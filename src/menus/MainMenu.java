package menus;

import menus.MeniuRetragereBani;
import entities.Client;
import entities.Bank;
import entities.account.AddAccountMenu;
import entities.account.AccountDetailsPage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainMenu extends javax.swing.JFrame {

    private Bank bank;
    private String saveLocation = null;
    private final DefaultTableModel model;

    public MainMenu() {
        initComponents();
        setLocationRelativeTo(null);
        bank = new Bank();
        model = (DefaultTableModel) accountTable.getModel();
        reloadTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        adaugaContButton = new javax.swing.JButton();
        stergeContButton = new javax.swing.JButton();
        adaugaBaniButton = new javax.swing.JButton();
        retrageBaniButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        accountTable = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bank Application");

        contentPanel.setForeground(new java.awt.Color(255, 255, 255));

        adaugaContButton.setBackground(new java.awt.Color(0, 102, 204));
        adaugaContButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        adaugaContButton.setForeground(new java.awt.Color(255, 255, 255));
        adaugaContButton.setText("Adaugă cont");
        adaugaContButton.setBorder(null);
        adaugaContButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adaugaContButton.setSelected(true);
        adaugaContButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adaugaContButtonActionPerformed(evt);
            }
        });

        stergeContButton.setBackground(new java.awt.Color(0, 102, 204));
        stergeContButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        stergeContButton.setForeground(new java.awt.Color(255, 255, 255));
        stergeContButton.setText("Șterge cont");
        stergeContButton.setBorder(null);
        stergeContButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stergeContButton.setEnabled(false);
        stergeContButton.setPreferredSize(new java.awt.Dimension(89, 23));
        stergeContButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stergeContButtonActionPerformed(evt);
            }
        });

        adaugaBaniButton.setBackground(new java.awt.Color(0, 102, 204));
        adaugaBaniButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        adaugaBaniButton.setForeground(new java.awt.Color(255, 255, 255));
        adaugaBaniButton.setText("Adaugă bani");
        adaugaBaniButton.setBorder(null);
        adaugaBaniButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adaugaBaniButton.setEnabled(false);
        adaugaBaniButton.setMaximumSize(new java.awt.Dimension(83, 23));
        adaugaBaniButton.setMinimumSize(new java.awt.Dimension(83, 23));
        adaugaBaniButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adaugaBaniButtonActionPerformed(evt);
            }
        });

        retrageBaniButton.setBackground(new java.awt.Color(0, 102, 204));
        retrageBaniButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        retrageBaniButton.setForeground(new java.awt.Color(255, 255, 255));
        retrageBaniButton.setText("Retrage bani");
        retrageBaniButton.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        retrageBaniButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        retrageBaniButton.setEnabled(false);
        retrageBaniButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retrageBaniButtonActionPerformed(evt);
            }
        });

        accountTable.setAutoCreateRowSorter(true);
        accountTable.setBackground(new java.awt.Color(255, 255, 255));
        accountTable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        accountTable.setForeground(new java.awt.Color(0, 0, 0));
        accountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prenume", "Nume", "Numărul contului", "Sold"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        accountTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        accountTable.getTableHeader().setReorderingAllowed(false);
        accountTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(accountTable);
        if (accountTable.getColumnModel().getColumnCount() > 0) {
            accountTable.getColumnModel().getColumn(0).setResizable(false);
            accountTable.getColumnModel().getColumn(1).setResizable(false);
            accountTable.getColumnModel().getColumn(2).setResizable(false);
            accountTable.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(adaugaContButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(stergeContButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(adaugaBaniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(retrageBaniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adaugaBaniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(retrageBaniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(stergeContButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adaugaContButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuBar.setBackground(new java.awt.Color(0, 102, 204));
        menuBar.setForeground(new java.awt.Color(0, 102, 204));

        fileMenu.setBackground(new java.awt.Color(0, 102, 204));
        fileMenu.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        fileMenu.setForeground(new java.awt.Color(0, 0, 0));
        fileMenu.setText("File");
        fileMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fileMenu.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png")));
        exitMenuItem.setText("Ieșire");
        exitMenuItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exitMenuItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void accountTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountTableMouseClicked
        setAccountButtonsActive(true);

        if (evt.getClickCount() == 2) {
            int selectedRow = accountTable.getSelectedRow();
            Client customer = getSelectedCustomer(selectedRow);
            if (customer != null) {
                AccountDetailsPage page = new AccountDetailsPage(this, true, bank, customer);
                page.setVisible(true);
            }
        }
    }//GEN-LAST:event_accountTableMouseClicked

    private void retrageBaniButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retrageBaniButtonActionPerformed
        adaugaSauRetrageBani("withdraw");
    }//GEN-LAST:event_retrageBaniButtonActionPerformed

    private void adaugaBaniButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adaugaBaniButtonActionPerformed
        adaugaSauRetrageBani("deposit");
    }//GEN-LAST:event_adaugaBaniButtonActionPerformed

    private void stergeContButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stergeContButtonActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Sunteți siguri?", "Select an Option", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int selectedRow = accountTable.getSelectedRow();
            if (selectedRow >= 0) {
                Client customer = getSelectedCustomer(selectedRow);
                if (customer != null) {
                    bank.stergeCont(customer.getCont().getNumarCont());
                    removeCustomerFromTable(selectedRow);
                }
            }
        }
    }//GEN-LAST:event_stergeContButtonActionPerformed

    private void adaugaContButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adaugaContButtonActionPerformed
        AddAccountMenu menu = new AddAccountMenu(this, true, bank);
        menu.setVisible(true);
        if (menu.getCustomer() != null) {
            addCustomerToTable(menu.getCustomer());
        }
    }//GEN-LAST:event_adaugaContButtonActionPerformed

    private void adaugaSauRetrageBani(String action) {
        int selectedRow = accountTable.getSelectedRow();
        Client client = getSelectedCustomer(selectedRow);
        if (client != null) {
            javax.swing.JDialog window = null;
            if (action.equals("deposit")) {
                window = new DepositMenu(this, true, bank, client);
            } else if (action.equals("withdraw")) {
                window = new MeniuRetragereBani(this, true, bank, client);
            }
            if (window != null) {
                window.setVisible(true);
            }
            reloadCustomerRowData(selectedRow, client.getCont().getNumarCont());
        }
    }

    private Client getSelectedCustomer(int selectedRow) {
        Client client = null;
        if (selectedRow >= 0) {
            int accountNumber = (int) accountTable.getValueAt(selectedRow, 2);
            client = bank.getClient(accountNumber);
        }
        return client;
    }

    private void addCustomerToTable(Client client) {
        model.addRow(new Object[]{});
        reloadCustomerRowData(model.getRowCount() - 1, client.getCont().getNumarCont());
    }

    private void removeCustomerFromTable(int row) {
        model.removeRow(row);
    }

    private void reloadCustomerRowData(int selectedRow, int accountId) {
        Client customer = bank.getClient(accountId);
        model.setValueAt(customer.getPrenume(), selectedRow, 0);
        model.setValueAt(customer.getNume(), selectedRow, 1);
        model.setValueAt(customer.getCont().getNumarCont(), selectedRow, 2);
        model.setValueAt(String.format("%.2f", customer.getCont().getSold()), selectedRow, 3);
    }

    private void reloadTable() {
        DefaultTableModel model = (DefaultTableModel) accountTable.getModel();
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (Client c : bank.getClienti()) {
            addCustomerToTable(c);
        }
    }

    private void setAccountButtonsActive(boolean active) {
        adaugaBaniButton.setEnabled(active);
        retrageBaniButton.setEnabled(active);
        stergeContButton.setEnabled(active);
    }

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
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable accountTable;
    private javax.swing.JButton adaugaBaniButton;
    private javax.swing.JButton adaugaContButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton retrageBaniButton;
    private javax.swing.JButton stergeContButton;
    // End of variables declaration//GEN-END:variables

}
