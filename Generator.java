import java.util.Random;

public class Generator {
public static void main(String[] args) {
Random r= new Random();
int [] coeff = new int[2];
coeff[0]= r.nextInt(4)+1;
coeff[1]= r.nextInt(8)+1;
int constant= r.nextInt(4)+1;
String eqtn= "+" + coeff[0] + "x^2" + "-"+coeff[1]+"x^1+"+ constant+"=0";
System.out.println(eqtn);

	
}
}
