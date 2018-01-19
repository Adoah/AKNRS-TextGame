/*
 this class was imported on 11/16/2017 by Kayden
 */

import java.util.Random;

public class Crate
{
	//TODO generate array of all crate-droppable items
	//builds an array of random ints
	Random rand = new Random();
	public void buildCrate() 
	{
		int a[] = new int[5];
		for(int i = 0; i < 5; i++) 
		{
			a[i] = rand.nextInt();
		}
	}
	//TODO have this array of ints reference the crate-droppable item array, and match files up.
}