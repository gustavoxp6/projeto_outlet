package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;



import ENTIDADES.Cliente;

public class ClienteDAO {
  
    private static PreparedStatement preparar;
    public static Connection conectar;
    public ClienteDAO() {
        CONEXAO novaConexao = new CONEXAO();
        conectar = novaConexao.getConexao();
        preparar = null;
    }
    
    public static int insereCliente(Cliente cliente){
         /*  `cpf` CHAR(14) NOT NULL PRIMARY KEY,
        `nome` VARCHAR(100) NOT NULL,
        `datanascimento` DATE NOT NULL,
        `email` VARCHAR(45) NOT NULL UNIQUE,
        `telefone` CHAR(15) NOT NULL */
        int val = 0;
        try {
            String sql = "INSERT INTO cliente(cpf,nome,datanascimento,email,telefone) values(?,?,?,?,?)";
            preparar = conectar.prepareStatement(sql);
            System.out.println("Chegou aqui!");
            preparar.setString(1,cliente.getCpf());
            preparar.setString(2,cliente.getNome());
            preparar.setString(3,cliente.getDatanascimento());
            preparar.setString(4,cliente.getEmail());
            preparar.setString(5,cliente.getTelefone());
            val += preparar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir cliente!\n"+ e.getMessage());
        }        
        return val;
    }
    public static int deletaCliente(Cliente cliente) {
        int val = 0;
        try {
            String sql = "DELETE FROM cliente WHERE cpf = ?";
            preparar = conectar.prepareStatement(sql);
            preparar.setString(1,cliente.getCpf());            
            val += preparar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente Deletado❗❗");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar cliente!\n"+ e.getMessage());
        }        
        return val;
        
    }
    public static int atualizaCliente(Cliente cliente){
        int val = 0;
        try {
            String sql = "UPDATE cliente set nome = ?,datanascimento = ?,email = ?,telefone = ? where cpf = ?";
            preparar = conectar.prepareStatement(sql);            
            preparar.setString(1,cliente.getNome());
            preparar.setString(2,cliente.getDatanascimento());
            preparar.setString(3,cliente.getEmail());
            preparar.setString(4,cliente.getTelefone());
            preparar.setString(5,cliente.getCpf());
            val += preparar.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente!\n"+ e.getMessage());
        }        
        return val;
    }
    public static Cliente buscaCliente(Cliente cliente){
       
        
        try {
            String sql = "select nome,datanascimento,email,telefone from cliente where cpf = '"+cliente.getCpf()+"'";
            
            
            Statement stmt = conectar.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                
                cliente.setNome(resultado.getString("nome"));
                cliente.setDatanascimento(resultado.getString("datanascimento"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setTelefone(resultado.getString("telefone"));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente!\n"+ e.getMessage());
        }
        return cliente;
    }

    public static void start(Connection conexao) {
    }
    
}