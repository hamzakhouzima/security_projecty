package com.youcode.security.dto.Response;

import com.youcode.security.Model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Builder
@Getter
@Setter
public class TaskResponseDto {
    private  Long id ;

    private String title ;
    private String description ;

    private LocalDate deadline;
    private boolean completed;

    private User creator;
    private User assignedUser;




}