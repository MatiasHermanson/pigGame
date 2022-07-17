import java.util.*;
import javax.swing.*;

public class PigGame {
	
	public static void main(String[] args) {
		
		final int WIN_SCORE = 100;
		int num_dice = 0;
		int num_players = 0;

		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> players = new ArrayList();
		ArrayList<Integer> scores = new ArrayList();
  		
		do {
			System.out.println("How many dice do you want to roll at one time? (1 or 2): ");
			num_dice = sc.nextInt();
		}while (num_dice < 1 || num_dice > 2);
		
		do {
			System.out.println("Enter the number of players: (1 or 2)");
			num_players = sc.nextInt();
		}while(num_players < 1 || num_players > 2);
			
		
		for(int i = 0; i < num_players; i++) {
			System.out.println("Enter player " + (i + 1) + "'s name: ");
			players.add(sc.next());
			scores.add(0);
		}
		for(int j = 0; j < players.size(); j++) {
			
			String name = players.get(j);
			int score = scores.get(j);
			int die1 = 0, die2 = 0;
			char c;
			Random rand = new Random();
			
			System.out.println(name + ", its your current turn. Your current score is " + score);
			System.out.println();
			
			
			do {
				System.out.println("(R)oll the dice. ");
				c = sc.next().charAt(0);
			}while(c != 'r' && c != 'R');
			
			for(int k = score; k < WIN_SCORE; k += (die1 + die2)) {
				
				die1 = rand.nextInt(6) + 1;
				
				if(num_dice == 2) {

					die2 = rand.nextInt(6) + 1;
					System.out.println("You rolled a  " +  die1 +" and a " + die2);
				} else {
					
					System.out.println("You rolled a " + die1);
				}
			
				if(die1 == 1 && die2 == 1) {
				
					scores.set(j,0);
					System.out.println("---------- SNAKE EYES / TURN OVER ----------");
					break;
				} else if(die1 == 1 || die2 == 1) {
					scores.set(j,0);
					System.out.println("---------- YOU ROLLED A ONE / TURN OVER ----------");
					break;
				}
			
				do { 
				
					System.out.println("Would you like to (R)oll or (H)old? ");
					c = sc.next().charAt(0);
				
				} while (c != 'r' && c != 'R' && c != 'h' && c != 'H');
			
				if(c == 'h' || c == 'H') {
					scores.set(j, k + die1 + die2);
					break;
				}	
			}
			
			if(scores.get(j) >= WIN_SCORE) {
				System.out.println("Congratulations " + name + ", you won with " + scores.get(j) + " points.");
				break;
			}else if(j == players.size() -1) {
				j = -1;
			}
		}
	}
}

