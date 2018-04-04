public class TicTacToeBoard {
    private char[][] board;
    private char current_player;
    private boolean have_winner;

    public void TitcTacToeBoard()
    {
        this.board = new char[3][3];
        // Clear the board
        for(int i = 0; i<3; ++i)
            for(int j=0; j<3; ++j)
                this.board[i][j] = ' ';

        this.setCurrent_player('x');
        this.setHave_winner(false);
    }

    public String toString()
    {
        StringBuilder retval = new StringBuilder();

        for(int i = 0; i<3; ++i) {
            for (int j = 0; j < 3; ++j) {
                retval.append(this.board[i][j]);
                if(j != 2)
                    retval.append(" | ");
            }
            retval.append("---------");
        }

        return retval.toString();
    }

    public char checkWinner()
    {
        boolean isawinner;
        char player2score;

        //Check horizontals
        for(int i=0; i<3; ++i)
        {
            player2score = this.board[i][0];
            isawinner = true;
            for(int j=1; j<3; ++j)
            {
                if(this.board[i][j] != player2score)
                    isawinner = false;
            }
            if(isawinner)
                return player2score;
        }

        //Check verticals
        for(int j=0; j<3; ++j)
        {
            player2score = this.board[0][j];
            isawinner = true;
            for(int i=1; i<3; ++i)
            {
                if(this.board[i][j] != player2score)
                    isawinner = false;
            }
            if(isawinner)
                return player2score;
        }

        //Check diagonals
        player2score = this.board[0][0];
        isawinner = true;
        for(int k=1; k<3; ++k)
        {
            if(this.board[k][k] != player2score)
                isawinner = false;
        }
        if(isawinner)
            return player2score;

        player2score = this.board[0][2];
        isawinner = true;
        for(int k=1; k>=0; --k)
        {
            if(this.board[2 - k][k] != player2score)
                isawinner = false;
        }
        if(isawinner)
            return player2score;

        return ' ';
    }

    public char getCurrent_player() {
        return current_player;
    }

    public void setCurrent_player(char current_player) {
        this.current_player = current_player;
    }

    public boolean have_winner() {
        return have_winner;
    }

    public void setHave_winner(boolean have_winner) {
        this.have_winner = have_winner;
    }
}
