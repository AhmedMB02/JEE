package DAO;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Models.Compte;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;



public class DAOCompte implements CompteDaoInterface {
	
	private Connection maconnexion = Connexion.getInstance();
	
	@Override
	public void creerCompte(Compte c) {
		
	}

	@Override
	public Compte consulterCompte(int num) throws SQLException {
		Compte c = new Compte();
		Statement maStat = maconnexion.createStatement();
		ResultSet resultat = maStat.executeQuery("select * from compte c where c.num="+num);
		if(resultat.next()) {
			c.setNumcpt(num);
			c.setTypcpt(resultat.getInt(2));
			c.setProprietaire(resultat.getString(3));
			c.setSolde(resultat.getDouble(4));
			return c;
		}
		else return null;
	}

	@Override
	public List<Compte> listerAllCompte() {
		List<Compte> comptes = new ArrayList<Compte>();
		ResultSet resultat = null;
		Statement maStat;
		try {
			maStat = maconnexion.createStatement();
			resultat = maStat.executeQuery("SELECT num, type,proprietaire,solde FROM compte;");
			while(resultat.next()) {
				int num = resultat.getInt(1);
				int ty = resultat.getInt(2);
				String nom = resultat.getString(3);
				double sold = resultat.getDouble(4);
				
				Compte c = new Compte(num,ty,sold,nom);
				comptes.add(c);
			}
		}
		catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
		return comptes;
	}

	@Override
	public void DesposerRetirer(double montant,int num) {
		Statement maStat;
		Compte c = new Compte();
		ResultSet resultat = null;
		try {
			maStat = maconnexion.createStatement();
			c=consulterCompte(num);
			if(c != null) {
				resultat=maStat.executeQuery("update compte set solde=solde+"+montant+"where numero="+num);
				if(resultat.next()) {
					if(montant<0) 
						System.out.println("Operation retirer validé");
					else if (montant>0) 
						System.out.println("Operation depot validé");
				}	
				else 
					System.out.println("Operation non validé");
			}
		}
		catch(Throwable e1) {
			e1.printStackTrace();
		}

	}

}
