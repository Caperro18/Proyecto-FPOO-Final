import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Conexion_base_de_datos extends JFrame {
    private JTextField userField;
    private JPasswordField passField;

    public ConexionBaseDeDatos() {
        setTitle("Inicio de Sesión");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel userLabel = new JLabel("Usuario:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(userLabel, gbc);

        userField = new JTextField(15);
        gbc.gridx = 1;
        add(userField, gbc);

        JLabel passLabel = new JLabel("Contraseña:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passLabel, gbc);

        passField = new JPasswordField(15);
        gbc.gridx = 1;
        add(passField, gbc);

        JButton loginButton = new JButton("Iniciar Sesión");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(loginButton, gbc);

        loginButton.addActionListener(e -> authenticate(userField.getText(), new String(passField.getPassword())));

        setVisible(true);
    }

    private void authenticate(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            return;
        }

        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=PuntoDeVenta;user=sa;password=1234;";

        try (Connection con = DriverManager.getConnection(connectionUrl);
             PreparedStatement pst = con.prepareStatement("SELECT RolID FROM Usuarios WHERE Nombre = ? AND Contrasena = ?")) {

            pst.setString(1, username);
            pst.setString(2, password);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int role = rs.getInt("RolID");
                    JOptionPane.showMessageDialog(this, role == 1 ? "Bienvenido Administrador." : "Bienvenido Usuario.");
                    // Carga del menú correspondiente
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Conexion_base_de_datos::new);
    }
}
