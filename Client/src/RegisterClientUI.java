
import javax.swing.JOptionPane;

public class RegisterClientUI extends javax.swing.JFrame {

  private boolean errorIp = true;
  private boolean errorPort = true;
  private boolean errorIdentification = true;

  public RegisterClientUI() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    textFieldIp = new javax.swing.JTextField();
    textFieldPort = new javax.swing.JTextField();
    textFieldIdentification = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    buttonRegister = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    labelErrorIp = new javax.swing.JLabel();
    labelErrorPort = new javax.swing.JLabel();
    labelErrorIdentification = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    textFieldIp.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        textFieldIpFocusLost(evt);
      }
    });

    textFieldPort.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        textFieldPortFocusLost(evt);
      }
    });

    textFieldIdentification.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        textFieldIdentificationFocusLost(evt);
      }
    });

    jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Registro do Cliente");

    buttonRegister.setText("Registrar");
    buttonRegister.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonRegisterActionPerformed(evt);
      }
    });

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jLabel2.setText("IP:");

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jLabel3.setText("Porta:");

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jLabel4.setText("Identificação:");

    labelErrorIp.setForeground(new java.awt.Color(255, 0, 0));
    labelErrorIp.setText("");

    labelErrorPort.setForeground(new java.awt.Color(255, 0, 0));
    labelErrorPort.setText("");

    labelErrorIdentification.setForeground(new java.awt.Color(255, 0, 0));
    labelErrorIdentification.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    labelErrorIdentification.setText("");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(textFieldIp)
              .addComponent(jLabel4)
              .addComponent(jLabel2)
              .addComponent(textFieldPort)
              .addComponent(textFieldIdentification)
              .addComponent(labelErrorIdentification))
            .addContainerGap())
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(labelErrorIp)
              .addComponent(labelErrorPort)
              .addComponent(jLabel3))
            .addGap(0, 0, Short.MAX_VALUE))))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(buttonRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
      .addGroup(layout.createSequentialGroup()
        .addGap(140, 140, 140)
        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGap(146, 146, 146))
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelErrorIdentification, labelErrorIp, labelErrorPort});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(textFieldIp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelErrorIp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(textFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelErrorPort)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel4)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(textFieldIdentification, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelErrorIdentification)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(buttonRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(31, Short.MAX_VALUE))
    );

    layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelErrorIdentification, labelErrorIp, labelErrorPort});

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void textFieldIpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldIpFocusLost
    String text = textFieldIp.getText().trim();
    if (text.isEmpty()) {
      labelErrorIp.setText("IP vazio!");
    } else if (text.matches("\\d{9}")
      || !text.matches("\\d{3}.\\d{1}.\\d{1}.\\d{1}")
      && !text.matches("localhost")) {
      labelErrorIp
        .setText("IP inválido!, insira o ip no modelo 127.0.0.1 ou localhost");
    } else {
      labelErrorIp.setText("");
      errorIp = false;
    }
  }//GEN-LAST:event_textFieldIpFocusLost

  private void textFieldPortFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldPortFocusLost

    String text = textFieldPort.getText().trim();
    if (text.isEmpty()) {
      labelErrorPort.setText("Numero da Porta vazio");
    } else if (!text.matches("\\d{0,}")) {
      labelErrorPort.setText("Não é um numero");
    } else {
      labelErrorPort.setText("");
      errorPort = false;
    }

  }//GEN-LAST:event_textFieldPortFocusLost

  private void textFieldIdentificationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldIdentificationFocusLost

    String text = textFieldIdentification.getText().trim();
    if (text.isEmpty()) {
      labelErrorIdentification.setText("Identificção vazia");
    } else {
      labelErrorIdentification.setText("");
      errorIdentification = false;
    }
  }//GEN-LAST:event_textFieldIdentificationFocusLost

  private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterActionPerformed

    if (!errorIp && !errorPort && !errorIdentification) {
      int port = Integer.parseInt(textFieldPort.getText());
      new Thread(
        new Runnable() {
        @Override
        public void run() {
          dispose();
          new RegisterGroupUI(
            textFieldIp.getText(),
            textFieldIdentification.getText(),
            port
          ).setVisible(true);
        }
      }
      ).start();
    } else {
      JOptionPane.showMessageDialog(
        this,
        "Os campos não foram validados",
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
    }
  }//GEN-LAST:event_buttonRegisterActionPerformed

  public static void main(String args[]) {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(RegisterClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(RegisterClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(RegisterClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(RegisterClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new RegisterClientUI().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton buttonRegister;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel labelErrorIdentification;
  private javax.swing.JLabel labelErrorIp;
  private javax.swing.JLabel labelErrorPort;
  private javax.swing.JTextField textFieldIdentification;
  private javax.swing.JTextField textFieldIp;
  private javax.swing.JTextField textFieldPort;
  // End of variables declaration//GEN-END:variables
}
