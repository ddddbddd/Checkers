fun main() {
    println("What's your name?")
    val firstName = readln()
    println("What's your colour? W/B")
    val colour = readln()
    val first = Player(firstName, colour)
    first.checkOfColor()

    println("What's your name, second Player?")
    val secondName = readln()
    val second = Player(secondName, first.colorOfSecond())

    println("\n")
    first.infoAboutPlayer(1)
    second.infoAboutPlayer(2)

    Board.initializeBoard()

    val win = Win(first, second)
    val man = Man(Board)
    val king = King(Board)
    val move = Moves(Board, man, win, king)

    val i = 0

    while(i < 1) {
        Board.printBoard(first, second)
        move.moving(first.move)
    }
}

var count = 1

fun colour(): String {
    return if (count % 2 != 0) "Wh" else "Bl"
}
// 2. In order can be killed(king)
// 3. Ходить справа на лево( и наоборот оф корз)
// 5. Хоидть только кула можно(king)
