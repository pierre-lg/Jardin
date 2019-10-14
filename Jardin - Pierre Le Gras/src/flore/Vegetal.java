package flore;

public abstract class Vegetal {
	
	public Etat etat;
	public String dessin[] = new String[6];
	
	public Vegetal() {
		this.dessin[0] = "-";
		this.dessin[1] = ".";
		this.dessin[2] = "|";
		this.dessin[5] = "#";
		this.etat = Etat.GRAINE;
	}
	
	@Override
	public String toString() {
		String a = " ";
		if(this.etat == Etat.GRAINE) {
		  a = dessin[0];
		}
		else if(this.etat == Etat.GERME){
			a = dessin[1];
		}
		else if(this.etat == Etat.TIGE){
			a = dessin[2];
		}
		else if(this.etat == Etat.FEUILLE){
			a = dessin[3];
		}
		else if(this.etat == Etat.FLEUR){
			a = dessin[4];
		}
		else if(this.etat == Etat.MORT){
			a = dessin[5];
		}
		
		return a;
	}
	
	public Etat grandir() {
		
		this.etat = Etat.values()[this.etat.ordinal() + 1];
		
		return etat;
	}
	
	public String toStringé() 
    {
        String dessinActuel = "";
        Integer etatActuel = this.etat.ordinal();

        dessinActuel = this.dessin[etatActuel];
        return dessinActuel;
    }
	
	
	
}
