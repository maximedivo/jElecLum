/**
 * 
 */
package jElecLum.core.canalisation;

import java.util.Arrays;

/**
 * @author SARPROJA
 *
 */
public class Canalisation {
	public static int P = 0;
	//public static int L2 = 0;
	//public static int L3 = 0;
	public static int N = 1;
	public static int PE = 2;
	
	//parent ?
	Conducteur conducteurs[];
	CanaType canaType;
	boolean triphase;
	boolean neutre;
	boolean pe;
	
	
	public Canalisation(float longueur, boolean triphase, boolean neutre, boolean pe, ConducType conducType, CanaType canaType) {
		conducteurs = new Conducteur[3];
		Arrays.fill(conducteurs, new Conducteur(longueur, 0, conducType, this));
		this.canaType = canaType;
		this.triphase = triphase;
		this.neutre = neutre;
		this.pe = pe;
	}
	
	public boolean setSection(int conduc, float section) {
		if (conduc == N && !this.neutre) return false;
		if (conduc == PE && !this.pe) return false;
		return this.conducteurs[conduc].setSection(section);
	}
	
	public float getSection(int conduc) {
		if (conduc == N && !this.neutre) return 0f;
		if (conduc == PE && !this.pe) return 0f;
		return this.conducteurs[conduc].getSection();
	}
	
	public boolean conducExist(int conduc) {
		return (this.conducteurs[conduc] != null);
	}
	
	public float getRbPh(int nRho) {
		return this.conducteurs[P].getRc(nRho);
	}
	
	public float getXbPh() {
		return this.getXc(P);
	}
	
	public float getRbPhPh(int nRho) {
		return this.conducteurs[P].getRc(nRho) * 2;
	}
	
	public float getXbPhPh() {
		return this.getXc(P) * 2;
	}
	
	public float getRbPhN(int nRho) {
		return this.conducteurs[P].getRc(nRho) + this.conducteurs[N].getRc(nRho);
	}
	
	public float getXbPhN() {
		return this.getXc(P) + this.getXc(N);
	}
	
	private float getXc(int conduc) {
		return (this.conducExist(conduc)) ? (this.canaType.getLambda() * this.conducteurs[conduc].longueur) : 0f;
	}
}
