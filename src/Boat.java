public class Boat 
{
	//declare attributes of the object
	private String style;
	private String hoodOrniment;
	private int speed;
	//no need for zero argument constructor
	//loaded constructor
	public Boat(String brand, String model, int horsepower)
	{
		this.style = style;
		this.hoodOrniment = model;
		this.speed = speed;
	}
	//getters and setters
	public String getStyle()
	{
		return this.style;
	}
	public void setStyle(String style)
	{
		this.style = style;
	}
	public String getHoodOrniment()
	{
		return this.hoodOrniment;
	}
	public void setHoodOrniment(String hoodOrniment)
	{
		this.hoodOrniment = hoodOrniment;
	}
	public int getSpeed()
	{
		return this.speed;
	}
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
}