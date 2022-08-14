package com.digrutt.course_spring.web.secutiry;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

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
}
