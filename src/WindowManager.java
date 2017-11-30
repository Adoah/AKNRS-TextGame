import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

//change window state, redraw window

public class WindowManager 
{
	private Shell shell;
	private Display display;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Text text;
	private Label label1;
	private Label label2;
	int windowStatus;
	public WindowManager(Shell shell, Display display) 
	{
		this.display = display;
		this.shell = shell;
		//zero arg constructor
	}
	public void switchToMenuWindow()
	{
		button1 = new Button(shell, SWT.PUSH);
		button1 = new Button(shell, SWT.PUSH);
		button2 = new Button(shell, SWT.PUSH);
		button3 = new Button(shell, SWT.PUSH);
		button4 = new Button(shell, SWT.PUSH);
		label2 = new Label(shell, SWT.PUSH);
		text = new Text(shell, SWT.PUSH);
		this.windowStatus = 1;
		//Font font = new Font(label2.getDisplay(), new FontData("Mono", 10, SWT.ITALIC));
		//label2.setFont(font);
		label2.setText("Welcome to my game!\nSelect what you want to do!");
		label2.setBounds(0, 0, 800, 50);
		label2.setToolTipText("Welcome to my game! Select what you want to do!");
		label2.setBackground(display.getSystemColor(SWT.COLOR_DARK_GRAY));		
		button1.setText("Start the game!");
		button1.setBounds(0, 50, 150, 50);
		button2.setText("Resume your previous game!");
		button2.setBounds(150, 50, 200, 50);
		button3.setText("Change the colors!");
		button3.setBounds(350, 50, 150, 50);
		button4.setText("Quit");
		button4.setBounds(500, 50, 75, 50);
		text.setBounds(0, 0, 0, 0);
	}
	public void switchToMainWindow()
	{
		button1 = new Button(shell, SWT.PUSH);
		button2 = new Button(shell, SWT.PUSH);
		button3 = new Button(shell, SWT.PUSH);
		button4 = new Button(shell, SWT.PUSH);
		text = new Text(shell, SWT.PUSH);
		label1 = new Label(shell, SWT.PUSH);
		label2 = new Label(shell, SWT.PUSH);
		this.windowStatus = 0;
		//Font font = new Font(label2.getDisplay(), new FontData("Mono", 10, SWT.ITALIC));
		//label2.setFont(font);
		label2.setText("here's some text with a font applied");
		label2.setBounds(0, 0, 800, 80);
		label2.setToolTipText("Random label expressing mouse listener event");
		label2.setBackground(display.getSystemColor(SWT.COLOR_DARK_GRAY));
		
		label1.setText("Welcome to my text adventure!\nAre you ready to play?!?!");
		label1.setToolTipText("All responses to your commands will appear here");
		label1.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
		label1.setBounds(0, 80, 800, 70);
		text.setText("ENTER COMMANDS HERE!");
		text.setToolTipText("Enter all of your commands here");
		text.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
		text.setForeground(display.getSystemColor(SWT.COLOR_CYAN));
		text.setBounds(0, 150, 800, 100);
		
		button1.setText("A button");
		button1.setToolTipText("what does it do?");
		button1.setBounds(50, 250, 80, 60);
		button2.setBounds(0, 0, 0, 0);
		button3.setBounds(0, 0, 0, 0);
		button4.setBounds(130, 250, 80, 60);
		button4.setText("Quit");
		shell.setBounds(80, 80, 1280, 720);
	}
	
	public int getWindowStatus()
	{
		return this.windowStatus;
	}
	public String getWindowStatusString()
	{
		if(this.windowStatus == 1)
		{
			return "menu";
		}
		if(this.windowStatus == 0)
		{
			return "gameplay";
		}
		else
		{
			return "";
		}
	}
	public void setWindowStatus(String status)
	{
		if(status == "menu")
		{
			this.windowStatus = 1;
		}
		if(status == "gameplay")
		{
			this.windowStatus = 0;
		}
	}
	public void setWindowStatus(int status)
	{
		this.windowStatus = status;
	}
	public Button getButton1() {
		return button1;
	}
	public void setButton1(Button button1) {
		this.button1 = button1;
	}
	public Button getButton2() {
		return button2;
	}
	public void setButton2(Button button2) {
		this.button2 = button2;
	}
	public Button getButton3() {
		return button3;
	}
	public void setButton3(Button button3) {
		this.button3 = button3;
	}
	public Button getButton4() {
		return button4;
	}
	public void setButton4(Button button4) {
		this.button4 = button4;
	}
	public Text getText() {
		return text;
	}
	public void setText(Text text) {
		this.text = text;
	}
	public Label getLabel1() {
		return label1;
	}
	public void setLabel1(Label label1) {
		this.label1 = label1;
	}
	public Label getLabel2() {
		return label2;
	}
	public void setLabel2(Label label2) {
		this.label2 = label2;
	}
}
