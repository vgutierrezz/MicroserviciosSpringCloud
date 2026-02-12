package com.vgutierrez.checkout.controller;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.vgutierrez.checkout.model.Checkout;

import com.vgutierrez.checkout.service.ICheckoutService;

@RestController
@RequestMapping("/checkout")
public class CheckoutRestController {
    private ICheckoutService checkoutService;

    public CheckoutRestController(ICheckoutService checkoutService) {
        super();
        this.checkoutService = checkoutService;
    }

    @GetMapping()
    public Checkout getCheckout(@RequestParam List<String> productIds, @RequestHeader("X-Request-from") String requestFrom, @RequestHeader Map<String, String> headers) {
        System.out.println("Enviado desde: " + requestFrom);
        if(!requestFrom.equals("gateway")){
            return null;
        }
        return checkoutService.buildCheckout(productIds);
    }

    @GetMapping("/{id}")
    public Checkout getById(@PathVariable String id) {
        return new Checkout(id);
    }

}
