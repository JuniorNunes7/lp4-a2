package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Geladeira; 
import db.Conexao;

/**
 * Servlet implementation class geladeira
 */
@WebServlet("/geladeira")
public class geladeira extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public geladeira() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Conexao con = new Conexao();
			ArrayList<Geladeira> result = con.getAll();
			request.setAttribute("geladeiras", result);

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher view = request.getRequestDispatcher("show.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modelo = request.getParameter("modelo");
		Integer volume = Integer.parseInt(request.getParameter("volume"));
		Integer numero_portas = Integer.parseInt(request.getParameter("numPortas"));
		Boolean faz_gelo = Boolean.parseBoolean(request.getParameter("fazGelo"));
		
		Geladeira geladeira = new Geladeira(modelo, volume,numero_portas, faz_gelo);
		
		try {
			Conexao con = new Conexao();
			con.insert(geladeira);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		 doGet(request, response);
	}

}
