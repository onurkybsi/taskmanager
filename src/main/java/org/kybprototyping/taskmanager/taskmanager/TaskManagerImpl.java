package org.kybprototyping.taskmanager.taskmanager;

import org.springframework.transaction.annotation.Transactional;

class TaskManagerImpl implements TaskManager {

  private static final long MIN_TIMEOUT_SEC = 5;

  private TaskManagerRepository repository;

  @Override
  @Transactional
  public <H extends InputOnlyHandler<I>, I> Task<H, I> createTask(Task<H, I> taskToCreate) {
    assertTaskToCreate(taskToCreate);
    TaskEntity entityToSave = TaskEntity.fromTask(taskToCreate);
    TaskEntity savedEntity = repository.save(entityToSave);
    return TaskEntity.toTask(savedEntity);
  }

  private static <H, I> void assertTaskToCreate(Task<H, I> taskToCreate) {
    if (taskToCreate.getHandlerClass() == null) {
      throw new IllegalArgumentException("handlerClass cannot be null!");
    }
    if (taskToCreate.getInput() == null) {
      throw new IllegalArgumentException("input cannot be null!");
    }
    if (taskToCreate.getTimeoutSec() < MIN_TIMEOUT_SEC) {
      throw new IllegalArgumentException("timeoutSec cannot be less than " + MIN_TIMEOUT_SEC);
    }
  }

}
