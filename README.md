# Sistema de Gerenciamento de Estoque

## Sistema para gerenciar o estoque de equipamentos de T.I. de uma empresa, controlando cada item por marca, especificações, tag de patrimônio e status.

🚧 Status: em desenvolvimento. Este README é atualizado a cada nova funcionalidade.

## Tecnologias
- Java 25
- Spring Boot 4.2.0
- Spring Web MVC
- Spring Data JPA
- Lombok
- Maven (wrapper incluso: mvnw / mvnw.cmd)

## Funcionalidades
- [x] Estrutura inicial do projeto Spring Boot
- [x] Entidade Notebook mapeada com JPA
- [x] Enum de status (DISPONIVEL, EMPRESTADO, MANUTENCAO, DEFEITO)
- [x] Repositório (NotebookRepository)
- [x] Regras de negócio: cadastro, empréstimo, devolução e alteração de status
- [ ] Configuração do banco de dados
- [ ] Endpoints REST (camada controller)
- [ ] Atualização e remoção de equipamentos
- [ ] Testes automatizados
- [ ] Documentação da API (Swagger/OpenAPI)

## Estrutura do projeto

```
src/main/java/com/bezer/Gerenciamento/de/Estoque/
├── GerenciamentoDeEstoqueApplication.java   # Classe principal
├── model/
│   ├── Notebook.java                         # Entidade JPA
│   └── StatusNotebook.java                   # Enum de status
├── repository/
│   └── NotebookRepository.java               # Acesso ao banco
└── service/
    └── NotebookService.java                  # Regras de negócio
```

Próxima etapa prevista: `controller/`.
## Autor

**André Ribeiro**
- [LinkedIn](https://www.linkedin.com/in/andrebezer/)