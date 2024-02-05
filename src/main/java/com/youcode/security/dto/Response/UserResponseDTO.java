package com.youcode.security.dto.Response;

import com.youcode.security.Model.Role;
//import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDTO {
//    @NotBlank(message = "Username is required")
    private String username;

//    @NotBlank(message = "Password is required")
    private String password;


    private int tokens ;

    private Role role;


}
