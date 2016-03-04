package br.estacio.poo.historicoacademico.util;

import br.estacio.poo.historicoacademico.frames.FrameCadastroAluno;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 * Projeto de Histórico Acadêmico
 * Atividade Estruturada - 2015.2
 * Programação Orientada a Objetos - Estácio|FIC
 * @author Matheus Braga
 */
public class CalculaIdade extends JDialog {
    
    private JLabel lblAnoAtual;
    private JLabel lblAnoNasc;
    private JLabel lblIdadeCalculada;
    private JTextField txtAnoAtual;
    private JTextField txtAnoNasc;
    private JTextField txtIdadeCalculada;
    private JButton btnCalcular;
    private JButton btnFechar;
    private JPanel pnlBotoes[] = new JPanel[2];
    private JPanel pnlTextFields[] = new JPanel[3];
    private int anoAtual;
    private FrameCadastroAluno frameAluno = null;
              
    public CalculaIdade(FrameCadastroAluno fa) {
        setTitle("Calcular Idade");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(330, 230);
        setLocationRelativeTo(fa);
        setLayout(new GridLayout(4, 4, 15, 15));
        setModal(true);
        getContentPane().setBackground(new Color(230,230,250));
        frameAluno = fa;
        
        startComponents();
        startEvents();
        
        this.setVisible(true);
    }
    
    private void startComponents() {
        lblAnoAtual = new JLabel("Ano Atual: ", JLabel.RIGHT);
        lblAnoNasc = new JLabel("Ano de Nascimento: ", JLabel.RIGHT);
        lblIdadeCalculada = new JLabel("Idade Calculada: ", JLabel.RIGHT);
        txtAnoAtual = new JTextField(5);
        txtAnoNasc = new JTextField(5);
        txtIdadeCalculada = new JTextField(5);
        btnCalcular = new JButton("Calcular");
        btnFechar = new JButton("Fechar");
        
        //Configurando o layout dos botões
        btnCalcular.setBackground(new Color(105,105,105));
        btnCalcular.setFont(new Font("sans-serif", Font.BOLD, 15));
        btnCalcular.setForeground(new Color(0,0,255));
        
        btnFechar.setBackground(new Color(105,105,105));
        btnFechar.setFont(new Font("sans-serif", Font.BOLD, 15));
        btnFechar.setForeground(new Color(0,0,255));
        
        //Pegando o ano atual do sistema
        Calendar cal = Calendar.getInstance();
        anoAtual = cal.get(Calendar.YEAR);
        
        //Setando o ano atual
        txtAnoAtual.setText(String.valueOf(anoAtual));
        txtAnoAtual.setEditable(false);
        
        //Adicionando os botões a painéis
        for(int i = 0; i < pnlBotoes.length; i++) {
            if(i == 1) {
                pnlBotoes[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
                pnlBotoes[i].setBackground(new Color(230,230,250));
                pnlBotoes[i].add(btnFechar);
                break;
            }
            
            pnlBotoes[i] = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            pnlBotoes[i].setBackground(new Color(230,230,250));
            pnlBotoes[i].add(btnCalcular);  
        } 
        
        //Adicioando os JTextFields a painéis
        for(int i = 0; i < pnlTextFields.length; i++) {
            pnlTextFields[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
            pnlTextFields[i].setBackground(new Color(230,230,250));
            switch(i) {
                case 0:
                    pnlTextFields[i].add(txtAnoAtual);
                    break;
                case 1:
                    pnlTextFields[i].add(txtAnoNasc);
                    break;
                    
                case 2:
                    txtIdadeCalculada.setEditable(false);
                    pnlTextFields[i].add(txtIdadeCalculada);
                    break;
            }

        }
        
        //Adicionando os componentes ao contentPane do Frame
        this.add(lblAnoAtual);
        this.add(pnlTextFields[0]);
        this.add(lblAnoNasc);
        this.add(pnlTextFields[1]);
        this.add(pnlBotoes[0]);
        this.add(pnlBotoes[1]);
        this.add(lblIdadeCalculada);
        this.add(pnlTextFields[2]); 
    }
    
    public void buttonCalcular() {
        int anoNasc = 0;
        int idade = 0;
        try {
            anoNasc = Integer.parseInt(txtAnoNasc.getText());
            idade = anoAtual - anoNasc;
            if((anoNasc <= 0 || anoNasc > anoAtual) || (idade < 16 || idade > 120)) 
                throw new IllegalArgumentException();
            else 
                txtIdadeCalculada.setText(String.valueOf(idade));
        } 
        catch (NumberFormatException numberException) {
            if(txtAnoNasc.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Informe o Ano de Nascimento!", "Ano de Nascimento Inválido", JOptionPane.ERROR_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Digite Apenas Números!", "Ano de Nascimento Inválido", JOptionPane.ERROR_MESSAGE);
        } 
        catch (IllegalArgumentException AnoInvalidoException) {
            if(anoNasc <= 0)
                JOptionPane.showMessageDialog(this, "O ano de nascimento deve ser maior que ZERO!", "Ano de Nascimento Inválido", JOptionPane.ERROR_MESSAGE);
            else if(anoNasc > anoAtual)
                    JOptionPane.showMessageDialog(this,"O ano de nascimento deve ser menor que o ANO ATUAL!", "Ano de Nascimento Inválido", JOptionPane.ERROR_MESSAGE);
            else if(idade < 16)
                JOptionPane.showMessageDialog(this, "O aluno deve ter idade a partir de 16 anos!", "Idade Inválida", JOptionPane.ERROR_MESSAGE);
            else if(idade > 120)
                JOptionPane.showMessageDialog(this, "Já morreu ou é uma relíquia!", "Idade Inválida", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void buttonFechar() {
        frameAluno.setTxtIdade(txtIdadeCalculada.getText());
        dispose();
    }
    
    //Classe que trata os eventos dos botões
    private class BotaoHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnCalcular) {
                buttonCalcular();
            }    
            else if(e.getSource() == btnFechar) {
                buttonFechar();
            }
        }            
    }    
    
    //Classe que trata o evento de fechar a janela
    private class WindowHandler extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
           buttonFechar();
        }
    }
    
    //Classe que trata o layout dos botões quando o cursor passar por sua área
    private class MouseHandler extends MouseAdapter {
        
        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == btnCalcular) {
                btnCalcular.setBackground(new Color(190, 190, 190));
                btnCalcular.setForeground(Color.BLACK);      
            }
            else if(e.getSource() == btnFechar) {
                btnFechar.setBackground(new Color(190, 190, 190));
                btnFechar.setForeground(Color.BLACK);
            }
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource() == btnCalcular) {
                btnCalcular.setBackground(new Color(105,105,105));
                btnCalcular.setForeground(new Color(0,0,255));
            }
            else if(e.getSource() == btnFechar) {
                btnFechar.setBackground(new Color(105,105,105));
                btnFechar.setForeground(new Color(0,0,255));
            }
        }       
    }
    
    //Método que adiciona os listeners aos componentes
    private void startEvents() {
        this.addWindowListener(new WindowHandler());
        btnCalcular.addActionListener(new BotaoHandler());
        btnCalcular.addMouseListener(new MouseHandler());
        btnFechar.addActionListener(new BotaoHandler());
        btnFechar.addMouseListener(new MouseHandler());
    }
    
}
