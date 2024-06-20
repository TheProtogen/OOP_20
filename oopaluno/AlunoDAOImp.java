package oopaluno;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOImp implements AlunoDAO {

    private ConnectionBuilder c = null;

    public AlunoDAOImp() throws AlunoException { 
        try { 
            c = ConnectionBuilder.getInstance();
        } catch (Exception e) { 
            throw new AlunoException( e );
        }
    }

    @Override
    public void adicionar(Aluno a) {
        try {
            Connection con = c.getConnection();
            String sql = 
            """
            INSERT INTO aluno VALUES (?,?,?,?);        
            """;

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, a.getId());
            ps.setString(2, a.getRa());
            ps.setString(3, a.getNome());
            ps.setDate(4, Date.valueOf(a.getNascimento()));

            ps.executeUpdate();
            con.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Aluno> pesquisar(String conteudo) {
        try { 
            
            List<Aluno> lista = new ArrayList<Aluno>();
            Connection con = c.getConnection();

            String sql = 
            """
            SELECT * FROM aluno WHERE nome LIKE ?
            """;
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + conteudo + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) { 
                Aluno a = new Aluno();
                a.setId(rs.getLong("id"));
                a.setRa(rs.getString("ra"));
                a.setNome(rs.getString("nome"));
                a.setNascimento(rs.getDate("nascimento").toLocalDate());
                lista.add(a);
            }

            ps.close();
            con.close();
            
            return lista;
        } catch (Exception e) { 
            return null;
        }
         
    }
    
}
