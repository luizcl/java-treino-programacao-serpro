package br.com.bank.exceptions;

public class BancoNaoCadastradoException extends RuntimeException {
    public BancoNaoCadastradoException(String mensagem){
        super(mensagem);
    }
}
