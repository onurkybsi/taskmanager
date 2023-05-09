package org.kybprototyping.taskmanager.taskmanager;

/**
 * Represents the API which locates the registered services in the application context.
 */
public interface ServiceLocator {

  /**
   * Returns the instance of the registered service.
   *
   * @param <T> service type
   * @param serviceType {@link Class} instance of the service class
   * @return service instance
   */
  <T> T getService(Class<T> serviceType);

}
