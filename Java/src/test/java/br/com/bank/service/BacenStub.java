package br.com.bank.service;

import br.com.bank.gateway.Bacen;
import br.com.bank.model.Banco;

public class BacenStub extends Bacen {

    public long cadastrarBanco(Banco banco) {
        System.out.println("Cadastrando banco " + banco.getNome() );
        System.out.println(" ... ... ... ");
        System.out.println("Banco cadastrado com sucesso!");
        System.out.println("Número de registro: " + 123);

        return 123;
    }

}
