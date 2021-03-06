package test.scala

import org.scalatest._
import main.scala.{ ShoppingCart, Apple, Orange }

class ShoppingCartSpec extends wordspec.AnyWordSpec {

  "Shopping cart calculation" should {
    "return 2.05" in {
      val totalPrice = ShoppingCart.calcTotalPrice(Apple, Apple, Orange, Apple)
      assert(totalPrice == 2.05)
    }

    "return 0.60" in {
         val totalPrice = ShoppingCart.calcTotalPrice(Apple)
        assert(totalPrice == 0.60)
    }

    "return 0.85" in {
         val totalPrice = ShoppingCart.calcTotalPrice(Apple, Orange)
        assert(totalPrice == 0.85)
    }
  }

  "Shopping cart with discount calculation" should {

    "calculate 0 items" in {
      val totalPrice = ShoppingCart.calcTotalPriceWithDiscount(Seq())
      assert(totalPrice == 0.0)
    }

    "calculate 1 apples" in {
      val totalPrice = ShoppingCart.calcTotalPriceWithDiscount(Seq(Apple))
      assert(totalPrice == 0.60)
    }

    "calculate 2 apples" in {
      val totalPrice = ShoppingCart.calcTotalPriceWithDiscount(Seq(Apple, Apple))
      assert(totalPrice == 0.60)
    }

    "calculate 3 apples" in {
      val totalPrice = ShoppingCart.calcTotalPriceWithDiscount(Seq(Apple, Apple, Apple))
      assert(totalPrice == 1.20)
    }

    "calculate 4 apples" in {
      val totalPrice = ShoppingCart.calcTotalPriceWithDiscount(Seq(Apple, Apple, Apple, Apple))
      assert(totalPrice == 1.20)
    }

    "calculate 3 oranges" in {
      val totalPrice = ShoppingCart.calcTotalPriceWithDiscount(Seq(Orange, Orange, Orange))
      assert(totalPrice == 0.50)
    }

    "calculate 4 oranges" in {
      val totalPrice = ShoppingCart.calcTotalPriceWithDiscount(Seq(Orange, Orange, Orange, Orange))
      assert(totalPrice == 0.75)
    }

    "calculate a mixture of products" in {
      val totalPrice = ShoppingCart.calcTotalPriceWithDiscount(Seq(Apple, Orange, Orange, Apple, Orange, Orange, Apple))
      assert(totalPrice == 1.95)
    }
  } 
}