package com.example.todoc.data.entity;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(
    tableName = "task_table",
    foreignKeys = @ForeignKey(
        entity = Project.class,
        parentColumns = "project_id",
        childColumns = "projectId"
    )
)
public class Task {

    @PrimaryKey(autoGenerate = true)
    private int task_id;

    @ColumnInfo(index = true)
    private final int projectId;

    @NonNull
    private final String task_name;

    private final long task_timeStamp;

    public Task(int projectId, @NonNull String task_name, long task_timeStamp) {
        this.projectId = projectId;
        this.task_name = task_name;
        this.task_timeStamp = task_timeStamp;
    }

    @Ignore
    @VisibleForTesting
    public Task(int taskId, int projectId, @NonNull String task_name, long task_timeStamp) {
        this.task_id = taskId;
        this.projectId = projectId;
        this.task_name = task_name;
        this.task_timeStamp = task_timeStamp;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public int getProjectId() {
        return projectId;
    }

    @NonNull
    public String getTask_name() {
        return task_name;
    }

    public long getTask_timeStamp() {
        return task_timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return task_id == task.task_id && projectId == task.projectId && task_timeStamp == task.task_timeStamp && task_name.equals(task.task_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task_id, projectId, task_name, task_timeStamp);
    }

    @Override
    public String toString() {
        return "Task{" +
            "task_id=" + task_id +
            ", projectId=" + projectId +
            ", task_name='" + task_name + '\'' +
            ", task_timeStamp=" + task_timeStamp +
            '}';
    }
}
