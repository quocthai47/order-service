package metanet.poc.orderservice.client;

import metanet.poc.orderservice.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "payment-service", url = "payment-service", path = "/payment")
@RequestMapping(produces = "application/json")
public interface PaymentFeignClient {

    @RequestMapping(value = "/reduceBalance", method = RequestMethod.POST, produces = "application/json")
    ResponseEntity reduceBalance(@RequestBody AccountDto accountDto);
}
