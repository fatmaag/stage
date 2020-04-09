import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.BasicStroke;


public class Rectangle extends Rectangle2D.Double implements Dessinable{
    
    public Rectangle(Point2D point1, Point2D point2, Color _couleurTraits, int _epaisseur, Color _couleurRemplissage){
	super(point1.getX(), point1.getY(), point2.getX() - point1.getX(), point2.getY() - point1.getY());

	couleurTraits = _couleurTraits;
	epaisseur = _epaisseur;
	couleurRemplissage = _couleurRemplissage;
    }

    private Color couleurTraits;

    private Color couleurRemplissage;

    // Epaisseur des traits
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
	setRect(getX() + dx, getY() + dy, getWidth(), getHeight());
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
