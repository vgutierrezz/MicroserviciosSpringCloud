package com.vgutierrez.checkout.repository;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vgutierrez.checkout.configuration.LoadBalancerConfiguration;
import com.vgutierrez.checkout.model.dto.Product;

@FeignClient(name = "product-service")
@LoadBalancerClient(name = "product-service", configuration = LoadBalancerConfiguration.class)
public interface FeignProductrepository {

    @RequestMapping(method = RequestMethod.GET, value = "/products")

    Product getProductById(@RequestParam String id);
}
