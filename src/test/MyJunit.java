package test;


import java.sql.Date;
import java.util.List;
import org.junit.Test;
import dao.ProductDao;
import model.Product;


public class MyJunit {

	
	@Test
	public void testCreate() throws Exception {
		
		Product produto = new Product();
		
		produto.setPrice(49.90);
		produto.setDescription("Enlatado");
		produto.setWarranty(new Date(10/12/2017));
		produto.setCostPrice(30.00);
		produto.setStock("100");
		
		ProductDao dao = new ProductDao();
		dao.create(produto);
	}

	@Test
	public void testGetList() throws Exception {
		
		ProductDao dao = new ProductDao();
		List<Product> products = dao.getList();
		
		for(Product product : products){
			System.out.println(product.toString());
		}
	}

	@Test
	public void testFind() throws Exception {
		
		ProductDao dao = new ProductDao();
		Product product = dao.find(1);
		System.out.println(product.toString());
	}

	@Test
	public void testUpdate() throws Exception {
		
		ProductDao dao = new ProductDao();
		Product product = dao.find(1);
		product.setPrice(60.00);
		dao.update(product);
		System.out.println(product.toString());
		
	}

	@Test
	public void testDelete() throws Exception {
		
		ProductDao dao = new ProductDao();
		Product product = dao.find(1);
		dao.delete(product);
		

	}

}
