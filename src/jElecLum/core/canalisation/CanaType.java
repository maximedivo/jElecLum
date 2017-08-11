/**
 * 
 */
package jElecLum.core.canalisation;

/**
 * @author SARPROJA
 *
 */
public class CanaType {
	public static CanaType MULTI = new CanaType("Câble multiconducteurs", 0.08f);
	public static CanaType MONO_TREFLE = new CanaType("Câble monoconducteur en trèfle", 0.08f);
	public static CanaType MONO_JOINTIF = new CanaType("Câble monoconducteur jointif en nappe", 0.09f);
	public static CanaType MONO_ESPACE = new CanaType("Câble multiconducteurs", 0.08f);
	
	private String nom;
	private float lambda;
	
	public CanaType(String nom, float lambda) {
		this.nom = nom;
		this.lambda = lambda;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public float getLambda() {
		return this.lambda;
	}
}
