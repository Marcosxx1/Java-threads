package restaurante;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import cliente.Cliente;
import cozinheiro.Cozinheiro;
import pedido.Pedido;

/*	TSI 3713 Sistemas Distribuídos
    Professor: 
	Rodrigo Andrade Cardoso
	
	Alunos:
	Luiz Ferreira Neto
  	Pablo Ruan Dias
 	Marcos Alexandre da Silva
 
 */

/**
 * Classe principal que representa o restaurante e inicia a simulação do restaurante.
 */
public class Restaurante {
    public static void main(String[] args) {
        // Cria uma fila de pedidos e uma lista de pedidos prontos
        Queue<Pedido> filaPedidos = new LinkedList<>();
        List<Pedido> pedidosProntos = new ArrayList<>();
        
        // Gera aleatoriamente o número de clientes (entre 20 e 50) e cozinheiros (entre 5 e 10)
        int numClientes = new Random().nextInt(31) + 20; // Entre 20 e 50 clientes
        int numCozinheiros = new Random().nextInt(6) + 5; // Entre 5 e 10 cozinheiros

        // Cria arrays de threads para clientes e cozinheiros
        Thread[] clientes = new Thread[numClientes];
        Thread[] cozinheiros = new Thread[numCozinheiros];

        // Inicializa threads para os cozinheiros
        for (int i = 0; i < numCozinheiros; i++) {
            cozinheiros[i] = new Thread(new Cozinheiro(filaPedidos));
            cozinheiros[i].start();
        }

        // Inicializa threads para os clientes
        for (int i = 0; i < numClientes; i++) {
            clientes[i] = new Thread(new Cliente("Cliente " + (i + 1), filaPedidos, pedidosProntos));
            clientes[i].start();
        }
    }
}
