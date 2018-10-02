package ingsfw.pdd.decorator;

import ingsw.pdd.decorator.impl.decorators.EncryptMessage;
import ingsw.pdd.decorator.impl.decorators.SOAPEnvelopMessage;
import ingsw.pdd.decorator.impl.decorators.XMLFormatterDecorate;
import ingsw.pdd.decorator.impl.message.CustomerMessage;
import ingsw.pdd.decorator.impl.message.IMessage;

public class DecoratorMain {

	public static void main(String[] args) {
	
		
		CustomerMessage customerMessage = new CustomerMessage(
				
				"Pedro Perez", "pedroperez123@gmail.com", "0375342756"); 
		System.out.println("Original Message ==> " + customerMessage);
		
		 IMessage message1 = new EncryptMessage("usuario", "HG58YZ3CR9123456",
				 new SOAPEnvelopMessage(  new XMLFormatterDecorate(customerMessage))).processMessage();
				System.out.println("message1 =====================================>\n"  + message1.getContent() + "\n\n");
			
				 IMessage message2 = new SOAPEnvelopMessage(new EncryptMessage("usuario", "HG58YZ3CR9123456", 
				 new XMLFormatterDecorate(customerMessage))).processMessage();
				
				System.out.println("message2 =====================================>\n" + message2.getContent());
		
		
	}

}
