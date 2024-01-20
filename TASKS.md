# TASKS

- [x] ajustar **campo de periodicidade** da **tabela vacinas para** um **enum (dias, semanas, meses, anos)**

- [x] ajustar **compo de situacao** da **tabela agendas** para receber um valor **enum ("Agendado", "Cancelado", "Realizado")**

- [x] adicionar **select de alergias** no formulário de criação de **usuário**

- [x] adicionar **select de vacinas** no formulário de criação de **agenda**

- [x] adicionar **select de usuários** no formulário de criação de **agenda**

- [x] refatorar **handler de criação de agendas**
    
    - Regra: sempre que uma vacinação for agendada é preciso considerar as informações de doses, periodicidade e intervalo da tabela vacinas, ou seja, se estivermos fazendo a agenda de uma vacina que possui 5 doses, com periodicidade anual e intervalor de 3, o sistema deverá, automaticamente, criar cinco agendas. A primeira agenda será para a data escolhida; a segunda para o mesmo dia/mês (se possível) e três anos a frente; a terceira/quarta/quinta para daqui a 6 anos, 9 anos e 12 anos

- [x] criar opções de marcar agenda como "Cancelada" ou "Realizada"

- [x] criar visualização das **alergias** de um usuário em específico
    
    - novo botão na tabela associado a listagem de alergia, o botão abre uma nova modal
    - nova modal que exibe no nome de todas as alergia do usuário

- [ ] criar filtro para visualizar apenas as **agendas do dia corrente**

- [ ] sempre exibir primeiro as agendas no estado **Aguardando**, depois as agendas nos estados **Realizado** e **Cancelado**

- [ ] criar filtro para visualizar apenas as **agendas** de um usuário em específico

- [ ] alterar **input de estado (uf)** no **formulário do usuário** para um **select com os 26 etados**
