import java.util.HashMap;
import java.util.Scanner;

import flore.*;

public class Jardin {
	
	private int longueur;
	private int largeur;
	private Emplacement emplacement[][];
	private HashMap<String, Integer> panier;
	
	public Jardin( int longueur, int largeur) {
		this.setLongueur(longueur);
		this.setLargeur(largeur);
		this.setPanier(new HashMap<String, Integer>());
		this.emplacement = new Emplacement[longueur][largeur];
		
	}
	
	public void ajouterAuPanier(String nomVegetal, int qté) {
		this.panier.put(nomVegetal, qté);
	}
	
	
	public void afficherEmplacement(){
		String a = " ";
		
		for(int i = 0; i<longueur; i++) {
			for(int j = 0; j<largeur; j++) {
				if( emplacement[i][j] == null) {
					System.out.print("o"); 
				}else {
					System.out.print(emplacement[i][j].getVegetal().toString()); 
				}
				
			}
			System.out.print( "\n");
		}
			
	}
	
	 
	public String toString() {
		afficherEmplacement();
		return "\nEt notre panier contient : \n\nTomate : " +  panier.get("Tomate") + " graine(s)"
		+ " \nCarotte : " + panier.get("Carotte")  + " graine(s)" +  "\nAil : " +
		panier.get("Ail")  + " graine(s)" +  "\nBetterave : " +
		panier.get("Betterave")  + " graine(s)";
	}
	
	
	public void semer() {
//		
		Scanner scannerPlante = new Scanner(System.in);
		System.out.println("Que souhaitez vous planter ?\n"
				+ "1-Ail\n"
				+ "2-Betterave\n"
				+ "3-Tomate\n"
				+ "4-Carotte");
		int reponsePlante = scannerPlante.nextInt();
		System.out.println("Dans quelle colonne souhaitez vous la placer");
		int reponseColonne = scannerPlante.nextInt();
		System.out.println("Dans quelle ligne souhaitez vous la placer");
		int reponseLigne = scannerPlante.nextInt();
			
			
			
		if(reponsePlante == 1) {
			this.emplacement[reponseColonne][reponseLigne]= new Emplacement(new Ail());
			panier.put("Ail", panier.get("Ail") - 1);
			}
		else if(reponsePlante == 2) {
			this.emplacement[reponseColonne][reponseLigne]= new Emplacement(new Betterave());
			panier.put("Betterave", panier.get("Betterave") - 1);
			}
		else if(reponsePlante == 3) {
			this.emplacement[reponseColonne][reponseLigne]= new Emplacement(new Tomate());
			panier.put("Tomate", panier.get("Tomate") - 1);
			}
		else if(reponsePlante == 4) {
			this.emplacement[reponseColonne][reponseLigne]= new Emplacement(new Carotte());
			panier.put("Carotte", panier.get("Carotte") - 1);
			}
		cls();
		
		}
		
	
	public void queFaire() {
		
		boolean reponse = false;
		while(reponse == false) {
		
			Scanner scanner = new Scanner(System.in);
			System.out.println("\n\nQue souhaitez-vous faire ? \n\n"
					+ "1-Semer une graine\n"
					+ "2-Récolter toutes les plantes qui sont matures\n" 
					+"3-Passer à la saison suivante \n"
					+ "4-Quitter l'application") ;
			int reponseChoix = scanner.nextInt();
			
			if(reponseChoix == 1 || reponseChoix ==2 || reponseChoix == 3 || reponseChoix == 4 ) {
				reponse = true;
				if(reponseChoix == 1) {
					semer();
				}
				else if(reponseChoix == 2) {
					recolter();
				}
				else if(reponseChoix == 3) {
					saisonSuivante();
				}
				else if(reponseChoix == 4) {
					stopAuProgramme();
				}
			}
		}
	
	}
	
	public void saisonSuivante(){
		
		for(int x = 0; x<longueur; x++) {
			for(int y = 0; y<largeur; y++) {
				if(this.emplacement[x][y] != null)
				this.emplacement[x][y].getVegetal().grandir();
			}
		}
		cls();
		
		
	}
	
	public void recolter() {
		for(int x = 0; x<longueur; x++) {
			for(int y = 0; y<largeur; y++) {
				if(this.emplacement[x][y] != null) {
					if(this.emplacement[x][y].getVegetal().etat == Etat.FLEUR ) {
						if(this.emplacement[x][y].getVegetal() instanceof IRacePure) {
							IRacePure v = (IRacePure) this.emplacement[x][y].getVegetal();
							v.seReproduire(this.panier);
						}
						/*else if(this.emplacement[x][y].getVegetal() instanceof IOgm) {
							IOgm w = (IOgm) this.emplacement[x][y].getVegetal();
							w.seDupliquer(x, y);					
						}*/
						this.emplacement[x][y] = null;					
					}
					
				}
			}		
		}
		cls();
	}
	
	
	public void stopAuProgramme() {
		System.exit(0);
	}

	


	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public HashMap<String, Integer> getPanier() {
		return panier;
	}

	public void setPanier(HashMap<String, Integer> panier) {
		this.panier = panier;
	}

	public Emplacement[][] getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(Emplacement emplacement[][]) {
		this.emplacement = emplacement;
	}
	
	
	

	public void cls()
    {
		for (int i = 0; i<50; i++) {
			System.out.println();
		}
    }
	
}
