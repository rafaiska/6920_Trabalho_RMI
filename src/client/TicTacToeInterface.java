package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TicTacToeInterface extends Remote {
    public char playerTurn() throws RemoteException;
    public String getBoardString() throws RemoteException;
    public boolean play(int line, int column, char playerSymbol) throws RemoteException;
    public char getPlayerSymbol() throws RemoteException;
}
