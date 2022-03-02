from typing import List

from deck import Deck


class Game:
    def __init__(self):
        self.deck = Deck()
        self.game_over = False
        self.player_cards = []
        self.dealer_cards = []
        self.player_score = 0
        self.dealer_score = 0
        self.player_input_to_continue = True

    def deal_initial_player_cards(self):
        """
        Deal 2 random cards to player and update the corresponding player score
        :return: None
        """
        card1 = self.deck.random_draw()
        card2 = self.deck.random_draw()
        self.player_cards.append(card1)
        self.player_cards.append(card2)
        self.player_score = self.compute_score(self.player_cards)

    def deal_initial_dealer_cards(self):
        """
        Deal 2 random cards to dealer and update the corresponding dealer score
        :return: None
        """
        card1 = self.deck.random_draw()
        card2 = self.deck.random_draw()
        self.dealer_cards.append(card1)
        self.dealer_cards.append(card2)
        self.dealer_score = self.compute_score(self.dealer_cards)

    @staticmethod
    def compute_score(cards_list: List[str]) -> int:
        """
        Takes a list of cards and computes the final score
        :param cards_list:
        :return: The sum of the integer score
        """
        sum_cards = 0
        for card in cards_list:
            if card.isdigit():
                sum_cards += int(card)
            elif card == 'K' or card == 'Q' or card == 'J':
                sum_cards += 10
            else:
                sum_cards += 11
        if 'A' in cards_list:
            count = 0
            for card in cards_list:
                if card == 'A':
                    count = count + 1

            while sum_cards > 21 and count > 0:
                sum_cards -= 10
                count = count - 1
        return sum_cards

    def player_game(self):
        """
        Main function which runs the player part of the game, updates score and exits when any of the exit criteria are met
        :return:
        """
        while self.player_input_to_continue and self.game_over is False:
            if self.player_score == 21:
                print(f"Dealer has: {self.dealer_cards[0]} ? = ?")
                print(f"Player has: {self.player_cards} =  {self.player_score} ")
                print("Player wins!")
                print("Blackjack!")
                self.game_over = True
            else:
                print(f"Dealer has: {self.dealer_cards[0]} ? = ?")
                print(f"Player has:{self.player_cards} = {self.player_score}")
                val = input("Would you like to (H)it or (S)tand?")
                if val == 'H':
                    card = self.deck.random_draw()
                    self.player_cards.append(card)
                    self.player_score = self.compute_score(self.player_cards)
                    if self.player_score > 21:
                        self.game_over = True
                        print(f"Player busts with {self.player_cards} = {self.player_score}")
                        print("Dealer wins")
                else:
                    print(f"Player stands with: {self.player_cards} = {self.player_score}")
                    self.player_input_to_continue = False
        self.dealer_game()

    def dealer_game(self):
        """
        Main function which runs the dealer part of the game, updates score and exits when any of the exit criteria are met
        :return:
        """
        while self.game_over is False:
            print(f"Dealer has:{self.dealer_cards} = {self.dealer_score}")
            if self.dealer_score > 21:
                print("Player wins!")
                print(
                    f"Player's {self.player_cards} = {self.player_score} to Dealer's {self.dealer_cards} = {self.dealer_score}")
                self.game_over = True
            elif self.dealer_score < 17:
                while self.dealer_score <= 17:
                    print("Dealer hits")
                    card = self.deck.random_draw()
                    self.dealer_cards.append(card)
                    self.dealer_score = self.compute_score(self.dealer_cards)
                    print(f"Dealer has:{self.dealer_cards}")
            else:
                print("Dealer stands")
                if self.dealer_score > self.player_score:
                    print("Dealer wins!")
                    self.game_over = True
                    print(
                        f"Dealer's {self.dealer_cards} ={self.dealer_score} to Player's {self.player_cards} = {self.player_score}")
                elif self.dealer_score == self.player_score:
                    print("It's a tie. Game ends")
                    self.game_over = True
                else:
                    print("Player wins!")
                    self.game_over = True
                    print(
                        f"Player's {self.player_cards} = {self.player_score} to Dealer's {self.dealer_cards} = {self.dealer_score}")
