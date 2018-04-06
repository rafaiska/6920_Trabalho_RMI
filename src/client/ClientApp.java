package client;

public class ClientApp {
    public void main(String args[])
    {
        TicTacToeClient client = new TicTacToeClient();
        
        while (client.step());
    }
}
