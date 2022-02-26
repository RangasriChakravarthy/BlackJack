import unittest
from unittest import mock
from datetime import datetime, timedelta

from game import Game


class TestBlackjack(unittest.TestCase):
    """
    Unit tests to check if the score computation is correct given a sequence of cards
    """

    def test_score_compute(self):
        old = datetime.now()

        test_cards_list_1 = ['A', 'A', 'A']
        test_output_1 = Game.compute_score(test_cards_list_1)
        self.assertEqual(test_output_1, 13)

        test_cards_list_2 = ['A', 'A', 'A', 'A']
        test_output_2 = Game.compute_score(test_cards_list_2)
        self.assertEqual(test_output_2, 14)

        test_cards_list_3 = ['A', 'K']
        test_output_3 = Game.compute_score(test_cards_list_3)
        self.assertEqual(test_output_3, 21)

        test_cards_list_4 = ['A', 'Q']
        test_output_4 = Game.compute_score(test_cards_list_4)
        self.assertEqual(test_output_4, 21)

        test_cards_list_5 = ['A', 'J']
        test_output_5 = Game.compute_score(test_cards_list_5)
        self.assertEqual(test_output_5, 21)

        test_cards_list_6 = ['A', '10']
        test_output_6 = Game.compute_score(test_cards_list_6)
        self.assertEqual(test_output_6, 21)

        test_cards_list_7 = ['K', 'A']
        test_output_7 = Game.compute_score(test_cards_list_7)
        self.assertEqual(test_output_7, 21)

        test_cards_list_8 = ['Q', 'A']
        test_output_8 = Game.compute_score(test_cards_list_8)
        self.assertEqual(test_output_8, 21)

        test_cards_list_9 = ['J', 'A']
        test_output_9 = Game.compute_score(test_cards_list_9)
        self.assertEqual(test_output_9, 21)

        test_cards_list_10 = ['10', 'A']
        test_output_10 = Game.compute_score(test_cards_list_10)
        self.assertEqual(test_output_10, 21)

        test_card_list_11 = ['Q', '9']
        test_output_11 = Game.compute_score(test_card_list_11)
        self.assertEqual(test_output_11, 19)

        test_card_list_12 = ['Q', 'K']
        test_output_12 = Game.compute_score(test_card_list_12)
        self.assertEqual(test_output_12, 20)

        test_card_list_13 = ['J', 'K']
        test_output_13 = Game.compute_score(test_card_list_13)
        self.assertEqual(test_output_13, 20)

        test_card_list_14 = ['Q', 'J']
        test_output_14 = Game.compute_score(test_card_list_14)
        self.assertEqual(test_output_14, 20)

        test_card_list_15 = ['Q', '10']
        test_output_15 = Game.compute_score(test_card_list_15)
        self.assertEqual(test_output_15, 20)

        test_cards_list_16 = ['6', 'Q', '7']
        test_output_16 = Game.compute_score(test_cards_list_16)
        self.assertEqual(test_output_16, 23)

        test_cards_list_17 = ['A', '2', 'J', '4', '6']
        test_output_17 = Game.compute_score(test_cards_list_17)
        self.assertEqual(test_output_17, 23)

        test_cards_list_18 = ['A', '8', '7']
        test_output_18 = Game.compute_score(test_cards_list_18)
        self.assertEqual(test_output_18, 16)

        test_cards_list_19 = ['6', 'Q', '10']
        test_output_19 = Game.compute_score(test_cards_list_19)
        self.assertEqual(test_output_19, 26)

        test_cards_list_20 = ['2', '2']
        test_output_20 = Game.compute_score(test_cards_list_20)
        self.assertEqual(test_output_20, 4)

        test_cards_list_21 = ['2', 'A']
        test_output_21 = Game.compute_score(test_cards_list_21)
        self.assertEqual(test_output_21, 13)

        test_cards_list_22 = ['2', 'A', 'A']
        test_output_22 = Game.compute_score(test_cards_list_22)
        self.assertEqual(test_output_22, 14)

        test_cards_list_23 = ['2', 'A', 'A', 'A']
        test_output_23 = Game.compute_score(test_cards_list_23)
        self.assertEqual(test_output_23, 15)

        test_cards_list_24 = ['2', 'A', 'A', 'A', 'A']
        test_output_24 = Game.compute_score(test_cards_list_24)
        self.assertEqual(test_output_24, 16)

        new = datetime.now()
        runtime = new - old
        print(runtime.microseconds / 1000)

    def test_dealt_two_cards(self):
        """
        unit tests to check if player and dealer were dealt 2 cards each in the beginning and if those dealt cards were
        removed from the total deck of cards.
        :return:
        """
        old = datetime.now()

        g = Game()
        g.deal_initial_dealer_cards()
        len_1 = len(g.dealer_cards)
        self.assertEqual(len_1, 2)

        cards_len = len(g.deck.cards)
        self.assertEqual(cards_len, 50)

        g.deal_initial_player_cards()
        len_2 = len(g.player_cards)
        self.assertEqual(len_2, 2)

        cards_len = len(g.deck.cards)
        self.assertEqual(cards_len, 48)

        new = datetime.now()
        runtime = new - old
        print(runtime.microseconds / 1000)

    '''mocking scenarios: creating exact scenarios to mimic the game, to get specific results'''
    '''Scenario 1: '''

    @mock.patch('builtins.input', side_effect=['H'])  # setting what action the player will take. In this case, player hits once
    @mock.patch("deck.shuffle_cards", return_value=['7'] * 7)  # modifying the deck of cards to have only the card 7, 7 times, so that only 7 is returned every time a card is drawn
    def test_player_blackjack(self, mock_shuffle, mock_input):
        old = datetime.now()  # to capture time before start

        g = Game()
        g.deal_initial_dealer_cards()
        g.deal_initial_player_cards()
        g.run_game()

        new = datetime.now()  # to capture time at end
        runtime = new - old  # calculating difference
        print(runtime.microseconds / 1000)  # printing time

    @mock.patch('builtins.input', side_effect=['H'])
    @mock.patch("deck.shuffle_cards", return_value=['10'] * 7)
    def test_player_bust(self, mock_shuffle, mock_input):
        old = datetime.now()

        g = Game()
        g.deal_initial_dealer_cards()
        g.deal_initial_player_cards()
        g.run_game()

        new = datetime.now()
        runtime = new - old
        print(runtime.microseconds / 1000)

    @mock.patch('builtins.input', side_effect=['S'])
    @mock.patch("deck.shuffle_cards", return_value=['10'] * 7)
    def test_player_tie(self, mock_shuffle, mock_input):
        old = datetime.now()

        g = Game()
        g.deal_initial_dealer_cards()
        g.deal_initial_player_cards()
        g.run_game()

        new = datetime.now()
        runtime = new - old
        print(runtime.microseconds / 1000)

    @mock.patch('builtins.input', side_effect=['S'])
    @mock.patch("deck.shuffle_cards", return_value=['J', 'K', 'Q', '5', '10'])
    def test_dealer_bust(self, mock_shuffle, mock_input):
        old = datetime.now()

        g = Game()
        g.deal_initial_dealer_cards()
        g.deal_initial_player_cards()
        g.run_game()

        new = datetime.now()
        runtime = new - old
        print(runtime.microseconds / 1000)

    @mock.patch('builtins.input', side_effect=['S'])
    @mock.patch("deck.shuffle_cards", return_value=['J', 'K', 'Q', '8', '10'])
    def test_player_stand_win(self, mock_shuffle, mock_input):
        old = datetime.now()

        g = Game()
        g.deal_initial_dealer_cards()
        g.deal_initial_player_cards()
        g.run_game()

        new = datetime.now()
        runtime = new - old
        print(runtime.microseconds / 1000)

    @mock.patch('builtins.input', side_effect=['S'])
    @mock.patch("deck.shuffle_cards", return_value=['J', 'J', '9', 'A', 'Q'])
    def test_dealer_stand_win(self, mock_shuffle, mock_input):
        old = datetime.now()

        g = Game()
        g.deal_initial_dealer_cards()
        g.deal_initial_player_cards()
        g.run_game()

        new = datetime.now()
        runtime = new - old
        print(runtime.microseconds / 1000)


if __name__ == '__main__':
    unittest.main()
