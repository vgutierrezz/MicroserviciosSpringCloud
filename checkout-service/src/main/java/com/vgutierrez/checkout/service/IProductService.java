package com.vgutierrez.checkout.service;

import java.util.List;
import com.vgutierrez.checkout.model.Checkout;
import com.vgutierrez.checkout.model.dto.Product;

public interface IProductService {

    Product getProduct(String id);  
}
