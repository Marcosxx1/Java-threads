/**
 * A classe Cozinheiro representa um cozinheiro em um restaurante que prepara pedidos.
 */
package cozinheiro;

import java.util.concurrent.BlockingQueue;
/* 	 A fila de pedidos é uma instância da interface BlockingQueue que é usada para implementar o cenário produtor-consumidor
 * em um ambiente multithreaded. 
 * 
 * 	 A interface BlockingQueue fornece métodos que podem ser usados para adicionar e remover
 * elementos da fila, e também fornece métodos que podem ser usados para bloquear a thread até que a fila esteja não vazia
 * ou não cheia.
 * 	 Existem dois tipos de BlockingQueue: ilimitada e limitada. 
 * 	 Uma fila ilimitada pode crescer quase indefinidamente, enquanto uma fila limitada tem uma capacidade máxima definida. 
 * 
 * 	 O mais importante ao projetar um programa produtor-consumidor
 *  usando uma BlockingQueue ilimitada é que os consumidores devem ser capazes de consumir mensagens tão rapidamente quanto os 
 *  produtores estão adicionando mensagens à fila. 
 *  Caso contrário, a memória pode ficar cheia e teríamos uma exceção OutOfMemory*/

import pedido.Pedido;
import restaurante.NotificadorCliente;

public class Cozinheiro extends Thread {

	private BlockingQueue<Pedido> filaPedidos;
	private NotificadorCliente notificador;

	/**
	 * Construtor da classe Cozinheiro.
	 * 
	 * @param filaPedidos Fila de pedidos.
	 * @param notificador Notificador de cliente.
	 */
	public Cozinheiro(BlockingQueue<Pedido> filaPedidos, NotificadorCliente notificador) {
		this.filaPedidos = filaPedidos;
		this.notificador = notificador;
	}

	/**
	 * Método sobrescrito da classe Thread que é executado quando a thread é
	 * iniciada. O método contém um loop infinito que retira um pedido da fila de
	 * pedidos usando o método take(), simula o tempo de preparo do pedido usando o
	 * método sleep(), imprime uma mensagem informando que o pedido foi preparado e
	 * notifica o cliente que o pedido está pronto usando o método
	 * notificarCliente().
	 */
	@Override
	public void run() {
		while (true) {
			try {
				Pedido pedido = filaPedidos.take(); // Retire um pedido da fila
				System.out.println("Cozinheiro está preparando: " + pedido);
				sleep(pedido.getTempoPreparo()); // Simula o tempo de preparo
				System.out.println("Pedido preparado: " + pedido);
				notificador.notificarCliente("Pedido pronto: " + pedido);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
