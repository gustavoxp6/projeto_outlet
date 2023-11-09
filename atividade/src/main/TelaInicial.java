package main;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import com.toedter.calendar.JDateChooser;
import DAO.*;
import ENTIDADES.*;
public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PainelInicial;
    private JLayeredPane layeredPane;
    private JPanel PainelGerenciamentoCliente;
    private JTextField tf_NomeCliente;
    private JTextField tf_EmailCliente;
    private JTextField tf_LogradouroCliente;
    private JTextField tf_NumeroCliente;
    private JTextField tf_ComplementoCliente;
    private JTextField tf_BairroCliente;
    private JTextField tf_CidadeCliente;
	private JButton btn_Inserir;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
					CONEXAO conectar = new CONEXAO();
					ProdutoDao.start(conectar.getConexao());
					ClienteDAO.start(conectar.getConexao());
					EnderecoDAO.start(conectar.getConexao());
					PedidoDAO.start(conectar.getConexao());
					ItempedidoDAO.start(conectar.getConexao());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1080, 720);
		PainelInicial = new JPanel();
		PainelInicial.setBackground(new Color(255, 255, 255));
		PainelInicial.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PainelInicial);
		PainelInicial.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(170, 170, 170));
		menuBar.setBounds(0, 0, 152, 686);
		PainelInicial.add(menuBar);
		// Defina o layout do JMenuBar como BoxLayout na orientação Y (vertical)
        menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.Y_AXIS));
        

		
		JMenu mn_Cliente = new JMenu("Cliente");
		menuBar.add(mn_Cliente);
		
		JMenuItem mntm_ClienteGerenciamento = new JMenuItem("Gerenciamento");
		mntm_ClienteGerenciamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                limparpainel();
                GerenciamentoCliente();

			}
		});
		mn_Cliente.add(mntm_ClienteGerenciamento);
		
		JMenuItem mntm_ClienteConsulta = new JMenuItem("Consulta");
		mntm_ClienteConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparpainel();
				ConsultaCliente();
			}
		});
		mn_Cliente.add(mntm_ClienteConsulta);
		
		JMenu mn_Produto = new JMenu("Produto");
		menuBar.add(mn_Produto);
		
		JMenuItem mntm_ProdutoGerenciamento = new JMenuItem("Gerenciamento");
		mntm_ProdutoGerenciamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                limparpainel();
                gerenciamentoProduto();
			}
		});
		mn_Produto.add(mntm_ProdutoGerenciamento);
		
		JMenuItem mntm_ProdutoConsulta = new JMenuItem("Consulta");
		mntm_ProdutoConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparpainel();
				ConsultaProduto();
			}
		});
		mn_Produto.add(mntm_ProdutoConsulta);
		
		JMenu mn_Estoque = new JMenu("Estoque");
		menuBar.add(mn_Estoque);
		
		JMenu mn_Pedido = new JMenu("Pedido");
		menuBar.add(mn_Pedido);
		
		JMenuItem mntm_PedidoGerenciamento = new JMenuItem("Gerenciamento");
		mntm_PedidoGerenciamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparpainel();
				TELAPEDIDO();
			}
		});
		mn_Pedido.add(mntm_PedidoGerenciamento);
		
		JMenuItem mntm_PedidoConsulta = new JMenuItem("Consulta");
		mntm_PedidoConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparpainel();
				ConsultaPedido();
			}
		});
		mn_Pedido.add(mntm_PedidoConsulta);
		
		JMenu mn_Venda = new JMenu("Venda");
		menuBar.add(mn_Venda);
		
		JMenuItem mntm_VendaGerenciamento = new JMenuItem("Gerenciamento");
		mntm_VendaGerenciamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_Venda.add(mntm_VendaGerenciamento);
		
		JMenuItem mntm_VendaConsulta = new JMenuItem("Consulta");
		mntm_VendaConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_Venda.add(mntm_VendaConsulta);
		
		JMenu mn_Financeiro = new JMenu("Financeiro");
		menuBar.add(mn_Financeiro);
		
		JMenuItem mntm_ContasPagar = new JMenuItem("Contas a Pagar");
		mntm_ContasPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_Financeiro.add(mntm_ContasPagar);
		
		JMenuItem mntm_ContasReceber = new JMenuItem("Contas a Receber");
		mntm_ContasReceber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_Financeiro.add(mntm_ContasReceber);
		
		JMenu mn_EntradaMercadorias = new JMenu("Entrada de \nMercadoria");
		mn_EntradaMercadorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mn_EntradaMercadorias);
		
		JMenu mn_Relatorios = new JMenu("Relatórios");
		menuBar.add(mn_Relatorios);
		
		JMenu mn_Nada1 = new JMenu(" ");
		menuBar.add(mn_Nada1);
		JMenu mn_Nada2 = new JMenu(" ");
		menuBar.add(mn_Nada2);
		JMenu mn_Nada3 = new JMenu(" ");
		menuBar.add(mn_Nada3);
		JMenu mn_Nada4 = new JMenu(" ");
		menuBar.add(mn_Nada4);
		JMenu mn_Nada5 = new JMenu(" ");
		menuBar.add(mn_Nada5);
		JMenu mn_Nada6 = new JMenu(" ");
		menuBar.add(mn_Nada6);
		JMenu mn_Nada7 = new JMenu(" ");
		menuBar.add(mn_Nada7);
		JMenu mn_Nada8 = new JMenu(" ");
		menuBar.add(mn_Nada8);
		JMenu mn_Nada9 = new JMenu(" ");
		menuBar.add(mn_Nada9);
		JMenu mn_Nada10 = new JMenu(" ");
		menuBar.add(mn_Nada10);
		
		JMenu mn_Sair = new JMenu("Sair");
		mn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mn_Sair);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(32, 215, 0));
		layeredPane.setBounds(164, 0, 910, 686);
		PainelInicial.add(layeredPane);
	}

    public void GerenciamentoCliente() {

        PainelGerenciamentoCliente = new JPanel();
        layeredPane.setLayer(PainelGerenciamentoCliente, 0);
        PainelGerenciamentoCliente.setBounds(0, 0, 910, 686);
        layeredPane.add(PainelGerenciamentoCliente);
		PainelGerenciamentoCliente.setBackground(new Color(255, 255, 255));
		PainelGerenciamentoCliente.setLayout(null);
        Cliente cliente = new Cliente();
		ClienteDAO clientedao = new ClienteDAO();
		EnderecoDAO enderecodao = new EnderecoDAO();
		Endereco endereco = new Endereco();
		JLabel lbl_Titulo = new JLabel("Gerenciamento de Cliente");
		lbl_Titulo.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lbl_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Titulo.setBounds(6, 35, 904, 16);
		PainelGerenciamentoCliente.add(lbl_Titulo);
		
		JLabel lbl_CPFCliente = new JLabel("CPF");
		lbl_CPFCliente.setBounds(32, 103, 36, 16);
		PainelGerenciamentoCliente.add(lbl_CPFCliente);
		
		JFormattedTextField ftf_CPFCliente = new JFormattedTextField(Mascara("###.###.###-##"));
		ftf_CPFCliente.setBounds(71, 98, 238, 26);
		PainelGerenciamentoCliente.add(ftf_CPFCliente);
		
		JLabel lbl_NomeCliente = new JLabel("Nome");
		lbl_NomeCliente.setBounds(348, 103, 48, 16);
		PainelGerenciamentoCliente.add(lbl_NomeCliente);
		
		tf_NomeCliente = new JTextField();
		tf_NomeCliente.setBounds(396, 98, 491, 26);
		PainelGerenciamentoCliente.add(tf_NomeCliente);
		tf_NomeCliente.setColumns(10);
		
		JLabel lbl_DataNascimentoCliente = new JLabel("Data de Nascimento");
		lbl_DataNascimentoCliente.setBounds(32, 149, 138, 16);
		PainelGerenciamentoCliente.add(lbl_DataNascimentoCliente);
		
		JDateChooser dt_DataNascimentoCliente = new JDateChooser();
		dt_DataNascimentoCliente.setBounds(171, 144, 213, 26);
		PainelGerenciamentoCliente.add(dt_DataNascimentoCliente);
		
		JLabel lbl_EmailCliente = new JLabel("E-mail");
		lbl_EmailCliente.setBounds(396, 149, 48, 16);
		PainelGerenciamentoCliente.add(lbl_EmailCliente);
		
		tf_EmailCliente = new JTextField();
		tf_EmailCliente.setBounds(456, 144, 431, 26);
		PainelGerenciamentoCliente.add(tf_EmailCliente);
		tf_EmailCliente.setColumns(10);
		
		JLabel lbl_TelefoneCliente = new JLabel("Telefone");
		lbl_TelefoneCliente.setBounds(32, 199, 61, 16);
		PainelGerenciamentoCliente.add(lbl_TelefoneCliente);
		
		JFormattedTextField tft_TelefoneCliente = new JFormattedTextField();
		tft_TelefoneCliente.setBounds(96, 194, 213, 26);
		PainelGerenciamentoCliente.add(tft_TelefoneCliente);
		
		JLabel lbl_EnderecoCliente = new JLabel("Endereço");
		lbl_EnderecoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_EnderecoCliente.setBounds(6, 260, 904, 16);
		PainelGerenciamentoCliente.add(lbl_EnderecoCliente);
		
		JLabel lbl_LogradouroCliente = new JLabel("Logradouro");
		lbl_LogradouroCliente.setBounds(32, 304, 82, 16);
		PainelGerenciamentoCliente.add(lbl_LogradouroCliente);
		
		tf_LogradouroCliente = new JTextField();
		tf_LogradouroCliente.setBounds(114, 299, 543, 26);
		PainelGerenciamentoCliente.add(tf_LogradouroCliente);
		tf_LogradouroCliente.setColumns(10);
		
		JLabel lbl_NumeroCliente = new JLabel("Número");
		lbl_NumeroCliente.setBounds(684, 304, 61, 16);
		PainelGerenciamentoCliente.add(lbl_NumeroCliente);
		
		tf_NumeroCliente = new JTextField();
		tf_NumeroCliente.setBounds(757, 299, 130, 26);
		PainelGerenciamentoCliente.add(tf_NumeroCliente);
		tf_NumeroCliente.setColumns(10);
		
		JLabel lbl_ComplementoCliente = new JLabel("Complemento");
		lbl_ComplementoCliente.setBounds(32, 349, 94, 16);
		PainelGerenciamentoCliente.add(lbl_ComplementoCliente);
		
		tf_ComplementoCliente = new JTextField();
		tf_ComplementoCliente.setBounds(134, 344, 340, 26);
		PainelGerenciamentoCliente.add(tf_ComplementoCliente);
		tf_ComplementoCliente.setColumns(10);
		
		JLabel lbl_BairroCliente = new JLabel("Bairro");
		lbl_BairroCliente.setBounds(486, 349, 48, 16);
		PainelGerenciamentoCliente.add(lbl_BairroCliente);
		
		tf_BairroCliente = new JTextField();
		tf_BairroCliente.setBounds(538, 344, 349, 26);
		PainelGerenciamentoCliente.add(tf_BairroCliente);
		tf_BairroCliente.setColumns(10);
		
		JLabel lbl_CidadeCliente = new JLabel("Cidade");
		lbl_CidadeCliente.setBounds(32, 396, 48, 16);
		PainelGerenciamentoCliente.add(lbl_CidadeCliente);
		
		tf_CidadeCliente = new JTextField();
		tf_CidadeCliente.setBounds(84, 391, 265, 26);
		PainelGerenciamentoCliente.add(tf_CidadeCliente);
		tf_CidadeCliente.setColumns(10);
		
		JLabel lbl_EstadoCliente = new JLabel("Estado");
		lbl_EstadoCliente.setBounds(371, 396, 48, 16);
		PainelGerenciamentoCliente.add(lbl_EstadoCliente);
		
		JComboBox cb_EstadoCliente = new JComboBox();
		cb_EstadoCliente.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"}));
		cb_EstadoCliente.setBounds(419, 392, 238, 27);
		PainelGerenciamentoCliente.add(cb_EstadoCliente);
		
		JLabel lbl_CEPCliente = new JLabel("CEP");
		lbl_CEPCliente.setBounds(685, 396, 36, 16);
		PainelGerenciamentoCliente.add(lbl_CEPCliente);
		
		JFormattedTextField ftf_CEPCliente = new JFormattedTextField(Mascara("#####-###"));
		ftf_CEPCliente.setBounds(721, 391, 166, 26);
		PainelGerenciamentoCliente.add(ftf_CEPCliente);

		JButton btn_CadastrarCliente = new JButton("Cadastrar");
		btn_CadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                cliente.setCpf(ftf_CPFCliente.getText());
				SimpleDateFormat converterdata = new SimpleDateFormat("yyyy/MM/dd");
                cliente.setDatanascimento(converterdata.format(dt_DataNascimentoCliente.getDate()));
                cliente.setEmail(tf_EmailCliente.getText());
                cliente.setNome(tf_NomeCliente.getText());
                cliente.setTelefone(tft_TelefoneCliente.getText());
                endereco.setBairro(tf_BairroCliente.getText());
                endereco.setLogradouro(tf_LogradouroCliente.getText());
                endereco.setCep(ftf_CEPCliente.getText());
                endereco.setCidade(tf_CidadeCliente.getText());
                endereco.setComplemento(tf_ComplementoCliente.getText());
                endereco.setEstado((String) cb_EstadoCliente.getSelectedItem());
                endereco.setNumero(tf_NumeroCliente.getText());
                endereco.setCliente_cpf(ftf_CPFCliente.getText());
                if(cliente.getCpf().equals("")
                
                || cliente.getEmail().equals("")
                || cliente.getNome().equals("")
                || cliente.getTelefone().equals("")
				|| endereco.getBairro().equals("")
				|| endereco.getLogradouro().equals("")
				|| endereco.getCep().equals("")
				|| endereco.getCidade().equals("")
				|| endereco.getEstado().equals("")
				|| endereco.getNumero().equals("")
                ){
                    JOptionPane.showMessageDialog(null,"Todos os campos são obrigatorios❗❗\nExceto o complemento.");
                }else{
                    clientedao.insereCliente(cliente);
                    enderecodao.insereEndereco(endereco);   
                }
				
			}
		});
		btn_CadastrarCliente.setBounds(151, 518, 117, 29);
		PainelGerenciamentoCliente.add(btn_CadastrarCliente);
		
		JButton btn_BuscarCliente = new JButton("Buscar");
		btn_BuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.setCpf(ftf_CPFCliente.getText());
				clientedao.buscaCliente(cliente);
				tf_NomeCliente.setText(cliente.getNome());
				tf_EmailCliente.setText(cliente.getEmail());
				tft_TelefoneCliente.setText(cliente.getTelefone());
				SimpleDateFormat formatorecebido = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat formatoexibicao = new SimpleDateFormat("d'de'MMM'de'y");
				Date dataformatada = null;
				try {
					dataformatada = formatorecebido.parse(cliente.getDatanascimento());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				formatoexibicao.format(dataformatada);
				dt_DataNascimentoCliente.setDate(dataformatada);
				endereco.setCliente_cpf(ftf_CPFCliente.getText());
				enderecodao.buscaEnderecosDoCLiente(endereco);
				tf_LogradouroCliente.setText(endereco.getLogradouro());
				tf_BairroCliente.setText(endereco.getBairro());
				tf_CidadeCliente.setText(endereco.getCidade());
				tf_ComplementoCliente.setText(endereco.getComplemento());
				ftf_CEPCliente.setText(endereco.getCep());
				tf_NumeroCliente.setText(endereco.getNumero());
				cb_EstadoCliente.setSelectedItem(endereco.getEstado());
				
			}
		});
		btn_BuscarCliente.setBounds(296, 518, 117, 29);
		PainelGerenciamentoCliente.add(btn_BuscarCliente);
		
		JButton btn_AtualizarCliente = new JButton("Atualizar");
		btn_AtualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.setCpf(ftf_CPFCliente.getText());
				cliente.setDatanascimento(dt_DataNascimentoCliente.getDateFormatString());
				cliente.setEmail(tf_EmailCliente.getText());
				cliente.setNome(tf_NomeCliente.getText());
				cliente.setTelefone(tft_TelefoneCliente.getText());
				clientedao.atualizaCliente(cliente);
				endereco.setBairro(tf_BairroCliente.getText());
				endereco.setCep(ftf_CEPCliente.getText());
				endereco.setCidade(tf_CidadeCliente.getText());
				endereco.setCliente_cpf(ftf_CPFCliente.getText());
				endereco.setComplemento(tf_ComplementoCliente.getText());
				endereco.setEstado((String) cb_EstadoCliente.getSelectedItem());
				endereco.setLogradouro(tf_LogradouroCliente.getText());
				endereco.setNumero(tf_NumeroCliente.getText());
				enderecodao.atualizaEndereco(endereco);
					ftf_CPFCliente.setText("");
					dt_DataNascimentoCliente.setToolTipText("");
					tf_EmailCliente.setText("");
					tf_NomeCliente.setText("");
					tft_TelefoneCliente.setText("");
					tf_BairroCliente.setText("");
					ftf_CEPCliente.setText("");
					tf_CidadeCliente.setText("");
					tf_ComplementoCliente.setText("");
					cb_EstadoCliente.setSelectedIndex(0);
					tf_LogradouroCliente.setText("");
					tf_NumeroCliente.setText("");
					
			}
		});
		btn_AtualizarCliente.setBounds(449, 518, 117, 29);
		PainelGerenciamentoCliente.add(btn_AtualizarCliente);
		
		JButton btn_ExcluirCliente = new JButton("Excluir");
		btn_ExcluirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				endereco.setCliente_cpf(ftf_CPFCliente.getText());
				enderecodao.deletaEndereco(endereco);
				cliente.setCpf(ftf_CPFCliente.getText());
				clientedao.deletaCliente(cliente);
					ftf_CPFCliente.setText("");
					dt_DataNascimentoCliente.setToolTipText("");
					tf_EmailCliente.setText("");
					tf_NomeCliente.setText("");
					tft_TelefoneCliente.setText("");
					tf_BairroCliente.setText("");
					ftf_CEPCliente.setText("");
					tf_CidadeCliente.setText("");
					tf_ComplementoCliente.setText("");
					cb_EstadoCliente.setSelectedIndex(0);
					tf_LogradouroCliente.setText("");
					tf_NumeroCliente.setText("");
					
			}
		});
		btn_ExcluirCliente.setBounds(604, 518, 117, 29);
		PainelGerenciamentoCliente.add(btn_ExcluirCliente);

    }
	public void ConsultaCliente() {
		JPanel PainelConsultaCliente = new JPanel();
		layeredPane.setLayer(PainelConsultaCliente, 0);
		PainelConsultaCliente.setBounds(0, 0, 910, 686);
		layeredPane.add(PainelConsultaCliente);
		PainelConsultaCliente.setBackground(new Color(255, 255, 255));
		PainelConsultaCliente.setLayout(null);
		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		
		JLabel lbl_CidadeClienteConsulta = new JLabel("Cidade");
		lbl_CidadeClienteConsulta.setBounds(79, 39, 48, 16);
		PainelConsultaCliente.add(lbl_CidadeClienteConsulta);
		
		JTextField tf_CidadeClienteConsulta = new JTextField();
		tf_CidadeClienteConsulta.setBounds(139, 34, 164, 26);
		PainelConsultaCliente.add(tf_CidadeClienteConsulta);
		tf_CidadeClienteConsulta.setColumns(10);
		
		JLabel lbl_EstadoClienteConsulta = new JLabel("Estado");
		lbl_EstadoClienteConsulta.setBounds(336, 39, 48, 16);
		PainelConsultaCliente.add(lbl_EstadoClienteConsulta);
		
		JComboBox cb_EstadoClienteConsulta = new JComboBox();
		cb_EstadoClienteConsulta.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"}));
		cb_EstadoClienteConsulta.setBounds(396, 35, 238, 27);
		PainelConsultaCliente.add(cb_EstadoClienteConsulta);
		
		
		JButton bt_BuscarClienteConsulta = new JButton("Buscar");
		bt_BuscarClienteConsulta.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		//if (table_ConsultaCliente != null && scrollPaneCliente != null) {
		// table_ConsultaCliente=null;
		// scrollPaneCliente.getViewport().removeAll();
		// table_ConsultaCliente = new JTable();
		// scrollPaneCliente = new JScrollPane(table_ConsultaCliente);
		//}
		
		JTable table_ConsultaCliente = new JTable();
		table_ConsultaCliente.setBackground(new Color(255,255,255)); // define a cor de fundo do JTable
		table_ConsultaCliente.setBounds(0, 88, 910, 590);
		DefaultTableModel model = (DefaultTableModel) table_ConsultaCliente.getModel(); //
		model.addColumn("CPF"); // adiciona a coluna 0
		model.addColumn("Nome"); // adiciona a coluna 1
		model.addColumn("Nascimento"); // adiciona a coluna 2
		model.addColumn("E-mail"); // adiciona a coluna 3
		model.addColumn("Telefone"); // adiciona a coluna 4
		model.addColumn("Cidade"); // adiciona a coluna 5
		model.addColumn("Estado"); // adiciona a coluna 6
		table_ConsultaCliente.getColumnModel().getColumn(0).setPreferredWidth(100); // define a largura da coluna 0
		table_ConsultaCliente.getColumnModel().getColumn(1).setPreferredWidth(150); // define a largura da coluna 1
		table_ConsultaCliente.getColumnModel().getColumn(2).setPreferredWidth(80); // define a largura da coluna 2
		table_ConsultaCliente.getColumnModel().getColumn(3).setPreferredWidth(150); // define a largura da coluna 3
		table_ConsultaCliente.getColumnModel().getColumn(4).setPreferredWidth(80); // define a largura da coluna 4
		table_ConsultaCliente.getColumnModel().getColumn(5).setPreferredWidth(100); // define a largura da coluna 5
		table_ConsultaCliente.getColumnModel().getColumn(6).setPreferredWidth(30); // define a largura da coluna 6
		
		JScrollPane scrollPaneCliente = new JScrollPane(table_ConsultaCliente);
		scrollPaneCliente.setLocation(0, 88);
		scrollPaneCliente.setSize(910, 590);
		scrollPaneCliente.setPreferredSize(new Dimension(910, 590)); // define a largura e altura do ScrollPane
		javax.swing.JViewport viewport = scrollPaneCliente.getViewport(); // define a cor de fundo do ScrollPane
		viewport.setBackground(new Color(255,255,255)); // define a cor de fundo do ScrollPane
		PainelConsultaCliente.add(scrollPaneCliente);
		try {
			
            CONEXAO novaConexao = new CONEXAO();
            Connection conectar = novaConexao.getConexao();
            Connection conn = conectar;
           
            // Procedimentos para obter os dados de uma tabela
            java.sql.Statement stmt = conn.createStatement();

            String cidade = tf_CidadeClienteConsulta.getText();
            String estado = (String) cb_EstadoClienteConsulta.getSelectedItem();
            String query = "";
            
            if (cidade.equals("") && estado.equals("Selecione")) {
            query = "SELECT cliente.cpf, cliente.nome, cliente.datanascimento, cliente.telefone, cliente.email, endereco.cidade, endereco.estado FROM cliente INNER JOIN endereco ON cliente.cpf = endereco.cliente_cpf";
			System.out.println("Query executada");
            } else if (!cidade.equals("") && estado.equals("Selecione")) {
            query = "SELECT cliente.cpf, cliente.nome, cliente.datanascimento, cliente.telefone, cliente.email, endereco.cidade, endereco.estado FROM cliente INNER JOIN endereco ON cliente.cpf = endereco.cpf_cliente WHERE endereco.cidade = '" + cidade + "'";
            } else if (!cidade.equals("") && !estado.equals("Selecione")) {
            query = "SELECT cliente.cpf, cliente.nome, cliente.datanascimento, cliente.telefone, cliente.email, endereco.cidade, endereco.estado FROM cliente INNER JOIN endereco ON cliente.cpf = endereco.cpf_cliente WHERE endereco.cidade = '" + cidade + "' AND endereco.estado = '" + estado + "'";
            }
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
            String cpf = ( rs.getString("cliente.cpf"));
            String nome = ( rs.getString("cliente.nome") );
            Date datanascimento = (rs.getDate("cliente.datanascimento"));
            String telefone = ( rs.getString("cliente.telefone"));
            String emall = (rs.getString("cliente.email"));
            String cliente_cidade = ( rs.getString("endereco.cidade"));
            String cliente_estado = ( rs.getString("endereco.estado"));
           
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String strdataretirada = sdf.format(datanascimento);
            
            model.addRow(new Object[]{cpf, nome, strdataretirada, telefone, emall, cliente_cidade, cliente_estado});
            }
            } catch (SQLException erro_consulta_cliente) {
            
            }
    
		
		}
		});
		bt_BuscarClienteConsulta.setBounds(667, 34, 117, 29);
		PainelConsultaCliente.add(bt_BuscarClienteConsulta);
	}
    public void gerenciamentoProduto(){

        JPanel contentPane = new JPanel();
		layeredPane.setLayer(contentPane, 0);
		contentPane.setBounds(0, 0, 910, 686);
		layeredPane.add(contentPane);
		contentPane.setBackground(new Color(255, 255, 255));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		 Produto produto = new Produto();
	     ProdutoDao produtoDao = new ProdutoDao();

		
		JLabel lblNewLabel = new JLabel("PRODUTO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(393, 38, 137, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cod");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(41, 174, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JTextField tf_Cod = new JTextField();
		tf_Cod.setBounds(97, 171, 86, 20);
		contentPane.add(tf_Cod);
		tf_Cod.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Descrição");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(339, 174, 70, 14);
		contentPane.add(lblNewLabel_2);
		
		JTextField tf_Descricao = new JTextField();
		tf_Descricao.setBounds(419, 171, 163, 20);
		contentPane.add(tf_Descricao);
		tf_Descricao.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Marca");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(642, 174, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JTextField tf_Marca = new JTextField();
		tf_Marca.setBounds(698, 171, 170, 20);
		contentPane.add(tf_Marca);
		tf_Marca.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Preco");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(41, 267, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JTextField tf_Preco = new JTextField();
		tf_Preco.setBounds(97, 264, 101, 20);
		contentPane.add(tf_Preco);
		tf_Preco.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Quantidade de estoque");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(339, 267, 131, 14);
		contentPane.add(lblNewLabel_5);
		
		JTextField tf_Quantidade_estoque = new JTextField();
		tf_Quantidade_estoque.setBounds(496, 264, 93, 20);
		contentPane.add(tf_Quantidade_estoque);
		tf_Quantidade_estoque.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) { 
		produto.setCod(tf_Cod.getText());
		produto.setDescricao(tf_Descricao.getText());
		produto.setMarca(tf_Marca.getText());
		produto.setPreco(Double.parseDouble(tf_Preco.getText().replace(",", ".")));
		produto.setQuantidadeestoque(Integer.parseInt((tf_Quantidade_estoque.getText())));
		if(produto.getCod().equals("")
			|| produto.getDescricao().equals("")
			|| produto.getMarca().equals("")
			|| tf_Preco.equals("")
			|| tf_Quantidade_estoque.equals("")){
				JOptionPane.showConfirmDialog(null, "Todos os campos são obrigatorios!!");
			}else{
				ProdutoDao.insereProduto(produto);
			}
			
		}
	});
			
	btnNewButton.setBounds(129, 403, 95, 23);
	contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) { 
			produto.setCod(tf_Cod.getText());
			produtoDao.busca(produto);
			tf_Descricao.setText(produto.getDescricao());
			tf_Marca.setText(produto.getMarca());	
			tf_Preco.setText(Double.toString((produto.getPreco())));
			tf_Quantidade_estoque.setText(Integer.toString(produto.getQuantidadeestoque()));
			
		}
	});
		btnNewButton_1.setBounds(339, 403, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Atualizar");
		btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) { 
			produto.setCod(tf_Cod.getText());
			produto.setDescricao(tf_Descricao.getText());
			produto.setMarca(tf_Marca.getText());
			produto.setPreco(Double.parseDouble(tf_Preco.getText()));
			produto.setQuantidadeestoque(Integer.parseInt(tf_Quantidade_estoque.getText()));
			produtoDao.atualiza(produto);
			tf_Cod.setText("");
			tf_Descricao.setText("");
			tf_Marca.setText("");
			tf_Preco.setText("");
			tf_Quantidade_estoque.setText("");
			}
	});
		btnNewButton_2.setBounds(550, 403, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Excluir");
		btnNewButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) { 
			produto.setCod(tf_Cod.getText());
			produtoDao.deleta(produto);
			}
	});
		btnNewButton_3.setBounds(730, 403, 89, 23);
		contentPane.add(btnNewButton_3);

    
    }
	
	public void ConsultaProduto() {
		JPanel PainelConsultaProduto = new JPanel();
		layeredPane.setLayer(PainelConsultaProduto, 0);
		PainelConsultaProduto.setBounds(0, 0, 910, 686);
		layeredPane.add(PainelConsultaProduto);
		PainelConsultaProduto.setBackground(new Color(255, 255, 255));
		PainelConsultaProduto.setLayout(null);
		
		
		JLabel lbl_Cod_produto = new JLabel("Codigo do produto");
		lbl_Cod_produto.setBounds(30, 31, 110, 30);
		PainelConsultaProduto.add(lbl_Cod_produto);
		
		JTextField tf_Cod_Produto = new JTextField();
		tf_Cod_Produto.setBounds(139, 34, 164, 26);
		PainelConsultaProduto.add(tf_Cod_Produto);
		tf_Cod_Produto.setColumns(10);
		
		
		JButton bt_BuscarProduto = new JButton("Buscar");
		bt_BuscarProduto.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		//if (table_ConsultaCliente != null && scrollPaneCliente != null) {
		// table_ConsultaCliente=null;
		// scrollPaneCliente.getViewport().removeAll();
		// table_ConsultaCliente = new JTable();
		// scrollPaneCliente = new JScrollPane(table_ConsultaCliente);
		//}
		
		JTable table_consulta_produto = new JTable();
		table_consulta_produto.setBackground(new Color(255,255,255)); // define a cor de fundo do JTable
		table_consulta_produto.setBounds(0, 88, 910, 590);
		DefaultTableModel model = (DefaultTableModel) table_consulta_produto.getModel(); //
		model.addColumn("Descrição"); // adiciona a coluna 0
		model.addColumn("Marca"); // adiciona a coluna 1
		model.addColumn("Preço"); // adiciona a coluna 2
		model.addColumn("Quantidade no estoque"); // adiciona a coluna 3

		table_consulta_produto.getColumnModel().getColumn(0).setPreferredWidth(100); // define a largura da coluna 0
		table_consulta_produto.getColumnModel().getColumn(1).setPreferredWidth(150); // define a largura da coluna 1
		table_consulta_produto.getColumnModel().getColumn(2).setPreferredWidth(80); // define a largura da coluna 2
		table_consulta_produto.getColumnModel().getColumn(3).setPreferredWidth(175); // define a largura da coluna 3

		
		JScrollPane scrollPaneProduto = new JScrollPane(table_consulta_produto);
		scrollPaneProduto.setLocation(0, 88);
		scrollPaneProduto.setSize(910, 590);
		scrollPaneProduto.setPreferredSize(new Dimension(910, 590)); // define a largura e altura do ScrollPane
		javax.swing.JViewport viewport = scrollPaneProduto.getViewport(); // define a cor de fundo do ScrollPane
		viewport.setBackground(new Color(255,255,255)); // define a cor de fundo do ScrollPane
		PainelConsultaProduto.add(scrollPaneProduto);
		try {
			
            CONEXAO novaConexao = new CONEXAO();
            Connection conectar = novaConexao.getConexao();
            Connection conn = conectar;
           
            // Procedimentos para obter os dados de uma tabela
            java.sql.Statement stmt = conn.createStatement();

            String cod = tf_Cod_Produto.getText();
            String query = "";
            
            if (cod.equals("")) {
            query = "SELECT produto.descricao, produto.marca, produto.preco, produto.quantidadeestoque from produto";
			System.out.println("Query executada");
            } else if (!cod.equals("")) {
            query = "SELECT produto.descricao, produto.marca, produto.preco, produto.quantidadeestoque from produto WHERE cod='"+cod+"'";
            }
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
            String descricao = ( rs.getString("produto.descricao"));
            String marca = ( rs.getString("produto.marca") );
            Double preco = (rs.getDouble("produto.preco"));
            int quantidadeestoque = ( rs.getInt("produto.quantidadeestoque"));
            
            model.addRow(new Object[]{descricao, marca, preco, quantidadeestoque});
            }
            } catch (SQLException erro_consulta_cliente) {
            
            }
    
		
		}
		});
		bt_BuscarProduto.setBounds(667, 34, 117, 29);
		PainelConsultaProduto.add(bt_BuscarProduto);
	}
public void ConsultaPedido() {
		JPanel PauinelConsultapedido = new JPanel();
		layeredPane.setLayer(PauinelConsultapedido, 0);
		PauinelConsultapedido.setBounds(0, 0, 910, 686);
		layeredPane.add(PauinelConsultapedido);
		PauinelConsultapedido.setBackground(new Color(255, 255, 255));
		PauinelConsultapedido.setLayout(null);
		
		
		JLabel lbl_Cod_Pedido = new JLabel("Codigo do Pedido");
		lbl_Cod_Pedido.setBounds(30, 31, 110, 30);
		PauinelConsultapedido.add(lbl_Cod_Pedido);
		
		JTextField tf_Cod_Pedido = new JTextField();
		tf_Cod_Pedido.setBounds(139, 34, 164, 26);
		PauinelConsultapedido.add(tf_Cod_Pedido);
		tf_Cod_Pedido.setColumns(10);
		//tf_Cod_Pedido.addKeyListemer()
		JLabel lbl_Cod_Produto = new JLabel("Codigo do Produto");
		lbl_Cod_Produto.setBounds(310, 39, 110, 16);
		PauinelConsultapedido.add(lbl_Cod_Produto);
		
		JTextField tf_cod_Produto = new JTextField();
		tf_cod_Produto.setBounds(415, 35, 238, 27);
		PauinelConsultapedido.add(tf_cod_Produto);
		tf_cod_Produto.setColumns(10);
		
		JButton btn_Buusca_Pedido = new JButton("Buscar");
		btn_Buusca_Pedido.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		//if (table_ConsultaCliente != null && scrollPaneCliente != null) {
		// table_ConsultaCliente=null;
		// scrollPaneCliente.getViewport().removeAll();
		// table_ConsultaCliente = new JTable();
		// scrollPaneCliente = new JScrollPane(table_ConsultaCliente);
		//}
		
		JTable table_consulta_pedido = new JTable();
		table_consulta_pedido.setBackground(new Color(255,255,255)); // define a cor de fundo do JTable
		table_consulta_pedido.setBounds(0, 88, 910, 590);
		DefaultTableModel model = (DefaultTableModel) table_consulta_pedido.getModel(); //
		model.addColumn("id"); // adiciona a coluna 0
		model.addColumn("data"); // adiciona a coluna 1
		model.addColumn("CPF"); // adiciona a coluna 2
		model.addColumn("Nome do Produto"); // adiciona a coluna 3
		model.addColumn("Quantidade");
		model.addColumn("valor");
		model.addColumn("Subtotal");
		table_consulta_pedido.getColumnModel().getColumn(0).setPreferredWidth(80); // define a largura da coluna 0
		table_consulta_pedido.getColumnModel().getColumn(1).setPreferredWidth(150); // define a largura da coluna 1
		table_consulta_pedido.getColumnModel().getColumn(2).setPreferredWidth(100); // define a largura da coluna 2
		table_consulta_pedido.getColumnModel().getColumn(3).setPreferredWidth(100); // define a largura da coluna 3
		table_consulta_pedido.getColumnModel().getColumn(4).setPreferredWidth(100); // define a largura da coluna 3
		table_consulta_pedido.getColumnModel().getColumn(5).setPreferredWidth(100); // define a largura da coluna 3
		table_consulta_pedido.getColumnModel().getColumn(6).setPreferredWidth(100); // define a largura da coluna 3

		
		JScrollPane scrollPaneProduto = new JScrollPane(table_consulta_pedido);
		scrollPaneProduto.setLocation(0, 88);
		scrollPaneProduto.setSize(910, 590);
		scrollPaneProduto.setPreferredSize(new Dimension(910, 590)); // define a largura e altura do ScrollPane
		javax.swing.JViewport viewport = scrollPaneProduto.getViewport(); // define a cor de fundo do ScrollPane
		viewport.setBackground(new Color(255,255,255)); // define a cor de fundo do ScrollPane
		PauinelConsultapedido.add(scrollPaneProduto);
		try {
			
            CONEXAO novaConexao = new CONEXAO();
            Connection conectar = novaConexao.getConexao();
            Connection conn = conectar;
           
            // Procedimentos para obter os dados de uma tabela
            java.sql.Statement stmt = conn.createStatement();

            String id = tf_Cod_Pedido.getText().trim();
			String cod = tf_cod_Produto.getText().trim();
            String query = "";
            
            if (cod.isEmpty() && id.isEmpty()) {
            query = "SELECT pedido.id, pedido.data, pedido.cliente_cpf, produto.marca, itempedido.quantidade, itempedido.valor, itempedido.subtotal from itempedido JOIN pedido ON itempedido.pedido_id=pedido.id JOIN produto ON itempedido.produto_cod=produto.cod";
			
            } else if (cod.isEmpty() && !id.isEmpty()) {
            query = "SELECT pedido.id, pedido.data, pedido.cliente_cpf, produto.marca, itempedido.quantidade, itempedido.valor, itempedido.subtotal from itempedido JOIN pedido ON itempedido.pedido_id=pedido.id JOIN produto ON itempedido.produto_cod=produto.cod WHERE pedido.id = '"+id+"'";
            }else if (!cod.isEmpty() && !id.isEmpty()) {
            query = "SELECT pedido.id, pedido.data, pedido.cliente_cpf, produto.marca, itempedido.quantidade, itempedido.valor, itempedido.subtotal from itempedido JOIN pedido ON itempedido.pedido_id=pedido.id JOIN produto ON itempedido.produto_cod=produto.cod WHERE produto.cod = '"+cod+"' AND pedido.id='"+id+"'";
            }
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
            String id_pedido = ( rs.getString("pedido.id"));
            Date data = ( rs.getDate("pedido.data") );
            String cpf = (rs.getString("pedido.cliente_cpf"));
            String nome_produto = ( rs.getString("produto.marca"));
            int quantidade = ( rs.getInt("itempedido.quantidade"));
            Double valor = ( rs.getDouble("itempedido.valor"));
            Double subtotal = ( rs.getDouble("itempedido.subtotal"));

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String strdataretirada = sdf.format(data);

            model.addRow(new Object[]{id_pedido, strdataretirada, cpf, nome_produto, quantidade, valor, subtotal});
            }
            } catch (SQLException erro_consulta_pedido) {
				System.out.println("Erro consultar pedido!\n"+erro_consulta_pedido.getMessage());
            }
    
		
		}
		});
		btn_Buusca_Pedido.setBounds(667, 34, 117, 29);
		PauinelConsultapedido.add(btn_Buusca_Pedido);
	}

	public void TELAPEDIDO() {
		JPanel Pane_Pedido = new JPanel();
		layeredPane.setLayer(Pane_Pedido, 0);
		Pane_Pedido.setBounds(0, 0, 910, 686);
		layeredPane.add(Pane_Pedido);
		Pane_Pedido.setBackground(new Color(255, 255, 255));
		//setPane_Pedido(Pane_Pedido);
		Pane_Pedido.setLayout(null);

		Pedido pedido = new Pedido();
		Itempedido itempedido = new Itempedido();
		JTable table_Insere_pedido = new JTable();
		table_Insere_pedido.setBackground(new Color(255,255,255)); // define a cor de fundo do JTable
		table_Insere_pedido.setBounds(0, 0, 500, 475);
		DefaultTableModel model = (DefaultTableModel) table_Insere_pedido.getModel(); //
		model.addColumn("Codigo do produto");
		model.addColumn("Nome do produto"); // adiciona a coluna 0
		model.addColumn("Descrição"); // adiciona a coluna 1
		model.addColumn("Valor"); // adiciona a coluna 2
		model.addColumn("Subtotal"); // adiciona a coluna 3
		table_Insere_pedido.getColumnModel().getColumn(0).setPreferredWidth(150);
		table_Insere_pedido.getColumnModel().getColumn(1).setPreferredWidth(150); // define a largura da coluna 0
		table_Insere_pedido.getColumnModel().getColumn(2).setPreferredWidth(150); // define a largura da coluna 1
		table_Insere_pedido.getColumnModel().getColumn(3).setPreferredWidth(80); // define a largura da coluna 2
		table_Insere_pedido.getColumnModel().getColumn(4).setPreferredWidth(150); // define a largura da coluna 3
		
		
		JScrollPane ScrollPane_Insere_pedido = new JScrollPane(table_Insere_pedido);
		ScrollPane_Insere_pedido.setLocation(335, 88);
		ScrollPane_Insere_pedido.setSize(500, 475);
		ScrollPane_Insere_pedido.setPreferredSize(new Dimension(910, 590)); // define a largura e altura do ScrollPane
		javax.swing.JViewport viewport = ScrollPane_Insere_pedido.getViewport(); // define a cor de fundo do ScrollPane
		viewport.setBackground(new Color(255,255,255)); // define a cor de fundo do ScrollPane
		Pane_Pedido.add(ScrollPane_Insere_pedido);
		
		JLabel lblNewLabel = new JLabel("PEDIDO");
		lblNewLabel.setBounds(396, 34, 102, 29);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		Pane_Pedido.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cpf");
		lblNewLabel_1.setBounds(82, 186, 34, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		Pane_Pedido.add(lblNewLabel_1);
		
		JTextField tf_Cpf = new JTextField();
		tf_Cpf.setBounds(107, 183, 129, 20);
		Pane_Pedido.add(tf_Cpf);
		tf_Cpf.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Id do pedido");
		lblNewLabel_2.setBounds(30, 158, 75, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		Pane_Pedido.add(lblNewLabel_2);
		
		JTextField tf_Id = new JTextField();
		tf_Id.setBounds(107, 155, 70, 20);
		Pane_Pedido.add(tf_Id);
		tf_Id.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Data");
		lblNewLabel_3.setBounds(82, 122, 46, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		Pane_Pedido.add(lblNewLabel_3);
		
		JDateChooser dt_data = new JDateChooser();
		dt_data.setBounds(115, 120, 213, 26);
		Pane_Pedido.add(dt_data);

		JButton btn_Cadastrar_pedido = new JButton("Cadastrar Pedido");
		btn_Cadastrar_pedido.setBounds(10, 230, 140, 23);
		btn_Cadastrar_pedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat converterdata = new SimpleDateFormat("yyyy/MM/dd");
                pedido.setData(converterdata.format(dt_data.getDate()));
				pedido.setCliente_cpf(tf_Cpf.getText());
				pedido.setId(tf_Id.getText());
				PedidoDAO.insere(pedido);
				
			}
		});
		btn_Cadastrar_pedido.setFont(new Font("Tahoma", Font.BOLD, 11));
		Pane_Pedido.add(btn_Cadastrar_pedido);

		JButton btn_Buscar_pedido = new JButton("Buscar pedido");
		btn_Buscar_pedido.setBounds(155, 230, 140, 23);
		btn_Buscar_pedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pedido.setId(tf_Id.getText());
				PedidoDAO.buscaClienteDoPedido(pedido);
				SimpleDateFormat formatorecebido = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				SimpleDateFormat formatoexibicao = new SimpleDateFormat("d'de'MMM'de'y");
				Date dataformatada = null;
				try {
					dataformatada = formatorecebido.parse(pedido.getData());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				formatoexibicao.format(dataformatada);
				tf_Cpf.setText(pedido.getCliente_cpf());
				dt_data.setDate(dataformatada);
			}
		});
		btn_Buscar_pedido.setFont(new Font("Tahoma", Font.BOLD, 11));
		Pane_Pedido.add(btn_Buscar_pedido);

		JButton btn_Atualizar_pedido = new JButton("Atualizar pedido");
		btn_Atualizar_pedido.setBounds(10, 260, 140, 23);
		btn_Atualizar_pedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pedido.setId(tf_Id.getText());
				PedidoDAO.atualiza(pedido);
				tf_Cpf.setText("");
				tf_Id.setText("");
				dt_data.setToolTipText("");
				
			}
		});
		btn_Atualizar_pedido.setFont(new Font("Tahoma", Font.BOLD, 11));
		Pane_Pedido.add(btn_Atualizar_pedido);

		JButton btn_Excluir_pedido = new JButton("Excluir");
		btn_Excluir_pedido.setBounds(155, 260, 140, 23);
		btn_Excluir_pedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pedido.setId(tf_Id.getText());
				PedidoDAO.deleta(pedido);
				tf_Cpf.setText("");
				tf_Id.setText("");
				dt_data.setToolTipText("");
			}
		});
		btn_Excluir_pedido.setFont(new Font("Tahoma", Font.BOLD, 11));
		Pane_Pedido.add(btn_Excluir_pedido);
		
		JLabel lblNewLabel_4 = new JLabel("Codigo do Produto");
		lblNewLabel_4.setBounds(10, 326, 107, 14);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		Pane_Pedido.add(lblNewLabel_4);
		
		JTextField tf_Codigo_produto = new JTextField();
		tf_Codigo_produto.setBounds(130, 323, 60, 20);
		Pane_Pedido.add(tf_Codigo_produto);
		tf_Codigo_produto.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Quantidade");
		lblNewLabel_5.setBounds(10, 354, 70, 14);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		Pane_Pedido.add(lblNewLabel_5);
		
		JTextField tf_Quantidade = new JTextField();
		tf_Quantidade.setBounds(130, 351, 54, 20);
		Pane_Pedido.add(tf_Quantidade);
		tf_Quantidade.setColumns(10);

		btn_Inserir = new JButton("Inserir produto");
		btn_Inserir.setBounds(10, 400, 120, 23);
		btn_Inserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
			
					CONEXAO novaConexao = new CONEXAO();
					Connection conectar = novaConexao.getConexao();
					Connection conn = conectar;
				   
					// Procedimentos para obter os dados de uma tabela
					java.sql.Statement stmt = conn.createStatement();
		
					String quantidade = tf_Quantidade.getText();
					String id_produto = tf_Codigo_produto.getText();
					String query = "";
					
					if (!id_produto.equals("")) {
					query = "SELECT produto.cod, produto.preco, produto.marca, produto.descricao from produto where produto.cod ='"+id_produto+"' ";
					System.out.println("Query executada");
					}
		
					ResultSet rs = stmt.executeQuery(query);
					
					while (rs.next()) {
					String cod = ( rs.getString("produto.cod") );
					String nome = ( rs.getString("produto.marca") );
					String descricao = (rs.getString("produto.descricao"));
					Double valor = ( rs.getDouble("produto.preco"));
					Double subtotal = valor * Double.parseDouble(quantidade);
					System.out.println(subtotal);
					boolean produtoExistente = false;
					int rowIndex = -1;
					for (int i = 0; i < model.getRowCount(); i++) {
						if (nome.equals(model.getValueAt(i, 1))) {
							produtoExistente = true;
							rowIndex = i;
							break;
						}
					}
			
					// Se o produto já está na lista, atualiza a quantidade e o subtotal
					if (produtoExistente) {
						Double quantidadeExistente = Double.parseDouble(model.getValueAt(rowIndex, 3).toString());
						Double subtotalExistente = Double.parseDouble(model.getValueAt(rowIndex, 4).toString());
						quantidadeExistente += Double.parseDouble(quantidade);
						subtotalExistente += subtotal;
						model.setValueAt(quantidadeExistente, rowIndex, 3);
						model.setValueAt(subtotalExistente, rowIndex, 4);
					} else {
						// Se o produto não está na lista, adiciona uma nova linha na tabela
						model.addRow(new Object[]{cod, nome, descricao,valor, subtotal});
					}
					
				}
					} catch (SQLException erro_consulta_cliente) {
					JOptionPane.showMessageDialog(null,"Erro inserir produto\n"+ erro_consulta_cliente.getMessage());
					}
			}
		});
		btn_Inserir.setFont(new Font("Tahoma", Font.BOLD, 11));
		Pane_Pedido.add(btn_Inserir);

		JButton btn_Excluir_Produto = new JButton("Excluir");
		btn_Excluir_Produto.setBounds(135, 400, 90, 23);
		btn_Excluir_Produto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigoexcluir = tf_Codigo_produto.getText();
					int rowIndex = -1;
					for (int i = 0; i < model.getRowCount(); i++) {
						if (codigoexcluir.equals(model.getValueAt(i, 0))) {
							rowIndex = i;
							break;
						}
					}
					if(rowIndex!=-1){
						model.removeRow(rowIndex);	

					}else{
						JOptionPane.showMessageDialog(null,"Produto não encontrado na tabela");
					}
			}
		});
		btn_Excluir_Produto.setFont(new Font("Tahoma", Font.BOLD, 11));
		Pane_Pedido.add(btn_Excluir_Produto);

		JButton btn_Alterar_Produto = new JButton("Alterar");
		btn_Alterar_Produto.setBounds(230, 400, 90, 23);
		btn_Alterar_Produto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codalterar = tf_Codigo_produto.getText();
				int rowIndex = -1;
					for (int i = 0; i < model.getRowCount(); i++) {
						if (codalterar.equals(model.getValueAt(i, 0))) {
							rowIndex = i;
							break;
						}
					}
					if(rowIndex!= -1){
						model.removeRow(rowIndex);
						try {
			
							CONEXAO novaConexao = new CONEXAO();
							Connection conectar = novaConexao.getConexao();
							Connection conn = conectar;
						   
							// Procedimentos para obter os dados de uma tabela
							java.sql.Statement stmt = conn.createStatement();
				
							String quantidade = tf_Quantidade.getText();
							String id_produto = tf_Codigo_produto.getText();
							String query = "";
							
							if (!id_produto.equals("")) {
							query = "SELECT produto.cod, produto.preco, produto.marca, produto.descricao from produto where produto.cod ='"+codalterar+"' ";
							System.out.println("Query executada");
							}
				
							ResultSet rs = stmt.executeQuery(query);
							
							while (rs.next()) {
							String cod = ( rs.getString("produto.cod") );
							String nome = ( rs.getString("produto.marca") );
							String descricao = (rs.getString("produto.descricao"));
							Double valor = ( rs.getDouble("produto.preco"));
							Double subtotal = valor * Double.parseDouble(quantidade);
							System.out.println(subtotal);
							boolean produtoExistente = false;
							int rowindex1 = -1;
							for (int i = 0; i < model.getRowCount(); i++) {
								if (nome.equals(model.getValueAt(i, 1))) {
									produtoExistente = true;
									rowindex1 = i;
									break;
								}
							}
					
							// Se o produto já está na lista, atualiza a quantidade e o subtotal
							if (produtoExistente) {
								Double quantidadeExistente = Double.parseDouble(model.getValueAt(rowindex1, 3).toString());
								Double subtotalExistente = Double.parseDouble(model.getValueAt(rowindex1, 4).toString());
								quantidadeExistente += Double.parseDouble(quantidade);
								subtotalExistente += subtotal;
								model.setValueAt(quantidadeExistente, rowindex1, 3);
								model.setValueAt(subtotalExistente, rowindex1, 4);
							} else {
								// Se o produto não está na lista, adiciona uma nova linha na tabela
								model.addRow(new Object[]{cod, nome, descricao, valor, subtotal});
							}
							
						}
							} catch (SQLException erro_consulta_cliente) {
							JOptionPane.showMessageDialog(null,"Erro inserir produto\n"+ erro_consulta_cliente.getMessage());
							}
					}
				
			}
		});
		btn_Alterar_Produto.setFont(new Font("Tahoma", Font.BOLD, 11));
		Pane_Pedido.add(btn_Alterar_Produto);

		
		
		JButton btn_Concluir_pedido = new JButton("Concluir pedido");
		btn_Concluir_pedido.setBounds(500, 579, 150, 23);
		btn_Concluir_pedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double subtotalExistente=0.0;
				int codproduto=0;
				int rowindex = -1;
				for (int i = 0; i < model.getRowCount(); i++) {
						rowindex = i;
						subtotalExistente += Double.parseDouble(model.getValueAt(rowindex, 4).toString());
						codproduto += Integer.parseInt(model.getValueAt(rowindex, 0).toString());
							
				}
				System.out.println(1);
				model.addRow(new Object[]{"VALOR TOTAL ", "", "",codproduto, subtotalExistente});
				DefaultTableModel model = (DefaultTableModel) table_Insere_pedido.getModel();

				int rowCount = model.getRowCount();

				for (int i = 0; i < rowCount; i++) {
   				 Object[] rowData = new Object[model.getColumnCount()];

   				 for (int j = 0; j < model.getColumnCount(); j++) {
        		rowData[j] = model.getValueAt(i, j);
    					}
					}
					 model = (DefaultTableModel) table_Insere_pedido.getModel();

rowCount = model.getRowCount();
StringBuilder message = new StringBuilder();

for (int i = 0; i < rowCount; i++) {
    Object[] rowData = new Object[model.getColumnCount()];
    for (int j = 0; j < model.getColumnCount(); j++) {
        rowData[j] = model.getValueAt(i, j);
        message.append(rowData[j]).append("\t"); // Assuming tab-separated values
    }
    message.append("\n"); // Newline to separate rows
}

JOptionPane.showMessageDialog(null, message.toString());
			}
			
		});
		btn_Concluir_pedido.setFont(new Font("Tahoma", Font.BOLD, 11));
		Pane_Pedido.add(btn_Concluir_pedido);
		
		JButton btn_Cancelar_pedido = new JButton("Cancelar pedido");
		btn_Cancelar_pedido.setBounds(680, 579, 150, 23);
		btn_Cancelar_pedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pedido.setId(tf_Id.getText());
				PedidoDAO.deleta(pedido);
				tf_Cpf.setText("");
				dt_data.setDate(null);
				tf_Id.setText("");
				tf_Codigo_produto.setText("");
				tf_Quantidade.setText("");
				
				
			}
		});
		btn_Cancelar_pedido.setFont(new Font("Tahoma", Font.BOLD, 11));
		Pane_Pedido.add(btn_Cancelar_pedido);
			
		}
			
	
    public void limparpainel() {
		
        layeredPane.removeAll();
        layeredPane.repaint();
        layeredPane.revalidate();
    }
    public MaskFormatter Mascara(String Mascara){
           
        MaskFormatter F_Mascara = new MaskFormatter();
        try{
            F_Mascara.setMask(Mascara); //Atribui a mascara
            F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento
        }
        catch (Exception excecao) {
        excecao.printStackTrace();
        }
        return F_Mascara;
 }
}