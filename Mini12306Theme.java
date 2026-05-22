package mini12306.ui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

final class Mini12306Theme {
    static final Color BLUE = new Color(35, 112, 220);
    static final Color BLUE_DARK = new Color(22, 83, 172);
    static final Color SKY = new Color(231, 242, 255);
    static final Color CYAN = new Color(41, 184, 214);
    static final Color GREEN = new Color(44, 178, 126);
    static final Color TEXT = new Color(31, 41, 55);
    static final Color MUTED = new Color(100, 116, 139);
    static final Color LINE = new Color(212, 222, 235);
    static final Color PAGE = new Color(244, 248, 252);
    static final Color CARD = new Color(255, 255, 255);

    static final Font TITLE_FONT = new Font("Microsoft YaHei UI", Font.BOLD, 28);
    static final Font SUBTITLE_FONT = new Font("Microsoft YaHei UI", Font.PLAIN, 14);
    static final Font LABEL_FONT = new Font("Microsoft YaHei UI", Font.PLAIN, 13);
    static final Font INPUT_FONT = new Font("Microsoft YaHei UI", Font.PLAIN, 15);
    static final Font BUTTON_FONT = new Font("Microsoft YaHei UI", Font.BOLD, 15);

    private Mini12306Theme() {
    }

    static JPanel page() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(PAGE);
        panel.setBorder(new EmptyBorder(28, 34, 28, 34));
        return panel;
    }

    static JPanel card() {
        JPanel panel = new RoundedPanel(CARD, 18);
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(30, 34, 30, 34));
        return panel;
    }

    static JLabel title(String text) {
        JLabel label = new JLabel(text);
        label.setFont(TITLE_FONT);
        label.setForeground(TEXT);
        return label;
    }

    static JLabel subtitle(String text) {
        JLabel label = new JLabel(text);
        label.setFont(SUBTITLE_FONT);
        label.setForeground(MUTED);
        return label;
    }

    static JLabel label(String text) {
        JLabel label = new JLabel(text);
        label.setFont(LABEL_FONT);
        label.setForeground(TEXT);
        return label;
    }

    static JLabel badge(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(SKY);
        label.setForeground(BLUE_DARK);
        label.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        label.setBorder(new EmptyBorder(6, 12, 6, 12));
        return label;
    }

    static JTextField textField(String placeholder) {
        JTextField field = new JTextField(placeholder);
        field.setFont(INPUT_FONT);
        field.setForeground(MUTED);
        field.setCaretColor(BLUE);
        field.setPreferredSize(new Dimension(280, 42));
        field.setBorder(new RoundBorder(LINE, 12, new Insets(9, 12, 9, 12)));
        field.setBackground(Color.WHITE);
        return field;
    }

    static JPasswordField passwordField(String placeholder) {
        JPasswordField field = new JPasswordField(placeholder);
        field.setFont(INPUT_FONT);
        field.setForeground(MUTED);
        field.setCaretColor(BLUE);
        field.setEchoChar((char) 0);
        field.setPreferredSize(new Dimension(280, 42));
        field.setBorder(new RoundBorder(LINE, 12, new Insets(9, 12, 9, 12)));
        field.setBackground(Color.WHITE);
        return field;
    }

    static JButton primaryButton(String text) {
        JButton button = new RoundedButton(text, BLUE, BLUE_DARK, Color.WHITE);
        button.setPreferredSize(new Dimension(280, 44));
        return button;
    }

    static JButton secondaryButton(String text) {
        JButton button = new RoundedButton(text, new Color(239, 246, 255), new Color(219, 234, 254), BLUE_DARK);
        button.setPreferredSize(new Dimension(150, 38));
        return button;
    }

    static GridBagConstraints gbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(6, 0, 6, 0);
        gbc.weightx = 1;
        return gbc;
    }

    static void setRendering(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }

    private static final class RoundedPanel extends JPanel {
        private final Color color;
        private final int radius;

        RoundedPanel(Color color, int radius) {
            this.color = color;
            this.radius = radius;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            setRendering(g2);
            g2.setColor(new Color(16, 24, 40, 18));
            g2.fillRoundRect(4, 6, getWidth() - 8, getHeight() - 8, radius + 4, radius + 4);
            g2.setColor(color);
            g2.fillRoundRect(0, 0, getWidth() - 8, getHeight() - 10, radius, radius);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    private static final class RoundedButton extends JButton {
        private final Color normal;
        private final Color hover;
        private final Color textColor;
        private boolean hovering;

        RoundedButton(String text, Color normal, Color hover, Color textColor) {
            super(text);
            this.normal = normal;
            this.hover = hover;
            this.textColor = textColor;
            setFont(BUTTON_FONT);
            setForeground(textColor);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            setBorder(new EmptyBorder(10, 16, 10, 16));
            addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    hovering = true;
                    repaint();
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    hovering = false;
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            setRendering(g2);
            g2.setColor(hovering ? hover : normal);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
            g2.dispose();
            setForeground(textColor);
            super.paintComponent(g);
        }
    }

    private static final class RoundBorder extends AbstractBorder {
        private final Color color;
        private final int radius;
        private final Insets insets;

        RoundBorder(Color color, int radius, Insets insets) {
            this.color = color;
            this.radius = radius;
            this.insets = insets;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            setRendering(g2);
            g2.setColor(color);
            g2.setStroke(new BasicStroke(1.2f));
            Shape border = new RoundRectangle2D.Double(x + 0.5, y + 0.5, width - 1, height - 1, radius, radius);
            g2.draw(border);
            g2.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return insets;
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.top = this.insets.top;
            insets.left = this.insets.left;
            insets.bottom = this.insets.bottom;
            insets.right = this.insets.right;
            return insets;
        }
    }

    static void removeDefaultBorder(JComponent component) {
        component.setBorder(BorderFactory.createEmptyBorder());
    }
}
