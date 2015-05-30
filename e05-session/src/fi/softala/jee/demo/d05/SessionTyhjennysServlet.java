package fi.softala.jee.demo.d05;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SessionTyhjennysServlet
 */
@WebServlet("/tyhjenna_sessio")
public class SessionTyhjennysServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTyhjennysServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//mitätöidään olemassa oleva sessio
		request.getSession().invalidate();
		//ohjataan takaisin alkuun
		response.sendRedirect("kirjoituskone.jsp");
	}

}
