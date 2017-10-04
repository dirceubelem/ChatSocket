/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author usuario
 */
public class ObterCliente extends Thread {

    private final List<Socket> clientes;
    private final ServerSocket servidor;

    public ObterCliente(List<Socket> clientes, ServerSocket servidor) {
        this.clientes = clientes;
        this.servidor = servidor;
    }

    @Override
    public void run() {
        try {

            while (true) {

                System.out.println("Aguardando cliente...");

                Socket cliente = servidor.accept();
                System.out.println("Nova conexão com o cliente "
                        + cliente.getInetAddress().getHostAddress()
                );

                clientes.add(cliente);

                ObterMensagem m = new ObterMensagem(cliente, clientes);
                m.start();

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
