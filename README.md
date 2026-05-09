# Anotação

> Projeto em desenvolvimento

Sistema pessoal de anotações com busca inteligente via IA. A ideia surgiu conversando com um amigo que estava desenvolvendo algo similar — resolvi criar o meu próprio do zero.

Você anota algo que aprendeu ou qualquer coisa com um título, e depois consegue buscar em uma lista paginada (10 itens por página). Se não lembrar o título ou o conteúdo, é só perguntar para o agente de IA que ele busca e explica detalhadamente.

## Tech Stack

- **Java 17** + **Spring Boot 3.5.14**
- Spring Web, Spring Data JPA, Spring Validation
- MySQL + Docker Compose
- Lombok
- MapStruct
- LangChain4j + Anthropic (Claude)
- Futuramente: Frontend via IA no terminal

## Estrutura do Projeto

```
src/main/java/Debug_._Grow/br/com/anotacao/
├── controller/
│   └── AnotacaoController.java     # Endpoints REST
├── dto/
│   ├── AnotacaoDTO.java            # Record de saída
│   ├── AnotacaoRequestDTO.java     # Record de criação
│   └── AnotacaoUpdateDTO.java      # Record de atualização
├── exception/
│   ├── AnotacaoNotFoundException.java
│   └── GlobalExceptionHandler.java # Tratamento global de erros
├── mapper/
│   └── AnotacaoMapper.java         # MapStruct (gerado automaticamente)
├── model/
│   └── Anotacao.java               # Entidade JPA (tb_anotacao)
├── repository/
│   └── AnotacaoRepository.java     # JPA Repository
└── service/
    └── AnotacaoService.java        # Lógica de negócio
```

## Endpoints

| Método | Rota                | Descrição                     |
|--------|---------------------|-------------------------------|
| POST   | `/anotacoes`        | Cria uma anotação             |
| GET    | `/anotacoes/{id}`   | Retorna anotação por ID       |
| GET    | `/anotacoes/listar` | Lista anotações (10 por página) |
| PUT    | `/anotacoes/{id}`   | Atualiza uma anotação         |
| DELETE | `/anotacoes/{id}`   | Remove uma anotação           |

A listagem aceita o parâmetro `?pagina=0` (0-indexed). Cada página retorna até 10 anotações.

## Decisões Técnicas

### 1. MapStruct para mapeamento
Uso do MapStruct com `componentModel = "spring"` para gerar automaticamente a implementação do mapper entre entidade e DTO, eliminando boilerplate e erros manuais.

### 2. Records para DTOs
Uso de `record` do Java para DTOs — mais conciso, imutável e menos código que classes tradicionais.

### 3. Arquitetura em camadas
Segue o padrão **Controller → Service → Repository**, separando responsabilidades e facilitando manutenção e testes.

### 4. LangChain4j + Anthropic para busca inteligente
Integração com IA (Claude via Anthropic) para buscar anotações quando você não lembra o título exato. Basta descrever o conteúdo que o agente encontra e explica. *(Em implementação)*

### 5. Paginação nativa com Spring Data
Uso de `Pageable` e `PageRequest.of(pagina, 10)` para controle de paginação direto do Spring Data JPA.

## Como Rodar

```bash
# Sobe o MySQL
docker compose up -d

# Configurar variáveis de ambiente (ou usar .env)
export DB_USERNAME=root
export DB_PASSWORD=sua-senha
export DB_NAME=mydatabase
export ANTHROPIC_API_KEY=sk-ant-sua-chave

# Rodar a aplicação
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```

Testar com Insomnia, Postman ou similar:

```bash
# Criar anotação
curl -X POST http://localhost:8080/anotacoes \
  -H "Content-Type: application/json" \
  -d '{"titulo": "Meu titulo", "anotacao": "Minha anotacao"}'

# Listar página 0
curl http://localhost:8080/anotacoes/listar?pagina=0
```

## Próximos Passos

- [ ] Implementar integração com LangChain4j + Anthropic (busca inteligente)
- [ ] Melhorar tratamento de exceções e validações
- [ ] Desenvolver frontend via IA integrada no terminal
- [ ] Publicar vídeo de demonstração no LinkedIn
- 
## Em andamento: documentação dos passos que tomei no projeto.

## 👨‍💻 Desenvolvido por
**Gustavo Bueno Mazur**  
[LinkedIn](https://www.linkedin.com/in/gustavo-bueno-mazur/https://www.linkedin.com/in/gustavo-bueno-mazur/)
