package main.scala

trait Product {
    val price : BigDecimal
}

case object Apple extends Product {
    val price = 0.60
}
case object Orange extends Product {
    val price = 0.25
}

object ShoppingCart {

    def calcTotalPrice(shoppingList: Product*) = {
        shoppingList.map{ x => x.price }.sum
    }

    def calcTotalPriceWithDiscount(shoppingList: Product*) = {

        calcDiscount(2, 1, 0.6, shoppingList.filter(_ match { case Apple => true case _ => false }).size) +
        calcDiscount(3, 2, 0.25, shoppingList.filter(_ match { case Orange => true case _ => false }).size)
    }

    def calcDiscount(n : Int, m : Int, cost: BigDecimal, totalItem : Int) : BigDecimal = cost * (totalItem / n * m + totalItem % n)
}