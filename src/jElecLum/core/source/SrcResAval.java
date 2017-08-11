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
		int nRho;
		nRho = (context.getRegle() == CtxRegle.Max) ? 0 : 1;
		if (context.getCircuit() == CtxCircuit.P) {
			float rbPh = 0f;
			for(Canalisation cana : this.liaisonsAvals) {
				rbPh += cana.getRbPh(nRho);
			}
			return this.liaisonTr.getRbPh(nRho) + rbPh;
		} else if (context.getCircuit() == CtxCircuit.PP) {
			float rbPhPh = 0f;
			for(Canalisation cana : this.liaisonsAvals) {
				rbPhPh += cana.getRbPhPh(nRho);
			}
			return this.liaisonTr.getRbPhPh(nRho) + rbPhPh;
		} else if (context.getCircuit() == CtxCircuit.PN) {
			float rbPhN = 0f;
			for(Canalisation cana : this.liaisonsAvals) {
				rbPhN += cana.getRbPhN(nRho);
			}
			return this.liaisonTr.getRbPhN(nRho) + rbPhN;
		}
		return 0f;
	}
	
	public float getRres(Context context) {	
		return this.getRres(0f, context);
	}

	@Override
	public float getXres(float un, Context context) {
		if (context.getCircuit() == CtxCircuit.P) {
			float xbPh = 0f;
			for(Canalisation cana : this.liaisonsAvals) {
				xbPh += cana.getXbPh();
			}
			return this.liaisonTr.getXbPh() + xbPh;
		} else if (context.getCircuit() == CtxCircuit.PP) {
			float xbPhPh = 0f;
			for(Canalisation cana : this.liaisonsAvals) {
				xbPhPh += cana.getXbPhPh();
			}
			return this.liaisonTr.getXbPhPh() + xbPhPh;
		} else if (context.getCircuit() == CtxCircuit.PN) {
			float xbPhN = 0f;
			for(Canalisation cana : this.liaisonsAvals) {
				xbPhN += cana.getXbPhN();
			}
			return this.liaisonTr.getXbPhN() + xbPhN;
		}
		return 0f;
	}
	
	public float getXres(Context context) {
		return getXres(0f, context);
	}
}
