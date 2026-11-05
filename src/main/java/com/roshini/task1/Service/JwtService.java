package com.roshini.task1.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    private SecretKey secretKey;
    public JwtService(){
        secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    }
    public String generateToken(String username){
        return Jwts.builder()

                .subject(username)
                //returned object from previous line is called by next method
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(secretKey)
                .compact(); // converting builder information to string
    }
    public String extractUsername(String token){
        return Jwts.parser() //parser  is to extract information from a big token
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
    public boolean validateToken(String token, String username){

        String approveUsername = extractUsername(token);

        Date expirtaion= Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();
        return username.equals(approveUsername) && expirtaion.after(new Date());

    }
}
