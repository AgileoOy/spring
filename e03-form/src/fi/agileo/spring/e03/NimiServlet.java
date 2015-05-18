package fi.agileo.spring.e03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Tämä servlet ottaa vastaan lomakkeelle syötetyn nimen ja tulostaa sen selaimelle näytettävälle sivulle.
 */
@WebServlet("/nayta_syotetty_nimi")
public class NimiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NimiServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//requestin parametri "etunimi" java-muuttujaan
		String syotettyNimi = request.getParameter("etunimi");
		
		//tarvitaan kirjoituskone, jolla voidaan kirjoittaa tekstiä webbiselaimelle takaisin päin
		PrintWriter wout = response.getWriter();

		//palautetaan selaimelle sivu, jossa lukee syötetty nimi
		wout.println("<!DOCTYPE html>");
		wout.println("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"></head><body>");
		wout.println("<p>Tervehdys " +syotettyNimi +"!</p>");
		wout.println("<p><a href=\"lomake.jsp\">kokeile uudestaan</a></p>");
		wout.println("</body></html>");
		
	}

}
