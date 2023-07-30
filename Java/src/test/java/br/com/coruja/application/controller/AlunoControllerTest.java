package br.com.coruja.application.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.coruja.domain.model.Aluno;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AlunoControllerTest {
    
    @Autowired
    protected WebTestClient web;

    @BeforeEach
    public void setUp() {
        web = web.mutate().responseTimeout(Duration.ofMillis(10000)).build();
    }

    @Test
    public void adicionaAluno() {
        Aluno aluno = new Aluno("João da Silva", "joao@example.com");

        web.post().uri("/alunos")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(aluno)
            .exchange().expectStatus().isEqualTo(HttpStatus.CREATED)
            .expectBody(Aluno.class)
            .value(a -> { assertEquals(aluno.getNome(), a.getNome());
                        assertEquals(aluno.getEmail(), a.getEmail()); });

    }

}
