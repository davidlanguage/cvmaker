package cvmaker.app.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY =
            "YDV97O6TTJYKC601DX4N2QX4GM2LO0BST5L1VQNLZ9N95V37BL18UVJNDMUFVGF1UK73FOILP453HFFH";

    public String getToken(UserDetails userDetails){
        return getToken(new HashMap<>(), userDetails);
    }

    private String getToken(Map<String, Object> extraClaims, UserDetails userDetails){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+10000*60*24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey() {
        final byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getUsernameFromToken(final String token) {
        return getClaims(token, Claims::getSubject);
    }

    public boolean isTokenValid(final String token, final UserDetails userDetails) {

        final String username = getUsernameFromToken(token);

        return (username.equals(userDetails.getUsername())&&!isTokenExpired(token));
    }

    private Claims getAllClaims(final String token){

        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T getClaims(final String token, final Function<Claims, T> claimsResolver){

        final Claims claims = getAllClaims(token);

        return claimsResolver.apply(claims);

    }

    private Date getExpiration(final String token) {
        return getClaims(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(final String token){
        return getExpiration(token).before(new Date());
    }

}
