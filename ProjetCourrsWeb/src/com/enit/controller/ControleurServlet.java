package com.enit.controller;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msglc.model.Compte;
import com.msglc.model.Film;
import com.msglc.model.Salle;
import com.msglc.model.SalleProg;
import com.msglc.model.Seance;
import com.msglc.services.Cinema;
import com.msglc.services.Utilisateur;

@WebServlet(name="cs",urlPatterns={"/controleur"})
public class ControleurServlet extends HttpServlet{
	ServletContext context ;
	@EJB private Cinema cinema;
//	@EJB private Utilisateur utilisateur;
	
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{ 
		context= request.getSession().getServletContext();
	
	    List<Film> listeFilm =	cinema.list();

	    context.setAttribute("listeCours", listeCours);
        context.getRequestDispatcher("/listeFilm.jsp").forward(request, response);
	} 
	
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{ 
		context= request.getSession().getServletContext();
	
		List<Film> listeFilm =	cinema.list()
        String action=request.getParameter("action"); 
		 
		if(action.equals("ajouter"))
		{ 
			Integer idFilm= Integer.parseInt(request.getParameter("idF"));
			String nomFilm= request.getParameter("nomF");
			Integer duree=request.getParameter("dureeF");
			String realisateur=request.getParameter("realF");
				 
				
			Film nvFilm= new Film(idFilm,nomFilm,duree, realisateur);
			listeFilm.setFilm(nvFilm);
				
				
			request.setAttribute("beanFilm", listeFilm);
			

			context.setAttribute("listeFilm", listeFilm);
		} 
			

           context.getRequestDispatcher("/listeFilm.jsp").forward(request, response);
	} 
	}
