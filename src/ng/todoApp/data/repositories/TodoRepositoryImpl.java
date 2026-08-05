package ng.todoApp.data.repositories;

import ng.todoApp.data.models.Todo;
import java.util.ArrayList;
import java.util.List;

public class TodoRepositoryImpl implements TodoRepository {
    private List<Todo> todos = new ArrayList<>();
    private long count;

    @Override
    public int getCount(){
        return todos.size();
    }

    @Override
    public void addTodo(Todo todo) {
        todo.setId(++count);
        todos.add(todo);
    }

    @Override
    public Todo findTodoById(Long id) {
        for (Todo todo : todos) {
            if (todo.getId().equals(id)) {
                return todo;
            }
        }
        return null;
    }

    @Override
    public List<Todo> findAllTodos() {
        return new ArrayList<>(todos);
    }

    @Override
    public List<Todo> findTodosByCompletion(boolean completed) {
        List<Todo> result = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.isCompleted() == completed) {
                result.add(todo);
            }
        }
        return result;
    }

    @Override
    public void updateTodo(Todo todo) {
        for (int index = 0; index < todos.size(); index++) {
            if (todos.get(index).getId().equals(todo.getId())) {
                todos.set(index, todo);
                return;
            }
        }
        throw new RuntimeException("Todo not found with id: " + todo.getId());
    }

    @Override
    public void deleteTodo(Todo todo) {
        todos.removeIf(t -> t.getId().equals(todo.getId()));
    }

    @Override
    public void deleteTodoById(Long id) {
        todos.removeIf(t -> t.getId().equals(id));
    }

    @Override
    public void clear() {
        todos.clear();
        count = 0;
    }
}