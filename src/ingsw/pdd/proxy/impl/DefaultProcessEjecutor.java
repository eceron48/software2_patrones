package ingsw.pdd.proxy.impl;

public class DefaultProcessEjecutor {	
	
	public void ejecuteProcess(int idProcess,String user,String password)
			throws Exception {
		
		System.out.println("procesos " + idProcess + " en ejecución");
		System.out.println("procesos " + idProcess + " terminado");
	}

}
