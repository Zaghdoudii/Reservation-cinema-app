package com.msglc.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.msglc.model.Compte;
import com.msglc.model.Film;
import com.msglc.model.SalleProg;
import com.msglc.model.Seance;

public class CinemaBean implements Cinema {

	@PersistenceContext 
	private EntityManager em = null ;

	public CinemaBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<Film> list() {
		Query req=em.createQuery("select c from Film c");
		List<Film> reqlist=(List<Film>)req.getResultList();
		Set<Film> reqset= (Set<Film>) reqlist.stream().collect(Collectors.toSet());
		return reqset;
	}

	@Override
	public Set<Film> findByPattern (String pattern){

		Query q = em.createNamedQuery("findFilmByPattern");
		q.setParameter("nom",pattern);
		List<Film> res = (List<Film>)q.getResultList();
		Set<Film> reqset= (Set<Film>) res.stream().collect(Collectors.toSet());
		return reqset;
	}

	@Override
	public Film findFilm(int id) {
		Film fl=em.find(Film.class, id);
	    return fl;
	}

	@Override
	public void reserve(Seance seance, Utilisateur u) throws PlusDePlaceException, UserNotFoundException, SoldeNegatifException, SoldeInsuffisantException {
		int p = seance.getPlaces();
		int ca = ((Seance) seance.getSalleProg().getSalle()).getPlaces();
		if( u.solde() < seance.getTarif() ) {
			throw new SoldeInsuffisantException();
		}
		else {
			if (ca<p) {
				throw new PlusDePlaceException();
			}
			else {
				String nom = u.getName();
				Compte c = new Compte(nom);
				u.init(nom, c.getPassword());
				u.debite(seance.getTarif());
				p++;
			}
		}
		
	}

	@Override
	public Set<SalleProg> getAllSalleProg() {
		Query req=em.createQuery("select c from SalleProg c");
		List<SalleProg> reqlist=(List<SalleProg>)req.getResultList();
		Set<SalleProg> reqset= (Set<SalleProg>) reqlist.stream().collect(Collectors.toSet());
		return reqset;
	}

	@Override
	public Film createFilm(String name) {
		Film F= new Film(name);
		return F;
		
	}

	@Override
	public void update(Film f) {
		em.merge(f);
	}

	@Override
	public float getTarif() {
		Seance i = new Seance();
		return i.getTarif();

	}


}

