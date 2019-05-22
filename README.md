# gerenciador-de-login

Requisitos:
    -Maven
    -Docker
    -Minikube kubectl


1º criar um pacote da aplicação:
    $mvn package -DskipTests
    
2º Buildar Dockerfile:
    $ docker build -t saadapplestore/gereciador-login-usuario .
    
3º realizar login no docker hub:
    $ docker login
    
4º enviar imagem para o servidor:
    $ docker push saadapplestore/gerenciador-login-usuario
    
5º Após o container estiver ok no hub é hora de rodar o minikube
    $ minikube start
   Aguardar fim do processo de criação da vm

6º Após finalizar criação do kubernetes ele vincula o minikube com o kubectl, hora de ativar os serviços no kubernetes:
    $ kubectl create -f ./kubernetes/mongoVolume.yalm
    $ kubectl create -f ./kubernetes/mongoVolumeClaim.yalm
    $ kubectl create -f ./kubernetes/mongoDeploy.yalm
    $ kubectl create -f ./kubernetes/mongoService.yalm
    $ kubectl create -f ./kubernetes/springDeploy.yalm
    $ kubectl create -f ./kubernetes/springService.yalm
    $ kubectl get service
    $ minikube ip
    
7º aguarde o cluster processar os arquivos e verifique o acesso:
    http://minikubeip:porta referente a web-service/users
    EX: http://192.168.99.106:31960/users

8º parametros para pesquisa:
http://192.168.99.106:31960/users?page=0&size=3&sort=name&order=desc
page = pagina que está visualizando
size = numero de registros que são exibidos por pagina
sort = atributo de User que deseja que seja ordenavel
order = ordem da ordenação desc ou asc;


