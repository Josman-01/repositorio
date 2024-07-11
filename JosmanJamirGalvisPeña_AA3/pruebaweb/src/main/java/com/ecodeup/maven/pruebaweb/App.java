package com.ecodeup.maven.pruebaweb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Dates
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	EntityManagerFactory emf= Persistence.createEntityManagerFactory("pruebaweb");  
    	EntityManager em = emf.createEntityManager();
    	
    	Registro r = new Registro("Juan", "juan1@gmail.com", "987654");  //Estos son los datos se subieran a la base de datos MySQL 
    	
    	em.getTransaction().begin();  //Comienza una transaccion
    	
    	em.persist(r);  //Esta parte guarda los datos en la base de datos MySQL
    	
    	em.getTransaction().commit();  //Aqui se confirma los cambios realizados y la finalizacion de la transaccion
    	
    	em.close();  //Se cierra la conexion
    	emf.close();
    	
    	
    	System.out.println( "Datos subidos" ); //Mensaje de cuando los datos se han terminado de subir 
    }
}
