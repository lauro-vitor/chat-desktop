
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.PrintStream;
import java.util.ArrayList;

public class Server {

  public static JTextArea textArea;
  private static JFrame frame;
  private static ServerSocket server;
  private static Socket client;
  private static ArrayList<PrintStream> clients;
  private static ArrayList<String> groups;
  private static ArrayList<String> chat;
  private static String updateGroup = "";
  private static String updateChat = "";
  private static final String ADD_CHAT = "ADD_CHAT";
  private static final String REMOVE_CHAT = "REMOVE_CHAT";
  private static final String ADD_GROUP = "ADD_GROUP";
  private static int id = 0;

  public static void main(String[] args) {

    int port = setPort();
    initComponents();
    connectServerSocket(port);
  }

  private static void connectServerSocket(int port) {
    try {
      server = new ServerSocket(port);
      textArea.append("porta:" + port + "\n");
      while (true) {
        textArea.append("Esperando conexão ...\n");
        client = server.accept();
        clients.add(new PrintStream(client.getOutputStream()));
        textArea.append("conexão aceita\n");
        PrintStream output = new PrintStream(client.getOutputStream());
        new Thread(
          new Runnable() {
          @Override
          public void run() {
            distributeProtocol(updateGroup + updateChat);
          }
        }
        ).start();
        SentProtocol sp = new SentProtocol(client.getInputStream());
        new Thread(sp).start();
      }
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(
        frame,
        ex.getMessage(), "Error connectServerSocket",
        JOptionPane.ERROR_MESSAGE);
    }
  }

  public static boolean processProtocol(Protocol p) {
    if (p.getAction() != null) {
      switch (p.getAction()) {
        case ADD_GROUP:
          groups.add(p.getData());
          return true;
        case ADD_CHAT: {
          chat.add(p.getData() + "=id=" + id);
          id++;
          return true;
        }
        case REMOVE_CHAT: {
          boolean find = false;
          String e = "";
          for (int i = 0; i < chat.size() && !find; i++) {
            if (chat.get(i).contains(p.getData())) {
              e = chat.get(i);
              find = true;
            }
          }
          if (!e.isEmpty()) {
            chat.remove(e);
            return true;
          }
          return false;
        }
        default:
          return false;
      }
    }
    return false;
  }

  public static String writeProtocol(Protocol p) {
    switch (p.getAction()) {
      case ADD_GROUP: {
        updateGroup = "";
        updateGroup += "FROM:Server;";
        updateGroup += "TO:Client;";
        updateGroup += "ACTION:ADD_GROUP;";
        updateGroup += "DATA:";
        for (int i = 0; i < groups.size(); i++) {
          updateGroup += groups.get(i) + "§§";
        }
        updateGroup += ";}";
        return updateGroup + updateChat;
      }
      case ADD_CHAT: {
        updateChat = "";
        updateChat += "FROM:Server;";
        updateChat += "TO:Client;";
        updateChat += "ACTION:ADD_CHAT;";
        updateChat += "DATA:";
        for (int i = 0; i < chat.size(); i++) {
          updateChat += chat.get(i) + "§§";
        }
        updateChat += ";}";
        return updateGroup + updateChat;
      }
      case REMOVE_CHAT: {
        updateChat = "";
        updateChat += "FROM:Server;";
        updateChat += "TO:Client;";
        updateChat += "ACTION:REMOVE_CHAT;";
        updateChat += "DATA:" + p.getData() + ";}";
        return updateGroup + updateChat;
      }
      default:
        return "";
    }
  }

  public static void distributeProtocol(String message) {
    clients.forEach((c) -> {
      c.println(message);
    });
  }

  private static void initComponents() {
    clients = new ArrayList<>();
    groups = new ArrayList<>();
    chat = new ArrayList<>();
    frame = new JFrame("Servidor");
    textArea = new JTextArea();
    textArea.setEditable(false);
    frame.add(new JScrollPane(textArea));
    frame.setSize(400, 500);
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    frame.setVisible(true);
  }

  private static int setPort() {
    String portText = null;
    while (portText == null
      || portText.isEmpty()
      || !validityPortNumber(portText)) {
      portText = JOptionPane.showInputDialog(null, "Insira o número da porta");
    }
    return Integer.parseInt(portText);
  }

  private static boolean validityPortNumber(String portText) {
    if (portText.matches("\\d{0,}")) {
      return true;
    } else {
      JOptionPane
        .showMessageDialog(
          null,
          "insira numeros",
          "Error",
          JOptionPane.ERROR_MESSAGE
        );
      return false;
    }
  }
}
