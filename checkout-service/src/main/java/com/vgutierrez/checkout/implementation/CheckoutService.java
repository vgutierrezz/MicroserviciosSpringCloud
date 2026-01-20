package com.vgutierrez.checkout.implementation;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vgutierrez.checkout.model.Checkout;
import com.vgutierrez.checkout.service.ICheckoutService;
import com.vgutierrez.checkout.service.IProductService;

import com.vgutierrez.checkout.model.dto.Product;

@Service
public class CheckoutService implements ICheckoutService {
    private IProductService productService;

    public CheckoutService(IProductService productService) {
        this.productService = productService;
    }

   @Override
    public Checkout buildCheckout(List<String> productIds) {
       Double total = 0.0;
       for (String id : productIds) {
           Product product = productService.getProduct(id);
           System.out.println("Product from Product Service: " + product.getInstance());
           total += product.getPrice();
       }
       Checkout checkout = new Checkout("1", "http://checkout.url", total.toString(), Arrays.asList("CREDIT_CARD", "PAYPAL"));
       return checkout;
    } 
}
