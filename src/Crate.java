/*
 this class was imported on 11/16/2017 by Kayden
 */

import java.util.Random;

public class Crate{

	// needs an arraylist ArrayList<>
  Random rand = new Random();
  
  //make an array of x values, fill it with the random number gen.
  
  public void buildCrate(){
  
  int a[] = new int[5]; 
  //declaration and instantiation.
  for(int i = 0; i < 5; i++)
  {
    a[i] = rand.nextInt();
  }
  
  }
  

}