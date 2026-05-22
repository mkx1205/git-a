package mini12306.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public final class LoginPanel extends JPanel {
    public LoginPanel() {
        this(null);
    }

    public LoginPanel(Runnable onRegister) {
        setLayout(new BorderLayout(26, 0));
        setOpaque(false);

        add(new BrandPanel("安全登录，开启便捷铁路出行",
                "查询车次、在线购票、退票改签，一站式处理旅客出行中的核心票务需求。"), BorderLayout.WEST);
        add(formCard(onRegister), BorderLayout.CENTER);
    }

    private JPanel formCard(Runnable onRegister) {
        JPanel card = Mini12306Theme.card();

        JPanel form = new JPanel(new GridBagLayout());
        form.setOpaque(false);
        form.setBorder(new EmptyBorder(4, 10, 0, 10));

        JPanel header = new JPanel();
        header.setOpaque(false);
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        JLabel badge = Mini12306Theme.badge("旅客服务平台");
        badge.setAlignmentX(LEFT_ALIGNMENT);
        header.add(badge);
        header.add(Box.createVerticalStrut(16));
        JLabel title = Mini12306Theme.title("欢迎登录");
        title.setAlignmentX(LEFT_ALIGNMENT);
        header.add(title);
        header.add(Box.createVerticalStrut(8));
        JLabel subtitle = Mini12306Theme.subtitle("请输入账号信息，进入 Mini-12306 在线车票系统。");
        subtitle.setAlignmentX(LEFT_ALIGNMENT);
        header.add(subtitle);
        form.add(header, Mini12306Theme.gbc(0, 0));

        form.add(Mini12306Theme.label("手机号 / 用户名"), Mini12306Theme.gbc(0, 1));
        JTextField account = Mini12306Theme.textField("请输入手机号或用户名");
        form.add(account, Mini12306Theme.gbc(0, 2));

        form.add(Mini12306Theme.label("登录密码"), Mini12306Theme.gbc(0, 3));
        form.add(Mini12306Theme.passwordField("请输入登录密码"), Mini12306Theme.gbc(0, 4));

        JPanel options = new JPanel(new BorderLayout());
        options.setOpaque(false);
        JCheckBox remember = new JCheckBox("记住账号");
        remember.setOpaque(false);
        remember.setForeground(Mini12306Theme.MUTED);
        remember.setFont(Mini12306Theme.LABEL_FONT);
        JLabel forgot = new JLabel("忘记密码？");
        forgot.setFont(Mini12306Theme.LABEL_FONT);
        forgot.setForeground(Mini12306Theme.BLUE);
        options.add(remember, BorderLayout.WEST);
        options.add(forgot, BorderLayout.EAST);
        form.add(options, Mini12306Theme.gbc(0, 5));

        JButton login = Mini12306Theme.primaryButton("登录");
        form.add(login, Mini12306Theme.gbc(0, 6));

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        footer.setOpaque(false);
        footer.add(Mini12306Theme.subtitle("还没有账号？"));
        JButton register = Mini12306Theme.secondaryButton("立即注册");
        if (onRegister != null) {
            register.addActionListener(event -> onRegister.run());
        }
        footer.add(register);
        form.add(footer, Mini12306Theme.gbc(0, 7));

        card.add(form, BorderLayout.CENTER);
        return card;
    }
}
