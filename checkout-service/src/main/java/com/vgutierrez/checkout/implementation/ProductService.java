package com.vgutierrez.checkout.implementation;
import com.vgutierrez.checkout.model.dto.Product;
import com.vgutierrez.checkout.repository.FeignProductrepository;
import com.vgutierrez.checkout.service.IProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    private FeignProductrepository feignProductrepository;

    public ProductService(FeignProductrepository feignProductrepository) {
        this.feignProductrepository = feignProductrepository;
    }

    @Override
    public Product getProduct(String id) {
        return feignProductrepository.getProductById(id);
    }

}
