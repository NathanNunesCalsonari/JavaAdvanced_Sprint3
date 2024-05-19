# DataTech
Integrantes do Grupo:
Grupo:

Nome Completo: Ana Paula Nascimento Silva- rm552513

Responsabilidade no Projeto: empresaControler.java , cronograma;
Nome Completo: Calina Thalya Santana da Silva- rm552523

Responsabilidade no Projeto: homeControler.java , documentação/organização no github

Nome Completo: Geovana Ribeiro Domingos Silva- rm99646

Responsabilidade no Projeto: empresaDTO.java

Nome Completo: Leonardo Camargo Lucena- rm552537

Responsabilidade no Projeto: empresa.java
Nome Completo: Nathan Nunes Calsonari- rm552539

Responsabilidade no Projeto: empresaRepository.java , empresaService.java
Instruções de Execução
Para executar a aplicação, siga os passos abaixo:

Precisa primeiro ter o tomcat server v10.1

Em seguida, precisa selecionar qual método vai querer, GET, SET, PUT, DELETE

Vídeo de Apresentação
Assista ao vídeo de apresentação da proposta tecnológica, público-alvo e problemas que a aplicação se propõe a solucionar aqui: https://www.youtube.com/watch?v=TsUd9z82e2E.

Atualizaçôes:
No atual projeto, atualizamos alguns erros que tinha no programa, como não conseguir acessar o banco de dados e cadastrar algum produto. Além disso foi acrescentado o CRUD do produto, pois nossa ideia visa utilizar
ele também para que as empresas consigam registrar seu produto para ter os feedbacks dos clientes. 

Vale mencionar também que houve uma mudança no banco de dados e os diagramas de classe foram atualizados.

Imagem dos Diagramas de classe:
![image](https://github.com/NathanNunesCalsonari/JavaAdvanced_Sprint2/assets/130010914/c787ba51-d6e9-449f-82c0-b08eab6d44bf)

![image](https://github.com/NathanNunesCalsonari/JavaAdvanced_Sprint2/assets/130010914/c6968ffc-ac64-4226-b28a-c804ee2324cb)

Imagem do Diagrama de Entidade e Relacionamento
![image](https://github.com/NathanNunesCalsonari/JavaAdvanced_Sprint2/assets/130010914/4b612fc8-8035-4ee5-b3b9-03d147687718)

#Endpoints:
GET /empresa/listar
GET /empresa/{id}
POST /empresa/cadastrar
PUT /empresa/{id}
DELETE /empresa/{id}

GET /produto/listar
GET /produto/{id}
POST /produto/cadastrar
PUT /produto/{id}
DELETE /produto/{id}
