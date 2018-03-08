import java.util.ArrayList;

public class Building 
{
	private ArrayList<Floor> Floors = new ArrayList<>();
	private String description;
	
	public Building()
	{
		Floors.add(new Floor());
	}
	public Building(int floors)
	{
		for (int i = 0; i < floors; i++)
		{
			Floors.add(new Floor());
		}
	}
	public ArrayList<Floor> getFloors() 
	{
		return Floors;
	}
	//for returning a specific floor
	public Floor getFloor(int index)
	{
		return Floors.get(index);
	}
	public int getNumberOfFloors()
	{
		return Floors.size();
	}

	public void setFloors(ArrayList<Floor> floors) 
	{
		Floors = floors;
	}
	public void addFloors(int floors)
	{
		for (int i = 0; i < floors; i++)
		{
			Floors.add(new Floor());
		}
	}
	public String toString()
	{
		String s = null;
		for (int i = 0; i < Floors.size(); i++)
		{
			s += Floors.get(i).toString();
		}
		return s;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
