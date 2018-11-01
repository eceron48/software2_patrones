package ingsw.pdd.chainofresponsability.validator;

import ingsw.pdd.chainofresponsability.domain.Telephone;
import ingsw.pdd.chainofresponsability.domain.order.AbstractOrder;

public class TelephoneValidator extends AsbtractOrderValidator{

	@Override
	public void validate(AbstractOrder order) throws ValidationException {
		Telephone tel = order.getContributor().getTelephone();
		 if(null == tel){
			 throw new ValidationException(
					 "El tel�fono del contribuyente es obligatorio");
		}else if(tel.getNumber().length()!= 7){
		 throw new ValidationException("N�mero de tel�fono inv�lido");
		 }else if(tel.getLada().length()!=3){
		 throw new ValidationException("Lada inv�lida");
		}
	 }
		
	}
	
	
	

