import kotlin.math.abs

class Man(
    private val board: Board
) {

    fun whereCanItGo(
        fromDigit: Int, fromLetter: Int,
        toDigit: Int, toLetter: Int
    ) : Boolean {
        if (colour() == "Wh" && fromDigit - toDigit < 0 ||
         colour() == "Bl" && fromDigit - toDigit > 0) {
            println("You can't move there!! Change you move!!!")
            return false
        }

        if (board.board[toDigit][toLetter] == "...|") {
            if (abs(fromDigit - toDigit) > 1 || abs(fromLetter - toLetter) > 1 ||
                fromLetter == toLetter) {
                println("You can't move there!! Change you move!!!")
                return false
            }
        } else {
            println("You can't move there!! Change you move!!!")
            return false
        }
        return true
    }

    fun killing(
        fromDigit: Int, fromLetter: Int,
        toDigit: Int, toLetter: Int
    ): Boolean  {
        if (abs(fromLetter - toLetter) == 2) {

            val killDigit = (fromDigit + toDigit) / 2
            val killLetter = (fromLetter + toLetter) / 2

            if (board.board[killDigit][killLetter] != "...|") {
                if (board.board[toDigit][toLetter] == "...|" &&
                    board.board[killDigit][killLetter] != colour() + "M|" &&
                    board.board[killDigit][killLetter] != colour() + "K|") {
                        board.board[killDigit][killLetter] = "...|"
                        board.board[fromDigit][fromLetter] = board.board[toDigit][toLetter]
                            .also { board.board[toDigit][toLetter] = board.board[fromDigit][fromLetter] }
                    return true
                }
            }
        }
        return false
    }



}
