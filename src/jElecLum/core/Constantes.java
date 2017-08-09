/**
 * 
 */
package jElecLum.core;

/**
 * @author SARPROJA
 *
 */
public enum Constantes {
	RhoAl("Résistivité aluminium", 29.41f),
	RhoCu("Résistivité cuivre", 18.51f),
	
	m("facteur de charge", 1.05f),
	Cmax("Facteur de tension max", 1.05f),
	Cmin("Facteur de tension min", .95f),
	
	SkqrMax("Puissance de court-circuit du réseau haute tension max", 250_000f),
	SkqrMin("Puissance de court-circuit du réseau haute tension min", 125_000f),
	
	kRq("Coefficient Rq sur Xq", .100f),
	kXq("Coefficient Xq sur Zq", .995f),
	kRt("Coefficient Rt sur Zt", .31f),
	kXt("Coefficient Xt sur Zt", .95f);

	private String nom;
	private float valeur;
	
	Constantes(String nom, float valeur){
		this.nom = nom;
	    this.valeur = valeur;
	}
	
	public String toString(){
	    return this.nom;
	}
	
	public String getNom(){
	    return this.nom;
	}
	
	public float getValeur(){
	    return this.valeur;
	}
}
