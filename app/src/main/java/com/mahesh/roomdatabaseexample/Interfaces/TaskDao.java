package com.mahesh.roomdatabaseexample.Interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mahesh.roomdatabaseexample.Task;

import java.util.List;

/**
 * Created by fipl on 28/08/2017.
 */

@Dao
public interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addTask(Task task);

    @Query("select * from task")
    public List<Task> getAllTasks();

    @Query("select * from task where id = :id")
    public List<Task> getTask(long id);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTask(Task task);

    @Query("delete from task")
    void removeAllTasks();
}
