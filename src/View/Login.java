package View;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;

public class Login extends JFrame {
    private JPanel contentPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton iniciarSesiónButton;
    private JProgressBar progressBar1;

    public Login() {
        FlatDarkLaf.setup();
        setContentPane(contentPanel);
        setTitle("Inicio de sesión");
        setSize(300, 170);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
