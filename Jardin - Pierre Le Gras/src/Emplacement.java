import flore.Vegetal;

public class Emplacement {
	
	 private Vegetal vegetal;
	 
	 @Override
	public String toString() {
		 return vegetal.toString();
	}
	 
	 public Emplacement(Vegetal vegetal) {
		this.vegetal = vegetal;
	}
	 
	 public Vegetal getVegetal() {
		return vegetal;
	}
	 
	 public void setVegetal(Vegetal vegetal) {
		this.vegetal = vegetal;
	}
}
