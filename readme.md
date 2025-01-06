# Projeto desafio

Fazer a gravação e consulta de pedidos com um volume diário entre 150.000 a 200.000 requsições diárias

## Tecnologias utilizadas

Para o projeto foi utilizado Springboot 3 com java 17

Flyway para criação e inserção de dados inicial
Actuator para métricas
Swagger para dcoumentação
Lombok para reduzir verbosidade do java
Banco de dados postgres

## Software testes

criado a pasta de evidencias com os arquivos gerados do postman e jmeter, utilizado para teste de integração e carga

Feito uma carga de 60 (threads) com 500 requisições cada totalizando 30.000 requisições em menos de 2 minutos

Houve maior estress no banco de dados devido a quatidade de volume de transações, não caiu apenas foi uma carga extensa.

Para maiores demandas pensar em banco de dados replicados, e se tiver muita demanda de consulta utilizar estratégia de banco de gravação e banco de consulta.


## Container

Foi criado arquivo em docker e para subir o projeto todo em docker-compose, comando abaixo para iniciar o projeto


docker-compose up --build