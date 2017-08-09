/**
 * 
 */
package jElecLum.core.source;

import jElecLum.core.Constantes;

/**
 * @author SARPROJA
 *
 */
public class SrcResAmont extends AbstractSrcRes{

	private float skqrMin;
	private float skqrMax;
		
	public SrcResAmont() {
		this.skqrMin = Constantes.SkqrMin.getValeur();
		this.skqrMax = Constantes.SkqrMax.getValeur();
	}
	
	@Override
	public float getRres(float un, Context context) {
		return this.getXres(un, context) * Constantes.kRq.getValeur();
	}

	@Override
	public float getXres(float un, Context context) {
		return this.getZres(un, context) * Constantes.kXq.getValeur();
	}
	
	protected float getZres(float un, Context context) {
		float u = (float) (Math.pow((Constantes.m.getValeur() * un), 2));
		if (context == Context.Max) {
			return (float) (u / this.skqrMax);
		}else if (context == Context.Min) {
			return (float) (u / this.skqrMin);
		}
		return 0;
	}

}
