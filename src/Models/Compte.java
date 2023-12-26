package Models;

public class Compte {
	private int numcpt;
	private int typcpt;
	private double solde;
	private String proprietaire;
	
	
	public Compte() {
		super();
	}
	public Compte(int numcpt, int typcpt, double solde, String proprietaire) {
	
		super();
		this.numcpt = numcpt;
		this.typcpt = typcpt;
		this.solde = solde;
		this.proprietaire = proprietaire;
	}
	public int getNumcpt() {
		return numcpt;
	}
	public void setNumcpt(int numcpt) {
		this.numcpt = numcpt;
	}
	public int getTypcpt() {
		return typcpt;
	}
	public void setTypcpt(int typcpt) {
		this.typcpt = typcpt;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}
	
}
