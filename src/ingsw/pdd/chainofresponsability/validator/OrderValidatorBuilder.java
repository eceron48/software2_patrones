package ingsw.pdd.chainofresponsability.validator;

public class OrderValidatorBuilder {
	public static final AsbtractOrderValidator  buildSalesOrderValidator(){
		AsbtractOrderValidator  validator = new SalesOrderValidator();
	 validator.addValidator(buildCustomerValidator());
	 validator.addValidator(new OrderItemValidator());
		 validator.addValidator(new CreditValidator());
	 return validator;
		 }
		
		 private static AsbtractOrderValidator  buildCustomerValidator(){
			 AsbtractOrderValidator  validator = new CustomerValidator();
		 validator.addValidator(buildContributorValidator());
		 return validator;
		 }
		
		 private static AsbtractOrderValidator  buildContributorValidator(){
			 AsbtractOrderValidator  validator = new ContributorValidator();
		 validator.addValidator(new AddressValidator());
		 validator.addValidator(new TelephoneValidator());
		 return validator;
		
		}
}
