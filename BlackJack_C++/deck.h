#include <string>
#include <vector>
#include <algorithm>
#include <random> 
#include <chrono>

using namespace std;
class Deck {
public:
	vector<string> cards_ordered = {"A", "K", "Q", "J", "2", "3", "4", "5", "6", "7", "8", "9", "10",
	                       		"A", "K", "Q", "J", "2", "3", "4", "5", "6", "7", "8", "9", "10",
						   		"A", "K", "Q", "J", "2", "3", "4", "5", "6", "7", "8", "9", "10",
						   		"A", "K", "Q", "J", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

	vector<string> cards;
	Deck() {
		cards = shuffle_cards(cards_ordered);	
	}

    vector<string>& shuffle_cards(vector<string>& cards_list) {
		unsigned seed = std::chrono::system_clock::now().time_since_epoch().count();
		shuffle(cards_list.begin(),cards_list.end(),default_random_engine(seed));
		return cards_list;
	}

	string random_draw(){	
		string draw_card = cards.back();
		cards.pop_back();
		return draw_card;
    }	      
};

