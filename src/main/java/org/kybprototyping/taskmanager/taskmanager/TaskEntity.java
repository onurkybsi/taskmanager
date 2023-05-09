package org.kybprototyping.taskmanager.taskmanager;

import org.hibernate.annotations.GenericGenerator;
import java.time.OffsetDateTime;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "task")
class TaskEntity {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;

  @Column(name = "handler_class_name")
  @NotBlank
  private String handlerClassName;

  @Column(name = "input")
  private String input;

  @Column(name = "input_class_name")
  private String inputClassName;

  @Column(name = "execution_date")
  private OffsetDateTime executionDate;

  @Column(name = "try_count")
  @NotNull
  private int tryCount;

  @Column(name = "timeout_sec")
  @NotNull
  private long timeoutSec;

  @Column(name = "modification_date")
  @NotNull
  private OffsetDateTime modificationDate;

  @Column(name = "creation_date")
  @NotNull
  private OffsetDateTime creationDate;

  static <H extends InputOnlyHandler<I>, I> TaskEntity fromTask(Task<H, I> task) {
    return TaskEntity.builder().handlerClassName(task.getHandlerClass().getName())
        .input(Helper.toJson(task.getInput())).inputClassName(task.getInput().getClass().getName())
        .executionDate(task.getExecutionDate()).timeoutSec(task.getTimeoutSec()).build();
  }

  static <H extends InputOnlyHandler<I>, I> Task<H, I> toTask(TaskEntity entity) {
    return new Task<>(entity.getId(), Helper.findClass(entity.getHandlerClassName()),
        Helper.fromJson(entity.getInput()), entity.getExecutionDate(), entity.getTryCount(),
        entity.getTimeoutSec(), entity.getModificationDate(), entity.getCreationDate());
  }

}
