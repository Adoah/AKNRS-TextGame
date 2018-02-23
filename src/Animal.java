import java.util.Random;

//animals are organic beings
public class Animal 
{
	private String name;
	private String species;
	private int atkDmg;
	private int health;
	private boolean isAlive;
	private String temperament;
	//number from 0-1. 0 is no hostility, 1 is immediate hostility
	private double hostility;
	private String description;
	private int maximumPenetratableArmor;
	
	public Animal()
	{
		this.health = 100;
		this.isAlive = true;
		this.temperament = "Normal";
	}
	
	public Animal(String name, String species, int atkDmg, int health, boolean isAlive, String temperament)
	{
		this.name = name;
		this.species = species;
		this.atkDmg = atkDmg;
		this.health = health;
		this.isAlive = isAlive;
		this.temperament = temperament;
	}
	
	//TODO random number generator based on the hostility index
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getSpecies() 
	{
		return species;
	}
	public void setSpecies(String species) 
	{
		this.species = species;
	}
	public int getAtkDmg() 
	{
		return atkDmg;
	}
	public void setAtkDmg(int atkDmg) 
	{
		this.atkDmg = atkDmg;
	}
	public int getHealth() 
	{
		return health;
	}
	public void setHealth(int health) 
	{
		this.health = health;
	}
	public boolean getAlive() 
	{
		return isAlive;
	}
	public void setAlive(boolean isAlive) 
	{
		this.isAlive = isAlive;
	}
	//run getAlive after running this
	public void checkAlive()
	{
		if(this.atkDmg <= 0)
		{
			this.isAlive = false;
		}
	}
	public String toString()
	{
		//TODO figure out correct formatting here
		return "A " + this.species + " " + this.description;
	}
	public String getTemperament() 
	{
		return temperament;
	}
	public void setTemperament(String temperament) 
	{
		this.temperament = temperament;
	}
	public double getHostilityValue() 
	{
		return hostility;
	}
	public boolean getHostile()
	{
		Random random = new Random();
		double randomValue = 0 + (1 - 0) * random.nextDouble();
		if(randomValue < this.hostility)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void setHostility(double hostility) 
	{
		this.hostility = hostility;
	}
	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public int getMaximumPenetratableArmor() 
	{
		return maximumPenetratableArmor;
	}

	public void setMaximumPenetratableArmor(int number)
	{
		this.maximumPenetratableArmor = number;
	}
}
