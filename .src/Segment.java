import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.Color;
import java.awt.BasicStroke;


public class Segment extends Line2D.Double implements Dessinable{

    
    public Segment(Point2D p1, Point2D p2, Color _couleurTraits, int _epaisseur){
	super(p1, p2);
	couleurTraits = _couleurTraits;
	epaisseur = _epaisseur;
    }

   
    public Segment(double x1, double y1, double x2, double y2, Color _couleurTraits, int _epaisseur){
	super(x1, y1, x2, y2);
	couleurTraits = _couleurTraits;
	epaisseur = _epaisseur;
    }

    private Color couleurTraits;

    private int epaisseur;

    public void dessiner(Graphics g){
	Graphics2D g2d = (Graphics2D)g;
	g2d.setColor(couleurTraits);
	g2d.setStroke(new BasicStroke(epaisseur, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	g2d.draw(this);
    }

    
    public boolean contains(Point2D point){
	if(point.equals(getP1()) || point.equals(getP2()))
	    return true;
	else return false;
    }

   
    public void afficher(){
    }

    
    public void translater(int dx , int dy){
	setLine(getX1() + dx, getY1() + dy, getX2() + dx, getY2() + dy);
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
