# Demo API

API REST simples para criar e gerenciar tarefas. O projeto foi desenvolvido com Java 21 e Spring Boot, usando Spring Data JPA e H2 para persistência.

## Como executar

É necessário ter o Java 21 instalado. Na raiz do projeto, execute:

```bash
.\mvnw.cmd spring-boot:run
```

A API ficará disponível em `http://localhost:8080`.

## Endpoints

| Método | Caminho | Descrição |
|---|---|---|
| `GET` | `/api/tasks` | Lista as tarefas |
| `GET` | `/api/tasks/{id}` | Busca uma tarefa pelo ID |
| `POST` | `/api/tasks/create` | Cria uma tarefa |
| `POST` | `/api/tasks/update` | Atualiza uma tarefa |
| `PUT` | `/api/tasks/{id}/complete` | Marca uma tarefa como concluída |
| `DELETE` | `/api/tasks/{id}/delete` | Exclui uma tarefa |

Uma coleção de exemplos para testar os endpoints está disponível em `postman_collection.json`.
