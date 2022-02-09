package com.todolist.Service;

import com.todolist.Entity.ToDoList;
import com.todolist.Repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ToDoListServiceImplementation implements ToDoListService {

    @Autowired
    private ToDoListRepository toDoListRepository;

    @Override
    public List<ToDoList> getAllTasks() {
        return toDoListRepository.findAll();
    }

    @Override
    public List<ToDoList> getActiveTasks() {
        return toDoListRepository.findByActiveEquals(true);
    }

    @Override
    public List<ToDoList> getCompletedTasks() {
        return toDoListRepository.findByActiveEquals(false);
    }

    @Override
    public ToDoList addTask(ToDoList toDoList) {
        if (toDoList.getMessage() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Task cannot be null.");
        } else {
            ToDoList toDoList1 = toDoListRepository.findByMessageAndActiveEquals(toDoList.getMessage(), true);
            if (toDoList1 != null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Task Already Exist");
            } else {
                toDoList.setActive(true);
                toDoListRepository.save(toDoList);
            }
            return toDoList;
        }
    }

    @Override
    public ToDoList updateStatus(long id) {
        ToDoList checkID = toDoListRepository.findById(id);
        if (checkID == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task Not Found");
        }
        checkID.setActive(false);
        toDoListRepository.save(checkID);
        return checkID;
    }

    @Override
    public String deleteTask(long id) {
        ToDoList checkID = toDoListRepository.findById(id);
        if (checkID == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task Not Found");
        }
        toDoListRepository.delete(checkID);
        return "Successfully Deleted";
    }
}
