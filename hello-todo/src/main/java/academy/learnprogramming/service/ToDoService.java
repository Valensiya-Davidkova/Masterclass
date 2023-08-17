package academy.learnprogramming.service;

import com.academy.learnprogramming.entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ToDoService {
    //this class is for CRUD database operations for entities
    @PersistenceContext
    EntityManager entityManager;

    public Todo createToDo(Todo todo){
        //Persist into database
        entityManager.persist(todo);
        return todo;
    }

    public Todo updateToDo(Todo todo){
        entityManager.merge(todo);
        return todo;
    }
    public Todo findToDoById(Long id){
        return entityManager.find(Todo.class,id);
    }
    public List<Todo> getTodos(){
        return entityManager.createQuery("SELECT t from Todo t",Todo.class).getResultList();
    }
}
