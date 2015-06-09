package fi.agileo.spring.e11.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.agileo.spring.e11.kello.Kello;
import fi.agileo.spring.e11.kello.SuomiKello;
import fi.agileo.spring.e11.kello.SysteemiKelloLahde;

/**
 * Servlet implementation class KelloServlet
 */
@WebServlet("/kello")
public class KelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public KelloServlet() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Kello kello = new SuomiKello(new SysteemiKelloLahde());

		
		request.setAttribute("pvm", kello.getPvm());
		request.setAttribute("aika", kello.getAika());
		request.getRequestDispatcher("WEB-INF/jsp/kello.jsp").forward(request, response);
	}

}
