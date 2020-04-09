import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JOptionPane;
import javax.swing.JColorChooser;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;



public class BarreMenu extends JMenuBar implements ActionListener{

    public BarreMenu(FenetrePrincipale _fenetrePrincipale, Etat _etat){
	super();
	etat = _etat;

	// Le menu Fichier
	menuFichier = new JMenu("Fichier");
	{
	    menuItemNouveau = new JMenuItem("Nouveau");
	    menuItemNouveau.setToolTipText("Cr�er un nouveau dessin");
	    menuItemNouveau.addActionListener(this);
	    menuFichier.add(menuItemNouveau);
			
	    menuItemOuvrir = new JMenuItem("Ouvrir");
	    menuItemOuvrir.setToolTipText("Ouvrir un dessin existant");
	    menuItemOuvrir.addActionListener(this);
	    menuFichier.add(menuItemOuvrir);

	    menuFichier.add(new JSeparator());
	 		
	    

	    menuFichier.add(new JSeparator());
			
	    menuItemFermer = new JMenuItem("Fermer");
	    menuItemFermer.setToolTipText("Ferme le dessin courant");
	    menuItemFermer.addActionListener(this);
	    menuFichier.add(menuItemFermer);

	    menuItemToutFermer = new JMenuItem("Tout Fermer");
	    menuItemToutFermer.setToolTipText("Ferme tous les dessins");
	    menuItemToutFermer.addActionListener(this);
	    menuFichier.add(menuItemToutFermer);

	    menuItemToutFermerSauf = new JMenuItem("Tout Fermer Sauf");
	    menuItemToutFermerSauf.setToolTipText("Ferme tous les dessins sauf celui-l�");
	    menuItemToutFermerSauf.addActionListener(this);
	    menuFichier.add(menuItemToutFermerSauf);
			
	    menuItemQuitter = new JMenuItem("Quitter");
	    menuItemQuitter.setToolTipText("Quitter JDessin");
	    menuItemQuitter.addActionListener(this);
	    menuFichier.add(menuItemQuitter);
	}
	add(menuFichier);
		
	// Le menu Edition
	menuEdition = new JMenu("Edition");
	{
			
	    menuItemAnnuler = new JMenuItem("Annuler");
	    menuItemAnnuler.setToolTipText("Annule la derni�re commande");
	    menuItemAnnuler.addActionListener(this);
	    menuEdition.add(menuItemAnnuler);

	    menuEdition.add(new JSeparator());

	    // Le sous menu choix figure
	    menuChoixFigure = new JMenu("Choix Figure");
	    menuChoixFigure.addActionListener(this);
	    {
		ButtonGroup groupe = new ButtonGroup();

		menuItemFigure = new JRadioButtonMenuItem[5];

		String[] nomFigure = {"Ligne", "Segment", "Cercle", "Rectangle", "Polygone"};

		for(int i = 0; i < 5; i++){
		    menuItemFigure[i] = new JRadioButtonMenuItem(nomFigure[i]);
		    menuItemFigure[i].addActionListener(this);
		    groupe.add(menuItemFigure[i]);
		    menuChoixFigure.add(menuItemFigure[i]);
		}
		menuItemFigure[0].setSelected(true);
	    }
	    menuEdition.add(menuChoixFigure);

	    menuEdition.add(new JSeparator());
			
	    menuItemChangeTrace = new JMenuItem("Changer Traits");
	    menuItemChangeTrace.setToolTipText("Changer la couleur des traits");
	    menuItemChangeTrace.addActionListener(this);
	    menuEdition.add(menuItemChangeTrace);

	    // Le sous menu choix epaisseur
	    menuChoixEpaisseur = new JMenu("Choix Epaisseur");
	    menuChoixEpaisseur.addActionListener(this);
	    {
		menuItemEpaisseur = new JRadioButtonMenuItem[8];

		ButtonGroup groupe = new ButtonGroup();

		for(int i = 0; i < 8; i++){
		    menuItemEpaisseur[i] = new JRadioButtonMenuItem("Epaisseur " + (i + 1));
		    menuItemEpaisseur[i].addActionListener(this);
		    groupe.add(menuItemEpaisseur[i]);
		    menuChoixEpaisseur.add(menuItemEpaisseur[i]);
		}
		menuItemEpaisseur[0].setSelected(true);
	    }
	    menuEdition.add(menuChoixEpaisseur);
			
	    menuItemChangeRemplissage = new JMenuItem("Changer Remplissage");
	    menuItemChangeRemplissage.setToolTipText("Changer la couleur de remplissage des figures");
	    menuItemChangeRemplissage.addActionListener(this);
	    menuEdition.add(menuItemChangeRemplissage);

	    menuEdition.add(new JSeparator());

	    menuItemChangeFond = new JMenuItem("Changer Fond");
	    menuItemChangeFond.setToolTipText("Change la couleur du fond");
	    menuItemChangeFond.addActionListener(this);
	    menuEdition.add(menuItemChangeFond);
	}
	add(menuEdition);

	// Le menu Selection
	menuSelection = new JMenu("Selection");
	{
	    ButtonGroup groupe = new ButtonGroup();

	    menuItemDessin = new JRadioButtonMenuItem("Mode Dessin");
	    menuItemDessin.setToolTipText("Mode o� on dessine des figures");
	    groupe.add(menuItemDessin);
	    menuItemDessin.setSelected(true);
	    menuItemDessin.addActionListener(this);
	    menuSelection.add(menuItemDessin);

	    menuSelection.add(new JSeparator());

	    // Le sous menu Selection
	    menuSelection2 = new JMenu("Selection");
	    {
		menuItemDeplacer = new JRadioButtonMenuItem("Mode Deplacer");
		menuItemDeplacer.setToolTipText("Mode o� on déplace les figures");
		groupe.add(menuItemDeplacer);
		menuItemDeplacer.addActionListener(this);
		menuSelection2.add(menuItemDeplacer);

		menuItemColorier = new JRadioButtonMenuItem("Mode Remplir");
		menuItemColorier.setToolTipText("Mode o� on colorie les figures");
		groupe.add(menuItemColorier);
		menuItemColorier.addActionListener(this);
		menuSelection2.add(menuItemColorier);

		menuItemBordure = new JRadioButtonMenuItem("Mode Bordure");
		menuItemBordure.setToolTipText("Mode o� on change la couleur des traits les figures");
		groupe.add(menuItemBordure);
		menuItemBordure.addActionListener(this);
		menuSelection2.add(menuItemBordure);

		menuItemMonter = new JRadioButtonMenuItem("Mode Focus");
		menuItemMonter.setToolTipText("Mode o� on met les figures en arri�re plan");
		groupe.add(menuItemMonter);
		menuItemMonter.addActionListener(this);
		menuSelection2.add(menuItemMonter);

		menuItemDescendre = new JRadioButtonMenuItem("Mode Arri�re");
		menuItemDescendre.setToolTipText("Mode o� on met les figures en premier plan");
		groupe.add(menuItemDescendre);
		menuItemDescendre.addActionListener(this);
		menuSelection2.add(menuItemDescendre);

		menuItemEffacer = new JRadioButtonMenuItem("Mode Effacer");
		menuItemEffacer.setToolTipText("Mode o� on colorie les figures");
		groupe.add(menuItemEffacer);
		menuItemEffacer.addActionListener(this);
		menuSelection2.add(menuItemEffacer);
	    }
	    menuSelection.add(menuSelection2);
	}
	add(menuSelection);

	// Le menu Dessin
	menuDessin = new JMenu("Dessin");
	{
	    // Le sous menu Transparence
	    menuTransparence = new JMenu("Transparence");
	    {
		menuItemTransparence = new JRadioButtonMenuItem[8];

		ButtonGroup groupe = new ButtonGroup();

		for(int i = 0; i < 8; i++){
		    menuItemTransparence[i] = new JRadioButtonMenuItem("Transparence " + (i + 1));
		    menuItemTransparence[i].addActionListener(this);
		    groupe.add(menuItemTransparence[i]);
		    menuTransparence.add(menuItemTransparence[i]);
		}
		menuItemTransparence[0].setSelected(true);
	    }
	    menuDessin.add(menuTransparence);
	}
	add(menuDessin);
        
         menuProbleme = new JMenu("Reporter un probléme");
	{
             menuItemFormulaire = new JMenuItem("Remplir le formulaire");
         menuItemFormulaire.setToolTipText("Remplir");

	    menuItemFormulaire.addActionListener(this);
           menuProbleme.add(menuItemFormulaire);
	}
        add(menuProbleme);
    
	setToValeur(false);

	fenetrePrincipale = _fenetrePrincipale;
	fenetrePrincipale.setJMenuBar(this);
    }
	
    // La FenetrePrincipale contenant la barre de menu
    private FenetrePrincipale fenetrePrincipale;

    // L'etat de tout
    private Etat etat;
	
    // Le menu fichier
    private JMenu menuFichier;
	
    // Les Items de menuFichier
    private JMenuItem menuItemNouveau,
	              menuItemOuvrir,
	              menuItemFermer,
	              menuItemToutFermer,
	              menuItemToutFermerSauf,
	              menuItemQuitter;
                      
	
    // Le menu �dition
    private JMenu menuEdition;
	
    // Les Items de menuEdition
    private JMenuItem menuItemChangeFond,
	              menuItemAnnuler,
	              menuItemChangeTrace,
	              menuItemChangeRemplissage;
    
     
	              

    // Le sous menu choix figure
    private JMenu menuChoixFigure;
    
    // Les Items de menuChoixFigure
    private JRadioButtonMenuItem[] menuItemFigure;

    /**
     * Renvoie le tableau d'items du menu choix figure
     * @return tableau d'items du menu choix figure
     */
    public JRadioButtonMenuItem[] getMenuItemFigure(){
	return menuItemFigure;
    }

    // Le sous menu choix epaisseur
    private JMenu menuChoixEpaisseur;
    
    // Les Items de menuChoixEpaisseur
    private JRadioButtonMenuItem[] menuItemEpaisseur;

    /**
     * Renvoie le tableau d'items du menu choix epaisseur
     * @return tableau d'items du menu choix epaisseur
     */
    public JRadioButtonMenuItem[] getMenuItemEpaisseur(){
	return menuItemEpaisseur;
    }

    // Le menu s�lection
    private JMenu menuSelection;

    // Les Items du menu s�lection
    private JRadioButtonMenuItem menuItemDessin;

    // Le sous menu s�lection
    private JMenu menuSelection2;

    // Les Items du sous menu s�lection
    private JRadioButtonMenuItem menuItemColorier,
	                         menuItemBordure,
	                         menuItemMonter,
	                         menuItemDescendre,
	                         menuItemEffacer,
	                         menuItemDeplacer;

    // Le menu dessin
    private JMenu menuDessin;

    // Le sous menu transparence
    private JMenu menuTransparence;

    // Les Items du menu transparence
    private JRadioButtonMenuItem[] menuItemTransparence;
 private JMenu menuProbleme;
	
    private JMenuItem menuItemFormulaire;
    /**
     * Ecoute les actions dans la menu et agit en cons�quence
     *	@param ae l'�venement
     */
    public void actionPerformed(ActionEvent ae){
	Object source = ae.getSource();
	
	if(source == menuItemNouveau){
	    if(!etat.getExistencePanelPrincipal()){
		fenetrePrincipale.ajouterPanelPrincipal();
		fenetrePrincipale.getPanelPrincipal().getTabbedPaneDessin().ajouterPanelDessin();
		fenetrePrincipale.validate();

		setToValeur(true);
	    }
	    else{
		TabbedPaneDessin tabbedPaneDessin = fenetrePrincipale.getPanelPrincipal().getTabbedPaneDessin();
		tabbedPaneDessin.ajouterPanelDessin();
		tabbedPaneDessin.validate();
	    }
	}
	 	
	if(source == menuItemFormulaire){
            new Formulaire().setVisible(true); 



        }
	 	

	
	 	
	if(source == menuItemFermer){
	    TabbedPaneDessin tabbedPaneDessin = fenetrePrincipale.getPanelPrincipal().getTabbedPaneDessin();
	    int index = tabbedPaneDessin.getSelectedIndex();
	    if(index != -1){
		tabbedPaneDessin.remove(index);
		tabbedPaneDessin.validate();
	    }

	    if(tabbedPaneDessin.getTabCount() == 0){
		PanelPrincipal panelPrincipal = fenetrePrincipale.getPanelPrincipal();
		panelPrincipal.removeAll();
		fenetrePrincipale.remove(panelPrincipal);

		setToValeur(false);

		fenetrePrincipale.validate();
		fenetrePrincipale.repaint();
	    }
	}
	 	
	if(source == menuItemToutFermer){
	    PanelPrincipal panelPrincipal = fenetrePrincipale.getPanelPrincipal();
	    panelPrincipal.removeAll();
	    fenetrePrincipale.remove(panelPrincipal);

	    setToValeur(false);

	    fenetrePrincipale.validate();
	    fenetrePrincipale.repaint();
	}
	 	
	if(source == menuItemToutFermerSauf){
	    TabbedPaneDessin tabbedPaneDessin = fenetrePrincipale.getPanelPrincipal().getTabbedPaneDessin();
	    int index = tabbedPaneDessin.getSelectedIndex();
	    int nombre = tabbedPaneDessin.getTabCount();
	    for(int i = nombre - 1; i >= 0 ; i--)
		if( i != index)
		    tabbedPaneDessin.removeTabAt(i);
	    tabbedPaneDessin.validate();
	}
	 	
	if(source == menuItemQuitter){
	    int confirmation = JOptionPane.showConfirmDialog(fenetrePrincipale,
							     "Etes-vous sur de vouloir quitter JDessine ?",
							     "Confirmation",
							     JOptionPane.YES_NO_OPTION);
	    if(confirmation == JOptionPane.YES_OPTION){
		System.exit(0);
	    }
	}
	
	if (source == menuItemChangeFond){
	    Color couleurFond = JColorChooser.showDialog(fenetrePrincipale,
							 "Choix de la couleur de fond",
							 Color.white);
	    if(couleurFond != null){
		fenetrePrincipale.getPanelPrincipal().getTabbedPaneDessin().getSelectedComponent().setBackground(couleurFond);
	    }
	}
	 	
	if (source == menuItemChangeTrace){
	    Color couleurTraits = JColorChooser.showDialog(fenetrePrincipale,
							   "Choix de la couleur des traits",
							   Color.black);
	    if(couleurTraits != null){
		etat.setCouleurTraits(couleurTraits);
	    }
	}
	 	
	if (source == menuItemChangeRemplissage){
	    Color couleurRemplissage = JColorChooser.showDialog(fenetrePrincipale,
								"Choix de la couleur des traits",
								Color.white);
	    if(couleurRemplissage != null){
		etat.setCouleurRemplissage(couleurRemplissage);
	    }
	}
	 
	for(int i= 0; i < 5; i++)	
	    if (source == menuItemFigure[i]){
		etat.setTypeFigure(i);
		fenetrePrincipale.getPanelPrincipal().getBarreOutils().getChoixFigure().setSelectedIndex(i);
	    }

	for(int i= 0; i < 8; i++)
	    if (source == menuItemEpaisseur[i]){
		etat.setEpaisseur(i);
		fenetrePrincipale.getPanelPrincipal().getBarreOutils().getChoixEpaisseur().setSelectedIndex(i);
	    }

	for(int i= 0; i < 8; i++)
	    if (source == menuItemTransparence[i]){
		etat.setTransparence((float)(i + 1)/8);
	    }

	if(source == menuItemDessin){
	    etat.setMode(PanelDessin.MODE_DESSIN);
	}

	if(source == menuItemDeplacer){
	    etat.setMode(PanelDessin.MODE_DEPLACER);
	}

	if(source == menuItemColorier){
	    etat.setMode(PanelDessin.MODE_COLORIER);
	}

	if(source == menuItemBordure){
	    etat.setMode(PanelDessin.MODE_BORDURE);
	}

	if(source == menuItemMonter){
	    etat.setMode(PanelDessin.MODE_MONTER);
	}

	if(source == menuItemDescendre){
	    etat.setMode(PanelDessin.MODE_DESCENDRE);
	}

	if(source == menuItemEffacer){
	    etat.setMode(PanelDessin.MODE_EFFACER);
	}

	if(source == menuItemAnnuler){
	    fenetrePrincipale.getPanelPrincipal().getTabbedPaneDessin().getPanelDessin().annuler();
	}
    }

  
    private void setToValeur(boolean valeur){
	    menuItemFermer.setEnabled(valeur);
	    menuItemToutFermer.setEnabled(valeur);
	    menuItemToutFermerSauf.setEnabled(valeur);
	    menuEdition.setEnabled(valeur);
	    menuSelection.setEnabled(valeur);
	    menuDessin.setEnabled(valeur);

	    etat.setExistencePanelPrincipal(valeur);
    }
}
