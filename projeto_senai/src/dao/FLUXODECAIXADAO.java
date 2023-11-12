package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JOptionPane;

import entity.FLUXODECAIXA;

public class FLUXODECAIXADAO {
    
    private static PreparedStatement preparar;
    private static Connection conectar;

    public FLUXODECAIXADAO() {
        CONEXAO novaConexao = new CONEXAO();
        conectar = novaConexao.getConexao();
        preparar = null;
    }
    public void calculo_total(FLUXODECAIXA fluxodecaixa){
        String procedure="CALL calculo_total(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String query1="SELECT cod, total_de_saidas, total_de_entradas, saldo_do_dia, saldo_atual FROM fluxo_de_caixa WHERE cod=(SELECT cod FROM fluxo_de_caixa ORDER BY cod DESC LIMIT 1)";
        try{
            preparar = conectar.prepareStatement(procedure);
            preparar.setString(1,  fluxodecaixa.getData());
            preparar.setDouble(2, fluxodecaixa.getSaldo_anterior());
            preparar.setDouble(3, fluxodecaixa.getDinheiro());
            preparar.setDouble(4, fluxodecaixa.getCartao());
            preparar.setDouble(5, fluxodecaixa.getOutros_entradas());
            preparar.setDouble(6, fluxodecaixa.getFornecedores());
            preparar.setDouble(7, fluxodecaixa.getImpostos());
            preparar.setDouble(8, fluxodecaixa.getContas());
            preparar.setDouble(9, fluxodecaixa.getManuntencoes());
            preparar.setDouble(10, fluxodecaixa.getParcela_equipamento());
            preparar.setDouble(11, fluxodecaixa.getDespesa_bancaria());
            preparar.setDouble(12, fluxodecaixa.getSalario_funcionario());
            preparar.setDouble(13, fluxodecaixa.getProlabore());
            preparar.setDouble(14, fluxodecaixa.getOutras_saidas());
            preparar.execute();
            System.out.println("Procedure Executada com sucesso!!");
        }catch(SQLException erro_calcular){
            JOptionPane.showMessageDialog(null,"Erro ao calcular os valores!\n"+ erro_calcular.getMessage());
        }
        try {
            java.sql.Statement stmt = conectar.createStatement();
            ResultSet resultado = stmt.executeQuery(query1);

            while (resultado.next()) {
                fluxodecaixa.setCod(resultado.getInt("cod"));
                fluxodecaixa.setTotal_saidas(resultado.getDouble("total_de_saidas"));
                fluxodecaixa.setTotal_entrada(resultado.getDouble("total_de_entradas"));
                fluxodecaixa.setSaldo_do_dia(resultado.getDouble("saldo_do_dia"));
                fluxodecaixa.setSaldo_atual(resultado.getDouble("saldo_atual"));
            }
        } catch (SQLException erro_consultar_Registro) {
            System.out.println("Erro ao consultar registro!\n" + erro_consultar_Registro.getMessage());
        }
    }
    public void Buscar_fluxo(FLUXODECAIXA fluxodecaixa){
        String sql = "SELECT * from fluxo_de_caixa WHERE cod = "+fluxodecaixa.getCod();
        try {
            java.sql.Statement stmt = conectar.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                fluxodecaixa.setDinheiro(rs.getDouble("dinheiro"));
                fluxodecaixa.setCartao(rs.getDouble("cartao"));
                fluxodecaixa.setContas(rs.getDouble("contas"));
                fluxodecaixa.setData(rs.getString("data"));
                fluxodecaixa.setDespesa_bancaria(rs.getDouble("despesa_bancaria"));
                fluxodecaixa.setFornecedores(rs.getDouble("fornecedores"));
                fluxodecaixa.setImpostos(rs.getDouble("impostos"));
                fluxodecaixa.setManuntencoes(rs.getDouble("manutencao"));
                fluxodecaixa.setOutras_saidas(rs.getDouble("outras_saidas"));
                fluxodecaixa.setOutros_entradas(rs.getDouble("outras_entradas"));
                fluxodecaixa.setParcela_equipamento(rs.getDouble("parcela_de_equipamento"));
                fluxodecaixa.setProlabore(rs.getDouble("prolabore"));
                fluxodecaixa.setSalario_funcionario(rs.getDouble("salario_funcionario"));
                fluxodecaixa.setSaldo_anterior(rs.getDouble("saldo_dia_anterior"));
                fluxodecaixa.setTotal_saidas(rs.getDouble("total_de_saidas"));
                fluxodecaixa.setTotal_entrada(rs.getDouble("total_de_entradas"));
                fluxodecaixa.setSaldo_do_dia(rs.getDouble("saldo_do_dia"));
                fluxodecaixa.setSaldo_atual(rs.getDouble("saldo_atual"));
            }
    }catch(SQLException erro){
        JOptionPane.showMessageDialog(null, "Erro ao buscar os dados");
        }
    }
}