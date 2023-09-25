package cozinheiro;

import java.util.Queue;

import pedido.Pedido;
import java.util.Queue;

/**
 * Classe que representa um cozinheiro responsável por preparar pedidos.
 */
public class Cozinheiro implements Runnable {
    private Queue<Pedido> filaPedidos;

    /**
     * Construtor da classe Cozinheiro.
     *
     * @param filaPedidos A fila de pedidos a ser preparada pelo cozinheiro.
     */
    public Cozinheiro(Queue<Pedido> filaPedidos) {
        this.filaPedidos = filaPedidos;
    }

    /**
     * Implementação do método run() da interface Runnable.
     * Este método é executado quando a thread do cozinheiro é iniciada.
     */
    @Override
    public void run() {
        while (true) {
            synchronized (filaPedidos) {
                // Aguardar até que haja pedidos na fila
                while (filaPedidos.isEmpty()) {
                    try {
                        filaPedidos.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // Retirar o primeiro pedido da fila e prepará-lo
                Pedido pedido = filaPedidos.poll();
                prepararPedido(pedido);
                // Notificar o cliente que o pedido está pronto
                synchronized (pedido) {
                    pedido.notify();
                }
            }
        }
    }

    /**
     * Método privado para preparar um pedido.
     *
     * @param pedido O pedido a ser preparado.
     */
    private void prepararPedido(Pedido pedido) {
        System.out.println("Preparando " + pedido.getCategoria() + ": " + pedido.getNome());
        try {
            // Simular o tempo de preparo do pedido com Thread.sleep()
            Thread.sleep(pedido.getTempoPreparo());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Pedido " + pedido.getNome() + " pronto!");
    }
}
