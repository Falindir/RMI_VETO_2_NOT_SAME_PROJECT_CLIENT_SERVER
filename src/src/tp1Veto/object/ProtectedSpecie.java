package src.tp1Veto.object;

import java.rmi.RemoteException;

public class ProtectedSpecie extends Specie {

	private static final long serialVersionUID = 1L;


	public ProtectedSpecie(String name, int lifeTime) throws RemoteException {
		super(name, lifeTime);
	}

	@Override
	public String getInformation() throws RemoteException {
		return "Information sur : " + name + " est une espèce protégé";
	}
	
}
