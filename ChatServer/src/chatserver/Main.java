/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class Main {

    public static void main(String[] args) {

        List<Socket> clientes = new ArrayList<>();

        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Porta 12345 aberta!");

            ObterCliente o = new ObterCliente(clientes, servidor);
            o.start();

        } catch (Exception e) {

        }

    }

}
