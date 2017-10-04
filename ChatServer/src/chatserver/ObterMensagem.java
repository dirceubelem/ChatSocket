/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.PrintStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class ObterMensagem extends Thread {

    private Socket cliente;
    private List<Socket> clientes;

    public ObterMensagem(Socket cliente, List<Socket> clientes) {
        this.cliente = cliente;
        this.clientes = clientes;
    }

    @Override
    public void run() {

        try {

            Scanner s = new Scanner(cliente.getInputStream());
            while (s.hasNextLine()) {

                String msg = s.nextLine();

                System.out.println(msg);

                for (Socket sk : clientes) {
                    PrintStream saida = new PrintStream(sk.getOutputStream());
                    saida.print(msg);
                }

            }

            s.close();

        } catch (Exception e) {

        }

    }

}
