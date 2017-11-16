
public class Armor {

	private String name;
	  private int armorClass;
	  private int size;
	  private int weight;
	  private double wear;
	  private boolean isUsable;

	  public Armor(){
	    this.wear = 0;
	    this.isUsable = true;
	  }
	  
	  public Armor(String name, int armorClass, int size, int weight, double wear, boolean isUsable){
	   this.name = name;
	   this.armorClass = armorClass;
	   this.size = size;
	   this.weight = weight;
	   this.wear = wear;
	   this.isUsable = isUsable;
	  }
	  
	public String getName(){
	  return this.name;
	}
	public void setName(String name){
	  this.name = name;
	}
	public int getArmorClass(){
	  return this.armorClass;
	}
	public void setArmorClass(int armorClass){
	  this.armorClass = armorClass;
	}
	public int GetSize(){
	  return this.size;
	}
	public void setSize(int size){
	  this.size = size;
	}
	public int getWeight(){
	  return this.weight;
	}
	public void setWeight(int weight){
	  this.weight = weight;
	}
	  public double getWear(){
	  return this.wear;
	}
	public void setWear(double wear){
	  this.wear = wear;
	}
	  public boolean getIsUsable(){
	    return this.isUsable;
	  }
	public void setIsUsable(boolean isUseable){
	  this.isUsable = isUsable;
	}

	  
	  public String toString(){
	 
	   return "You found: " + this.name + "It is a level " + this.armorClass + "balistic protection and is: " + this.size + "and weighs: " + this.weight + "Kg" + " its condition is: " + this.wear + this.isUsable;
	    
	  }
	
}
