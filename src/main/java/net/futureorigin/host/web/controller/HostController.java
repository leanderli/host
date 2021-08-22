package net.futureorigin.host.web.controller;

import com.alibaba.cola.dto.SingleResponse;
import net.futureorigin.host.common.util.HostUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * HostController
 * <p></p>
 *
 * @author Leander Lee on 2021/8/22.
 */
@RestController
@RequestMapping(path = "host")
public class HostController {

    @GetMapping(path = "myHost")
    public SingleResponse<String> getIp(HttpServletRequest request) {
        return SingleResponse.of(HostUtils.getRealIpV2(request));
    }


}
