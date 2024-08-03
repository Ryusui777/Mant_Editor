package main.UI.Entities;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class ScrollBar extends JScrollBar{

    public ScrollBar(Color thumbColor, Color trackColor, Color focusedThumb, int orientation) {
        super(orientation);
        setUI(new CustomScrollBarUI(thumbColor, trackColor, focusedThumb));
        this.setFocusable(true);
    }

    private static class CustomScrollBarUI extends BasicScrollBarUI {

        Color track;
        Color focusedThumb;
        Color thumb;
        public CustomScrollBarUI(Color thumbColor, Color trackColor, Color focusedThumb) {


            this.thumb = thumbColor;
            this.track = trackColor;
            this.focusedThumb = focusedThumb;
            configureScrollBarColors();
        }

       @Override
       protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
       }
       @Override
       protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
       }

       @Override
       protected void configureScrollBarColors(){
           this.thumbColor = thumb;
           this.trackColor = track;
       }

       private JButton createZeroButton(){
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            return button;
       }

       @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {

            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setPaint(thumbColor);
            g2d.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height,10,10);
            g2d.dispose();
       }
       @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Color color = trackColor != null ? trackColor : UIManager.getColor("ScrollBar.track");
            g2d.setPaint(color);
            g2d.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
            g2d.dispose();
       }

    }

}
