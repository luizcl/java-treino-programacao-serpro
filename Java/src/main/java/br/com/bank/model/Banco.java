package br.com.bank.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    private List<Conta> contasL = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.put(conta.getCpf(),conta);
        contasL.add(conta);
    }

    public void ordenarContas(){
        Comparator<Conta> comp = Comparator.comparing(Conta::getCpf);
        Collections.sort(contasL, comp);
    }

    public Conta pesquisarContaDoCliente(String cpf) {
        return contas.get(cpf);
    }

    public Conta pesquisarContaDoClienteOld(String cpf) {
        Conta c = null;
        for (int i = 0; i < contasL.size(); i++) {
            if (contasL.get(i).getCpf().equals(cpf)) {
                c = contasL.get(i);
            }
        }
        return c;
    }

    public Conta pesquisarContaDoClienteOldBreak(String cpf) {
        Conta c = null;
        for (int i = 0; i < contasL.size(); i++) {
            if (contasL.get(i).getCpf().equals(cpf)) {
                c = contasL.get(i);
                break;
            }
        }
        return c;
    }

    public Conta pesquisaBinariaContaDosClientes(String cpf){

        int inicio = 0, meio, fim = ( contasL.size() -1);
        while(inicio <= fim){
            meio = (inicio + fim) /2;
            Conta c = contasL.get(meio);
            String cpf_conta = c.getCpf();
            if(cpf.compareTo(cpf_conta)==0){
                return c;
            }
            else if(cpf.compareTo(cpf_conta)>0){
                inicio = meio + 1;
            } else{
                fim = meio - 1;
            }
        }
        return null;
    }

    public List<Conta> listarContasAltaRenda() {
        return filtrarContas(c -> c.getSaldo() >= 10000);
    }

    private List<Conta> filtrarContas(Predicate<Conta> filtro) {
        return contas.values().stream().filter(filtro).collect(Collectors.toList());
    }
}
