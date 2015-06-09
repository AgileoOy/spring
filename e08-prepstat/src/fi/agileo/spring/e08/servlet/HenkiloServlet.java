package fi.agileo.spring.e08.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.agileo.spring.e08.bean.Henkilo;
import fi.agileo.spring.e08.dao.DAOPoikkeus;
import fi.agileo.spring.e08.dao.HenkiloDAO;


/**
 * Servlet implementation class HenkiloServlet
 */
@WebServlet("/henkilot")
public class HenkiloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HenkiloServlet() {
        super();
    }

    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String enimi = request.getParameter("etunimi");
		String snimi = request.getParameter("sukunimi");
		
		Henkilo h = new Henkilo(enimi, snimi);

		try {
			HenkiloDAO hDao = new HenkiloDAO();
			hDao.lisaa(h);
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		
		response.sendRedirect("henkilot"); //redirect doGet
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Henkilo> henkilot;
		
		try {
			//tietokannasta henkilöt
			HenkiloDAO hDao = new HenkiloDAO();
			henkilot = hDao.haeKaikki();
		} catch(DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		//requestiin talteen
		request.setAttribute("henkilot", henkilot);
		
		//jsp hoitaa muotoilun
		request.getRequestDispatcher("henkilot.jsp").forward(request, response);
		
	}

}
