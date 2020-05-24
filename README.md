# chat-desktop
# Screenshots
![1](https://user-images.githubusercontent.com/64668717/82762537-fa3c3280-9dd7-11ea-827b-0afa706d3734.png)
![2](https://user-images.githubusercontent.com/64668717/82762541-fad4c900-9dd7-11ea-874a-ca2962ab952a.png)
![borda](https://user-images.githubusercontent.com/64668717/82762700-e1804c80-9dd8-11ea-80eb-a3213c7da80a.png)
![3](https://user-images.githubusercontent.com/64668717/82762608-5d2dc980-9dd8-11ea-9426-6212aeec8fef.png)
![4](https://user-images.githubusercontent.com/64668717/82762609-5e5ef680-9dd8-11ea-95f6-25872642c34f.png)
![borda](https://user-images.githubusercontent.com/64668717/82762700-e1804c80-9dd8-11ea-80eb-a3213c7da80a.png)
![5](https://user-images.githubusercontent.com/64668717/82762610-5f902380-9dd8-11ea-9a12-4e2f05d5388b.png)
![6](https://user-images.githubusercontent.com/64668717/82762614-61f27d80-9dd8-11ea-924a-021bbd604b7f.png)
![borda](https://user-images.githubusercontent.com/64668717/82762700-e1804c80-9dd8-11ea-80eb-a3213c7da80a.png)
![7](https://user-images.githubusercontent.com/64668717/82762648-96fed000-9dd8-11ea-8930-42a2235c5f1c.png)
![borda](https://user-images.githubusercontent.com/64668717/82762700-e1804c80-9dd8-11ea-80eb-a3213c7da80a.png)
![8](https://user-images.githubusercontent.com/64668717/82762649-98c89380-9dd8-11ea-9de0-971afdb8c95e.png)


<h1> Projeto </h1>
  <p>
    Foi desenvolvido um programa desktop de chat multi-usuário , usando socket. O programa foi elaborado de acordo com as seguintes regras:
  </p>
  <ul>
    <li>
      	O usuário, ao abrir o servidor, deve configurar a porta para o serviço;
    </li>
    <li>
      	O usuário, ao abrir o cliente, deve configurar o IP e a porta para a conexão com o servidor, em seguida deve configurar sua identificação;
    </li>
    <li>
       No cliente, depois de estabelecer a conexão com o servidor e se identificar, o usuário deve escolher uma sala criada por outro usuário ou criar sua própria sala;
    </li>
    <li>
      No cliente, depois de escolher ou criar a sala, o usuário deve ter uma lista de usuários online atualizada daquela sala;
    </li>
    <li>
      Sempre que um usuário entrar ou sair da sala, todos os usuários daquela sala devem ser avisados, com uma mensagem apresentando a identificação daquele usuário
    </li>
    <li>
       A sala deve ter uma área de texto onde as mensagens são apresentadas, antecipadas da identificação do usuário que a enviou
    </li>
    <li>
       No cliente, depois de escolher ou criar a sala, o usuário pode enviar uma mensagem para a sala, que deve ser apresentada para todos os usuários daquela sala
    </li>
    <li>
      Para isso, deverá ter um campo de digitação para que o usuário possa entrar com a mensagem, e esse campo deve ser separado da área de texto das mensagens da sala
    </li>
  </ul>
   <p>
        Neste projeto foi feito um chat que consiste em uma comunicação entre cliente e
    servidor, por meio de um protocolo de comunicação. O servidor é aberto para
    conexão através de uma porta e possui uma Lista de PrintStream que guarda cada
    cliente que o acessa, e possui mais duas Listas de String uma para armazenar as
    salas e outra para armazenar o nome do cliente e as mensagens do chat. Toda vez
    que um cliente estabelece a conexão é disparado uma thread que faz a
    comunicação, enviando uma mensagem com todos os dados do chat, e toda vez
    que uma alteração é feita em um cliente é disparado uma thread que envia uma
    mensagem para o servidor e o mesmo retorna a mensagem para os demais clientes
    da aplicação para fazer as devidas alterações.
   </p>
   <h1>Tecnologia Usada</h1>
   <p>Java utilizando a Biblioteca Swing, foi escrito na IDE NetBeans</p>
   <h1>Clone</h1>
   <p>
    O projeto possui duas pastas, a pasta Server é o projeto Servidor e a pasta Client é o Client ambas são um projeto NetBeans. Para executar é só ir na aba File >> Open Project.
   </p>
