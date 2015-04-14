package src.tp1Veto;


import src.tp1.interfaces.IAnimal;
import src.tp1.interfaces.IVeterinaryOffice;
import src.tp1Veto.object.Animal;
import src.tp1Veto.object.ProtectedSpecie;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



@SuppressWarnings("deprecation")
public class Client_2 {
	
	private Client_2() {
		
	}
	
	public static void main(String[] args) {
		String host = (args.length < 1) ? null : args[0];
		try {
			// TODO METTRE LE BON CHEMIN
			System.setProperty("java.security.policy", "/home/jimmy/workspace/NTIERS/VETO/Animal.policy");
			
			System.setSecurityManager(new RMISecurityManager());
						
			Registry registry = LocateRegistry.getRegistry(host);
						
			IVeterinaryOffice cabinet = (IVeterinaryOffice) registry.lookup("cabinet");
			
			System.out.println("Cabinet renu : " + cabinet.getName());
			
			//printVeterinary(cabinet);

			//IAnimal animal = new Animal("Camelia", "Falindir", "chat", new Specie("typeDeChat", 14));
			
			//cabinet.addAnimal(animal);

			IAnimal animal2 = new Animal("Samantha", "Falindir", "peroquet", new ProtectedSpecie("type de peroquet", 100));
			
			cabinet.addAnimal(animal2);
			
			//cabinet.searchAnimal("Samantha");
			
			printVeterinary(cabinet);
			
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
	
	public static void printVeterinary(IVeterinaryOffice cabinet) {
		try {
			System.out.println("\nIn the veterinary office");
			System.out.println(cabinet.listAnimal().size());
			for(IAnimal animal : cabinet.listAnimal()) {
				System.out.println(animal.information());
				System.out.println(animal.getName());
				System.out.println(animal.getFollowUpFile().getObservation());
				System.out.println("Info espèce animal : " + animal.getSpecie().getInformation());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
