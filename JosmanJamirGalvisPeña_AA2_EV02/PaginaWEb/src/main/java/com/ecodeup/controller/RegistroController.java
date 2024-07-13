package com.ecodeup.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecodeup.dao.ProductoDAO;

/**
 * Servlet implementation class RegistroController
 * @param <Registro>
 */
@WebServlet(description = "administracion de los datos de usuarios", urlPatterns = { "/registro" })
public class RegistroController<Registro> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String opcion = request.getParameter("opcion");
		
		if (opcion.equals("registrar")) {
			System.out.println("Usted a presionando la opcion registrar");
			RequestDispatcher requestDispatcher= request.getRequestDispatcher("/view/registrar.jsp");
			requestDispatcher.forward(request, response);
		} else if (opcion.equals("lista")) {
			
			ProductoDAO productoDAO= new ProductoDAO();
			List<com.ecodeup.model.Registro> lista= new ArrayList<>();
			
			try {
				lista=productoDAO.obtenerRegistros();
				for (com.ecodeup.model.Registro registro : lista) {
					System.out.println(registro);
				}
				request.setAttribute("lista", lista);
				RequestDispatcher requestDispatcher= request.getRequestDispatcher("/view/lista.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Usted a presionando la opcion lista de registros");
		} else if (opcion.equals("editar")) {
			int id= Integer.parseInt(request.getParameter("id"));
			System.out.println("Editar id: "+id);
			ProductoDAO productoDAO= new ProductoDAO();
			com.ecodeup.model.Registro r= new com.ecodeup.model.Registro();
			try {
				r=productoDAO.obtenerRegistro(id);
				System.out.println(r);
				request.setAttribute("registro", r);
				RequestDispatcher requestDispatcher= request.getRequestDispatcher("/view/editar.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (opcion.equals("eliminar")) {
			ProductoDAO productoDAO= new ProductoDAO();
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				productoDAO.eliminar(id);
				System.out.println("Registro eliminado");
				RequestDispatcher requestDispatcher= request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		String opcion= request.getParameter("opcion");
		if (opcion.equals("guardar")) {
			ProductoDAO productoDAO= new ProductoDAO();
		com.ecodeup.model.Registro registro= new com.ecodeup.model.Registro();
		registro.setNombre(request.getParameter("nombre"));
		registro.setCorreo(request.getParameter("correo"));
		((com.ecodeup.model.Registro)registro).setContraseña(request.getParameter("contraseña"));	
		
		try {
			productoDAO.guardar((com.ecodeup.model.Registro) registro);
			System.out.println("Usuario registrado exitosamente");
			RequestDispatcher requestDispatcher= request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}else if (opcion.equals("editar")) {
		com.ecodeup.model.Registro registro= new com.ecodeup.model.Registro();
		ProductoDAO productoDAO= new ProductoDAO();
		registro.setId(Integer.parseInt(request.getParameter("id")));
		registro.setNombre(request.getParameter("nombre"));
		registro.setCorreo(request.getParameter("correo"));
		((com.ecodeup.model.Registro)registro).setContraseña(request.getParameter("contraseña"));	
		try {
			productoDAO.editar(registro);
			System.out.println("Informacion actualizada");
			RequestDispatcher requestDispatcher= request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
		
		
		//doGet(request, response);
	}

}
