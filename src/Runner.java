import java.util.ArrayList;
import java.util.Scanner;
/*
 * this class runs the program.
 * This game is a classic Zork style text adventure.
 * 
 */

public class Runner 
{
	//private static Label TmpLabel;
	public static void main(String[] args)
	{
		Splash splash = new Splash();
		splash.splashScreen();
		Gameplay gameplay = new Gameplay();
	}	
	public void Wait(double timer)
	{
		try {
            Thread.sleep((long) (timer*1000));
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
	}
}
