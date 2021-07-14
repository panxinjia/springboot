package com.xiaopantx.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

/**
 *
 * @author panxj
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private Integer id;
    private String name;
    private List<String> likes;
    private List<Location> locs;
    @Value("${p_email}")
    private String email;
}
