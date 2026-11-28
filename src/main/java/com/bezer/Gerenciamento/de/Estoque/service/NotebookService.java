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

    public Notebook ListarPorApelido(String apelidoComputador){
        return notebookRepository.findByApelidoComputador(apelidoComputador).orElseThrow(() -> new RuntimeException("Notebook com o apelido " + apelidoComputador + " não foi encontrado!"));
    }

    public List<Notebook> ListarPorMemRam(Integer memRam){
        return notebookRepository.findByMemRam(memRam);
    }

    public List<Notebook> ListarPorMemRom(Integer memRom){
        return notebookRepository.findByMemRom(memRom);
    }

    public Notebook salvar(Notebook notebook){

        if (notebookRepository.existsByTagPatrimonio(notebook.getTagPatrimonio())){
            throw new RuntimeException(("Ja existe um Notebook com essa Tag de Patrimonio"));
        }

        validarEspecificacoes(notebook.getApelidoComputador(), notebook.getMemRam(), notebook.getMemRom(), null);

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

    @Transactional
    public Notebook atualizarEspecificacoes(Long id, String apelidoComputador, Integer memRam, Integer memRom){
        Notebook notebook = ListarPorId(id);

        validarEspecificacoes(apelidoComputador, memRam, memRom, id);

        notebook.setApelidoComputador(apelidoComputador);
        notebook.setMemRam(memRam);
        notebook.setMemRom(memRom);
        return notebookRepository.save(notebook);
    }

    // Valida apelido, RAM e ROM. idAtual é o id do notebook sendo editado (null no cadastro).
    private void validarEspecificacoes(String apelidoComputador, Integer memRam, Integer memRom, Long idAtual){
        if (apelidoComputador == null || apelidoComputador.isBlank()){
            throw new RuntimeException("O apelido do computador é obrigatório.");
        }

        if (memRam == null || memRam <= 0){
            throw new RuntimeException("A memória RAM (em GB) deve ser maior que zero.");
        }

        if (memRom == null || memRom <= 0){
            throw new RuntimeException("A memória ROM (em GB) deve ser maior que zero.");
        }

        notebookRepository.findByApelidoComputador(apelidoComputador).ifPresent(existente -> {
            if (!existente.getId().equals(idAtual)){
                throw new RuntimeException("Já existe um Notebook com o apelido " + apelidoComputador);
            }
        });
    }

    @Transactional
    public void deletar(Long id){
        Notebook notebook = ListarPorId(id); // lança exceção se o id não existir

        if (notebook.getStatus() == StatusNotebook.EMPRESTADO){
            throw new RuntimeException("Não é possível excluir um notebook emprestado.");
        }

        notebookRepository.delete(notebook);
    }

}
