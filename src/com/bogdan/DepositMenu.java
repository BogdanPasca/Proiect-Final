package com.bogdan;

import javax.swing.JOptionPane;

public class DepositMenu extends javax.swing.JDialog {

    private Client customer;
    private Bank bank;

    public DepositMenu(java.awt.Frame parent, boolean modal, Bank banca, Client client) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.bank = banca;
        this.customer = client;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sumaDeAdaugatLabel = new javax.swing.JLabel();
        sumaDeAdaugatField = new javax.swing.JTextField();
        adaugaButton = new javax.swing.JButton();
        anulareButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Meniu adăugare bani");
        getContentPane().setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        sumaDeAdaugatLabel.setText("Suma de adăugat:");
        getContentPane().add(sumaDeAdaugatLabel);
        getContentPane().add(sumaDeAdaugatField);

        adaugaButton.setText("Adaugă");
        adaugaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adaugaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adaugaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(adaugaButton);

        anulareButton.setText("Anulare");
        anulareButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        anulareButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anulareButtonActionPerformed(evt);
            }
        });
        getContentPane().add(anulareButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void anulareButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anulareButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_anulareButtonActionPerformed

    private void adaugaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adaugaButtonActionPerformed
        StringBuilder warnings = new StringBuilder();
        //Verifica daca campul suma de adaugat nu este gol
        if (sumaDeAdaugatField.getText().isEmpty()) {
            warnings.append("Introduceți suma de adăugat.\n");
        } else {
            double amount = 0;
            try {
                amount = Bank.round(Double.parseDouble(sumaDeAdaugatField.getText()), 2);
                int result = JOptionPane.showConfirmDialog(this, "Depuneti " + String.format("%.2f", amount) + " lei în cont?\nDobânda oferită: " + String.format("%.2f Lei", (bank.verificaDobanda(customer.getCont().getSold(), amount) * amount)));
                if (result == JOptionPane.OK_OPTION) {
                    try {
                        //Realizeaza tranzactia
                        bank.adaugaBani(customer.getCont().getNumarCont(), amount);
                        this.dispose();
                    } catch (InvalidAmountException ex) {
                        warnings.append("Suma depusă nu este validă.\n");
                    }

                }
            } catch (NumberFormatException ex) {
                warnings.append("Sunt permise doar numere!\n");
            }
        }
        if (warnings.length() > 0) {
            JOptionPane.showMessageDialog(this, warnings.toString(), "Deposit Warnings", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_adaugaButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adaugaButton;
    private javax.swing.JButton anulareButton;
    private javax.swing.JTextField sumaDeAdaugatField;
    private javax.swing.JLabel sumaDeAdaugatLabel;
    // End of variables declaration//GEN-END:variables
}
