/**
 * A classe Cliente representa um cliente que faz pedidos em um restaurante.
 */
package cliente;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

import pedido.Pedido;
import restaurante.NotificadorCliente;

public class Cliente extends Thread {
    private String nome;
    private BlockingQueue<Pedido> filaPedidos;
    private NotificadorCliente notificador;

    /**
     * Construtor para criar um objeto Cliente.
     *
     * @param nome O nome do cliente.
     * @param filaPedidos A fila de pedidos onde o cliente coloca seus pedidos.
     * @param notificador O notificador de cliente usado para receber notificações sobre os pedidos.
     */
    public Cliente(String nome, BlockingQueue<Pedido> filaPedidos, NotificadorCliente notificador) {
        this.nome = nome;
        this.filaPedidos = filaPedidos;
        this.notificador = notificador;
    }

    /**
     * O método run() é chamado quando a thread do cliente é iniciada.
     * O cliente faz três pedidos de diferentes categorias (entrada, prato principal, sobremesa)
     * e coloca esses pedidos na fila de pedidos do restaurante.
     */
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            // Crie um pedido de acordo com a categoria (entrada, prato principal, sobremesa)
            String categoria;
            if (i == 0) {
                categoria = "entrada";
            } else if (i == 1) {
                categoria = "prato principal";
            } else {
                categoria = "sobremesa";
            }
            
            Random random = new Random();
            int tempoPreparo = random.nextInt(3900) + 100; // De 100 a 4000 milissegundos

            Pedido pedido = new Pedido(nome, tempoPreparo, categoria);
            
            try {
                filaPedidos.put(pedido); // Adicione o pedido à fila
                System.out.println(nome + " fez um pedido: " + pedido);
                sleep(tempoPreparo); // Simula o cliente esperando pelo pedido
                notificador.notificarCliente(nome + ", seu pedido está pronto: " + pedido);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
