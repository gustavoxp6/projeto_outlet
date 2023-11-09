package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dao.FLUXODECAIXADAO;
import entity.FLUXODECAIXA;
public class TELAFLUXODECAIXA extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_Saldo_anterior;
	private JTextField tf_Dinheiro;
	private JTextField tf_Cartao;
	private JTextField tf_Outras_entradas;
	private JTextField tf_Fornecedores;
	private JTextField tf_Impostos;
	private JTextField tf_Contas;
	private JTextField tf_Manutencoes;
	private JTextField tf_Parcela_equipamento;
	private JTextField tf_Despesa_bancaria;
	private JTextField tf_Outras_saidas;
	private JTextField tf_Salario_funcionario;
	private JTextField tf_prolabore;
	private JTextField tf_Total_saidas;
	private JTextField tf_Saldo_dia;
	private JTextField tf_Saldo_Atual;
	private JTextField tf_Data;
	private JTextField tf_Cod;
	private JTextField textField;
	private JTextField tf_Total_entradas;
	
	private FLUXODECAIXA fluxodecaixa = new FLUXODECAIXA();
	private FLUXODECAIXADAO fluxodecaixadao = new FLUXODECAIXADAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TELAFLUXODECAIXA frame = new TELAFLUXODECAIXA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TELAFLUXODECAIXA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 647);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0,0,0));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Fornecedores");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(89, 241, 107, 13);
		contentPane.add(lblNewLabel_4);
		
		tf_Fornecedores = new JTextField();
		tf_Fornecedores.setBounds(188, 238, 96, 19);
		contentPane.add(tf_Fornecedores);
		tf_Fornecedores.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Imposto");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(312, 238, 64, 13);
		contentPane.add(lblNewLabel_5);
		
		tf_Impostos = new JTextField();
		tf_Impostos.setBounds(392, 238, 96, 19);
		contentPane.add(tf_Impostos);
		tf_Impostos.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Contas");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(518, 241, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		tf_Contas = new JTextField();
		tf_Contas.setBounds(577, 237, 96, 19);
		contentPane.add(tf_Contas);
		tf_Contas.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Manutenções");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(683, 238, 88, 13);
		contentPane.add(lblNewLabel_7);
		
		tf_Manutencoes = new JTextField();
		tf_Manutencoes.setBounds(772, 235, 96, 19);
		contentPane.add(tf_Manutencoes);
		tf_Manutencoes.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Parcela de equipamento");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(89, 292, 155, 13);
		contentPane.add(lblNewLabel_8);
		
		tf_Parcela_equipamento = new JTextField();
		tf_Parcela_equipamento.setBounds(248, 291, 96, 19);
		contentPane.add(tf_Parcela_equipamento);
		tf_Parcela_equipamento.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Despesa bancaria");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(373, 292, 128, 13);
		contentPane.add(lblNewLabel_9);
		
		tf_Despesa_bancaria = new JTextField();
		tf_Despesa_bancaria.setBounds(514, 289, 96, 19);
		contentPane.add(tf_Despesa_bancaria);
		tf_Despesa_bancaria.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Salario funcionario");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setBounds(628, 290, 134, 13);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Outros");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setBounds(331, 342, 45, 13);
		contentPane.add(lblNewLabel_11);
		
		tf_Outras_saidas = new JTextField();
		tf_Outras_saidas.setBounds(405, 339, 96, 19);
		contentPane.add(tf_Outras_saidas);
		tf_Outras_saidas.setColumns(10);
		
		tf_Salario_funcionario = new JTextField();
		tf_Salario_funcionario.setBounds(763, 287, 96, 19);
		contentPane.add(tf_Salario_funcionario);
		tf_Salario_funcionario.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Prolabore");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setBounds(89, 342, 79, 13);
		contentPane.add(lblNewLabel_12);
		
		tf_prolabore = new JTextField();
		tf_prolabore.setBounds(185, 336, 96, 19);
		contentPane.add(tf_prolabore);
		tf_prolabore.setColumns(10);
		
		JButton btn_Calculo = new JButton("Calcular");
		btn_Calculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Primeiro, obtenha os valores dos campos de texto
String data = tf_Data.getText();
int saldo_anterior = tf_Saldo_anterior.getText().isEmpty() ? 0 : Integer.parseInt(tf_Saldo_anterior.getText());
int dinheiro = tf_Dinheiro.getText().isEmpty() ? 0 : Integer.parseInt(tf_Dinheiro.getText());
int cartao = tf_Cartao.getText().isEmpty() ? 0 : Integer.parseInt(tf_Cartao.getText());
int outras_entradas = tf_Outras_entradas.getText().isEmpty() ? 0 : Integer.parseInt(tf_Outras_entradas.getText());
int fornecedores = tf_Fornecedores.getText().isEmpty() ? 0 : Integer.parseInt(tf_Fornecedores.getText());
int impostos = tf_Impostos.getText().isEmpty() ? 0 : Integer.parseInt(tf_Impostos.getText());
int contas = tf_Contas.getText().isEmpty() ? 0 : Integer.parseInt(tf_Contas.getText());
int manutencoes = tf_Manutencoes.getText().isEmpty() ? 0 : Integer.parseInt(tf_Manutencoes.getText());
int parcela_equipamento = tf_Parcela_equipamento.getText().isEmpty() ? 0 : Integer.parseInt(tf_Parcela_equipamento.getText());
int despesa_bancaria = tf_Despesa_bancaria.getText().isEmpty() ? 0 : Integer.parseInt(tf_Despesa_bancaria.getText());
int salario_funcionario = tf_Salario_funcionario.getText().isEmpty() ? 0 : Integer.parseInt(tf_Salario_funcionario.getText());
int prolabore = tf_prolabore.getText().isEmpty() ? 0 : Integer.parseInt(tf_prolabore.getText());
int outras_saidas = tf_Outras_saidas.getText().isEmpty() ? 0 : Integer.parseInt(tf_Outras_saidas.getText());

// Atribua os valores aos campos do objeto fluxodecaixa
fluxodecaixa.setData(data);
fluxodecaixa.setSaldo_anterior(saldo_anterior);
fluxodecaixa.setDinheiro(dinheiro);
fluxodecaixa.setCartao(cartao);
fluxodecaixa.setOutros_entradas(outras_entradas);
fluxodecaixa.setFornecedores(fornecedores);
fluxodecaixa.setImpostos(impostos);
fluxodecaixa.setContas(contas);
fluxodecaixa.setManuntencoes(manutencoes);
fluxodecaixa.setParcela_equipamento(parcela_equipamento);
fluxodecaixa.setDespesa_bancaria(despesa_bancaria);
fluxodecaixa.setSalario_funcionario(salario_funcionario);
fluxodecaixa.setProlabore(prolabore);
fluxodecaixa.setOutras_saidas(outras_saidas);

					
				if( tf_Data.getText().equals("")
				||	tf_Saldo_anterior.getText().equals("")
				|| tf_Dinheiro.getText().equals("")
				|| tf_Cartao.getText().equals("")
				|| tf_Outras_entradas.getText().equals("")
				){
					JOptionPane.showMessageDialog(null, "Digite os campos de entradas e a data para aremazenar os dados!");
				}
				
				else{
			     fluxodecaixadao.calculo_total(fluxodecaixa);
				 tf_Cod.setText(Integer.toString(fluxodecaixa.getCod()));
				 tf_Total_saidas.setText(Integer.toString((int)fluxodecaixa.getTotal_saidas()));
				 tf_Total_entradas.setText(Integer.toString((int)fluxodecaixa.getTotal_entrada()));
				 tf_Saldo_dia.setText(Integer.toString((int)fluxodecaixa.getSaldo_do_dia()));
				 tf_Saldo_Atual.setText(Integer.toString((int)fluxodecaixa.getSaldo_atual()));
				}
			}
		});
		btn_Calculo.setForeground(Color.BLACK);
		btn_Calculo.setBackground(Color.WHITE);
		btn_Calculo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Calculo.setBounds(362, 413, 96, 21);
		contentPane.add(btn_Calculo);
		
		JLabel lblNewLabel_15 = new JLabel("Saldo atual");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_15.setForeground(Color.WHITE);
		lblNewLabel_15.setBounds(619, 487, 88, 13);
		contentPane.add(lblNewLabel_15);
		
		tf_Saldo_Atual = new JTextField();
		tf_Saldo_Atual.setBounds(611, 510, 96, 19);
		contentPane.add(tf_Saldo_Atual);
		tf_Saldo_Atual.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Data");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_16.setForeground(Color.white);
		lblNewLabel_16.setBounds(64, 57, 45, 13);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_21 = new JLabel("Cod");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_21.setForeground(Color.white);
		lblNewLabel_21.setBounds(64, 26, 45, 13);
		contentPane.add(lblNewLabel_21);
		
		tf_Cod = new JTextField();
		tf_Cod.setBounds(119, 27, 77, 19);
		contentPane.add(tf_Cod);
		tf_Cod.setColumns(10);
		
		JLabel lblNewLabel_18 = new JLabel("SAIDAS:");
		lblNewLabel_18.setForeground(Color.WHITE);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_18.setBounds(89, 207, 64, 13);
		contentPane.add(lblNewLabel_18);
		
		JLabel lblNewLabel_22 = new JLabel("RESULTADOS:");
		lblNewLabel_22.setForeground(Color.WHITE);
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_22.setBounds(99, 468, 107, 13);
		contentPane.add(lblNewLabel_22);
		
		tf_Data = new JTextField();
		tf_Data.setBounds(119, 56, 115, 19);
		contentPane.add(tf_Data);
		tf_Data.setColumns(10);
		
		JButton btn_Buscar = new JButton("Buscar");
		btn_Buscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Buscar.setBounds(509, 413, 85, 21);
		contentPane.add(btn_Buscar);
		
		JLabel lblNewLabel_19 = new JLabel("Fluxo de caixa");
		lblNewLabel_19.setBackground(Color.black);
		lblNewLabel_19.setForeground(Color.white);
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_19.setBounds(423, 46, 188, 27);
		contentPane.add(lblNewLabel_19);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(61, 89, 861, 114);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Dinheiro");
		lblNewLabel_1.setBounds(10, 85, 58, 13);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		
		tf_Dinheiro = new JTextField();
		tf_Dinheiro.setBounds(77, 84, 96, 19);
		panel.add(tf_Dinheiro);
		tf_Dinheiro.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cartão");
		lblNewLabel_2.setBounds(203, 87, 45, 13);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		
		tf_Cartao = new JTextField();
		tf_Cartao.setBounds(272, 84, 96, 19);
		panel.add(tf_Cartao);
		tf_Cartao.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Outros");
		lblNewLabel_3.setBounds(402, 87, 45, 13);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(Color.WHITE);
		
		tf_Outras_entradas = new JTextField();
		tf_Outras_entradas.setBounds(467, 84, 96, 19);
		panel.add(tf_Outras_entradas);
		tf_Outras_entradas.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Saldo do dia anterior");
		lblNewLabel.setBounds(10, 13, 155, 13);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		
		tf_Saldo_anterior = new JTextField();
		tf_Saldo_anterior.setBounds(175, 11, 96, 19);
		panel.add(tf_Saldo_anterior);
		tf_Saldo_anterior.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("ENTRADAS:");
		lblNewLabel_17.setBounds(10, 47, 100, 13);
		panel.add(lblNewLabel_17);
		lblNewLabel_17.setForeground(Color.WHITE);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(UIManager.getColor("Button.disabledForeground"));
		panel_1.setBounds(61, 201, 861, 180);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(61, 381, 861, 163);
		contentPane.add(panel_2);	
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_13 = new JLabel("Total de saidas");
		lblNewLabel_13.setBounds(152, 105, 96, 13);
		panel_2.add(lblNewLabel_13);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_13.setForeground(Color.WHITE);
		
		tf_Total_saidas = new JTextField();
		tf_Total_saidas.setBounds(134, 129, 127, 19);
		panel_2.add(tf_Total_saidas);
		tf_Total_saidas.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Saldo do dia");
		lblNewLabel_14.setBounds(418, 105, 79, 13);
		panel_2.add(lblNewLabel_14);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_14.setForeground(Color.WHITE);
		
		tf_Saldo_dia = new JTextField();
		tf_Saldo_dia.setBounds(418, 129, 96, 19);
		panel_2.add(tf_Saldo_dia);
		tf_Saldo_dia.setColumns(10);
		
		JLabel lblNewLabel_23 = new JLabel("Total de entrada");
		lblNewLabel_23.setForeground(Color.WHITE);
		lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_23.setBounds(290, 104, 115, 14);
		panel_2.add(lblNewLabel_23);
		
		tf_Total_entradas = new JTextField();
		tf_Total_entradas.setBounds(300, 129, 86, 20);
		panel_2.add(tf_Total_entradas);
		tf_Total_entradas.setColumns(10);

		JLabel lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setForeground(new Color(0,0,0));
		lblNewLabel_20.setIcon(new ImageIcon("C:\\Users\\55819\\Downloads\\SENAI\\projeto_senai\\src\\telas\\imagem\\Fluxo-de-caixa-melhore-a-saúde-financeira-da-sua-imobiliáriaD.jpg"));
		lblNewLabel_20.setBounds(0, 0, 1022, 610);
		getContentPane().add(lblNewLabel_20);
		
	}
}
