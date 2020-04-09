import java.awt.Color;

public class Commande{

    public Commande(int _type, Dessinable _figure){
	type = _type;
	figure = _figure;
    }

    public Commande(int _type, Dessinable _figure, Color _couleur){
	type = _type;
	couleur = _couleur;
	figure = _figure;
    }

    public Commande(int _type, int _index){
	type = _type;
	index = _index;
    }

    private Dessinable figure; 

    public Dessinable getFigure(){
	return figure;
    }

    private int type;

   
    public int getType(){
	return type;
    }

    private int index;

    
    public int getIndex(){
	return index;
    }

    private Color couleur;

   
    public Color getCouleur(){
	return couleur;
    }
}
