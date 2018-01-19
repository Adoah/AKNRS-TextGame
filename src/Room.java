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
	//used for dark or light rooms (as in, needs to use flashlight)
	private boolean isVisible;
	private String description;
	//the 'number' of this room
	private int roomNumber;
	//rooms that you can go to from this room
	private int[] availableRooms;
	private int roomRight;
	private int roomLeft;
	private int roomFront;
	private int roomBack;
	
	public Room()
	{
		this.isVisible = true;
		//-1 indicates no room there. 0 is first room upon entry to building.
		this.roomRight = -1;
		this.roomLeft = -1;
		this.roomFront = -1;
		this.roomBack = -1;
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
	public int[] getAvailableRooms() 
	{
		return availableRooms;
	}
	public void setAvailableRooms(int[] availableRooms) 
	{
		this.availableRooms = availableRooms;
	}
	public int getRoomNumber() 
	{
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) 
	{
		this.roomNumber = roomNumber;
	}
	public int getRoomRight() 
	{
		return roomRight;
	}
	public void setRoomRight(int roomRight) 
	{
		this.roomRight = roomRight;
	}
	public int getRoomLeft() 
	{
		return roomLeft;
	}
	public void setRoomLeft(int roomLeft) 
	{
		this.roomLeft = roomLeft;
	}
	public int getRoomFront() 
	{
		return roomFront;
	}
	public void setRoomFront(int roomFront) 
	{
		this.roomFront = roomFront;
	}
	public int getRoomBack() 
	{
		return roomBack;
	}
	public void setRoomBack(int roomBack) 
	{
		this.roomBack = roomBack;
	}
	
	//leave direction input strings lowercase
	public int getRoomInDirection(String direction)
	{
		if(direction.equals("left"))
		{
			return this.roomLeft;
		}
		if(direction.equals("right"))
		{
			return this.roomRight;
		}
		if(direction.equals("forward"))
		{
			return this.roomFront;
		}
		if(direction.equals("back"))
		{
			return this.roomBack;
		}
		else return -1;
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
	public void setVisibility(boolean vis)
	{
		this.isVisible = vis;
	}
	public boolean getVisibility()
	{
		return this.isVisible;
	}
	
	public String toString()
	{
		return "consumables: " + Consumables.toString() + ", Utilities: " + Utilities.toString() + ", Animals: " + Animals.toString() + ", Weapons: " + Weapons.toString();
	}

}
