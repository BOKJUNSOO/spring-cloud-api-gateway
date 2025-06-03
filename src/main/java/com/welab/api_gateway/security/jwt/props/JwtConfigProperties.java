package com.welab.api_gateway.security.jwt.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// bean 등록과 다른 클래스에 의존성 주입을 위한 어노테이션
@Component
// yaml 파일에 있는 값을 읽어오기 위한 어노테이션 
@ConfigurationProperties(value = "jwt", ignoreUnknownFields = true)
@Getter
@Setter
public class JwtConfigProperties {
    private String header;
    private String secretKey;
}
