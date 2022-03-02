#include <iostream>
#include <stdio.h>
#include <stdlib.h>

#include "game.h"

int main()
{
	Game g;
	g.deal_initial_dealer_cards();
	g.deal_initial_player_cards();
	g.player_game();
	return 0;
}
