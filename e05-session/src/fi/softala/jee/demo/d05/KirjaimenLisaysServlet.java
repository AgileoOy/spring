package fi.softala.jee.demo.d05;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SessioNappisServlet
 */
@WebServlet("/lisaa_kirjain")
public class KirjaimenLisaysServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KirjaimenLisaysServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//otetaan paikalliseen java-muuttujaan lähetetty kirjain
		String kirjain = request.getParameter("k");
		
		//katsotaan sessiosta, mikä teksti siellä on ennestään
		String teksti = (String)request.getSession().getAttribute("kokoteksti");
		
		//jos sessiosta ei löytynyt vielä tekstiä, alustetaan uusi String-olio
		if (teksti == null) {
			teksti = "";
		}
		
		//lisätään klikattu kirjain tekstiin
		teksti += kirjain;
		
		//tallennetaan uusi teksti takaisin sessioon
		request.getSession().setAttribute("kokoteksti", teksti);
		
		//ohjataan jsp-sivulle, joka saa hoitaa muotoilun
		request.getRequestDispatcher("kirjoituskone.jsp").forward(request, response);
		
	}


}
