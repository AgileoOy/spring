package fi.softala.jee.demo.d04.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.softala.jee.demo.d04.bean.Henkilo;

/**
 * Servlet implementation class NimiForwarderServlet
 */
@WebServlet("/nayta_syotetty_nimi")
public class NimiForwarderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NimiForwarderServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//paketoidaan requestin parametrit yhteen olioon
		String enimi = request.getParameter("etunimi");
		String snimi = request.getParameter("sukunimi");
		Henkilo henk = new Henkilo(enimi, snimi);
		
		//tallennetaan luotu olio requestin atribuutiksi
		request.setAttribute("henkilo", henk);
		
		//ohjataan pyyntö jsp-sivulle, joka hoitaa tulostuksen muotoilun
		request.getRequestDispatcher("nayta_henkilo.jsp").forward(request, response);
	}

}
