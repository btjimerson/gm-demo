package com.yugabyte.gmdemo;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DataJpaTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class TaskRepositoryTests {

    private static final Log LOG = LogFactory.getLog(TaskRepositoryTests.class);

    private static final String[] PLANT_CODES = { "WBGN", "WSPH", "WTOL" };

    @Autowired
    TaskRepository taskRepository;

    @Test
    void testInsertWithConversion() throws Exception {

        Random random = new Random();

        Task task = new Task();
        String taskId = "2024-04-11-10-22-42" + UUID.randomUUID().toString();

        task.setTaskId(taskId);
        task.setTaskStatId("3");
        task.setTaskKeyTxt(taskId);
        task.setCrtUsrId("SYSTEM");
        task.setUpdUsrId("SYSTEM");
        task.setTcn(2);
        task.setPlantId(PLANT_CODES[random.nextInt(PLANT_CODES.length)]);

        taskRepository.save(task);

        Optional<Task> savedTask = taskRepository.findById(taskId);
        LOG.info(String.format("Task saved = [%s], plant location = [%s]", savedTask.get().getTaskId(),
                savedTask.get().getPlantId()));

    }
}
