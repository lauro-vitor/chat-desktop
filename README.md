# chat-desktop
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
