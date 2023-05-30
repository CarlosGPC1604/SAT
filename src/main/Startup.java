package main;
import View.Login;
import com.formdev.flatlaf.FlatDarkLaf;

public class Startup extends javax.swing.JFrame {
    public static void main(String[] args) {
        FlatDarkLaf.setup();
        Login login = new Login();
        login.setVisible(true);
    }
}
