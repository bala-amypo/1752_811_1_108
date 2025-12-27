package com.example.demo.security;

import io.jsonwebtoken.*;
import java.util.Date;

public class JwtTokenProvider {

    private final String secret;
    private final long validityInMs;
    private final boolean someFlag;

    public JwtTokenProvider(String secret, long validityInMs, boolean someFlag) {
        this.secret = secret;
        this.validityInMs = validityInMs;
        this.someFlag = someFlag;
    }

    public String createToken(String username, String role) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("role", role);

        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMs);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
