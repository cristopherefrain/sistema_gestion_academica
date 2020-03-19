package Views;


import Controllers.ProfesorController;
import Entities.Profesor;
import Models.ProfesorModel;
import Application.ApplicationDesktop;
import javax.swing.*;
import java.util.Observer;

public class ProfesorView extends JInternalFrame implements Observer {

    public ProfesorView() {
        super();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        codigoLbl = new javax.swing.JLabel();
        cedulaFld = new javax.swing.JTextField();
        nombreLbl = new javax.swing.JLabel();
        nombreFld = new javax.swing.JTextField();
        tituloLbl = new javax.swing.JLabel();
        telefonoFld = new javax.swing.JTextField();
        guardarBtn = new javax.swing.JButton();
        atrasBtn = new javax.swing.JButton();
        tituloLbl1 = new javax.swing.JLabel();
        emailFld = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Profesor");
        setPreferredSize(new java.awt.Dimension(395, 220));

        codigoLbl.setText("Cédula Profesor:");

        cedulaFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaFldActionPerformed(evt);
            }
        });

        nombreLbl.setText("Nombre:");

        tituloLbl.setText("Teléfono:");

        guardarBtn.setBackground(new java.awt.Color(92, 184, 92));
        guardarBtn.setForeground(new java.awt.Color(255, 255, 255));
        guardarBtn.setText("Guardar");
        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBtnActionPerformed(evt);
            }
        });

        atrasBtn.setBackground(new java.awt.Color(217, 83, 79));
        atrasBtn.setForeground(new java.awt.Color(255, 255, 255));
        atrasBtn.setText("Atras");
        atrasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBtnActionPerformed(evt);
            }
        });

        tituloLbl1.setText("Email:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloLbl1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tituloLbl)
                            .addComponent(codigoLbl))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cedulaFld, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(guardarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(atrasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nombreFld)
                            .addComponent(telefonoFld)
                            .addComponent(emailFld, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoLbl)
                    .addComponent(cedulaFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLbl)
                    .addComponent(nombreFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloLbl)
                    .addComponent(telefonoFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloLbl1)
                    .addComponent(emailFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarBtn)
                    .addComponent(atrasBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_atrasBtnActionPerformed

    private void guardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBtnActionPerformed
        this.controller.guardar();
        this.setVisible(false);
    }//GEN-LAST:event_guardarBtnActionPerformed

    private void cedulaFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaFldActionPerformed

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ProfesorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ProfesorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ProfesorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ProfesorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atrasBtn;
    public javax.swing.JTextField cedulaFld;
    private javax.swing.JLabel codigoLbl;
    public javax.swing.JTextField emailFld;
    public javax.swing.JButton guardarBtn;
    public javax.swing.JTextField nombreFld;
    private javax.swing.JLabel nombreLbl;
    public javax.swing.JTextField telefonoFld;
    private javax.swing.JLabel tituloLbl;
    private javax.swing.JLabel tituloLbl1;
    // End of variables declaration//GEN-END:variables

    ProfesorController controller;
    ProfesorModel model;

    public void setController(ProfesorController controller) {
        this.controller = controller;
    }

    public void setModel(ProfesorModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public ProfesorModel getModel() {
        return model;
    }

    @Override
    public void update(java.util.Observable updatedModel, Object parametros) {

        Profesor CarreraCurrent = model.getCurrent();

        this.cedulaFld.setEnabled(model.getModo() == ApplicationDesktop.MODO_AGREGAR);

        cedulaFld.setText(CarreraCurrent.getCedula_profesor());
        if (model.getErrores().get("Cedula") != null) {
            codigoLbl.setBorder(ApplicationDesktop.BORDER_ERROR);
            codigoLbl.setToolTipText(model.getErrores().get("Cedula"));
        } else {
            codigoLbl.setBorder(null);
            codigoLbl.setToolTipText("");
        }

        nombreFld.setText(CarreraCurrent.getNombre());
        if (model.getErrores().get("Nombre") != null) {
            nombreLbl.setBorder(ApplicationDesktop.BORDER_ERROR);
            nombreLbl.setToolTipText(model.getErrores().get("Nombre"));
        } else {
            nombreLbl.setBorder(null);
            nombreLbl.setToolTipText("");
        }

        telefonoFld.setText(CarreraCurrent.getTelefono());
        if (model.getErrores().get("Telefono") != null) {
            tituloLbl.setBorder(ApplicationDesktop.BORDER_ERROR);
            tituloLbl.setToolTipText(model.getErrores().get("Telefono"));
        } else {
            tituloLbl.setBorder(null);
            tituloLbl.setToolTipText("");
        }
        
        emailFld.setText(CarreraCurrent.getEmail());
        if (model.getErrores().get("Email") != null) {
            tituloLbl.setBorder(ApplicationDesktop.BORDER_ERROR);
            tituloLbl.setToolTipText(model.getErrores().get("Email"));
        } else {
            tituloLbl.setBorder(null);
            tituloLbl.setToolTipText("");
        }

        this.validate();
        
        if (!model.getMensaje().equals("")) {
            JOptionPane.showMessageDialog(this, model.getMensaje(), "", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}