package jElecLum.core;

import jElecLum.core.isolant.Isolant;
import jElecLum.core.matiere.Matiere;

/**
*
* @author ${user}
* 
*/

public class Conducteur {
	
	private Canalisation parent;
	private float section;
	private Matiere ame;
	private Isolant isolant;
	
	public Conducteur(float section, Matiere ame, Isolant isolant) {
		this.section = section;
		this.ame = ame;
		this.isolant = isolant;
	}
	
	public float rbx (int x) {
		switch (x){
		case 0:
			return (float)this.ame.getRho0()/this.section;
		case 1:
			return (float)this.ame.getRho0()*this.isolant.coef1()/this.section;
		case 2:
			return (float)this.ame.getRho0()*this.isolant.coef2(this.section)/this.section;
		case 3:
			return (float)this.ame.getRho0()*this.isolant.coef3(this.section)/this.section;
		default:
			return 0f;
		}
		
	}
	
}
