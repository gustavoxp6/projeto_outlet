package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CONEXAO {

    private static String url = "jdbc:mysql://localhost:3306/outlet";
    private static String user = "root";
    private static String pass = "";

    private static Connection conectar;

    public CONEXAO() {
        try {
            if (conectar ==  null) {
                conectar = DriverManager.getConnection(url, user, pass);
                System.out.println("Banco de dados conectado com sucesso!");
            } else {
                System.out.println("Banco de dados conectado com sucesso!");
            }
        } catch (SQLException erro_conectar_banco) {
            System.out.println("Erro ao conectar no banco de dados!\n" + erro_conectar_banco.getMessage());
        }
    }

    public Connection getConexao() {
        return conectar;
    }

    public void finalizarConexao() {
        try {
            conectar.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}