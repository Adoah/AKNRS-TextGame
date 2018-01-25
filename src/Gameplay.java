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
	//might make it progressive in the future. As in it's executing as the person walks into each zone?? For ram efficiency???
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
		map.getMapAtPos(0, 0, 0).addBuildings(2);
		//adding rooms (floors are added by default)
		map.getMapAtPos(0, 0, 0).getBuilding(0).getFloor(0).addRooms(2);
		map.getMapAtPos(0, 0, 0).getBuilding(0).getFloor(1).addRooms(2);
		//adding a weapon
		map.getMapAtPos(0, 0, 0).getBuilding(0).getFloor(1).getRoom(0).addWeapon(new Rifle());
		//adding people
		map.getMapAtPos(0, 0, 0).getBuilding(0).getFloor(1).getRoom(1).addAnimal(new Human("Bozo", "clown"));
		map.getMapAtPos(0, 0, 0).getBuilding(0).getFloor(0).getRoom(0).addAnimal(new Human("JOIJIO", "lkadsf"));
		//testing description framework
		map.getMapAtPos(0, 0, 0).getBuilding(0).getFloor(0).getRoom(0).setDescription("THE ROOM LOOKS LIKE THIS XSJLKJLDF");
		map.getMapAtPos(0, 0, 0).setDescription("THERE IS A BUILDING IN FRONT OF YOU... or YOU ENTER A BARREN TUNDRA");
		
		
		//can I build a logical function that assigns the floor's array index to the data stored in the floor???
		//scan through each position, if there is a building, then scan through each floor, setting floor.setFloorNumber to 'i'
	}
	public void turn()
	{
		Scanner in = new Scanner(System.in);
		//prints the description of the zone that the player has entered.
		//map.getMapAtPos(player.getPosition()).toString();
		//makes the input lowercase
		String input = in.nextLine().toLowerCase();
		//runs the parseinput function.
		String parsed = parseInput(input);
		//TODO fighting system logic goes here!
		if(parsed.contains("attack"))
		{
			//pull the enemies in the current room from the map
			 ArrayList<Animal> roomAnimals = (ArrayList<Animal>) map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getAnimals().clone();
			//figure out which animal is hostile
			 ArrayList<Animal> hostileAnimals = new ArrayList<>();
			 for(int i = 0; i < roomAnimals.size(); i++)
			 {
				 if(roomAnimals.get(i).getHostility() > .8)
				 {
					 hostileAnimals.add(roomAnimals.get(i));
				 }
			 }
			 System.out.println("What do you want to attack?");
			 for(int i = 0; i < hostileAnimals.size(); i++)
			 {
				 //TODO figure out correct formatting system here
				 hostileAnimals.get(i).toString();
			 }
			 input = in.next().toLowerCase();
			 int targetAnimalIndex = -1;
			 //using j for error checking
			 int j = 0;
			 //TODO later check for the enemy in the original input text
			 for(int i = 0; i < hostileAnimals.size(); i++)
			 {
				 if(hostileAnimals.get(i).getName().equals(input))
				 {
					 j++;
					targetAnimalIndex = i;
				 }
			 }
			 if(j > 1)
			 {
				System.out.println("there are more than one of those!");
				//TODO ask which one of the many to execute;
			 }
			 attack(hostileAnimals.get(targetAnimalIndex));
			//ask player who they want to attack
			//if(parsed.contains(animal name)) then forge questioning the player
			//follow same process for figuring out what weapon to use.
		}
		if(player.getCurrentBuilding() != -1)
		{
			//moving rooms between buildings
			if(parsed.equals("left") || parsed.equals("right") || parsed.equals("forward") || parsed.equals("back")) 
			{
				//parsing for directions occurs in this function
				int target = map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getRoomInDirection(input);
				if(target != -1)
				{
					player.setCurrentRoom(target);
					//prints description of the room that you just switched to.
					System.out.println(map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).toString());
				}
				System.out.println("There is no room that way!");
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
					int totalFloorsOfBuilding = map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getNumberOfFloors();
					//checking if there is a floor above
					if(totalFloorsOfBuilding - player.getCurrentFloor() > 0 && player.getCurrentFloor() > 0)
					{
						//have to check if player is in the room with the staircase
						boolean staircase = map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getHasStaircase();
						if(staircase)
						{
							//changes floor
							player.changeFloor(delta);
							//switching current room to the room with the staircase on the new floor.
							int amtOfRooms = map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRooms().size();
							for(int i = 0; i < amtOfRooms; i++)
							{
								if(map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(i).getHasStaircase())
								{
									player.setCurrentRoom(i);
								}
							}
							//prints the description of the room that you have just entered.
							System.out.println(map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).toString());
						}
						else
						{
							System.out.println("There is no staircase to go up in this room!");
						}
					}
					else
					{
						System.out.println("There is no floor there!");
					}
				}
				else
				{
					System.out.println("You are not in a building!");
				}
			}
			//TODO change this text
			if(parsed.equals("other building"))
			{
				int totalBuildings = map.getMapAtPos(player.getPosition()).getBuildings().size();
				if(totalBuildings > 1)
				{
					//prompt what building you want to switch into, and indicate which building you are in.
					System.out.println("What building do you want to enter?");
					for(int i = 1; i < totalBuildings + 1; i++)
					{
						if(i == player.getCurrentBuilding() + 1)
						{
							System.out.println("Building " + i + "(You are here)");
						}
						else
						{
							System.out.println("Building " + i);
						}
					}
					//accept user input
					int questionAnswer = in.nextInt();
					//switch to building, and reset all values
					player.setCurrentBuilding(questionAnswer);
					player.setCurrentFloor(0);
					player.setCurrentRoom(0);
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
		//if floor++ or floor--, then say something like, you climb up the stairs
		//same thing when changing rooms, say something like, "you enter a room with" ....
		
	}
	public String parseInput(String input)
	{
		//build a string tokenizer
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
	public void attack(Animal target)
	{
		//this is where all the actual attacking happens
		//TODO check for weapon names in original input
		System.out.println("what do you want to attack with");
		for(int i = 0; i < player.getWeapons().size(); i++)
		{
			System.out.println(player.getWeapons().get(i).getName());
		}
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
	}
}