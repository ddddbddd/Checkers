import kotlin.math.max

class King(
    private val board: Board
)  {
    fun whereCanItGo(
        fromDigit: Int, fromLetter: Int,
        toDigit: Int, toLetter: Int
    ): Boolean {
        if (board.board[toDigit][toLetter] == "...|")  {
            if (fromLetter == toLetter ||
                fromDigit == toDigit) {
                println("You can't move there!! Change you move!!!")
                return false
            }

            val minDigit = (if (fromDigit > toDigit) toDigit else fromDigit) + 1
            val minLetter = (if (fromLetter > toLetter) toLetter else fromLetter) + 1
            val maxDigit = (if (fromDigit > toDigit) fromDigit else toDigit)
            val maxLetter = (if (fromLetter > toLetter) fromLetter else toLetter)

            var xyi = 0
            var countOfFigures = 0
            var digit = 0
            var letter = 0
            for (i in minDigit ..maxDigit) {
                for (j in minLetter + xyi..maxLetter) {
                    if (board.board[i][j] != "...|" && board.board[i][j] != "___|") {
                        countOfFigures++
                        digit = i
                        letter = j
                        xyi++
                        break
                    }
                }
            }
            if (countOfFigures >= 2) {
                println("You can't move there!! Change you move!!!")
                return false
            }
            if (countOfFigures == 1) {
                killing(digit, letter)
                return true
            } else if (countOfFigures == 0) {
                return true
            }
        } else {
            println("You can't move there!! Change you move!!!")
            return false
        }

        return false
    }

    fun killing( digit: Int, letter: Int ) {
        board.board[digit][letter] = "...|"
    }
}