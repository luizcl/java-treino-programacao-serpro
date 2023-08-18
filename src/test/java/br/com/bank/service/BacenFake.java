package br.com.bank.service;

import java.util.Hashtable;
import java.util.Random;

import java.util.Map;

import br.com.bank.gateway.Bacen;
import br.com.bank.model.Banco;

public class BacenFake extends Bacen {

    private Map<String, Long> bancos = new Hashtable<>();

    public long cadastrarBanco(Banco banco) {
        long registro = 0;
        if(bancos.get(banco.getNome()) == null){
            Random rand = new Random();
            registro = rand.nextLong();
            bancos.put(banco.getNome(), registro);
            return registro;
        } else {
            return bancos.get(banco.getNome());
        }
	}

    public Map<String,Long> getBancosCadastrados(){
        return bancos;
    }

}
