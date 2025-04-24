# Sistema de Cadastro de Alunos

Este é um sistema de cadastro de alunos desenvolvido em Java com interface gráfica usando Swing. O sistema permite gerenciar alunos e suas matrículas em disciplinas.

## Funcionalidades

O sistema oferece as seguintes funcionalidades:

1. **Cadastro de Aluno**
   - Cadastra um novo aluno com nome, CPF, telefone e endereço
   - Permite matricular o aluno em até 5 disciplinas durante o cadastro

2. **Alteração de Aluno**
   - Permite modificar os dados de um aluno existente
   - Busca o aluno pelo CPF
   - Permite atualizar nome, telefone e endereço

3. **Exibição de Aluno**
   - Mostra os dados completos de um aluno específico
   - Exibe informações pessoais e disciplinas matriculadas
   - Busca o aluno pelo CPF

4. **Remoção de Aluno**
   - Remove um aluno do sistema
   - Requer confirmação antes da remoção
   - Busca o aluno pelo CPF

5. **Matrícula em Disciplina**
   - Permite matricular um aluno em uma disciplina
   - Mostra lista de disciplinas disponíveis
   - Verifica se o aluno já está matriculado na disciplina

6. **Listagem de Alunos**
   - Exibe todos os alunos cadastrados no sistema
   - Mostra dados pessoais e disciplinas de cada aluno
   - Apresenta uma mensagem quando não há alunos cadastrados

## Como Usar

1. Execute o programa através da classe `Main`
2. No menu principal, escolha uma das opções disponíveis:
   - Cadastrar aluno
   - Alterar aluno
   - Exibir aluno
   - Remover aluno
   - Matricular aluno
   - Listar todos os alunos
   - Sair

3. Siga as instruções na tela para cada operação:
   - Para cadastrar: informe os dados do aluno e as disciplinas
   - Para alterar: informe o CPF e os novos dados
   - Para exibir: informe o CPF do aluno
   - Para remover: informe o CPF e confirme a remoção
   - Para matricular: informe o CPF e escolha a disciplina
   - Para listar: basta selecionar a opção

## Estrutura do Projeto

O projeto está organizado nos seguintes pacotes:

- `com.estudante`: Contém a classe principal do sistema
- `com.estudante.dao`: Contém as classes de acesso a dados
- `com.estudante.model`: Contém as classes de modelo
- `com.estudante.service`: Contém a lógica de negócios

## Requisitos

- Java JDK 8 ou superior
- Banco de dados MySQL
- Driver JDBC para MySQL

## Observações

- O sistema utiliza interface gráfica com JOptionPane para interação com o usuário
- Todas as operações são validadas antes de serem executadas
- O sistema mantém a consistência dos dados entre alunos e disciplinas
- As mensagens de erro são exibidas de forma clara para o usuário 