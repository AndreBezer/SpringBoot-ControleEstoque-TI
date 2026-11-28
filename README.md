# Sistema de Gerenciamento de Estoque

## Sistema para gerenciar o estoque de equipamentos de T.I. de uma empresa, controlando cada item por marca, especificações (processador, memória RAM e armazenamento), apelido do computador, tag de patrimônio e status.

🚧 Status: em desenvolvimento. Este README é atualizado a cada nova funcionalidade.

## Tecnologias
- Java 25
- Spring Boot 4.2.0
- Spring Web MVC
- Spring Data JPA
- Banco de dados H2 (em arquivo, na pasta `data/`)
- Lombok
- Maven (wrapper incluso: mvnw / mvnw.cmd)

## Funcionalidades
- [x] Estrutura inicial do projeto Spring Boot
- [x] Entidade Notebook mapeada com JPA
- [x] Enum de status (DISPONIVEL, EMPRESTADO, MANUTENCAO, DEFEITO)
- [x] Repositório (NotebookRepository)
- [x] Regras de negócio: cadastro, empréstimo, devolução e alteração de status
- [x] Configuração do banco de dados (H2 em arquivo)
- [x] Endpoints REST (camada controller)
- [x] Atualização de status e remoção de equipamentos
- [x] Apelido do computador, memória RAM e memória ROM no cadastro do Notebook
- [x] Busca por apelido, RAM e ROM
- [x] Atualização das especificações (apelido, RAM e ROM)
- [ ] Testes automatizados
- [ ] Documentação da API (Swagger/OpenAPI)

## Estrutura do projeto

```
src/main/java/com/bezer/Gerenciamento/de/Estoque/
├── GerenciamentoDeEstoqueApplication.java   # Classe principal
├── controller/
│   └── NotebookController.java               # Endpoints REST
├── dto/
│   ├── AtualizarStatusRequest.java           # Corpo da requisição de status
│   └── AtualizarEspecificacoesRequest.java   # Corpo da requisição de especificações
├── model/
│   ├── Notebook.java                         # Entidade JPA
│   └── StatusNotebook.java                   # Enum de status
├── repository/
│   └── NotebookRepository.java               # Acesso ao banco
└── service/
    └── NotebookService.java                  # Regras de negócio
```

## Campos do Notebook

| Campo | Coluna | Descrição |
|-------|--------|-----------|
| `marca` | `marca` | Marca do equipamento |
| `processador` | `processador` | Processador |
| `tagPatrimonio` | `tag_patrimonio` | Tag de patrimônio (única) |
| `apelidoComputador` | `apelido_computador` | Apelido do computador (único) |
| `memRam` | `mem_ram` | Memória RAM em GB (ex.: 16) |
| `memRom` | `mem_rom` | Armazenamento em GB (ex.: 512) |
| `status` | `status` | DISPONIVEL, EMPRESTADO, MANUTENCAO ou DEFEITO |

No cadastro, apelido, RAM e ROM são obrigatórios (RAM e ROM maiores que zero) e o status inicial é sempre `DISPONIVEL`.

## Endpoints

Base: `/Notebook`

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/Notebook` | Lista todos os notebooks |
| GET | `/Notebook/{id}` | Busca por id |
| GET | `/Notebook/apelido/{apelido}` | Busca por apelido do computador |
| GET | `/Notebook/ram/{gb}` | Lista notebooks com a RAM informada |
| GET | `/Notebook/rom/{gb}` | Lista notebooks com o armazenamento informado |
| POST | `/Notebook/add` | Cadastra um notebook |
| PUT | `/Notebook/{id}` | Atualiza o status |
| PUT | `/Notebook/{id}/especificacoes` | Atualiza apelido, RAM e ROM |
| DELETE | `/Notebook/{id}` | Remove um notebook (não permitido se estiver emprestado) |

### Exemplo de cadastro

`POST /Notebook/add`

```json
{
  "marca": "Dell",
  "processador": "Intel i5",
  "tagPatrimonio": "TI-001",
  "apelidoComputador": "NOTE-FINANCEIRO-01",
  "memRam": 16,
  "memRom": 512
}
```

### Exemplo de atualização de status

`PUT /Notebook/1`

```json
{
  "status": "MANUTENCAO"
}
```

### Exemplo de atualização de especificações

`PUT /Notebook/1/especificacoes`

```json
{
  "apelidoComputador": "NOTE-FINANCEIRO-01",
  "memRam": 32,
  "memRom": 1024
}
```

## Autor

**André Ribeiro**
- [LinkedIn](https://www.linkedin.com/in/andrebezer/)