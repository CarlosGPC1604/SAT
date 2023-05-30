package View;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;

public class Login extends JFrame {
    private JPanel contentPanel;

    public Login() {
        FlatDarkLaf.setup();
        setContentPane(contentPanel);
        setTitle("Inicio de sesión");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
}
