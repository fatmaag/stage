import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JColorChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;


public class BarreOutils extends JToolBar implements ActionListener{
	
    /**
     * Cr�e une BarreOutils
     * @param _panelPrincipal panel contenant le boite action
     * @param _etat etat de tout
     */
    public BarreOutils(PanelPrincipal _panelPrincipal, Etat _etat){
	super(JToolBar.HORIZONTAL);
	etat = _etat;
		
	boutonNouveau = new JButton("Nouveau");
	boutonNouveau.setToolTipText("Cr�er un nouveau dessin");
	boutonNouveau.addActionListener(this);
	add(boutonNouveau);
		
	boutonOuvrir = new JButton("Ouvrir");
	boutonOuvrir.setToolTipText("Ouvrir un dessin existant");
	boutonOuvrir.addActionListener(this);
	add(boutonOuvrir);
		
	
	
	choixFigure = new JComboBox(new String[]{"Ligne",
						 "Segment",
						 "Cercle",
						 "Rectangle",
						 "Polygone"});;
	choixFigure.addActionListener(this);
	add(choixFigure);
	
	boutonCouleurTraits = new JButton("Couleur Traits");
	add(boutonCouleurTraits);
	boutonCouleurTraits.setToolTipText("Change la couleur des traits");
	boutonCouleurTraits.addActionListener(this);
	add(boutonCouleurTraits);
	
	choixEpaisseur = new JComboBox(new String[]{"Epaisseur 1",
						    "Epaisseur 2",
						    "Epaisseur 3",
						    "Epaisseur 4",
						    "Epaisseur 5",
						    "Epaisseur 6",
						    "Epaisseur 7",
						    "Epaisseur 8"});;
	choixEpaisseur.addActionListener(this);
	add(choixEpaisseur);
		
	boutonCouleurRemplissage = new JButton("Couleur Remplissage");
	add(boutonCouleurRemplissage);
	boutonCouleurRemplissage.setToolTipText("Change la couleur du remplissage");
	boutonCouleurRemplissage.addActionListener(this);
	add(boutonCouleurRemplissage);
		
	boutonQuitter = new JButton("Quitter");
	boutonQuitter.setToolTipText("Quitter JavaDessin");
	boutonQuitter.addActionListener(this);
	add(boutonQuitter);

	panelPrincipal = _panelPrincipal;
	panelPrincipal.add(this, BorderLayout.NORTH);
    }

    // le Panel Principal contenant la Barre Outils
    private PanelPrincipal panelPrincipal;

    // L'etat de tout
    private Etat etat;
	
    // les boutons de la boite action
    private JButton boutonNouveau,
	            boutonOuvrir,
	            boutonCouleurTraits,
	            boutonCouleurRemplissage,
	            boutonQuitter;
    
    private JComboBox choixFigure;

    /**
     * Renvoie la JComboBox choixFigure
     */
    public JComboBox getChoixFigure(){
	return choixFigure;
    }
    
    // Combo box d�finissant le choix de l'�paisseur des traits
    private JComboBox choixEpaisseur;

    /**
     * Renvoie la JComboBox choixEpaisseur
     */
    public JComboBox getChoixEpaisseur(){
	return choixEpaisseur;
    }
					
    
    public void actionPerformed(ActionEvent ae){
	Object source = ae.getSource();
		
	if (source == boutonNouveau){
	    panelPrincipal.getTabbedPaneDessin().ajouterPanelDessin();
	    panelPrincipal.getTabbedPaneDessin().validate();
	}
	
	if (source == boutonCouleurTraits){
	    Color couleurTraits = JColorChooser.showDialog(panelPrincipal.getFenetrePrincipale(),
							   "Choix de la couleur des traits",
							   Color.black);
	    if(couleurTraits != null){
		etat.setCouleurTraits(couleurTraits);
	    }
	}
		
	if (source == boutonCouleurRemplissage){
	    Color couleurRemplissage = JColorChooser.showDialog(panelPrincipal.getFenetrePrincipale(),
								"Choix de la couleur des traits",
								Color.white);
	    if(couleurRemplissage != null){
		etat.setCouleurRemplissage(couleurRemplissage);
	    }
	}
	
	if (source == boutonOuvrir){
	}
		
	
		
	if (source == choixFigure){
	    int index = choixFigure.getSelectedIndex();
	    etat.setTypeFigure(index);
	    panelPrincipal.getFenetrePrincipale().getBarreMenu().getMenuItemFigure()[index].setSelected(true);
	}
		
	if (source == choixEpaisseur){
	    int index = choixEpaisseur.getSelectedIndex();
	    etat.setEpaisseur(index + 1);
	    panelPrincipal.getFenetrePrincipale().getBarreMenu().getMenuItemEpaisseur()[index].setSelected(true);
	}
		
	if (source == boutonQuitter){
	    int confirmation = JOptionPane.showConfirmDialog(panelPrincipal.getFenetrePrincipale(),
							   "Etes-vous sur(e) de vouloir quitter JDessin ?",
							   "Confirmation",
							   JOptionPane.YES_NO_OPTION);
	    if( confirmation == JOptionPane.YES_OPTION)
		System.exit(0);
	}
    }
}
