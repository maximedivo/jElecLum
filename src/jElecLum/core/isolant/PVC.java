/**
 * 
 */
package jElecLum.core.isolant;

/**
 * @author SARPROJA
 *
 */
public class PVC extends Isolant {
	public String nom() { //Nom de l'isolant
		return "PVC";
	}
	public float coef1() { //Coefficient pour Rho1
		return	1.2f;
	}
	public float coef2(float section) { //Coefficient pour Rho2
		if(section > 300)
			return 1.34f;
		else
			return 1.38f;
	}
	public float coef3(float section) { //Coefficient pour Rho3
		if(section > 300)
			return 1.26f;
		else
			return 1.30f;
	}
}
