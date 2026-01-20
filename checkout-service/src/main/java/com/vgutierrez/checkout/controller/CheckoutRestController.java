package com.vgutierrez.checkout.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Checkout getCheckout(@RequestParam List<String> productIds) {
        return checkoutService.buildCheckout(productIds);
    }
}
