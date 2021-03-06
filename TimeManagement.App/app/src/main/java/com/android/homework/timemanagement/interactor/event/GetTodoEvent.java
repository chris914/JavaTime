package com.android.homework.timemanagement.interactor.event;

import com.android.homework.timemanagement.model.Task;

import java.util.List;

public class GetTodoEvent {
    private int code;
    private List<Task> tasks;
    private Throwable throwable;

    public GetTodoEvent() { }

    public GetTodoEvent(int code, List<Task> tasks) {
        this.code = code;
        this.tasks = tasks;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
