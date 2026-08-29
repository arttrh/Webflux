Estudando webflux e sobre programação reativa usei mongoDB, 
docker claro (Não queria instalar o software) 
subi um container,
nesse repo trabalhei com Handler e Route para saber como funciona a questão dos endpoints,
Talvez pretendo seguir com esse repo...

COMANDO EXCLUSIVAMENTE PARA USUARIOS DE LINUX:

Obviamente tem que ter o docker instalado na sua maquina
Caso tenha olha os status
sudo systemctl status docker, caso esteja desativado
sudo systemctl start docker
docker run -d \                      
  --name mongodb \
  -p 27017:27017 \
  -v mongo_data:/data/db \
  mongo:latest

  docker exect -it mongodb mongosh

  crie o banco: use webflux 
  E seja feliz fazendo querys com esse codigo.
