# Documentação do Código do Restaurante

Este código Java representa um sistema de restaurante simples, onde clientes fazem pedidos aleatórios e cozinheiros preparam esses pedidos. O sistema é implementado usando threads para representar clientes e cozinheiros, com uma fila de pedidos para coordenar o fluxo de trabalho.

## Classes Principais

### 1. `Pedido`

A classe `Pedido` representa um pedido feito por um cliente no restaurante. Cada pedido possui três atributos:

- `nome`: O nome do item do menu.
- `tempoPreparo`: O tempo estimado necessário para preparar o pedido em milissegundos.
- `categoria`: A categoria do pedido, como "entrada", "prato principal" ou "sobremesa".

#### Métodos Principais:

- `Pedido(String nome, int tempoPreparo, String categoria)`: O construtor da classe `Pedido` que inicializa os atributos do pedido.

- `getNome()`: Retorna o nome do pedido.

- `getTempoPreparo()`: Retorna o tempo estimado de preparo do pedido.

- `getCategoria()`: Retorna a categoria do pedido.

### 2. `Cliente`

A classe `Cliente` representa um cliente que faz pedidos no restaurante. Cada cliente é executado em uma thread separada. Os clientes fazem pedidos aleatórios e aguardam a entrega desses pedidos.

#### Atributos:

- `nome`: O nome do cliente.
- `filaPedidos`: Uma fila de pedidos que armazena os pedidos feitos pelos clientes.
- `pedidosProntos`: Uma lista que armazena os pedidos prontos para entrega.

#### Métodos Principais:

- `Cliente(String nome, Queue<Pedido> filaPedidos, List<Pedido> pedidosProntos)`: O construtor da classe `Cliente` que inicializa os atributos do cliente.

- `run()`: O método `run` da interface `Runnable` representa o comportamento do cliente. Cada cliente faz três pedidos aleatórios e aguarda a entrega de cada pedido.

- `criarPedidoAleatorio()`: Método privado que cria um pedido aleatório com base em itens de menu pré-definidos.

### 3. `Cozinheiro`

A classe `Cozinheiro` representa um cozinheiro que prepara os pedidos na cozinha do restaurante. Cada cozinheiro é executado em uma thread separada. Os cozinheiros retiram pedidos da fila de pedidos e os preparam.

#### Atributos:

- `filaPedidos`: Uma fila de pedidos que armazena os pedidos a serem preparados.

#### Métodos Principais:

- `Cozinheiro(Queue<Pedido> filaPedidos)`: O construtor da classe `Cozinheiro` que inicializa a fila de pedidos.

- `run()`: O método `run` da interface `Runnable` representa o comportamento do cozinheiro. Os cozinheiros continuamente verificam a fila de pedidos, preparam os pedidos e notificam os clientes quando os pedidos estão prontos.

- `prepararPedido(Pedido pedido)`: Método privado que simula o processo de preparação de um pedido, incluindo o tempo de preparo.

### 4. `Restaurante`

A classe `Restaurante` é a classe principal do programa. Ela contém o método `main` que inicia o sistema do restaurante, criando clientes e cozinheiros aleatoriamente.

#### Métodos Principais:

- `main(String[] args)`: O método `main` cria uma fila de pedidos, uma lista de pedidos prontos e inicia um número aleatório de clientes e cozinheiros. O número de clientes e cozinheiros é determinado aleatoriamente dentro de intervalos específicos.

## Funcionamento do Programa

O programa funciona da seguinte forma:

1. Um número aleatório de clientes e cozinheiros é criado no método `main`.

2. Cada cozinheiro é executado em uma thread separada e continua verificando a fila de pedidos. Quando um pedido está na fila, o cozinheiro o prepara.

3. Cada cliente é executado em uma thread separada e faz três pedidos aleatórios, colocando-os na fila de pedidos. Os clientes aguardam até que seus pedidos sejam preparados e, em seguida, recebem os pedidos prontos.

4. O programa continua em execução indefinidamente até que seja interrompido manualmente.

Esta documentação fornece uma visão geral do código do restaurante e seu funcionamento. Cada classe e método são explicados, permitindo uma compreensão clara do sistema de restaurante implementado.
