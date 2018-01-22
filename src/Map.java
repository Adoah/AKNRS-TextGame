//map contains the object positions
public class Map 
{
	private Zone map[][][] = new Zone[25][25][2];
	public Map()
	{
		for(int i = 0; i < 25; i++)
		{
			for(int j = 0; j < 25; j++)
			{
				for(int k = 0; k < 2; k++)
				{
					map[i][j][k] = new Zone();
				}
			}
		}
	}
	public Zone[][][] getMap() 
	{
		return map;
	}
	public void setMap(Zone map[][][]) 
	{
		this.map = map;
	}
	public Zone getMapAtPos(int position[])
	{
		return map[position[0]][position[1]][position[2]];
	}
	public Zone getMapAtPos(int x, int y, int z)
	{
		return map[x][y][z];
	}
}
