package DAO;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class Connexion {

   private static Connection maCx;
   private Connexion(){     // constructeur privé
	   try{
		   Class.forName("com.mysql.jdbc.Driver");
		   maCx=DriverManager.getConnection("jdbc:mysql://localhost/horizon","root","");
	   } catch(SQLException|ClassNotFoundException e){

       ((Throwable) e).printStackTrace();

        System.out.println("Problème Connexion sur la BD "+e.getMessage());

        }

      }

   public static Connection getInstance(){
	   if(maCx==null)
		   new Connexion();
   return maCx;

  }

}