package com.bezer.Gerenciamento.de.Estoque.service;

import com.bezer.Gerenciamento.de.Estoque.model.Notebook;
import com.bezer.Gerenciamento.de.Estoque.model.StatusNotebook;
import com.bezer.Gerenciamento.de.Estoque.repository.NotebookRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotebookService {

    public final NotebookRepository notebookRepository;

    public NotebookService(NotebookRepository notebookRepository){
        this.notebookRepository = notebookRepository;
    }

    public List<Notebook> ListarTodos(){
        return notebookRepository.findAll();
    }

    public List<Notebook> ListarStatus(StatusNotebook status){
        return notebookRepository.findByStatus(status);
    }

    public Notebook ListarPorId(Long id){
        return notebookRepository.findById(id).orElseThrow(() -> new RuntimeException("Notebook com o id " + id + " não foi encontrado!"));
    }

    public Notebook ListarPorTagPatrimonio(String tagPatrimonio){
        return notebookRepository.findByTagPatrimonio(tagPatrimonio).orElseThrow(() -> new RuntimeException("Notebook com a Tag de Patrimonio " + tagPatrimonio + " não foi encontrado!"));
    }

    public Notebook salvar(Notebook notebook){

        if (notebookRepository.existsByTagPatrimonio(notebook.getTagPatrimonio())){
            throw new RuntimeException(("Ja existe um Notebook com essa Tag de Patrimonio"));
        }

        notebook.setStatus(StatusNotebook.DISPONIVEL);

        return notebookRepository.save(notebook);
    }

    @Transactional
    public Notebook emprestar(Long id){
        Notebook notebook = ListarPorId(id);

        if (notebook.getStatus() != StatusNotebook.DISPONIVEL){
            throw new RuntimeException("Notebook indisponivel. Status atual: " + notebook.getStatus());
        }

        notebook.setStatus(StatusNotebook.EMPRESTADO);
        return notebookRepository.save(notebook);
    }

    @Transactional
    public Notebook devolver(Long id){
        Notebook notebook = ListarPorId(id);

        if (notebook.getStatus() != StatusNotebook.EMPRESTADO){
            throw new RuntimeException("Só é possível devolver um notebook emprestado. Status atual: " + notebook.getStatus());
        }

        notebook.setStatus(StatusNotebook.DISPONIVEL);
        return notebookRepository.save(notebook);
    }

    @Transactional
    public Notebook alterarStatus(Long id, StatusNotebook novoStatus) {
        Notebook notebook = ListarPorId(id);
        notebook.setStatus(novoStatus);
        return notebookRepository.save(notebook);
    }

}
