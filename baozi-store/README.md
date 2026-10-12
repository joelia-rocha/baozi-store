# Baozi Store – API REST

API REST em **Java 17 + Spring Boot 3** (Spring Data JPA, H2) para controlar clientes, produtos e pedidos de uma loja de pão chinês.

## Estrutura
```
src/main/java/com/baozistore/
  BaoziStoreApplication.java
  model/       Cliente, Produto, Pedido
  repository/  ClienteRepository, ProdutoRepository, PedidoRepository
  controller/  ClienteController, ProdutoController, PedidoController
  dto/         PedidoRequest
```

## Como executar
```bash
mvn spring-boot:run
```
A API sobe em http://localhost:8080 (banco H2 em arquivo `./data/baozistore`).
Para MySQL: `mvn spring-boot:run -Dspring-boot.run.profiles=mysql`

## Endpoints
| Entidade | Método | URL | Resposta |
|---|---|---|---|
| Cliente/Produto/Pedido | POST | /clientes, /produtos, /pedidos | 201 |
| idem | GET | /clientes, /produtos, /pedidos | 200 |
| idem | GET | /{recurso}/{id} | 200 / 404 |
| idem | PUT | /{recurso}/{id} | 200 / 404 |
| idem | DELETE | /{recurso}/{id} | 204 / 404 (409 se houver pedidos) |

Regras: pedido exige cliente e produto existentes (404) e produto com estoque (400);
cliente/produto com pedidos não pode ser apagado (409).

## Testes no Postman
Importe `postman/BaoziStore.postman_collection.json` e execute as requisições **na ordem** (Print 1 a Print 11).
Use um banco limpo (apague a pasta `data/` antes) para que os ids sejam 1, 1 e 1.
