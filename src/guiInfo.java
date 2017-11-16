import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class guiInfo 
{
	private Shell shell;
	private Display display;
	private Button button1 = new Button(shell, SWT.PUSH);
	private Button button2 = new Button(shell, SWT.PUSH);
	private Button button3 = new Button(shell, SWT.PUSH);
	private Button button4 = new Button(shell, SWT.PUSH);
	private Button button5 = new Button(shell, SWT.PUSH);
	private Text text = new Text(shell, SWT.PUSH);
	private Label label1 = new Label(shell, SWT.PUSH);
	private Label label2 = new Label(shell, SWT.PUSH);
	public guiInfo(Shell shell, Display display)
	{
		this.display = display;
		this.shell = shell;
	}
	public guiInfo(Button button1, Button button2, Button button3, Button button4, Button button5, Text text, Label label1, Label label2) 
	{
		// TODO Auto-generated constructor stub
		this.button1 = button1;
		this.button2 = button2;
		this.button3 = button3;
		this.button4 = button4;
		this.button5 = button5;
		this.text = text;
		this.label1 = label1;
		this.label2 = label2;
	}
	public void changeAll(Button button1, Button button2, Button button3, Button button4, Button button5, Text text, Label label1, Label label2)
	{
		this.button1 = button1;
		this.button2 = button2;
		this.button3 = button3;
		this.button4 = button4;
		this.button5 = button5;
		this.text = text;
		this.label1 = label1;
		this.label2 = label2;
	}
	public guiInfo sendAll()
	{
		return this;
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
	public Button getButton5() {
		return button5;
	}
	public void setButton5(Button button5) {
		this.button5 = button5;
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
