package machine

class CoffeeMachine {
    private var water = 400
    private var milk = 540
    private var coffeeBeans = 120
    private var cups = 9
    private var money = 550

    private val espresso = Coffee(250, 0, 16, 4)
    private val latte = Coffee(350, 75, 20, 7)
    private val cappuccino = Coffee(200, 100, 12, 6)

    fun giveStatus() {
        println(
            "The coffee machine has:\n" +
                    "$water ml of water\n" +
                    "$milk ml of milk\n" +
                    "$coffeeBeans g of coffee beans\n" +
                    "$cups disposable cups\n" +
                    "$$money of money"
        )
    }

    fun userBuy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
        print(">")
        val input = readLine() ?: "0"

        when (input) {
            "1" -> this.buy(espresso)
            "2" -> this.buy(latte)
            "3" -> this.buy(cappuccino)
        }
    }

    private fun buy(coffee: Coffee) {

        if (water >= coffee.water && milk >= coffee.milk && coffeeBeans >= coffee.coffeeBeans && cups >= 1) {
            water -= coffee.water
            milk -= coffee.milk
            coffeeBeans -= coffee.coffeeBeans
            cups -= 1
            money += coffee.price
            println("I have enough resources and am making you a nice cup of coffee!")
        } else {
            var message = "Sorry, not enough "
            if (water < coffee.water) message += "water "
            if (coffeeBeans < coffee.coffeeBeans) message += "coffee beans "
            if (milk < coffee.milk) message += "milk "
            if (cups <= 0) message += "disposable cups "
            println(message)
        }


    }

    fun userFill() {
        println("How many ml of water do you want to add: ")
        print(">")

        var input = readLine() ?: "0"
        val waterToAdd = input.toInt()

        println("How many ml of milk do you want to add: ")
        print(">")

        input = readLine() ?: "0"
        val milkToAdd = input.toInt()

        println("How many grams of coffee do you want to add: ")
        print(">")

        input = readLine() ?: "0"
        val coffeeToAdd = input.toInt()

        println("How many disposable cups do you want to add: ")
        print(">")

        input = readLine() ?: "0"
        val cupsToAdd = input.toInt()

        this.fill(waterToAdd, milkToAdd, coffeeToAdd, cupsToAdd)
    }

    private fun fill(waterToAdd: Int, milkToAdd: Int, coffeeToAdd: Int, cupsToAdd: Int) {
        water += waterToAdd
        milk += milkToAdd
        coffeeBeans += coffeeToAdd
        cups += cupsToAdd
    }

    fun userTake() {
        println("You have taken all of this  machines money: $$money")
        money = 0
        print("\n")
    }

    inner class Coffee(val water: Int, val milk: Int, val coffeeBeans: Int, val price: Int)

}