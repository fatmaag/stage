import java.awt.Color;

public class Etat{

    /**
     * Cr�e et initialise un ensemble de parametres
     */
    public Etat(){
	existencePanelPrincipal = false;
	typeFigure = PanelDessin.MODE_LIGNE;
	epaisseur = 1;
	transparence = 1.0f;
	couleurTraits = Color.black;
	couleurRemplissage = Color.white;
	mode = PanelDessin.MODE_DESSIN;
    }

    // Si il y a d�ja un panelprincipal
    private boolean existencePanelPrincipal;

    /**
     * Renvoie existencePanelPrincipal
     * @return existencePanelPrincipal
     */
    public boolean getExistencePanelPrincipal(){
	return existencePanelPrincipal;
    }

    /**
     * Change la valeur de existencePanelPrincipal
     * @param valeur nouvelle valeur de existencePanelPrincipal
     */
    public void setExistencePanelPrincipal(boolean valeur){
	existencePanelPrincipal = valeur;
    }

    // La couleur utilis�e pour les traits
    private Color couleurTraits;

    /**
     * Renvoie la couleur utilis�e pour les traits
     * @return couleur des traits
     */
    public Color getCouleurTraits(){
	return couleurTraits;
    }

    /**
     * Change la couleur utilis�e pour les traits
     * @param _couleurTraits nouvelle couleur
     */
    public void setCouleurTraits(Color _couleurTraits){
	couleurTraits = _couleurTraits;
    }

    // La couleur utilis�e pour les remplissage
    private Color couleurRemplissage;

    /**
     * Renvoie la couleur utilis�e pour les remplissage
     * @return couleur des remplissage
     */
    public Color getCouleurRemplissage(){
	return couleurRemplissage;
    }

    /**
     * Change la couleur utilis�e pour les remplissage
     * @param _couleurRemplissage nouvelle couleur
     */
    public void setCouleurRemplissage(Color _couleurRemplissage){
	couleurRemplissage = _couleurRemplissage;
    }

    // L'epaisseur des traits
    private int epaisseur;

    /**
     * Renvoie l'epaisseur
     * @return l'epaisseur
     */
    public int getEpaisseur(){
	return epaisseur;
    }

    /**
     * Change l'epaisseur
     * @param _epaisseur nouvelle epaisseur
     */
    public void setEpaisseur(int _epaisseur){
	epaisseur = _epaisseur;
    }

    // Le type de figure � dessiner
    private int typeFigure;

    /**
     * Renvoie le type figure
     * @return le type de figure
     */
    public int getTypeFigure(){
	return typeFigure;
    }

    /**
     * Change le type figure
     * @param _typeFigure nouveau mode figure
     */
    public void setTypeFigure(int _typeFigure){
	typeFigure = _typeFigure;
    }

    // Le mode
    private int mode;

    /**
     * Renvoie le mode
     * @return le mode
     */
    public int getMode(){
	return mode;
    }

    /**
     * Remplace le mode
     * @param _mode nouveau mode
     */
    public void setMode(int _mode){
	mode = _mode;
    }

    // La transparence
    private float transparence;

    /**
     * Retourne la transparence
     */
    public float getTransparence(){
	return transparence;
    }

    /**
     * Change la transparence
     */
    public void setTransparence(float _transparence){
	transparence = _transparence;
    }
}
