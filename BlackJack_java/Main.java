import java.util.*;

class Deck{
    List<String> cards = new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J", "A",
                "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J", "A",
                "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J", "A",
                "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J", "A"));

    public void shuffle_cards(){
        Collections.shuffle(cards);
    }
    public String random_draw(){
        Random rand= new Random();
        int randomIndex= rand.nextInt(cards.size());
        String randomElement= cards.get(randomIndex);
        cards.remove(randomElement);
        return randomElement;
    }
}

class Game extends Deck{
    Deck d1= new Deck();
    Boolean game_over = false;
    List<String> player_cards = new ArrayList<>();
    List<String> dealer_cards = new ArrayList<>();
    int player_score =0, dealer_score=0;
    Boolean player_input_to_continue = true;

    public void deal_initial_player_cards(){
        String card1= d1.random_draw();
        String card2= d1.random_draw();
        player_cards.add(card1);
        player_cards.add(card2);
        player_score = compute_score(player_cards);
    }
    public void deal_initial_dealer_cards(){
        String card1= d1.random_draw();
        String card2= d1.random_draw();
        dealer_cards.add(card1);
        dealer_cards.add(card2);
        dealer_score = compute_score(dealer_cards);
    }
    public static int compute_score(List<String> cards){
        int sum_cards =0;
        for(int i=0; i<cards.size(); i++){
            String temp= cards.get(i);
            boolean isNumeric = temp.chars().allMatch( Character::isDigit ); //to check if the string is digit
            if(isNumeric == true){
                sum_cards+= Integer.parseInt(temp);
            }
            else if (temp == "K" || temp == "Q" || temp == "J")
                sum_cards+=10;
            else
                sum_cards+=11;
        }
        if (cards.contains("A")){
            int count=0;
            for(int i=0; i< cards.size(); i++){
                String temp= cards.get(i);
                if(temp == "A")
                    count++;
            }
            while (sum_cards>21 && count>0){
                sum_cards-=10;
                count--;
            }
        }
        return sum_cards;
    }
    public void run_game(){
        while(player_input_to_continue == true && game_over == false){
            if(player_score == 21){
                System.out.println("Dealer has: "+dealer_cards.get(0) + " ? = ?");
                System.out.println("Player has: "+ player_cards + " = " + player_score);
                System.out.println("Player wins!");
                System.out.println("Blackjack!");
                game_over = true;
            }
            else{
                Scanner scan = new Scanner(System.in);
                System.out.println("Dealer has: "+dealer_cards.get(0) + " ? = ?");
                System.out.println("Player has: "+ player_cards + " = " + player_score);
                System.out.println("Would you like to (H)it or (S)tand?");
                String val = scan.next();
                if(val.equals("H")){
                    String card= d1.random_draw();
                    player_cards.add(card);
                    player_score = compute_score(player_cards);
                    if(player_score > 21){
                        game_over = true;
                        System.out.println("Player busts with "+ player_cards + " = " + player_score);
                        System.out.println("Dealer wins");
                    }
                }
                else{
                    System.out.println("Player stands with "+ player_cards + " = " + player_score);
                    player_input_to_continue = false;
                }
            }
        }
        while (game_over == false){
            System.out.println("Dealer has: "+ dealer_cards + " = " + dealer_score);
            if(dealer_score > 21){
                System.out.println("Player wins!");
                System.out.println("Player's" + player_cards + " = " + player_score + " to Dealer's" + dealer_cards + " = " + dealer_score);
                game_over=true;
            }
            else if (dealer_score < 17){
                while(dealer_score<=17){
                    System.out.println("Dealer hits");
                    String card= d1.random_draw();
                    dealer_cards.add(card);
                    dealer_score = compute_score(dealer_cards);
                    System.out.println("Dealer has: "+ dealer_cards);
                }
            }
            else{
                System.out.println("Dealer stands");
                if(dealer_score > player_score){
                    System.out.println("Dealer wins!");
                    game_over = true;
                    System.out.println("Dealer's" + dealer_cards + " = " + dealer_score + " to Player's" + player_cards + " = " + player_score);
                }
                else if( dealer_score == player_score){
                    System.out.println("It's a tie. Game ends");
                    game_over= true;
                }
                else{
                    System.out.println("Player wins!");
                    System.out.println("Player's" + player_cards + " = " + player_score + " to Dealer's" + dealer_cards + " = " + dealer_score);
                    game_over = true;
                }
            }
        }
    }
}


class Main {
    public static void main(String[] args) {
        Game g1= new Game();
        g1.deal_initial_player_cards();
        g1.deal_initial_dealer_cards();
        g1.run_game();
    }
}
