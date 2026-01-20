package com.vgutierrez.checkout.service;

import java.util.List;
import com.vgutierrez.checkout.model.Checkout;

public interface ICheckoutService {
    public Checkout buildCheckout(List<String> productIds);
}
