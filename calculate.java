import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JOptionPane;

public class calculate extends JFrame implements ActionListener{
    public static final int HEIGHT = 300;
    public static final int WIDTH = 350;
    private JPanel p1;
    private JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15;
    private JTextField tf1;

    private static final int NUMBER_OF_WIDGET = 20;

	private double result = 0.0;
	private String resultString ="0.0";
	private String operator = "";
	private String value = "";
	private BigDecimal resultDecimal = new BigDecimal("0.0");
	private BigDecimal valueDecimal = new BigDecimal("0.0");
	private boolean isDecimal = false;

    public static void main(String[] args){
        calculate gui = new calculate();
        gui.setVisible(true);
    }

    public calculate(){
        super("計算機");
        setSize(HEIGHT,WIDTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        
        tf1=new JTextField("",NUMBER_OF_WIDGET);
        tf1.setEditable(false);
        add(tf1,BorderLayout.NORTH); 

        p1=new JPanel();
        p1.setBackground(Color.LIGHT_GRAY);
        p1.setLayout(new GridLayout(5,3,5,5));
        add(p1);

        btn1 = new JButton("1");
        btn1.setBackground(Color.LIGHT_GRAY);
		btn1.addActionListener(this);
        p1.add(btn1);

        btn2 = new JButton("2");
        btn2.setBackground(Color.LIGHT_GRAY);
		btn2.addActionListener(this);
        p1.add(btn2);

        btn3 = new JButton("3");
        btn3.setBackground(Color.LIGHT_GRAY);
		btn3.addActionListener(this);
        p1.add(btn3);

        btn4 = new JButton("4");
        btn4.setBackground(Color.LIGHT_GRAY);
		btn4.addActionListener(this);
        p1.add(btn4);

        btn5 = new JButton("5");
        btn5.setBackground(Color.LIGHT_GRAY);
		btn5.addActionListener(this);
        p1.add(btn5);

        btn6 = new JButton("6");
        btn6.setBackground(Color.LIGHT_GRAY);
		btn6.addActionListener(this);
        p1.add(btn6);

        btn7 = new JButton("7");
        btn7.setBackground(Color.LIGHT_GRAY);
		btn7.addActionListener(this);
        p1.add(btn7);

        btn8 = new JButton("8");
        btn8.setBackground(Color.LIGHT_GRAY);
		btn8.addActionListener(this);
        p1.add(btn8);
        
        btn9 = new JButton("9");
        btn9.setBackground(Color.LIGHT_GRAY);
		btn9.addActionListener(this);
        p1.add(btn9);

        btn10 = new JButton("+");
        btn10.setBackground(Color.LIGHT_GRAY);
		btn10.addActionListener(this);
        p1.add(btn10);
        
        btn11 = new JButton("0");
        btn11.setBackground(Color.LIGHT_GRAY);
		btn11.addActionListener(this);
        p1.add(btn11);
        
        btn12 = new JButton("-");
        btn12.setBackground(Color.LIGHT_GRAY);
		btn12.addActionListener(this);
        p1.add(btn12);
        
        btn13 = new JButton("*");
        btn13.setBackground(Color.LIGHT_GRAY);
		btn13.addActionListener(this);
        p1.add(btn13);
        
        btn14 = new JButton("=");
        btn14.setBackground(Color.LIGHT_GRAY);
		btn14.addActionListener(this);
        p1.add(btn14);
        
        btn15 = new JButton("/");
        btn15.setBackground(Color.LIGHT_GRAY);
		btn15.addActionListener(this);
        p1.add(btn15);

    }
    public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();

		if(actionCommand.equals("+")){
			calculate1();							//calculate result
			operator = "+";							//change operator
			value = "";								//initialize value
			isDecimal = false;
			tf1.setText(operator+value);				//print current operator and value
		}else if(actionCommand.equals("-")){
			calculate1();
			operator = "-";
			value = "";
			isDecimal = false;
			tf1.setText(operator+value);
		}else if(actionCommand.equals("*")){
			calculate1();
			operator = "*";
			value = "";
			isDecimal = false;
			tf1.setText(operator+value);
		}else if(actionCommand.equals("/")){
			calculate1();
			operator = "/";
			value = "";
			isDecimal = false;
			tf1.setText(operator+value);
		}else if(actionCommand.equals("=")){
			calculate1();
			//String resultString = String.valueOf(result);	
			tf1.setText(resultDecimal.toString());			//print current result
			value = "";										//initialize value
			operator = "";									//initialize operator
			isDecimal = false;								//set as false and you can click '.' again
		}else if(actionCommand.equals("0")){
			value = value+"0";
			tf1.setText(operator+value);
		}else if(actionCommand.equals("1")){
			value = value+"1";
			tf1.setText(operator+value);
		}
		else if(actionCommand.equals("2")){
			value = value+"2";
			tf1.setText(operator+value);
		}
		else if(actionCommand.equals("3")){		
			value = value+"3";
			tf1.setText(operator+value);
		}
		else if(actionCommand.equals("4")){		
			value = value+"4";
			tf1.setText(operator+value);
		}
		else if(actionCommand.equals("5")){	
			value = value+"5";
			tf1.setText(operator+value);
		}
		else if(actionCommand.equals("6")){		
			value = value+"6";
			tf1.setText(operator+value);
		}
		else if(actionCommand.equals("7")){	
			value = value+"7";
			tf1.setText(operator+value);
		}else if(actionCommand.equals("8")){
			value = value+"8";
			tf1.setText(operator+value);
		}else if(actionCommand.equals("9")){
			value = value+"9";
			tf1.setText(operator+value);
		}else if(actionCommand.equals(".")){
			if(!isDecimal){
				value = value+".";
				isDecimal = true;
			}
			tf1.setText(operator+value);
		}
	}
    public void calculate1(){
		if(!value.equals("")){						//prevent valueDouble is empty
			Double valueDouble = Double.parseDouble(value);
			valueDecimal = new BigDecimal(value);
			if(operator.equals("")){
				resultDecimal = valueDecimal;					//storage value when user uses it at first time
				//result = valueDouble;
				}else{
					if(operator.equals("+")){					//handle other operators
						//result += valueDouble;
						resultDecimal = resultDecimal.add(valueDecimal);
					}else if(operator.equals("-")){
						//result -= valueDouble;
						resultDecimal = resultDecimal.subtract(valueDecimal);
					}else if(operator.equals("*")){
						//result *= valueDouble;
						resultDecimal = resultDecimal.multiply(valueDecimal);
					}else if(operator.equals("/")){
						if(valueDouble == 0){				//show dialog if divide zero
							JOptionPane.showMessageDialog(p1, "Cannot be divided by 0", "Error message", JOptionPane.ERROR_MESSAGE);
						}else{
							//result /= valueDouble;
						resultDecimal = resultDecimal.divide(valueDecimal,5,RoundingMode.HALF_DOWN);
						}
					}	
				}
		}
	}

}

