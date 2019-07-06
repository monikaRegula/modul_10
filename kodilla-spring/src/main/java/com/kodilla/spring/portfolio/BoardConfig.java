package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BoardConfig {

    @Bean
    public Board getBoard(){
       // return new Board(toDoList, inProgressList,doneList);
        return new Board(taskList,taskList,taskList);
    }

    @Autowired
    @Qualifier("toDoList")
    TaskList taskList;

    @Bean(name="toDoList")
    @Scope("prototype")
        public TaskList getToDoList() {
        return new TaskList(new ArrayList<>());
    }

    @Bean(name="inProgressList")
    @Scope("prototype")
    public TaskList getInProgressList() {
        return new TaskList(new ArrayList<>());
    }

    @Bean(name="doneList")
    @Scope("prototype")
    public TaskList getdoneList() {
        return new TaskList(new ArrayList<>());
    }

}
