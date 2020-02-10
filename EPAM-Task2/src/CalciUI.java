import java.awt.*;
import java.awt.event.*;
public class CalciUI extends Frame {
	TextField op1;
	Button sum;
	TextField op2;
	Button diff;
	Button mul;
	Button div;
	Label equal;
	Label Error;
	TextField result;
	
	public CalciUI(){
		initializeComponents();
		addComponentsToFrame();
		addListenerInterfaces();
	}
	
	private void initializeComponents() {
		op1=new TextField(10);
		sum = new Button("+");
		diff = new Button("-");
		mul = new Button("*");
		div = new Button("/");
		op2=new TextField(10);
		result=new TextField(10);
		equal=new Label("=");
		result.setEditable(false);

	}
	
	private void addComponentsToFrame() {
		setLayout(new FlowLayout());
		add(op1);
		add(sum);
		add(diff);
		add(mul);
		add(div);
		add(op2);
		add(equal);
		add(result);
	} 
	
	private void addListenerInterfaces() {
		addWindowListener(new WindowClosingAdapter());
		sum.addActionListener(new CalciActionListener());
		diff.addActionListener(new CalciActionListener());
		div.addActionListener(new CalciActionListener());
		mul.addActionListener(new CalciActionListener());
	
	}
	private class WindowClosingAdapter extends WindowAdapter
	{
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	private class CalciActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			CalciConvModel cCM=new CalciConvModel();
			try{
				int o1=Integer.parseInt(op1.getText());
				
				int o2=Integer.parseInt(op2.getText());
				cCM.setOper1(o1);
				cCM.setOper2(o2);
				if(e.getSource()==sum) {
					cCM.add();
				}
				if(e.getSource()==div) {
					cCM.div();
				}
				if(e.getSource()==diff) {
					cCM.sub();
				}
				if(e.getSource()==mul) {
					cCM.mul();
				}
			}
			catch(Exception E) {
				Error=new Label("You better add some values");
				add(Error);
			}
			result.setText(String.valueOf(cCM.getRes()));

			
		}
		
	}
}
