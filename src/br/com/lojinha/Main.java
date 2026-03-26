package br.com.lojinha;

import br.com.lojinha.model.*;
import br.com.lojinha.service.SistemaPagamentoExterno;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("====== BEM-VINDO À LOJINHA ONLINE ======\n");

        // 1. Identificação de cliente (criados estaticamente para simplificar)
        ClientePF clientePadrao = new ClientePF(1, "João da Silva", "Rua das Flores, 123", "111.222.333-44", "01/05/1990");
        System.out.println("Logado como: " + clientePadrao.getNome() + "\n");

        // 2. Catálogo de produtos
        Produto p1 = new Produto(101, "Eletrônicos", "Smartphone Galaxy", 2500.00);
        Produto p2 = new Produto(102, "Acessórios", "Fone de Ouvido Bluetooth", 150.00);
        Produto p3 = new Produto(103, "Informática", "Notebook Dev 16GB", 4800.00);
        List<Produto> catalogo = Arrays.asList(p1, p2, p3);

        Pedido pedido = new Pedido(5001, clientePadrao, 25.00, "Compra via menu interativo");
        boolean sair = false;

        while (!sair) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Listar Produtos");
            System.out.println("2. Adicionar Produto ao Carrinho");
            System.out.println("3. Ver Carrinho");
            System.out.println("4. Finalizar Compra (Checkout)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Catálogo de Produtos ---");
                    for (int i = 0; i < catalogo.size(); i++) {
                        Produto p = catalogo.get(i);
                        System.out.println((i + 1) + ". " + p.getDescricao() + " - R$ " + p.getValor());
                    }
                    break;

                case 2:
                    System.out.println("\n--- Adicionar ao Carrinho ---");
                    for (int i = 0; i < catalogo.size(); i++) {
                        System.out.println((i + 1) + ". " + catalogo.get(i).getDescricao());
                    }
                    System.out.print("Selecione o número do produto: ");
                    int prodIdx = scanner.nextInt() - 1;
                    System.out.print("Quantidade: ");
                    int qtd = scanner.nextInt();
                    
                    if (prodIdx >= 0 && prodIdx < catalogo.size()) {
                        pedido.adicionarItem(new ItemPedido(catalogo.get(prodIdx), qtd));
                        System.out.println("Produto adicionado!");
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Seu Carrinho ---");
                    if (pedido.getItens().isEmpty()) {
                        System.out.println("Carrinho vazio.");
                    } else {
                        for (ItemPedido item : pedido.getItens()) {
                            System.out.println(" - " + item.getQuantidade() + "x " + item.getProduto().getDescricao() + " | Subtotal: R$ " + item.getSubTotal());
                        }
                        System.out.println("Total Atual: R$ " + pedido.calcularTotal());
                    }
                    break;

                case 4:
                    if (pedido.getItens().isEmpty()) {
                        System.out.println("Adicione produtos antes de finalizar!");
                        break;
                    }
                    System.out.println("\n--- Finalizando Compra ---");
                    System.out.println("Valor Total: R$ " + pedido.calcularTotal());
                    System.out.print("Confirmar pagamento com Cartão? (S/N): ");
                    String conf = scanner.nextLine();

                    if (conf.equalsIgnoreCase("S")) {
                        Pagamento pgto = new Pagamento(1, LocalDate.now(), "Cartão de Crédito");
                        pedido.setPagamento(pgto);

                        // Uso do SINGLETON
                        System.out.println("[SISTEMA] Acionando Gateway...");
                        boolean sucesso = SistemaPagamentoExterno.getInstance().processarPagamento(pgto, pedido.calcularTotal());

                        if (sucesso) {
                            pedido.setStatusPedido("Pago");
                            System.out.println("\n[SUCESSO] Pagamento aprovado!");
                            
                            Entrega entrega = new Entrega("BR" + System.currentTimeMillis() % 1000000, "Em separação");
                            System.out.println("Seu código de rastreio: " + entrega.getCodRastreio());
                        }
                        sair = true;
                    }
                    break;

                case 0:
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        System.out.println("\nObrigado por comprar conosco!");
        System.out.println("====== FIM DA SIMULAÇÃO ======");
        scanner.close();
    }
}


