import javax.swing.JFrame;
import javax.swing.JWindow;

public class FenetrePrincipale extends JFrame{
	
    /**
     * Cr�e une FenetrePrincipale avec le titre sp�cifi�
     * @param titre titre de la fenetre
     */
    public FenetrePrincipale(String titre){
	super(titre);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	etat = new Etat();
	barreMenu = new BarreMenu(this, etat);

	pack();
	setExtendedState(MAXIMIZED_BOTH);
	setVisible(true);

	(new JWindow(this)).setVisible(true);
    }
	
    // Le panel principal de la fenetre
    private PanelPrincipal panelPrincipal;
	
    /**
     * Renvoie le panel principal de la fenetre
     * @return le panel principal
     */
    public PanelPrincipal getPanelPrincipal(){
	return panelPrincipal;
    }
	
    /**
     * Ajoute un panel nouveau
     */
    public void ajouterPanelPrincipal(){
	panelPrincipal = new PanelPrincipal(this, etat);
    }
	
    // Le barre menu de la fenetre principale
    private BarreMenu barreMenu;

    /**
     * Renvoie le barre menu de la fenetre principale
     * @return le barre menu
     */
    public BarreMenu getBarreMenu(){
	return barreMenu;
    }

    // L'etat de tout
    private Etat etat;
}
