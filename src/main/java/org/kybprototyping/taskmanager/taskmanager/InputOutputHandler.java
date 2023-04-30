package org.kybprototyping.taskmanager.taskmanager;

@FunctionalInterface
public interface InputOutputHandler<I, O> {

  O handle(I input);

}
