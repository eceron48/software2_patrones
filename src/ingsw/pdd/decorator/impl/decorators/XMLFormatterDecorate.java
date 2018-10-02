package ingsw.pdd.decorator.impl.decorators;

import java.io.ByteArrayOutputStream;


import javax.xml.namespace.QName;
import javax.xml.*;
import javax.xml.bind.JAXBContextFactory;

import ingsw.pdd.decorator.impl.message.IMessage;
import ingsw.pdd.decorator.impl.message.TextMessage;

public class XMLFormatterDecorate extends MessageDecorator {


	public XMLFormatterDecorate(IMessage message) {
		 super(message);
		 }
		
	@Override

	public IMessage processMessage()
	{  message = message.processMessage();

	message = xmlMessage(); 
	return message;
	
	} 
	
	private IMessage xmlMessage() 
	{  try {

	JAXBContextFactory jc = JAXBContext.newInstance(message.getClass()); 
	@SuppressWarnings("unchecked")
	JAXBElement<IMessage> je2 = new JAXBElement<IMessage>(  new QName(message.getClass().getName()), (Class<IMessage>) message.getClass(), message);
	
	Marshaller marshaller = jc.createMarshaller();  marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	
	ByteArrayOutputStream output = new ByteArrayOutputStream();
	marshaller.marshal(je2, output);

	return new TextMessage(new String(output.toByteArray()));
	} catch (Exception e) {

	e.printStackTrace(); throw new RuntimeException("Error al convertir el XML");
	
	}  }

}
