package br.com.coruja.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.coruja.domain.model.Aluno;
import br.com.coruja.domain.repository.AlunoRepository;

@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepository rep;

    public Aluno salvar(Aluno a){
        return rep.save(a);
    }

    public Aluno buscar(int id){
        return rep.findById(id).orElse(null);
    }

    public List<Aluno> listar(){
        return rep.findAll();
    }

    public Aluno atualizAluno(int id, Aluno a){
        Aluno aluno = buscar(id);

        if(aluno != null){
            if(a.getNome() != null){
                aluno.setNome(a.getNome());
            }
            if(a.getEmail() != null){
                aluno.setEmail(a.getEmail());
            }
            return salvar(aluno);
        }else{
            return null;
        }
        
    }

    public boolean removerAluno(Aluno a){
        Aluno aluno = buscar(a.getId());

        if(aluno != null){
            rep.deleteById(a.getId());
            return true;
        }else{
            return false;
        }
    }

    public boolean removerAluno(int id){
        Aluno aluno = buscar(id);

        if(aluno != null){
            rep.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

}
