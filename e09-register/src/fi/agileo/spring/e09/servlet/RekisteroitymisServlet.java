package fi.agileo.spring.e09.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.agileo.spring.e09.bean.InvalidWebUserPoikkeus;
import fi.agileo.spring.e09.bean.WebUser;
import fi.agileo.spring.e09.dao.DAOPoikkeus;
import fi.agileo.spring.e09.dao.webuser.UsernameVarattuPoikkeus;
import fi.agileo.spring.e09.dao.webuser.WebUserDAO;

/**
 * Servlet implementation class RekisteroitymisServlet
 */
@WebServlet("/rekisteroidy")
public class RekisteroitymisServlet extends HttpServlet {
	
	public static final String FRONT_PAGE = "WEB-INF/jsp/rekisteroityminen.jsp";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RekisteroitymisServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		try {
			//luodaan käyttäjä suolalla ja hashilla
			WebUser kayttaja = new WebUser(username, password, password2);
			//lisätään tietokantaan
			WebUserDAO dao = new WebUserDAO();
			dao.lisaa(kayttaja);
			
			//takaisin onnistumisviestillä
			response.sendRedirect("rekisteroidy?onnistui=y");
			
		} catch(InvalidWebUserPoikkeus e) {
			takaisinVirheviestilla(e.getMessage(), username, request, response);
		} catch(UsernameVarattuPoikkeus e) {
			String virheviesti = "Käyttäjätunnus " +username +" on jo varattu, valitse toinen käyttäjätunnus!";
			takaisinVirheviestilla(virheviesti, username, request, response);
		} catch(DAOPoikkeus e) {
			throw new ServletException("Tietokantavirhe", e);
		} catch (NoSuchAlgorithmException e) {
			throw new ServletException("Salausalgoritmia ei löydy.", e);
		}
	
		
	}
	
	private void takaisinVirheviestilla(String viesti, String username, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("error", viesti);
		request.setAttribute("prev_reg_username", username);
		request.getRequestDispatcher(FRONT_PAGE).forward(request, response);
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(FRONT_PAGE).forward(request, response);
	}
	

}
