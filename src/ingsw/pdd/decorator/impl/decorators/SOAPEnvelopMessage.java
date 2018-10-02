package ingsw.pdd.decorator.impl.decorators;

import ingsw.pdd.decorator.impl.message.IMessage;

public class SOAPEnvelopMessage extends MessageDecorator {
	

	public SOAPEnvelopMessage(IMessage message) {
		 super(message);
		 }
		
		@Override
		 public IMessage processMessage() {
		 message.processMessage();
		
		message = envelopMessage();  return message;
		
		}
		
		
		private IMessage envelopMessage() {  String soap = "<soapenv:Envelope xmlns:soapenv="
	
		+ "\"http://schemas.xmlsoap.org/soap/envelope/\" "  + 
		"xmlns:ser=\"http://service.dishweb.cl.com/\">\n" +
		"<soapenv:Header/>\n"  + 
		" <soapenv:Body>\n"
		+ message.getContent() 
		+ "\n"
		+ 
		"</soapenv:Body>\n" 
		+
		"</soapenv:Envelope>";
		
		message.setContent(soap);  
		return message;
		
		}
}
