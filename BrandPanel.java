package mini12306.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

final class BrandPanel extends JPanel {
    BrandPanel(String headline, String description) {
        setOpaque(false);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(350, 520));
        setBorder(new EmptyBorder(34, 32, 34, 32));

        JPanel copy = new JPanel();
        copy.setOpaque(false);
        copy.setLayout(new BoxLayout(copy, BoxLayout.Y_AXIS));

        JLabel logo = new JLabel("Mini-12306");
        logo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 30));
        logo.setForeground(Color.WHITE);
        copy.add(logo);
        copy.add(Box.createVerticalStrut(12));

        JLabel title = new JLabel("<html>" + headline + "</html>");
        title.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        copy.add(title);
        copy.add(Box.createVerticalStrut(14));

        JLabel desc = new JLabel("<html><body style='line-height:1.45;width:250px'>" + description + "</body></html>");
        desc.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        desc.setForeground(new Color(229, 244, 255));
        copy.add(desc);
        copy.add(Box.createVerticalGlue());

        add(copy, BorderLayout.CENTER);

        JPanel stats = new JPanel(new GridLayout(1, 3, 10, 0));
        stats.setOpaque(false);
        stats.add(stat("实名", "认证"));
        stats.add(stat("在线", "购票"));
        stats.add(stat("便捷", "改签"));
        add(stats, BorderLayout.SOUTH);
    }

    private JPanel stat(String top, String bottom) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        JLabel t = new JLabel(top, SwingConstants.CENTER);
        t.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        t.setForeground(Color.WHITE);
        JLabel b = new JLabel(bottom, SwingConstants.CENTER);
        b.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
        b.setForeground(new Color(215, 240, 255));
        panel.add(t, BorderLayout.CENTER);
        panel.add(b, BorderLayout.SOUTH);
        return panel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        Mini12306Theme.setRendering(g2);
        int w = getWidth();
        int h = getHeight();
        g2.setPaint(new java.awt.GradientPaint(0, 0, Mini12306Theme.BLUE_DARK, w, h, Mini12306Theme.CYAN));
        g2.fillRoundRect(0, 0, w, h, 22, 22);
        g2.setColor(new Color(255, 255, 255, 42));
        g2.fillOval(w - 150, 30, 210, 210);
        g2.setColor(new Color(255, 255, 255, 25));
        g2.fillOval(-60, h - 170, 190, 190);
        g2.setColor(new Color(255, 255, 255, 60));
        g2.fillRoundRect(38, h - 126, w - 76, 1, 1, 1);
        g2.dispose();
        super.paintComponent(g);
    }
}
