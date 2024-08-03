package main.UI.Entities;
import main.UI.EditorWindow;
import main.UI.Interfaces.colorThemes;
import main.UI.Interfaces.generalTools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuBar extends JPanel {
    static int width = generalTools.getRatio(1);
    static int height = generalTools.getRatio(0.021);
    static int itemWidth = generalTools.getRatio(0.065);

    MenuTab fileTab;
    {
        JMenuItem newFile = getItem("New File");
        JMenuItem openFile = getItem("Open File");
        JMenuItem saveFile = getItem("Save File");
        JMenuItem[] fileItems = {newFile, openFile, saveFile};
        fileTab = new MenuTab("File", 0, 0, itemWidth, height, fileItems);
    }

    MenuTab themeTab;
    {
        JMenuItem barca = getItem("Barça");
        JMenuItem defaultTheme = getItem("Manta (Default)");
        JMenuItem[] themeItems = {defaultTheme, barca};
        themeTab = new MenuTab("Themes", itemWidth * 2, 0, itemWidth, height, themeItems);
    }

    MenuTab viewTab;
    {
        JMenuItem terminal = getItem("Terminal");
        JMenuItem[] viewItems = {terminal};
        viewTab = new MenuTab("View", itemWidth, 0, itemWidth, height, viewItems);
    }

    MenuTab runTab;
    {
       runTab = new MenuTab("Run", itemWidth*14, 0, itemWidth, height);
    }

    public MenuBar(EditorWindow window) {

            // Setup size, position, position and layout
            this.setLayout(null);
            this.setBounds(0, 0, width, height);
            this.setBackground(colorThemes.colorPalette.get("Default").get("MenuBar"));

            themeTab.items[0].addActionListener(e -> window.changeColorTheme("Default"));
            themeTab.items[1].addActionListener(e-> window.changeColorTheme("Barca"));

            viewTab.items[0].addActionListener(e -> window.showTerminal());
            // Adds all components to panel
            add(fileTab);
            add(runTab);
            add(themeTab);
            add(viewTab);

    }


    /** getItem()
     *
     * <p> Creates a JMenuItem with a hardcoded format to fit perfectly as
     * an item of a popup menu item, the only parameter is the text to be
     * assigned to the item </p>
     *
     * @param text is the text that is to be assigned to the item
     * @return A JMenuItem formatted with prefixed parameters
     * */
    private JMenuItem getItem(String text) {

        // Creates JMenuItem object
        JMenuItem item = new JMenuItem(text);

        // Sets Focusable value to false
        item.setFocusable(false);

        // Sets font to default Font form colorThemes interface
        item.setFont(colorThemes.defaultItemsFont);

        // Sets dimensions
        item.setPreferredSize(new Dimension(itemWidth, height));

        // Sets background color
        item.setBackground(colorThemes.colorPalette.get("Default").get("MenuBar").darker());

        // Sets font color
        item.setForeground(colorThemes.colorPalette.get("Default").get("FontColor"));

        return item;

    }

    public void changeTheme(String themeName) {

        setBackground(colorThemes.colorPalette.get(themeName).get("MenuBar"));

        themeTab.changeTheme(themeName);
        viewTab.changeTheme(themeName);
        fileTab.changeTheme(themeName);

    }

    /**
     * The {@code MenuTab}, extends javax.swing.JButton class, used to create a menu tab
     *
     * <p>This class's constructor creates a JButton object with some hardcoded parameters
     *    and other that must be provided to fit to this program necessities </p>
     *
     * @author David Orias
     * @version 1.0
     *
     * */

    public static class MenuTab extends JButton {
        JMenuItem[] items;

        /**
         * Constructs a {@code MenuTab} object with hardcoded, but editable parameters
         * and specified text, position, size, and the tab's items
         *
         * @param text The text for the menu tab
         * @param Px The x position of the tab
         * @param Py The y position of the tab
         * @param width The width of the tab
         * @param height The height of the tab
         * */

        public MenuTab(String text, int Px, int Py, int width, int height) {

            setText(text); // Sets tab text
            setFocusable(false); // Sets Focusable value to false
            setBounds(Px, Py, width, height); // Sets tabs position and size
            setFont(colorThemes.defaultItemsFont); // Sets tab's font
            setBackground(colorThemes.colorPalette.get("Default").get("MenuBar")); // Sets tab's background color
            setForeground(colorThemes.colorPalette.get("Default").get("FontColor")); // Sets tab's font color

        }

        /**
         * Constructs a {@code MenuTab} object with hardcoded, but editable parameters
         * and specified text, position, size, and the tab's items
         *
         * @param text The text for the menu tab
         * @param Px The x position of the tab
         * @param Py The y position of the tab
         * @param width The width of the tab
         * @param height The height of the tab
         * @param tabItems An array with tab's items
         * */

        public MenuTab(String text, int Px, int Py, int width, int height, JMenuItem[] tabItems) {
            this.items = tabItems; // Sets attribute items

            setText(text); // Sets tab text
            setFocusable(false); // Sets Focusable value to false
            setBounds(Px, Py, width, height); // Sets tabs position and size
            setFont(colorThemes.defaultItemsFont); // Sets tab's font
            setBackground(colorThemes.colorPalette.get("Default").get("MenuBar")); // Sets tab's background color
            setForeground(colorThemes.colorPalette.get("Default").get("FontColor")); // Sets tab's font color

            MenuTab invoker = this; // invoker to use with mouseMotionListener

            JPopupMenu popupMenu = new JPopupMenu(); // Creates the popup menu object
            // Sets the attribute items
            for (JMenuItem item : items) {
                popupMenu.add(item);
            }
            addActionListener(e -> popupMenu.show(invoker, 0, height));
            // Add a MouseListener to the tab
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    popupMenu.show(invoker,0, getY() + getHeight());
                }
                @Override
                public void mouseExited(MouseEvent e) {

                    if(!popupMenu.getBounds().contains(e.getPoint())){
                        popupMenu.setVisible(false);
                    }
                }
            });
        }

        public void changeTheme(String themeName) {

            setBackground(colorThemes.colorPalette.get(themeName).get("MenuBar"));
            setForeground(colorThemes.colorPalette.get(themeName).get("FontColor"));

            for (JMenuItem item : items) {
                item.setForeground(colorThemes.colorPalette.get(themeName).get("FontColor"));
                item.setBackground(colorThemes.colorPalette.get(themeName).get("MenuBar"));
            }

        }
    }

}
