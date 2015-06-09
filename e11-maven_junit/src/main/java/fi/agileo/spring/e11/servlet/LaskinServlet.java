package fi.agileo.spring.e11.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.agileo.spring.e11.laskin.Laskin;

/**
 * Servlet implementation class LaskinServlet
 */
@WebServlet("/laskin")
public class LaskinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LaskinServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// LOMAKKEESEEN SYÖTETYT LUVUT
		int eka = getIntParameter("luku1", request);
		int toka = getIntParameter("luku2", request);

		// LASKETAAN SUMMA LASKIMELLA
		Laskin laskin = new Laskin();
		int tulos = 0;
		String operaatio = request.getParameter("operaatio");
		if (operaatio != null && operaatio.equals("summa")) {
			tulos = laskin.summaa(eka, toka);
		} else if (operaatio != null && operaatio.equals("kerto")) {
			tulos = laskin.kertolasku(eka, toka);
		} else {
			tulos = 0;
		}

		// FORWARDOIDAAN JSP:LLE (MUOTOILU)
		request.setAttribute("tulos", tulos);
		request.getRequestDispatcher("WEB-INF/jsp/laskin.jsp").forward(request,
				response);

	}

	private int getIntParameter(String paramNimi, HttpServletRequest request) {
		int iArvo = 0;
		String sArvo = request.getParameter(paramNimi);
		if (sArvo != null) {
			try {
				iArvo = Integer.parseInt(sArvo);
			} catch (NumberFormatException e) {
				System.out.println(sArvo +" ei ole kunnollinen kokonaisluku.");
			}
		}
		return iArvo;
	}

}
