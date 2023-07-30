package br.com.coruja.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.coruja.domain.model.Aluno;
import br.com.coruja.domain.service.AlunoService;

/*
 * Essa classe precisa estar neste pacote pois o spring 
 * só reconhece os endpoints de quem está no mesmo pacote
 * do annotation @SpringBootApplication
 */

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoService as;

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> find(@PathVariable int id){
        Aluno a = as.buscar(id);
        if( a != null){
            //return ResponseEntity.status(200).body(a);
            //ou
            return ResponseEntity.ok(a);
        } else{
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping
    public ResponseEntity<List<Aluno>> list(){
        List<Aluno> alunos = as.listar();

        if( alunos != null){
            return ResponseEntity.ok(alunos);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Aluno> save(@RequestBody Aluno a){
        Aluno salvo = as.salvar(a);

        if(salvo != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        }else{
            return ResponseEntity.noContent().
                    header("Aluno não salvo", a.getNome()).
                    build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> put(@PathVariable int id, @RequestBody Aluno a){
        Aluno aluno = as.atualizAluno(id, a);

        if(aluno != null){
            return ResponseEntity.ok(aluno);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable int id){
        if(as.removerAluno(id)){
            return ResponseEntity.ok(id);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
