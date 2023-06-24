object Board {
    var board = mutableListOf<MutableList<String>>()

    fun initializeBoard() {
        generateLetters()
        for (i in 1..8) {
            if (i <= 3 || i >= 6) {
                figuresOnBoard(i)
            } else
                colorOfCell(i)
        }
        }

    fun generateLetters() {
        board.add(mutableListOf())
        for (i in 'A'..'H') {
            board[0].add(i.toString())
        }
    }

    fun colorOfCell(i: Int) {
        board.add(mutableListOf())
        board.last().add("${board.size - 1}|")
        if (i % 2 == 0) {
            (1..8)
                .map { if (it % 2 == 0) "___" else "..." }
                .forEach { board.last().add("$it|") }
        } else {
            (1..8)
                .map { if (it % 2 == 0) "..." else "___"}
                .forEach { board.last().add("$it|") }
        }
    }

    fun figuresOnBoard(i: Int) {
        board.add(mutableListOf())
        board.last().add("${board.size - 1}|")
        (1..8)
            .map { when(i) {
                1, 3 -> if (it % 2 == 0) "BlM" else "___"
                2 -> if (it % 2 != 0) "BlM" else "___"
                6, 8 -> if (it % 2 != 0) "WhM" else "___"
                7 -> if (it % 2 == 0) "WhM" else "___"
                else -> "penis"
            } }
            .forEach { board.last().add("$it|") }
    }

    fun printBoard(firstPlayer: Player, secondPlayer: Player) {
        emptyLines()
        board.take(1).forEach {x ->
            println("   ${x.joinToString(" ".repeat(3))}")
        }
        for (i in board.drop(1)) {
            println(i.joinToString( ""))

        }
        firstPlayer.whoseMove(secondPlayer)
    }

    fun emptyLines() {
        println("\n".repeat(5))
    }
}
