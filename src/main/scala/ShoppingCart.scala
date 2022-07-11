package main.scala

trait Product {
    val name: String
    val price : BigDecimal
}

case object Apple extends Product {
    val name = "apple"
    val price = 0.60
}
case object Orange extends Product {
    val name = "orange"
    val price = 0.25
}

object ShoppingCart {
    def calcTotalPrice(shoppingList: Product*) = {
        shoppingList.map{ x => x.price }.sum
    }

    def calcTotalPriceWithDiscount(shoppingList: Seq[Product]) = {
        calcDiscount(2, 1, Apple.price, shoppingList.filter(_ match { case Apple => true case _ => false }).size) +
        calcDiscount(3, 2, Orange.price, shoppingList.filter(_ match { case Orange => true case _ => false }).size)
    }

    def calcDiscount(n : Int, m : Int, cost: BigDecimal, totalItem : Int) : BigDecimal = cost * (totalItem / n * m + totalItem % n)
}