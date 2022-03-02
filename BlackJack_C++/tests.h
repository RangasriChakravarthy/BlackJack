#include <stdio.h>

#include "game.h"
using namespace std;

class Tests {
public:
    int test_output;
    vector<string> test_cards;
    Game g;
    void checkScore(int game_score,int exp_score) {
        if(game_score == exp_score)
		    cout << "Test passed" <<endl;
	    else 
		    throw std::invalid_argument( "Score tests failed" );
    }

    //unit tests to check if the score computation is correct given a sequence of cards
    void test1() {
        test_cards = {"A", "A", "A"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 13);
    }

    void test2() {
        test_cards = {"A", "A", "A", "A"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 14);
    }

    void test3() {
        test_cards = {"A", "K"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 21);
    }

    void test4() {
        test_cards = {"A", "Q"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 21);
    }

    void test5() {
        test_cards = {"A", "J"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 21);
    }

    void test6() {
        test_cards = {"A", "10"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 21);
    }

    void test7() {
        test_cards = {"K", "A"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 21);
    }

    void test8() {
        test_cards = {"Q", "A"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 21);
    }

    void test9() {
        test_cards = {"J", "A"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 21);
    }

    void test10() {
        test_cards = {"10", "A"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 21);
    }

    void test11() {
        test_cards = {"Q", "9"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 19);
    }

    void test12() {
        test_cards = {"Q", "K"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 20);
    }

    void test13() {
        test_cards = {"J", "K"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 20);
    }

    void test14() {
        test_cards = {"Q", "J"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 20);
    }

    void test15() {
        test_cards = {"Q", "10"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 20);
    }

    void test16() {
        test_cards = {"6", "Q", "7"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 23);
    }

    void test17() {
        test_cards = {"A", "2", "J", "4", "6"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 23);
    }

    void test18() {
        test_cards = {"A", "8", "7"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 16);
    }

    void test19() {
        test_cards = {"6", "Q", "10"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 26);
    }

    void test20() {
        test_cards = {"2", "2"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 4);
    }

    void test21() {
        test_cards = {"2", "A"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 13);
    }

    void test22() {
        test_cards = {"2", "A", "A"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 14);
    }

    void test23() {
        test_cards = {"2", "A", "A", "A"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 15);
    }

    void test24(){
        test_cards = {"2", "A", "A", "A", "A"};
        test_output = g.compute_score(test_cards);
        checkScore(test_output, 16);
    }

    void test_dealt_two_cards(){
        //unit tests to check if player and dealer were dealt 2 cards each in the beginning and if those dealt cards were
        //removed from the total deck of cards
       
        int cards_len = 52;
        g.deal_initial_dealer_cards();
        cards_len = g.dealer_cards.size();
        if(cards_len == 2) {cout << "Initial two cards are dealt for dealer" << endl;}
        else {throw std::invalid_argument("Wrong card dealt");}

        cards_len = g.deck.cards.size();
        if(cards_len == 50) {cout << "Deck size is 50 now" << endl;}
        else {throw std::invalid_argument("Wrong deck size");}

        g.deal_initial_player_cards();
        cards_len = g.player_cards.size();
        if(cards_len == 2) {cout << "Initial two cards are dealt for dealer" << endl;}
        else {throw std::invalid_argument("Wrong card dealt");}

        cards_len = g.deck.cards.size();
        if(cards_len == 48) {cout << "Deck size is 48 now" << endl;}
        else {throw std::invalid_argument("Wrong deck size");}

    }

    void test_score_compute(){
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
        test11();
        test12();
        test13();
        test14();
        test15();
        test16();
        test17();
        test18();
        test19();
        test20();
        test21();
        test22();
        test23();
        test24();
    }

    void test_player_blackjack() {
        cout << " test_player_blackjack " << endl;
        g.deck.cards = {"7", "7", "7", "7", "7", "7", "7", "7"};
        g.deal_initial_dealer_cards();
        g.deal_initial_player_cards();
        g.compute_score(g.player_cards);
        g.compute_score(g.dealer_cards);
        cout << "Dealer has: "+g.dealer_cards[0] + " ? = ?" ;
        cout << "Player has : ";
		g.print_cards(g.player_cards);
		cout << " = " << g.player_score << " " << endl;
        cout << "Would you like to (H)it or (S)tand?" << endl;
        cout << "H" << endl;
        string card = g.deck.random_draw();
        g.player_cards.push_back(card);
        g.player_score = g.compute_score(g.player_cards);
        if(g.player_score == 21){
            cout << "Dealer has: "+g.dealer_cards[0] + " ? = ?" ;
            cout << "Player has : ";
			g.print_cards(g.player_cards);
			cout << " = " << g.player_score << " " << endl;
			cout << "Player wins!!!" << endl;
			cout << "BlackJack";
        }
    }

    void test_player_busts() {
        cout << " test_player_busts " << endl;
        g.deck.cards = {"10", "10", "10", "10", "10", "10", "10", "10"};
        g.deal_initial_dealer_cards();
        g.deal_initial_player_cards();
        g.compute_score(g.player_cards);
        g.compute_score(g.dealer_cards);
        cout << "Dealer has: "+g.dealer_cards[0] + " ? = ?" ;
        cout << "Player has : ";
		g.print_cards(g.player_cards);
		cout << " = " << g.player_score << " " << endl;
        cout << "Would you like to (H)it or (S)tand?" << endl;
        cout << "H" << endl;
        string card = g.deck.random_draw();
        g.player_cards.push_back(card);
        g.player_score = g.compute_score(g.player_cards);
        if(g.player_score > 21){
            cout << "Player busts with ";
			g.print_cards(g.player_cards);
			cout << " = " << g.player_score << endl;
			cout << "Dealer wins!!!" << endl;
        }
    }

    void test_player_tie() {
        cout << " test_player_tie " << endl;
        g.deck.cards = {"10", "10", "10", "10", "10", "10", "10", "10"};
        g.deal_initial_dealer_cards();
        g.deal_initial_player_cards();
        g.compute_score(g.player_cards);
        g.compute_score(g.dealer_cards);
        cout << "Dealer has: "+g.dealer_cards[0] + " ? = ?" ;
        cout << "Player has : ";
		g.print_cards(g.player_cards);
		cout << " = " << g.player_score << " " << endl;
        cout << "Would you like to (H)it or (S)tand?" << endl;
        cout << "S" << endl;
        cout << "Player stands with " ;
        g.print_cards(g.player_cards);
        cout << " = " + g.player_score << " " << endl;
        g.dealer_game();
    }

    void test_dealer_bust() {
        cout << " test_dealer_bust " << endl;
        g.deck.cards = {"J", "K", "Q","10"};
        g.player_cards= {"J", "K"};
        g.dealer_cards= {"10", "5"};
        g.dealer_score = g.compute_score(g.dealer_cards);
        g.player_score = g.compute_score(g.player_cards);
        cout << "Dealer has: "+g.dealer_cards[0] + " ? = ?" ;
        cout << "Player has : ";
		g.print_cards(g.player_cards);
		cout << " = " << g.player_score << " " << endl;
        cout << "Would you like to (H)it or (S)tand?" << endl;
        cout << "S" << endl;
        cout << "Player stands with " ;
        g.print_cards(g.player_cards);
        cout << " = " + g.player_score << " " << endl;
        g.dealer_game();
    }

    void test_player_stand_win() {
        cout << " test_player_stand_win " << endl;
        g.deck.cards = {"J", "K", "Q","10"};
        g.player_cards= {"J", "K"};
        g.dealer_cards= {"10", "8"};
        g.dealer_score = g.compute_score(g.dealer_cards);
        g.player_score = g.compute_score(g.player_cards);
        cout << "Dealer has: "+g.dealer_cards[0] + " ? = ?" << endl;
        cout << "Player has : ";
		g.print_cards(g.player_cards);
		cout << " = " << g.player_score << " " << endl;
        cout << "Would you like to (H)it or (S)tand?" << endl;
        cout << "S" << endl;
        cout << "Player stands with " ;
        g.print_cards(g.player_cards);
        cout << " = " + g.player_score << " " << endl;
        g.dealer_game();
    }

    void test_dealer_stand_win() {
        cout << " test_dealer_stand_win " << endl;
        g.player_cards= {"8", "K"};
        g.dealer_cards= {"10", "Q"};
        g.dealer_score = g.compute_score(g.dealer_cards);
        g.player_score = g.compute_score(g.player_cards);
        cout << "Dealer has: "+g.dealer_cards[0] + " ? = ?"  << endl;
        cout << "Player has : ";
		g.print_cards(g.player_cards);
		cout << " = " << g.player_score << " " << endl;
        cout << "Would you like to (H)it or (S)tand?" << endl;
        cout << "S" << endl;
        cout << "Player stands with " ;
        g.print_cards(g.player_cards);
        cout << " = " + g.player_score << " " << endl;
        g.dealer_game();
    }

    void test_both_blackjack() {
        cout << " test_both_blackjack " << endl;
        g.player_cards=  {"A", "K"};
        g.dealer_cards=  {"10", "A"};
        g.dealer_score = g.compute_score(g.dealer_cards);
        g.player_score = g.compute_score(g.player_cards);
        g.player_game();
    }
};
