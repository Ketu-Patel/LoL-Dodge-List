import javax.swing.*;

public class GUI1 {
    private JPanel panel1;
    private JTextField textField1;
    private JButton button1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new GUI1().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
