package cliente;
import java.util.List;
import java.util.Queue;
import java.util.Random;
/*	TSI 3713 Sistemas Distribuídos
    Professor: 
	Rodrigo Andrade Cardoso
	
	Alunos:
	Luiz Ferreira Neto
  	Pablo Ruan Dias
 	Marcos Alexandre da Silva
 
 */
import pedido.Pedido;
/**
 * Classe que representa um cliente que faz pedidos e aguarda a entrega dos mesmos.
 */
public class Cliente implements Runnable {
    private String nome;
    private Queue<Pedido> filaPedidos;
    private List<Pedido> pedidosProntos;

    /**
     * Construtor da classe Cliente.
     *
     * @param nome           O nome do cliente.
     * @param filaPedidos    A fila de pedidos onde o cliente coloca seus pedidos.
     * @param pedidosProntos A lista onde os pedidos prontos serão armazenados.
     */
    public Cliente(String nome, Queue<Pedido> filaPedidos, List<Pedido> pedidosProntos) {
        this.nome = nome;
        this.filaPedidos = filaPedidos;
        this.pedidosProntos = pedidosProntos;
    }

    /**
     * Implementação do método run() da interface Runnable.
     * Este método é executado quando a thread do cliente é iniciada.
     */
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            Pedido pedido = criarPedidoAleatorio();
            System.out.println(nome + " fez um pedido: " + pedido.getNome());
            filaPedidos.add(pedido);
            synchronized (filaPedidos) {
                filaPedidos.notify(); // Notificar a equipe da cozinha sobre um novo pedido
            }
            synchronized (pedido) {
                try {
                    pedido.wait(); // Aguardar até que o pedido seja preparado
                    pedidosProntos.add(pedido);
                    System.out.println(nome + " recebeu seu pedido: " + pedido.getNome());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Método privado para criar um pedido aleatório.
     *
     * @return Um objeto Pedido com características aleatórias.
     */
    private Pedido criarPedidoAleatorio() {
        String[] itens = {"Entrada 1", "Entrada 2", "Prato Principal 1", "Prato Principal 2", "Sobremesa 1", "Sobremesa 2"};
        String nomePedido = itens[new Random().nextInt(itens.length)];
        int tempoPreparo = new Random().nextInt(3901) + 100; // Entre 100 e 4000 ms
        String categoria = nomePedido.contains("Entrada") ? "entrada" :
                (nomePedido.contains("Prato Principal") ? "prato principal" : "sobremesa");
        return new Pedido(nomePedido, tempoPreparo, categoria);
    }
}
