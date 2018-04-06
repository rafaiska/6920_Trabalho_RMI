package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import server.TicTacToeBoard;

public class TicTacToeClient {
    private TicTacToeBoard board;

    public TicTacToeClient()
    {
        try {
            Naming.rebind("//localhost:1099/TicTacToe", this.board);
        }
        catch (java.rmi.RemoteException e)
        {
            System.out.println("Could not find remote object: " + e.getMessage());
        }
        catch (MalformedURLException e)
        {
            System.out.println("Wrong URL: " + e.getMessage());
        }
    }

    public boolean step()
    {
        return true;
    }
}
