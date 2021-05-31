package top.b0x0.mudubbo.myconsumer.controller;

import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.b0x0.mydubbo.myapi.service.ProvideService;
import top.b0x0.mydubbo.mycommon.exception.BusinessMsgEnum;
import top.b0x0.mydubbo.mycommon.vo.R;
import top.b0x0.mydubbo.mycommon.vo.req.SayHelloReq;

import javax.validation.constraints.NotNull;

/**
 * @author TANG
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试：消费者示例", value = "消费者示例")
@Validated  // 单个参数校验,需要在类上加此参数
public class ConsumerController {

//    @DubboReference(version = "${service.version}", check = false)
    @Reference(version = "${service.version}", check = false)
    ProvideService provideService;

    @GetMapping("/hello")
    public R sayHello(@Validated SayHelloReq vo) {
        String sayHello = provideService.sayHello("消费者 " + vo.getName() + " 访问了....");
        return R.ok(sayHello);
    }

    @GetMapping("/hello1")
    public R sayHello1(@NotNull(message = "name不能为空") String name) {
        String sayHello = provideService.sayHello("消费者 " + name + " 访问了....");
        return R.ok(sayHello);
    }

    @GetMapping("/error")
    public R error() {
        return R.fail(BusinessMsgEnum.PARMETER_EXCEPTION);
    }
}
