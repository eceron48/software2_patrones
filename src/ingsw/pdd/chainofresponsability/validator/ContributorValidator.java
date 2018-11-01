package ingsw.pdd.chainofresponsability.validator;

import ingsw.pdd.chainofresponsability.domain.Contributor;
 import ingsw.pdd.chainofresponsability.domain.Status;
 import ingsw.pdd.chainofresponsability.domain.order.AbstractOrder;

public class ContributorValidator extends AsbtractOrderValidator{

	@Override
	public void validate(AbstractOrder order) throws ValidationException {
		for(AsbtractOrderValidator validator : validators){
			 validator.validate(order);
			}
			 Contributor contributor = order.getContributor();
			 if(Status.ACTIVO != contributor.getStatus()){
		throw new ValidationException("El contribuyente no está activo");
			 }
		
	}

	
}
