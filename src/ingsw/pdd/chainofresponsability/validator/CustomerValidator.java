package ingsw.pdd.chainofresponsability.validator;

import ingsw.pdd.chainofresponsability.domain.Customer;
import ingsw.pdd.chainofresponsability.domain.order.AbstractOrder;

public class CustomerValidator extends AsbtractOrderValidator {

	@Override
	public void validate(AbstractOrder order) throws ValidationException {
		for(AsbtractOrderValidator validator : validators){
			 validator.validate(order);
			 }
			
			 if(!(order.getContributor() instanceof Customer)){
			 throw new ValidationException("El contribuyente no es un cliente");
			 }
			}
		
	}
	


