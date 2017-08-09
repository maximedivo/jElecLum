/**
 * 
 */
package jElecLum.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SARPROJA
 *
 */
public class Reseau {
	
	private ArrayList<Noeud> data;
	
	public Reseau() {
		this.data = new ArrayList<Noeud>();
	}
	
	public boolean add(Noeud noeud) {
		if (noeud.setReseau(this))
			this.data.add(noeud);
			this.indexer();
			return true;		
	}
	
	public boolean remove (Noeud noeud) {
		return this.data.remove(noeud);
	}
	
	public void indexer() {
		int index = 1;
		int profondeur = 0;
		for (Noeud child : this.getRootElements()) {
			int[] values = this.subIndexer(child, index, profondeur);
			index = values[0];
			profondeur = values[1];
		}
		
		    
	}
	
	private int[] subIndexer(Noeud noeud, int index, int profondeur) {
		noeud.setIndex1(index);
		noeud.setProfondeur(profondeur);
		index++;
		profondeur++;
		for (Noeud child : this.getDirectChildsOf(noeud)) {
			int[] values = this.subIndexer(child, index, profondeur);
			index = values[0];
			profondeur = values[1];
		}
		noeud.setIndex2(index);
		index++;
		profondeur--;
		return new int[] {index, profondeur};
	}
	
	public List<Noeud> getRootElements(){
		ArrayList<Noeud> filter = new ArrayList<Noeud>();
		for (Noeud anNoeud : this.data) {
			if (anNoeud.getParent() == anNoeud)
				filter.add(anNoeud);
		}
		return filter;
	}
	
	public List<Noeud> getChildsOf(Noeud noeud){
		ArrayList<Noeud> filter = new ArrayList<Noeud>();
		for (Noeud anNoeud : this.data) {
			if (anNoeud.isChildOf(noeud))
				filter.add(anNoeud);
		}
		return filter;
	}
	
	public List<Noeud> getDirectChildsOf(Noeud noeud){
		ArrayList<Noeud> filter = new ArrayList<Noeud>();
		for (Noeud anNoeud : this.data) {
			if (anNoeud.getParent() == noeud && anNoeud.getParent() != anNoeud)
				filter.add(anNoeud);
		}
		return filter;
	}
	
	public List<Noeud> getParentsOf(Noeud noeud){
		ArrayList<Noeud> filter = new ArrayList<Noeud>();
		for (Noeud anNoeud : this.data) {
			if (anNoeud.isParentOf(noeud))
				filter.add(anNoeud);
		}
		return filter;
	}
}
