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
		turn();
	}
	//full world generation.
	//might make it progressive in the future.
	public void init()
	{
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

		String input = in.nextLine().toLowerCase();
		String parsed = parseInput(input);
		//moving between rooms in buildings
		//TODO Also have to check if player is inside building
		if(parsed.equals("left") || parsed.equals("right") || parsed.equals("forward") || parsed.equals("back")) 
		{
			if(player.getCurrentBuilding() != -1)
			{
				//checking if room exists
				int target = map.getAboveGroundAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getRoomInDirection(input);
				if(target != -1)
				{
					player.setCurrentRoom(target);
				}
				map.getAboveGroundAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).toString();
			}
		}
		//switching floors
		if(parsed.equals("upstairs") || parsed.equals("downstairs"))
		{
			int delta = 0;
			if(parsed.equals("upstairs"))
			{
				delta = 1;
			}
			if(parsed.equals("downstairs"))
			{
				delta = -1;
			}
			if(player.getCurrentBuilding() != -1)
			{
				//checking if floor exists
				int totalFloorsOfBuilding = map.getAboveGroundAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getNumberOfFloors();
				//checking if there is a floor above
				if(totalFloorsOfBuilding - player.getCurrentFloor() > 0 && player.getCurrentFloor() > 0)
				{
					//have to check if player is in the room with the staircase
					boolean staircase = map.getAboveGroundAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getHasStaircase();
					if(staircase)
					{
						//changes floor
						player.changeFloor(delta);
						//switching current room to the room with the staircase on the new floor.
						int amtOfRooms = map.getAboveGroundAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRooms().size();
						for(int i = 0; i < amtOfRooms; i++)
						{
							if(map.getAboveGroundAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(i).getHasStaircase())
							{
								player.setCurrentRoom(i);
							}
						}
					}
				}
			}
		}
		//leaving buildings entirely
		if(parsed.equals("leave"))
		{
			player.setCurrentRoom(-1);
			player.setCurrentFloor(-1);
			player.setCurrentBuilding(-1);
		}
		
		//TODO have to build for switching buildings		
		//if floor++ or floor--, then say something like, you climb up the stairs
		//same thing when changing rooms, say something like, "you enter a room with" ....
		
	}
	
	public String parseInput(String input)
	{
		//reduces the input string to left, right, front or back for simplicity and other code compatibility.
		if(input.contains("left"))
		{
			return "left";
		}
		else if(input.contains("right"))
		{
			return "right";
		}
		else if(input.contains("forward"))
		{
			return "forward";
		}
		else if(input.contains("back"))
		{
			return "back";
		}
		return input;
	}
}
