package flore;

import java.util.HashMap;

public class Carotte extends Vegetal implements IRacePure {

	public Carotte() {
		this.dessin[3] = "c";
		this.dessin[4] = "C";
	}	
	
	public void seReproduire(HashMap<String, Integer> panier) {
		panier.put("Carotte", panier.get("Tomate") + 3);
	}
}
