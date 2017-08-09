/**
 * 
 */
package jElecLum.core;

/**
 * @author SARPROJA
 *
 */
public class Noeud {
	private String nom;
	private int index1;
	private int index2;
	private int profondeur;
	private Noeud parent;
	private Reseau reseau;
	// il est théoriquement impossible de changer un noeud de réseau.
	
	public Noeud(String nom) {
		this(nom, null);
	}
	
	public Noeud(String nom, Noeud parent) {
		this.nom = nom;
		this.index1 = 0;
		this.index2 = 0;
		this.profondeur = 0;
		this.parent = parent;
		if (this.parent != null)
			this.reseau = this.parent.getReseau();			
		else {
			this.reseau = new Reseau();
			this.parent = this;
		}			
		this.reseau.add(this);
	}
	
	public String toString() {
		return this.nom + " :" + this.getIndex1() + " - " + this.getIndex2() + " / " + this.profondeur;
	}
	
	public Reseau getReseau() {
		return this.reseau;
	}
	
	boolean setReseau(Reseau reseau) {
		if (this.parent.getReseau() == reseau) {
			this.reseau = reseau;
			return true;
		}
		else {
			this.parent = this;
			this.reseau.remove(this);
			this.reseau = reseau;
			return true;
		}
	}
	
	public Noeud getParent() {
		return this.parent;
	}
	
	public boolean setParent(Noeud parent, boolean withChild) {
		if (this.reseau == parent.getReseau()) {
			if (withChild) {
				this.parent = parent;
				
				return true;
			} else {
				for (Noeud child : this.reseau.getDirectChildsOf(this)) {
					child.setParent(this.parent, true);
				}
				this.parent = parent;
				return true;
			}
				
		} else
			return false;
	}
	
	public int getProfondeur() {
		return this.profondeur;
	}
	
	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}
	
	public int getIndex1() {
		return this.index1;
	}
	
	public void setIndex1(int index) {
		this.index1 = index;
	}
	
	public int getIndex2() {
		return this.index2;
	}
	
	public void setIndex2(int index) {
		this.index2 = index;
	}
	
	public int countChild() {
		return (int)((this.index2 - this.index1 - 1) / 2);
	}

	public boolean isChildOf (Noeud parent) {
		return (this.index1 > parent.getIndex1() && this.index2 < parent.getIndex2());
	}
	
	public boolean isParentOf (Noeud child) {
		return (this.index1 < child.getIndex1() && this.index2 > child.getIndex2());
	}

}