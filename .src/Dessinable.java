import java.awt.Graphics;
import java.awt.Color;
import java.awt.geom.Point2D;


public interface Dessinable{

    /**
     * Dessine la figure
     * @param g contexte graphique
     */
    public abstract void dessiner(Graphics g);

    /**
     * Affiche les caract�ristiques de la figure en console
     */
    public abstract void afficher();

    /**
     * V�rifie si un point appartient � la figure
     * @param point un point
     * @return vrai si le point appartient � la figure 
     */
    public abstract boolean contains(Point2D point);

    /**
     * Effectue une translation de la figure
     * @param dx
     * @param dy
     */
    public abstract void translater(int dx, int dy);

    /**
     * Change la couleur des traits
     * @param couleur nouvelle couleur
     */
    public abstract void setCouleurTraits(Color couleur);

    /**
     * Retourne la couleur des traits
     */
    public abstract Color getCouleurTraits();

    /**
     * Change la couleur de remplissage
     * @param couleur nouvelle couleur
     */
    public abstract void setCouleurRemplissage(Color couleur);

    /**
     * Retourne la couleur de remplissage
     */
    public abstract Color getCouleurRemplissage();
}
