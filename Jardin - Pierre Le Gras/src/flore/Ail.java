package flore;

import java.util.HashMap;

public class Ail extends Vegetal implements IRacePure{

	public Ail() {
		this.dessin[3] = "a";
		this.dessin[4] = "A";
	}
	
	public void seReproduire(HashMap<String, Integer> panier) {
		panier.put("Ail", panier.get("Ail") + 3);
	}

}