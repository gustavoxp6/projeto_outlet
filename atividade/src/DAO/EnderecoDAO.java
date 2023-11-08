package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ENTIDADES.Endereco;

public class EnderecoDAO {
    
    private static PreparedStatement preparar;
    public static Connection conectar;
    public EnderecoDAO() {
        CONEXAO novaConexao = new CONEXAO();
        conectar = novaConexao.getConexao();
        preparar = null;
    }
    public static int insereEndereco(Endereco endereco){
        int val= 0;
        /*`id` INT NOT NULL AUTO_INCREMENT,
        `logradouro` VARCHAR(100) NOT NULL,
        `numero` VARCHAR(10) NOT NULL,
        `complemento` VARCHAR(45) NULL,
        `bairro` VARCHAR(45) NOT NULL,
        `cidade` VARCHAR(45) NOT NULL,
        `estado` VARCHAR(45) NOT NULL,
        `cep` CHAR(10) NOT NULL,
        `cliente_cpf` CHAR(14) NOT NULL, */
        try {
            String sql = "INSERT INTO endereco(logradouro,numero,complemento,bairro,cidade,estado,cep,cliente_cpf) values(?,?,?,?,?,?,?,?)";
            preparar = conectar.prepareStatement(sql);
            preparar.setString(1,endereco.getLogradouro());
            preparar.setString(2,endereco.getNumero());
            preparar.setString(3,endereco.getComplemento());
            preparar.setString(4,endereco.getBairro());
            preparar.setString(5,endereco.getCidade());
            preparar.setString(6,endereco.getEstado());
            preparar.setString(7,endereco.getCep());
            preparar.setString(8,endereco.getCliente_cpf());
            val += preparar.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir endereço!\n"+ e.getMessage());
        }
        return val;
    }
    public static int deletaEndereco(Endereco endereco){
        int resposta = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja excluir esses dados?","Confirmação",JOptionPane.YES_NO_OPTION);
        int val= 0;
        if(resposta == JOptionPane.YES_OPTION){
        String sql = "DELETE FROM endereco WHERE  cliente_cpf = ?";
        try {    
            preparar = conectar.prepareStatement(sql);
            preparar.setString(1,endereco.getCliente_cpf());
            val += preparar.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar endereço!\n"+ e.getMessage());
        }
    }    
        return val;
    }
    public static int atualizaEndereco(Endereco endereco){
        int val= 0;
        try {
            String sql = "UPDATE endereco SET logradouro =?,numero=?,complemento=?,bairro=?,cidade=?,estado=?,cep=? WHERE cliente_cpf=? ";
            preparar = conectar.prepareStatement(sql);
            preparar.setString(1,endereco.getLogradouro());
            preparar.setString(2,endereco.getNumero());
            preparar.setString(3,endereco.getComplemento());
            preparar.setString(4,endereco.getBairro());
            preparar.setString(5,endereco.getCidade());
            preparar.setString(6,endereco.getEstado());
            preparar.setString(7,endereco.getCep());
            preparar.setString(8,endereco.getCliente_cpf());
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso❗❗");
            val += preparar.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir endereço!\n"+ e.getMessage());
        }
        return val;
    }
    public static void buscaEnderecosDoCLiente(Endereco endereco){
        
        try {
            String sql = "select logradouro,numero,complemento,bairro,cidade,estado,cep from endereco where cliente_cpf ='"+endereco.getCliente_cpf()+"'";
            
            Statement stmt = conectar.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);
            
            while(resultado.next()){
                endereco.setLogradouro(resultado.getString("logradouro"));
                endereco.setBairro(resultado.getString("bairro"));
                endereco.setCep(resultado.getString("cep"));
                endereco.setCidade(resultado.getString("cidade"));
                endereco.setComplemento(resultado.getString("complemento"));
                endereco.setEstado(resultado.getString("estado"));
                endereco.setNumero(resultado.getString("numero"));
                
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar endereços!\n"+ e.getMessage());
        }
        
    }
    public static void start(Connection conexao) {
    }
    
    
    
    
}