
import java.util.Scanner;
import java.io.InputStream;
import javax.swing.JOptionPane;

public class SentProtocol implements Runnable {

  private final Scanner scan;

  public SentProtocol(InputStream i) {
    scan = new Scanner(i);
  }

  @Override
  public void run() {
    while (scan.hasNextLine()) {
      String auxString = scan.nextLine();
      Protocol p = new Protocol(auxString);
      if (Server.processProtocol(p)) {
        Server.distributeProtocol(Server.writeProtocol(p));
      } else {
        JOptionPane.showMessageDialog(
          null,
          "Erro ao Processar o protocolo" + p.getData(),
          "Error at SentProtocol Thread",
          JOptionPane.ERROR_MESSAGE
        );
      }
    }
  }
}
