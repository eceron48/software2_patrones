package ingsw.pdd.visitor.impl;

import ingsw.pdd.visitor.domain.Activitie;
import ingsw.pdd.visitor.domain.Employee;
import ingsw.pdd.visitor.domain.Project;

public class PriceProjectVisitor implements  IVisitor<Number> {
	private double totalPrice;

	@Override
	public void project(Project project) {
		for(Activitie act : project.getActivities()){
			 act.accept(this);
			 }
		
	}

	@Override
	public void activitie(Activitie activitie) {
		totalPrice += activitie.getPrice();
		 for(Activitie act : activitie.getActivities()){
		 act.accept(this);
		
	}
	}	 

	@Override
	public void employee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Number getResult() {
		
		return  totalPrice;
	}

}
