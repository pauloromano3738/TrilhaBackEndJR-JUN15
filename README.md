![Código Certo Coders](https://utfs.io/f/3b2340e8-5523-4aca-a549-0688fd07450e-j4edu.jfif)

# 📚 Trilha Inicial BackEnd Jr
Este projeto tem como objetivo desenvolver uma API RESTful para gerenciamento de tarefas, proporcionando funcionalidades de CRUD (Create, Read, Update, Delete) de tarefas, autenticação de usuários e armazenamento dos dados em um banco de dados.

## Objetivos:
- Criar uma API que permita CRUD (Create, Read, Update, Delete) de tarefas.
- Implementar autenticação de usuários.
- Utilizar um banco de dados SQLite para armazenar as tarefas.
- Documentar todo o processo e apresentar as conclusões.

## Requisitos Funcionais:
- Criar Tarefa: Endpoint para criar uma nova tarefa.
- Listar Tarefas: Endpoint para listar todas as tarefas.
- Atualizar Tarefa: Endpoint para atualizar uma tarefa existente.
- Deletar Tarefa: Endpoint para deletar uma tarefa existente.

## Autenticação de Usuários:
- Registro de Usuário: Endpoint para registrar um novo usuário.
- Login de Usuário: Endpoint para autenticar um usuário e gerar um token JWT.
- Proteção de Rotas: Garantir que apenas usuários autenticados possam acessar os endpoints de tarefas.

## Como instalar e usar a API:

- Você também pode usar a API pelo link:

```bash
https://app-projetotrilhabackend-qaw73yn3ya-uc.a.run.app
```

1. Clone o repositório:

```bash
git clone https://github.com/pauloromano3738/TrilhaBackEndJR-JUN15.git
```

2. Instale as dependências com o Maven

3. Inicie o aplicativo com Maven
   
4. A API estará acessível em

```bash
http://localhost:8080:
```

## API Endpoints
- Você pode visualizar a documentação da API pelo swagger no link:
  
```bash
https://app-projetotrilhabackend-qaw73yn3ya-uc.a.run.app/swagger-ui/index.html
```

```markdown
------------------------------------------------------

POST /auth/register - Registra um novo usuário

{
  "nome": "string",
  "login": "string",
  "senha": "string"
}

------------------------------------------------------

POST /auth/login - Login com uma conta de usuário

{
  "login": "string",
  "senha": "string"
}

um token que será gerado como resposta para acessar os outros endpoints.

------------------------------------------------------

GET /usuarios/listar - Lista todos os usuários cadastrados

------------------------------------------------------

GET /usuarios/listar/{id} - Lista o usuário do id passado como parâmetro

------------------------------------------------------

PUT /usuarios/atualizar/{id} - Atualiza o usuário do id passado como parâmetro

{
  "nome": "string",
  "login": "string",
  "senha": "string"
}

------------------------------------------------------

DELETE /usuarios/excluir/{id} - Exclui o usuário do id passado como parâmetro

------------------------------------------------------

GET /tarefas/listar - Lista todas as tarefas cadastradas

------------------------------------------------------

GET /tarefas/listar/{id} - Lista a tarefa do id passado como parâmetro

------------------------------------------------------

POST /tarefas/adicionar - Registra uma nova tarefa

{
  "titulo": "string",
  "descricao": "string",
  "data": "2024-07-11",
  "usuario_id": 0
}

------------------------------------------------------

PUT /tarefas/atualizar/{id} - Atualiza a tarefa do id passado como parâmetro

{
  "titulo": "string",
  "descricao": "string",
  "data": "2024-07-11",
  "usuario_id": 0
}

------------------------------------------------------

DELETE /tarefas/excluir/{id} - Exclui a tarefa do id passado como parâmetro

------------------------------------------------------
```

🌐 **Contato:**
- Email: pauloromano3738@gmail.com

---
