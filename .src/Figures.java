import java.util.LinkedList;
import java.util.Iterator;
import java.awt.Graphics;
import java.awt.geom.Point2D;


public class Figures extends LinkedList{

    /**
     * Cr�e une nouvelle liste de Figures Dssinables
     */
    public Figures(){
	super();
    }

    /**
     * Dessine les figures
     * @param g contexte graphique
     */
    public void dessiner(Graphics g){
	for(Iterator i = this.iterator(); i.hasNext(); )
	    ((Dessinable)i.next()).dessiner(g);
    }

    /**
     * V�rifie un point est dans l'ensemble des figures
     * @return Renvoie la derni�re figure contenant le point et null sinon
     */
    public Dessinable contient(Point2D point){
	Iterator i = this.iterator();
	while(i.hasNext()){
	    Dessinable figure = (Dessinable)i.next();
	    if(figure.contains(point))
		return figure;
	}
	return null;
    }
}
