import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.BasicStroke;


public class Cercle extends Ellipse2D.Double implements Dessinable{

    /**
     * Cr�e un Cercle avec 2 point2D
     * @param centre centre du cercle
     * @param point un pointdu cercle
     * @param _couleurTraits couleur des traits
     * @param _epaisseur �paisseur
     * @param _couleurRemplissage couleur de remplissage
     */

    public Cercle(Point2D centre, Point2D point, Color _couleurTraits, int _epaisseur, Color _couleurRemplissage){
	super(centre.getX() - centre.distance(point), centre.getY() - centre.distance(point),
	      2 * centre.distance(point), 2 * centre.distance(point));

	couleurTraits = _couleurTraits;
	epaisseur = _epaisseur;
	couleurRemplissage = _couleurRemplissage;
    }

    // La couleur utilis�e pour les traits
    private Color couleurTraits;

    // La couleur utilis�e pour les remplissage
    private Color couleurRemplissage;

    // Epaisseur des traits
    private int epaisseur;

    /**
     * Dessine le cercle
     * @param g contexte graphique
     */
    public void dessiner(Graphics g){
	Graphics2D g2d = (Graphics2D)g;
	g2d.setColor(couleurRemplissage);
	g2d.fill(this);
	g2d.setColor(couleurTraits);
	g2d.setStroke(new BasicStroke(epaisseur, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	g2d.draw(this);
    }

    /**
     * Affiche les caract�ristiques du cercle
     */
    public void afficher(){
    }

    /**
     * Translater le cerlce
     * @param dx
     * @param dy
     */
    public void translater(int dx , int dy){
	setFrame(getX() + dx, getY() + dy, getWidth(), getHeight());
    }

    /**
     * Change la couleur des traits
     * @param couleur nouvelle couleur
     */
    public void setCouleurTraits(Color couleur){
	couleurTraits = couleur;
    }

    /**
     * Change la couleur de remplissage
     * @param couleur nouvelle couleur
     */
    public void setCouleurRemplissage(Color couleur){
	couleurRemplissage = couleur;
    }

    /**
     * Retourne la couleur de remplissage
     */
    public Color getCouleurRemplissage(){
	return couleurTraits;
    }

    /**
     * Retourne la couleur des traits
     */
    public Color getCouleurTraits(){
	return couleurTraits;
    }
}
