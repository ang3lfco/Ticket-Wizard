/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import interfaces.IBoletoService;
import interfaces.IReventaService;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import models.Boleto;
import models.Evento;
import models.Reventa;
import services.BoletoService;
import services.ReventaService;

/**
 *
 * @author martinez
 */
public class frmReventa extends javax.swing.JFrame {
    private IBoletoService boletoService;
    private IReventaService reventaService;
    private String idUsuario;
    private int idBoleto;
    private int idVendedor;
    /**
     * Creates new form frmCompra
     */
    public frmReventa(int idBoleto, int idVendedor, String idUsuario) throws SQLException {
        this.boletoService = new BoletoService();
        this.idUsuario = idUsuario;
        this.idBoleto = idBoleto;
        this.idVendedor = idVendedor;
        this.reventaService = new ReventaService();
        initComponents();
        setLocationRelativeTo(null);
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
        lblCerrar1 = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        btnComprar = new javax.swing.JButton();
        btnDetalles = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        lblCerrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar.png"))); // NOI18N
        lblCerrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrar1MouseClicked(evt);
            }
        });

        lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimizar.png"))); // NOI18N

        btnComprar.setBackground(new java.awt.Color(0, 102, 83));
        btnComprar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnComprar.setForeground(new java.awt.Color(255, 255, 255));
        btnComprar.setText("Comprar");
        btnComprar.setBorder(null);
        btnComprar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnComprarMouseClicked(evt);
            }
        });
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        btnDetalles.setBackground(new java.awt.Color(0, 102, 83));
        btnDetalles.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDetalles.setForeground(new java.awt.Color(255, 255, 255));
        btnDetalles.setText("Ver detalles");
        btnDetalles.setBorder(null);
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMinimizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCerrar1))
                    .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCerrar1)
                    .addComponent(lblMinimizar))
                .addGap(66, 66, 66)
                .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCerrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrar1MouseClicked
        try {
            frmMenu menu = new frmMenu(idUsuario);
            menu.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(frmReventa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblCerrar1MouseClicked

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        try {
            // TODO add your handling code here:
            Boleto boleto = boletoService.getBoletoPorId(idBoleto);
            if (boleto != null) {
                boletoService.comprarBoleto(boleto.getnSerie(), Integer.parseInt(idUsuario), idVendedor, (boleto.getPrecioActual() + 100.00), (boleto.getPrecioActual() * 0.03));
                JOptionPane.showMessageDialog(this, "Boleto seleccionado: " + boleto.getId() + " - " + boleto.getFila() + ", Asiento: " + boleto.getAsiento() + " - $" + boleto.getPrecioActual());
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro el boleto seleccionado.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmReventa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetallesActionPerformed

    private void btnComprarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprarMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnComprarMouseClicked

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
    private javax.swing.JButton btnDetalles;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCerrar1;
    private javax.swing.JLabel lblMinimizar;
    // End of variables declaration//GEN-END:variables
}
