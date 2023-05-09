package org.kybprototyping.taskmanager.taskmanager;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Represents an asynchronous task to be handled by the application.
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class Task<H, I> {

  private final UUID id;
  private final Class<H> handlerClass;
  private final I input;
  @Setter
  private OffsetDateTime executionDate;
  @Setter
  private int tryCount;
  private final long timeoutSec;
  private final OffsetDateTime modificationDate;
  private final OffsetDateTime creationDate;

  /**
   * Builds a new {@link Task}.
   *
   * @param <I> type of the input class
   * @param <H> type of the handler class
   * @param handlerClass class instance of the handler class
   * @param input input of the task
   * @param timeoutSec timeout of the task in seconds
   * @return built {@link Task}
   */
  public static <H extends InputOnlyHandler<I>, I> Task<H, I> of(Class<H> handlerClass, I input,
      long timeoutSec) {
    return new Task<>(null, handlerClass, input, timeoutSec, OffsetDateTime.now(),
        OffsetDateTime.now());
  }

  /**
   * Sets the {@code executionDate} of the created task.
   *
   * @param executionDate value to set
   * @return created task
   */
  public Task<H, I> executionDate(OffsetDateTime executionDate) {
    this.executionDate = executionDate;
    return this;
  }

}
