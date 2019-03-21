import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.JButton;
public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterTheEquation;
	private JTextField textField;
    private String eqtn;
    private double result;
    private JLabel lblResult;
    private ArrayList<Integer> coef= new ArrayList<Integer>();
    private int degree, constant;
    private ArrayList<Integer> powers= new ArrayList<Integer>();
    private JLabel lblEnterAnd;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 12));
		setTitle("Polynomial Calculator");
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 351);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEnterTheEquation = new JTextField();
		txtEnterTheEquation.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 13));
		txtEnterTheEquation.setForeground(Color.YELLOW);
		txtEnterTheEquation.setBackground(Color.LIGHT_GRAY);
		txtEnterTheEquation.addMouseListener(new MouseAdapter() {
		
		});
		txtEnterTheEquation.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 if (e.getKeyCode() == KeyEvent.VK_ENTER)
			        {
			         eqtn = txtEnterTheEquation.getText();
			         System.out.println(eqtn);
			        
			         
			         char[] polynom= new char [eqtn.length()];
					 polynom= eqtn.toCharArray();
					 for(int i=0; i<polynom.length; i++) {
						 if (polynom[i]=='x') {
							 if(polynom[i+1] == '^') {
							 powers.add(Character.getNumericValue(polynom[i+2]));
							 }
							 if(polynom[i-2] == '-') {
								 coef.add(- Character.getNumericValue(polynom[i-1]));
							 }
							 else if(polynom[i-2]!= '-') {
							 coef.add(Character.getNumericValue(polynom[i-1]));}
							 
							 
						 }
						 if(polynom[polynom.length - 4] =='-') {
							 constant= - Character.getNumericValue(polynom[polynom.length -3]);
							  
						 }
						 else if(polynom[polynom.length - 4] =='+') {
						 constant= Character.getNumericValue(polynom[polynom.length -3]);
						 }
						 /* for two digit constants
						 else if(polynom[polynom.length - 5] =='-') {
							 String temp= Integer.toString(Character.getNumericValue( polynom[polynom.length - 4] ))+ Integer.toString(Character.getNumericValue(polynom[polynom.length - 5]));
							 constant= - Integer.parseInt(temp);
							  
						 }
						 else if(polynom[polynom.length - 5] =='+') {
							 String temp= Integer.toString(Character.getNumericValue( polynom[polynom.length - 4] ))+ Integer.toString(Character.getNumericValue(polynom[polynom.length - 5]));
							 constant= Integer.parseInt(temp);
							  
						 }*/
						 
						 
						 
						 }
					 System.out.println("Coefficients: ");
					 for(int j=0; j<coef.size(); j++) {
							
							System.out.println(coef.get(j));
						}
					
					 System.out.println("The constant number: " + constant);
					 
					 System.out.println(powers);
					 degree= powers.get(0);
					 for(int k=0; k<powers.size(); k++) {
						if(powers.get(k)>degree) {
							degree=powers.get(k);
						}
					 }
					 System.out.println("The degree of the polynomial: " + degree);
		
		if(degree==1) {
			double a0= coef.get(0);
			double b0= constant;
			double x0= -b0 / a0;
			
			textField.setText("x= " +x0);
		}
		else if(degree==2) {
		   double a = coef.get(0);
		   double b= coef.get(1);
		   double c= constant;
		   
		   System.out.println("a: " +a +" b: " + b +" c: " +c);
		   System.out.println("b^2: " +(b*b) + " 4ac: " + (4*a*c));
		   double disc= b*b - 4*a*c;
		   double discF= Math.sqrt((b*b) - (4 *a*c));
		   
		   System.out.println("Delta: " +disc);
		   
	if(disc>0) {
		
		double x1= (-b + discF) / (2 * a);
		   double x2= (-b - discF) / (2 * a);
		      
		   textField.setText("x1= " +x1 + " x2= " +x2);
		   
		   
		   
	}
	else if(disc==0) {
		double x3=-b/ (2*a);
		
		textField.setText("x= " +x3);
	}
	else if(disc<0) {
		textField.setText("No real roots");
	}
	   }
		
		else if(degree==3) {
			double a= coef.get(0);
			double b= coef.get(1);
			double c= coef.get(2);
			double d= constant;
			
			double sumOfAllRoots= -b / a;
			double mulOfAllRoots= -d / a;
			double sumCouples= c/a;
			
			
			textField_1.setText(Double.toString(sumOfAllRoots));
			textField_2.setText(Double.toString(mulOfAllRoots));
			textField_3.setText(Double.toString(sumCouples));
			
			
			
			
		}
			        }
				
			}
		});
		txtEnterTheEquation.setBounds(101, 57, 350, 41);
		contentPane.add(txtEnterTheEquation);
		txtEnterTheEquation.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 13));
		textField.setForeground(Color.YELLOW);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(101, 142, 350, 41);
		contentPane.add(textField);
		textField.setColumns(10);
	
		
		
		
		lblResult = new JLabel("Result");
		lblResult.setFont(new Font("Segoe UI Light", Font.BOLD, 16));
		lblResult.setForeground(Color.WHITE);
		lblResult.setBounds(232, 109, 69, 22);
		contentPane.add(lblResult);
		
		lblEnterAnd = new JLabel("Enter a polynomial up to the 3rd degree");
		lblEnterAnd.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		lblEnterAnd.setForeground(Color.WHITE);
		lblEnterAnd.setBounds(118, 14, 325, 32);
		contentPane.add(lblEnterAnd);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				powers= new ArrayList<Integer>();
				coef=  new ArrayList<Integer>();
				txtEnterTheEquation.setText(" ");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				
			}
		});
		btnReset.setForeground(new Color(255, 255, 204));
		btnReset.setFont(new Font("MS Gothic", Font.BOLD, 18));
		btnReset.setBackground(new Color(204, 0, 51));
		btnReset.setBounds(223, 269, 90, 32);
		contentPane.add(btnReset);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		textField_1.setForeground(Color.CYAN);
		textField_1.setBackground(Color.GRAY);
		textField_1.setBounds(101, 226, 55, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		textField_2.setForeground(Color.CYAN);
		textField_2.setBackground(Color.GRAY);
		textField_2.setBounds(246, 226, 55, 32);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		textField_3.setForeground(Color.CYAN);
		textField_3.setBackground(Color.GRAY);
		textField_3.setBounds(439, 226, 55, 32);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("x1+x2+x3=");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 236, 81, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("x1.x2.x3=");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(166, 235, 70, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("x1.x2+x1.x3+x2.x3=");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(311, 235, 118, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblOfThisrd = new JLabel("Of this 3rd Degree Polynomial");
		lblOfThisrd.setForeground(Color.WHITE);
		lblOfThisrd.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblOfThisrd.setBounds(166, 194, 248, 21);
		contentPane.add(lblOfThisrd);
	}
}
