#include <iostream>
#include <stdio.h>
#include <stdlib.h>

#include "tests.h"

int main()
{
	Tests t;
	auto start = std::chrono::system_clock::now();
	t.test_dealt_two_cards();
	t.test_score_compute();
	t.test_both_blackjack();
	t.test_dealer_stand_win();
	t.test_player_stand_win();
	t.test_dealer_bust();
	t.test_player_tie();
	t.test_player_busts();
	t.test_player_blackjack();
	auto end = std::chrono::system_clock::now();	
	std::chrono::duration<double, std::milli> fp_ms = end - start;
	std::cout << "Time elapsed for the whole test " << fp_ms.count() << " ms " ;
	return 0;
}
