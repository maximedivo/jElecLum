/**
 * 
 */
package jElecLum.core.canalisation;

import java.util.ArrayList;


/**
 * @author SARPROJA
 *
 */
public class ConducType {
	private static float[] LIST_SECTIONS = new float[] {1.5f, 2.5f, 4f, 6f, 10f, 12f, 16f, 25f, 35f, 50f, 70f, 95f, 120f, 150f, 185f, 240f, 300f, 500f, 630f};
	
	public static ConducType U1000R2V = new ConducType("U 1000 R2V", "NF C32-321", Matiere.CUIVRE, Isolant.PR_EPR, new float[] {1.5f, 630f});
	public static ConducType U1000RVFV = new ConducType("U 1000 RVFV", "NF C32-322", Matiere.CUIVRE, Isolant.PR_EPR, new float[] {1.5f, 300f});
	public static ConducType TORSADE = new ConducType("Torsade", "NF C33-209", Matiere.ALUMINIUM, Isolant.PR_EPR, new float[] {16f, 150f});
	
	//isolant PR mais à calculer comme PVC car T° Âme < 70° - Voir 15-100 Tab. 52A
	public static ConducType H07RNF = new ConducType("H 07 RN-F", "NF C32-102-4", Matiere.CUIVRE, Isolant.PVC, new float[] {1.5f, 500f}); 
	
	//Câbles distribution ENEDIS
	public static ConducType BT_ENEDIS = new ConducType("H1-XDV", "NF C33-210", Matiere.ALUMINIUM, Isolant.PR_EPR, new float[] {50f, 240f});
	
	private String nom;
	private String norme;
	private ArrayList<Float> sections;
	private Matiere ame;
	private Isolant isolant;
	
	public ConducType(String nom, String norme, Matiere ame, Isolant isolant, float[] sectionsMinMax) {
		this.nom = nom;
		this.norme = norme;
		this.ame = ame;
		this.isolant = isolant;
		this.initSections(sectionsMinMax);
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getNorme() {
		return this.norme;
	}
	
	public ArrayList<Float> getSections(){
		return this.sections;
	}
	
	public String getAme() {
		return this.ame.getNom();
	}
	
	public String getIsolant() {
		return this.isolant.getNom();
	}
	
	public float getRho(int nRho, float section) {	
		switch (nRho){
		case 0:
			return (float) this.ame.getRho0();
		case 1:
			return (float) this.ame.getRho0() * this.isolant.getCoef1();
		case 2:
			return (float) this.ame.getRho0() * this.isolant.getCoef2(section);
		case 3:
			return (float) this.ame.getRho0() * this.isolant.getCoef3(section);
		default:
			return 0f;
		}
	}
	
	private void initSections(float[] sectionsMinMax) {
		this.sections = new ArrayList<Float>();
		for (float section : this.LIST_SECTIONS) {
			if (section >= sectionsMinMax[0] && section <= sectionsMinMax[1])
				this.sections.add(section);
		}
	}
}
