package com.msglc.services;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.msglc.model.Compte;



@Stateful public class UtilisateurBean implements Utilisateur {
    @PersistenceContext
    private EntityManager em = null;
    private int user_id;
    
    public UtilisateurBean() {
        super();
    }
    
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public void debite(float somme) throws SoldeNegatifException,UserNotFoundException{
    float solde;
    solde = solde();
    if( solde+somme <= 0 ){
         throw new SoldeNegatifException();
    }else{
         Compte compte;
         Query q = em.createNamedQuery("findCompteById");
         q.setParameter("cid",user_id);
		List<Compte> res = (List<Compte>)(q.getResultList());
         if(res.size()==0){
	         throw new UserNotFoundException();
        }else{
	          compte = res.get(0);
	          compte.setSolde(solde+somme);
	          em.merge(compte);
	    }
	} 
}

	public String getName() throws UserNotFoundException{
	     String nom;
	     Query q = em.createNamedQuery("findCompteById");
	     q.setParameter("cid",user_id);
	     List<Compte> res = (List<Compte>)(q.getResultList());
	     if(res.size()==0){
            	throw new UserNotFoundException();
	     }else{
	            nom = res.get(0).getName();
	     }
	      return nom;
	}
	
	
	public void init(String name, String passwd) throws UserNotFoundException {
	    Query q = em.createNamedQuery("findCompteByName");
	    q.setParameter("cname",name);
	    @SuppressWarnings("unchecked")
		List<Compte> res = (List<Compte>)q.getResultList();
	    if (res==null || res.size()==0) {
	        throw new UserNotFoundException();
	    }else{
	        if (res.get(0).getName().equals(name) && res.get(0).getPassword().equals(passwd)){
	            user_id = res.get(0).getId();
	        }else {
	            throw new UserNotFoundException();
	        }
	}
	}
	
	
	
	public float solde() throws UserNotFoundException{
	    float sld;
	    Query q = em.createNamedQuery("findCompteById");
	    q.setParameter("cid",user_id);
	    List<Compte> res = (List<Compte>)(q.getResultList());
	    if(res.size()==0)
	        throw new UserNotFoundException();
	    else
        	sld = res.get(0).getSolde();
    	return sld;
	}
}
	

