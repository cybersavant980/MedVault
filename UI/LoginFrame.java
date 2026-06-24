package UI;

import UI.components.MessageDialog;
import UI.components.RoundedButton;
import UI.components.RoundedPanel;
import UI.components.RoundedPasswordField;
import UI.components.RoundedTextField;
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

    private void initializeComponents() {

        usernameField = new RoundedTextField(20);
        passwordField = new RoundedPasswordField(20);

        loginButton = new RoundedButton("Login");
        clearButton = new RoundedButton("Clear");
        exitButton = new RoundedButton("Exit");
    }

    private void layoutComponents() {

        JPanel root = new JPanel(new GridLayout(1, 2));
        root.setBackground(Theme.BACKGROUND);

        // ================= LEFT PANEL =================

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Theme.PRIMARY);
        leftPanel.setLayout(new GridBagLayout());

        JLabel title = new JLabel("THE_PROJECT");
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Color.WHITE);

        JLabel subtitle = new JLabel("Offline Home Medical Record");
        subtitle.setFont(Theme.SUBTITLE_FONT);
        subtitle.setForeground(Color.WHITE);

        JPanel leftContent = new JPanel();
        leftContent.setOpaque(false);
        leftContent.setLayout(new BoxLayout(leftContent, BoxLayout.Y_AXIS));

        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftContent.add(title);
        leftContent.add(Box.createVerticalStrut(15));
        leftContent.add(subtitle);

        leftPanel.add(leftContent);

        // ================= RIGHT PANEL =================

        RoundedPanel formPanel = new RoundedPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBorder(new EmptyBorder(30, 30, 30, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.weightx = 1;

        JLabel loginLabel = new JLabel("Login");
        loginLabel.setFont(Theme.HEADER_FONT);

        gbc.gridy = 0;
        formPanel.add(loginLabel, gbc);

        gbc.gridy++;
        formPanel.add(new JLabel("Username"), gbc);

        gbc.gridy++;
        formPanel.add(usernameField, gbc);

        gbc.gridy++;
        formPanel.add(new JLabel("Password"), gbc);

        gbc.gridy++;
        formPanel.add(passwordField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setOpaque(false);

        buttonPanel.add(loginButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        gbc.gridy++;
        formPanel.add(buttonPanel, gbc);

        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(Theme.BACKGROUND);
        rightPanel.add(formPanel);

        root.add(leftPanel);
        root.add(rightPanel);

        setContentPane(root);
    }

    private void registerEvents() {

        loginButton.addActionListener(e -> validateLogin());

        clearButton.addActionListener(e -> {
            usernameField.setText("");
            passwordField.setText("");
        });

        exitButton.addActionListener(e -> System.exit(0));
    }

    private void validateLogin() {

        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (username.equals("admin") && password.equals("admin123")) {

            MessageDialog.showSuccess(this, "Login Successful");

            dispose();

            new MainFrame().setVisible(true);

        } else {

            MessageDialog.showError(this, "Invalid Username or Password");

        }
    }

    private void setFrameProperties() {

        setTitle("THE_PROJECT");
        setSize(Theme.WINDOW_WIDTH, Theme.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
}