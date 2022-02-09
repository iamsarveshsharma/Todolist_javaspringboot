package com.todolist.Repository;

import com.todolist.Entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {

    List<ToDoList> findByActiveEquals(boolean active);

    ToDoList findByMessageAndActiveEquals(String message, boolean active);

    ToDoList findById(long id);
}
