
import java.io.IOException;
import java.net.Socket;
import javax.swing.DefaultListModel;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ChatUI extends javax.swing.JFrame {

  private Socket client;
  private final String nickName;
  private final String groupName;
  private final String ip;
  private final int port;
  private Scanner scan;
  private PrintStream output;
  private final DefaultListModel<String> dlm = new DefaultListModel<>();
  private final String ADD_CHAT = "ADD_CHAT";
  private final String REMOVE_CHAT = "REMOVE_CHAT";
  private final String USER = "USER";
  private final ArrayList<Integer> id;

  public ChatUI(String ip, int port, String nickName, String groupName) {
    this.ip = ip;
    this.port = port;
    this.nickName = nickName;
    this.groupName = groupName;
    id = new ArrayList<>();
    initComponents();
    runConnect();
  }

  private void runConnect() {
    new Thread(
      new Runnable() {
      @Override
      public void run() {
        try {
          client = new Socket(ip, port);
          scan = new Scanner(client.getInputStream());
          output = new PrintStream(client.getOutputStream());

          new Thread(
            new Runnable() {
            @Override
            public void run() {
              while (scan.hasNextLine()) {
                String msg = scan.nextLine();
                if (!msg.isEmpty()) {
                  ProtocolClient pc = new ProtocolClient(msg, "CHAT");
                  if (!processProtocolClient(pc)) {
                    JOptionPane.showMessageDialog(
                      ChatUI.this,
                      "Error em receber Protocolo" + msg,
                      "Error",
                      JOptionPane.ERROR_MESSAGE
                    );
                  }
                }
              }
            }
          }).start();

        } catch (IOException ex) {
          Logger.getLogger(ChatUI.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
    ).start();
  }

  private String writeProtocol(String action, String data) {
    return "FROM:Client;TO:Server;ACTION:" + action + ";DATA:" + data;
  }

  private boolean processProtocolClient(ProtocolClient p) {
    switch (p.getAction()) {
      case ADD_CHAT: {
        String[] aux;
        if (p.getArrayData() != null) {
          for (String arrayData : p.getArrayData()) {
            aux = arrayData.split("=");
            if (aux[2].equalsIgnoreCase(groupName)) {
              if (aux[0].equalsIgnoreCase(USER)) {
                if (!dlm.contains(aux[1])) {
                  dlm.addElement(aux[1]);
                  textAreaMessage.append(aux[1] + " Entrou \n\n");
                }
              } else {
                if (!id.contains(Integer.parseInt(aux[5]))) {
                  id.add(Integer.parseInt(aux[5]));
                  textAreaMessage.append(aux[1] + ":" + aux[3].trim() + "\n\n");
                }
              }
            }
          }
        } else {
          aux = p.getData().split("=");
          if (aux[0].equalsIgnoreCase(USER)) {
            if (aux[2].equalsIgnoreCase(groupName)) {
              if (!dlm.contains(aux[1])) {
                dlm.addElement(aux[1]);
              }
            }
          }
        }
        return true;
      }
      case REMOVE_CHAT: {
        String[] aux = p.getData().split("=");
        for (int i = 0; i < dlm.size(); i++) {
          if (dlm.get(i).equalsIgnoreCase(aux[1])) {
            textAreaMessage.append(dlm.get(i) + " Saiu \n");
            dlm.remove(i);
            return true;
          }
        }
        return true;
      }
      default:
        return false;
    }
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    textAreaMessage = new javax.swing.JTextArea();
    labelNickName = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    listClients = new javax.swing.JList<>(dlm);
    jScrollPane3 = new javax.swing.JScrollPane();
    textAreaInput = new javax.swing.JTextArea();
    buttonSent = new javax.swing.JButton();
    labelGroupName = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent evt) {
        formWindowClosing(evt);
      }
    });

    textAreaMessage.setEditable(false);
    textAreaMessage.setColumns(20);
    textAreaMessage.setRows(5);
    jScrollPane1.setViewportView(textAreaMessage);

    labelNickName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    labelNickName.setText(nickName);

    jScrollPane2.setViewportView(listClients);

    textAreaInput.setColumns(20);
    textAreaInput.setRows(5);
    jScrollPane3.setViewportView(textAreaInput);

    buttonSent.setText("Enviar");
    buttonSent.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonSentActionPerformed(evt);
      }
    });

    labelGroupName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    labelGroupName.setText(groupName);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(labelNickName)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
            .addComponent(labelGroupName)
            .addGap(16, 16, 16))
          .addComponent(jScrollPane3)
          .addComponent(jScrollPane1))
        .addGap(12, 12, 12)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
          .addComponent(buttonSent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(4, 4, 4)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(labelGroupName)
          .addComponent(labelNickName))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
          .addComponent(buttonSent, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void buttonSentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSentActionPerformed

    if (!textAreaInput.getText().isEmpty()) {
      output.println(
        writeProtocol(
          ADD_CHAT,
          "MESSAGE=" + nickName + "=" + groupName + "=" + textAreaInput.getText().trim()
        )
      );
      textAreaInput.setText("");
    }
  }//GEN-LAST:event_buttonSentActionPerformed

  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    output.println(writeProtocol(REMOVE_CHAT, "USER=" + nickName + "=" + groupName));
    System.exit(0);
  }//GEN-LAST:event_formWindowClosing

  public static void main(String args[]) {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(ChatUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(ChatUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(ChatUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(ChatUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton buttonSent;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JLabel labelGroupName;
  private javax.swing.JLabel labelNickName;
  private javax.swing.JList<String> listClients;
  private javax.swing.JTextArea textAreaInput;
  private javax.swing.JTextArea textAreaMessage;
  // End of variables declaration//GEN-END:variables
}
