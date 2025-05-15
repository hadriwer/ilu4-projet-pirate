package vue.ui.presentation.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author ember
 */
public class CustomJButton extends JButton {
    private Shape shape;
    private int round;
    private int radius;

    public void setBorderRadius(int radius) {
        this.radius = radius;
    }

    public int getBorderRadius() {
        return radius;
    }

    public CustomJButton() {
        super("");
        this.round = 15;
        setBackground(new Color(92, 64, 51, 153));
        setForeground(new Color(255, 255, 255));
        setOpaque(false);
        setFont(new Font("Verdana", Font.BOLD, 15));
        setFocusPainted(false);
        setUI(new BasicButtonUI());
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, round, round);
        super.paintComponent(g);

        final Graphics2D g1 = (Graphics2D) g;
        g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    // supprimer détection des clic en dehors du rond du bouton
    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1.0f, getHeight() - 1.0f, round, round);
        }

        return shape.contains(x, y);
    }
}
