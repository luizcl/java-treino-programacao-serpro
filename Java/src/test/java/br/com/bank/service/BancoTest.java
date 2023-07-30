package br.com.bank.service;

import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import br.com.bank.model.Banco;
import br.com.bank.model.Conta;

public class BancoTest {    
    
    String nome = "Banco do Brasil";
    private Banco b = new Banco(nome);

    private List<Conta> mockContaRepository;

    public void initValues(){
        mockContaRepository = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            String cpf = String.format("%011d", i);
            mockContaRepository.add(new Conta(cpf));
        }

    }

    private void addConta(Conta conta){
        b.adicionarConta(conta);
        assertEquals(conta, b.pesquisarContaDoCliente(conta.getCpf()));
    }

    @Test
    public void testBanco(){
        initValues();
        mockContaRepository.forEach(x -> addConta(x));

        Random rand = new Random();
        int random;
        int numAltaRenda = 20;
        for (int i =0 ; i <= numAltaRenda ; i++){
            random = rand.nextInt(mockContaRepository.size());
            Conta conta = mockContaRepository.get(random);
            double saldo = conta.getSaldo();
            double valor = i*10000;
            conta.addValor(valor);
            double soma = conta.getSaldo();
            assertEquals(soma, (saldo + valor));
            assertEquals(soma, conta.getSaldo());
            assertEquals(conta, b.pesquisarContaDoCliente(conta.getCpf()));
            assertEquals(conta.getSaldo(), b.pesquisarContaDoCliente(conta.getCpf()).getSaldo());
        }
        List<Conta> contas = b.listarContasAltaRenda();
        contas.forEach(x -> assertTrue(x.getSaldo() >= 10000));
        assertEquals(numAltaRenda, contas.size());
    }
}
