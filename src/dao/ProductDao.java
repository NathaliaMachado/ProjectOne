package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;


public class ProductDao {
	
    private Connection connection;
    
	
	public void create(Product product) throws Exception {
		
		this.connection = new ConnectionFactory().getConnection();
		
		PreparedStatement stmt = null;
		String sql = "INSERT INTO Product (price, description, warranty, costPrice, stock) " +
		"VALUES (?,?,?,?,?); " ;
		
		try {
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setDouble(1, product.getPrice());
			stmt.setString(2, product.getDescription());
			stmt.setDate(3, product.getWarranty());
			stmt.setDouble(4, product.getCostPrice());
			stmt.setString(5, product.getStock());
			
			stmt.execute();
			
		}
		catch (SQLException e) {
			throw new Exception(e);
			
		}
		finally {
			
			try {
				
				stmt.close();
				connection.close();
			}
			catch (SQLException e) {
				
				throw new Exception(e);
				
			}
		}
	}	
	
	
	public List<Product> getList() throws Exception {
		
		this.connection = new ConnectionFactory().getConnection();
		List<Product> products = new ArrayList<Product>();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		try {
			
			stmt = this.connection.prepareStatement("SELECT * FROM Product;");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				Product product = new Product();
				
				product.setCode(rs.getInt("code"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));
				product.setWarranty(rs.getDate("warranty"));
				product.setCostPrice(rs.getDouble("costPrice"));
				product.setStock(rs.getString("stock"));
				
		        products.add(product);
				
			}
		}	
			catch (SQLException e) {
				throw new Exception(e);
				
			}
			finally {
				
				try {
					rs.close();
					stmt.close();
					connection.close();
					
					
				}
				catch (SQLException e) {
					throw new Exception(e);
					
				}
			}
			return products;
	}

    
    public Product find(int code) throws Exception {
	
    	this.connection = new ConnectionFactory().getConnection();
    	
    	String sql = "SELECT * FROM Product WHERE code = ?;" ;
    	
    	Product product = new Product();
    	ResultSet rs = null;
    	PreparedStatement stmt = null;
	
    	try {
		
    		stmt = this.connection.prepareStatement(sql);
    		stmt.setInt(1, code);
    		rs = stmt.executeQuery();
		
    		while(rs.next()) {
			
				product.setCode(rs.getInt("code"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));
				product.setWarranty(rs.getDate("warranty"));
				product.setCostPrice(rs.getDouble("costPrice"));
				product.setStock(rs.getString("stock"));
				
    		}
		
    	}
    	catch (SQLException e) {
    		throw new Exception(e);
		
    	}
    	finally {
		
    		try {
				rs.close();
				stmt.close();
				connection.close();
    		}
    		catch (SQLException e) {
    			throw new Exception(e);
    			
    		}
    	}
    	return product;
    }
    
    
    public void update(Product product) throws Exception {
		
		this.connection = new ConnectionFactory().getConnection();
		
		String sql = "UPDATE Product SET price = ?, description = ?, "
		+ " warranty = ?, costPrice = ?, stock = ? WHERE code = ?;" ;
		
		PreparedStatement stmt = null;
		
		try {
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setDouble(1, product.getPrice());
			stmt.setString(2, product.getDescription());
			stmt.setDate(3, product.getWarranty());
			stmt.setDouble(4, product.getCostPrice());
			stmt.setString(5, product.getStock());
			stmt.setInt(6, product.getCode());
			
			stmt.execute();
			
		}
		catch (SQLException e) {
			throw new Exception(e);
			
		}
		finally {
			
			try {
				stmt.close();
				connection.close();
				
			}
			catch (SQLException e) {
				throw new Exception(e);
				
			}
		}
	}
    
    
    public void delete(Product product) throws Exception {
		
		this.connection = new ConnectionFactory().getConnection();
		
		String sql = "DELETE FROM Product WHERE code = ?;" ;
		PreparedStatement stmt = null;
		
		try {
			
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, product.getCode());
			stmt.execute();
			
		}
		catch (SQLException e) {
			throw new Exception(e);
			
		}
		finally {
			
			try {
				stmt.close();
				connection.close();
				
			}
			catch (SQLException e) {
				throw new Exception(e);
			}
		}
	}

}
