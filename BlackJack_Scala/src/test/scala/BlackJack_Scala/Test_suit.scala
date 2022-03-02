package BlackJack_Scala
import org.scalatest.FreeSpec
import scala.collection.mutable.ListBuffer

class BlackJack_Tester extends FreeSpec {
  "Test score compute" in {
     assert(test_score_compute == true)
   }

   "test_deal_Cards" in {
     assert(test_deal_Cards == true)
   }

   def test_score_compute() : Boolean = {
    val t1 = System.currentTimeMillis()
    //Test1
    val card1:ListBuffer[String] = ListBuffer("A","A","A")
    assert(Game.compute_score(card1) == 13)

    //Test2
    val card2:ListBuffer[String] = ListBuffer("A", "A", "A", "A")
    assert(Game.compute_score(card2) == 14)

    //Test3
     val card3:ListBuffer[String] = ListBuffer("A", "K")
     assert(Game.compute_score(card3) == 21)
  
   //Test4
     val card4:ListBuffer[String] = ListBuffer("A", "Q")
     assert(Game.compute_score(card4) == 21)
   
    //Test5
     val card5:ListBuffer[String] = ListBuffer("A", "J")
     assert(Game.compute_score(card5) == 21)

    //Test6
     val card6:ListBuffer[String] = ListBuffer("A", "10")
     assert(Game.compute_score(card6) == 21)

    //Test7
     val card7:ListBuffer[String] = ListBuffer("K","A")
     assert(Game.compute_score(card7) == 21)

     //Test8
     val card8:ListBuffer[String] = ListBuffer("Q","A")
     assert(Game.compute_score(card8) == 21)

    //Test9
     val card9:ListBuffer[String] = ListBuffer("J", "A")
     assert(Game.compute_score(card9) == 21)
   
    //Test10
     val card10:ListBuffer[String] = ListBuffer("10", "A")
     assert(Game.compute_score(card10) == 21)

    //Test11
     val card11:ListBuffer[String] = ListBuffer("Q","9")
     assert(Game.compute_score(card11) == 19)
  
    //Test12
    val card12:ListBuffer[String] = ListBuffer("Q","K")
    assert(Game.compute_score(card12) == 20)
 
    //Test13
    val card13:ListBuffer[String] = ListBuffer("J","K")
    assert(Game.compute_score(card13) == 20)

    //Test14
     val card14:ListBuffer[String] = ListBuffer("Q","J")
     assert(Game.compute_score(card14) == 20)
   
     //Test15
     val card15:ListBuffer[String] = ListBuffer("Q","10")
     assert(Game.compute_score(card15) == 20)
   
     //Test16   
     val card16:ListBuffer[String] = ListBuffer("6","7","Q")
     assert(Game.compute_score(card16) == 23)   

     //Test17
     val card17:ListBuffer[String] = ListBuffer("A", "2" ,"J","4","6")
     assert(Game.compute_score(card17) == 23)

    //test18
     val card18:ListBuffer[String] = ListBuffer("A", "8","7")
     assert(Game.compute_score(card18) == 16)   

    //Test19
     val card19:ListBuffer[String] = ListBuffer("6", "Q", "10")
     assert(Game.compute_score(card19) == 26)

    //Test20   
     val card20:ListBuffer[String] = ListBuffer("2", "2")
     assert(Game.compute_score(card20) == 4)

     //Test21   
     val card21:ListBuffer[String] = ListBuffer("2", "A")
     assert(Game.compute_score(card21) == 13)
   
    //Test22
     val card22:ListBuffer[String] = ListBuffer("2", "A", "A")
     assert(Game.compute_score(card22) == 14) 

    //Test23   
     val card23:ListBuffer[String] = ListBuffer("2", "A", "A", "A")
     assert(Game.compute_score(card23) == 15)
   
     //Test24
     val card24:ListBuffer[String] = ListBuffer("2", "A", "A", "A", "A")
     assert(Game.compute_score(card24) == 16)

     val duration = System.currentTimeMillis() - t1
     println("Total time for Test score compute : " + duration + " ms")
     true     
   }

   def test_deal_Cards(): Boolean = {
        val old= System.currentTimeMillis(); //measures time at start
        Game.deal_initial_player_cards();
        val len1= Game.player_cards.size;
        assert(len1 == 2);
        Game.deal_initial_dealer_cards();
        val len2= Game.dealer_cards.size;
        assert(len2 == 2);  
        val diff= System.currentTimeMillis() - old; // difference in time
        println("Total time for test_deal_Cards : " + diff + " ms")
        true
    }
}

