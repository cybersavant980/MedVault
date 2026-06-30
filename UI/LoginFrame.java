package UI;

import UI.components.*;
import UI.theme.Theme;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginFrame extends JFrame {

    private RoundedTextField usernameField;
    private RoundedPasswordField passwordField;

    private RoundedButton loginButton;
    private RoundedButton clearButton;
    private RoundedButton exitButton;

    public LoginFrame() {

        initializeComponents();

        layoutComponents();

        registerEvents();

        setFrameProperties();

    }

    // =====================================================
    // Initialize
    // =====================================================

    private void initializeComponents() {

        usernameField = new RoundedTextField(22);

        passwordField = new RoundedPasswordField(22);

        loginButton = new RoundedButton("Login");

        clearButton = new RoundedButton("Clear");

        exitButton = new RoundedButton("Exit");

    }

    // =====================================================
    // Layout
    // =====================================================

    private void layoutComponents() {

        JPanel root = new JPanel(new GridLayout(1,2));

        root.setBackground(Theme.BACKGROUND);

        root.add(createLeftPanel());

        root.add(createRightPanel());

        setContentPane(root);

    }
        // =====================================================
    // Left Panel
    // =====================================================

    private JPanel createLeftPanel() {

        JPanel panel = new JPanel(new GridBagLayout());

        panel.setBackground(Theme.PRIMARY);

        JPanel content = new JPanel();

        content.setOpaque(false);

        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        JLabel logo = new JLabel("🛡");

        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        logo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 72));

        JLabel title = new JLabel("MedVault");

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        title.setFont(new Font("Segoe UI", Font.BOLD, 38));

        title.setForeground(Color.WHITE);

        JLabel subtitle1 = new JLabel("Offline Home Medical");

        subtitle1.setAlignmentX(Component.CENTER_ALIGNMENT);

        subtitle1.setForeground(Color.WHITE);

        subtitle1.setFont(Theme.SUBTITLE_FONT);

        JLabel subtitle2 = new JLabel("Record & Emergency");

        subtitle2.setAlignmentX(Component.CENTER_ALIGNMENT);

        subtitle2.setForeground(Color.WHITE);

        subtitle2.setFont(Theme.SUBTITLE_FONT);

        JLabel subtitle3 = new JLabel("Management System");

        subtitle3.setAlignmentX(Component.CENTER_ALIGNMENT);

        subtitle3.setForeground(Color.WHITE);

        subtitle3.setFont(Theme.SUBTITLE_FONT);

        content.add(logo);
        content.add(Box.createVerticalStrut(25));
        content.add(title);
        content.add(Box.createVerticalStrut(15));
        content.add(subtitle1);
        content.add(subtitle2);
        content.add(subtitle3);

        panel.add(content);

        return panel;

    }

    // =====================================================
    // Right Panel
    // =====================================================

    private JPanel createRightPanel() {

        JPanel panel = new JPanel(new GridBagLayout());

        panel.setBackground(Theme.BACKGROUND);

        RoundedPanel loginCard = new RoundedPanel();

        loginCard.setPreferredSize(new Dimension(470,470));

        loginCard.setLayout(new GridBagLayout());

        loginCard.setBorder(new EmptyBorder(30,30,30,30));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10,10,10,10);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.weightx = 1;

        gbc.gridx = 0;

        JLabel heading = new JLabel("Welcome Back");

        heading.setFont(Theme.HEADER_FONT);

        heading.setForeground(Theme.TEXT_PRIMARY);

        JLabel caption = new JLabel("Login to continue");

        caption.setFont(Theme.SUBTITLE_FONT);

        caption.setForeground(Theme.TEXT_SECONDARY);

        gbc.gridy = 0;
        loginCard.add(heading, gbc);

        gbc.gridy++;
        loginCard.add(caption, gbc);

        gbc.gridy++;
        loginCard.add(new JLabel("Username"), gbc);

        gbc.gridy++;
        loginCard.add(usernameField, gbc);

        gbc.gridy++;
        loginCard.add(new JLabel("Password"), gbc);

        gbc.gridy++;
        loginCard.add(passwordField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(
                FlowLayout.CENTER,
                15,
                0));

        buttonPanel.setOpaque(false);

        buttonPanel.add(loginButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        gbc.gridy++;
        gbc.insets = new Insets(25,10,10,10);

        loginCard.add(buttonPanel, gbc);

        panel.add(loginCard);

        return panel;

    }
        // =====================================================
    // Events
    // =====================================================

    private void registerEvents() {

        loginButton.addActionListener(e -> validateLogin());

        clearButton.addActionListener(e -> {

            usernameField.setText("");

            passwordField.setText("");

            usernameField.requestFocus();

        });

        exitButton.addActionListener(e -> System.exit(0));

        getRootPane().setDefaultButton(loginButton);

    }

    // =====================================================
    // Login Validation
    // =====================================================

    private void validateLogin() {

        String username =
                usernameField.getText().trim();

        String password =
                new String(passwordField.getPassword());

        if (username.isEmpty()) {

            MessageDialog.showError(
                    this,
                    "Please enter username.");

            usernameField.requestFocus();

            return;

        }

        if (password.isEmpty()) {

            MessageDialog.showError(
                    this,
                    "Please enter password.");

            passwordField.requestFocus();

            return;

        }

        if (username.equals("admin")
                && password.equals("admin123")) {

            MessageDialog.showSuccess(
                    this,
                    "Welcome to MedVault!");

            dispose();

            SwingUtilities.invokeLater(() -> {

                MainFrame frame = new MainFrame();

                frame.setVisible(true);

            });

        } else {

            MessageDialog.showError(
                    this,
                    "Invalid username or password.");

            passwordField.setText("");

            passwordField.requestFocus();

        }

    }

    // =====================================================
    // Frame Properties
    // =====================================================

    private void setFrameProperties() {

        setTitle("MedVault");

        setSize(1200, 700);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

    }

}