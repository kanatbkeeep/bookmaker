package com.example.bookmaker.repository;

import com.example.bookmaker.entity.Token;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<Token, Long> {
    Token findByToken(String token);
}
