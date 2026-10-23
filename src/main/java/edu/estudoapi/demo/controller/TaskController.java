package edu.estudoapi.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import edu.estudoapi.demo.dto.TaskRequest;
import edu.estudoapi.demo.entity.Task;
import edu.estudoapi.demo.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> listar() {
        return taskService.listarTodas();
    }

    @GetMapping("/{id}")
    public Task buscarPorId(@PathVariable Long id) {
        return taskService.buscarPorId(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Task criar(
        @RequestBody TaskRequest request,
        @RequestHeader ("X-user-id") Long userId){
        request.validarCamposPermitidos();

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCompleted(false);
        return taskService.criar(task, userId);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Task atualizar(@RequestBody Task task) {
        return taskService.atualizar(task);
    }

    @PutMapping ("/{id}/complete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void concluir(@PathVariable Long id) {
        taskService.concluir(id);
    }

    @DeleteMapping ("/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        taskService.deletar(id);
    }
}
