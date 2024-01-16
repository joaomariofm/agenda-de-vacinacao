# TASKS

- [ ] ajustar **campo de periodicidade** da **tabela vacinas para** um **enum (dias, semanas, meses, anos)**

- [ ] ajustar **comapo de situacao** da **tabela agendas** para receber um valor **enum ("Agendado", "Cancelado", "Realizado")** ou **Nulo**

- [ ] refatorar **handler de criação de agendas**
    
    - Regra: sempre que uma vacinação for agendada é preciso considerar as informações de doses, periodicidade e intervalo da tabela vacinas, ou seja, se estivermos fazendo a agenda de uma vacina que possui 5 doses, com periodicidade anual e intervalor de 3, o sistema deverá, automaticamente, criar cinco agendas. A primeira agenda será para a data escolhida; a segunda para o mesmo dia/mês (se possível) e três anos a frente; a terceira/quarta/quinta para daqui a 6 anos, 9 anos e 12 anos

- [ ] alterar **input de estado (uf)** no **formulário do usuário** para um **select com os 26 etados**
