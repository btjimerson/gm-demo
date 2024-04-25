package com.yugabyte.gmdemo;

import org.springframework.data.repository.CrudRepository;

public interface TaskTypeRepository extends CrudRepository<TaskType, String> {

}
