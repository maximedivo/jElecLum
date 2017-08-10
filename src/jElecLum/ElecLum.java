package jElecLum;

import jElecLum.core.ConducType;
import jElecLum.core.Conducteur;
import jElecLum.core.Noeud;
import jElecLum.core.Reseau;
import jElecLum.core.source.Context;
import jElecLum.core.source.SrcElecTransfo;

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
		System.out.println("Rq (max) = " + sourceTest.getResAmont().getRres(un, Context.Min));
		System.out.println("Rq (min) = " + sourceTest.getResAmont().getRres(un, Context.Max));
		System.out.println("Xq (max) = " + sourceTest.getResAmont().getXres(un, Context.Min));
		System.out.println("Xq (min) = " + sourceTest.getResAmont().getXres(un, Context.Max));
		System.out.println();
		System.out.println("Rs (max) = " + sourceTest.getRSource(Context.Min));
		System.out.println("Rs (min) = " + sourceTest.getRSource(Context.Max));
		System.out.println("Xs (max) = " + sourceTest.getXSource(Context.Min));
		System.out.println("Xs (min) = " + sourceTest.getXSource(Context.Max));
		
		Conducteur c1 = new Conducteur(25f, 0f, ConducType.U1000R2V, null);
		System.out.println("S = " + c1.getSection());
		System.out.println("S = " + c1.setSection(22f));
		System.out.println("S = " + c1.getSection());
		System.out.println("S = " + c1.setSection(70f));
		System.out.println("S = " + c1.getSection());
	}
	
}
