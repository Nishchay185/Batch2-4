package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Admindto;
import dto.Sign_in_dto;

public class hub_dao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hub");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void insert(Sign_in_dto si) {
		entityTransaction.begin();
		entityManager.persist(si);
		entityTransaction.commit();
	}

	public void delete(String Email) {
		Sign_in_dto dp = entityManager.find(Sign_in_dto.class, Email);
		dp.setEmail(Email);
		entityTransaction.begin();
		entityManager.remove(dp);
		entityTransaction.commit();
	}

	public void Admininsert(Admindto ad) {
		entityTransaction.begin();
		entityManager.persist(ad);
		entityTransaction.commit();
	}

	public Sign_in_dto findvalue(String Email) {
		Sign_in_dto dp = entityManager.find(Sign_in_dto.class, Email);
		return dp;
	}

	public Admindto Adminfindvalue(String Email) {
		Admindto dp = entityManager.find(Admindto.class, Email);
		return dp;
	}

	public List<Sign_in_dto> fetchall() {
		Query query = entityManager.createQuery("select data from Sign_in_dto data");
		List<Sign_in_dto> list = query.getResultList();
		return list;
	}

	public List<Sign_in_dto> DeleteClick(String Email) {
		List<Sign_in_dto> list = fetchall();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEmail().equals(Email)) {
				entityTransaction.begin();
				entityManager.remove(list.get(i));
				entityTransaction.commit();
				list.remove(i);
				break;
			}
		}

		return list;
	}

	public void upDate(String Email, String first_name) {
		Sign_in_dto dto1 = entityManager.find(Sign_in_dto.class, Email);

	
				entityTransaction.begin();
				dto1.setFirst_name(first_name);
				entityManager.merge(dto1);
				entityTransaction.commit();
			
	}
}
