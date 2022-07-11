package hmrc.exercise

import org.scalatest._
import hmrc.exercise.ShoppingCart

class ShoppingCartSpec extends wordspec.AnyWordSpec {

  "Shopping cart" should {
    "return £2.05" in {
      val totalPrice = ShoppingCart.calcTotalPrice("Apple", "Apple","Orange", "Apple")
      assert(totalPrice == 2.05)
    }
  } 
}