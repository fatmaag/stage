import javax.swing.JPanel;
import java.awt.BorderLayout;


public class PanelPrincipal extends JPanel{

   
    public PanelPrincipal(FenetrePrincipale _fenetrePrincipale, Etat _etat){
	super(new BorderLayout());
	etat = _etat;

	barreOutils = new BarreOutils(this, etat);
	tabbedPaneDessin = new TabbedPaneDessin(this, etat);

	fenetrePrincipale = _fenetrePrincipale;
	fenetrePrincipale.getContentPane().add(this);
    }

    // Fenetre Principale contenant le panel principal
    private FenetrePrincipale fenetrePrincipale;

    public FenetrePrincipale getFenetrePrincipale(){
	return fenetrePrincipale;
    }

    private BarreOutils barreOutils;

    
    public BarreOutils getBarreOutils(){
	return barreOutils;
    }

    private Etat etat;

    private TabbedPaneDessin tabbedPaneDessin;

    
    public TabbedPaneDessin getTabbedPaneDessin(){
	return tabbedPaneDessin;
    }
}
