package mini12306.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public final class Mini12306App {
    private Mini12306App() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            setupLookAndFeel();
            JFrame frame = new JFrame("Mini-12306 登录与注册");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setMinimumSize(new Dimension(920, 620));

            JPanel page = Mini12306Theme.page();
            JPanel cards = new JPanel(new CardLayout());
            CardLayout cardLayout = (CardLayout) cards.getLayout();
            cards.setOpaque(false);
            cards.add(new LoginPanel(() -> cardLayout.show(cards, "register")), "login");
            cards.add(new RegisterPanel(() -> cardLayout.show(cards, "login")), "register");
            page.add(cards, BorderLayout.CENTER);

            frame.setContentPane(page);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    static void setupLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ignored) {
            UIManager.put("Label.font", Mini12306Theme.LABEL_FONT);
        }
    }
}
