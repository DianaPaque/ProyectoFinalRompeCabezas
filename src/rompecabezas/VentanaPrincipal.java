/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rompecabezas;

import java.awt.event.KeyEvent;

/**
 *
 * @author usuario
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
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
        bAcercade = new javax.swing.JButton();
        bIniciarJuego = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bAcercade.setBackground(new java.awt.Color(255, 204, 153));
        bAcercade.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        bAcercade.setForeground(new java.awt.Color(102, 102, 102));
        bAcercade.setText("acerca del juego");
        bAcercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAcercadeActionPerformed(evt);
            }
        });
        jPanel1.add(bAcercade, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        bIniciarJuego.setBackground(new java.awt.Color(255, 204, 153));
        bIniciarJuego.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        bIniciarJuego.setForeground(new java.awt.Color(102, 102, 102));
        bIniciarJuego.setText("Iniciar Juego");
        bIniciarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIniciarJuegoActionPerformed(evt);
            }
        });
        jPanel1.add(bIniciarJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, -1, -1));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Brain Twist");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RcInicial.jpg"))); // NOI18N
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel2KeyPressed(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bIniciarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIniciarJuegoActionPerformed
        // TODO add your handling code here:
        DialogoRompeCabezas d1 = new DialogoRompeCabezas(this, true);
        d1.setVisible(true);
    }//GEN-LAST:event_bIniciarJuegoActionPerformed

    private void bAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAcercadeActionPerformed
        // TODO add your handling code here:
        DialogoAcercaDelJuego d2 = new DialogoAcercaDelJuego(this, true);
        d2.setVisible(true);
    }//GEN-LAST:event_bAcercadeActionPerformed

    private void jLabel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2KeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_SPACE){
            System.exit(0);
        }
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        VentanaPrincipal VentanaPrincipal = new VentanaPrincipal();
        VentanaPrincipal.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAcercade;
    private javax.swing.JButton bIniciarJuego;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
