package Views;


import Controllers.CursoController;
import Entities.Curso;
import Models.CursoModel;
import Application.ApplicationDesktop;
import javax.swing.*;
import java.util.Observer;

public class CursoView extends JInternalFrame implements Observer {

    public CursoView() {
        super();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        codigoLbl = new javax.swing.JLabel();
        cursoFld = new javax.swing.JTextField();
        nombreLbl = new javax.swing.JLabel();
        tituloLbl = new javax.swing.JLabel();
        guardarBtn = new javax.swing.JButton();
        atrasBtn = new javax.swing.JButton();
        codigoLbl1 = new javax.swing.JLabel();
        nombreFld = new javax.swing.JTextField();
        nombreLbl1 = new javax.swing.JLabel();
        creditosFld = new javax.swing.JTextField();
        tituloLbl1 = new javax.swing.JLabel();
        horasFld = new javax.swing.JTextField();
        carreraFld = new javax.swing.JComboBox<>();
        cicloFld = new javax.swing.JComboBox<>();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Curso");

        codigoLbl.setText("Código Curso:");

        cursoFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursoFldActionPerformed(evt);
            }
        });

        nombreLbl.setText("Código Carrera:");

        tituloLbl.setText("Número Ciclo:");

        guardarBtn.setText("Guardar");
        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBtnActionPerformed(evt);
            }
        });

        atrasBtn.setText("Atras");
        atrasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBtnActionPerformed(evt);
            }
        });

        codigoLbl1.setText("Nombre:");

        nombreFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreFldActionPerformed(evt);
            }
        });

        nombreLbl1.setText("Creditos:");

        tituloLbl1.setText("Horas Semanales:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tituloLbl1)
                            .addComponent(codigoLbl1))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(guardarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(atrasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nombreFld, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(creditosFld, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(horasFld, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tituloLbl)
                                    .addComponent(codigoLbl))
                                .addGap(36, 36, 36))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nombreLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cursoFld)
                            .addComponent(carreraFld, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cicloFld, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoLbl)
                    .addComponent(cursoFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLbl)
                    .addComponent(carreraFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloLbl)
                    .addComponent(cicloFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoLbl1)
                    .addComponent(nombreFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLbl1)
                    .addComponent(creditosFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloLbl1)
                    .addComponent(horasFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarBtn)
                    .addComponent(atrasBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void cursoFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cursoFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cursoFldActionPerformed

    private void nombreFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreFldActionPerformed

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
//            java.util.logging.Logger.getLogger(CursoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CursoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CursoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CursoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    public javax.swing.JComboBox<String> carreraFld;
    public javax.swing.JComboBox<String> cicloFld;
    private javax.swing.JLabel codigoLbl;
    private javax.swing.JLabel codigoLbl1;
    public javax.swing.JTextField creditosFld;
    public javax.swing.JTextField cursoFld;
    public javax.swing.JButton guardarBtn;
    public javax.swing.JTextField horasFld;
    public javax.swing.JTextField nombreFld;
    private javax.swing.JLabel nombreLbl;
    private javax.swing.JLabel nombreLbl1;
    private javax.swing.JLabel tituloLbl;
    private javax.swing.JLabel tituloLbl1;
    // End of variables declaration//GEN-END:variables

    CursoController controller;
    CursoModel model;

    public void setController(CursoController controller) {
        this.controller = controller;
    }

    public void setModel(CursoModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public CursoModel getModel() {
        return model;
    }

    @Override
    public void update(java.util.Observable updatedModel, Object parametros) {

        Curso CursoCurrent = model.getCurrent();

        this.cursoFld.setEnabled(model.getModo() == ApplicationDesktop.MODO_AGREGAR);

        cursoFld.setText(CursoCurrent.getCodigo_curso());
        if (model.getErrores().get("Curso") != null) {
            codigoLbl.setBorder(ApplicationDesktop.BORDER_ERROR);
            codigoLbl.setToolTipText(model.getErrores().get("Curso"));
        } else {
            codigoLbl.setBorder(null);
            codigoLbl.setToolTipText("");
        }

        nombreFld.setText(CursoCurrent.getNombre());
        if (model.getErrores().get("Nombre") != null) {
            nombreLbl.setBorder(ApplicationDesktop.BORDER_ERROR);
            nombreLbl.setToolTipText(model.getErrores().get("Nombre"));
        } else {
            nombreLbl.setBorder(null);
            nombreLbl.setToolTipText("");
        }

        creditosFld.setText(CursoCurrent.getCreditos());
        if (model.getErrores().get("Creditos") != null) {
            tituloLbl.setBorder(ApplicationDesktop.BORDER_ERROR);
            tituloLbl.setToolTipText(model.getErrores().get("Creditos"));
        } else {
            tituloLbl.setBorder(null);
            tituloLbl.setToolTipText("");
        }
        
        horasFld.setText(CursoCurrent.getHoras_semanales());
        if (model.getErrores().get("Horas") != null) {
            tituloLbl.setBorder(ApplicationDesktop.BORDER_ERROR);
            tituloLbl.setToolTipText(model.getErrores().get("Horas"));
        } else {
            tituloLbl.setBorder(null);
            tituloLbl.setToolTipText("");
        }

        carreraFld.setModel(model.getCarrera());
        
        cicloFld.setModel(model.getCiclo());
        
        this.controller.actualizar();
        
        carreraFld.setSelectedItem(CursoCurrent.getCodigo_carrera());
        
        cicloFld.setSelectedItem(CursoCurrent.getNo_ciclo());
        
        this.validate();
        
        if (!model.getMensaje().equals("")) {
            JOptionPane.showMessageDialog(this, model.getMensaje(), "", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}