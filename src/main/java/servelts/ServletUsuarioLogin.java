//Es el comunicador entre JS (por parte de Front) y hacia la base de datos por IUC(Interfaz de Usuario Controller - IUsuarioController.java)
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
 * Servlet implementation class ServletUsuarioLogin
 */
@WebServlet("/ServletUsuarioLogin")
public class ServletUsuarioLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuarioLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         * Recibe la solictud o requerimiento del .JS , para devolverle una respuesta cuando se cumplan las dos condiciones y
         * se utiliza doGet y doPost
         *doGet obtiene la información del index.js 
         *doPost muestra la información de index.js
         * Seguido le manda esa información a los controladores 
	 */
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UsuarioController usuario = new UsuarioController();
		String username = request.getParameter("usuario");//Campo user_name del backenda base de datos
		String contrasena = request.getParameter("contrasena");//Campo passsword del backenda base de datos
		String result = usuario.login(username, contrasena);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(result);
		out.flush();//temporalmente almacena esa info de contraseña y usuario y si alguna persona mas quiera loguearse, el flush puede desbordarse por tanta ocupacion, soltando y liberando la memoria para que otra persona pueda ingresar. 
		out.close();//cierra el flush o si no queda como un ciclo
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        //doGet ontiene la informacion 
        //doPost muestra la informacion
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
