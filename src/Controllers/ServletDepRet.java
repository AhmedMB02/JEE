package Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CompteDaoInterface;
import DAO.DAOCompte;

/**
 * Servlet implementation class ServletDepRet
 */
@WebServlet("/ServletDepRet")
public class ServletDepRet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDepRet() {
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
		int numc = Integer.parseInt(request.getParameter("numc"));
		int op = Integer.parseInt(request.getParameter("r"));
		double mont = Double.parseDouble(request.getParameter("montant"));
		CompteDaoInterface dao = new DAOCompte();
		PrintWriter out = response.getWriter();
		out.println("Compte operation "+numc+" op : "+op+" ,montant : "+mont);
		
		if(op==0)
			dao.DesposerRetirer(-mont, numc);
		else
			dao.DesposerRetirer(mont, numc);
	}

}
