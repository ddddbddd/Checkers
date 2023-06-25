class Player(
    m_name: String,
    m_colour: String
) {
    var name = m_name
        get() = field.replaceFirstChar { it.uppercase() }
    var colour = m_colour
        get() = field.replaceFirstChar { it.uppercase() }

    fun infoAboutPlayer(numOfPlayer: Int) {
        println("${if (numOfPlayer == 1) "First player\'s" else "Second player's"} name is $name" +
                " and he/she play for ${if (colour == "B") "Black" else "White"}")
    }

    private fun colorOfSecond(): String {
        if (this.colour == "W") {
            return "B"
        }
        return "W"
    }

    fun checkOfColor() {
        if (this.colour != "W" && this.colour != "B") {
            while(this.colour != "W" && this.colour != "B" ) {
                println("You have written wrong color!! Correct it, pls")
                this.colour = readln().uppercase()
            }
        }
    }

    var move = 1
    fun whoseMove(second: Player) {
        val white: Player
        val black: Player
        if (this.colour == "W") {
            white = this
            black = second
        } else {
            white = second
            black = this
        }
        println()
        println("${if (move % 2 != 0) white.name else black.name} make your move")
           move++
    }
}
