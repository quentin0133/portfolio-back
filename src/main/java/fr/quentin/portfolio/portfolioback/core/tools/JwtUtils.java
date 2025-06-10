package fr.quentin.portfolio.portfolioback.core.tools;

import fr.quentin.portfolio.portfolioback.core.config.SecurityConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * The type Jwt utils.
 */
public class JwtUtils {
    private static final long TOKEN_DURATION = Duration.ofSeconds(SecurityConfig.getEXPIRATION_TIME_SECONDS())
                                                    .toMillis(); // 1H
    private static final long REFRESH_TOKEN_DURATION = Duration.ofSeconds(SecurityConfig.getEXPIRATION_TIME_SECONDS() * 7L)
                                                            .toMillis(); // 1H

    /**
     * Extract username string.
     *
     * @param jwtToken the jwt token
     * @return the string
     */
    public static String extractUsername(String jwtToken) {
        return extractClaim(jwtToken, Claims::getSubject);
    }

    /**
     * Validate token boolean.
     *
     * @param jwtToken    the jwt token
     * @param userDetails the user details
     * @return the boolean
     */
    public static boolean validateToken(String jwtToken, UserDetails userDetails) {
        final String username = extractUsername(jwtToken);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken);
    }

    /**
     * Is token expired boolean.
     *
     * @param jwtToken the jwt token
     * @return the boolean
     */
    public static boolean isTokenExpired(String jwtToken) {
        return extractExpiration(jwtToken).isBefore(LocalDate.now());
    }

    /**
     * Extract expiration local date.
     *
     * @param jwtToken the jwt token
     * @return the local date
     */
    public static LocalDate extractExpiration(String jwtToken) {
        return convertToLocalDateViaInstant(extractClaim(jwtToken, Claims::getExpiration));
    }

    /**
     * Extract claim t.
     *
     * @param <T>            the type parameter
     * @param jwtToken       the jwt token
     * @param claimsResolver the claims resolver
     * @return the t
     */
    public static <T> T extractClaim(String jwtToken, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(jwtToken);
        return claimsResolver.apply(claims);
    }

    private static Claims extractAllClaims(String jwtToken) {
        return Jwts.parser().setSigningKey(SecurityConfig.getJWT_SECRET_KEY()).parseClaimsJws(jwtToken).getBody();
    }

    private static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    /**
     * Generate token string.
     *
     * @param userDetails the user details
     * @return the string
     */
    public static String generateToken(UserDetails userDetails) {
        return createToken(userDetails, new Date(System.currentTimeMillis() + TOKEN_DURATION));
    }

    private static String createToken(UserDetails userDetails, Date expiration) {

        return Jwts.builder().setClaims(getClaims(userDetails)).setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SecurityConfig.getJWT_SECRET_KEY())
                .compact();
    }

    /**
     * Gets token from request.
     *
     * @param request the request
     * @return the token from request
     */
    public static String getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    private static Map<String, Object> getClaims(UserDetails userDetails) {
        if (userDetails == null)
            throw new UsernameNotFoundException("User not found");
        Map<String, Object> claims = new HashMap<>();
        claims.put("authorities", userDetails.getAuthorities());
        //Add other claim if needed
        return claims;
    }
}
