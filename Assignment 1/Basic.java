package Assignment;
import java.util.Scanner;

public class Basic {
	static Dice d;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter no of sides in the dice");
		int sides = in.nextInt();
		
		if(sides<2) {
			System.out.println("Not Possible");
		}
		else if(sides == 2) {
			d = new Dice(2);
			System.out.println(d.rollDice2());
		}
		else {
			d = new Dice(sides);
			System.out.println(d.rollDice());
		}
	}

}
