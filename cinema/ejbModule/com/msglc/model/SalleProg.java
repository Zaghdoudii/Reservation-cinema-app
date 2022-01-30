package com.msglc.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.jd.gui.view.component.List;

//Entity esclave
@Entity
@Table(name="SalleP")
public class SalleProg<String> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id_salleprog;

	@ManyToOne
	@JoinColumn(name="id_film")
    private Film film;
	
	@OneToMany(mappedBy="salleProg")
	private List<Seance> seance ;
	
	public SalleProg() {
		
	}
	public SalleProg(int id_salleprog) {
		super();
		this.id_salleprog = id_salleprog;
	}
	
	@OneToOne(mappedBy="SalleP")
	public int getId_salleprog() {
		return id_salleprog;
	}

	public void setId_salleprog(int id_salleprog) {
		this.id_salleprog = id_salleprog;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_salleprog;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalleProg other = (SalleProg) obj;
		if (id_salleprog != other.id_salleprog)
			return false;
		return true;
	}
    
	
	
	@Override
	public String toString() {
		return "SalleProg [id_salleprog=" + id_salleprog + "]";
	}
	
	
	public Salle getSalle() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
