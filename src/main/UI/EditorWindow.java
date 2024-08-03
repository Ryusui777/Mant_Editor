package main.UI;

import com.google.errorprone.annotations.Keep;
import main.UI.Interfaces.colorThemes;
import main.UI.Entities.MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class EditorWindow extends JFrame implements ActionListener, colorThemes, KeyListener {

    String appName = "Super Vole Interpreter";

    CodingSpace codeSpace = new CodingSpace();

    MenuBar menuBar = new MenuBar(this);

    EditorTerminal terminal = new EditorTerminal();

    public EditorWindow() {
        this.setTitle(appName);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setBackground(colorThemes.colorPalette.get("Default").get("BG"));
        this.add(codeSpace);

        this.add(this.menuBar);
        this.setVisible(true);
    }
    public void changeColorTheme(String newThemeName) {
       menuBar.changeTheme(newThemeName);
       codeSpace.changeTheme(newThemeName);
       terminal.changeTheme(newThemeName);
       terminal.printInTerminal("Color changed: " + newThemeName);
    }
    public void showTerminal(){
        terminal.showTerminal();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            terminal.printInTerminal("hello");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
