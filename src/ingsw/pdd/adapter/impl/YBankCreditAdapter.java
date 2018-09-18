package ingsw.pdd.adapter.impl;

import ingsw.pdd.adpter.creditapi.banky.YBankCreditApprove;
import ingsw.pdd.adpter.creditapi.banky.YBankCreditApproveResult;
import ingsw.pdd.adpter.creditapi.banky.YBankCreditSender;
import ingsw.pdd.adpter.creditapi.banky.YBankCreditSenderListener;

public class YBankCreditAdapter implements IBankAdapter,YBankCreditSenderListener {

	private YBankCreditApproveResult yresponse;

	
		
	

	@Override
	public BankCreditResponse sendCreditRequest(BankCreditRequest request) {
		YBankCreditApprove yrequest = new YBankCreditApprove();
		yrequest.setCredit((float) request.leerAmount());
		yrequest.setName(request.leerCustomer());
		
		YBankCreditSender sender = new YBankCreditSender();
		sender.sendCreditForValidate(yrequest, this);
		
		do {
			try {
				Thread.sleep(10000);
				System.out.println("YBank petición en espera...");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}while(yresponse==null);
		BankCreditResponse response = new BankCreditResponse();
		response.setApproved(yresponse.getApprove() == "Y" ? true : false);
		return response;
	
	
	}
	@Override
	public void notifyCreditResult(YBankCreditApproveResult result) {
		this.yresponse=result;
}
}
