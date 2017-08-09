/**
 * 
 */
package jElecLum.core.isolant;

/**
 * @author SARPROJA
 *
 */
public abstract class Isolant {
	public abstract String nom(); //Nom de l'isolant
	public abstract float coef1(); //Coefficient pour Rho1
	public abstract float coef2(float section); //Coefficient pour Rho2
	public abstract float coef3(float section); //Coefficient pour Rho3
}
