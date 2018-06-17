package Assignment;
import java.util.Random;

public class Dice {
	int sides = 0;
	Random rand = new Random();
	
	public Dice(int sides) {
		this.sides = sides;
	}
	
	public int rollDice() {
		int result = rand.nextInt(sides);
		return result+1;
	}
	
	public String rollDice2() {
		int result = rand.nextInt(2);
		if(result==0) {
			return "False";
		}
		else {
			return "True";
		}
	}
}
