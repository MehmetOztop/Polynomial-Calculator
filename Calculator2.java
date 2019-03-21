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
public class Calculator2 extends JFrame {

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
	public Calculator2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEnterTheEquation = new JTextField();
		txtEnterTheEquation.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				txtEnterTheEquation.setText(" ");
			}
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
											 
						 
						 }
					 System.out.println("Coefficients: ");
					 for(int j=0; j<coef.size(); j++) {
							
							System.out.println(coef.get(j));
						}
					
					 System.out.println("The constant number: " + constant);
					 
					 System.out.println(powers);
					 degree= powers.get(0);
					 for(int k=0; k<powers.size(); k++) {
						if(powers.get(k)<degree) {
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
		   double disc= Math.sqrt(b*b - 4 *a*c);
		   
	if(disc>0) {	   double x1= (-b + disc) / (2 * a);
		   double x2= (-b - disc) / (2 * a);
		    
		   textField.setText("x1= " +x1 + " x2= " +x2);
		   
	}
	if(disc==0) {
		double x3=-b/ (2*a);
		
		textField.setText("x= " +x3);
	}
	if(disc<0) {
		
		textField.setText("No real roots");
	}
	   }
			        }
				
			}
		});
		txtEnterTheEquation.setBounds(101, 57, 299, 41);
		contentPane.add(txtEnterTheEquation);
		txtEnterTheEquation.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(101, 150, 350, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(Double.toString(result)); 
		
		
		
		lblResult = new JLabel("Result");
		lblResult.setBounds(106, 125, 46, 14);
		contentPane.add(lblResult);
		
		lblEnterAnd = new JLabel("Enter a polynomial up to 2nd degree");
		lblEnterAnd.setBounds(130, 11, 203, 32);
		contentPane.add(lblEnterAnd);
	}
}
