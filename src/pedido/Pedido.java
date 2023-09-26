package pedido;

/*	TSI 3713 Sistemas Distribuídos
    Professor: 
	Rodrigo Andrade Cardoso
	
	Alunos:
	Luiz Ferreira Neto
  	Pablo Ruan Dias
 	Marcos Alexandre da Silva
 
 */

/**
 * Classe que representa um pedido.
 */
public class Pedido {
    private String nome;
    private int tempoPreparo;
    private String categoria;

    /**
     * Construtor da classe Pedido.
     *
     * @param nome O nome do pedido.
     * @param tempoPreparo O tempo estimado de preparo do pedido em milissegundos.
     * @param categoria A categoria do pedido (ex: pizza, hambúrguer, sobremesa).
     */
    public Pedido(String nome, int tempoPreparo, String categoria) {
        this.nome = nome;
        this.tempoPreparo = tempoPreparo;
        this.categoria = categoria;
    }

    /**
     * Obtém o nome do pedido.
     *
     * @return Uma string representando o nome do pedido.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o tempo de preparo do pedido.
     *
     * @return Um valor inteiro representando o tempo estimado de preparo do pedido em milisegundos.
     */
    public int getTempoPreparo() {
        return tempoPreparo;
    }

    /**
     * Obtém a categoria do pedido.
     *
     * @return Uma string representando a categoria do pedido.
     */
    public String getCategoria() {
        return categoria;
    }
}
