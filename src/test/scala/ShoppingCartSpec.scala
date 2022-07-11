package hmrc.exercise

import org.scalatest._
import hmrc.exercise.ShoppingCart

class ShoppingCartSpec extends wordspec.AnyWordSpec {

  "Shopping cart calculation" should {
    "return 2.05" in {
      val totalPrice = ShoppingCart.calcTotalPrice("Apple", "Apple","Orange", "Apple")
      assert(totalPrice == 2.05)
    }

    "return 0.60" in {
         val totalPrice = ShoppingCart.calcTotalPrice("Apple")
        assert(totalPrice == 0.60)
    }

    "return 0.85" in {
         val totalPrice = ShoppingCart.calcTotalPrice("Apple", "Orange")
        assert(totalPrice == 0.85)
    }

    "throw Invalid Product exception" in {
        assertThrows[Exception](ShoppingCart.calcTotalPrice("Banana"))
    }
  }

  "Shopping cart with discount calculation" should {

    "calculate 0 items" in {
      val totalPrice = ShoppingCart.calcTotalPriceWithDiscount()
      assert(totalPrice == 0.0)
    }

    "calculate 1 apples" in {
      val totalPrice = ShoppingCart.calcTotalPriceWithDiscount("Apple")
      assert(totalPrice == 0.60)
    }

    "calculate 2 apples" in {
      val totalPrice = ShoppingCart.calcTotalPriceWithDiscount("Apple", "Apple")
      assert(totalPrice == 0.60)
    }

    "calculate 3 apples" in {
      val totalPrice = ShoppingCart.calcTotalPriceWithDiscount("Apple", "Apple", "Apple")
      assert(totalPrice == 1.20)
    }

    "calculate 4 apples" in {
      val totalPrice = ShoppingCart.calcTotalPriceWithDiscount("Apple", "Apple", "Apple", "Apple")
      assert(totalPrice == 1.20)
    }

    "calculate 3 oranges" in {
      val totalPrice = ShoppingCart.calcTotalPriceWithDiscount("Orange", "Orange", "Orange")
      assert(totalPrice == 0.25)
    }

    "calculate 4 oranges" in {
      val totalPrice = ShoppingCart.calcTotalPriceWithDiscount("Orange", "Orange", "Orange", "Orange")
      assert(totalPrice == 0.25)
    }

  } 
}