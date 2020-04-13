package br.mack.ps2.persistencia;
import br.mack.ps2.entidade.Pontuacao;

import java.sql.*;

public class PontuacaoDAOMySQL implements PontuacaoDAO {
    private final MySQLConnection mysql = new MySQLConnection();
    String createSQL = "INSERT INTO pontuacao (data, p_rodada, s_rodada, t_rodada, total) VALUES (?, ?, ?, ?, ?)";
    private String readSQL = "SELECT * FROM pontuacao";

    @Override
    public boolean create(Pontuacao pontuacao) {
        Connection conexao = mysql.getConnection();

        try {
            PreparedStatement stm = conexao.prepareStatement(createSQL);

            stm.setString(1, pontuacao.getData());
            stm.setInt(2, pontuacao.getP_rodada());
            stm.setInt(3, pontuacao.getS_rodada());
            stm.setInt(4, pontuacao.getT_rodada());
            stm.setInt(5, pontuacao.getTotal());

            int registros = stm.executeUpdate();

            return  registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public void read() {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String data = rs.getString("data");
                int p_rodada = rs.getInt("p_rodada");
                int s_rodada = rs.getInt("s_rodada");
                int t_rodada = rs.getInt("t_rodada");
                int total = rs.getInt("total");
                System.out.println("\nData: " + data + "\nPrimeira Rodada: " + p_rodada+ "\nSegunda Rodada: " + s_rodada + "\nTerceira Rodada: " + t_rodada + "\nTotal: " + total);
            }
            rs.close();
            conexao.close();

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
