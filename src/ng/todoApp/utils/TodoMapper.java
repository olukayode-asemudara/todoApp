package ng.todoApp.utils;

import ng.todoApp.dtos.request.CreateTodoRequest;
import ng.todoApp.dtos.response.CreateTodoResponse;
import ng.todoApp.data.models.Todo;

public class TodoMapper {

    public static Todo map(CreateTodoRequest request) {
        Todo todo = new Todo();
        todo.setTitle(request.getName());
        todo.setBody(request.getBody());
        return todo;
    }

    public static CreateTodoResponse map(Todo todo) {
        CreateTodoResponse response = new CreateTodoResponse();
        response.setId(todo.getId());
        response.setTitle(todo.getTitle());
        response.setBody(todo.getBody());
        response.setCompleted(todo.isCompleted());
        response.setCreatedAt(todo.getCreatedAt());

        return response;
    }
}