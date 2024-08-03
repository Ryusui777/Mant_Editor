package main.UI.Interfaces;

import java.awt.*;
import java.util.HashMap;
public interface colorThemes {

      Font deafultCodeSpaceFont = new Font("Comic Sans", Font.PLAIN, generalTools.getRatio(0.017));
      Font defaultItemsFont = new Font("Arial", Font.BOLD, generalTools.getRatio(0.01));

      String[] hexValues = {"1", "2", "3", "4", "5", "6", "7", "8",
              "9", "A", "B", "C", "D", "E", "F"};

      HashMap<String, HashMap<String, Color>> colorPalette = getColorPalette();

     static HashMap<String, HashMap<String, Color>> getColorPalette() {
          HashMap<String, HashMap<String, Color>> colorPalette = new HashMap<>();
          colorPalette.put("Default", getDefault());
          colorPalette.put("Barca", getBarca());
          return colorPalette;
      }

      static HashMap<String, Color> getBarca(){

          HashMap<String, Color> barca = new HashMap<>();
          barca.put("BG", new Color(0x12086F));
          barca.put("FontColor", new Color(0xFFFFFF));
          barca.put("Thumb", new Color(255,255,255, 100));
          barca.put("BorderColor", new Color(0xEDBB00));
          barca.put("FocusedThumb", new Color(255,255,255, 220));
          barca.put("Register1", new Color(0xEDBB00));
          barca.put("Register2", new Color(0xA50044));
          barca.put("MenuBar", new Color(0xDB0030));
          barca.put("codeSpace", new Color(0x12085F));
          barca.put("Alternative", new Color(0x0000000));

          return barca;

      }

      static HashMap<String, Color> getDefault(){

         HashMap<String, Color> defaults = new HashMap<>();
         defaults.put("BG", new Color(0x030057));
         defaults.put("FontColor", new Color(0x00F8EE));
         defaults.put("Thumb", new Color(0,249,255, 180));
         defaults.put("BorderColor", new Color(0x0900FF));
         defaults.put("FocusedThumb", new Color(255,255,255, 220));
         defaults.put("Register1", new Color(0x12));
         defaults.put("Register2", new Color(0xA50044));
         defaults.put("MenuBar", new Color(0x0900FF));
         defaults.put("codeSpace", new Color(3, 20, 86));
         return defaults;

      }


}
