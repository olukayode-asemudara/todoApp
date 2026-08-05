package ng.todoApp.data.repositories;

import ng.todoApp.data.models.Todo;
import java.util.List;

public interface TodoRepository {
    void addTodo(Todo todo);
    Todo findTodoById(Long id);
    List<Todo> findAllTodos();
    List<Todo> findTodosByCompletion(boolean completed);
    void updateTodo(Todo todo);
    void deleteTodo(Todo todo);
    void deleteTodoById(Long id);
    void clear();
    int getCount();
}