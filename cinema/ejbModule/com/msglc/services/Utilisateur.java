package com.msglc.services;

import javax.ejb.Remote;

@Remote
public interface Utilisateur {
     //Initialiser le bean compte bancaire utilisateur (authentification) 
     public void init(String name, String passwd) throws UserNotFoundException; 
     
     public String getName() throws UserNotFoundException; 
     
     public float solde() throws SoldeNegatifException,UserNotFoundException; 
     
     // Débiter le compte de l'utilisateur
     public void debite(float f) throws SoldeNegatifException,UserNotFoundException;
}
