import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author Daniel Andrade
 * @see Swing2.Swing
 * @see Swing2.Conexao
 */
public class Aluno {
    private String Cpf;
    private String Matricula;
    private String Nome;

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void gravar() {

        Connection conexao = Conexao.getConexao();
        String sql = "insert into alunos (cpf, matricula, nome) values (?, ?, ?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, Cpf);
            ps.setString(2, Matricula);
            ps.setString(3, Nome);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Gravado com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar");
        }
    }

    public void consultar() {
        Connection conexao = Conexao.getConexao();
        String sql = "select * from alunos where cpf = ? and matricula = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, Cpf);
            ps.setString(2, Matricula);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Nome = rs.getString("nome");
                Cpf = rs.getString("cpf");
                Matricula = rs.getString("matricula");

            } else {
                JOptionPane.showMessageDialog(null, "Não encontrado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }

    }

    public void limpar() {
        Cpf = "";
        Matricula = "";
        Nome = "";
    }

    public void alterar() {
        Connection conexao = Conexao.getConexao();
        String sql = "update alunos set nome = ? where cpf = ? and matricula = ?";
        String sql2 = "update alunos set cpf = ? where nome = ? and matricula = ?";
        String sql3 = "update alunos set matricula = ? where cpf = ? and nome = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            PreparedStatement ps2 = conexao.prepareStatement(sql2);
            PreparedStatement ps3 = conexao.prepareStatement(sql3);
            ps.setString(1, Nome);
            ps.setString(2, Cpf);
            ps.setString(3, Matricula);
            ps.execute();
            ps2.setString(1, Cpf);
            ps2.setString(2, Nome);
            ps2.setString(3, Matricula);
            ps2.execute();
            ps3.setString(1, Cpf);
            ps3.setString(2, Nome);
            ps3.setString(3, Matricula);
            ps3.execute();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar");
        }
    }

    public void excluir() {
        Connection conexao = Conexao.getConexao();
        String sql = "delete from alunos where cpf = ? and matricula = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, Cpf);
            ps.setString(2, Matricula);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir");
        }
    }

}
