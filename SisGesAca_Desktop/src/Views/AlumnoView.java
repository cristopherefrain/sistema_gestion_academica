package Views;

import Controllers.AlumnoController;
import Entities.Alumno;
import Application.ApplicationDesktop;
import Models.ObjetoModel;
import java.util.Observer;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public final class AlumnoView extends JInternalFrame implements Observer {

    private AlumnoController controller;
    private ObjetoModel<Alumno, String> model;

    public AlumnoView() {
        super();
        initComponents();
    }

    public void setController(AlumnoController controller) {
        this.controller = controller;
    }

    public void setModel(ObjetoModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public ObjetoModel<Alumno, String> getModel() {
        return model;
    }

    @Override
    public void update(java.util.Observable updatedModel, Object parametros) {
        Alumno AlumnoCurrent = model.getCurrent();
        this.cedulaFld.setEnabled(model.getModo() == ApplicationDesktop.MODO_AGREGAR);
        cedulaFld.setText(AlumnoCurrent.getCedula_alumno());
        if (model.getErrores().get("Cedula") != null) {
            codigoLbl.setBorder(ApplicationDesktop.BORDER_ERROR);
            codigoLbl.setToolTipText(model.getErrores().get("Cedula"));
        } else {
            codigoLbl.setBorder(null);
            codigoLbl.setToolTipText("");
        }
        nombreFld.setText(AlumnoCurrent.getNombre());
        if (model.getErrores().get("Nombre") != null) {
            nombreLbl.setBorder(ApplicationDesktop.BORDER_ERROR);
            nombreLbl.setToolTipText(model.getErrores().get("Nombre"));
        } else {
            nombreLbl.setBorder(null);
            nombreLbl.setToolTipText("");
        }
        telefonoFld.setText(AlumnoCurrent.getTelefono());
        if (model.getErrores().get("Nombre") != null) {
            nombreLbl.setBorder(ApplicationDesktop.BORDER_ERROR);
            nombreLbl.setToolTipText(model.getErrores().get("Nombre"));
        } else {
            nombreLbl.setBorder(null);
            nombreLbl.setToolTipText("");
        }
        emailFld.setText(AlumnoCurrent.getEmail());
        if (model.getErrores().get("Creditos") != null) {
            tituloLbl.setBorder(ApplicationDesktop.BORDER_ERROR);
            tituloLbl.setToolTipText(model.getErrores().get("Creditos"));
        } else {
            tituloLbl.setBorder(null);
            tituloLbl.setToolTipText("");
        }
        fechaFld.setText(AlumnoCurrent.getFecha_nacimiento());
        if (model.getErrores().get("Horas") != null) {
            tituloLbl.setBorder(ApplicationDesktop.BORDER_ERROR);
            tituloLbl.setToolTipText(model.getErrores().get("Horas"));
        } else {
            tituloLbl.setBorder(null);
            tituloLbl.setToolTipText("");
        }
        carreraFld.setModel(model.getComboBox1());
        this.controller.actualizar();
        carreraFld.setSelectedItem(AlumnoCurrent.getCarrera());
        this.validate();
        if (!model.getMensaje().equals("")) {
            JOptionPane.showMessageDialog(this, model.getMensaje(), "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        codigoLbl = new javax.swing.JLabel();
        cedulaFld = new javax.swing.JTextField();
        nombreLbl = new javax.swing.JLabel();
        tituloLbl = new javax.swing.JLabel();
        guardarBtn = new javax.swing.JButton();
        atrasBtn = new javax.swing.JButton();
        codigoLbl1 = new javax.swing.JLabel();
        telefonoFld = new javax.swing.JTextField();
        nombreLbl1 = new javax.swing.JLabel();
        emailFld = new javax.swing.JTextField();
        tituloLbl1 = new javax.swing.JLabel();
        fechaFld = new javax.swing.JTextField();
        carreraFld = new javax.swing.JComboBox<>();
        nombreFld = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Alumno");

        codigoLbl.setText("Cédula Alumno:");

        cedulaFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaFldActionPerformed(evt);
            }
        });

        nombreLbl.setText("Código Carrera:");

        tituloLbl.setText("Nombre:");

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

        codigoLbl1.setText("Teléfono:");

        telefonoFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoFldActionPerformed(evt);
            }
        });

        nombreLbl1.setText("Email:");

        tituloLbl1.setText("Fecha Nacimiento:");

        nombreFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreFldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloLbl)
                    .addComponent(nombreLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloLbl1)
                    .addComponent(codigoLbl1)
                    .addComponent(nombreLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cedulaFld, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(guardarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(atrasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(emailFld)
                        .addComponent(fechaFld)
                        .addComponent(telefonoFld)
                        .addComponent(carreraFld, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nombreFld, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
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
                    .addComponent(tituloLbl)
                    .addComponent(nombreFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoLbl1)
                    .addComponent(telefonoFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLbl1)
                    .addComponent(emailFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloLbl1)
                    .addComponent(fechaFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carreraFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreLbl))
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
    private void cedulaFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaFldActionPerformed
    private void telefonoFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoFldActionPerformed
    private void nombreFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreFldActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atrasBtn;
    public javax.swing.JComboBox<String> carreraFld;
    public javax.swing.JTextField cedulaFld;
    private javax.swing.JLabel codigoLbl;
    private javax.swing.JLabel codigoLbl1;
    public javax.swing.JTextField emailFld;
    public javax.swing.JTextField fechaFld;
    public javax.swing.JButton guardarBtn;
    public javax.swing.JTextField nombreFld;
    private javax.swing.JLabel nombreLbl;
    private javax.swing.JLabel nombreLbl1;
    public javax.swing.JTextField telefonoFld;
    private javax.swing.JLabel tituloLbl;
    private javax.swing.JLabel tituloLbl1;
    // End of variables declaration//GEN-END:variables
}
