package com.todolist.Service;

import com.todolist.Entity.ToDoList;

import java.util.List;

public interface ToDoListService {
    List<ToDoList> getAllTasks();

    List<ToDoList> getActiveTasks();

    List<ToDoList> getCompletedTasks();

    ToDoList addTask(ToDoList toDoList);

    ToDoList updateStatus(long id);

    String deleteTask(long id);
}
