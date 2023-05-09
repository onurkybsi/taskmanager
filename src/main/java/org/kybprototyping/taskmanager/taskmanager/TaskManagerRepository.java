package org.kybprototyping.taskmanager.taskmanager;

import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

interface TaskManagerRepository extends CrudRepository<TaskEntity, UUID> {
}
