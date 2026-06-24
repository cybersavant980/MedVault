package UI.components;

import UI.theme.Theme;

import javax.swing.*;
import java.awt.*;

public class SearchBar extends JPanel {

    private final RoundedTextField searchField;
    private final RoundedButton searchButton;

    public SearchBar() {

        setOpaque(false);
        setLayout(new BorderLayout(10, 0));

        searchField = new RoundedTextField(20);
        searchButton = new RoundedButton("Search");

        add(searchField, BorderLayout.CENTER);
        add(searchButton, BorderLayout.EAST);
    }

    public String getSearchText() {
        return searchField.getText().trim();
    }

    public void clear() {
        searchField.setText("");
    }

    public RoundedButton getSearchButton() {
        return searchButton;
    }

    public RoundedTextField getSearchField() {
        return searchField;
    }
}
