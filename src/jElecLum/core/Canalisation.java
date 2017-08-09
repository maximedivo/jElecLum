/**
 * 
 */
package jElecLum.core;

import jElecLum.core.isolant.PR;
import jElecLum.core.isolant.PVC;
import jElecLum.core.matiere.Matiere;

/**
 * @author SARPROJA
 *
 */
public class Canalisation {
	//parent
	Conducteur conducteurs[];
	float longueur;
	
	public Canalisation() {
		conducteurs[0] = new Conducteur(10f, Matiere.Cuivre, new PR());
		conducteurs[1] = new Conducteur(10f, Matiere.Cuivre, new PR());
		conducteurs[2] = new Conducteur(10f, Matiere.Cuivre, new PR());
		conducteurs[3] = new Conducteur(10f, Matiere.Cuivre, new PR());
		conducteurs[4] = new Conducteur(10f, Matiere.Cuivre, new PR());
		
	}
}
