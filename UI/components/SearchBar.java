package UI.components;

import UI.theme.Theme;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SearchBar extends JPanel {

    private final RoundedTextField searchField;
    private final RoundedButton searchButton;

    public SearchBar() {

        setOpaque(false);
        setLayout(new BorderLayout(12, 0));
        setBorder(new EmptyBorder(5, 5, 5, 5));

        searchField = new RoundedTextField(30);

        searchField.setToolTipText("Search...");

        searchButton = new RoundedButton("Search");

        add(searchField, BorderLayout.CENTER);
        add(searchButton, BorderLayout.EAST);

    }

    public String getSearchText() {

        return searchField.getText().trim();

    }

    public void setSearchText(String text) {

        searchField.setText(text);

    }

    public void clear() {

        searchField.setText("");

        searchField.requestFocus();

    }

    public RoundedButton getSearchButton() {

        return searchButton;

    }

    public RoundedTextField getSearchField() {

        return searchField;

    }

}