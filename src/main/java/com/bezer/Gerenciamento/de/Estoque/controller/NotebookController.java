package com.bezer.Gerenciamento.de.Estoque.controller;

import com.bezer.Gerenciamento.de.Estoque.dto.AtualizarEspecificacoesRequest;
import com.bezer.Gerenciamento.de.Estoque.dto.AtualizarStatusRequest;
import com.bezer.Gerenciamento.de.Estoque.model.Notebook;
import com.bezer.Gerenciamento.de.Estoque.service.NotebookService;
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

    @GetMapping("/apelido/{apelido}")
    public ResponseEntity<Notebook> buscarPorApelido(@PathVariable String apelido){
        Notebook notebook = notebookService.ListarPorApelido(apelido);
        return ResponseEntity.ok(notebook);
    }

    @GetMapping("/ram/{gb}")
    public ResponseEntity<List<Notebook>> buscarPorMemRam(@PathVariable Integer gb){
        return ResponseEntity.ok(notebookService.ListarPorMemRam(gb));
    }

    @GetMapping("/rom/{gb}")
    public ResponseEntity<List<Notebook>> buscarPorMemRom(@PathVariable Integer gb){
        return ResponseEntity.ok(notebookService.ListarPorMemRom(gb));
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

    @PutMapping("/{id}/especificacoes")
    public ResponseEntity<Notebook> atualizarEspecificacoes(@PathVariable Long id, @RequestBody AtualizarEspecificacoesRequest request){
        Notebook notebookAtualizado = notebookService.atualizarEspecificacoes(id, request.apelidoComputador(), request.memRam(), request.memRom());
        return ResponseEntity.ok(notebookAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        notebookService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}