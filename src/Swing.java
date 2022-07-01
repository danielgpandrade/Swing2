import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Swing {
    public static void main(String[] args) {
        // Define a janela
        JFrame janela = new JFrame("Cadastro de alunos"); // Janela Normal
        janela.setResizable(false); // A janela não poderá ter o tamanho ajustado
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janela.setSize(450, 300); // Define tamanho da janela
        // Define o layout da janela
        Container caixa = janela.getContentPane();
        caixa.setLayout(null);
        // Define os labels dos campos
        JLabel labelCPF = new JLabel("CPF: ");
        JLabel labelMatricula = new JLabel("Matricula: ");
        JLabel labelNome = new JLabel("Nome: ");
        // Posiciona os labels na janela
        labelCPF.setBounds(50, 40, 100, 20); // coluna, linha, largura, tamanho
        labelMatricula.setBounds(50, 80, 150, 20); // coluna, linha, largura, tamanho
        labelNome.setBounds(50, 120, 100, 20); // coluna, linha, largura, tamanho
        // Define os input box
        JTextField jTextCPF = new JTextField();
        JTextField jTextMatricula = new JTextField();
        JTextField jTextNome = new JTextField();
        // Define se os campos est�o habilitados ou n�o no in�cio
        jTextCPF.setEnabled(true);
        jTextMatricula.setEnabled(false);
        jTextNome.setEnabled(false);
        // Posiciona os input box
        jTextCPF.setBounds(180, 40, 90, 20);
        jTextMatricula.setBounds(180, 80, 90, 20);
        jTextNome.setBounds(180, 120, 150, 20);
        // Adiciona os r�tulos e os input box na janela
        janela.add(labelCPF);
        janela.add(labelMatricula);
        janela.add(labelNome);
        janela.add(jTextCPF);
        janela.add(jTextMatricula);
        janela.add(jTextNome);
        // Define bot�es e a localiza��o deles na janela
        JButton botaoGravar = new JButton("Gravar");
        botaoGravar.setBounds(50, 160, 100, 20);
        janela.add(botaoGravar);
        JButton botaoConsultar = new JButton("Consultar nome");
        botaoConsultar.setBounds(180, 160, 130, 20);
        janela.add(botaoConsultar);
        JButton botaoLimpar = new JButton("Limpar");
        botaoLimpar.setBounds(320, 160, 100, 20);
        janela.add(botaoLimpar);
        JButton botaoAlterar = new JButton("Alterar nome");
        botaoAlterar.setBounds(50, 200, 130, 20);
        janela.add(botaoAlterar);
        JButton botaoExcluir = new JButton("Excluir");
        botaoExcluir.setBounds(190, 200, 100, 20);
        janela.add(botaoExcluir);
        // Define objeto para pesquisar no banco de dados
        Aluno aluno = new Aluno();
        // Define acoes dos botoes
        botaoGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Pega os valores dos campos
                aluno.setCpf(jTextCPF.getText());
                aluno.setMatricula(jTextMatricula.getText());
                aluno.setNome(jTextNome.getText());
                // Chama o m�todo para gravar no banco de dados
                aluno.gravar();
                // Limpa os campos
                jTextCPF.setText("");
                jTextMatricula.setText("");
                jTextNome.setText("");
            }
        });

        botaoConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Pega os valores dos campos
                aluno.setCpf(jTextCPF.getText());
                aluno.setMatricula(jTextMatricula.getText());
                aluno.setNome(jTextNome.getText());
                // Chama o m�todo para consultar no banco de dados
                aluno.consultar();
                // Preenche os campos com os dados do banco de dados
                jTextCPF.setText(aluno.getCpf());
                jTextMatricula.setText(aluno.getMatricula());
                jTextNome.setText(aluno.getNome());
            }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Limpa os campos
                jTextCPF.setText("");
                jTextMatricula.setText("");
                jTextNome.setText("");
            }
        });

        botaoAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Pega os valores dos campos
                aluno.setCpf(jTextCPF.getText());
                aluno.setMatricula(jTextMatricula.getText());
                aluno.setNome(jTextNome.getText());
                // Chama o m�todo para alterar no banco de dados
                aluno.alterar();
                // Limpa os campos
                jTextCPF.setText("");
                jTextMatricula.setText("");
                jTextNome.setText("");
            }
        });

        botaoExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Pega os valores dos campos
                aluno.setCpf(jTextCPF.getText());
                aluno.setMatricula(jTextMatricula.getText());
                aluno.setNome(jTextNome.getText());
                // Chama o m�todo para excluir no banco de dados
                aluno.excluir();
                // Limpa os campos
                jTextCPF.setText("");
                jTextMatricula.setText("");
                jTextNome.setText("");
            }
        });

        // Apresenta a janela
        janela.setVisible(true);

        // Fazer com que Matrícula só seja preenchível após CPF estar preenchido
        jTextCPF.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (jTextCPF.getText().length() == 11) {
                    jTextMatricula.setEnabled(true);
                } else {
                    jTextMatricula.setEnabled(false);
                }
            }
        });
        // Fazer com que Nome só seja preenchível após Matrícula estar preenchido
        jTextMatricula.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (jTextMatricula.getText().length() == 6) {
                    jTextNome.setEnabled(true);
                } else {
                    jTextNome.setEnabled(false);
                }
            }
        });
        // Inserir texto no campo de resposta matrícula
        jTextMatricula.setText("6 dígitos");

    }
}