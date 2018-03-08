import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Gameplay 
{
	//ArrayList<Building> buildings = new ArrayList<>();
	public static boolean gameOver = false;
	Map map = new Map();
	Player player = new Player();
	public Gameplay()
	{
		init();
		while (gameOver == false)
		{
			turn();
		}
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
		animals.get(4).setTemperament("The most awesome");
		
		//this is actually useful
		//adding buildings
		map.getMapAtPos(0, 0, 0).addBuildings(1);
		//adding rooms (floors are added by default)
		map.getMapAtPos(0, 0, 0).getBuilding(0).getFloor(0).addRooms(1);
		map.getMapAtPos(0, 0, 0).getBuilding(0).addFloors(1);
		//adding a weapon
		map.getMapAtPos(0, 0, 0).getBuilding(0).getFloor(1).getRoom(0).addWeapon(new Rifle());
		//adding people
		map.getMapAtPos(0, 0, 0).getBuilding(0).getFloor(1).getRoom(1).addAnimal(new Human("Bonzo", "UN Oficer"));
		map.getMapAtPos(0, 0, 0).getBuilding(0).getFloor(1).getRoom(1).addAnimal(new Human("Ric (Codename Alfa)", "UN soldier"));
		map.getMapAtPos(0, 0, 0).getBuilding(0).getFloor(1).getRoom(1).addAnimal(new Human("Tom (Codename Bravo)", "UN soldier"));
		map.getMapAtPos(0, 0, 0).getBuilding(0).getFloor(0).getRoom(0).addAnimal(new Human("Vlademir", "Militia Leader"));
		map.getMapAtPos(0, 0, 0).getBuilding(0).getFloor(0).getRoom(0).addAnimal(new Human("Peter", "Militia fighter"));
		map.getMapAtPos(0, 0, 0).getBuilding(0).getFloor(0).getRoom(0).addWeapon(new DMR());
		map.getMapAtPos(0, 0, 0).getBuilding(0).getFloor(0).getRoom(0).addArmor(new Armor2());
		Scanner in = new Scanner(System.in);
		
		//testing description framework
		map.getMapAtPos(0, 0, 0).setDescription("You are on a fortified island that overlooks the ocean. In the didstance there is a snowy forest at the edge of a beach.");
		map.getMapAtPos(0, 0, 0).getBuilding(0).getFloor(0).getRoom(0).setDescription(
		"You are in a heavily fortified bunker with 2 inch thick steel plating a DMR and Level two Armor rests on a work bench. \n"
		+ " There are 5 people in the room with you deep in conversation. Bonzo: The UN Officer, Ric (Codename Alfa): A UN soldier, Tom (Codename Bravo): A UN soldier, Vlademir: The Milita Leader, and Peter: A Militia Fighter. \n"
		+ " Bonzo the UN oficer turns around slowly and adresses you: Welcome, thanks for coming, as you know this situation here is pretty bad \n");
		
		/*
		String input = in.nextLine().toLowerCase();
		String parsed = parseInput(input);
		input = in.next().toLowerCase();
		if (KEYPRESSED == true) {
			map.getMapAtPos(0, 0, 0).getBuilding(0).getFloor(0).getRoom(0).setDescription("");
		}
		*/
		
		//map.getMapAtPos(0, 1, 0).setDescription("THIS IS A TEST STATING THAT YOU ARE IN A BARREN TUNDRA");
		//map.getMapAtPos(0, 1, 0).addBuildings(1);
		//map.getMapAtPos(0, 1, 0).getBuilding(0).getFloor(0).getRoom(0).setDescription("There is a gun in this room.");
		//map.getMapAtPos(0, 1, 0).getBuilding(0).getFloor(0).getRoom(0).addWeapon(new DMR());
		
		//can I build a logical function that assigns the floor's array index to the data stored in the floor???
		//scan through each position, if there is a building, then scan through each floor, setting floor.setFloorNumber to 'i'
	
		//can I build a logical function that assigns the floor's array index to the data stored in the floor???
		//scan through each position, if there is a building, then scan through each floor, setting floor.setFloorNumber to 'i'
	}
	@SuppressWarnings("unchecked")
	public void turn()
	{
		//printing code
		//player is not in building
		if(player.getCurrentBuilding() == -1)
		{
			if(map.getMapAtPos(player.getPosition()).getHasVisit())
			{
				System.out.println(map.getMapAtPos(player.getPosition()).getLabel());
			}
			else
			{
				System.out.println(map.getMapAtPos(player.getPosition()).getDescription());
			}
		}
		else
		{
			if(player.getCurrentBuilding() != -1 && player.getCurrentFloor() != -1 && player.getCurrentRoom() != -1)
			{
				if(map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getHasVisit())
				{
					System.out.println(map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getLabel());
				}
				else
				{
					System.out.println(map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getDescription());
				}
			}
		}
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
			//pull the enemies in the current room from the map into an isolated arraylist
			ArrayList<Animal> roomAnimals = (ArrayList<Animal>) map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getAnimals().clone();
			//figure out which animal is hostile
			ArrayList<Animal> hostileAnimals = new ArrayList<>();
			for(int i = 0; i < roomAnimals.size(); i++)
			{
				if(roomAnimals.get(i).getHostile())
				{
					 hostileAnimals.add(roomAnimals.get(i));
				}
			}
			System.out.println("What do you want to attack?");
			//prints the list of animals that are in the room, and indicates which are hostile
			for(int i = 0; i < roomAnimals.size(); i++)
			{
				//TODO figure out correct formatting system here
				String result = "";
				result = roomAnimals.get(i).toString() + " ";
				if(roomAnimals.get(i).getHostile())
				{
					 result += "(HOSTILE)\n";
				}
				else
				{
					 result += "\n";
				}
				System.out.println(result);
			 }
			 //gets user input
			 input = in.next().toLowerCase();
			 int targetAnimalIndex = -1;
			 //j is for ensuring that there is only one of the animals
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
			 //TODO Add dead animal checking earlier (somewhere in here)
			 attack(hostileAnimals.get(targetAnimalIndex));
			//ask player who they want to attack
			//if(parsed.contains(animal name)) then forge questioning the player
			//follow same process for figuring out what weapon to use.
		}
		else if(parsed.contains("enter building"))
		{
			if(map.getMapAtPos(player.getPosition()).getBuildings().size() == 1)
			{
				player.setCurrentBuilding(0);
			}
			else
			{
				StringTokenizer st = new StringTokenizer(input, " ");
				int target = 0;
				for(int i = 0; i < map.getMapAtPos(player.getPosition()).getBuildings().size(); i++)
				{
					if (map.getMapAtPos(player.getPosition()).getBuilding(i).getDescription().contains(st.nextToken()))
					{
						target = i;
					}
				}
				player.setCurrentBuilding(target);
			}
		}
		
		else if(parsed.contains("description"))
		{
			if(player.getCurrentBuilding() == -1)
			{
					System.out.println(map.getMapAtPos(player.getPosition()).getDescription());
			}
			else
			{
					System.out.println(map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getDescription());
			}
		}
		//moving rooms between buildings
		if((parsed.equals("left") || parsed.equals("right") || parsed.equals("forward") || parsed.equals("back")) && (player.getCurrentBuilding() != -1))
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
		if((parsed.equals("upstairs") || parsed.equals("downstairs")) && (player.getCurrentBuilding() != -1))
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
		//leaving buildings entirely
		if(parsed.equals("leave"))
		{
			player.setCurrentRoom(-1);
			player.setCurrentFloor(-1);
			player.setCurrentBuilding(-1);
		}	
		if (parsed.equals("pick up"))
		{
			String itemName = in.nextLine().toLowerCase();
			boolean itemExists = false;
			//need to scan through every available object that a player can pick up in the room
			//match the name to the name of each object
			//ensure no duplicates
			//then remove that one object from the arraylist in the room and put it in the players arraylist
			//figure out something special for armor
			
			//scans through the weapons in the room
			for(int i = 0; i < map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getWeapons().size(); i++)
			{
				if(map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getWeapon(i).getName().equals(itemName))
				{
					player.addWeapon(map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getWeapon(i));
					map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).removeWeapon(i);
					System.out.println("You picked up the " + map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getWeapon(i).getName());
					itemExists = true;
					break;
				}
			}
			for(int i = 0; i < map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getConsumables().size(); i++)
			{
				if(map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getConsumable(i).getName().equals(itemName))
				{
					player.addConsumable(map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getConsumable(i));
					map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).removeConsumable(i);
					System.out.println("You picked up the " + map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getConsumable(i).getName());
					itemExists = true;
					break;
				}
			}
			for(int i = 0; i < map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getUtilities().size(); i++)
			{
				if(map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getUtility(i).getName().equals(itemName))
				{
					player.addUtility(map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getUtility(i));
					map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).removeUtility(i);
					System.out.println("You picked up the " + map.getMapAtPos(player.getPosition()).getBuilding(player.getCurrentBuilding()).getFloor(player.getCurrentFloor()).getRoom(player.getCurrentRoom()).getUtility(i).getName());
					itemExists = true;
					break;
				}
			}
			if(itemExists == false)
			{
				System.out.println("That item doesn't exist!");
			}
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
	@SuppressWarnings({ "resource", "unused" })
	public void attack(Animal target)
	{
		//this is where all the actual attacking happens
		//TODO check for weapon names in original input
		System.out.println("what do you want to attack with");
		for(int i = 0; i < player.getWeapons().size(); i++)
		{
			System.out.println(player.getWeapons().get(i).getName());
		}
		//weapon selection
		Scanner scanner = new Scanner(System.in);
		int weaponSelection = scanner.nextInt();
		Weapon weapon = player.getWeapons().get(weaponSelection);
		if(target.getAlive())
		{
			if(player.getAmtOfType(weapon.getAmmoType()) > 0)
			{
				//PLAYER IS ATTACKING
				//TODO integrate HS probability (more damage dealt if HS)
				//TODO integrate effective range (if out of range, misses) (inapplicable)
				//TODO integrate aim time (enemy might get in 2 attacks in the time it takes you to do one
				//decrementing the target's health
				target.setHealth(target.getHealth() - weapon.getAtkDmg());
				//decrementing ammo
				player.remove1RoundOfType(weapon.getAmmoType());
				//changing the wear of the weapon
				weapon.setWear(weapon.getWear() - weapon.getWearPerShot());
				
				//ENEMY IS ATTACKING
				if(player.getArmor().getArmorClass() <= target.getMaximumPenetratableArmor())
				{
					//doing damage to the player
					player.setHealth(player.getHealth() - target.getAtkDmg());
					//doing damage to the player's armor
					player.getArmor().setWear(player.getArmor().getWear() - player.getArmor().getWearPerHit());
				}
				else
				{
					System.out.println("Your armor is too powerful! The enemy cannot harm you (until your armor breaks)!");
				}
			}
			//replace the player's weapon
			player.setWeapon(weaponSelection, weapon);
		}
		else
		{
			System.out.println("The target that you have selected is dead! There is no point wasting ammo or damaging your weapons!");
		}
		
	}
}