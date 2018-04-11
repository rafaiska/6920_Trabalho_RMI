package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TicTacToeBoard extends UnicastRemoteObject implements TicTacToeInterface {
    private char[][] board;
    private char current_player;
    private boolean have_winner;
    private boolean ready;
    char[] playerSymbols;

    public TicTacToeBoard() throws RemoteException {
        super();
        playerSymbols = new char[2];
        playerSymbols[0] = 'o';
        playerSymbols[1] = 'x';
        this.board = new char[3][3];
        // Clear the board
        for(int i = 0; i<3; ++i)
            for(int j=0; j<3; ++j)
                this.board[i][j] = ' ';

        this.setCurrent_player('x');
        this.setHave_winner(false);
        ready = false;
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

    @Override
    public char playerTurn() {
        return current_player;
    }

    @Override
    public String getBoardString() {
        return toString();
    }

    @Override
    public boolean play(int linha, int coluna, char playerSymbol) {
        if(playerSymbol != current_player)
            return false;
        if(linha < 0 || linha > 2)
            return false;
        if(coluna < 0 || coluna > 2)
            return false;
        if(board[linha][coluna] != ' ')
            return false;

        board[linha][coluna] = playerSymbol;
        if(current_player == 'x')
            current_player = 'o';
        else
            current_player = 'x';
        return true;
    }

    @Override
    public char getPlayerSymbol() {
        char retval = ' ';
        if (playerSymbols[1] != ' ') {
            retval = playerSymbols[1];
            playerSymbols[1] = ' ';
        }
        else if (playerSymbols[0] != ' ') {
            retval = playerSymbols[0];
            playerSymbols[0] = ' ';
            ready = true;
        }

        return retval;
    }

    public void run()
    {
        while(!have_winner)
        {
        }
    }
}
