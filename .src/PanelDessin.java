import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.BasicStroke;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.InputEvent;
import java.util.Vector;
import java.util.Stack;
import java.awt.AlphaComposite;


public class PanelDessin extends JPanel implements MouseListener, MouseMotionListener{
	
   
    public PanelDessin(TabbedPaneDessin _tabbedPaneDessin, Etat _etat){
	super();
	etat = _etat;
	setBackground(Color.white);

	addMouseListener(this);
	addMouseMotionListener(this);

	compteur++;
	numero = compteur;

	nom = "Dessin " + numero;

	liste = new Vector();

	figures = new Figures();

	commandes = new Stack();

	tabbedPaneDessin = _tabbedPaneDessin;
	tabbedPaneDessin.addTab(nom, this);
    }

    // TabbedPaneDessin contenant le panel dessin
    TabbedPaneDessin tabbedPaneDessin;

    // L'etat de tout
    private Etat etat;

    // Compteur des PanelDessin
    private static int compteur = 0;

    // Num�ro du panel dessin
    private int numero;

    // Nom du panel dessin
    private String nom;

    // Liste de points � tracer
    private Vector liste;

    // L'ensemble des figures dessin�es
    private Figures figures;

    // La pile des commandes effecctu�e
    private Stack commandes;

    /**
     * Renvoie la pile de commandes
     */
    public Stack getCommandes(){
	return commandes;
    } 

    // mode ligne
    public static final int MODE_LIGNE = 0;

    // mode segment
    public static final int MODE_SEGMENT = 1;

    // mode cercle
    public static final int MODE_CERCLE = 2;

    // mode rectangle
    public static final int MODE_RECTANGLE = 3;

    // mode polygone
    public static final int MODE_POLYGONE = 4;

    // mode dessin
    public static final int MODE_DESSIN = 0;

    // mode s�lection
    public static final int MODE_DEPLACER = 1;

    // mode colorier
    public static final int MODE_COLORIER = 2;

    // mode remplir
    public static final int MODE_REMPLIR = 3;

    // mode bordure
    public static final int MODE_BORDURE = 4;

    // mode effacer
    public static final int MODE_EFFACER = 5;

    // mode monter
    public static final int MODE_MONTER = 6;

    // mode descendre
    public static final int MODE_DESCENDRE = 7;

    /**
     * Annule la derni�re commande
     */
    public void annuler(){
	if(!commandes.empty()){
	    Commande commande = (Commande)commandes.pop();
	    int type = commande.getType();
	    if(type == MODE_DESSIN){
		figures.remove(commande.getFigure());
	    }
	    
	    if(type == MODE_EFFACER){
		figures.add(commande.getFigure());
	    }
	    
	    if(type == MODE_COLORIER){
		((Dessinable)commande.getFigure()).setCouleurRemplissage(commande.getCouleur());
	    }
	    repaint();
	}
    }

    // figure selectionn�e
    private Dessinable figureSelectionnee;

    // si une figure est s�lectionn�e
    private boolean selection;

    /**
     * M�thode appel�e pour dessiner
     * @param g interface graphique
     */
    public void paintComponent(Graphics g){
	Graphics2D g2d =(Graphics2D)g;
	super.paintComponent(g2d);
	g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, etat.getTransparence()));
	figures.dessiner(g2d);
    }

    /**
     * M�thode appel�e lorsque un bouton de la souris est appuy�
     * @param me l'�venement
     */
    public void mousePressed(MouseEvent me){

	if(etat.getMode() == MODE_DESSIN){
	    if((me.getModifiers() & InputEvent.BUTTON1_MASK) != 0){
		if(etat.getTypeFigure() != MODE_POLYGONE){
		    liste.add(new Point2D.Double(me.getX(), me.getY()));
		}
	    }
	}

	if(etat.getMode() == MODE_DEPLACER){
	    if((me.getModifiers() & InputEvent.BUTTON1_MASK) != 0){
		if(!selection){
		    Point2D point = new Point2D.Double(me.getX(), me.getY());
		    figureSelectionnee = figures.contient(point);
		    if(figureSelectionnee != null){
			liste.add(point);
			selection = true;
		    }
		}
	    }
	}
    }
	
    /**
     * M�thode appel�e lorsque un bouton de la souris est relach�
     * @param me l'�venement
     */
    public void mouseReleased(MouseEvent me){

	if(etat.getMode() == MODE_DESSIN){

	    if((me.getModifiers() & InputEvent.BUTTON1_MASK) != 0){

		if(etat.getTypeFigure() == MODE_LIGNE){
		    Ligne ligne = new Ligne(liste, etat.getCouleurTraits(), etat.getEpaisseur());
		    figures.add(ligne);
		    commandes.push(new Commande(MODE_DESSIN, ligne));
		    liste.clear();
		    repaint();
		}

		if(etat.getTypeFigure() == MODE_SEGMENT){
		    Point2D point1 = (Point2D)liste.lastElement();
		    Point2D point2 = new Point2D.Double(me.getX(), me.getY());
		    Segment segment = new Segment(point1, point2, etat.getCouleurTraits(), etat.getEpaisseur());
		    figures.add(segment);
		    commandes.push(new Commande(MODE_DESSIN, segment));
		    liste.clear();
		    repaint();
		}

		if(etat.getTypeFigure() == MODE_CERCLE){
		    Point2D point1 = (Point2D)liste.firstElement();
		    Point2D point2 = new Point2D.Double(me.getX(), me.getY());
		    Cercle cercle = new Cercle(point1, point2, etat.getCouleurTraits(), etat.getEpaisseur(), etat.getCouleurRemplissage());
		    figures.add(cercle);
		    commandes.push(new Commande(MODE_DESSIN, cercle));
		    liste.clear();
		    repaint();
		}

		if(etat.getTypeFigure() == MODE_RECTANGLE){
		    Point2D point1 = (Point2D)liste.lastElement();
		    Point2D point2 = new Point2D.Double(me.getX(), me.getY());
		    Rectangle rectangle = new Rectangle(point1, point2, etat.getCouleurTraits(), etat.getEpaisseur(), etat.getCouleurRemplissage());
		    figures.add(rectangle);
		    commandes.push(new Commande(MODE_DESSIN, rectangle));
		    liste.clear();
		    repaint();
		}
	    }
	}

	if(etat.getMode() == MODE_DEPLACER){
	    if((me.getModifiers() & InputEvent.BUTTON1_MASK) != 0){
		if(selection){
		    selection = false;
		    commandes.push(new Commande(MODE_DESSIN, figureSelectionnee));
		    liste.clear();
		}
	    }
	}
    }
	
    /**
     * M�thode appel�e lorsque un bouton de la souris est click�
     * @param me l'�venement
     */
    public void mouseClicked(MouseEvent me){

	if(etat.getMode() == MODE_DESSIN){

	    if((me.getModifiers() & InputEvent.BUTTON1_MASK) != 0){

		if(etat.getTypeFigure() == MODE_POLYGONE){
		    if(liste.size() < 1){
			liste.add(new Point2D.Double(me.getX(), me.getY()));
		    }

		    else{
			Point2D point1 = (Point2D)liste.lastElement();
			Point2D point2 = new Point2D.Double(me.getX(), me.getY());
			liste.add(point2);
			Segment segment = new Segment(point1, point2, etat.getCouleurTraits(), etat.getEpaisseur());
		    
			Graphics g = getGraphics();
			segment.dessiner(g);
			g.dispose();
		    }
                    
		}
	    }

	    if((me.getModifiers() & InputEvent.BUTTON3_MASK) != 0){

		if(etat.getTypeFigure() == MODE_POLYGONE){
		    Polygone polygone = new Polygone(liste, etat.getCouleurTraits(), etat.getEpaisseur(), etat.getCouleurRemplissage());
		    figures.add(polygone);
		    commandes.push(new Commande(MODE_DESSIN, polygone));
		    repaint();
		    liste.clear();
		}
	    }
	}

	if(etat.getMode() == MODE_COLORIER){
	    if((me.getModifiers() & InputEvent.BUTTON1_MASK) != 0){
		Point2D point = new Point2D.Double(me.getX(), me.getY());
		figureSelectionnee = figures.contient(point);
		if(figureSelectionnee != null){
		    commandes.push(new Commande(MODE_COLORIER, figureSelectionnee, figureSelectionnee.getCouleurRemplissage()));
		    figureSelectionnee.setCouleurRemplissage(etat.getCouleurRemplissage());
		    repaint();
		}
	    }
	}
	
	if(etat.getMode() == MODE_BORDURE){
	    if((me.getModifiers() & InputEvent.BUTTON1_MASK) != 0){
		Point2D point = new Point2D.Double(me.getX(), me.getY());
		figureSelectionnee = figures.contient(point);
		if(figureSelectionnee != null){
		    commandes.push(new Commande(MODE_COLORIER, figureSelectionnee, etat.getCouleurTraits()));
		    figureSelectionnee.setCouleurTraits(etat.getCouleurTraits());
		    repaint();
		}
	    }
	}

	if(etat.getMode() == MODE_EFFACER){
	    if((me.getModifiers() & InputEvent.BUTTON1_MASK) != 0){
		Point2D point = new Point2D.Double(me.getX(), me.getY());
		figureSelectionnee = figures.contient(point);
		if(figureSelectionnee != null){
		    commandes.push(new Commande(MODE_EFFACER, figureSelectionnee));
		    figures.remove(figureSelectionnee);
		    repaint();
		}
	    }
	}

	if(etat.getMode() == MODE_MONTER){
	    if((me.getModifiers() & InputEvent.BUTTON1_MASK) != 0){
		Point2D point = new Point2D.Double(me.getX(), me.getY());
		figureSelectionnee = figures.contient(point);
		if(figureSelectionnee != null){
		    commandes.push(new Commande(MODE_COLORIER, figures.size() - 1));
		    figures.remove(figureSelectionnee);
		    figures.add(figureSelectionnee);
		    repaint();
		}
	    }
	}

	if(etat.getMode() == MODE_DESCENDRE){
	    if((me.getModifiers() & InputEvent.BUTTON1_MASK) != 0){
		Point2D point = new Point2D.Double(me.getX(), me.getY());
		figureSelectionnee = figures.contient(point);
		if(figureSelectionnee != null){
		    commandes.push(new Commande(MODE_COLORIER, figures.size() - 1));
		    figures.remove(figureSelectionnee);
		    figures.add(0,figureSelectionnee);
		    repaint();
		}
	    }
	}
    }
		
    /**
     * M�thode appel�e lorsque le pointeur penetre dans l'objet
     * @param me l'�venement
     */
    public void mouseEntered(MouseEvent me){
    }
    	
    /**
     * M�thode appel�e lorsque le pointeur quitte l'objet
     * @param me l'�venement
     */
    public void mouseExited(MouseEvent me){
    }
    	
    /**
     * M�thode appel�e lorsque le pointeur se d�place dans l'objet sans
     * bouton enfonc�
     * @param me l'�venement
     */
    public void mouseMoved(MouseEvent me){
    }
    
    /**
     * M�thode appel�e lorsque le pointeur se d�place dans l'objet avec
     * bouton enfonc�
     */
    public void mouseDragged(MouseEvent me){

	if(etat.getMode() == MODE_DESSIN){

	    if((me.getModifiers() & InputEvent.BUTTON1_MASK) != 0){
		
		if(etat.getTypeFigure() == MODE_LIGNE){
		    Point2D point1 = (Point2D)liste.lastElement();
		    Point2D point2 = new Point2D.Double(me.getX(), me.getY());
		    liste.add(point2);
		    
		    Segment segment = new Segment(point1, point2, etat.getCouleurTraits(), etat.getEpaisseur());
		    Graphics g = getGraphics();
		    segment.dessiner(g);
		    g.dispose();
		}

		if(etat.getTypeFigure() == MODE_SEGMENT){
		    Point2D point1 = (Point2D)liste.lastElement();
		    Point2D point2 = new Point2D.Double(me.getX(), me.getY());
		    Segment segment = new Segment(point1, point2, etat.getCouleurTraits(), etat.getEpaisseur());

		    Graphics g = getGraphics();
		    repaint();
		    segment.dessiner(g);
		    g.dispose();
		}

		if(etat.getTypeFigure() == MODE_CERCLE){
		    Point2D point1 = (Point2D)liste.lastElement();
		    Point2D point2 = new Point2D.Double(me.getX(), me.getY());
		    Cercle cercle = new Cercle(point1, point2, etat.getCouleurTraits(), etat.getEpaisseur(), etat.getCouleurRemplissage());

		    Graphics g = getGraphics();
		    repaint();
		    cercle.dessiner(g);
		    g.dispose();
		}

		if(etat.getTypeFigure() == MODE_RECTANGLE){
		    Point2D point1 = (Point2D)liste.lastElement();
		    Point2D point2 = new Point2D.Double(me.getX(), me.getY());
		    Rectangle rectangle = new Rectangle(point1, point2, etat.getCouleurTraits(), etat.getEpaisseur(), etat.getCouleurRemplissage());

		    Graphics g = getGraphics();
		    repaint();
		    rectangle.dessiner(g);
		    g.dispose();
		}
	    }
	}
	
	if(etat.getMode() == MODE_DEPLACER){
	    
	    if((me.getModifiers() & InputEvent.BUTTON1_MASK) != 0){

		if(selection){
		    Point2D point = new Point2D.Double(me.getX(), me.getY());
		    int dx = (int)(point.getX() - ((Point2D)liste.lastElement()).getX());
		    int dy = (int)(point.getY() - ((Point2D)liste.lastElement()).getY());
		    figureSelectionnee.translater(dx, dy);
		    liste.add(point);
		    repaint();
		}
	    }
	}
    }
}
