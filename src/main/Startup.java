package main;
import View.Login;
import com.formdev.flatlaf.FlatDarkLaf;

import java.util.Date;

public class Startup extends javax.swing.JFrame {
    public static void main(String[] args) {
        FlatDarkLaf.setup();
        Login login = new Login();

        System.out.println(new Date());
    }
}
