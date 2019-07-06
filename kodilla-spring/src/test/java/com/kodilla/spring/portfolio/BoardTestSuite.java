package com.kodilla.spring.portfolio;

import javafx.concurrent.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Test
    public void testTaskListExists(){
        //sprawdzam czy istnieją beany dla poszczególnych list :todo,inprogress, done
        //given
        ApplicationContext context=
                new AnnotationConfigApplicationContext(BoardConfig.class);
        //when&then
        boolean toDoExists = context.containsBean("toDoList");
        boolean inProgressExists = context.containsBean("inProgressList");
        boolean doneExists = context.containsBean("doneList");
        System.out.println("Todo exists: " + toDoExists);
        System.out.println("Inprogress exists: "+inProgressExists);
        System.out.println("Done exists: "+doneExists);

    }

    @Test
    public void testTaskAdded(){
        //given
        ApplicationContext context=
                new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        TaskList inProgress = board.inProgressList;
        TaskList toDoList = (TaskList)context.getBean("toDoList");
        TaskList doneList = (TaskList)context.getBean("doneList");
        //when&then
        toDoList.tasks.add("to do1");
        int toDoSize = toDoList.tasks.size();

        inProgress.tasks.add("inprogress1");
        inProgress.tasks.add("inprogress2");
        int progressSize = inProgress.tasks.size();

        doneList.tasks.add("done1");
        doneList.tasks.add("done2");
        doneList.tasks.add("done3");
        int doneSize = doneList.tasks.size();

        Assert.assertEquals(toDoSize,1);
        Assert.assertEquals(progressSize ,2);
        Assert.assertEquals(doneSize,3);
    }
}
