import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Gameplay 
{
	//ArrayList<Building> buildings = new ArrayList<>();
	Map map = new Map();
	Player player = new Player();
	public Gameplay()
	{
		init();
	}
	//full world generation.
	//might make it progressive in the future.
	public void init()
	{
		Random random = new Random();
		Player player = new Player();
		ArrayList<Animal> animals = new ArrayList<>();
		ArrayList<Weapon> weapons = new ArrayList<>();
		
		weapons.add(new Sniper());
		weapons.add(new DMR());
		weapons.add(new Handgun());
		weapons.add(new Rifle());
		weapons.add(new Knife());
		
		animals.add(new Human("Steve"));
		animals.add(new Human("Bonzo", "cook"));
		animals.add(new Human("Kai", "programmer"));
		animals.add(new Human("Alex", "annihilator"));
		animals.add(new Human("Kayden"));
		animals.get(0).setTemperament("barbarian");
		animals.get(3).setTemperament("relaxed");
		animals.get(4).setTemperament("lunatic");
		
		//this is actually useful
		//adding buildings
		map.getAboveGroundAtPos(0, 0).addBuildings(2);
		//adding rooms (floors are added by default)
		map.getAboveGroundAtPos(0, 0).getBuilding(0).getFloor(0).addRooms(2);
		map.getAboveGroundAtPos(0, 0).getBuilding(0).getFloor(1).addRooms(2);
		//adding a weapon
		map.getAboveGroundAtPos(0, 0).getBuilding(0).getFloor(1).getRoom(0).addWeapon(new Rifle());
		//adding people
		map.getAboveGroundAtPos(0, 0).getBuilding(0).getFloor(1).getRoom(1).addAnimal(new Human("Bozo", "clown"));
		map.getAboveGroundAtPos(0, 0).getBuilding(0).getFloor(0).getRoom(0).addAnimal(new Human("JOIJIO", "lkadsf"));
		//testing description framework
		map.getAboveGroundAtPos(0, 0).getBuilding(0).getFloor(0).getRoom(0).setDescription("THE ROOM LOOKS LIKE THIS XSJLKJLDF");
		map.getAboveGroundAtPos(0, 0).setDescription("THERE IS A BUILDING IN FRONT OF YOU... or YOU ENTER A BARREN TUNDRA");
		
		
		//can I build a logical function that assigns the floor's array index to the data stored in the floor???
		//scan through each position, if there is a building, then scan through each floor, setting floor.setFloorNumber to 'i'
	}
	public void turn()
	{
		
		Scanner in = new Scanner(System.in);
		//TODO fighting system logic goes here!
		//prints the description of the zone that the player has entered.
		map.getAboveGroundAtPos(player.getPosition()).toString();

		//parse the input, so that if it is left, right, forward, or back, then it reduces the string to just that.
		String input = in.nextLine().toLowerCase();
		//moving between rooms in buildings
		if(input.equals("left") || input.equals("right") || input.equals("forward") || input.equals("back")) 
		{
			int target = map.getAboveGroundAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getRoomInDirection(input);
			if(target != -1)
			{
				player.setCurrentRoom(target);
			}
			map.getAboveGroundAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).toString();
		}
		
		//if floor++ or floor--, then say something like, you climb up the stairs
		//same thing when changing rooms, say something like, "you enter a room with" ....
		
	}
}
