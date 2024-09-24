/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Boleto;
import models.Evento;
import models.Transaccion;
import services.BoletoService;
import services.EventoService;
import services.TransaccionService;

/**
 *
 * @author martinez
 */
public class frmMenu extends javax.swing.JFrame {
    private String idUsuario;
    private EventoService eventoService;
    private BoletoService boletoService;
    private TransaccionService transaccionService;
    /**
     * Creates new form frmMenu
     */
    public frmMenu(String idUsuario) throws SQLException {
        this.idUsuario = idUsuario;
        initComponents();
        setLocationRelativeTo(null);
        
    }
    
    private void cargarEventos() throws SQLException {
        lblSeleccionDelMenu.setText("Todos los eventos:");
        pnlContenedor.removeAll();
        pnlContenedor.setLayout(new BoxLayout(pnlContenedor, BoxLayout.Y_AXIS));
        eventoService = new EventoService();
        try {
            List<Evento> eventos = eventoService.obtenerTodosLosEventos();
            for (Evento evento : eventos) {
                JPanel panelEvento = new JPanel();
                panelEvento.setLayout(null);
                panelEvento.setPreferredSize(new Dimension(738, 102));
                panelEvento.setBackground(new Color(0, 61, 122));

                JLabel lblNombre = new JLabel("Nombre: " + evento.getNombre());
                lblNombre.setForeground(Color.WHITE);
                lblNombre.setBounds(10, 10, 200, 30);
                panelEvento.add(lblNombre);

                JLabel lblVenue = new JLabel("Venue: " + evento.getVenue());
                lblVenue.setForeground(Color.WHITE);
                lblVenue.setBounds(10, 40, 200, 30);
                panelEvento.add(lblVenue);

                JLabel lblFecha = new JLabel("Fecha: " + evento.getFecha());
                lblFecha.setForeground(Color.WHITE);
                lblFecha.setBounds(10, 70, 200, 30);
                panelEvento.add(lblFecha);
                
                panelEvento.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            frmCompra compra = new frmCompra(evento, idUsuario);
                            compra.setVisible(true);
                            dispose();
                        } catch (SQLException ex) {
                            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                
                pnlContenedor.add(panelEvento);
                pnlContenedor.add(Box.createRigidArea(new Dimension(0, 10)));
            }
            pnlContenedor.revalidate();
            pnlContenedor.repaint();
        }
        catch (SQLException e) {
            System.out.println("Error al cargar los eventos: " + e.getMessage());
        }
    }
    
    private void cargarMisBoletos() throws SQLException{
        lblSeleccionDelMenu.setText("Tus boletos:");
        pnlContenedor.removeAll();
        pnlContenedor.setLayout(new BoxLayout(pnlContenedor, BoxLayout.Y_AXIS));
        boletoService = new BoletoService();
        try{
            List<Boleto> boletos = boletoService.getMisBoletos(Integer.parseInt(idUsuario));
            for(Boleto boleto : boletos){
                JPanel panelEvento = new JPanel();
                panelEvento.setLayout(null);
                panelEvento.setPreferredSize(new Dimension(738, 102));
                panelEvento.setBackground(new Color(0, 61, 122));

                JLabel lblNombre = new JLabel("nSerie: " + boleto.getnSerie());
                lblNombre.setForeground(Color.WHITE);
                lblNombre.setBounds(10, 10, 200, 30);
                panelEvento.add(lblNombre);

                JLabel lblVenue = new JLabel("Fila: " + boleto.getFila());
                lblVenue.setForeground(Color.WHITE);
                lblVenue.setBounds(10, 40, 200, 30);
                panelEvento.add(lblVenue);

                JLabel lblFecha = new JLabel("Asiento: " + boleto.getAsiento());
                lblFecha.setForeground(Color.WHITE);
                lblFecha.setBounds(10, 70, 200, 30);
                panelEvento.add(lblFecha);
                
                pnlContenedor.add(panelEvento);
                pnlContenedor.add(Box.createRigidArea(new Dimension(0, 10)));
            }
            pnlContenedor.revalidate();
            pnlContenedor.repaint();
        }
        catch (SQLException e) {
            System.out.println("Error al cargar los boletos: " + e.getMessage());
        }
    }
    
    private void CargarHistorial() throws SQLException{
        lblSeleccionDelMenu.setText("Historial:");
        pnlContenedor.removeAll();
        pnlContenedor.setLayout(new BoxLayout(pnlContenedor, BoxLayout.Y_AXIS));
        transaccionService = new TransaccionService();
        try{
            List<Transaccion> historial = transaccionService.getHistorial(Integer.parseInt(idUsuario));
            for(Transaccion t : historial){
                JPanel panelEvento = new JPanel();
                panelEvento.setLayout(null);
                panelEvento.setPreferredSize(new Dimension(738, 102));
                panelEvento.setBackground(new Color(0, 61, 122));

                JLabel lblNombre = new JLabel("ID: " + t.getId());
                lblNombre.setForeground(Color.WHITE);
                lblNombre.setBounds(10, 10, 200, 30);
                panelEvento.add(lblNombre);

                JLabel lblVenue = new JLabel("Monto: " + t.getMonto());
                lblVenue.setForeground(Color.WHITE);
                lblVenue.setBounds(10, 40, 200, 30);
                panelEvento.add(lblVenue);

                JLabel lblFecha = new JLabel("Fecha de Adquisicion: " + t.getAdquisicion());
                lblFecha.setForeground(Color.WHITE);
                lblFecha.setBounds(10, 70, 400, 30);
                panelEvento.add(lblFecha);
                
                pnlContenedor.add(panelEvento);
                pnlContenedor.add(Box.createRigidArea(new Dimension(0, 10)));
            }
            pnlContenedor.revalidate();
            pnlContenedor.repaint();
        }
        catch (SQLException e) {
            System.out.println("Error al cargar el Historial de Transacciones: " + e.getMessage());
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

        pnlPantalla = new javax.swing.JPanel();
        btnPerfil = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        lblBuscarIcono = new javax.swing.JLabel();
        txfBuscar = new javax.swing.JTextField();
        lblCerrar = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        btnEventos = new javax.swing.JButton();
        btnMisBoletos = new javax.swing.JButton();
        spnContenedor = new javax.swing.JScrollPane();
        pnlContenedor = new javax.swing.JPanel();
        lblSeleccionDelMenu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlPantalla.setBackground(new java.awt.Color(0, 51, 102));

        btnPerfil.setBackground(new java.awt.Color(0, 102, 83));
        btnPerfil.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPerfil.setForeground(new java.awt.Color(255, 255, 255));
        btnPerfil.setText("Perfil");
        btnPerfil.setBorder(null);
        btnPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPerfilMouseClicked(evt);
            }
        });

        btnHistorial.setBackground(new java.awt.Color(0, 102, 83));
        btnHistorial.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHistorial.setForeground(new java.awt.Color(255, 255, 255));
        btnHistorial.setText("Historial");
        btnHistorial.setBorder(null);
        btnHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistorialMouseClicked(evt);
            }
        });

        lblBuscarIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N

        txfBuscar.setBackground(new java.awt.Color(0, 102, 83));
        txfBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txfBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txfBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfBuscar.setText("Buscar");
        txfBuscar.setBorder(null);

        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar.png"))); // NOI18N
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });

        lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimizar.png"))); // NOI18N

        btnEventos.setBackground(new java.awt.Color(0, 102, 83));
        btnEventos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEventos.setForeground(new java.awt.Color(255, 255, 255));
        btnEventos.setText("Proximos eventos");
        btnEventos.setBorder(null);
        btnEventos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEventosMouseClicked(evt);
            }
        });

        btnMisBoletos.setBackground(new java.awt.Color(0, 102, 83));
        btnMisBoletos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMisBoletos.setForeground(new java.awt.Color(255, 255, 255));
        btnMisBoletos.setText("Tus boletos");
        btnMisBoletos.setBorder(null);
        btnMisBoletos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMisBoletos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMisBoletosMouseClicked(evt);
            }
        });

        spnContenedor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        spnContenedor.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlContenedor.setBackground(new java.awt.Color(0, 51, 102));
        pnlContenedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

        spnContenedor.setViewportView(pnlContenedor);

        lblSeleccionDelMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSeleccionDelMenu.setForeground(new java.awt.Color(255, 255, 255));
        lblSeleccionDelMenu.setText("Proximos eventos (Todos):");

        javax.swing.GroupLayout pnlPantallaLayout = new javax.swing.GroupLayout(pnlPantalla);
        pnlPantalla.setLayout(pnlPantallaLayout);
        pnlPantallaLayout.setHorizontalGroup(
            pnlPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPantallaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spnContenedor)
                    .addGroup(pnlPantallaLayout.createSequentialGroup()
                        .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMisBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblBuscarIcono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(lblMinimizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCerrar))
                    .addGroup(pnlPantallaLayout.createSequentialGroup()
                        .addComponent(lblSeleccionDelMenu)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlPantallaLayout.setVerticalGroup(
            pnlPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPantallaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCerrar)
                    .addComponent(lblMinimizar)
                    .addGroup(pnlPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblBuscarIcono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMisBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txfBuscar, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(52, 52, 52)
                .addComponent(lblSeleccionDelMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spnContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseClicked
        // TODO add your handling code here:
        try {
            frmPerfil perfil = new frmPerfil(idUsuario);
            perfil.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPerfilMouseClicked

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        // TODO add your handling code here:
        frmLogin login = new frmLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void btnMisBoletosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMisBoletosMouseClicked
        try {
            // TODO add your handling code here:
            cargarMisBoletos();
        } catch (SQLException ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMisBoletosMouseClicked

    private void btnEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEventosMouseClicked
        try {
            // TODO add your handling code here:
            cargarEventos();
        } catch (SQLException ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEventosMouseClicked

    private void btnHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialMouseClicked
        try {
            // TODO add your handling code here:
            CargarHistorial();
        } catch (SQLException ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHistorialMouseClicked

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
//            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmMenu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEventos;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnMisBoletos;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JLabel lblBuscarIcono;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel lblSeleccionDelMenu;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JPanel pnlPantalla;
    private javax.swing.JScrollPane spnContenedor;
    private javax.swing.JTextField txfBuscar;
    // End of variables declaration//GEN-END:variables
}
