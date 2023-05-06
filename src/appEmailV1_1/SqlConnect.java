package appEmailV1_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class SqlConnect {
	
	private  Connection con;
	private  PreparedStatement pst;
	private  ResultSet rs;
	private  ResultSetMetaData rss;
	private  String email;
	private  String comando;
	public int colunas;
	
	
	public Connection criarConexao() {
	
	try {
	con = DriverManager.getConnection("jdbc:mysql://databasejoabe.ddns.net:3306/javaAppEmail","javaAppEmail","smPvtJ@*!nq&5w%");
	} catch (Exception e) {
		e.printStackTrace();
	}
	return con;
}
	
	
	public void encerrarConexao() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// pesquisa o email pelo nome do professor, e registra o primeiro que encontrar
	public String pesquisaEmail(String nome) {
		comando = "SELECT email FROM tb_profs WHERE nome=?";
		
		try {
			pst = con.prepareStatement(comando);
			pst.setString(1, nome);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				this.email = rs.getString(1);
			} else {
				this.email = "0";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return email;
	}
	
	
	
	
		public Vector<Vector<String>> outrasInfos(String nome) {
		  
		Vector<Vector<String>> tabela = new Vector<Vector<String>>(40);
		
		comando = "SELECT `tb_profs`.*, `tb_profs_turmas`.`turma`, `tb_turmas`.`período` FROM `tb_profs` LEFT JOIN `tb_profs_turmas` ON `tb_profs_turmas`.`id_prof` = `tb_profs`.`id_prof` LEFT JOIN `tb_turmas` ON `tb_profs_turmas`.`turma` = `tb_turmas`.`turma` WHERE `tb_profs`.`nome` = ?";
		  
		  try {
				pst = con.prepareStatement(comando);
				pst.setString(1, nome);
				rs = pst.executeQuery();
				rss = rs.getMetaData();
				int q = rss.getColumnCount();
				this.colunas = q;
				
				
				while(rs.next()) {
					Vector<String> l1 = new Vector<String>();
					for (int i=0; i<=q; i++) {
						l1.add(rs.getString("id_prof"));
						l1.add(rs.getString("nome"));
						l1.add(rs.getString("sobrenomes"));
						l1.add(rs.getString("email"));
						l1.add(rs.getString("turma"));
						l1.add(rs.getString("período"));
					}
					tabela.add(l1);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  
		  return tabela;
	}
	
	
}
