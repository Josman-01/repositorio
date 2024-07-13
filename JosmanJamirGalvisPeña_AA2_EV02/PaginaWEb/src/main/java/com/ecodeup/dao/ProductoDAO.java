package com.ecodeup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecodeup.conexion.Conexion;
import com.ecodeup.model.Registro;
import com.mysql.cj.protocol.Resultset;

@SuppressWarnings("unused")
public class ProductoDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	//Guardar
	public boolean guardar(Registro registro) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="INSERT INTO registro (id_registro, nombre, correo, contraseña) VALUES(?,?,?,?)";
			statement=connection.prepareStatement(sql);
			
			statement.setString(1, null);
			statement.setString(2, registro.getNombre());
			statement.setString(3, registro.getCorreo());
			statement.setString(4, registro.getContraseña());
			
			estadoOperacion=statement.executeUpdate()>0;
			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}
	//Editar registro
	public boolean editar(Registro registro) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="UPDATE registro SET nombre=?, correo=?, contraseña=? WHERE id_registro=?";
			statement=connection.prepareStatement(sql);
			
			statement.setString(1, registro.getNombre());
			statement.setString(2, registro.getCorreo());
			statement.setString(3, registro.getContraseña());
			statement.setInt(4, registro.getId());
			
			estadoOperacion=statement.executeUpdate()>0;
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}
	//Eliminar registro
	public boolean eliminar(int idregistro) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="DELETE FROM registro WHERE id_registro=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, idregistro);
			estadoOperacion=statement.executeUpdate()>0;
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return estadoOperacion;
	}
	//Lista de usuarios
	public List<Registro> obtenerRegistros() throws SQLException {
		ResultSet resultset=null;
		List<Registro> listaregistro = new ArrayList<>();
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			sql="SELECT * FROM registro";
			statement=connection.prepareStatement(sql);
			resultset=statement.executeQuery(sql);
			while (resultset.next()) {
				Registro r=new Registro();
				r.setId(resultset.getInt(1));
				r.setNombre(resultset.getString(2));
				r.setCorreo(resultset.getString(3));
				r.setContraseña(resultset.getString(4));
				listaregistro.add(r);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaregistro;
	}
	
	//obtener registro de usuario
	public Registro obtenerRegistro(int idregistro) throws SQLException {
		ResultSet resultset=null;
		Registro r=new Registro();
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			sql="SELECT * FROM registro WHERE id_registro =?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, idregistro);
			resultset=statement.executeQuery();
			if (resultset.next()) {
				
				r.setId(resultset.getInt(1));
				r.setNombre(resultset.getString(2));
				r.setCorreo(resultset.getString(3));
				r.setContraseña(resultset.getString(4));
				

				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}
	//obtener conexion
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}
}
