package machine

fun main() {
    val machine = CoffeeMachine()
    var running = true

    while (running) {
        println("Write action (buy, fill, take, remaining, exit): ")
        print(">")
        val command = readLine() ?: ""

        when (command) {
            "buy" -> machine.userBuy()
            "fill" -> machine.userFill()
            "take" -> machine.userTake()
            "remaining" -> machine.giveStatus()
            "exit" -> running = false
        }
    }
}