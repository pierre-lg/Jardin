import java.io.IOException;

public class Terre {
	public static void main(String[] args){
		
		Jardin jardin = new Jardin(3,5);
		
		
		jardin.ajouterAuPanier("Ail",10);
		jardin.ajouterAuPanier("Tomate",5);
		jardin.ajouterAuPanier("Betterave",5);
		jardin.ajouterAuPanier("Carotte",5);
		

		
		System.out.print(jardin.toString());
		
		boolean connect� = true;
		
		while(connect� == true) {
			
			jardin.queFaire();
			System.out.print(jardin.toString());
			
		}
		
		
		
	}
}
