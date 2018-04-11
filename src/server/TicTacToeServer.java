package server;

import java.rmi.Naming;

public class TicTacToeServer {
    public TicTacToeServer()
    {
        try {
            TicTacToeBoard board = new TicTacToeBoard();
            Naming.rebind("rmi://127.0.0.1:1099/TicTacToe", board);
            board.run();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        new TicTacToeServer();
    }
}
