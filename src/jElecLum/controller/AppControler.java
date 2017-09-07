/**
 * 
 */
package jElecLum.controller;

import com.trolltech.qt.core.QObject;
import com.trolltech.qt.gui.QMainWindow;

/**
 * @author SARPROJA
 *
 */
public class AppControler extends QObject{

	public Signal1<Void> documentChanged = new Signal1<Void>();


	/**
	 * @param mainWindow
	 */
	public AppControler(QMainWindow mainWindow) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void newDocument() {
		// TODO Auto-generated constructor stub
	}
	
	public void openDocument() {
		// TODO Auto-generated constructor stub
	}
	
	public void saveDocument() {
		// TODO Auto-generated constructor stub
	}
	
	public void saveAsDocument() {
		// TODO Auto-generated constructor stub
	}
	
	public String getDocumentName() {
		return "Nouveau fichier";
	}

}
