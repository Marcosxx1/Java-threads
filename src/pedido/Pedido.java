package pedido;

/**
 * A classe Pedido representa um pedido com informações como nome, tempo de
 * preparo e categoria.
 */
public class Pedido {
	private String nome;
	private int tempoPreparo;
	private String categoria;

	/**
	 * Construtor para criar um objeto Pedido.
	 *
	 * @param nome         O nome do pedido.
	 * @param tempoPreparo O tempo de preparo do pedido em milissegundos.
	 * @param categoria    A categoria do pedido.
	 */
	public Pedido(String nome, int tempoPreparo, String categoria) {
		this.nome = nome;
		this.tempoPreparo = tempoPreparo;
		this.categoria = categoria;
	}

	/**
	 * Obtém o nome do pedido.
	 *
	 * @return O nome do pedido.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Define o nome do pedido.
	 *
	 * @param nome O novo nome do pedido.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Obtém o tempo de preparo do pedido em milissegundos.
	 *
	 * @return O tempo de preparo do pedido.
	 */
	public int getTempoPreparo() {
		return tempoPreparo;
	}

	/**
	 * Define o tempo de preparo do pedido em milissegundos.
	 *
	 * @param tempoPreparo O novo tempo de preparo do pedido.
	 */
	public void setTempoPreparo(int tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}

	/**
	 * Obtém a categoria do pedido.
	 *
	 * @return A categoria do pedido.
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * Define a categoria do pedido.
	 *
	 * @param categoria A nova categoria do pedido.
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * Retorna uma representação de string do objeto Pedido.
	 *
	 * @return Uma string formatada com informações sobre o pedido.
	 */
	@Override
	public String toString() {
		return "Pedido de " + nome + ": Categoria " + categoria + ", Tempo de Preparo: " + tempoPreparo + "ms";
	}
}
