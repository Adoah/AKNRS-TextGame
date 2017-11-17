import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class MainWnd
{	
	private Shell shell = new Shell();
	private Button button1 = new Button(shell, SWT.PUSH);
	private Button button2 = new Button(shell, SWT.PUSH);
	private Button button3 = new Button(shell, SWT.PUSH);
	private Button button4 = new Button(shell, SWT.PUSH);
	private Button button5 = new Button(shell, SWT.PUSH);
	private Label label2 = new Label(shell, SWT.NONE);
	private Label label1 = new Label(shell, SWT.NONE);
	private Text text = new Text(shell, SWT.NONE);
	//guiInfo guiinfo = new guiInfo(button1, button2, button3, button4, button5, text, label1, label2);
	WindowManager windowmanager;
	Runner runner;
	ArrayList<Building> buildings = new ArrayList<>();
	Map map = new Map();
	Player player  = new Player();
	
	public void SetupObject(Map map, Player player)
	{
		this.map = map;
		this.player = player;
	}
	
	public void refreshWindow()
	{
		/*
		button1 = guiinfo.getButton1();
		button2 = guiinfo.getButton2();
		button3 = guiinfo.getButton3();
		button4 = guiinfo.getButton4();
		button5 = guiinfo.getButton5();
		label1 = guiinfo.getLabel1();
		label2 = guiinfo.getLabel2();
		text = guiinfo.getText();
		shell.redraw();
		*/
		
		button1 = windowmanager.getButton1();
		button2 = windowmanager.getButton2();
		button3 = windowmanager.getButton3();
		button4 = windowmanager.getButton4();
		label1 = windowmanager.getLabel1();
		label2 = windowmanager.getLabel2();
		text = windowmanager.getText();
		shell.redraw();
		shell.layout();
	}
	//TODO - get it to redraw the window properly. something is being really stupid
	//TODO - get the text box to work
	//TODO - get all the buttons working
	//seems like everything stays after the redraw, and all the things added by the redraw function don't work
	public MainWnd()
	{
		//Runner runner = new Runner();
		final Display display = Display.getDefault();
		//shell = new Shell(display);
		Splash splash = new Splash();
		splash.splashScreen();
		
		windowmanager = new WindowManager(shell, display);
		windowmanager.switchToMenuWindow();
		refreshWindow();
		//creating all the listeners for buttons and the text box
		button1.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				label2.setText("Starting game!");
				windowmanager.switchToMainWindow();
				refreshWindow();
				//shell.layout();
				//shell.redraw();
				//call other Window correctly
			}
		});
		button2.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				label2.setText("ZOOM");
				
				//call other Window correctly
			}
		});
		button3.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				label2.setText("wooooopppp");
				
				//call other Window correctly
			}
		});
		button4.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				label2.setText("zzzzzzzzzzzzzzzzzzzzzzzzzzzz");
				
			}
		});
		text.addListener(SWT.Traverse, new Listener()
		{
			@Override
			public void handleEvent(Event event)
			{
				if(event.detail == SWT.TRAVERSE_RETURN)
				{
					System.out.println("ENTER PRESSED!");
					System.out.println(text.getText());
					text.setText("");
				}
			}
		});
		
		
		
		
		
		
		//shell.setLayout(new FillLayout());
		
		//label2 = new Label(shell, SWT.NONE);
		//0 for main game window, 1 for menu		
		
		//opening the shell
		shell.setBounds(100, 100, 800, 315);
		shell.setText("Alex's Text Adventure!");
		shell.open();
		//shell.addMouseMoveListener(e -> showSize(e));
		//label2.addMouseMoveListener(e -> showSize(e));
		while (!shell.isDisposed())
		{
			if(!display.readAndDispatch())
			{
				display.sleep();
			}
		}
		display.dispose();
	}
	/*
	public static void showSize(MouseEvent e)
	{
		int x = e.x;
		int y = e.y;
		String s = "bounds for label: " + label2.getBounds() + "\n";
		s+= "bounds for shell: " + shell.getBounds() + "\n";
		s+= "mouse pointer: " + x + " " + y;
		label2.setText(s);
	}
	*/
	
	public Text getText()
	{
		return this.text;
	}

	
	
	//unused getters and setters
	/*
	public void setLabel(Label label)
	{
		this.label = label;
		label.redraw();
	}
	public Label getLabel()
	{
		return this.label;
	}
	public void setShell(Shell shell)
	{
		this.shell = shell;
		shell.redraw();
	}
	public Shell getShell()
	{
		return this.shell;
	}
	public void setText(Text text)
	{
		MainWnd.text = text;
	}
	public Text getText()
	{
		return text;
	}
	public String getLabelText() 
	{
		return LabelText;
	}
	public void setLabelText(String labelText) 
	{
		label.setText(labelText);
		label.redraw();
	}
	*/
}