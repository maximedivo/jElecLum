/**
 * 
 */
package jElecLum.core.source;

/**
 * @author SARPROJA
 *
 */
public enum Context {
	Ik3Max(CtxRegle.Max, CtxCircuit.P),
	Ik2Max(CtxRegle.Max, CtxCircuit.PP),
	Ik1Max(CtxRegle.Max, CtxCircuit.PN),
	Ik2Min(CtxRegle.Min, CtxCircuit.PP),
	Ik1Min(CtxRegle.Min, CtxCircuit.PN),
	IfPE(CtxRegle.Def, CtxCircuit.PPE),
	IfPEN(CtxRegle.Def, CtxCircuit.PPEN),
	Ib(CtxRegle.DU, CtxCircuit.PN);
	
	private CtxRegle regle;
	private CtxCircuit circuit;
	
	Context(CtxRegle regle, CtxCircuit circuit) {
		this.regle = regle;
		this.circuit = circuit;
	}
	
	public CtxRegle getRegle() {
		return this.regle;
	}
	
	public CtxCircuit getCircuit() {
		return this.circuit;
	}
}