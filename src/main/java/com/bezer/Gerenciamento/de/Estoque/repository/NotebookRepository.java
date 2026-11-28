package com.bezer.Gerenciamento.de.Estoque.repository;

import com.bezer.Gerenciamento.de.Estoque.model.Notebook;
import com.bezer.Gerenciamento.de.Estoque.model.StatusNotebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Acesso ao banco de dados da entidade Notebook.
 * Já herda o CRUD pronto (save, findById, findAll, deleteById).
 */
@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Long> {

    /**
     * Busca todos os notebooks com o status informado.
     * Retorna lista vazia se não houver nenhum.
     */
    List<Notebook> findByStatus(StatusNotebook status);

    /**
     * Verifica se já existe um notebook com essa tag de patrimônio.
     * Retorna true se existir e false se estiver livre.
     */
    boolean existsByTagPatrimonio(String tagPatrimonio);

    /**
     * Busca um notebook pela tag de patrimônio.
     * Retorna Optional vazio se não encontrar.
     */
    Optional<Notebook> findByTagPatrimonio(String tagPatrimonio);

    /**
     * Busca um notebook pelo apelido do computador.
     * Retorna Optional vazio se não encontrar.
     */
    Optional<Notebook> findByApelidoComputador(String apelidoComputador);

    /**
     * Verifica se já existe um notebook com esse apelido.
     * Retorna true se existir e false se estiver livre.
     */
    boolean existsByApelidoComputador(String apelidoComputador);

    /**
     * Busca todos os notebooks com a quantidade de memória RAM (GB) informada.
     * Retorna lista vazia se não houver nenhum.
     */
    List<Notebook> findByMemRam(Integer memRam);

    /**
     * Busca todos os notebooks com o armazenamento (GB) informado.
     * Retorna lista vazia se não houver nenhum.
     */
    List<Notebook> findByMemRom(Integer memRom);
}
