import java.util.*;

/*A class that has the methods init() and solve()
 *The cards are numbered from 1 to 9 
 *The suits are in Clubs, Diamonds, Hearts and Spades
 *Perspective of the dealer:
 *The dealer must play a card of the same suit if they can
 *If they can, they need to play the same card type, but a higher value
 *If the dealer does not have a higher rank, then play the lowest card of
 *the card type
 *If the dealer does not have the card type either, then just play the
 *lowest card regardless of the card type 
 *@version 1.0
 *@author Yidam Park 
 */
public class JR1617_Agram {
	
	static Scanner in;
	static ArrayList<Integer> cardNum;
	static String dealerSuit;
	static int dealerNum;
	
	
	public static void main(String[] args) {
		
		//create a Scanner for user input
		System.out.println("Enter the cards: ");
		in = new Scanner(System.in);
		
		//use the init() and solve() methods
		init();
		solve();
	}
	
	//initializing the variables
	//dealerNum is the rank of the card
	//dealerSuit is the card type
	//cardNum is the array of cards that is laid out
	static void init() {
		dealerNum = in.nextInt();
		dealerSuit = in.next();
		
		cardNum = new ArrayList<Integer>();
	}
	
	//solving/figuring out which card to play
	static void solve() {
		
		//5 cards need to be out, which is why limit is 5
		for(int i=0; i<5; i++) {
			int num = in.nextInt();
			String s = in.next();
			if(dealerSuit.equals(s)) {
				cardNum.add(num);
			}
		}
		
		//sort the cards and dig through the cards that has a higher rank
		//Collections.sort sorts the elements present in the specified list of Collection
		Collections.sort(cardNum);
		int ans = -1;
		for(int i=0; i<cardNum.size(); i++) {
			if(dealerNum < cardNum.get(i)) {
				ans = cardNum.get(i);
				break;
			}
		}
	
		//if the card # does not have a higher suit and rank
		//print out "NONE"
		
		if(cardNum.size() == 0) {
			System.out.println("NONE");
		}
		
		//else 
		//if answer = -1 then print higher suit
		else {
			if(ans == -1) {
				System.out.println(cardNum.get(0) + dealerSuit);
			}
			else {
				System.out.println(ans + dealerSuit);
			}
		}
	}
	
	//Test Outputs//
	//4 S 2 S 5 S 6 S 8 S 9 S => 5 S
	//7 H 3 S 3 H 3 D 3 C 2 H => 2 H
	//9 D 3 C 5 H 1 S 7 D 9 S => 7 D
	//6 C 1 S 2 H 7 S 8 D 9 H => NONE
	//1 D 2 S 3 D 4 S 2 H 2 C => 3 D
	
}
