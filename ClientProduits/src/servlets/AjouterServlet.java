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
 * Servlet implementation class AjouterServlet
 */
@WebServlet("/AjouterServlet")
public class AjouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private ProduitRemote produitlocal;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		double prix = Double.parseDouble(request.getParameter("prix"));
		Produit p = new Produit();
		p.setNom(nom);
		p.setPrix(prix);
		p.setQuantite(quantite);
		int idp = produitlocal.ajouterProduit(p);
		p.setId(idp);
		request.getRequestDispatcher("ListerServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
