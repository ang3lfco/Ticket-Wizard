/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import interfaces.IBoletoService;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import models.Boleto;
import models.Evento;
import services.BoletoService;

/**
 *
 * @author martinez
 */
public class frmCompra extends javax.swing.JFrame {
    private Evento eventoSeleccionado;
    private IBoletoService boletoService;
    private String idUsuario;
    /**
     * Creates new form frmCompra
     */
    public frmCompra(Evento evento, String idUsuario) throws SQLException {
        this.idUsuario = idUsuario;
        this.eventoSeleccionado = evento;
        this.boletoService = new BoletoService();
        initComponents();
        cargarDatosEvento();
        setLocationRelativeTo(null);
    }
    
    private void cargarDatosEvento() {
        setTitle("Compra de boletos para: " + eventoSeleccionado.getNombre());
        try {
            List<Boleto> boletosDisponibles = boletoService.obtenerBoletosPorEvento(eventoSeleccionado.getId());

            if (boletosDisponibles.isEmpty()) {
                cmbDisponibles.setModel(new DefaultComboBoxModel<>(new String[] { "No hay boletos disponibles" }));
                cmbDisponibles.setEnabled(false);
            } else {
                DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
                for (Boleto boleto : boletosDisponibles) {
                    model.addElement("ID: " + boleto.getId() + ", Fila: " + boleto.getFila() + ", Asiento: " + boleto.getAsiento() + " - $" + boleto.getPrecioActual());
                }
                cmbDisponibles.setModel(model);
                cmbDisponibles.setEnabled(true);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar boletos: " + e.getMessage());
            cmbDisponibles.setModel(new DefaultComboBoxModel<>(new String[] { "Error al cargar boletos" }));
            cmbDisponibles.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmbDisponibles = new javax.swing.JComboBox<>();
        lblCerrar1 = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        btnComprar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        cmbDisponibles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblCerrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar.png"))); // NOI18N
        lblCerrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrar1MouseClicked(evt);
            }
        });

        lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimizar.png"))); // NOI18N

        btnComprar.setBackground(new java.awt.Color(0, 102, 83));
        btnComprar.setForeground(new java.awt.Color(255, 255, 255));
        btnComprar.setText("Comprar");
        btnComprar.setBorder(null);
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMinimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCerrar1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCerrar1)
                    .addComponent(lblMinimizar))
                .addGap(64, 64, 64)
                .addComponent(cmbDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCerrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrar1MouseClicked
        try {
            // TODO add your handling code here:
            frmMenu menu = new frmMenu(idUsuario);
            menu.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(frmCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblCerrar1MouseClicked

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        // TODO add your handling code here:
        try {
            String selectedItem = (String) cmbDisponibles.getSelectedItem();
            if (selectedItem == null || selectedItem.contains("No hay boletos disponibles")) {
                JOptionPane.showMessageDialog(this, "Por favor seleccione un boleto valido.");
                return;
            }
            // Extraer ID del boleto seleccionado del texto del ComboBox
            String[] parts = selectedItem.split(","); // Divide la cadena en partes usando la coma como delimitador
            String idPart = parts[0]; // Obten la primera parte "ID: X"
            String[] idParts = idPart.split(":"); // Divide la primera parte usando ":" como delimitador
            int boletoId = Integer.parseInt(idParts[1].trim()); // Obten el ID y elimina espacios en blanco
            Boleto boleto = boletoService.getBoletoPorId(boletoId);
            
            if (boleto != null) {
                boletoService.comprarBoleto(boleto.getnSerie(), Integer.parseInt(idUsuario), 11, boleto.getPrecioActual(), (boleto.getPrecioActual() * 0.03));
                JOptionPane.showMessageDialog(this, "Boleto seleccionado: " + boleto.getId() + " - " + boleto.getFila() + ", Asiento: " + boleto.getAsiento() + " - $" + boleto.getPrecioActual());
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro el boleto seleccionado.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmCompra.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al procesar la compra: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnComprarActionPerformed

//    /**
//     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(frmCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmCompra().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprar;
    private javax.swing.JComboBox<String> cmbDisponibles;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCerrar1;
    private javax.swing.JLabel lblMinimizar;
    // End of variables declaration//GEN-END:variables
}
