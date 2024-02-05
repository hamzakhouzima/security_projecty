package com.youcode.security.Repository;

import com.youcode.security.Model.Task;
import com.youcode.security.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long > {

    List<Task> findByAssignedUser(User user);

}
