package fi.agileo.spring.e07.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.agileo.spring.e07.bean.Henkilo;
import fi.agileo.spring.e07.dao.HenkiloDAO;


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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//tietokannasta henkilöt
		HenkiloDAO hDao = new HenkiloDAO();
		List<Henkilo> henkilot = hDao.haeKaikki();
		
		//requestiin talteen
		request.setAttribute("henkilot", henkilot);
		
		//jsp hoitaa muotoilun
		request.getRequestDispatcher("henkilot.jsp").forward(request, response);
		
	}

}
