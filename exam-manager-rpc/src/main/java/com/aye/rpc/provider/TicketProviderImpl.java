package com.aye.rpc.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.aye.api.provider.TicketProvider;

/**
 * @Author Aye
 * @Description:
 * @Date: Created in 21:57 2019/4/16
 * @Version: V1.0
 */
@Service
//        (
//        version = "1.0.0",
//        application = "${dubbo.application.id}",
//        registry = "${dubbo.registry.id}"
//)
public class TicketProviderImpl implements TicketProvider {
    @Override
    public String buyTicket(String name) {
        return "买到了"+name;
    }
}
