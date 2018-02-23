public class Weapon
{
	//attributes
	private int atkDmg;
	private double wear;
	private boolean isUsable;
	private int effectiveRange;
	private double weight;
	private double rechargeTime;
	//
	private double WearPerShot;
	private double stealth;
	private double armorPenetration;
	private int maximumPenetratableArmor;
	private double aimTime;
	//type 0 = 50cal, type 1 = 762, type 2 = 556, type 3 = 12 gauge, type 4 = 9mm
	private int ammoType;
	private String name;
	
	//constructors
	public Weapon()
	{
		this.isUsable = true;
		this.wear = 0;
		this.WearPerShot = 1;
	}
	
	public Weapon(int atkDmg, int wear, boolean isUsable)
	{
		this.atkDmg = atkDmg;
		this.wear = wear;
		this.isUsable = isUsable;
	}
	
	//mutators
	//getters
	public int getAtkDmg()
	{
		return this.atkDmg;
	}
	public double getWear()
	{
		return this.wear;
	}
	public boolean getIsUsable()
	{
		return this.isUsable;
	}
	public int getEffectiveRange()
	{
		return this.effectiveRange;
	}
	public double getWeight()
	{
		return this.weight;
	}
	public double getRechargeTime()
	{
		return this.rechargeTime;
	}
	public double getWearPerShot()
	{
		return this.WearPerShot;
	}
	public double getStealth()
	{
		return this.stealth;
	}
	public double getArmorPenetration()
	{
		return this.armorPenetration;
	}
	public int getMaximumPenetratableArmor()
	{
		return this.maximumPenetratableArmor;
	}
	public double getAimTime()
	{
		return this.aimTime;
	}
	//setters
	public void setAtkDmg(int atkDmg)
	{
		this.atkDmg = atkDmg;
	}
	public void setWear(double wear)
	{
		this.wear = wear;
	}
	public void setIsUsable(boolean isUsable)
	{
		this.isUsable = isUsable;
	}
	public void setEffectiveRange(int effectiveRange)
	{
		this.effectiveRange = effectiveRange;
	}
	public void setWeight(double weight)
	{
		this.weight = weight;
	}
	public void setRechargeTime(double rechargeTime)
	{
		this.rechargeTime = rechargeTime;
	}
	public void setWearPerShot(double WearPerShot)
	{
		this.WearPerShot = WearPerShot;
	}
	public void setStealth(double stealth)
	{
		this.stealth = stealth;
	}
	public void setArmorPenetration(double armorPenetration)
	{
		this.armorPenetration = armorPenetration;
	}
	public void setMaximumPenetratableArmor(int number)
	{
		this.maximumPenetratableArmor = number;
	}
	public void setAimTime(double aimTime)
	{
		this.aimTime = aimTime;
	}
	
	//to string method
	public String toString()
	{
		return "Attack damage: " + this.atkDmg + "\nWear of object: " + this.wear;
	}

	public String getName() 
	{
		return this.name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	public int getAmmoType() 
	{
		return ammoType;
	}
	public void setAmmoType(int ammoType) 
	{
		this.ammoType = ammoType;
	}
}
