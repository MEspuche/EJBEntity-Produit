package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Produit;
import session.ProduitRemote;

/**
 * Servlet implementation class ModifierServlet
 */
@WebServlet("/ModifierServlet")
public class ModifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ProduitRemote produitlocal;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierServlet() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Produit p = produitlocal.getProduit(id);
		request.setAttribute("produit",	p);
		request.getRequestDispatcher("/modifier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		double prix = Double.parseDouble(request.getParameter("prix"));
		Produit p = new Produit();
		p.setId(id);
		p.setNom(nom);
		p.setPrix(prix);
		p.setQuantite(quantite);
		produitlocal.modifierProduit(p);
		request.getRequestDispatcher("ListerServlet").forward(request, response);
	}

}
