package ingsw.pdd.builder;

import ingsw.pdd.builder.dto.Employee;
import ingsw.pdd.builder.dto.Employee.EmployeeBuilder;

public class BuilderMain {

	public static void main(String[] args) {
		

			
	Employee emp = new Employee.EmployeeBuilder().setName("Juan Jaime Perez Paez")
			.setGenero("Male").setEdad(29)
			
			.setDireccion("742 de Evergreen Terrace "  + "Barrio alto", "Bogot� D.C.", "Colombia", "03400")
			
			.addContacs("Carlos Castillo", "1122334455", "123", "Casa",  " Calle 26 No. 87 - 12 ", "Medell�n"
		
			, "Colombia", "10023") .addContacs("Mario Moyano", "3344556677", "Celular", null, null, null, null, null)
			
			.addPhones("0314590234 ", null, "Celular")
			.addPhones("0314590234", null, "casa").build();
			System.out.println(emp);

	}

}
