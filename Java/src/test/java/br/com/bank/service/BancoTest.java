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
    private final int max = 100000;
    public void initValues(){
        mockContaRepository = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
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

        Conta c;

        String cpf = String.format("%011d", 500);
        long inicio = System.nanoTime();
        c = b.pesquisarContaDoClienteOld(cpf);
        long fim = System.nanoTime();
        long duracao = fim - inicio;
        assertEquals(c.getCpf(),cpf);

        inicio = System.nanoTime();
        c = b.pesquisarContaDoCliente(cpf);
        fim = System.nanoTime();
        long duracao2 = fim - inicio;
        assertEquals(c.getCpf(),cpf);

        inicio = System.nanoTime();
        c = b.pesquisarContaDoClienteOldBreak(cpf);
        fim = System.nanoTime();
        long duracao3 = fim - inicio;
        assertEquals(c.getCpf(),cpf);

        b.ordenarContas();
        inicio = System.nanoTime();
        c = b.pesquisaBinariaContaDosClientes(cpf);
        fim = System.nanoTime();
        long duracao4 = fim - inicio;
        assertEquals(c.getCpf(),cpf);

        System.out.println("Duração do método antigo: " + duracao);
        System.out.println("Duração do método usando map: " + duracao2);
        System.out.println("Duração do método com o break: " + duracao3);
        System.out.println("Duração do método usando pesquisa Binária: " + duracao4);

        assertTrue(duracao2<duracao);

    }

}
