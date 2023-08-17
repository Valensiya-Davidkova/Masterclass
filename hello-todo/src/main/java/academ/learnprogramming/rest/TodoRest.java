package academ.learnprogramming.rest;

import academy.learnprogramming.service.ToDoService;
import com.academy.learnprogramming.entity.Todo;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoRest {
    @Inject
    ToDoService toDoService;
    @Path("new")
    @POST
    public Response createTodo(Todo todo){
        toDoService.createToDo(todo);
        return Response.ok(todo).build();
    }

    @Path("update")
    @PUT
    public Response updateTodo(Todo todo){
        toDoService.updateToDo(todo);
        return Response.ok(todo).build();
    }

    @Path("{id}")
    @GET
    public Todo getTodo(@PathParam("id") Long id){
        return toDoService.findToDoById(id);
    }


    @Path("list")
    @GET
    public List<Todo> getTodos(){
        return toDoService.getTodos();
    }

}
