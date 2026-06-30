package UI;

import UI.components.RoundedButton;
import UI.components.RoundedPanel;
import UI.components.MessageDialog;
import UI.theme.Theme;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {

    private RoundedButton backupButton;
    private RoundedButton restoreButton;
    private RoundedButton aboutButton;
    private RoundedButton exitButton;

    private JTextArea infoArea;

    public SettingsPanel() {

        initializeComponents();
        layoutComponents();
        registerEvents();

    }

    // =====================================================
    // Initialize
    // =====================================================

    private void initializeComponents() {

        backupButton = new RoundedButton("Backup Data");

        restoreButton = new RoundedButton("Restore Data");

        aboutButton = new RoundedButton("About");

        exitButton = new RoundedButton("Exit");

        infoArea = new JTextArea();

        infoArea.setEditable(false);

        infoArea.setFont(Theme.BODY_FONT);

        infoArea.setText(

                "MedVault\n\n"

                + "Offline Home Medical Record & Emergency Management System\n\n"

                + "Version : 1.0\n\n"

                + "Developed by Team MeadVault\n" 

                + "Lead by Vanshika Joshi with team members; Mangilal Dewasi and Lakshmi Kashyap\n\n"

                + "Data Storage : using .dat Files\n"

                + "Architecture : OOP + DSA\n"

                + "Mode : Offline"

        );

    }

    // =====================================================
    // Layout
    // =====================================================

    private void layoutComponents() {

        setLayout(new BorderLayout(15,15));

        setBackground(Theme.BACKGROUND);

        RoundedPanel topPanel = new RoundedPanel();

        topPanel.add(backupButton);
        topPanel.add(restoreButton);
        topPanel.add(aboutButton);
        topPanel.add(exitButton);

        JScrollPane scrollPane =
                new JScrollPane(infoArea);

        add(topPanel,BorderLayout.NORTH);

        add(scrollPane,BorderLayout.CENTER);

    }

    // =====================================================
    // Events
    // =====================================================

    private void registerEvents() {

        backupButton.addActionListener(e -> backupData());

        restoreButton.addActionListener(e -> restoreData());

        aboutButton.addActionListener(e -> showAbout());

        exitButton.addActionListener(e -> exitApplication());

    }

    // =====================================================
    // Backup
    // =====================================================

    private void backupData() {

        MessageDialog.showInfo(

                this,

                "Backup feature will be implemented later."

        );

    }

    // =====================================================
    // Restore
    // =====================================================

    private void restoreData() {

        MessageDialog.showInfo(

                this,

                "Restore feature will be implemented later."

        );

    }

    // =====================================================
    // About
    // =====================================================

    private void showAbout() {

        MessageDialog.showInfo(

                this,

                "MedVault\n\n"

                + "Offline Home Medical Record\n"

                + "& Emergency Management System\n\n"

                + "Version 1.0\n"

                + "Developed using Java Swing."

        );

    }

    // =====================================================
    // Exit
    // =====================================================

    private void exitApplication() {

        int option = JOptionPane.showConfirmDialog(

                this,

                "Exit MedVault?",

                "Exit",

                JOptionPane.YES_NO_OPTION

        );

        if(option == JOptionPane.YES_OPTION){

            System.exit(0);

        }

    }

}