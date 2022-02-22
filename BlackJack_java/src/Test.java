import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Test {
    //Unit tests to check if the score computation is correct given a sequence of cards
    @org.junit.jupiter.api.Test
    void test1() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("A", "A", "A"));
        int score = Game.compute_score(test_cards);
        assertEquals(13,score);
    }

    @org.junit.jupiter.api.Test
    void test2() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("A", "A", "A", "A"));
        int score = Game.compute_score(test_cards);
        assertEquals(14,score);
    }

    @org.junit.jupiter.api.Test
    void test3() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("A", "K"));
        int score = Game.compute_score(test_cards);
        assertEquals(21,score);
    }

    @org.junit.jupiter.api.Test
    void test4() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("A", "Q"));
        int score = Game.compute_score(test_cards);
        assertEquals(21,score);
    }

    @org.junit.jupiter.api.Test
    void test5() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("A", "J"));
        int score = Game.compute_score(test_cards);
        assertEquals(21,score);
    }

    @org.junit.jupiter.api.Test
    void test6() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("A", "10"));
        int score = Game.compute_score(test_cards);
        assertEquals(21,score);
    }

    @org.junit.jupiter.api.Test
    void test7() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("K", "A"));
        int score = Game.compute_score(test_cards);
        assertEquals(21,score);
    }

    @org.junit.jupiter.api.Test
    void test8() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("Q", "A"));
        int score = Game.compute_score(test_cards);
        assertEquals(21,score);
    }

    @org.junit.jupiter.api.Test
    void test9() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("J", "A"));
        int score = Game.compute_score(test_cards);
        assertEquals(21,score);
    }

    @org.junit.jupiter.api.Test
    void test10() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("10", "A"));
        int score = Game.compute_score(test_cards);
        assertEquals(21,score);
    }

    @org.junit.jupiter.api.Test
    void test11() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("Q", "9"));
        int score = Game.compute_score(test_cards);
        assertEquals(19,score);
    }

    @org.junit.jupiter.api.Test
    void test12() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("Q", "K"));
        int score = Game.compute_score(test_cards);
        assertEquals(20,score);
    }

    @org.junit.jupiter.api.Test
    void test13() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("J", "K"));
        int score = Game.compute_score(test_cards);
        assertEquals(20,score);
    }

    @org.junit.jupiter.api.Test
    void test14() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("Q", "J"));
        int score = Game.compute_score(test_cards);
        assertEquals(20,score);
    }

    @org.junit.jupiter.api.Test
    void test15() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("Q", "10"));
        int score = Game.compute_score(test_cards);
        assertEquals(20,score);
    }

    @org.junit.jupiter.api.Test
    void test16() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("6", "7", "Q"));
        int score = Game.compute_score(test_cards);
        assertEquals(23,score);
    }

    @org.junit.jupiter.api.Test
    void test17() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("A", "2", "J", "4", "6"));
        int score = Game.compute_score(test_cards);
        assertEquals(23,score);
    }

    @org.junit.jupiter.api.Test
    void test18() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("A", "8", "7"));
        int score = Game.compute_score(test_cards);
        assertEquals(16,score);
    }

    @org.junit.jupiter.api.Test
    void test19() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("6", "Q", "10"));
        int score = Game.compute_score(test_cards);
        assertEquals(26,score);
    }

    @org.junit.jupiter.api.Test
    void test20() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("2", "2"));
        int score = Game.compute_score(test_cards);
        assertEquals(4,score);
    }

    @org.junit.jupiter.api.Test
    void test21() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("2", "A"));
        int score = Game.compute_score(test_cards);
        assertEquals(13,score);
    }

    @org.junit.jupiter.api.Test
    void test22() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("2", "A", "A"));
        int score = Game.compute_score(test_cards);
        assertEquals(14,score);
    }

    @org.junit.jupiter.api.Test
    void test23() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("2", "A", "A", "A"));
        int score = Game.compute_score(test_cards);
        assertEquals(15,score);
    }

    @org.junit.jupiter.api.Test
    void test24() {
        List<String> test_cards = new ArrayList<>(Arrays.asList("2", "A", "A", "A", "A"));
        int score = Game.compute_score(test_cards);
        assertEquals(16,score);
    }

    /*unit tests to check if player and dealer were dealt 2 cards each in the beginning and if those dealt cards were
    removed from the total deck of cards.*/
    @org.junit.jupiter.api.Test
    void test25() {
        Game g = new Game();

        g.deal_initial_player_cards();
        int len1= g.player_cards.size();
        assertEquals(2,len1);
        int deck_len = g.d1.cards.size();
        assertEquals(50,deck_len);

        g.deal_initial_dealer_cards();
        int len2= g.dealer_cards.size();
        assertEquals(2,len2);
        deck_len= g.d1.cards.size();
        assertEquals(48,deck_len);

    }
}