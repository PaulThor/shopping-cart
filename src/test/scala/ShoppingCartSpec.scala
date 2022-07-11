package hmrc.exercise

import org.scalatest._
import hmrc.exercise.ShoppingCart

class ShoppingCartSpec extends wordspec.AnyWordSpec {

  "Shopping cart calculation" should {
    "return £2.05" in {
      val totalPrice = ShoppingCart.calcTotalPrice("Apple", "Apple","Orange", "Apple")
      assert(totalPrice == 2.05)
    }

    "return £0.60" in {
         val totalPrice = ShoppingCart.calcTotalPrice("Apple")
        assert(totalPrice == 0.60)
    }

    "throw Invalid Product exception" in {
        assertThrows[Exception](ShoppingCart.calcTotalPrice("Banana"))
    }
  } 
}