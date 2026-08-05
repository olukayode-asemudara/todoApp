package ng.todoApp.services;

import ng.todoApp.data.models.Todo;
import ng.todoApp.data.repositories.TodoRepository;
import ng.todoApp.data.repositories.TodoRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.AssertionsKt.assertNull;

public class TodoServicesTest {

    private TodoRepository repository;
    private Todo todo;

    @BeforeEach
    void setUp(){
        repository = new TodoRepositoryImpl();
        todo = new Todo();
    }

    @Test
    public void testRepositoryStartsEmpty() {
        assertTrue(repository.findAllTodos().isEmpty());
        assertEquals(0, repository.getCount());
        assertNull(repository.findTodoById(1L));
    }
}
