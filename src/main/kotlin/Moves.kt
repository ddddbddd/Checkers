class Moves  (
        private var board: Board,
        private val man: Man,
        private val win: Win,
        private val king: King
)  {
    enum class letters {
        none,
        A,
        B,
        C,
        D,
        E,
        F,
        G,
        H
    }

    fun toEnum(value: Char): Int {
        when(value) {
            'A' -> return letters.A.ordinal
            'B' -> return letters.B.ordinal
            'C' -> return letters.C.ordinal
            'D' -> return letters.D.ordinal
            'E' -> return letters.E.ordinal
            'F' -> return letters.F.ordinal
            'G' -> return letters.G.ordinal
            'H' -> return letters.H.ordinal
        }
        return 1
    }

    fun moving(who: Int) {
        println("Write the cell of the figure you want to move(LetterDigit like B1)")
        val cell = readln().uppercase()
        val digit = cell[1].digitToInt()

        println("Where do you want to move figure from $cell?")
        val to = readln().uppercase()
        val digitTo = to[1].digitToInt()
        
        if (board.board[digit][toEnum(cell[0])] != "...|" ||
            board.board[digit][toEnum(cell[0])] != "___|") {
            if (board.board[digit][toEnum(cell[0])] == "WhM|" ||
                board.board[digit][toEnum(cell[0])] == "BlM|") {
                manMoving(digit, toEnum(cell[0]), digitTo, toEnum(to[0]), who)
                win.win()
            } else {
                kingMoving(digit, toEnum(cell[0]), digitTo, toEnum(to[0]), who)
                win.win()
            }
        }  else {
            println("You can't move with this figure!! Change you move!!")
            moving(who)
        }

    }

    private fun manMoving(digit: Int, letter: Int, toDigit: Int, toLetter: Int, who: Int) {
        if (!man.killing(digit, letter, toDigit, toLetter)) {
            if (!man.whereCanItGo(digit, letter, toDigit, toLetter)) {
                moving(who)
            } else {
                count++
                replaceFigureAndMove(digit, letter, toDigit, toLetter)
            }
            becomeKing(toDigit, toLetter, who)
        } else {
            becomeKing(toDigit, toLetter, who)
            count++
        }
    }

    private fun kingMoving(digit: Int, letter: Int, toDigit: Int, toLetter: Int, who: Int) {
        if (!king.whereCanItGo(digit, letter, toDigit, toLetter)) {
            moving(who)
        } else {
            count++
            replaceFigureAndMove(digit, letter, toDigit, toLetter)
        }
    }

    private fun replaceFigureAndMove(digit, letter, toDigit, toLetter) {
        board.board[digit][letter] = board.board[toDigit][toLetter]
            .also { board.board[toDigit][toLetter] = board.board[digit][letter] }
    }
    
    private fun becomeKing(digit: Int, letter: Int, who: Int) {
        if (who % 2 == 0 && digit == 1) {
            board.board[digit][letter] = "WhK|"
        } else if (who % 2 != 0 && digit == 8) {
            board.board[digit][letter] = "BlK|"
        }
    }
}
