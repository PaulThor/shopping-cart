package main.scala

object ShoppingCart {

    def calcTotalPrice(shoppingList: String*) = {
        shoppingList.map {
                case "Apple" => 0.60
                case "Orange" => 0.25
                case _ => throw new Exception("Invalid Product") 
        }.sum
    }

    def calcTotalPriceWithDiscount(shoppingList: String*) = {

        calcDiscount(
            2,
            1,
            0.6,
            shoppingList.filter(_ match { case "Apple" => true case _ => false }).size) +
        calcDiscount(
            3, 
            2, 
            0.25, 
            shoppingList.filter(_ match { case "Orange" => true case _ => false }).size
        )
    }

    def calcDiscount(n : Int, m : Int, cost: BigDecimal, totalItem : Int) : BigDecimal = cost * (totalItem / n * m + totalItem % n)
}