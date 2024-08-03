package main.UI;

import main.UI.Interfaces.colorThemes;
import main.UI.Interfaces.generalTools;

import javax.swing.*;

public class EditorTerminal extends JFrame implements colorThemes {

    JTextArea textArea;
    {
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setForeground(colorThemes.colorPalette.get("Default").get("FontColor"));
        textArea.setFont(colorThemes.deafultCodeSpaceFont);
    }

    JScrollPane scrollPane;
    {
        scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBar(CodingSpace.getScrollBar(JScrollBar.HORIZONTAL));
        scrollPane.setVerticalScrollBar(CodingSpace.getScrollBar(JScrollBar.VERTICAL));
        scrollPane.getViewport().getView().setBackground(colorThemes.colorPalette.get("Default").get("codeSpace"));
    }

    public EditorTerminal() {

        setLocation(getX(), generalTools.getRatio(0.33));
        setSize(generalTools.getRatio(1), generalTools.getRatio(0.2));
        getContentPane().setBackground(colorThemes.colorPalette.get("Default").get("codeSpace"));
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setAlwaysOnTop(true);
        setTitle("Terminal");

        add(scrollPane);

        setVisible(false);

    }
    public void changeTheme(String colorTheme) {
        textArea.setForeground(colorPalette.get(colorTheme).get("FontColor"));
        scrollPane.getViewport().getView().setBackground(colorPalette.get(colorTheme).get("codeSpace"));
    }
    public void printInTerminal(String text){
        if(!isVisible()){
            setVisible(true);
        }
        textArea.append("\n");
        textArea.append(text);
    }

    public void showTerminal(){
        if (!isVisible()) {
            setVisible(true);
        }
        else{
            setVisible(false);
        }
    }
}
