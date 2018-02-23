import java.util.ArrayList;

public class Player 
{
	private ArrayList<Weapon> weapons = new ArrayList<>();
	private ArrayList<Consumable> consumables = new ArrayList<>();
	private ArrayList<Utility> Utility = new ArrayList<>();
	private double hp;
	private double agility;
	private double weight;
	//maximum carry weight/inventory capacity is denoted by this. Calculations will need to be added so that it works tho
	private double maxweight;
	//monitors position (x,y,z), references 3 dimensional array map
	//z = 0 is above ground, -1 is below ground
	private int Position[] = new int[3];
	//tracks inter-building position. [0] = floor, [1] = room number
	private int currentBuilding;
	private int currentFloor;
	private int currentRoom;
	
	public Player()
	{
		this.Position[0] = 0;
		this.Position[1] = 0;
		this.Position[2] = 0;
		this.maxweight = 70;
		this.currentBuilding = -1;
		this.currentFloor = -1;
		this.currentRoom = -1;
	}
	
	public int getCurrentRoom() 
	{
		return currentRoom;
	}
	public void setCurrentRoom(int currentRoom) 
	{
		this.currentRoom = currentRoom;
	}
	public int getCurrentFloor() 
	{
		return currentFloor;
	}
	public void setCurrentFloor(int currentFloor) 
	{
		this.currentFloor = currentFloor;
	}
	public int getCurrentBuilding() 
	{
		return currentBuilding;
	}
	public void setCurrentBuilding(int currentBuilding) 
	{
		this.currentBuilding = currentBuilding;
	}
	public void changeFloor(int delta)
	{
		this.currentFloor = this.currentFloor + delta;
	}

	public void addWeapon(Weapon weapon)
	{
		this.weapons.add(weapon);
	}
	public ArrayList<Weapon> getWeapons() 
	{
		return weapons;
	}
	public void setWeapons(ArrayList<Weapon> weapons)
	{
		this.weapons = weapons;
	}
	public void addConsumables(Consumable consumable)
	{
		this.consumables.add(consumable);
	}
	public ArrayList<Consumable> getConsumables() {
		return consumables;
	}
	public void setConsumables(ArrayList<Consumable> consumables) 
	{
		this.consumables = consumables;
	}
	public void addUtility(Utility utility)
	{
		this.Utility.add(utility);
	}
	public ArrayList<Utility> getUtility() 
	{
		return Utility;
	}
	public void setUtility(ArrayList<Utility> utility) 
	{
		Utility = utility;
	}
	public void addHp(int hpToAdd)
	{
		this.hp = this.hp + hpToAdd;
	}
	public double getHp() 
	{
		return hp;
	}
	public void setHp(double hp) 
	{
		this.hp = hp;
	}
	public double getAgility() 
	{
		return agility;
	}
	public void setAgility(double agility) 
	{
		this.agility = agility;
	}
	public double getWeight() 
	{
		return weight;
	}
	public void setWeight(double weight) 
	{
		this.weight = weight;
	}
	public double getMaxweight() 
	{
		return maxweight;
	}
	public void setMaxweight(double maxweight) 
	{
		this.maxweight = maxweight;
	}
	public int[] getPosition() 
	{
		return Position;
	}
	public int getPosition(int i)
	{
		return Position[i];
	}
	public void setPosition(int position[]) 
	{
		Position = position;
	}
	public void setPositionX(int position)
	{
		this.Position[0] = position;
	}
	public void setPositionY(int position)
	{
		this.Position[1] = position;
	}
	public void setPositionZ(int position)
	{
		this.Position[2] = position;
	}
	public void positionLeft()
	{
		this.Position[0]--;
	}
	public void positionRight()
	{
		this.Position[0]++;
	}
	public void positionUp()
	{
		this.Position[1]++;
	}
	public void positionDown()
	{
		this.Position[1]--;
	}
}
