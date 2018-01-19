/*
 * 
 * last updated by Kayden on 11/30/2017 added array lists Armor and Crate
 * 
 */

import java.util.ArrayList;

public class Room 
{
	private ArrayList<Consumable> Consumables = new ArrayList<>();
	private ArrayList<Utility> Utilities = new ArrayList<>();
	private ArrayList<Animal> Animals = new ArrayList<>();
	private ArrayList<Weapon> Weapons = new ArrayList<>();
	private ArrayList<Armor> Armor = new ArrayList<>();
	private ArrayList<Crate> Crate = new ArrayList<>();
	private String description;
	private int roomNumber;
	
	public Room()
	{
		//zero arg constructor with zero construction???
		//is this legal
	}
	
	//adding of weapons and animals have to be done manually, because of amount of children.
	public Room(int consumables, int utilities)
	{
		for (int i = 0; i < consumables; i++)
		{
			Consumables.add(new Consumable());
		}
		for (int i = 0; i < utilities; i++)
		{
			Utilities.add(new Utility());
		}
	}
	
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String input)
	{
		this.description = input;
	}
	
	public ArrayList<Consumable> getConsumables() 
	{
		return Consumables;
	}
	public void setConsumables(ArrayList<Consumable> consumables) 
	{
		Consumables = consumables;
	}
	public void addConsumables(int consumables)
	{
		for (int i = 0; i < consumables; i++)
		{
			Consumables.add(new Consumable());
		}
	}
	public Consumable getConsumable(int index)
	{
		return Consumables.get(index);
	}
	public void addConsumable(Consumable consumable)
	{
		Consumables.add(consumable);
	}
	
	
	public ArrayList<Weapon> getWeapons() 
	{
		return Weapons;
	}
	public void setWeapons(ArrayList<Weapon> weapons) 
	{
		Weapons = weapons;
	}
	public void addWeapons(int weapons)
	{
		for (int i = 0; i < weapons; i++)
		{
			Weapons.add(new Weapon());
		}
	}
	public Weapon getWeapon(int index)
	{
		return Weapons.get(index);
	}
	public void addWeapon(Weapon weapon)
	{
		Weapons.add(weapon);
	}
	
	
	public ArrayList<Utility> getUtilities() 
	{
		return Utilities;
	}
	public void setUtilities(ArrayList<Utility> utilities) 
	{
		Utilities = utilities;
	}
	public void addUtilities(int utilities)
	{
		for (int i = 0; i < utilities; i++)
		{
			Utilities.add(new Utility());
		}
	}
	public Utility getUtility(int index)
	{
		return Utilities.get(index);
	}
	public void addUtility(Utility utility)
	{
		Utilities.add(utility);
	}
	
	
	public ArrayList<Animal> getAnimals() 
	{
		return Animals;
	}
	public void setAnimals(ArrayList<Animal> animals) 
	{
		Animals = animals;
	}
	public void addAnimals(int animals)
	{
		for (int i = 0; i < animals; i++)
		{
			Animals.add(new Animal());
		}
	}
	public Animal getAnimal(int index)
	{
		return Animals.get(index);
	}
	public void addAnimal(Animal animal)
	{
		Animals.add(animal);
	}
	
	public ArrayList<Armor> getArmor() 
	{
		return Armor;
	}
	public void setArmor(ArrayList<Armor> armor) 
	{
		Armor = armor;
	}
	public void addArmor(int armor)
	{
		for (int i = 0; i < armor; i++)
		{
			Armor.add(new Armor());
		}
	}
	public Armor getArmor(int index)
	{
		return Armor.get(index);
	}
	public void addArmor(Armor armor)
	{
		Armor.add(armor);
	}
	
	public ArrayList<Crate> getCrate() 
	{
		return Crate;
	}
	public void setCrate(ArrayList<Crate> crate) 
	{
		Crate = crate;
	}
	public void addCrate(int crate)
	{
		for (int i = 0; i < crate; i++)
		{
			Crate.add(new Crate());
		}
	}
	public Crate getCrate(int index)
	{
		return Crate.get(index);
	}
	public void addCrate(Crate crate)
	{
		Crate.add(crate);
	}
	
	public String toString()
	{
		return "consumables: " + Consumables.toString() + ", Utilities: " + Utilities.toString() + ", Animals: " + Animals.toString() + ", Weapons: " + Weapons.toString();
	}
}
