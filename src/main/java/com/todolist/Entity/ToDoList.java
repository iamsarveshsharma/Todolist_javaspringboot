package com.todolist.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "TO_DO_List")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TO_DO_List_ID")
    private long id;

    @Column(name = "TO_DO_Message", nullable = false)
    private String message;

    @Column(name = "isActive", nullable = false)
    private boolean active;


}
