package cn.elegs.interfaces.order.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 订单管理类.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    final String LIST = "order/list";

    @RequestMapping(value = "/list")
    public String list() {
        //TODO:Get order list
        return LIST;
    }
}
