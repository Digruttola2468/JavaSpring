package com.digrutt.course_spring.web.secutiry;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    //Esta llave deberia ser mas compleja
    private static final String KEY = "d1gr0tt";

    /*
    * AuthenticationRequest y AuthenticationResponse que seran
    * los encargados de recibir y enviar la informacion necesaria
    * para crear un JSON web token dentro de un controlador
    * */

    //
    public String generateToken(UserDetails userDetails){
        return Jwts.builder()
                .setSubject(userDetails.getUsername()) //Usuario
                .setIssuedAt(new Date())                //Fecha en que se creo
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) //Fecha en el que termina
                .signWith(SignatureAlgorithm.HS256, KEY).compact();     //Firmamos nuestro metodo
    }

    public boolean validateToken(String token, UserDetails userDetails){
        return userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpired(token);
    }

    //getSubject -> es donde esta el usuario de la peticion
    public String extractUsername(String token){
        return getClaims(token).getSubject();
    }

    public boolean isTokenExpired(String token){
        //Si este token esta antes de la fecha actual
        return getClaims(token).getExpiration().before(new Date());
    }

    //Claims son como objetos de nuestro Web Token
    private Claims getClaims(String token){
        return Jwts.parser()
                .setSigningKey(KEY).parseClaimsJws(token).getBody();
    }
}
