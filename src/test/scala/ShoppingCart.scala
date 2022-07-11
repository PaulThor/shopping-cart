package hmrc.exercise

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
            shoppingList.filter(_ match { case "Apple" => true case _ => false }).size,
            2,
            0.6) +
        calcDiscount(
            shoppingList.filter(_ match { case "Orange" => true case _ => false }).size,
            3,
            0.25)
    }

    def calcDiscount(quantity: Int, mod: Int, price: BigDecimal) = {
         val eq = (quantity + 1) - ((quantity + 1) % mod)
        (eq / mod * price)
    }
}