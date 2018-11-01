package ingsw.pdd.chainofresponsability.validator;

import ingsw.pdd.chainofresponsability.domain.order.AbstractOrder;
import ingsw.pdd.chainofresponsability.domain.order.SalesORder;

public class SalesOrderValidator extends AsbtractOrderValidator {

	@Override
	public void validate(AbstractOrder order) throws ValidationException {
		if (!(order instanceof SalesORder)) {
			throw new ValidationException("Se esperaba una orden de Venta");
		
	}
		for( AsbtractOrderValidator validator : validators){
			 validator.validate(order);
			 }

}
}