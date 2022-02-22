import unittest

from game import Game


class TestBlackjack(unittest.TestCase):
    """
    Unit tests to check if the score computation is correct given a sequence of cards
    """
    def test1(self):
        test_cards_list_1 = ['A', 'A', 'A']
        test_output_1 = Game.compute_score(test_cards_list_1)
        self.assertEqual(test_output_1, 13)

    def test2(self):
        test_cards_list_3 = ['A', 'A', 'A', 'A']
        test_output_3 = Game.compute_score(test_cards_list_3)
        self.assertEqual(test_output_3, 14)

    def test3(self):
        test_cards_list_4 = ['A', 'K']
        test_output_4 = Game.compute_score(test_cards_list_4)
        self.assertEqual(test_output_4, 21)

    def test4(self):
        test_cards_list_4 = ['A', 'Q']
        test_output_4 = Game.compute_score(test_cards_list_4)
        self.assertEqual(test_output_4, 21)

    def test5(self):
        test_cards_list_4 = ['A', 'J']
        test_output_4 = Game.compute_score(test_cards_list_4)
        self.assertEqual(test_output_4, 21)

    def test6(self):
        test_cards_list_4 = ['A', '10']
        test_output_4 = Game.compute_score(test_cards_list_4)
        self.assertEqual(test_output_4, 21)

    def test7(self):
        test_cards_list_4 = ['K', 'A']
        test_output_4 = Game.compute_score(test_cards_list_4)
        self.assertEqual(test_output_4, 21)

    def test8(self):
        test_cards_list_4 = ['Q', 'A']
        test_output_4 = Game.compute_score(test_cards_list_4)
        self.assertEqual(test_output_4, 21)

    def test9(self):
        test_cards_list_4 = ['J', 'A']
        test_output_4 = Game.compute_score(test_cards_list_4)
        self.assertEqual(test_output_4, 21)

    def test10(self):
        test_cards_list_4 = ['10', 'A']
        test_output_4 = Game.compute_score(test_cards_list_4)
        self.assertEqual(test_output_4, 21)

    def test11(self):
        test_card_list_2 = ['Q', '9']
        test_output_2 = Game.compute_score(test_card_list_2)
        self.assertEqual(test_output_2, 19)

    def test12(self):
        test_card_list_2 = ['Q', 'K']
        test_output_2 = Game.compute_score(test_card_list_2)
        self.assertEqual(test_output_2, 20)

    def test13(self):
        test_card_list_2 = ['J', 'K']
        test_output_2 = Game.compute_score(test_card_list_2)
        self.assertEqual(test_output_2, 20)

    def test14(self):
        test_card_list_2 = ['Q', 'J']
        test_output_2 = Game.compute_score(test_card_list_2)
        self.assertEqual(test_output_2, 20)

    def test15(self):
        test_card_list_2 = ['Q', '10']
        test_output_2 = Game.compute_score(test_card_list_2)
        self.assertEqual(test_output_2, 20)

    def test16(self):
        test_cards_list_5 = ['6', 'Q', '7']
        test_output_5 = Game.compute_score(test_cards_list_5)
        self.assertEqual(test_output_5, 23)

    def test17(self):
        test_cards_list_8 = ['A', '2', 'J', '4', '6']
        test_output_8 = Game.compute_score(test_cards_list_8)
        self.assertEqual(test_output_8, 23)

    def test18(self):
        test_cards_list_7 = ['A', '8', '7']
        test_output_7 = Game.compute_score(test_cards_list_7)
        self.assertEqual(test_output_7, 16)

    def test19(self):
        test_cards_list_5 = ['6', 'Q', '10']
        test_output_5 = Game.compute_score(test_cards_list_5)
        self.assertEqual(test_output_5, 26)

    def test20(self):
        test_cards_list_5 = ['2', '2']
        test_output_5 = Game.compute_score(test_cards_list_5)
        self.assertEqual(test_output_5, 4)

    def test21(self):
        test_cards_list_5 = ['2', 'A']
        test_output_5 = Game.compute_score(test_cards_list_5)
        self.assertEqual(test_output_5, 13)

    def test22(self):
        test_cards_list_5 = ['2', 'A', 'A']
        test_output_5 = Game.compute_score(test_cards_list_5)
        self.assertEqual(test_output_5, 14)

    def test23(self):
        test_cards_list_5 = ['2', 'A', 'A', 'A']
        test_output_5 = Game.compute_score(test_cards_list_5)
        self.assertEqual(test_output_5, 15)

    def test24(self):
        test_cards_list_5 = ['2', 'A', 'A', 'A', 'A']
        test_output_5 = Game.compute_score(test_cards_list_5)
        self.assertEqual(test_output_5, 16)

    def test_dealt_two_cards(self):
        """
        unit tests to check if player and dealer were dealt 2 cards each in the beginning and if those dealt cards were
        removed from the total deck of cards.
        :return:
        """
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


if __name__ == '__main__':
    unittest.main()