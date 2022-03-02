from random import shuffle


class Deck:
    def __init__(self):
        cards_ordered = ['A', 'K', 'Q', 'J', '2', '3', '4', '5', '6', '7', '8', '9', '10'] * 4
        self.cards = shuffle_cards(cards_ordered)

    def random_draw(self) -> str:
        """
        Pops the last element from the randomly shuffled card deck
        :return: string
        """
        return self.cards.pop()


def shuffle_cards(cards):
    shuffle(cards)
    return cards
