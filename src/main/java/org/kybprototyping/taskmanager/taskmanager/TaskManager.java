package org.kybprototyping.taskmanager.taskmanager;

/**
 * TaskManager API
 */
public interface TaskManager {

  <H, I> Task<H, I> createTask(Task<H, I> taskToCreate);

}
