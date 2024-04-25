package com.yugabyte.gmdemo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GmDemoApplication implements CommandLineRunner {

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	TaskTypeRepository taskTypeRepository;

	private static final String[] PLANT_CODES = { "WBGN", "WSPH", "WTOL" };

	private static final Log LOG = LogFactory.getLog(GmDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GmDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if (args == null || args.length == 0 || args[0] == null || args[0].equals("")) {
			System.out.println("ERROR: First and only argument should be the number of records to insert.");
			System.exit(-1);
		}
		int numberOfInserts = 0;
		try {
			numberOfInserts = Integer.parseInt(args[0]);
		} catch (NumberFormatException nfe) {
			System.out.println("ERROR: First and only argument should be a number, or 0 for unlimited inserts.");
			System.exit(-1);
		}

		int counter = -1;
		Random random = new Random();

		while (counter < numberOfInserts) {
			Task task = new Task();
			String taskId = "2024-04-11-10-22-42" + UUID.randomUUID().toString();

			TaskType taskType = null;
			List<String> ids = new ArrayList<>();
			ids.add("d142e0f7-ae8a-40dc-9d4f-c068767d0b09");
			Iterable<TaskType> taskTypes = taskTypeRepository.findAllById(ids);
			for (TaskType t : taskTypes) {
				taskType = t;
				break;
			}

			task.setTaskId(taskId);
			task.setTaskStatId("3");
			task.setTaskType(taskType);
			task.setTaskKeyTxt(taskId);
			task.setCrtTs(new Timestamp(System.currentTimeMillis()));
			task.setCrtUsrId("SYSTEM");
			task.setUpdUsrId("SYSTEM");
			task.setTcn(2);
			task.setUpdTs(new Timestamp(System.currentTimeMillis()));
			task.setPlantId(PLANT_CODES[random.nextInt(PLANT_CODES.length)]);

			taskRepository.save(task);

			Optional<Task> savedTask = taskRepository.findById(taskId);
			LOG.info(String.format("Task saved = [%s], plant location = [%s]", savedTask.get().getTaskId(),
					savedTask.get().getPlantId()));
			if (numberOfInserts != 0)
				counter++;
		}
	}

}
