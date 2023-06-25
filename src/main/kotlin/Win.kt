import kotlin.system.exitProcess

class Win(
    private val firstPlayer: Player,
    private val secondPlayer: Player
) {
    private var whiteWin = 1
    private var blackWin = 1

    fun win(){
        if (firstPlayer.move % 2 == 0) {
            whiteWin++
        } else {
            blackWin++
        }
        if (blackWin == 12 || whiteWin == 12) {
            if (firstPlayer.colour == "W" && whiteWin == 12 ||
                firstPlayer.colour == "B" && blackWin == 12) {
                println("\n${firstPlayer.name} has won!!! Congratulation!!")
                println("${secondPlayer.name} sosi xyec, Lox ebannii")
                exitProcess(0)
            } else {
                println("\n${secondPlayer.name} has won!!! Congratulation!!")
                println("${firstPlayer.name} sosi xyec, Lox ebannii")
                exitProcess(0)
            }
        }
    }

}