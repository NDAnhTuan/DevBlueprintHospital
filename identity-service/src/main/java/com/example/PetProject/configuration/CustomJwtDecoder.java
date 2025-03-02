package com.example.PetProject.configuration;

import com.example.PetProject.dto.request.IntrospectRequest;
import com.example.PetProject.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.text.ParseException;
import java.util.Objects;

@Component
public class CustomJwtDecoder implements JwtDecoder {
    @Value("${jwt.signerKey}")
    private String signerKey;

    @Autowired
    private AuthenticationService authenticationService;

    private NimbusJwtDecoder nimbusJwtDecoder = null;

    @Override
    public Jwt decode(String token) {
        /* Vi api gateway da kiem tra token nen kh can thiet nua*/
//        try {
//            // kiểm tra token hợp lệ hay chưa hoặc hết hạn
//            // hoặc đã logout hay chưa
//            var response = authenticationService.introspect(IntrospectRequest.builder()
//                            .token(token)
//                    .build());
//            if (response.isValid())
//                throw new JwtException("Token Invalid");
//        }
//        catch (JOSEException | ParseException e) {
//            throw new JwtException(e.getMessage());
//        }
        // nimbusJwtDecoder dung de verify signature cua Token
//        if (Objects.isNull(nimbusJwtDecoder)) {
//            SecretKeySpec secretKeySpec = new SecretKeySpec(signerKey.getBytes(), "HS512");
//             nimbusJwtDecoder = NimbusJwtDecoder
//                     .withSecretKey(secretKeySpec)
//                     .macAlgorithm(MacAlgorithm.HS512)
//                     .build();
//        }

//        return nimbusJwtDecoder.decode(token);
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            return new Jwt(token,
                    signedJWT.getJWTClaimsSet().getIssueTime().toInstant(),
                    signedJWT.getJWTClaimsSet().getExpirationTime().toInstant(),
                    signedJWT.getHeader().toJSONObject(),
                    signedJWT.getJWTClaimsSet().getClaims()
                    );
        }
        catch (ParseException e) {
            throw new JwtException("Invalid token");
        }
    }

}
