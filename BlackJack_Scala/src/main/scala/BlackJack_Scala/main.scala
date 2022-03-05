package BlackJack_Scala
import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine
import scala.util.Random


object Deck {

var ordered_cards:ListBuffer[ListBuffer[String]] = ListBuffer(ListBuffer("A", "K", "Q", "J", "2", "3", "4", "5", "6", "7", "8", "9", "10"),
                                ListBuffer("A", "K", "Q", "J", "2", "3", "4", "5", "6", "7", "8", "9", "10"),
						   		ListBuffer("A", "K", "Q", "J", "2", "3", "4", "5", "6", "7", "8", "9", "10"),
						   		ListBuffer("A", "K", "Q", "J", "2", "3", "4", "5", "6", "7", "8", "9", "10"))

					   	
 def random_draw(): String = {
   var card = Random.shuffle(ordered_cards(0)).head
   ordered_cards(0).remove(0)
   card  
  }
}

object Game {
var game_over:Boolean = false
var player_cards = new ListBuffer[String]()
var	dealer_cards = new ListBuffer[String]()
var player_score: Int = 0;
var dealer_score: Int = 0;
var player_input_to_continue:Boolean = true;

    def deal_initial_player_cards() = {
 	
		val card1 = Deck.random_draw();
    	val card2 = Deck.random_draw();
		player_cards += card1
		player_cards += card2
		player_score = compute_score(player_cards);

	}

 	def deal_initial_dealer_cards() = {

 		val card1 = Deck.random_draw();
    	val card2 = Deck.random_draw();
		dealer_cards += card1
		dealer_cards += card2
		dealer_score = compute_score(dealer_cards);

 	}

   def compute_score(cards_list : ListBuffer[String]):Int = {
    var sum_cards:Int = 0;
		var count:Int = 0;
	  	for(card <- cards_list) {
			if (card == "A") {
				sum_cards += 11;
        		count = count+1;
      		}
			else if( card == "K" || card == "Q" || card == "J")
				sum_cards += 10;
			else
				sum_cards += card.toInt;
		}
		while((sum_cards > 21) && (count > 0)){
			sum_cards -= 10;
			count = count-1;
		}
		sum_cards
   }

   def player_game() = {
	   	while(player_input_to_continue == true && game_over == false){
            println("")
            if(player_score == 21){
                println("Dealer has: "+ dealer_cards(0) + " ? = ?");
                println("Player has: "+ player_cards + " = " + player_score);
                println("Player wins!");
                println("Blackjack!");
                game_over = true;
            }
            else{
                println("Dealer has: "+dealer_cards(0) + " ? = ?");
                println("Player has: "+ player_cards + " = " + player_score);
                println("Would you like to (H)it or (S)tand?");
                val usr_input = readLine()
                if(usr_input.equals("H")){
                    val card= Deck.random_draw();
                    player_cards += card
                    player_score = compute_score(player_cards);
                    if(player_score > 21){
                        game_over = true;
                        println("Player busts with "+ player_cards + " = " + player_score);
                        println("Dealer wins");
                    }
                }
                else{
                    println("Player stands with "+ player_cards + " = " + player_score);
                    player_input_to_continue = false;
                }
            }
        }
        dealer_game();
   }

   def dealer_game() = {
       while (game_over == false){
            println("Dealer has: "+ dealer_cards + " = " + dealer_score);
            if(dealer_score > 21){
            	println("Player wins!");
                println("Player's" + player_cards + " = " + player_score + " to Dealer's" + dealer_cards + " = " + dealer_score);
                game_over=true;
            }
            else if (dealer_score < 17){
                while(dealer_score<=17){
                    println("Dealer hits");
                    val card= Deck.random_draw();
                    dealer_cards += card;
                    dealer_score = compute_score(dealer_cards);
                    println("Dealer has: "+ dealer_cards);
                }
            }
            else{
                println("Dealer stands");
                if(dealer_score > player_score){
                    println("Dealer wins!");
                    game_over = true;
                    println("Dealer's" + dealer_cards + " = " + dealer_score + " to Player's" + player_cards + " = " + player_score);
                }
                else if( dealer_score == player_score){
                    println("It's a tie. Game ends");
                    game_over= true;
                }
                else{
                    println("Player wins!");
                    println("Player's" + player_cards + " = " + player_score + " to Dealer's" + dealer_cards + " = " + dealer_score);
                    game_over = true;
                }
            }
        }
   }

  def main(args: Array[String]): Unit = {
    deal_initial_player_cards();
    deal_initial_dealer_cards();
    player_game();
    }
}

