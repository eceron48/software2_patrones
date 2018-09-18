package ingsw.pdd.adptermain;

import ingsw.pdd.adapter.impl.BankCreditRequest;
import ingsw.pdd.adapter.impl.BankCreditResponse;
import ingsw.pdd.adapter.impl.IBankAdapter;
import ingsw.pdd.adapter.impl.XBankCreditAdapter;
import ingsw.pdd.adapter.impl.YBankCreditAdapter;

public class AdapterMain {

	public static void main(String[] args) {
		//Request genérico para las dos API's
		
		BankCreditRequest request = new BankCreditRequest();  request.darCustomer("Pedro Perez");
		
		request.dartAmount(1600); 
		
		IBankAdapter xBank = new XBankCreditAdapter();
		BankCreditResponse xresponse = xBank.sendCreditRequest(request);
		
		System.out.println("xBank approved > " + xresponse.isApproved() + "\n"); 
		
		IBankAdapter yBank = new YBankCreditAdapter();  BankCreditResponse yresponse = yBank.sendCreditRequest(request);
		
		System.out.println("yBank approved > " + yresponse.isApproved() + "\n"); 
		
		if (xresponse.isApproved()) System.out.println("xBank aprobó su crédito, felicidades!");
		
		if (yresponse.isApproved()) System.out.println("yBank aprobó su crédito, felicidades!");
	
		if (!xresponse.isApproved() && !yresponse.isApproved()) System.out.println("lo sentimos su crédito no ha sido aprobado.");

	}

}
