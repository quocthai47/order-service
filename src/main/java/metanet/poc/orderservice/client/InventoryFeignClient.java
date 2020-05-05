package metanet.poc.orderservice.client;

import metanet.poc.orderservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "inventory-service", url = "inventory-service", path = "/inventory")
@RequestMapping(produces = "application/json")
public interface InventoryFeignClient {

    @RequestMapping(value = "/reduceStock", method = RequestMethod.POST, produces = "application/json")
    ResponseEntity reduceStock(@RequestBody ProductDto productDto);
}
