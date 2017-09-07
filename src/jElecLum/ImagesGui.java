/**
 * 
 */
package jElecLum;

import com.trolltech.qt.gui.QIcon;

/**
 * @author SARPROJA
 *
 */
public enum ImagesGui {
	APP("/lightning.ico"),
    
	FILE_32("/32x32/document_empty.png"),
	OPEN_32("/32x32/folder.png"),
	DISK_32("/32x32/diskette.png"),
	DISKS_32("/32x32/save_as.png"),
	PRINT_32("/32x32/printer.png"),

	DEP_32("/32x32/chart_organisation.png"),
	ADD_DEP_32("/32x32/chart_organisation_add.png"),
	SUP_DEP_32("/32x32/chart_organisation_delete.png"),

	ADD_32("/32x32/add.png"),
	SUP_32("/32x32/delete.png"),

	CUIVRE_16("/16x16/coin_single_gold.png"),
	ALUMINIUM_16("/16x16/coin_single_silver.png"),
	CUIVRE_32("/32x32/coin_single_gold.png"),
	ALUMINIUM_32("/32x32/coin_single_silver.png"),

	ZOOM_IN_32("/32x32/zoom_in.png"),
	ZOOM_OUT_32("/32x32/zoom_out.png"),
	ZOOM_FIT_32("/32x32/zoom_fit.png"),
	ZOOM_REFR_32("/32x32/zoom_refresh.png"),
	FULLSCREEN_32("/32x32/view_fullscreen_view.png"),
	PANEL_32("/32x32/panel.png"),

	OPEN_DB_32("/32x32/folder_database.png"),
	EDIT_32("/32x32/pencil_ruler.png");
	
	private static String baseUri = "./image/ico";
	
	private String uri;
	
	ImagesGui(String uri){
		this.uri = uri;
	}
	
	public String getUri() {
		return baseUri + this.uri;
	}
	
	public QIcon getIcon() {
		return new QIcon(this.getUri());
	}
}
