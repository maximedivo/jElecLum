package jElecLum.core.canalisation;

/**
*
* @author ${user}
* 
*/

public class Matiere {
	public static Matiere ALUMINIUM = new Matiere("Aluminium", "Al", 29.41f);
	public static Matiere CUIVRE = new Matiere("Cuivre", "Cu", 18.51f);

	private String nom; //Nom de la matiere
	private String abreviation; //Abréviation physique de la matière
	private float rho0; //Résistivité à 20 °C selon la NF EN 60909-0 (C 10-120), en mΩ. mm² / m
	   
	Matiere(String nom, String abreviation, float rho0){
		this.nom = nom;
	    this.abreviation = abreviation;
	    this.rho0 = rho0;
	}
	   
	public String toString(){
	    return this.nom;
	}
	public String getNom(){
	    return this.nom;
	}	
	public String getAbreviation(){
	    return this.abreviation;
	}	
	public float getRho0(){
	    return this.rho0;
	}
}