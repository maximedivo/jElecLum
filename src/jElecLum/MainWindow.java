/**
 * 
 */
package jElecLum;

import com.trolltech.qt.core.QSize;
import com.trolltech.qt.gui.*;

import jElecLum.controller.AppControler;

/**
 * @author SARPROJA
 *
 */
public class MainWindow extends QMainWindow{
	
	private static final String APP_VERSION = "jElecLum 0.1a";
	QTabWidget graphicTab = new QTabWidget(this);
	AppControler controller = new AppControler(this);
	
	public MainWindow() {
		super();
		this.setDocumentMode(true);
        this.setAcceptDrops(true);
        
        this.graphicTab.setTabsClosable(true);
        this.graphicTab.tabCloseRequested.connect(this, "supprDepart()");
        
        this.setCentralWidget(this.graphicTab);
        
        this.controller.documentChanged.connect(this, "initUi()");
        //this.fileDropped.connect(this, "document.openFile");
        
        this.initDock();
        this.initToolBar();
        this.initUi();
        
        this.showMaximized();
	}

	/**
	 * 
	 */
	private void initDock() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	private void initUi() {
		this.initTitle();
        this.graphicTab.clear();
	}

	/**
	 * 
	 */
	private void initTitle() {
		String name = new String();
		String edited = new String();

        String title = this.controller.getName() + " - " + APP_VERSION;
        this.setWindowTitle(title);
	}

	/**
	 * 
	 */
	private void initToolBar() {
		// TODO Auto-generated method stub
		QAction newAction = new QAction(ImagesGui.FILE_32.getIcon(), "Nouveau", this);
        newAction.setShortcut("Ctrl+N");
        newAction.setStatusTip("Créer un nouveau fichier");
        newAction.triggered.connect(this.getDocument(), "newDocument()");

        QAction openAction = new QAction(ImagesGui.OPEN_32.getIcon(), "Ouvrir", this);
        openAction.setShortcut("Ctrl+O");
        openAction.setStatusTip("Ouvrir un fichier");
        openAction.triggered.connect(this.getDocument(), "openDocument()");

        
        QAction saveAction = new QAction(ImagesGui.DISK_32.getIcon(), "Enregistrer", this);
        saveAction.setShortcut("Ctrl+S");
        saveAction.setStatusTip("Enregistrer le fichier");
        saveAction.triggered.connect(this.getDocument(), "saveDocument()");

        QAction saveAsAction = new QAction(ImagesGui.DISKS_32.getIcon(), "Enregistrer sous...", this);
        saveAsAction.setShortcut("Ctrl+Shift+S");
        saveAsAction.setStatusTip("Enregistrer le fichier sous...");
        saveAsAction.triggered.connect(this.getDocument(), "saveAsDocument()");
        
        QAction addDepartAction = new QAction(ImagesGui.ADD_DEP_32.getIcon(), "Nouveau départ", this);
        addDepartAction.setShortcut("Ctrl+Shift+C");
        addDepartAction.setStatusTip("Créer un nouveau départ sur l\"armoire");
        //addDepartAction.triggered.connect(this, "addDepart()");
        
        QAction redrawAction = new QAction(ImagesGui.ZOOM_REFR_32.getIcon(), "Rafraichir", this);
        redrawAction.setShortcut("Ctrl+R");
        redrawAction.setStatusTip("Rafraichir la zone graphique");
        //redrawAction.triggered.connect(this, "redraw()");
        
        QAction zoomResetAction = new QAction(ImagesGui.ZOOM_FIT_32.getIcon(), "Réinitialiser", this);
        zoomResetAction.setShortcut("R");
        zoomResetAction.setStatusTip("Réinitialiser la vue");
        //zoomResetAction.triggered.connect(this, "zoomReset()");
        
        QAction fullScreenAction = new QAction(ImagesGui.FULLSCREEN_32.getIcon(), "Plein écran", this);
        fullScreenAction.setShortcut("F11");
        fullScreenAction.setStatusTip("Afficher en plein écran");
        //fullScreenAction.triggered.connect(this, "fullScreen()");
        
        QAction showDockAction = new QAction(ImagesGui.PANEL_32.getIcon(), "Afficher panneau d\"édition", this);
        showDockAction.setShortcut("Ctrl+D");
        showDockAction.setStatusTip("Afficher le panneau d\"édition");
        showDockAction.setCheckable(true);
        showDockAction.setChecked(true);
        //showDockAction.triggered.connect(this, "dockShow()");
        //this.propertyDockWidget.visibilityChanged.connect(showDockAction, "setChecked()");
        
        // La barre de menu
        this.statusBar();

        QMenuBar menubar = this.menuBar();
        QMenu fileMenu = menubar.addMenu("&Fichier");
        fileMenu.addAction(newAction);
        fileMenu.addAction(openAction);
        fileMenu.addSeparator();
        fileMenu.addAction(saveAction);
        fileMenu.addAction(saveAsAction);
        
        QMenu editMenu = menubar.addMenu("&Edition");
        editMenu.addSeparator();
        
        QMenu displayMenu = menubar.addMenu("&Affichage");
        displayMenu.addAction(fullScreenAction);
        displayMenu.addSeparator();
        displayMenu.addAction(showDockAction);
        displayMenu.addSeparator();
        displayMenu.addAction(redrawAction);
        displayMenu.addAction(zoomResetAction);
        
        QMenu insertMenu = menubar.addMenu("&Insertion");
        insertMenu.addAction(addDepartAction);
        insertMenu.addSeparator();
        
        // La barre outils
        QToolBar toolbar = this.addToolBar("Fichier");
        toolbar.setIconSize(new QSize(32, 32));
        toolbar.addAction(newAction);
        toolbar.addAction(openAction);
        toolbar.addAction(saveAction);
        toolbar.addAction(saveAsAction);
        toolbar.addSeparator();
        
        toolbar = this.addToolBar("Edition");
        toolbar.setIconSize(new QSize(32, 32));
        toolbar.addAction(addDepartAction);
        toolbar.addSeparator();
	}

	/**
	 * @return
	 */
	private AppControler getDocument() {
		return this.controller;
	}

	/**
	 * @return
	 */
	private AbstractSignal supprDepart() {
		// TODO Auto-generated method stub
		return null;
	}
}
