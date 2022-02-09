package com.todolist.Controller;

import com.todolist.Entity.ToDoList;
import com.todolist.Service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;

    @GetMapping("/getAllTasks")
    public ResponseEntity<?> getAllTasks() {
        return ResponseEntity.ok(toDoListService.getAllTasks());
    }

    @GetMapping("/getActiveTasks")
    public ResponseEntity<?> getActiveTasks() {
        return ResponseEntity.ok(toDoListService.getActiveTasks());
    }

    @GetMapping("/getAllCompletedTasks")
    public ResponseEntity<?> getCompletedTasks() {
        return ResponseEntity.ok(toDoListService.getCompletedTasks());
    }

    @PutMapping("/addTask")
    public ResponseEntity<?> addTask(@RequestBody ToDoList toDoList) {
        return ResponseEntity.ok(toDoListService.addTask(toDoList));
    }

    @PostMapping("/updateStatus/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable long id) {
        return ResponseEntity.ok(toDoListService.updateStatus(id));
    }

    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable long id) {
        return ResponseEntity.ok(toDoListService.deleteTask(id));
    }
}
