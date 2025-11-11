package com.example.Coupan_Voucher_Service.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtUtils {

    private static final String SECRET = "SuperLongHardcodedSecretKeySuperLongHardcodedSecretKeySuperLongHardcodedSecretKey1234567890";
    private static final Key key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    // Extract userId from token
    public String getUserIdFromToken(String token) {
        token = token.trim();
        return (String) Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("userId");
    }

    // Optional: validate token
    public static boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
