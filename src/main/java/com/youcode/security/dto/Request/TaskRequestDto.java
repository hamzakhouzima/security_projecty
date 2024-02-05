package com.youcode.security.dto.Request;

//import com.youcode.taskflow.Model.Role;

//import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class TaskRequestDto {
    private  Long id ;
    private LocalDate creationDate  ;

    public TaskRequestDto() {
        this.creationDate = LocalDate.now(); // Set creationDate to current date in the constructor
    }


//    @NotBlank(message = "Title is required")
    private String title ;

//    @NotBlank(message = "Description is required")
    private String description ;

//    @NotBlank(message = "Deadline is required")
    private LocalDate deadline;


//    @FutureOrPresent(message = "Ticket could be created just in the present or the future date")


    private boolean completed;



    private UserRequestDTO creator;
//    private UserRequestDTO creator;
    private UserRequestDTO assignedUser;
//    private UserRequestDTO assignedUser;


    public boolean isCompleted() {
        return completed;
    }


}
