import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.util.Vector;
import java.awt.Polygon;


public class Polygone extends Polygon implements Dessinable{

    public Polygone(Vector vecteur, Color _couleurTraits, int _epaisseur, Color _couleurRemplissage){
	super();
	if(vecteur.size() > 1)
	    for(int i = 0; i < vecteur.size(); i++)
		addPoint((int)((Point2D)vecteur.elementAt(i)).getX(), (int)((Point2D)vecteur.elementAt(i)).getY());

	couleurTraits = _couleurTraits;
	epaisseur = _epaisseur;
	couleurRemplissage = _couleurRemplissage;
    }

    private Color couleurTraits;

    private Color couleurRemplissage;

    private int epaisseur;

   
    public void dessiner(Graphics g){
	Graphics2D g2d = (Graphics2D)g;
	g2d.setColor(couleurRemplissage);
	g2d.fill(this);
	g2d.setColor(couleurTraits);
	g2d.setStroke(new BasicStroke(epaisseur, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	g2d.draw(this);
    }

    
    public void afficher(){
    }

    
    public void translater(int dx , int dy){
	translate(dx, dy);
    }

    
    public void setCouleurTraits(Color couleur){
	couleurTraits = couleur;
    }

    
    public void setCouleurRemplissage(Color couleur){
	couleurRemplissage = couleur;
    }

    public Color getCouleurRemplissage(){
	return couleurTraits;
    }

    
    public Color getCouleurTraits(){
	return couleurTraits;
    }
}
