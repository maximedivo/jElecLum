/**
 * 
 */
package jElecLum.core.isolant;

/**
 * @author SARPROJA
 *
 */
public class PR extends Isolant {
	public String nom() { //Nom de l'isolant
		return "PR";
	}
	public float coef1() { //Coefficient pour Rho1
		return	1.28f;
	}
	public float coef2(float section) { //Coefficient pour Rho2
		return	1.60f;
	}
	public float coef3(float section) { //Coefficient pour Rho3
		return	1.48f;
	}
}