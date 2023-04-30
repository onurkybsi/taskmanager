package org.kybprototyping.taskmanager.taskmanager;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Task<H, I> {

  private final UUID id;
  private final Class<H> handlerClass;
  private final I input;
  @Setter
  private OffsetDateTime executionDate;
  @Setter
  private int retryCount;
  private final long timeoutSec;
  @Setter
  private String exceptionStackTrace;
  private final OffsetDateTime modificationDate;
  private final OffsetDateTime creationDate;

  public static <I, H extends InputOnlyHandler<I>> Task<H, I> of(Class<H> handlerClass, I input,
      long timeoutSec) {
    return new Task<>(null, handlerClass, input, timeoutSec, null, null);
  }

  public Task<H, I> executionDate(OffsetDateTime executionDate) {
    this.executionDate = executionDate;
    return this;
  }

}
