/**
 * 
 */
package jElecLum.core.source;

import jElecLum.core.Constantes;

/**
 * @author SARPROJA
 *
 */
public abstract class AbstractSrcElec {
	protected float un;
	protected float cmax;
	protected float cmin;
	protected AbstractSrcRes resAval;
	
	AbstractSrcElec(float un, AbstractSrcRes resAval){
		this.un = un;
		this.cmax = Constantes.Cmax.getValeur();
		this.cmin = Constantes.Cmin.getValeur();
		this.resAval = resAval;
	}
	
	public float getU0() {
		return (float) (this.un / Math.sqrt(3));
	}
	
	float getCmax() {
		return this.cmax;
	}
	
	float getCmin() {
		return this.cmin;
	}
	
	public abstract float getRSource(Context context);
	public abstract float getXSource(Context context);
	
	public abstract float getIkSrc(Context context);
	public abstract float getIk(Context context);
	
}
