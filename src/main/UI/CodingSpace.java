package main.UI;
import main.UI.Interfaces.colorThemes;
import main.UI.Interfaces.generalTools;
import com.google.gson.Gson;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CodingSpace extends JScrollPane implements colorThemes {

    JTextArea textArea;
    {
        textArea = new JTextArea();
        textArea.setBackground(colorPalette.get("Default").get("codeSpace"));
        textArea.setFont(colorThemes.deafultCodeSpaceFont);
        textArea.setForeground(colorThemes.colorPalette.get("Default").get("FontColor"));
        textArea.setCaretColor(colorThemes.colorPalette.get("Default").get("FontColor"));
    }

    public CodingSpace() {

        // Creates Border
        Border border = BorderFactory.createLineBorder(colorPalette.get("Default").get("BorderColor"), generalTools.getRatio(0.002));

        // Sets textArea as view port
        setViewportView(textArea);

        // Sets position and size
        setBounds(generalTools.getRatio(0.02), generalTools.getRatio(0.04),
                generalTools.getRatio(0.96), generalTools.getRatio(0.45));

        // Sets a custom scrollbar 'cause the default sucks
        setHorizontalScrollBar(getScrollBar(JScrollBar.HORIZONTAL));
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setVerticalScrollBar(getScrollBar(JScrollBar.VERTICAL));
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Sets background color
        getViewport().getView().setBackground(colorThemes.colorPalette.get("Default").get("codeSpace"));
        getViewport().setOpaque(true);

        // Sets border
        setBorder(border);
        setVisible(true);

    }

    static main.UI.Entities.ScrollBar getScrollBar(int orientation){
        return new main.UI.Entities.ScrollBar(colorThemes.colorPalette.get("Default").get("Thumb"),
                colorThemes.colorPalette.get("Default").get("codeSpace"),colorThemes.colorPalette.get("Barca").get("FocusedThumb"), orientation);
    }

    public void changeTheme(String themeName){

        textArea.setForeground(colorThemes.colorPalette.get(themeName).get("FontColor"));
        getViewport().getView().setBackground(colorThemes.colorPalette.get(themeName).get("codeSpace"));
        setBorder(BorderFactory.createLineBorder(colorPalette.get(themeName).get("BorderColor"), generalTools.getRatio(0.0015)));

    }
}
