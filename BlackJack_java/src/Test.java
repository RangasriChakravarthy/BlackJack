import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Test {

    //Unit tests to check if the score computation is correct given a sequence of cards
    @org.junit.jupiter.api.Test
    void test_score_compute() {
        long old= System.currentTimeMillis(); //measures time at start

        List<String> test_cards1 = new ArrayList<>(Arrays.asList("A", "A", "A"));
        int score1 = Game.compute_score(test_cards1);
        assertEquals(13,score1);

        List<String> test_cards2 = new ArrayList<>(Arrays.asList("A", "A", "A", "A"));
        int score2 = Game.compute_score(test_cards2);
        assertEquals(14,score2);

        List<String> test_cards3 = new ArrayList<>(Arrays.asList("A", "K"));
        int score3 = Game.compute_score(test_cards3);
        assertEquals(21,score3);

        List<String> test_cards4 = new ArrayList<>(Arrays.asList("A", "Q"));
        int score4 = Game.compute_score(test_cards4);
        assertEquals(21,score4);

        List<String> test_cards5 = new ArrayList<>(Arrays.asList("A", "J"));
        int score5 = Game.compute_score(test_cards5);
        assertEquals(21,score5);

        List<String> test_cards6 = new ArrayList<>(Arrays.asList("A", "10"));
        int score6 = Game.compute_score(test_cards6);
        assertEquals(21,score6);

        List<String> test_cards7 = new ArrayList<>(Arrays.asList("K", "A"));
        int score7 = Game.compute_score(test_cards7);
        assertEquals(21,score7);

        List<String> test_cards8 = new ArrayList<>(Arrays.asList("Q", "A"));
        int score8 = Game.compute_score(test_cards8);
        assertEquals(21,score8);

        List<String> test_cards9 = new ArrayList<>(Arrays.asList("J", "A"));
        int score9 = Game.compute_score(test_cards9);
        assertEquals(21,score9);

        List<String> test_cards10 = new ArrayList<>(Arrays.asList("10", "A"));
        int score10 = Game.compute_score(test_cards10);
        assertEquals(21,score10);

        List<String> test_cards11 = new ArrayList<>(Arrays.asList("Q", "9"));
        int score11 = Game.compute_score(test_cards11);
        assertEquals(19,score11);

        List<String> test_cards12 = new ArrayList<>(Arrays.asList("Q", "K"));
        int score12 = Game.compute_score(test_cards12);
        assertEquals(20,score12);

        List<String> test_cards13 = new ArrayList<>(Arrays.asList("J", "K"));
        int score13 = Game.compute_score(test_cards13);
        assertEquals(20,score13);

        List<String> test_cards14 = new ArrayList<>(Arrays.asList("Q", "J"));
        int score14 = Game.compute_score(test_cards14);
        assertEquals(20,score14);

        List<String> test_cards15 = new ArrayList<>(Arrays.asList("Q", "10"));
        int score15 = Game.compute_score(test_cards15);
        assertEquals(20,score15);

        List<String> test_cards16 = new ArrayList<>(Arrays.asList("6", "7", "Q"));
        int score16 = Game.compute_score(test_cards16);
        assertEquals(23,score16);

        List<String> test_cards17 = new ArrayList<>(Arrays.asList("A", "2", "J", "4", "6"));
        int score17 = Game.compute_score(test_cards17);
        assertEquals(23,score17);

        List<String> test_cards18 = new ArrayList<>(Arrays.asList("A", "8", "7"));
        int score18 = Game.compute_score(test_cards18);
        assertEquals(16,score18);

        List<String> test_cards19 = new ArrayList<>(Arrays.asList("6", "Q", "10"));
        int score19 = Game.compute_score(test_cards19);
        assertEquals(26,score19);

        List<String> test_cards20 = new ArrayList<>(Arrays.asList("2", "2"));
        int score20 = Game.compute_score(test_cards20);
        assertEquals(4,score20);

        List<String> test_cards21 = new ArrayList<>(Arrays.asList("2", "A"));
        int score21 = Game.compute_score(test_cards21);
        assertEquals(13,score21);

        List<String> test_cards22 = new ArrayList<>(Arrays.asList("2", "A", "A"));
        int score22 = Game.compute_score(test_cards22);
        assertEquals(14,score22);

        List<String> test_cards23 = new ArrayList<>(Arrays.asList("2", "A", "A", "A"));
        int score23 = Game.compute_score(test_cards23);
        assertEquals(15,score23);

        List<String> test_cards24 = new ArrayList<>(Arrays.asList("2", "A", "A", "A", "A"));
        int score24 = Game.compute_score(test_cards24);
        assertEquals(16,score24);

        long now= System.currentTimeMillis(); // measures time at end
        long diff= now- old; // difference in time
        System.out.print(diff); //print the execution time
    }

    /*unit tests to check if player and dealer were dealt 2 cards each in the beginning and if those dealt cards were
    removed from the total deck of cards.*/
    @org.junit.jupiter.api.Test
    void test_deal_Cards() {
        long old= System.currentTimeMillis(); //measures time at start
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

        long now= System.currentTimeMillis(); // measures time at end
        long diff= now- old; // difference in time
        System.out.println(diff); //print the execution time
    }

}

