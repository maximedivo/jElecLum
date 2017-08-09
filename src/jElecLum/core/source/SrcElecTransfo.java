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

	public float getRTransfo() {
		return this.getZTransfo() * Constantes.kRt.getValeur();
	}
	
	public float getXTransfo() {
		return this.getZTransfo() * Constantes.kXt.getValeur();
	};
	
	public float getRSource(Context context) {
		return this.getRTransfo() + this.resAmont.getRres(this.un, context) + this.resAval.getRres(this.un, context);
	}
	
	public float getXSource(Context context) {
		return this.getXTransfo() + this.resAmont.getXres(this.un, context) + this.resAval.getXres(this.un, context);
	};
}
