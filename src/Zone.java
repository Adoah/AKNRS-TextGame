import java.util.ArrayList;

public class Zone 
{
	private ArrayList<Building> buildings = new ArrayList<>();
	private String description = null;
	private boolean hasVisit;
	private String label;
	public Zone()
	{
		
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	public ArrayList<Building> getBuildings() 
	{
		return buildings;
	}
	public void addBuildings(int number)
	{
		for(int i = 0; i < number; i++)
		{
			this.buildings.add(new Building());
		}
	}
	public void setBuildings(ArrayList<Building> buildings) 
	{
		this.buildings = buildings;
	}
	public Building getBuilding(int index)
	{
		return this.buildings.get(index);
	}

	public String toString()
	{
		return this.description;
	}
	public boolean getHasVisit() {
		return hasVisit;
	}
	public void setHasVisit(boolean hasVisit) {
		this.hasVisit = hasVisit;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
}
