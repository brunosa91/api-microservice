package com.auth.service.application.ibmshopbackendauthservice.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class JwtProviderImpl {


    private static final String SECRE_KEY = "Som35ecretK3y109jP2n8PaMS05mDKAPOjd23ur98yoej";
    public String gerarToken(String email, List<? extends GrantedAuthority> Roles){
        Date inicio = Date.from(Instant.now(Clock.systemUTC()));
        return Jwts.builder().setSubject(email).claim("role", Roles.get(0)).setIssuedAt(inicio)
                .setExpiration(new Date(inicio.getTime() + 3600000))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();

    }

    public void validarToken(String token){
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }
    private Key getSignKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRE_KEY));
    }


}
