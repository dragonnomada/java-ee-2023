package com.example.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import com.example.entity.Todo;

@Stateless
public class TodoService {

	@PersistenceContext(unitName = "todoEntityManager")
	EntityManager todoEntityManager;

	public Todo addTodo(String title) {
		Todo todo = new Todo();
		todo.setTitle(title);
		todo.setCreated(new Date());
		todo.setChecked(false);

		todoEntityManager.persist(todo);

		todoEntityManager.flush();

		return todo;
	}

	public List<Todo> getTodos() {

		// USANDO CRITERIA API

		// CriteriaBuilder criteria = todoEntityManager.getCriteriaBuilder();
		//
		// CriteriaQuery<Todo> preparedQuery = criteria.createQuery(Todo.class);
		//
		// Root<Todo> todo = preparedQuery.from(Todo.class);
		//
		// CriteriaQuery<Todo> query = preparedQuery.select(todo);
		//
		// List<Todo> todos = todoEntityManager.createQuery(query).getResultList();
		//
		// return todos;

		// JPQL: SELECT todo FROM Todo todo
		// MySQL: SELECT * FROM todo

		// Query query = todoEntityManager.createQuery("SELECT todo FROM Todo todo",
		// Todo.class);
		Query query = todoEntityManager.createNativeQuery("SELECT * FROM todo", Todo.class);

		List todosObjects = query.getResultList();

		List<Todo> todos = new ArrayList<Todo>();

		for (Object todoObject : todosObjects) {
			todos.add((Todo) todoObject);
		}

		return todos;
	}

	public Todo getTodo(long id) {

		// USANDO CRITERIA API

		 CriteriaBuilder criteria = todoEntityManager.getCriteriaBuilder();
		
		 CriteriaQuery<Todo> preparedQuery = criteria.createQuery(Todo.class);
		
		 Root<Todo> todo = preparedQuery.from(Todo.class);
		
		 CriteriaQuery<Todo> query = preparedQuery.select(todo);
		
		 EntityType<Todo> Todo_ = todo.getModel();
		
		 Todo todoResult = todoEntityManager.createQuery(
		 query.where(criteria.equal(todo.get("id"), id))
		 ).getSingleResult();
		
		 return todoResult;

		// JPQL: SELECT todo FROM Todo todo
		// MySQL: SELECT * FROM todo

	}

}
