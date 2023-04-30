package org.kybprototyping.taskmanager.taskmanager;

@FunctionalInterface
public interface InputOnlyHandler<I> {

  void handle(I input);

}
