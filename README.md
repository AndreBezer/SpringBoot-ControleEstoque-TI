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
- [ ] Configuração do banco de dados
- [ ] Repositório (NotebookRepository)
- [ ] Regras de negócio (camada service)
- [ ] Endpoints REST (camada controller)
- [ ] Cadastro, listagem, atualização e remoção de equipamentos
- [ ] Controle de status (ex.: em estoque, em uso, em manutenção)
- [ ] Testes automatizados
- [ ] Documentação da API (Swagger/OpenAPI)

## Estrutura do projeto

```
src/main/java/com/bezer/Gerenciamento/de/Estoque/
├── GerenciamentoDeEstoqueApplication.java   # Classe principal
└── model/
    └── Notebook.java                         # Entidade JPA
```

Pastas previstas para as próximas etapas: `repository/`, `service/` e `controller/`.

## Autor

**André Ribeiro**
- [LinkedIn](https://www.linkedin.com/in/andrebezer/)