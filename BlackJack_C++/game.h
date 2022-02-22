#include <stdio.h>
#include <string>
#include <vector>

#include "deck.h"

using namespace std;

class Game {
 
 public:
 	Deck deck; 
	bool game_over = false;
	vector<string> player_cards;
	vector<string> dealer_cards;
	int player_score = 0;
	int dealer_score = 0;
	bool player_input_to_continue = true;
 

 	void deal_initial_player_cards(){
 	
		string card1 = deck.draw();
        string card2 = deck.draw();
		player_cards.push_back(card1);
		player_cards.push_back(card2);
		player_score = compute_score(player_cards);
	}

 	void deal_initial_dealer_cards(){

 		string card1 = deck.draw();
        string card2 = deck.draw();
		dealer_cards.push_back(card1);
		dealer_cards.push_back(card2);
		dealer_score = compute_score(dealer_cards);
 	}

 	int compute_score(vector<string>& cards_list) {
		
		int sum_cards=0;
		int len= cards_list.size();
	        for(int i=0;i< len;i++){
			if (cards_list[i] == "A")
				sum_cards += 11;
			else if( cards_list[i] == "K" || cards_list[i] == "Q" || cards_list[i] == "J")
				sum_cards += 10;
			else
				sum_cards += stoi(cards_list[i]);
			}
			int count = 0;
	        for(int i=0;i< len;i++){
				if (cards_list[i] == "A")
					count = count+1;
		    }	
		
		while((sum_cards > 21) && (count > 0)){
			sum_cards -= 10;
			count = count-1;
		}
		return sum_cards;
 	}

	void print_cards(vector<string>& cards_list){
		for(int i=0;i < cards_list.size();i++){
			cout << cards_list[i] << " ";
		}
	}

 	void run_game() {
		string user_choice;
		string card;
		while((player_input_to_continue == true) && (game_over == false)){
			if(player_score == 21){
				cout << "Dealer has : " << dealer_cards[0] << " ? = ?" << endl;
				cout << "Player has : ";
				print_cards(player_cards);
				cout << " = " << player_score << " " << endl;
				cout << "Player wins!!!" << endl;
				cout << "BlackJack";
				game_over = true;
			}
			else {
				cout << "Dealer has : " << dealer_cards[0] << " ? = ?" << endl;
				cout << "Player has : ";
				print_cards(player_cards);
				cout << " " << player_score << " " << endl;
				cout << "Would you like to (H)it or (S)tand?"<<endl;
				cin >> user_choice;
				if(user_choice == "H") {
					card = deck.draw();
					player_cards.push_back(card);
					player_score = compute_score(player_cards);
					if(player_score > 21){
						game_over = true;
						cout << "Player busts with ";
						print_cards(player_cards);
						cout << " = " << player_score << endl;
						cout << "Dealer wins!!!" << endl;
					}
				}
				else {				
					cout << "Player stands with ";
					print_cards(player_cards);
					cout << " = " << player_score << endl;
					player_input_to_continue = false;
				}	
			}
 		}

		while(game_over == false){
                cout << "Dealer has: ";
				print_cards(dealer_cards);
				cout << " = " << dealer_score << endl;
			if(dealer_score > 21){
					cout << "Player wins!" << endl;
					cout << "Player's card: ";
					print_cards(player_cards);
					cout << " = " << player_score << " to Dealer's ";
					print_cards(dealer_cards);
					cout << " = " << dealer_score << endl;
                    game_over = true;
			}
            else if(dealer_score < 17){
					while(dealer_score <= 17) {
						cout << "Dealer hits" << endl;
						card = deck.draw();
						dealer_cards.push_back(card);
						dealer_score = compute_score(dealer_cards);
						cout << "Dealer has : ";
						print_cards(dealer_cards);
						cout << endl;
					}
			}
            else {
				cout << "Dealer stands" << endl;
				if(dealer_score > player_score){
					cout << "Dealer wins!" << endl;
					game_over = true;
					cout << "Dealer's ";
					print_cards(dealer_cards);
					cout << "= " << dealer_score << " to Player's ";
					print_cards(player_cards);
					cout << " = " << player_score << endl;
				}
				else if(dealer_score == player_score){
					cout << "It's a tie. Game ends" << endl;
					game_over = true;
				}
				else {
					cout << "Player wins!" << endl;
					game_over = true;
					cout << "Player's ";
					print_cards(player_cards);
					cout << " = " << player_score << " to Dealer's ";
					print_cards(dealer_cards);
					cout << " = " << dealer_score << endl;
				}
			}  
		}
	 }
};
