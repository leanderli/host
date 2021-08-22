package net.futureorigin.host.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * BlankController
 * <p></p>
 *
 * @author Leander Lee on 2021/8/22.
 */
@Controller
public class BlankController {

    @RequestMapping(path = "/")
    public String blank() {
        return "redirect:index.html";
    }
}
