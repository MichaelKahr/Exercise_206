package GUI;

import BL.StorageModel;
import BL.StorageRenderer;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author mikeykahr
 */
public class StorageGUI extends javax.swing.JFrame {

    private StorageModel model = new StorageModel();
    private File f = new File("src/data.ser");
    /**
     * Creates new form StorageGUI
     */
    public StorageGUI() throws IOException, ClassNotFoundException {
        initComponents();
        jtOut.setModel(model);
        jtOut.setDefaultRenderer(Object.class, new StorageRenderer());
        model.load(f);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtOut = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmAdd = new javax.swing.JMenuItem();
        jmDelete = new javax.swing.JMenuItem();
        jmEdit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmBuy = new javax.swing.JMenuItem();
        jmSell = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jtOut.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtOut);

        jMenu1.setText("Management");

        jmAdd.setText("Add new article");
        jmAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAddActionPerformed(evt);
            }
        });
        jMenu1.add(jmAdd);

        jmDelete.setText("Remove Selected Article");
        jmDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDeleteActionPerformed(evt);
            }
        });
        jMenu1.add(jmDelete);

        jmEdit.setText("Edit Selected Article");
        jmEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditActionPerformed(evt);
            }
        });
        jMenu1.add(jmEdit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Bey/Sell");

        jmBuy.setText("Buy Selected Article");
        jmBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmBuyActionPerformed(evt);
            }
        });
        jMenu2.add(jmBuy);

        jmSell.setText("Sell Selected Article");
        jmSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSellActionPerformed(evt);
            }
        });
        jMenu2.add(jmSell);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAddActionPerformed
        StorageDlg dlg = new StorageDlg(this,true);
        dlg.setVisible(true);
        if(dlg.isOk()){
            model.add(dlg.getE());
        }
    }//GEN-LAST:event_jmAddActionPerformed

    private void jmDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDeleteActionPerformed
        model.delete(jtOut.getSelectedRow());
    }//GEN-LAST:event_jmDeleteActionPerformed

    private void jmEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditActionPerformed
        StorageDlg dlg = new StorageDlg(this, true, model.getRow(jtOut.getSelectedRow()));
        dlg.setVisible(true);
        if(dlg.isOk()){
            model.delete(jtOut.getSelectedRow());
            model.add(dlg.getE());
        }
    }//GEN-LAST:event_jmEditActionPerformed

    private void jmBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmBuyActionPerformed
        try {
            model.increase(jtOut.getSelectedRow());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }//GEN-LAST:event_jmBuyActionPerformed

    private void jmSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSellActionPerformed
        try {
            model.decrease(jtOut.getSelectedRow());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jmSellActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            model.save(f);
        } catch (IOException ex) {
            Logger.getLogger(StorageGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StorageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StorageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StorageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StorageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StorageGUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(StorageGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StorageGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jmAdd;
    private javax.swing.JMenuItem jmBuy;
    private javax.swing.JMenuItem jmDelete;
    private javax.swing.JMenuItem jmEdit;
    private javax.swing.JMenuItem jmSell;
    private javax.swing.JTable jtOut;
    // End of variables declaration//GEN-END:variables
}
