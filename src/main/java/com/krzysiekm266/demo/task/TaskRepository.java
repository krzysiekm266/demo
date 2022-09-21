package com.krzysiekm266.demo.task;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{
    @Query("SELECT task FROM Task task WHERE task.name = ?1")
    Optional<Task> findByName(String name);
}
