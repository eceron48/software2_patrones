package ingsw.pdd.chainofresponsability.validator;

import ingsw.pdd.chainofresponsability.domain.CreditData;
import ingsw.pdd.chainofresponsability.domain.order.AbstractOrder;

public class CreditValidator extends AsbtractOrderValidator {

	@Override
	public void validate(AbstractOrder order) throws ValidationException {
		double total = order.getTotal();
		 CreditData creditData = order.getContributor().getCreditData();
		 double newBalance = creditData.getBalance() + total;
		 if(newBalance > creditData.getCreditLimit()){
		 throw new ValidationException("El monto de la orden excede el "
		 + "l�mite de cr�dito disponible");
		 }
		
	}
	

}
