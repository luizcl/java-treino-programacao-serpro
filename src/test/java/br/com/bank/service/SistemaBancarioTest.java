package br.com.bank.service;

import br.com.bank.exceptions.BancoNaoCadastradoException;
import br.com.bank.gateway.Bacen;
import br.com.bank.model.Banco;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.quality.Strictness;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class SistemaBancarioTest {

    @InjectMocks
    private SistemaBancario sistemaBancario;
    @Mock
    private Bacen bacen;


    @Test
    public void testFakeBacen(){
        BacenFake bc = new BacenFake();
        sistemaBancario = new SistemaBancario(bc);
        Banco b = new Banco("Banco do Brasil");
        assertEquals(sistemaBancario.registrarBanco(b) , 
            (bc.getBancosCadastrados().get(b.getNome())));
    }

    @Test
    public void testStubBacen(){
        Bacen bc = new BacenStub();
        sistemaBancario = new SistemaBancario(bc);
        Banco b = new Banco("Banco do Brasil");
        assertEquals(123, sistemaBancario.registrarBanco(b));
    }

    @Test
    public void testMock(){
        /* Caso o cadastro do banco no Bacen tenha sido feito com sucesso, 
            ele retorna o número de registro do Banco */
        when(bacen.cadastrarBanco(any(Banco.class)))
            .thenReturn(123L);

        assertEquals(123L, bacen.cadastrarBanco(new Banco("AAA")));

        /* Caso o cadastro do banco no Bacen tenha dado algum problema, 
            a exceção BancoNaoCadastradoException do tipo RuntimeException deve ser retornada. 
            Use o assertThrows para isso. */
        when(bacen.cadastrarBanco(any(Banco.class)))
            .thenThrow(BancoNaoCadastradoException.class);
        
        assertThrows(BancoNaoCadastradoException.class, 
            () -> bacen.cadastrarBanco(new Banco("Santander")), "Banco não cadastrado");
    }
}