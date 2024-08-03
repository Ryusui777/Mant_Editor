package main.UI.Interfaces;

import java.awt.*;

public interface generalTools {
    int[] monitorSize = getMonitorSize();


    static int[] getMonitorSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        return new int[]{screenSize.width, screenSize.height};
    }

    static int getRatio(double ratio){
        return (int) (getMonitorSize()[0] * ratio);
    }

}
