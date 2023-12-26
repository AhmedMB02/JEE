package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CompteDaoInterface;
import DAO.DAOCompte;
import Models.Compte;

/**
 * Servlet implementation class ConsulterCompte
 */
@WebServlet("/ConsulterCompte")
public class ConsulterCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsulterCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CompteDaoInterface dao = new DAOCompte();
		Compte c = new Compte();
		int n = Integer.parseInt(request.getParameter("numero"));
		
		try {
			c=dao.consulterCompte(n);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("BeanC", c);
		request.getRequestDispatcher("AfficheCompte.jsp").forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		// en cas d'affiche avec PrintWriter
		/*
		PrintWriter out = response.getWriter();
		out.println("<h3> Information sur le compte </h3>");
		out.println("<h5> Numero : </h5>"+c.getNumcpt());
		out.println("<h5> Type Compte : </h5>"+c.getTypcpt());
		out.println("<h5> Proprietaire : </h5>"+c.getProprietaire());
		out.println("<h5> Solde : </h5>"+c.getSolde());
		*/
	}

}
