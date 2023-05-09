package org.kybprototyping.taskmanager.taskmanager;

/**
 * Represents the API which manages the asynchronous tasks in the application.
 */
public interface TaskManager {

  /**
   * Creates a new task to be handled asynchronously by the application.
   *
   * @param <H> type of the handler class
   * @param <I> type of the input class
   * @param taskToCreate task information to be created
   * @return the created task
   */
  <H extends InputOnlyHandler<I>, I> Task<H, I> createTask(Task<H, I> taskToCreate);

}
