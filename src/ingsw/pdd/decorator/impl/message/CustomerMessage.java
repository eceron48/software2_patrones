package ingsw.pdd.decorator.impl.message;

public class CustomerMessage implements IMessage{
private String name;
private String email;
private String telephone;

public CustomerMessage (String name,String email,String telephone) {
	this.name=name;
	this.email=email;
	this.telephone=telephone;
	
}

@Override
public IMessage processMessage() {
	
	return this;
}

@Override
public String getContent() {
	
	return toString();
}

@Override
public void setContent(String content) {
	throw new UnsupportedOperationException("Not suported yet.");
	
}
//implementado diferente si fallo volver a principal//

@Override
	public String toString() {
	
		return "QueryCustomerMessage{" + "name=" + name + ", email="  + email + ", telephone=" + telephone + '}';
	}



public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getTelephone() {
	return telephone;
}

public void setTelephone(String telephone) {
	this.telephone = telephone;
}


}
