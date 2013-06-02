#Sistema de Agendamento de Exames

Sistema de Agendamento de Exames Clínicos com as funções de cadastrar, alterar e excluir médico, exame e paciente, além de permitir o agendamento de exames e salvar o diagnóstico do exame.<br />
Desenvolvido em JSF e Hibernate, utilizando o modelo de desenvolvimento MVC. Apresentado como Trabalho para a disciplina de **Desenvolvimento de Aplicações Web** do 4º período do curso **Tecnologia em Sistemas para Internet**.<br />
[Especificação do Trabalho](https://github.com/ArthurAssuncao/AgendaExames/raw/master/Especificacao/Trabalho_Final_Java_JSF-Hibernate.pdf)

##Leia-me:
1. Instale o sistema de gerenciamento de banco de dados(SGBD) MySQL.
2. Execute o arquivo "dbExames.sql" do diretório "db_sql" no MySQL.
3. Modifique o arquivo "hibernate.cfg.xml" do diretório "source\src\java" com os dados do banco de dados MySQL.
4. Importe o projeto na IDE Netbeans e execute o projeto.
5. Cadastre um usuário.
6. Logue com o usuário criado.
7. Enjoy it.

##Tecnologias Utilizadas
* JSF (JavaServer Faces)
* Hibernate
* Twitter Bootstrap
* JQuery
  * JQuery Tablesorter Plugin
  * JQuery MaskedInput Plugin

##Screenshots

####Cadastrar Médico
![Cadastrar Médico](https://raw.github.com/ArthurAssuncao/AgendaExames/master/screenshots/tela_medico_cadastrar.png)


####Listar Paciente
![Listar Paciente](https://raw.github.com/ArthurAssuncao/AgendaExames/master/screenshots/tela_paciente_listar.png)


####Relatório - Valor Total Exames
![Relatorio - Valor Total Exames](https://raw.github.com/ArthurAssuncao/AgendaExames/master/screenshots/tela_valor_total_exames.png)
