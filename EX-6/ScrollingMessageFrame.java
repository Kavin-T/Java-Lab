import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class ScrollingMessageFrame extends JFrame implements Runnable {
    private String message = "Department of Information Technology";
    private int xPos, yPos;
    private Font font = new Font("Arial", Font.BOLD, 24);
    private Color[] colors = {Color.RED, Color.BLUE, Color.GREEN};
    private volatile boolean isRunning = true;

    public ScrollingMessageFrame() {
        setTitle("Scrolling Message");
        setSize(600, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        xPos = 1;
        yPos = getHeight() / 2;
    }

    public void startScrolling() {
        Thread t = new Thread(this);
        t.start();
    }

    public void stopScrolling() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                for (Color color : colors) {
                    setFont(font);
                    setForeground(color);
                    Thread.sleep(200); // Control scrolling speed
                    repaint();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(java.awt.Graphics g) {
        super.paint(g);
        g.drawString(message, xPos, yPos);
        xPos += 3;
        if (xPos > getWidth()) {
            xPos = 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScrollingMessageFrame frame = new ScrollingMessageFrame();
            frame.setVisible(true);
            frame.startScrolling();
        });
    }
}
