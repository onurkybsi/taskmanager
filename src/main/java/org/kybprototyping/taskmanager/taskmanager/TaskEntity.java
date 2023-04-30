package org.kybprototyping.taskmanager.taskmanager;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
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

  @Column(name = "retry_count")
  @NotNull
  private int retryCount;

  @Column(name = "timeout")
  @NotNull
  private long timeoutSec;

  @Column(name = "exception_stack_trace")
  private String exceptionStackTrace;

  @Column(name = "modification_date")
  @CreationTimestamp
  private OffsetDateTime modificationDate;

  @Column(name = "creation_date")
  @UpdateTimestamp
  private OffsetDateTime creationDate;

}
