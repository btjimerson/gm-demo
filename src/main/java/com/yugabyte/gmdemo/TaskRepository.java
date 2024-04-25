package com.yugabyte.gmdemo;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, String> {

}
