package com.capgemini.angularproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.angularproject.bean.ProductInfo;
import com.capgemini.angularproject.exception.ProductException;
@Repository
public class ProductDAOImpl implements ProductDAO{
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public List<ProductInfo> getAllProducts() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select m from ProductInfo m";
		Query query = manager.createQuery(jpql);

		List<ProductInfo> employeelist = query.getResultList();
		manager.close();
		return employeelist;
	}

	@Override
	public boolean createProductInfo(ProductInfo ref) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(ref);
			transaction.commit();
			isAdded = true;
			System.out.println("Added");
		}catch (Exception e) {
			e.printStackTrace();
			throw new ProductException("Product Already Exsits");
		}
		finally {
			manager.close();
		}
		return isAdded;
	}

	@Override
	public boolean updateProductInfo(ProductInfo ref) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isUpdated = false;
		try {
			transaction.begin();
			String jpql ="update ProductInfo e set e.price=:price where e.id=:id";
			Query query = manager.createQuery(jpql);
			query.setParameter("id",ref.getId());
			query.setParameter("price", ref.getPrice());
			int id = query.executeUpdate();
			transaction.commit();
			isUpdated = true;
		}catch (Exception e) {
			e.printStackTrace();
			throw new ProductException("Can't update the data");
		}
		finally {
			manager.close();
		}
		return isUpdated;
	}

	@Override
	public boolean deleteProductInfo(int id) {
		boolean isDeleted=false;
		EntityManager manager = factory.createEntityManager();
		ProductInfo product = manager.find(ProductInfo.class, id);
		if(product != null) {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(product);
			transaction.commit();
			isDeleted = true;
		}
		manager.close();
		return isDeleted;
	}

}
