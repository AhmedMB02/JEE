package DAO;

import java.sql.SQLException;
import java.util.List;

import Models.Compte;

public interface CompteDaoInterface {
	public void creerCompte(Compte c);
	public Compte consulterCompte(int num) throws SQLException;
	public List<Compte> listerAllCompte();
	public void DesposerRetirer(double montant,int num);

}
