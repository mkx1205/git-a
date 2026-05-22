package mini12306.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public final class ScreenshotExporter {
    private ScreenshotExporter() {
    }

    public static void main(String[] args) throws Exception {
        Mini12306App.setupLookAndFeel();
        File outputDir = new File("output/screenshots");
        if (!outputDir.exists() && !outputDir.mkdirs()) {
            throw new IllegalStateException("Cannot create output directory: " + outputDir);
        }

        SwingUtilities.invokeAndWait(() -> {
            try {
                export("login.png", new LoginPanel());
                export("register.png", new RegisterPanel());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private static void export(String filename, JPanel content) throws Exception {
        JPanel page = Mini12306Theme.page();
        page.setLayout(new BorderLayout());
        page.add(content, BorderLayout.CENTER);
        page.setSize(new Dimension(960, 640));
        page.doLayout();
        layoutChildren(page);

        BufferedImage image = new BufferedImage(960, 640, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        Mini12306Theme.setRendering(g2);
        page.paint(g2);
        g2.dispose();

        ImageIO.write(image, "png", new File("output/screenshots", filename));
    }

    private static void layoutChildren(java.awt.Container container) {
        container.doLayout();
        for (java.awt.Component child : container.getComponents()) {
            if (child instanceof java.awt.Container childContainer) {
                layoutChildren(childContainer);
            }
        }
    }
}
