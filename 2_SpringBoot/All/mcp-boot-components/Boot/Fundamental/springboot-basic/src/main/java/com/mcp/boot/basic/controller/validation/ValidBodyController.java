package com.mcp.boot.basic.controller.validation;

import com.mcp.boot.basic.vo.ValidVO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: KG
 * @description:
 * @date: Created in 22:44 2022/5/8
 * @modified by:
 */
@RestController
@Slf4j
@RequestMapping("/valid-body")
public class ValidBodyController {

    @ApiOperation("RequestBody校验")
    @PostMapping("/test1")
    public String test1(@Valid @RequestBody ValidVO validVO) {
        log.info("validEntity is {}", validVO);
        return "test1 valid success";
    }
}
