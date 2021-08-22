package net.futureorigin.host.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * HostProperties
 * <p></p>
 *
 * @author Leander Lee on 2021/8/22.
 */
@ConfigurationProperties(prefix = "net.futureorigin.host")
@Getter
@Setter
@ToString
public class HostProperties {

    private String[] allowedAccesskey;
}
