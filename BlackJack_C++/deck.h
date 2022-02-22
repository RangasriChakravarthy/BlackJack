#include <string>
#include <vector>
#include <algorithm>
#include <random> 
#include <chrono>

using namespace std;

class Deck {

public:
	vector<string> cards = {"A", "K", "Q", "J", "2", "3", "4", "5", "6", "7", "8", "9", "10",
	                       		"A", "K", "Q", "J", "2", "3", "4", "5", "6", "7", "8", "9", "10",
						   		"A", "K", "Q", "J", "2", "3", "4", "5", "6", "7", "8", "9", "10",
						   		"A", "K", "Q", "J", "2", "3", "4", "5", "6", "7", "8", "9", "10"};


	Deck() {
		unsigned seed = std::chrono::system_clock::now().time_since_epoch().count();
		shuffle(cards.begin(),cards.end(),default_random_engine(seed));
	}

	string draw(){	
		string draw_card = cards.back();
		cards.pop_back();
		return draw_card;
        }	      
};

