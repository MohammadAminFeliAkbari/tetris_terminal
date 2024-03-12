import javax.swing.*;
import java.awt.*;

public class NewClass extends JFrame {
    public static void main(String[] args) {
        JFrame panel = new JFrame();
        panel.setTitle("Drawing Matrix");
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setSize(400, 400);

        MatrixPanel matrixPanel = new MatrixPanel();
        
        panel.add(matrixPanel);

        panel.setVisible(true);
    }
}

class MatrixPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int rows = 5;
        int cols = 5;

        int cellWidth = getWidth() / cols;
        int cellHeight = getHeight() / rows;

        g.setColor(Color.BLACK);

        // رسم خطوط افقی
        for (int i = 1; i < cols; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, getHeight());
        }

        // رسم خطوط عمودی
        for (int i = 1; i < rows; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, getWidth(), y);
        }
    }
}