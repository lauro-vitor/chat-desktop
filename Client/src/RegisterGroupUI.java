
import java.io.IOException;
import java.net.Socket;
import java.io.PrintStream;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class RegisterGroupUI extends javax.swing.JFrame {

  private final String ip;
  private final String identification;
  private final int port;
  private Socket client;
  private PrintStream output;
  private Scanner scan;
  private final String ADD_GROUP = "ADD_GROUP";
  private final DefaultListModel<String> dlm = new DefaultListModel<>();

  public RegisterGroupUI(String ip, String identification, int port) {
    super("Sala");
    this.ip = ip;
    this.identification = identification;
    this.port = port;
    initComponents();
    runConnect();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    buttonAddGroup = new javax.swing.JButton();
    buttonConnectGroup = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    listGroup = new javax.swing.JList<>(dlm);

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel1.setText("Salas");

    buttonAddGroup.setText("Adicionar");
    buttonAddGroup.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonAddGroupActionPerformed(evt);
      }
    });

    buttonConnectGroup.setText("Entrar");
    buttonConnectGroup.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonConnectGroupActionPerformed(evt);
      }
    });

    listGroup.setToolTipText("");
    jScrollPane1.setViewportView(listGroup);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jScrollPane1)
          .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(buttonConnectGroup))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
            .addComponent(buttonAddGroup)))
        .addGap(20, 20, 20))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(buttonAddGroup)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(buttonConnectGroup)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void buttonAddGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddGroupActionPerformed

    boolean stop = false;
    String input;
    while (!stop) {
      input = JOptionPane.showInputDialog(this, "Insira o nome da sala");
      if (input == null) {
        stop = true;
      } else if (!input.isEmpty() && !dlm.contains(input)) {
        dlm.addElement(input);
        output.println("FROM:Register;TO:Server;ACTION:ADD_GROUP;DATA:" + input);
        stop = true;
      } else {
        String alertMsg;
        if (input.isEmpty()) {
          alertMsg = "Vazio";
        } else {
          alertMsg = "Já existe um grupo com esse nome";
        }
        JOptionPane.showMessageDialog(this, alertMsg, "Error", JOptionPane.ERROR_MESSAGE);
      }
    }

  }//GEN-LAST:event_buttonAddGroupActionPerformed

  private void buttonConnectGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConnectGroupActionPerformed

    if (listGroup.getSelectedValue() != null) {
      new Thread(
        new Runnable() {
        @Override
        public void run() {
          output.println(
            "FROM:Register;TO:Server;ACTION:ADD_CHAT;DATA:"
            + "USER=" + identification + "=" + listGroup.getSelectedValue()
          );
          dispose();
          new ChatUI(
            ip,
            port,
            identification,
            listGroup.getSelectedValue()
          ).setVisible(true);
        }
      }
      ).start();
    } else {
      JOptionPane.showMessageDialog(
        this,
        "Insira uma Sala",
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
    }
  }//GEN-LAST:event_buttonConnectGroupActionPerformed
  private void runConnect() {
    new Thread(
      new Runnable() {
      @Override
      public void run() {
        try {
          client = new Socket(ip, port);
          output = new PrintStream(client.getOutputStream());
          scan = new Scanner(client.getInputStream());
          new Thread(
            new Runnable() {
            @Override
            public void run() {
              while (scan.hasNextLine()) {
                String msg = scan.nextLine();
                if (!msg.isEmpty()) {
                  ProtocolClient pc = new ProtocolClient(msg, "GROUP");
                  if (!processProtocolClient(pc)) {
                    JOptionPane.showMessageDialog(
                      RegisterGroupUI.this,
                      "Error em receber Protocolo" + msg,
                      "Error",
                      JOptionPane.ERROR_MESSAGE
                    );
                  }
                }
              }
            }
          }
          ).start();
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(
            RegisterGroupUI.this,
            "Porta Inexistente " + ex.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE
          );
          System.exit(0);
        }
      }
    }
    ).start();
  }

  private boolean processProtocolClient(ProtocolClient p) {
    switch (p.getAction()) {
      case ADD_GROUP: {
        if (p.getArrayData() != null) {
          for (String arrayData : p.getArrayData()) {
            if (!dlm.contains(arrayData)) {
              dlm.addElement(arrayData);
            }
          }
        } else {
          if (!dlm.contains(p.getData())) {
            dlm.addElement(p.getData());
          }
        }
        return true;
      }
      default:
        return false;
    }
  }

  public static void main(String args[]) {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(RegisterGroupUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton buttonAddGroup;
  private javax.swing.JButton buttonConnectGroup;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JList<String> listGroup;
  // End of variables declaration//GEN-END:variables
}
