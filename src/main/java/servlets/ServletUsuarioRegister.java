package servlets;

	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import controller.UsuarioController;

	/**
	 * Servlet implementation class ServletUsuarioRegister
	 */
	@WebServlet("/ServletUsuarioRegister")
	public class ServletUsuarioRegister extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public ServletUsuarioRegister() {
			super();
			// TODO Auto-generated constructor stub
		}

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			UsuarioController usuario = new UsuarioController();
			
			String username = request.getParameter("username");
			String contrasena = request.getParameter("contrasena");
			String nombreCompleto = request.getParameter("nombreCompleto");
			String cedula = request.getParameter("cedula");
			String email = request.getParameter("email");
			double presupuesto = Double.parseDouble(request.getParameter("presupuesto"));
			boolean premium = Boolean.parseBoolean(request.getParameter("premium"));
			
			String result = usuario.register(username, contrasena, nombreCompleto, cedula, email, presupuesto, premium);
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(result);
			out.flush();
			out.close();
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	}
