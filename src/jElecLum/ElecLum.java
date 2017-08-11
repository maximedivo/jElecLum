package jElecLum;

import jElecLum.core.*;
import jElecLum.core.canalisation.*;
import jElecLum.core.source.*;

/**
*
* @author ${user}
* 
*/

public class ElecLum {
	
	public static void main(String[] args) {
		Noeud n1 = new Noeud("n1");
		Reseau root = n1.getReseau();
		Noeud n2 = new Noeud("n2", n1);
		Noeud n3 = new Noeud("n3", n1);
		Noeud n4 = new Noeud("n4", n2);
		Noeud n5 = new Noeud("n5", n3);
		Noeud n6 = new Noeud("n6", n4);
		Noeud n7 = new Noeud("n7", n5);
		Noeud n8 = new Noeud("n8", n5);
		
		System.out.println(n1);
		System.out.println(n6);
		System.out.println(n7);
		System.out.println(root.getChildsOf(n5));
		System.out.println();
		System.out.println();
		
		float un = 400f;
		float str = 400f;
		float ucc = 4f;
		
		SrcElecTransfo sourceTest = new SrcElecTransfo(un, str, ucc);
		System.out.println("Rt = " + sourceTest.getRTransfo());
		System.out.println("Xt = " + sourceTest.getXTransfo());
		System.out.println();
		System.out.println("Rq (max) = " + sourceTest.getResAmont().getRres(un, Context.Ik1Min));
		System.out.println("Rq (min) = " + sourceTest.getResAmont().getRres(un, Context.Ik3Max));
		System.out.println("Xq (max) = " + sourceTest.getResAmont().getXres(un, Context.Ik1Min));
		System.out.println("Xq (min) = " + sourceTest.getResAmont().getXres(un, Context.Ik3Max));
		System.out.println();
		System.out.println("Rs (max) = " + sourceTest.getRSource(Context.Ik1Min));
		System.out.println("Rs (min) = " + sourceTest.getRSource(Context.Ik3Max));
		System.out.println("Xs (max) = " + sourceTest.getXSource(Context.Ik1Min));
		System.out.println("Xs (min) = " + sourceTest.getXSource(Context.Ik3Max));
		System.out.println();
		System.out.println();
		
		Canalisation liTr = new Canalisation(10, true, true, false, ConducType.U1000R2V, CanaType.MONO_ESPACE);
		liTr.setSection(Canalisation.P, 240f);
		liTr.setSection(Canalisation.N, 240f);
		Canalisation c1 = new Canalisation(12, true, true, false, ConducType.U1000R2V, CanaType.MULTI);
		c1.setSection(Canalisation.P, 16f);
		c1.setSection(Canalisation.N, 16f);
		
		System.out.println("RbPh = " + liTr.getRbPh(0));
		System.out.println("RbPhPh = " + liTr.getRbPhPh(0));
		System.out.println("RbPhN = " + liTr.getRbPhN(0));
		System.out.println();
		System.out.println();
		
		SrcResAval resAval = (SrcResAval) sourceTest.getResAval();
		resAval.setLiaisonTr(liTr);
		//resAval.addLiaisonAval(c1);
		System.out.println("Ik3max Transfo = " + sourceTest.getIkSrc(Context.Ik3Max));
		System.out.println("Ik2max Transfo = " + sourceTest.getIkSrc(Context.Ik2Max));
		System.out.println("Ik1max Transfo = " + sourceTest.getIkSrc(Context.Ik1Max));
		System.out.println("Ik2min Transfo = " + sourceTest.getIkSrc(Context.Ik2Min));
		System.out.println("Ik1min Transfo = " + sourceTest.getIkSrc(Context.Ik1Min));
		System.out.println();
		System.out.println("Ik3max = " + sourceTest.getIk(Context.Ik3Max));
		System.out.println("Ik2max = " + sourceTest.getIk(Context.Ik2Max));
		System.out.println("Ik1max = " + sourceTest.getIk(Context.Ik1Max));
		System.out.println("Ik2min = " + sourceTest.getIk(Context.Ik2Min));
		System.out.println("Ik1min = " + sourceTest.getIk(Context.Ik1Min));
		
	}
	
}
