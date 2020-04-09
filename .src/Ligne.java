import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.util.Vector;
import java.util.Collection;


public class Ligne extends Vector implements Dessinable{

  
    public Ligne(Color _couleurTraits, int _epaisseur){
	super();
	couleurTraits = _couleurTraits;
	epaisseur = _epaisseur;
    }

   
    public Ligne(Collection collection, Color _couleurTraits, int _epaisseur){
	super(collection);
	couleurTraits = _couleurTraits;
	epaisseur = _epaisseur;
    }

    private Color couleurTraits;

    private int epaisseur;

    
    public void dessiner(Graphics g){
	Graphics2D g2d = (Graphics2D)g;
	g2d.setColor(couleurTraits);
	g2d.setStroke(new BasicStroke(epaisseur, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	g.setColor(couleurTraits);
	if(this.size() > 1){
	    for(int i = 1; i < this.size(); i++)
		g2d.draw(new Line2D.Double((Point2D)elementAt(i-1), (Point2D)elementAt(i)));
	}
    }

    public boolean contains(Point2D point){
	if(point.equals(firstElement()) || point.equals(lastElement()))
	    return true;
	else return false;
    }

    public void translater(int dx , int dy){
    }

   
    public void afficher(){
    }

    
    public void setCouleurTraits(Color couleur){
	couleurTraits = couleur;
    }

    
    public void setCouleurRemplissage(Color couleur){
    }

   
    public Color getCouleurRemplissage(){
	return null;
    }

   
    public Color getCouleurTraits(){
	return couleurTraits;
    }
}
