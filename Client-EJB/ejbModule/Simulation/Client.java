package Simulation;


import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import ejbModule.com.msglc.model.Compte;
import ejbModule.com.msglc.model.Film;
import ejbModule.com.msglc.model.SalleProg;
import ejbModule.com.msglc.model.Seance;
import ejbModule.com.msglc.services.Cinema;
import ejbModule.com.msglc.services.Utilisateur;

public class client {
	@SuppressWarnings("unused")
	
	public static void main(String[] args) {
		String appName=""; 
		String moduleName="cinema"; 
		String distinctName="cinema"; 
		String viewClassName=Utilisateur.class.getName()+"?stateful";
		String viewClassName2=Cinema.class.getName();
		
	    Context context1 = new InitialContext();
	    Context context2 = new InitialContext();
		
	    String ejbRemoteJNDIName="ejb:"+appName+"/"+moduleName+"/"+distinctName+"!"+viewClassName; 
	    String ejbRemoteJNDIName2="ejb:"+appName+"/"+moduleName+"/"+distinctName+"!"+viewClassName2; 

	    System.out.println(ejbRemoteJNDIName);
	    System.out.println(ejbRemoteJNDIName2);
	     
        Utilisateur utlstr=(Utilisateur) context1.lookup(ejbRemoteJNDIName);
        Cinema cnm=(Cinema) context2.lookup(ejbRemoteJNDIName2);

        System.out.println("stub= "+utlstr); 
        System.out.println("cnb= "+cnm); 
        if(utlstr.init("user", "mohamed")){
	        System.out.print("Le nom du client : "+utlstr.getName()+"\n");
	        System.out.print("le Solde du client  =  "+utlstr.solde()+"\n");


	        int d= 10;
	        utlstr.debite(d);
	        System.out.print("On debite du compte la somme suivante "+d+"\n");
	        System.out.print("Solde Restant =  "+utlstr.solde());
	    }
    }


}
