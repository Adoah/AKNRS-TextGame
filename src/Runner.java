import java.util.ArrayList;
import org.eclipse.swt.widgets.Label;
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
		//splash.stayFrosty();
		//splash.enceLogo();
		Scanner input  = new Scanner(System.in);
		MainWnd MainWindow = new MainWnd(1);
		Gameplay gameplay = new Gameplay(MainWindow);
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
