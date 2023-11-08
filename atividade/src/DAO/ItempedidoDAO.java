package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;

import ENTIDADES.Itempedido;

public class ItempedidoDAO {
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement ps;
    public static void start(Connection conn){
        con = conn;
    }
    public static int insere(Itempedido itempedido){
          /*
     * CREATE TABLE IF NOT EXISTS `outlet`.`itempedido` (
  `pedido_id` INT NOT NULL,
  `produto_cod` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `valor` DECIMAL(8,2) NOT NULL,
  `subtotal` DECIMAL(10,2) NOT NULL,
  INDEX `fk_itempedido_pedido1_idx` (`pedido_id` ASC),
  INDEX `fk_itempedido_produto1_idx` (`produto_cod` ASC),
  PRIMARY KEY (`pedido_id`, `produto_cod`),
  CONSTRAINT `fk_itempedido_pedido1`
    FOREIGN KEY (`pedido_id`)
    REFERENCES `outlet`.`pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itempedido_produto1`
    FOREIGN KEY (`produto_cod`)
    REFERENCES `outlet`.`produto` (`cod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
     */
        int vl = 0;
        try {
            // Busca o preço do produto específico que queremos inserir.
            String sql0 = "SELECT preco FROM produto WHERE cod = ?";
            PreparedStatement ps0 = con.prepareStatement(sql0);
            // Define o código do produto para a consulta.
            ps0.setString(1, itempedido.getProduto_cod());
            rs = ps0.executeQuery();
    
            // Se houver um preço para o produto, continua para inserir o item de pedido.
            if (rs.next()) {
                double preco = rs.getDouble("preco");
                itempedido.setValor(preco); // Configura o preço no objeto itempedido.
    
                // Prepara a inserção do novo item de pedido.
                String sql1 = "INSERT INTO itempedido(pedido_id, produto_cod, quantidade, valor, subtotal) VALUES (?, ?, ?, ?, ?)";
                ps = con.prepareStatement(sql1);
                ps.setString(1, itempedido.getPedido_id());
                ps.setString(2, itempedido.getProduto_cod());
                ps.setInt(3, itempedido.getQuantidade());
                ps.setDouble(4, preco); // Usa o preço obtido anteriormente.
                ps.setDouble(5, itempedido.getQuantidade() * preco); // Calcula o subtotal.
    
                // Executa a inserção e obtém o valor de retorno.
                vl = ps.executeUpdate();

                String sql2 = "SELECT Subtotal FROM itempedido WHERE pedido_id = '"+itempedido.getPedido_id()+"' and produto_cod = '"+itempedido.getProduto_cod()+"'";
            PreparedStatement ps1 = con.prepareStatement(sql2);
            // Define o código do produto para a consulta.
            rs = ps1.executeQuery();
            // Se houver um preço para o produto, continua para inserir o item de pedido.
            if (rs.next()) {
                double Subtotal = rs.getDouble("Subtotal");
                itempedido.setSubtotal(Subtotal); // Configura o preço no objeto itempedido.
    
                if(vl > 0) {
                    JOptionPane.showMessageDialog(null, "Pedido inserido com sucesso!!");
                }
            }
        }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir item do pedido!\n" + e.getMessage());
        } finally {
            // Fechar as conexões ResultSet, PreparedStatement e Connection aqui
        }
        return vl;
    }
    public static int atualiza(Itempedido itempedido){
        int vl = 0;
            try {
                // Update the quantity for the itempedido
                String sql = "UPDATE itempedido SET quantidade=? WHERE pedido_id = ? and produto_cod=?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, itempedido.getQuantidade());
                ps.setString(2, itempedido.getPedido_id());
                ps.setString(3, itempedido.getProduto_cod());
                vl += ps.executeUpdate(); // Use executeUpdate() for update operation
            
                // Select the price for the product
                String sql1 ="SELECT preco FROM produto WHERE cod = ?";
                PreparedStatement ps1 = con.prepareStatement(sql1);
                ps1.setString(1, itempedido.getProduto_cod());
                rs = ps1.executeQuery();
                if (rs.next()) {
                    double preco = rs.getDouble("preco");
                    itempedido.setValor(preco);
            
                    // Update the subtotal and the value for the itempedido
                    String sql2 = "UPDATE itempedido SET subtotal=?, valor=? WHERE pedido_id=? and produto_cod=?";
                    PreparedStatement ps2 = con.prepareStatement(sql2);
                    ps2.setDouble(1, itempedido.getValor() * itempedido.getQuantidade());
                    ps2.setDouble(2, itempedido.getValor());
                    ps2.setString(3, itempedido.getPedido_id());
                    ps2.setString(4, itempedido.getProduto_cod());
                    vl += ps2.executeUpdate(); // Use executeUpdate() for update operation
                }

                String sql3 = "SELECT subtotal FROM itempedido WHERE pedido_id = ? AND produto_cod = ?";
                PreparedStatement ps3 = con.prepareStatement(sql3);
                ps3.setString(1, itempedido.getPedido_id()); // Set the first parameter (pedido_id)
                ps3.setString(2, itempedido.getProduto_cod()); // Set the second parameter (produto_cod)
                rs = ps3.executeQuery(); // Execute the query without passing the SQL string
                if (rs.next()) {
                    double subtotal = rs.getDouble("subtotal");
                    itempedido.setSubtotal(subtotal);
                    // If you need to update the text field or another component with this subtotal, you would do it here.
                }
            
                JOptionPane.showMessageDialog(null,"Produto Atualizado!!!");
            
        } catch (SQLException e) {
            System.out.println("Erro ao inserir item do pedido!\n"+ e.getMessage());
        }
        return vl;
    }
    static int vl;
    public static int buscaItensDoPedido(Itempedido itempedido){
    
        try {
            String sql ="SELECT pedido_id,produto_cod,quantidade,valor,subtotal FROM itempedido where pedido_id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,itempedido.getPedido_id());            
            rs = ps.executeQuery();
            while(rs.next()){
                itempedido.setPedido_id(rs.getString("pedido_id"));
                itempedido.setProduto_cod(rs.getString("produto_cod"));
                itempedido.setQuantidade(rs.getInt("quantidade"));
                itempedido.setValor(rs.getDouble("valor"));
                itempedido.setSubtotal(rs.getDouble("subtotal"));
                
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar itens do pedido!\n"+ e.getMessage());
        }
        
        return vl;

       
    }
    public static List<Itempedido> buscaPedidosDoItem(String id){
        Itempedido it = new Itempedido();
        ArrayList<Itempedido> ls = new ArrayList<Itempedido>();
        try {
            String sql ="SELECT pedido_id,produto_cod,quantidade,valor,subtotal FROM itempedido where produto_cod = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,id);            
            rs = ps.executeQuery();
            while(rs.next()){
                it.setPedido_id(rs.getString("pedido_id"));
                it.setProduto_cod(rs.getString("produto_cod"));
                it.setQuantidade(rs.getInt("quantidade"));
                it.setValor(rs.getDouble("valor"));
                it.setSubtotal(rs.getDouble("subtotal"));
                ls.add(it);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar itens do pedido!\n"+ e.getMessage());
        }

        return ls.subList(0, ls.size());
    }
}