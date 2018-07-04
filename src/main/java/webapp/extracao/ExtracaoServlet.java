package webapp.extracao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/extracao.do")
public class ExtracaoServlet extends HttpServlet {
	private ExtracaoService DBExtracaoService = new ExtracaoService();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet ExtracaoServlet");
		try {
			//List<ServiceOrder> ServiceOrders = DBExtracaoService.retrieveExtracaoFull();
			request.setAttribute("serviceorders", DBExtracaoService.retrieveExtracaoFull());
			request.getRequestDispatcher("/WEB-INF/views/extracao.jsp").forward(
					request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/views/extracao.jsp").forward(
				request, response);
	}
}
