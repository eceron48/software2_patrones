package ingsw.pdd.visitor.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ingsw.pdd.visitor.domain.Activitie;
import ingsw.pdd.visitor.domain.Employee;
import ingsw.pdd.visitor.domain.EmployeePay;
import ingsw.pdd.visitor.domain.Project;

public class  PaymentProjectVisitor implements IVisitor<List<EmployeePay>> {

	@Override
	public void project(Project project) {
		for (Activitie act : project.getActivities()) {
			act.accept(this);
			 }

		
	}

	@Override
	public void activitie(Activitie activitie) {
		activitie.getResponsible().accept(this);
		 for (Activitie act : activitie.getActivities()) {
		 act.accept(this);
		 }
		
	}

	@Override
	public void employee(Employee employee) {
		String resp = employee.getName();
		 if (employeePayment.containsKey(resp)) {
		 employeePayment.put(resp,
		 employeePayment.get(resp).doubleValue()
		 + employee.getPrice());
		 } else {
		 employeePayment.put(resp, employee.getPrice());
		 }
		
	}

	@Override
	public List<EmployeePay> getResult() {
		List<EmployeePay> response = new ArrayList<>();
		
		 Set<String> keys = employeePayment.keySet();
		 for (String key : keys) {
		 response.add(new EmployeePay(key,
		 employeePayment.get(key).doubleValue()));
		 }
		
		 return response;
	}

}
