package com.youcode.security.Repository;

import com.youcode.security.Model.Token;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Id> {

        Token findTokenByUserIdAndType(Long user_id, String type);

}
