package br.com.lojinha.service;

import br.com.lojinha.model.Pagamento;

/**
 * Padrão Singleton: Garante que exista apenas uma instância responsável pela 
 * comunicação com o serviço de pagamento durante toda a execução do sistema.
 * 
 * Justificativa: Em ambientes reais, conexões com gateways de pagamento externos 
 * são recursos caros (sessões, sockets, certificados). O Singleton centraliza 
 * essa comunicação, evitando múltiplas instâncias e desperdício de recursos.
 */
public class SistemaPagamentoExterno {
    
    // Instância única privada e estática
    private static SistemaPagamentoExterno instance;

    // Construtor privado para evitar instanciamento externo
    private SistemaPagamentoExterno() {
        System.out.println("[SISTEMA] Conectando ao Gateway de Pagamento Externo...");
    }

    // Método público para obter a instância (Thread-safe simples)
    public static synchronized SistemaPagamentoExterno getInstance() {
        if (instance == null) {
            instance = new SistemaPagamentoExterno();
        }
        return instance;
    }

    public boolean processarPagamento(Pagamento pagamento, double valor) {
        System.out.println("[GATEWAY] Recebendo requisição de pagamento...");
        System.out.println("[GATEWAY] Tipo: " + pagamento.getTipoPagamento());
        System.out.println("[GATEWAY] Valor a capturar: R$ " + valor);
        System.out.println("[GATEWAY] Transação autorizada com sucesso!");
        return true;
    }
}
