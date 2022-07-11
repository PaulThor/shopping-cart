import main.scala._

object Main extends App {
  println("Enter shopping list to calculate the discounted price (e.g. apple,orange)")
  println("Enter exit to leave")

  var shoppingList = ""
    while (shoppingList != "exit") {
      shoppingList = scala.io.StdIn.readLine()
      val itemsList = convertToProducts(shoppingList)   
      println(s"Total Discounted Price: ${ShoppingCart.calcTotalPriceWithDiscount(itemsList)}")
    }

    def convertToProducts(items : String) = { items.toLowerCase.replace(" ", "").split(",").collect {
        case Apple.name => Apple
        case Orange.name => Orange
    }.toSeq }
}