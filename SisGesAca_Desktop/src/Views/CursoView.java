package Views;

import Controllers.CursoController;
import Entities.Curso;
import Application.ApplicationDesktop;
import Models.ObjetoModel;
import java.util.Observer;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public final class CursoView extends JInternalFrame implements Observer {

    private CursoController controller;
    private ObjetoModel<Curso, String> model;

    public CursoView() {
        super();
        initComponents();
    }

    public void setController(CursoController controller) {
        this.controller = controller;
    }

    public void setModel(ObjetoModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public ObjetoModel<Curso, String> getModel() {
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
        carreraFld.setModel(model.getComboBox1());
        cicloFld.setModel(model.getComboBox2());
        this.controller.actualizar();
        carreraFld.setSelectedItem(CursoCurrent.getCodigo_carrera());
        cicloFld.setSelectedItem(CursoCurrent.getNo_ciclo());
        this.validate();
        if (!model.getMensaje().equals("")) {
            JOptionPane.showMessageDialog(this, model.getMensaje(), "", JOptionPane.INFORMATION_MESSAGE);
        }
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
}
