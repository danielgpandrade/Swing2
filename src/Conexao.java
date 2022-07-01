import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    private static Connection conexao;

    public static Connection getConexao() {
        if (conexao == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexao = DriverManager.getConnection("jdbc:mysql://localhost/danielandrade", "root", "");
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Driver não encontrado");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados");
            }
        }
        return conexao;

    }
}