package net.futureorigin.host;

import net.futureorigin.host.common.config.HostProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * HostApp
 * <p></p>
 *
 * @author Leander Lee on 2021/8/22.
 */
@SpringBootApplication
@EnableConfigurationProperties({
        HostProperties.class
})
public class HostApp {

    public static void main(String[] args) {
        SpringApplication.run(HostApp.class, args);
    }
}
