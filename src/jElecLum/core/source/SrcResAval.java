/**
 * 
 */
package jElecLum.core.source;

import java.util.ArrayList;

import jElecLum.core.canalisation.*;

/**
 * @author SARPROJA
 *
 */
public class SrcResAval extends AbstractSrcRes{
	
	Canalisation liaisonTr;
	ArrayList<Canalisation> liaisonsAvals;
	
	public SrcResAval() {
		this.liaisonTr = new Canalisation(5f, true, true, false, ConducType.BT_ENEDIS, CanaType.MONO_ESPACE);
		this.liaisonsAvals = new ArrayList<Canalisation>();
	}
	
	public void setLiaisonTr(Canalisation liaisonTr) {
		this.liaisonTr = liaisonTr;
	}
	
	public Canalisation getLiaisonTr() {
		return this.liaisonTr;
	}
	
	public ArrayList<Canalisation> getLiaisonsAvals(){
		return this.liaisonsAvals;
	}
	
	public boolean addLiaisonAval(Canalisation liaison) {
		return this.liaisonsAvals.add(liaisonTr);
	}
	
	public boolean removeLiaisonAval(Canalisation liaison) {
		return this.liaisonsAvals.remove(liaisonTr);
	}
	
	public void resetLiaisonAval() {
		this.liaisonsAvals.clear();
	}
	
	@Override
	public float getRres(float un, Context context) {
		return 0f;
	}

	@Override
	public float getXres(float un, Context context) {
		return 0f;
	}
}
