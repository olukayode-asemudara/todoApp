package ng.todoApp.data.repositories;

import ng.todoApp.data.models.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TodoRepositoriesTest {

    private TodoRepository repository;
    private Todo todo;

    @BeforeEach
    void setUp(){
        repository = new TodoRepositoryImpl();
        todo = new Todo();
    }

    @Test
    public void testAddTodoToRepository() {
        repository.addTodo(todo);
        assertEquals(1, repository.findAllTodos().size());
        assertEquals(1L, todo.getId());
    }

    @Test
    public void testAddTodo(){
        repository.addTodo(todo);
        assertEquals(1, repository.findAllTodos().size());
    }

    @Test
    public void testRemoveTodo(){
        repository.addTodo(todo);
        repository.deleteTodo(todo);
        assertEquals(0, repository.findAllTodos().size());
    }

    @Test
    public void testClearAll(){
        Todo second_todo = new Todo();
        repository.addTodo(todo);
        repository.addTodo(second_todo);
        assertEquals(2, repository.findAllTodos().size());
        repository.clear();
        assertEquals(0, repository.findAllTodos().size());
    }

    @Test
    public void testFindTodoById(){
        Todo second_todo = new Todo();
        repository.addTodo(todo);
        repository.addTodo(second_todo);
        assertEquals(2, repository.findAllTodos().size());
        assertEquals(2, second_todo.getId());
    }

    @Test
    public void testDeleteTodoById(){
        Todo second_todo = new Todo();
        repository.addTodo(todo);
        repository.addTodo(second_todo);
        assertEquals(2, repository.findAllTodos().size());
        repository.deleteTodoById(1L);
        assertNull(repository.findTodoById(1L));
    }

    @Test
    public void testGetCountOfStoredTodos(){
        Todo second_todo = new Todo();
        repository.addTodo(todo);
        repository.addTodo(second_todo);
        assertEquals(2, repository.findAllTodos().size());
    }
}
