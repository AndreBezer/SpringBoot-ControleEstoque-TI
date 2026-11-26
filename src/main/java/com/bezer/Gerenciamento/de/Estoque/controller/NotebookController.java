package com.bezer.Gerenciamento.de.Estoque.controller;

import com.bezer.Gerenciamento.de.Estoque.dto.AtualizarStatusRequest;
import com.bezer.Gerenciamento.de.Estoque.model.Notebook;
import com.bezer.Gerenciamento.de.Estoque.model.StatusNotebook;
import com.bezer.Gerenciamento.de.Estoque.service.NotebookService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Notebook")
public class NotebookController {

    private final NotebookService notebookService;

    public NotebookController(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    @GetMapping
    public ResponseEntity<List<Notebook>> listarTodos(){
        List<Notebook> notebooks = notebookService.ListarTodos();
        return ResponseEntity.ok(notebooks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notebook> buscarPorId(@PathVariable Long id){
        Notebook notebook = notebookService.ListarPorId(id);
        return ResponseEntity.ok(notebook);
    }

    @PostMapping("/add")
    public ResponseEntity<Notebook> salvar(@RequestBody Notebook notebook){
        Notebook notebookSalvo = notebookService.salvar(notebook);
        return ResponseEntity.ok(notebookSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notebook> atualizarStatus(@PathVariable Long id, @RequestBody AtualizarStatusRequest request){
        Notebook notebookAtualizado = notebookService.alterarStatus(id, request.status());
        return ResponseEntity.ok(notebookAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        notebookService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
