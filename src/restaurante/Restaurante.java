/**
 * A classe Restaurante é responsável por simular a operação de um restaurante onde clientes fazem pedidos
 * e cozinheiros preparam esses pedidos.
 */
package restaurante;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import cliente.Cliente;
import cozinheiro.Cozinheiro;
import pedido.Pedido;

class Restaurante {
	/**
	 * O método main() é o ponto de entrada da aplicação e inicia a simulação do
	 * restaurante.
	 *
	 * @param args Argumentos da linha de comando (não utilizado neste caso).
	 */
	public static void main(String[] args) {
		int numClientes = 3; // De 20 a 50 clientes
		int numCozinheiros = new Random().nextInt(6) + 5; // De 5 a 10 cozinheiros

		// Cria uma fila de pedidos usando uma ArrayBlockingQueue, que é uma fila com
		// tamanho fixo.
		// O tamanho da fila é definido como numClientes * 3 para acomodar uma
		// quantidade estimada de pedidos.
		BlockingQueue<Pedido> filaPedidos = new ArrayBlockingQueue<>(numClientes * 3);
		NotificadorCliente notificador = new NotificadorCliente();

		// Inicializa os cozinheiros
		for (int i = 0; i < numCozinheiros; i++) {
			Cozinheiro cozinheiro = new Cozinheiro(filaPedidos, notificador);
			cozinheiro.start();
		}

		// Inicializa os clientes
		for (int i = 0; i < numClientes; i++) {
			Cliente cliente = new Cliente("Cliente " + (i + 1), filaPedidos, notificador);
			cliente.start();
		}
	}
}
