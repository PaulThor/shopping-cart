package hmrc.exercise

object ShoppingCart {

    def calcTotalPrice(shoppingList: String*) = {
        shoppingList.map {
                case "Apple" => 0.60
                case "Orange" => 0.25
                case _ => throw new Exception("Invalid Product") 
        }.sum
    }
}