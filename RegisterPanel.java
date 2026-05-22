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

public final class RegisterPanel extends JPanel {
    public RegisterPanel() {
        this(null);
    }

    public RegisterPanel(Runnable onBackToLogin) {
        setLayout(new BorderLayout(26, 0));
        setOpaque(false);

        add(new BrandPanel("实名注册，完成在线票务认证",
                "根据 Mini-12306 业务要求，旅客需提供身份、手机号和银行卡等信息成为合法用户。"), BorderLayout.WEST);
        add(formCard(onBackToLogin), BorderLayout.CENTER);
    }

    private JPanel formCard(Runnable onBackToLogin) {
        JPanel card = Mini12306Theme.card();

        JPanel form = new JPanel(new GridBagLayout());
        form.setOpaque(false);
        form.setBorder(new EmptyBorder(0, 10, 0, 10));

        JPanel header = new JPanel();
        header.setOpaque(false);
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        JLabel badge = Mini12306Theme.badge("实名注册");
        badge.setAlignmentX(LEFT_ALIGNMENT);
        header.add(badge);
        header.add(Box.createVerticalStrut(12));
        JLabel title = Mini12306Theme.title("创建旅客账号");
        title.setAlignmentX(LEFT_ALIGNMENT);
        header.add(title);
        header.add(Box.createVerticalStrut(8));
        JLabel subtitle = Mini12306Theme.subtitle("请填写真实信息，用于后续购票、退票和改签。");
        subtitle.setAlignmentX(LEFT_ALIGNMENT);
        header.add(subtitle);
        form.add(header, Mini12306Theme.gbc(0, 0));

        form.add(Mini12306Theme.label("真实姓名"), Mini12306Theme.gbc(0, 1));
        form.add(Mini12306Theme.textField("请输入旅客姓名"), Mini12306Theme.gbc(0, 2));

        form.add(Mini12306Theme.label("身份证号码"), Mini12306Theme.gbc(0, 3));
        JTextField idCard = Mini12306Theme.textField("请输入 18 位身份证号码");
        form.add(idCard, Mini12306Theme.gbc(0, 4));

        form.add(Mini12306Theme.label("手机号码"), Mini12306Theme.gbc(0, 5));
        form.add(Mini12306Theme.textField("请输入常用手机号"), Mini12306Theme.gbc(0, 6));

        form.add(Mini12306Theme.label("银行卡号"), Mini12306Theme.gbc(0, 7));
        form.add(Mini12306Theme.textField("用于在线支付与退款"), Mini12306Theme.gbc(0, 8));

        form.add(Mini12306Theme.label("设置密码"), Mini12306Theme.gbc(0, 9));
        form.add(Mini12306Theme.passwordField("请设置登录密码"), Mini12306Theme.gbc(0, 10));

        JCheckBox agree = new JCheckBox("我已阅读并同意实名购票服务协议");
        agree.setOpaque(false);
        agree.setFont(Mini12306Theme.LABEL_FONT);
        agree.setForeground(Mini12306Theme.MUTED);
        form.add(agree, Mini12306Theme.gbc(0, 11));

        JButton register = Mini12306Theme.primaryButton("完成注册");
        form.add(register, Mini12306Theme.gbc(0, 12));

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        footer.setOpaque(false);
        footer.add(Mini12306Theme.subtitle("已有账号？"));
        JButton back = Mini12306Theme.secondaryButton("返回登录");
        if (onBackToLogin != null) {
            back.addActionListener(event -> onBackToLogin.run());
        }
        footer.add(back);
        form.add(footer, Mini12306Theme.gbc(0, 13));

        card.add(form, BorderLayout.CENTER);
        return card;
    }
}
