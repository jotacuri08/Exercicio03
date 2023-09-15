package dao;

import model.Veiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class VeiculoDAO extends DAO {	
	public VeiculoDAO() {
		super();
		conectar();
	}
	
	
	public void finalize() {
		close();
	}
	
	/*
	 private List<Veiculo> get(String orderBy) {
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM veiculos" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Veiculo v = new Veiculo(rs.getInt("id"), rs.getString("marca"), rs.getString("modelo"),
	        			rs.getInt("ano"), (float)rs.getDouble("quilometragem")); 
	            veiculos.add(v);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return veiculos;
	}
	 */
	
	
	public boolean insert(Veiculo veiculo) {
	    boolean status = false;
	    try {
	        String sql = "INSERT INTO veiculos (id, marca, modelo, ano, quilometragem) VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement st = conexao.prepareStatement(sql);
	        st.setInt(1, veiculo.getID());
	        st.setString(2, veiculo.getMarca());
	        st.setString(3, veiculo.getModelo());
	        st.setInt(4, veiculo.getAno());
	        st.setFloat(5, veiculo.getQuilometragem());
	        st.executeUpdate();
	        st.close();
	        status = true;
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	    return status;
	}

	
	public Veiculo get(int id) {
		Veiculo veiculo = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM veiculos WHERE id="+id;
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 veiculo = new Veiculo(rs.getInt("id"), rs.getString("marca"), rs.getString("modelo"), 
	                				   rs.getInt("ano"), 
	        			               (float)rs.getDouble("quilometragem"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return veiculo;
	}
	
	
	public List<Veiculo> get() {
		return get("");
	}
	
	public List<Veiculo> getOrderByID() {
		return get("id");		
	}
	
	
	public List<Veiculo> getOrderByMarca() {
		return get("marca");		
	}
	
	
	public List<Veiculo> getOrderByAno() {
		return get("ano");		
	}
	
	
	private List<Veiculo> get(String orderBy) {
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM veiculos" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Veiculo v = new Veiculo(rs.getInt("id"), rs.getString("marca"), rs.getString("modelo"),
	        			rs.getInt("ano"), (float)rs.getDouble("quilometragem")); 
	            veiculos.add(v);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return veiculos;
	}
	
	
	public boolean update(Veiculo veiculo) {
		boolean status = false;
		try {  
			String sql = "UPDATE veiculos SET marca = " + veiculo.getMarca() + ", "
					   + "modelo = " + veiculo.getModelo() + ", " 
					   + "ano = " + veiculo.getAno() + ","
					   + "quilometragem = " + veiculo.getQuilometragem() + "WHERE id = " + veiculo.getID();
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM veiculos WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
}