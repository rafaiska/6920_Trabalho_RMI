package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

import server.TicTacToeBoard;

public class TicTacToeClient {
    private TicTacToeInterface binterface;
    char mySymbol;

    public TicTacToeClient()
    {
        try {
            binterface = (TicTacToeInterface)Naming.lookup("rmi://localhost:1099/TicTacToe");
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
        try {
            mySymbol = binterface.getPlayerSymbol();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(mySymbol == ' ')
        {
            System.out.println("ERRO: Dois jogadores já se conectaram");
            System.exit(1);
        }
    }

    public void main(String args[])
    {
        Scanner entrada = new Scanner(System.in);
        int linha, coluna;
        boolean sucesso = true;

        try {
            while (binterface.playerTurn() != ' ') {
                if (binterface.playerTurn() == mySymbol) {
                    //JOGA
                    System.out.print(binterface.getBoardString());
                    System.out.println("SUA VEZ!");
                    System.out.println("Em qual linha jogar?");
                    linha = entrada.nextInt();
                    System.out.println("Em qual coluna jogar?");
                    coluna = entrada.nextInt();
                    try {
                        sucesso = binterface.play(linha, coluna, mySymbol);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (!sucesso) {
                        System.out.println("Entrada inválida!");
                    }
                } else {
                    try {
                        wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
