/**
 * 
 */
package jElecLum.core.source;

import jElecLum.core.Constantes;

/**
 * @author SARPROJA
 *
 */
public class SrcElecTransfo extends AbstractSrcElec {

	private AbstractSrcRes resAmont;
	private float srt;
	private float ukt;
	
	
	/**
	 * @param un
	 */
	public SrcElecTransfo(float un, float srt, float ukt) {
		super(un, new SrcResAval());
		this.srt = srt;
		this.ukt = ukt;
		this.resAmont = new SrcResAmont();
	}
	
	protected float getZTransfo() {
		return (float) (Math.pow((Constantes.m.getValeur() * un), 2) / this.srt * this.ukt / 100);
	}
	
	public AbstractSrcRes getResAmont() {
		return this.resAmont;
	}
	
	public AbstractSrcRes getResAval() {
		return this.resAval;
	}

	public float getRTransfo() {
		return this.getZTransfo() * Constantes.kRt.getValeur();
	}
	
	public float getXTransfo() {
		return this.getZTransfo() * Constantes.kXt.getValeur();
	};
	
	public float getRSource(Context context) {
		return this.getRTransfo() + this.resAmont.getRres(this.un, context);
	}
	
	public float getXSource(Context context) {
		return this.getXTransfo() + this.resAmont.getXres(this.un, context);
	};
	
	public float getRTotal(Context context) {
		return this.getRTransfo() + this.resAmont.getRres(this.un, context) + this.resAval.getRres(this.un, context);
	}
	
	public float getXTotal(Context context) {
		return this.getXTransfo() + this.resAmont.getXres(this.un, context) + this.resAval.getXres(this.un, context);
	};
	
	public float getIkSrc(Context context) {
		float u = (context.getCircuit() == CtxCircuit.P || context.getCircuit() == CtxCircuit.PN) ? this.getU0() : this.un;
		float kZ = (context.getCircuit() == CtxCircuit.PP) ? 2 : 1;
		float r2 = (float) Math.pow(this.getRSource(context), 2);
		float x2 = (float) Math.pow(this.getXSource(context), 2);
		float c = (context.getRegle() == CtxRegle.Max) ? Constantes.Cmax.getValeur() : Constantes.Cmin.getValeur();
		float m = Constantes.m.getValeur();
		return (float) (( c * m * u) / (kZ * Math.sqrt(r2 + x2)));
	}
	
	public float getIk(Context context) {
		float u = (context.getCircuit() == CtxCircuit.P || context.getCircuit() == CtxCircuit.PN) ? this.getU0() : this.un;
		float kZ = (context.getCircuit() == CtxCircuit.PP) ? 2 : 1;
		float r2 = (float) Math.pow(this.getRTotal(context), 2);
		float x2 = (float) Math.pow(this.getXTotal(context), 2);
		float c = (context.getRegle() == CtxRegle.Max) ? Constantes.Cmax.getValeur() : Constantes.Cmin.getValeur();
		float m = Constantes.m.getValeur();
		return (float) (( c * m * u) / (kZ * Math.sqrt(r2 + x2)));
	}
}
