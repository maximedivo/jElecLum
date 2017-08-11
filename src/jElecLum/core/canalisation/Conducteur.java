package jElecLum.core.canalisation;

/**
*
* @author ${user}
* 
*/

public class Conducteur {
	
	private Canalisation parent; // est-ce utile??
	private float section;
	float longueur;
	ConducType conducType;
	
	public Conducteur(float longueur, float section, ConducType conducType, Canalisation parent) {
		this.parent = parent;
		this.conducType = conducType;
		if(!this.setSection(section))
			this.section = this.conducType.getSections().get(0);
		this.longueur = longueur;
	}
		
	public float getSection() {
		return this.section;
	}
	
	public boolean setSection(float section) {
		if (this.conducType.getSections().contains(section)) {
			this.section = section;
			return true;
		}
		return false;
	}
	
	public float getRc(int nRho) {
		return this.conducType.getRho(nRho, this.section) * this.longueur / this.section;
	}
	
}
