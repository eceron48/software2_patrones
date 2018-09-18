package ingsw.pdd.bridge;

import ingsw.pdd.bridge.encript.AESEncryptAlgorithm;
import ingsw.pdd.bridge.encript.DESEncryptAlgorithm;
import ingsw.pdd.bridge.encript.NoEncryptAlgorithm;
import ingsw.pdd.bridge.impl.DefaultMessageEncryptImpl;
import ingsw.pdd.bridge.impl.IMessageEncrypt;

public class BridgeMain {

	public static void main(String[] args) {
IMessageEncrypt aesImpl = new DefaultMessageEncryptImpl(  new AESEncryptAlgorithm());
		
IMessageEncrypt desImpl = new DefaultMessageEncryptImpl(  new DESEncryptAlgorithm());
		
IMessageEncrypt noImpl = new DefaultMessageEncryptImpl(  new NoEncryptAlgorithm());
	
 try {
final String message = "<Persona><Nombre>Pedro Perez</Nombre></Persona>";  String messageAES = aesImpl.encryptMessage(message, "HG58YZ3CR9123456");
		
		System.out.println("messageAES > " + messageAES + "\n"); 
		String messageDES = desImpl.encryptMessage(message, "XMzDdG4D03CKm2Ix");
		System.out.println("messageDES > " + messageDES + "\n");
		String messageNO = noImpl.encryptMessage(message, null);
		
		System.out.println("messageNO > " + messageNO + "\n");  } catch (Exception e) {
		
		e.printStackTrace(); }

	}
system.out;
}
