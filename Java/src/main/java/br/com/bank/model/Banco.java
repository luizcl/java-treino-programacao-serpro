package br.com.bank.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Map;

public class Banco {

    private String nome;

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    private Map<String, Conta> contas = new HashMap<String, Conta>();

    public void adicionarConta(Conta conta) {
        contas.put(conta.getCpf(),conta);
    }
    public Conta pesquisarContaDoCliente(String cpf) {
        return contas.get(cpf);
    }

    public Long pesquisaBinariaContaDosClientes(String cpf){
        List<Long> lContas = new ArrayList<>(contas.values().stream().map(x -> Long.valueOf(x.getCpf()))
            .sorted().collect(Collectors.toList()));

        int inicio = 0, meio, fim = lContas.size();
        Long aux_cpf = Long.valueOf(cpf);
        while(inicio != fim){
            meio = inicio + fim /2;
            Long c = lContas.get(meio);
            if(c == aux_cpf){
                return c;
            }
            if(aux_cpf > c){
                inicio = meio;
            } else if(aux_cpf < c){
                fim = meio;
            }
        }
        return 0L;
    }

    public List<Conta> listarContasAltaRenda() {
        return filtrarContas(c -> c.getSaldo() >= 10000);
    }

    private List<Conta> filtrarContas(Predicate<Conta> filtro) {
        return contas.values().stream().filter(filtro).collect(Collectors.toList());
    }
}
