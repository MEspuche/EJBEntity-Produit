package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Produit;
import session.ProduitRemote;

/**
 * Servlet implementation class ListerServlet
 */
@WebServlet("/ListerServlet")
public class ListerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ProduitRemote produitlocal;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Produit> listProduits = new ArrayList<Produit>();
		listProduits = produitlocal.findAllProduits();
		request.setAttribute("produits", listProduits);
		request.getRequestDispatcher("/lister.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
