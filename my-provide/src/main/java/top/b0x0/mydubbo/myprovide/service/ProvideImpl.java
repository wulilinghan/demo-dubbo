package top.b0x0.mydubbo.myprovide.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;
import top.b0x0.mydubbo.myapi.service.ProvideService;

/**
 * @author TANG
 */
@DubboService(version = "${service.version}")
@Component
public class ProvideImpl implements ProvideService {

    @Override
    public String sayHello(String word) {
        return word;
    }
}