package com.youcode.security.dto.Request;

import com.youcode.security.Model.Role;
import jakarta.persistence.Id;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDTO {
    @Id
    private Long id;

//    @NotBlank(message = "Username is required")
    private String username;

//    @NotBlank(message = "Password is required")
    private String password;
//    @Max(value = 3, message = "Max tokens is 3")
    private int tokens ;

    private Role role;


}