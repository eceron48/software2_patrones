package ingsw.pdd.facade.impl;

import java.util.HashMap;
import ingsw.pdd.facade.subsystems.bank.*;
import ingsw.pdd.facade.subsystems.biller.*;
import ingsw.pdd.facade.subsystems.crm.CRMSystem;
import ingsw.pdd.facade.subsystems.email.EmailSystem;
import ingsw.pdd.facade.util.*;

public class OnlinePaymentFacadeImpl implements IPaymentFacade {
	
	private static final CRMSystem crmSystem = new CRMSystem();
	private static final BillingSystem billingSyste = new BillingSystem();
	private static final BankSystem bankSyste = new BankSystem();
	private static final EmailSystem emailSenderSystem = new EmailSystem();
	
	@Override
	public PaymentResponse pay(PaymentRequest request)
			throws GeneralPaymentError {
		Customer customer = crmSystem.findCustomer(request.getCustomerId());
		//Validate set
		if(customer==null){
			throw new GeneralPaymentError("El cliente con id '" +request.getCustomerId()+"' no existe.");
		}else if("Baja".equals(customer.getStatus())){
			throw new GeneralPaymentError("El cliente con id '"+request.getCustomerId()+"' est� dado de baja.");
		}else if(request.getAmmount() >
			billingSyste.queryCustomerBalance(customer.getId())){
			throw new GeneralPaymentError("Se est� intentado realizar un pago " + "\n\tmayor al saldo del cliente");
		}
		
		//Pago bancario. Se realiza el cargo a la tarjeta
		TransferRequest transfer = new TransferRequest(
				request.getAmmount(),request.getCardNumber(),
				request.getCardName(), request.getCardExpDate(),
				request.getCardNumber());
		String payReference = bankSyste.transfer(transfer);
		
		//Afectaci�n del saldo en el sistema de facturaci�n
		BillingPayRequest billingRequest = new BillingPayRequest(
				request.getCustomerId(), request.getAmmount());
		double newBalance = billingSyste.pay(billingRequest);
		
		//El cliente se reactiva si el nuevo saldo es menor de 51$
		
		String newStatus = customer.getStatus();
		if(newBalance<=50){
			OnMemoryDataBase.changeCustomerStatus(request.getCustomerId(), "Activo");
			newStatus = "Activo";
		}
		
		//Env�o de la confirmaci�n de pago por Email
		HashMap<String,String> params = new HashMap<>();
		params.put("$name", customer.getName());
		params.put("$ammount", request.getAmmount()+"");
		params.put("$newBalance", newBalance+"");
		String number = request.getCardNumber();
		String subfix = number.substring(number.length()-4, number.length());
		params.put("$cardNumber", subfix);
		params.put("$reference", payReference);
		params.put("$newStatus", newStatus);
		emailSenderSystem.sendEmail(params);
		
		return new PaymentResponse(payReference, newBalance, newStatus);				

	}

}
