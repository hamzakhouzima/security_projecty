package com.youcode.security.Controller;

//import com.youcode.security.Security.JwtService;
import com.youcode.security.Service.AuthenticationService;
import com.youcode.security.dto.Request.AuthenticationRequest;
import com.youcode.security.dto.Request.RegisterRequest;
import com.youcode.security.dto.Response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
//    private final JwtService JwtService ;

    @PostMapping("/super/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/super/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        try{
            return ResponseEntity.ok(authenticationService.authenticate(request));


        }catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("test");
    }
}
