import javax.swing.JTabbedPane;
import java.awt.BorderLayout;


public class TabbedPaneDessin extends JTabbedPane{

    
    public TabbedPaneDessin(PanelPrincipal _panelPrincipal, Etat _etat){
	super();
	etat = _etat;

	panelPrincipal = _panelPrincipal;
	panelPrincipal.add(this, BorderLayout.CENTER);
    }

    private PanelPrincipal panelPrincipal;

    private Etat etat;

    
    public void ajouterPanelDessin(){
	PanelDessin panelDessin = new PanelDessin(this, etat);
    }

    
    public PanelDessin getPanelDessin(){
	return (PanelDessin)getSelectedComponent();
    }
}
