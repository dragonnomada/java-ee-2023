package com.example.jpa;

//import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

//import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.transaction.SystemException;
//import javax.transaction.UserTransaction;
//import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.example.entity.Demo;

@Stateful
public class DemoService {

	Logger logger = Logger.getLogger("DemoService");

	// @Resource(lookup = "java:comp/UserTransaction")
	// UserTransaction userTransaction;

	@PersistenceContext(unitName = "entityManager")
	EntityManager entityManager;

	public Demo addDemo(String title) {

		logger.info("Agregando Demo: " + title);

		Demo demo = new Demo();

		demo.setTitle(title);
		demo.setCreated(new Date());

		try {
			// userTransaction.begin();

			entityManager.persist(demo);

			// userTransaction.commit();

			// entityManager.flush();

			logger.info("Demo creado: " + demo);

			return demo;
		} catch (Exception e) {
			// try {
			// userTransaction.rollback();
			// } catch (IllegalStateException | SecurityException | SystemException e1) {
			// logger.warning(e1.getMessage());
			// }
			logger.warning(e.getMessage());
		}

		return null;

	}

	public List<Demo> getDemos() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Demo> criteriaQuery = criteriaBuilder.createQuery(Demo.class);

		Root<Demo> rootEntry = criteriaQuery.from(Demo.class);
		CriteriaQuery<Demo> all = criteriaQuery.select(rootEntry);
		TypedQuery<Demo> allQuery = entityManager.createQuery(all);

		return allQuery.getResultList();

		// --- ALTERNATIVA CON QUERY MANUAL ---
		// Query query = entityManager.createNativeQuery("select * from demo",
		// Demo.class);
		// Query query = entityManager.createQuery("select d from Demo d",
		// Demo.class);
		//
		// List<Demo> demos = new ArrayList<Demo>();
		//
		// for (Object demo : query.getResultList()) {
		// demos.add((Demo) demo);
		// }
		//
		// return demos;
	}

}
