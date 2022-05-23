package com.lenguageconquers.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    public static final String KEY =  "1n7egrador";

    public String generateToken(UserDetails userDetails){
        //asignamos usuario, fecha de la creacion del jwt, fecha de expiracion de 10 horas,firmamos el metodo con una clave
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (60*60*24)))
                .signWith(SignatureAlgorithm.HS256,KEY).compact();
    }

    public boolean validarToken(String token, UserDetails userDetails){
        return userDetails.getUsername().equals(extraerUsuario(token)) && !isTokenExpirado(token);
    }

    public String extraerUsuario(String token){
        return getClaims(token).getSubject();
    }

    public boolean isTokenExpirado(String token){
        return getClaims(token).getExpiration().before(new Date());
    }

    //OBJETOS DEL JWT
    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }
}
