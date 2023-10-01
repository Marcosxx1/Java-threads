# Restaurante Simulado

Este é um programa de simulação de restaurante que demonstra como clientes fazem pedidos e cozinheiros preparam esses pedidos em um ambiente concorrente.

## Classes

### `Restaurante`

A classe `Restaurante` é a classe principal que inicia a simulação. Ela cria um número aleatório de cozinheiros e clientes e os inicia para simular a operação do restaurante.

### `Cozinheiro`

A classe `Cozinheiro` representa um cozinheiro que prepara os pedidos. Cada cozinheiro é executado em sua própria thread e retira pedidos da fila, prepara-os e notifica os clientes quando estão prontos.

### `Cliente`

A classe `Cliente` representa um cliente que faz pedidos. Cada cliente é executado em sua própria thread e faz três pedidos de diferentes categorias (entrada, prato principal, sobremesa). Os pedidos são adicionados à fila de pedidos do restaurante.

### `Pedido`

A classe `Pedido` representa um pedido com informações como nome, tempo de preparo e categoria. Ela é usada para representar os pedidos feitos pelos clientes.

### `NotificadorCliente`

A classe `NotificadorCliente` é usada para notificar os clientes quando seus pedidos estão prontos.

## Execução

Para executar o programa, você pode simplesmente executar a classe `Restaurante`. O número de clientes e cozinheiros é gerado aleatoriamente no código.

## Observações

Este é um programa de simulação e não representa um restaurante real. Ele foi criado apenas para fins de demonstração de conceitos de concorrência em Java.
## Uso de BlockingQueue em vez de Queue

Neste programa, escolhemos usar uma `BlockingQueue` em vez de uma `Queue` normal para a gestão da fila de pedidos. A principal razão para essa escolha é a necessidade de lidar com concorrência de forma eficaz e segura em um ambiente simulado de restaurante.

- **Concorrência Segura**: A `BlockingQueue` oferece recursos de sincronização incorporados, o que garante que várias threads possam acessar a fila de pedidos de forma segura e coordenada. Em um ambiente concorrente como um restaurante simulado, onde vários clientes fazem pedidos simultaneamente e vários cozinheiros preparam esses pedidos, a segurança é fundamental.

- **Coordenação Simples**: A `BlockingQueue` fornece métodos convenientes, como `put()` e `take()`, que facilitam a coordenação entre as threads. Os clientes podem adicionar pedidos à fila usando `put()`, e os cozinheiros podem retirar pedidos da fila usando `take()`. Isso simplifica muito a lógica de coordenação entre as partes envolvidas.

- **Prevenção de Condições de Corrida**: A `BlockingQueue` ajuda a evitar condições de corrida, um problema comum em programas concorrentes. Ela garante que apenas um thread possa adicionar ou remover itens da fila de cada vez, evitando conflitos e garantindo que os pedidos sejam processados na ordem correta.

Essa escolha de design com uma `BlockingQueue` foi feita para garantir a correta execução do restaurante simulado, onde a coordenação eficaz entre clientes e cozinheiros é fundamental para o funcionamento adequado do sistema em um ambiente concorrencial.

