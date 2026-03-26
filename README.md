# LojinhaJava 🛒

Um sistema simples de e-commerce desenvolvido em Java para demonstrar conceitos de Programação Orientada a Objetos e Padrões de Projeto.

## 📂 Estrutura do Projeto

O projeto está organizado nos seguintes pacotes dentro de `src/br/com/lojinha`:

-   **`main`**: Contém a classe `Main.java`, que é o ponto de entrada da aplicação e gerencia o menu interativo.
-   **`model`**: Contém as classes de domínio que representam as entidades do sistema:
    -   `Cliente`, `ClientePF`, `ClientePJ`: Gestão de usuários.
    -   `Produto`, `ItemPedido`, `Pedido`: Fluxo de vendas.
    -   `Pagamento`, `Entrega`: Processamento pós-venda.
    -   `Estoque`, `Fornecedor`: Gestão de suprimentos (simulado).
-   **`service`**: Contém serviços de apoio e integrações externas.

## 🏗️ Principais Decisões Arquiteturais

1.  **Separação de Camadas**: O sistema segue uma separação clara entre as classes de dados (`model`) e a lógica de interação/integração (`Main` e `service`).
2.  **Herança e Polimorfismo**: Utilizados na modelagem de clientes (`ClientePF` e `ClientePJ`), permitindo tratar diferentes tipos de compradores de forma genérica no sistema de pedidos.
3.  **Fluxo Completo de Checkout**: A aplicação simula desde a escolha de produtos até a geração de um código de rastreio para a entrega, garantindo uma visão holística de um sistema de vendas.

## 💎 Padrão de Projeto: Singleton

O padrão **Singleton** foi aplicado para gerenciar a comunicação com serviços externos de pagamento.

### Onde e Como foi aplicado:
-   **Classe**: `br.com.lojinha.service.SistemaPagamentoExterno`
-   **Objetivo**: Garantir que exista apenas **uma única instância** responsável por conversar com o Gateway de Pagamento.
-   **Justificativa**: Conexões com gateways externos (sockets, certificados, sessões) são recursos computacionalmente caros. O uso do Singleton evita a criação desnecessária de múltiplas instâncias e centraliza o controle de acesso.

### Implementação:
```java
public class SistemaPagamentoExterno {
    private static SistemaPagamentoExterno instance;

    private SistemaPagamentoExterno() { } // Construtor privado

    public static synchronized SistemaPagamentoExterno getInstance() {
        if (instance == null) {
            instance = new SistemaPagamentoExterno();
        }
        return instance;
    }
}
```
Para utilizar o serviço em qualquer parte do código (como no Checkout na classe `Main`), basta chamar:
`SistemaPagamentoExterno.getInstance().processarPagamento(...)`
