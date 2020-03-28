package Views;

import Application.ApplicationDesktop;
import Controllers.InicioSesionController;
import Entities.Usuario;
import Models.ObjetoModel;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author wizard
 */
public final class InicioSesionView extends JFrame implements Observer {

    private InicioSesionController controller;
    private ObjetoModel<Usuario, String> model;

    public InicioSesionView() {
        super();
        initComponents();
    }

    public void setController(InicioSesionController controller) {
        this.controller = controller;
    }

    public void setModel(ObjetoModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public ObjetoModel<Usuario, String> getModel() {
        return model;
    }

    @Override
    public void update(Observable o, Object arg) {
        Usuario usuarioCurrent = model.getCurrent();
        cedulaTxtFld.setText(usuarioCurrent.getCedula());
        if (model.getErrores().get("Cedula") != null) {
            cedulaLbl.setBorder(ApplicationDesktop.BORDER_ERROR);
            cedulaLbl.setToolTipText(model.getErrores().get("Cedula"));
        } else {
            cedulaLbl.setBorder(null);
            cedulaLbl.setToolTipText("");
        }
        clavetxtFld.setText(usuarioCurrent.getClave());
        if (model.getErrores().get("Clave") != null) {
            claveLbl.setBorder(ApplicationDesktop.BORDER_ERROR);
            claveLbl.setToolTipText(model.getErrores().get("Clave"));
        } else {
            claveLbl.setBorder(null);
            claveLbl.setToolTipText("");
        }
        this.validate();
        if (!model.getMensaje().equals("")) {
            JOptionPane.showMessageDialog(this, model.getMensaje(), "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cedulaTxtFld = new javax.swing.JTextField();
        AccederBtn = new javax.swing.JButton();
        cedulaLbl = new javax.swing.JLabel();
        claveLbl = new javax.swing.JLabel();
        clavetxtFld = new javax.swing.JPasswordField();
        cerrarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de Sesion");

        cedulaTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaTxtFldActionPerformed(evt);
            }
        });

        AccederBtn.setBackground(new java.awt.Color(92, 184, 92));
        AccederBtn.setForeground(new java.awt.Color(255, 255, 255));
        AccederBtn.setText("Ingresar");
        AccederBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccederBtnActionPerformed(evt);
            }
        });

        cedulaLbl.setText("Cedula");

        claveLbl.setText("Clave");

        clavetxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clavetxtFldActionPerformed(evt);
            }
        });

        cerrarBtn.setBackground(new java.awt.Color(217, 83, 79));
        cerrarBtn.setForeground(new java.awt.Color(255, 255, 255));
        cerrarBtn.setText("Cerrar");
        cerrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(clavetxtFld, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(cedulaTxtFld, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(claveLbl)
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cedulaLbl)
                        .addGap(66, 66, 66))
                    .addComponent(AccederBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cerrarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(cedulaLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cedulaTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(claveLbl)
                .addGap(4, 4, 4)
                .addComponent(clavetxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(AccederBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cerrarBtn)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cedulaTxtFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaTxtFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaTxtFldActionPerformed
    private void AccederBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccederBtnActionPerformed
        if (controller.iniciarSesion()) {
            if (!model.getMensaje().equals("")) {
                JOptionPane.showMessageDialog(this, model.getMensaje(), "", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_AccederBtnActionPerformed
    private void clavetxtFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clavetxtFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clavetxtFldActionPerformed
    private void cerrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarBtnActionPerformed
        controller.exit();
    }//GEN-LAST:event_cerrarBtnActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AccederBtn;
    private javax.swing.JLabel cedulaLbl;
    public javax.swing.JTextField cedulaTxtFld;
    private javax.swing.JButton cerrarBtn;
    private javax.swing.JLabel claveLbl;
    public javax.swing.JPasswordField clavetxtFld;
    // End of variables declaration//GEN-END:variables

}
