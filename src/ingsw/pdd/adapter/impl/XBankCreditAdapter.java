package ingsw.pdd.adapter.impl;

import ingsw.pdd.adapter.creditapi.bankx.XBankCreditAPI;
import ingsw.pdd.adapter.creditapi.bankx.XBankCreditRequest;
import ingsw.pdd.adapter.creditapi.bankx.XBankCreditResponse;

public class XBankCreditAdapter implements IBankAdapter {

	@Override
	public BankCreditResponse sendCreditRequest(BankCreditRequest request) {
		XBankCreditRequest xrequest = new XBankCreditRequest();
		xrequest.setCustomerName(request.leerCustomer());
		xrequest.setRequestAmount(request.leerAmount());
		XBankCreditAPI api = new XBankCreditAPI();
		XBankCreditResponse xresponse = api.sendCreditRequest(xrequest);
		
		BankCreditResponse response = new BankCreditResponse();
		response.setApproved(xresponse.isAproval());
		return response;
	}

}
