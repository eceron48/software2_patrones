package ingsw.pdd.facade.subsystems.bank;

import java.util.UUID;
import ingsw.pdd.facade.impl.GeneralPaymentError;
import ingsw.pdd.facade.util.OnMemoryDataBase;

public class BankSystem  {
	
	public String transfer(TransferRequest request) throws GeneralPaymentError{
		String cardNumerPrefix = request.getCardNumber().substring(0, 3);
		if (!OnMemoryDataBase.validateCardBins(cardNumerPrefix)) {
			throw new GeneralPaymentError("Tarjeta inv�lida.");
		}
		
		String cardCompany = OnMemoryDataBase.getCardCompany(cardNumerPrefix);
		if ("AMEX".equals(cardCompany) && request.getCardNumber().length() != 15) {
			throw new GeneralPaymentError("El n�mero de la tarjeta es inv�lido");
		} else if (("VISA".equals(cardCompany) || "MASTERCARD".equals(cardCompany))
				&& request.getCardNumber().length() != 16) {
			throw new GeneralPaymentError("El n�mero de la tarjeta es inv�lido");
		}
		
		String number = request.getCardNumber();
		String cardNumerSubfix = number.substring(number.length()-4, number.length());
		System.out.println("Se ha realizado un cargo al cliente '"
				+ request.getCardName() + "' \n"
				+ "\tpor el monto de '" + request.getAmmount() + "' a la tarjeta "
				+ "terminaci�n '"+cardNumerSubfix+"'.\n");
		
		return UUID.randomUUID().toString();			

	}

}
