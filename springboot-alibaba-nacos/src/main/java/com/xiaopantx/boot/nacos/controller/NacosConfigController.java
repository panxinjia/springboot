package com.xiaopantx.boot.nacos.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author panxj
 */
@RestController
@RequestMapping(value = "config")
public class NacosConfigController {


    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @GetMapping(value = "useLocalCache")
    public Object useLocalCache() {
        return this.useLocalCache;
    }
}
