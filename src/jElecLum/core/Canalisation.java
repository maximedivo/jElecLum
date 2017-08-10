/**
 * 
 */
package jElecLum.core;

import jElecLum.core.isolant.Isolant;
import jElecLum.core.matiere.Matiere;

/**
 * @author SARPROJA
 *
 */
public class Canalisation {
	private static int L1 = 0;
	private static int L2 = 1;
	private static int L3 = 2;
	private static int N = 3;
	private static int PE = 4;
	
	//parent
	Conducteur conducteurs[];
	
	
	public Canalisation(float longueur, int nbPhase, boolean neutre, boolean pe, ConducType conducType, CanaType canaType) {
		this.conducteurs[L1] = new Conducteur(longueur, 0, conducType, this);
		this.conducteurs[L2] = new Conducteur(longueur, 0, conducType, this);
		this.conducteurs[L3] = new Conducteur(longueur, 0, conducType, this);
		this.conducteurs[N] = new Conducteur(longueur, 0, conducType, this);
		this.conducteurs[PE] = new Conducteur(longueur, 0, conducType, this);
		
	}
}
