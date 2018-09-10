package ingsw.pdd.builder.dto;

import java.util.ArrayList;
import java.util.List;

import ingsw.pdd.builder.IBuilder;

public class Employee {
	
	private String 			nombre ;
	private String 			genero;
	private int    			edad;
	private Address 		direccion;
	private List<Phone>		telefonos;
	private List<Contact>	contactos;

	private Employee(String nombre, String genero, int edad, Address direccion, List<Phone> telefonos,
		List<Contact> contactos) {
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
		this.direccion = direccion;
		this.telefonos = telefonos;
		this.contactos = contactos;
	}

	
	public Employee(String nombre,int edad, String genero) {
		
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
	}
	
	public Employee() {
		
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Address getDireccion() {
		return direccion;
	}

	public void setDireccion(Address direccion) {
		this.direccion = direccion;
	}

	public List<Phone> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Phone> telefonos) {
		this.telefonos = telefonos;
	}

	public List<Contact> getContactos() {
		return contactos;
	}

	public void setContactos(List<Contact> contactos) {
		this.contactos = contactos;
	}

	public String toString() {
		return "Employee{"+ "nombre= "+nombre+" edad= "+ edad +" genero= "+genero+"\ndireccion= "+
	direccion+ "telefono=" +telefonos+" contactos= "+contactos+ '}';
				
	}
	
	
	
	
	public static class EmployeeBuilder implements IBuilder<Employee>{
		
		private String nombre;
		private int edad;
		
		private String genero; 
		private Address	direccion;
	
		private final List<Phone> telefonos = new ArrayList<>(); 
		private final List<Contact> contactos = new ArrayList<>();
		
		public EmployeeBuilder() {
			
			
		}
		
		

	
		
		
		
		
		public EmployeeBuilder setName(String nombre) {
			this.nombre=nombre;
			return this;
		}

		public EmployeeBuilder setEdad(int edad) {
			this.edad=edad;
			return this;
		}

		public EmployeeBuilder setGenero(String genero) {
			this.genero=genero;
			return this;
		}


		public EmployeeBuilder setDireccion(String  dir,  String ciudad,String pais, String cp) 
		{ direccion= new Address(dir, ciudad, pais, cp);
				
				return this;  }
		
		
		
				
				public EmployeeBuilder addPhones(String phoneNumber, String ext,
		
				String phoneType) {  telefonos.add(new Phone(phoneNumber, ext, phoneType));
				
				return this; }
			
			 public EmployeeBuilder addContacs(String name, String phoneNumber,
			
				String ext, String phoneType,String address, String city, String country, String cp) {
			contactos.add(new Contact(name, new Phone(phoneNumber, ext, phoneType)
			 ,new Address(address, city, country, cp)));
				
				return this;}
			 
			 public EmployeeBuilder addContacs(String name, String phoneNumber,
					
					 String ext, String phoneType) { contactos.add(new Contact(name, new Phone(phoneNumber, ext, phoneType)));

					 return this;  }

			


			@Override
			public Employee build() {
		
				return new Employee(nombre, genero, edad, direccion, telefonos, contactos);
			}
			 
			 
			
			 }
		
		
	
}
