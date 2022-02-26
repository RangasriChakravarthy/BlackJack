package BlackJack_Scala
import org.scalatest.FreeSpec
import scala.collection.mutable.ListBuffer

class BlackJack_Tester extends FreeSpec {

  "Test 1" in {
    val cards:ListBuffer[String] = ListBuffer("A","A","A")
    assert(Game.compute_score(cards) == 13)
  }
   
  "Test 2" in {
     val cards:ListBuffer[String] = ListBuffer("A", "A", "A", "A")
     assert(Game.compute_score(cards) == 14)
  }

  "Test 3" in {
     val cards:ListBuffer[String] = ListBuffer("A", "K")
     assert(Game.compute_score(cards) == 21)
  }

  "Test 4" in {
     val cards:ListBuffer[String] = ListBuffer("A", "Q")
     assert(Game.compute_score(cards) == 21)
   }

  "Test 5" in {
     val cards:ListBuffer[String] = ListBuffer("A", "J")
     assert(Game.compute_score(cards) == 21)
  }

  "Test 6" in {
     val cards:ListBuffer[String] = ListBuffer("A", "10")
     assert(Game.compute_score(cards) == 21)
   }

  "Test 7" in {
     val cards:ListBuffer[String] = ListBuffer("K","A")
     assert(Game.compute_score(cards) == 21)
   }

  "Test 8" in {
     val cards:ListBuffer[String] = ListBuffer("Q","A")
     assert(Game.compute_score(cards) == 21)
   }

  "Test 9" in {
     val cards:ListBuffer[String] = ListBuffer("J", "A")
     assert(Game.compute_score(cards) == 21)
   }

  "Test 10" in {
     val cards:ListBuffer[String] = ListBuffer("10", "A")
     assert(Game.compute_score(cards) == 21)
   }

  "Test 11" in {
     val cards:ListBuffer[String] = ListBuffer("Q","9")
     assert(Game.compute_score(cards) == 19)
   }

  "Test 12" in {
     val cards:ListBuffer[String] = ListBuffer("Q","K")
     assert(Game.compute_score(cards) == 20)
   }

  "Test 13" in {
     val cards:ListBuffer[String] = ListBuffer("J","K")
     assert(Game.compute_score(cards) == 20)
   }

  "Test 14" in {
     val cards:ListBuffer[String] = ListBuffer("Q","J")
     assert(Game.compute_score(cards) == 20)
   }

   "Test 15" in {
     val cards:ListBuffer[String] = ListBuffer("Q","10")
     assert(Game.compute_score(cards) == 20)
   }

   "Test 16" in {
     val cards:ListBuffer[String] = ListBuffer("6","7","Q")
     assert(Game.compute_score(cards) == 23)
   }

   "Test 17" in {
     val cards:ListBuffer[String] = ListBuffer("A", "2" ,"J","4","6")
     assert(Game.compute_score(cards) == 23)
   }

   "Test 18" in {
     val cards:ListBuffer[String] = ListBuffer("A", "8","7")
     assert(Game.compute_score(cards) == 16)
   }

   "Test 19" in {
     val cards:ListBuffer[String] = ListBuffer("6", "Q", "10")
     assert(Game.compute_score(cards) == 26)
   }

   "Test 20" in {
     val cards:ListBuffer[String] = ListBuffer("2", "2")
     assert(Game.compute_score(cards) == 4)
   }

   "Test 21" in {
     val cards:ListBuffer[String] = ListBuffer("2", "A")
     assert(Game.compute_score(cards) == 13)
   }

   "Test 22" in {
     val cards:ListBuffer[String] = ListBuffer("2", "A", "A")
     assert(Game.compute_score(cards) == 14)
   }

   "Test 23" in {
     val cards:ListBuffer[String] = ListBuffer("2", "A", "A", "A")
     assert(Game.compute_score(cards) == 15)
   }

   "Test 24" in {
     val cards:ListBuffer[String] = ListBuffer("2", "A", "A", "A", "A")
     assert(Game.compute_score(cards) == 16)
   }
}

