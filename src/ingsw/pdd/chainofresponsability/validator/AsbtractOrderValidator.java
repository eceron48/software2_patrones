package ingsw.pdd.chainofresponsability.validator;

import java.util.ArrayList;
import java.util.List;

import ingsw.pdd.chainofresponsability.domain.order.AbstractOrder;

public abstract class AsbtractOrderValidator {

	protected List<AsbtractOrderValidator> validators = new ArrayList<>();

	public abstract void validate(AbstractOrder order) throws ValidationException;
	
	 public void addValidator(AsbtractOrderValidator validator){
	 validators.add(validator);
	 }
}
