/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package rompecabezas;

/**
 *
 * @author usuario
 */
public class DialogoRompeCabezas extends javax.swing.JDialog {

    /**
     * Creates new form DialogoRompeCabezas
     */
    public DialogoRompeCabezas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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
        bMarvel = new javax.swing.JButton();
        bDisney = new javax.swing.JButton();
        bPixar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bMarvel.setBackground(new java.awt.Color(255, 204, 153));
        bMarvel.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        bMarvel.setForeground(new java.awt.Color(0, 0, 0));
        bMarvel.setText("Marvel");
        bMarvel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMarvelActionPerformed(evt);
            }
        });
        jPanel1.add(bMarvel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, -1));

        bDisney.setBackground(new java.awt.Color(255, 153, 153));
        bDisney.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        bDisney.setForeground(new java.awt.Color(0, 0, 0));
        bDisney.setText("Disney");
        bDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDisneyActionPerformed(evt);
            }
        });
        jPanel1.add(bDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        bPixar.setBackground(new java.awt.Color(153, 255, 153));
        bPixar.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        bPixar.setForeground(new java.awt.Color(0, 0, 0));
        bPixar.setText("Pixar");
        bPixar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPixarActionPerformed(evt);
            }
        });
        jPanel1.add(bPixar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgmarvel (1).jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgPixar (1).jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgDisney (1).png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 2, 50)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese la categoria");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/r1.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
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

    private void bDisneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDisneyActionPerformed
        // TODO add your handling code here:
        dispose();
        DialogoDisney d1 = new DialogoDisney(this, true);
        d1.setVisible(true);
    }//GEN-LAST:event_bDisneyActionPerformed

    private void bMarvelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMarvelActionPerformed
        // TODO add your handling code here:
        dispose();
        DialogoMarvel d2 = new DialogoMarvel(this, true);
        d2.setVisible(true);
    }//GEN-LAST:event_bMarvelActionPerformed

    private void bPixarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPixarActionPerformed
        // TODO add your handling code here:
        dispose();
        DialogoPixar d3 = new DialogoPixar(this, true);
        d3.setVisible(true);
    }//GEN-LAST:event_bPixarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDisney;
    private javax.swing.JButton bMarvel;
    private javax.swing.JButton bPixar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}