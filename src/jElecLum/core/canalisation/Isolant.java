/**
 * 
 */
package jElecLum.core.canalisation;

/**
 * @author SARPROJA
 *
 */
public class Isolant {
	public static Isolant PR_EPR = new Isolant("PR-EPR", new float[] {1.28f, 1.60f, 1.48f});
	public static Isolant PVC = new Isolant("PVC", new float[] {1.20f, 1.38f, 1.34f, 1.30f, 1.26f});
	
	private String nom;
	private float c1;
	private float c21;
	private float c22;
	private float c31;
	private float c32;
	
	public Isolant(String nom, float[] c) { // c = {c1, c2, c3} ou {c1, c2-300, c2+300, c3-300, c3+300};
		this.nom = nom;
		if (c.length == 3) {
			this.c1 = c[0];
			this.c21 = c[1];
			this.c22 = c[1];
			this.c31 = c[2];
			this.c32 = c[2];
		}
		else {
			this.c1 = c[0];
			this.c21 = c[1];
			this.c22 = c[2];
			this.c31 = c[3];
			this.c32 = c[4];
		}
	}
	
	public String getNom() { //Nom de l'isolant
		return this.nom;
	}
	public float getCoef1() { //Coefficient pour Rho1
		return	this.c1;
	}
	public float getCoef2(float section) { //Coefficient pour Rho2
		if(section > 300)
			return this.c22;
		else
			return this.c21;
	}
	public float getCoef3(float section) { //Coefficient pour Rho3
		if(section > 300)
			return this.c32;
		else
			return this.c31;
	}
}
