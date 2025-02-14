package Views;

import Controllers.AlumnoListadoController;
import Application.ApplicationDesktop;
import Entities.Alumno;
import Models.ObjetoListadoModel;
import java.util.Observer;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public final class AlumnoListadoView extends JInternalFrame implements Observer {

    private AlumnoListadoController controller;
    private ObjetoListadoModel<Alumno, String> model;

    public void setController(AlumnoListadoController controller) {
        this.controller = controller;
    }

    public void setModel(ObjetoListadoModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public ObjetoListadoModel<Alumno, String> getModel() {
        return model;
    }

    @Override
    public void update(java.util.Observable updatedModel, Object parametros) {
        cedulaFld.setText(model.getFilter().getCedula_alumno());
        if (model.getErrores().get("nombreFld") != null) {
            codigo_carreraLbl.setBorder(ApplicationDesktop.BORDER_ERROR);
            codigo_carreraLbl.setToolTipText(model.getErrores().get("nombreFld"));
        } else {
            codigo_carreraLbl.setBorder(null);
            codigo_carreraLbl.setToolTipText("");
        }
        instrumentoTbl.setModel(model.getTableModel());
        instrumentoTbl.getColumn("Cedula Alumno").setPreferredWidth(100);
        instrumentoTbl.getColumn("Nombre").setPreferredWidth(100);
        instrumentoTbl.getColumn("Telefono").setPreferredWidth(100);
        instrumentoTbl.getColumn("Email").setPreferredWidth(100);
        instrumentoTbl.getColumn("Fecha Nacimiento").setPreferredWidth(100);
        instrumentoTbl.getColumn("Carrera").setPreferredWidth(100);
        this.revalidate();
        if (!model.getMensaje().equals("")) {
            JOptionPane.showMessageDialog(this, model.getMensaje(), "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public AlumnoListadoView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        codigo_carreraLbl = new javax.swing.JLabel();
        cedulaFld = new javax.swing.JTextField();
        buscarFld = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        instrumentoTbl = new javax.swing.JTable();
        agregarFld = new javax.swing.JButton();
        borrarFld = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setResizable(true);
        setTitle("Informacion Alumnos");

        codigo_carreraLbl.setText("Cédula Alumno:");

        cedulaFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaFldActionPerformed(evt);
            }
        });

        buscarFld.setBackground(new java.awt.Color(2, 117, 216));
        buscarFld.setForeground(new java.awt.Color(255, 255, 255));
        buscarFld.setText("Buscar");
        buscarFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarFldActionPerformed(evt);
            }
        });

        instrumentoTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        instrumentoTbl.setRowHeight(25);
        instrumentoTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        instrumentoTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                instrumentoTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(instrumentoTbl);

        agregarFld.setBackground(new java.awt.Color(92, 184, 92));
        agregarFld.setForeground(new java.awt.Color(255, 255, 255));
        agregarFld.setText("Agregar");
        agregarFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarFldActionPerformed(evt);
            }
        });

        borrarFld.setBackground(new java.awt.Color(217, 83, 79));
        borrarFld.setForeground(new java.awt.Color(255, 255, 255));
        borrarFld.setText("Borrar");
        borrarFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarFldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(codigo_carreraLbl)
                        .addGap(18, 18, 18)
                        .addComponent(cedulaFld)
                        .addGap(18, 18, 18)
                        .addComponent(buscarFld, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(agregarFld)
                .addGap(18, 18, 18)
                .addComponent(borrarFld, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(267, 267, 267))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo_carreraLbl)
                    .addComponent(cedulaFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarFld, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarFld)
                    .addComponent(borrarFld))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarFldActionPerformed
        controller.buscar();
    }//GEN-LAST:event_buscarFldActionPerformed
    private void instrumentoTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instrumentoTblMouseClicked
        if (evt.getClickCount() == 2) {
            int row = this.instrumentoTbl.getSelectedRow();
            ApplicationDesktop.ALUMNO_VIEW.setLocation(evt.getLocationOnScreen());
            controller.editar(row);
        }
    }//GEN-LAST:event_instrumentoTblMouseClicked
    private void agregarFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarFldActionPerformed
        ApplicationDesktop.ALUMNO_VIEW.setLocation(this.agregarFld.getLocationOnScreen());
        controller.agregar();
    }//GEN-LAST:event_agregarFldActionPerformed
    private void borrarFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarFldActionPerformed
        int row = this.instrumentoTbl.getSelectedRow();
        if (row != -1) {
            int resp = JOptionPane.showConfirmDialog(this, "Desea borrar?");
            if (resp == JOptionPane.YES_OPTION) {
                controller.borrar(row);
            }
        }
    }//GEN-LAST:event_borrarFldActionPerformed
    private void cedulaFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaFldActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarFld;
    private javax.swing.JButton borrarFld;
    private javax.swing.JButton buscarFld;
    public javax.swing.JTextField cedulaFld;
    private javax.swing.JLabel codigo_carreraLbl;
    private javax.swing.JTable instrumentoTbl;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
