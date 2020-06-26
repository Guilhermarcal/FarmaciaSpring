# FarmaciaSpring
Trabalho de Desenvolvimento WEB em java / SpringBoot desenvolvido por alunos da faculdade COTEMIG - BH

O trabalho é baseado em um sistema de vendas para uma farmacia, onde temos aplicações do tipo:

- Produtos :
  - Codigo
  - Nome
  - Preço
  - Imagem
  
- Order : 
  - Numero do pedido
  - Informações do cliente
   
- Account :
  - Nome do usuario ( utilizado na tela de login )
  - Senha ( com criptografia )
  - Ativo ( 1 para true )
  - Role ( tipo do usuário :
            - Employee - Funcionario
            - Manager - Gerente
                
Para o funcionamento da aplicação, é necessário cadastrar as informações de login pelo banco de dados

Exemplo : 
  - INSERT INTO `accounts` (`USER_NAME`, `ACTIVE`, `ENCRYTED_PASSWORD`, `USER_ROLE`) VALUES
    ('funcionario', b'1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_EMPLOYEE'),
    ('gerente', b'1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_MANAGER');
