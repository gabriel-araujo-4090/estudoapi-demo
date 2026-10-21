package edu.estudoapi.demo.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.estudoapi.demo.entity.Task;
import edu.estudoapi.demo.repository.TaskRepository;
import edu.estudoapi.demo.service.validate.ValidateInput;

@Service 
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task criar(Task task) {
        ValidateInput.validateTitle(task.getTitle());
        return taskRepository.save(task);
    }

    public List<Task> listarTodas() {
        return taskRepository.findAll();
    }

    public Task buscarPorId(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Tarefa não encontrada"));
    }
    public Task atualizar(Task task) {
        ValidateInput.validateTitle(task.getTitle());
        if (task.getId() == null || !taskRepository.existsById(task.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada");
        }
        return taskRepository.save(task);
    }
    public void concluir (Long id) {
        Task task = buscarPorId(id);
        task.setCompleted(true);
        taskRepository.save(task);
    }
    public void deletar (Long id) {
        Task task = buscarPorId(id);
        taskRepository.delete(task);
    }
}