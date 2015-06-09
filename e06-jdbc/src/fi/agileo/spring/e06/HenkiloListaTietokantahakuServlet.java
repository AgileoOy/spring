package fi.agileo.spring.e06;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HenkiloListaTietokantahakuServlet
 */
@WebServlet("/henkilolista")
public class HenkiloListaTietokantahakuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HenkiloListaTietokantahakuServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//kirjoituskone käyttöön, jotta voidaan kirjoittaa responseen
		PrintWriter wout = response.getWriter();
		
		//tulostetaan sivun alkuun tarvittavat html-tagit
		wout.println("<!DOCTYPE html>");
		wout.println("<html>");
		wout.println("<body>");
		
		
		//TIETOKANTAHAKU
		
		String username = "agileo";
		String password = "deitabeispasv00rdi";
		String url = "jdbc:mariadb://localhost/springcoursedb";

		Connection yhteys = null;
		
		try {
			//YHTEYDEN AVAUS JA HAKU
			//ajurin lataus
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			//avataan yhteys
			yhteys = DriverManager.getConnection(url, username, password);
			
			//suoritetaan haku
			String sql = "select id, etunimi, sukunimi from henkilo";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			//käydään hakutulokset läpi
			while(tulokset.next()) {
				int id = tulokset.getInt("id");
				String etunimi = tulokset.getString("etunimi");
				String sukunimi = tulokset.getString("sukunimi");
				
				//tulostetaan yksittäinen hakutulos responseen
				wout.println(id + ". " + etunimi +" " +sukunimi +"<br/>");
			}
			
		} catch(Exception e) {
			//JOTAIN VIRHETTÄ TAPAHTUI
			e.printStackTrace();
			wout.println("<p style=\"color:red\">Tietokantahaku aiheutti virheen</p>");
		} finally {
			//LOPULTA AINA SULJETAAN YHTEYS
			try {
				if (yhteys != null && !yhteys.isClosed())
					yhteys.close();
			} catch(Exception e) {
				System.out.println("Tietokantayhteys ei jostain syystä suostu menemään kiinni.");
			}
		}
		
		
		//suljetaan vielä webbisivun html-tagit
		wout.println("</body></html>");
	}

}
