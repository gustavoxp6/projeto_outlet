package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import dao.FLUXODECAIXADAO;

public class TELADELOGIN extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tf_Usuario;
	private JTextField tf_Senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TELADELOGIN frame = new TELADELOGIN();
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
	public TELADELOGIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1036, 647);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		
		JLabel lblNewLabel = new JLabel("New label");
		
		
		JLabel lblNewLabel_2 = new JLabel("     Login");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(446, 100, 91, 28);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lb_usuario = new JLabel("Usuario");
		lb_usuario.setForeground(Color.WHITE);
		lb_usuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_usuario.setBounds(450, 137, 55, 13);
		getContentPane().add(lb_usuario);
		
		tf_Usuario = new JTextField();
		tf_Usuario.setBounds(450, 160, 96, 19);
		getContentPane().add(tf_Usuario);
		tf_Usuario.setColumns(10);
		
		JLabel lb_senha = new JLabel("Senha");
		lb_senha.setForeground(Color.WHITE);
		lb_senha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_senha.setBounds(450, 189, 45, 13);
		getContentPane().add(lb_senha);
		
		tf_Senha = new JTextField();
		tf_Senha.setBounds(450, 212, 96, 19);
		getContentPane().add(tf_Senha);
		tf_Senha.setColumns(10);
		
		JButton btn_Entrar = new JButton("Entrar");
		btn_Entrar.setForeground(Color.WHITE);
		btn_Entrar.setBackground(Color.BLACK);
		btn_Entrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Entrar.setBounds(450, 273, 103, 21);
		getContentPane().add(btn_Entrar);
		
		JButton btn_Cadastrar = new JButton("Cadastrar");
		btn_Cadastrar.setForeground(Color.WHITE);
		btn_Cadastrar.setBackground(Color.BLACK);
		btn_Cadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Cadastrar.setBounds(450, 311, 103, 21);
		getContentPane().add(btn_Cadastrar);
		
		JLabel lb_recuperar_senha = new JLabel("Recuperar senha");
		lb_recuperar_senha.setForeground(Color.WHITE);
		lb_recuperar_senha.setBounds(455, 232, 117, 13);
		getContentPane().add(lb_recuperar_senha);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(372, 53, 257, 376);
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\55819\\Downloads\\imagemNova2.png"));
		lblNewLabel_5.setBounds(0, 0, 1022, 610);
		getContentPane().add(lblNewLabel_5);
	}
}
