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
};
