package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ENTIDADES.Produto;

public class ProdutoDao {
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement ps;
    public static void start(Connection conn){
        con = conn;
    }
    public static int insereProduto(Produto produto){
         /*-- -----------------------------------------------------
-- Table `outlet`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outlet`.`produto` (
  `cod` INT NOT NULL,
  `descricao` VARCHAR(100) NOT NULL,
  `marca` VARCHAR(45) NULL,
  `preco` DECIMAL(8,2) NOT NULL,
  `quantidadeestoque` INT NOT NULL,
  PRIMARY KEY (`cod`))
ENGINE = InnoDB; */
        int vl = 0;
        String sql = "INSERT INTO produto(cod,descricao,marca,preco,quantidadeestoque) values (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,produto.getCod());
            ps.setString(2,produto.getDescricao());
            ps.setString(3,produto.getMarca());
            ps.setDouble(4,produto.getPreco());
            ps.setInt(5,produto.getQuantidadeestoque());
            
            vl += ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir produto!\n"+ e.getMessage());
        }
        return vl;
    }
    public static int deleta(Produto produto){
        int vl = 0;
        int opcao = JOptionPane.showConfirmDialog(null,"Tem certeza que você quer excluir o produto?","Confirmação",JOptionPane.YES_NO_OPTION);
        if(opcao==JOptionPane.YES_OPTION){
        try {
            String sql = "DELETE FROM produto WHERE cod = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,produto.getCod());            
            vl += ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto excluido com sucesso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar produto!\n"+ e.getMessage());
        }
    }
        return vl;
    }
    public static int atualiza(Produto produto){
        int vl = 0;
        try {
            String sql = "UPDATE produto SET descricao=?,marca=?,preco=?,quantidadeestoque=? WHERE cod = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,produto.getDescricao());
            ps.setString(2,produto.getMarca());
            ps.setDouble(3,produto.getPreco());
            ps.setInt(4,produto.getQuantidadeestoque());
            ps.setString(5,produto.getCod());
            vl += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir produto!\n"+ e.getMessage());
        }
        return vl;
    }
    public static Produto busca(Produto produto ){
       
        
        String sql =  "SELECT descricao,marca,preco,quantidadeestoque FROM produto WHERE cod = '"+produto.getCod()+"'";
        try {
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                produto.setDescricao(rs.getString("descricao"));
                produto.setMarca(rs.getString("marca"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidadeestoque(rs.getInt("quantidadeestoque"));
                System.out.println(produto.getMarca());
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Produto!\n"+ e.getMessage());
        }
        return produto;
    }

}