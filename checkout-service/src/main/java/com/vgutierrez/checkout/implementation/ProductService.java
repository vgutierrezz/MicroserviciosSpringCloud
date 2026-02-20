package com.vgutierrez.checkout.implementation;
import com.vgutierrez.checkout.model.dto.Product;
import com.vgutierrez.checkout.repository.FeignProductrepository;
import com.vgutierrez.checkout.service.IProductService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service
public class ProductService implements IProductService {
    private FeignProductrepository feignProductrepository;

    Logger log = LoggerFactory.getLogger(ProductService.class);

    public ProductService(FeignProductrepository feignProductrepository) {
        super();
        this.feignProductrepository = feignProductrepository;
    }

    private int contador = 0;
    @Override
    @CircuitBreaker(name = "product", fallbackMethod = "getProductFallbackMethod")
    @Retry(name = "product")
    public Product getProduct(String id) {
        contador++;
        log.info("Intento número: " + contador + " para id: " + id);
        return feignProductrepository.getProductById(id, true);
    }

    public Product getProductFallbackMethod(String id, CallNotPermittedException exception){
        log.error("Circuit Breaker en estado Open");
        return new Product();
    }
}
