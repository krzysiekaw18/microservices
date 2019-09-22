package com.krzysiek.s.microservices.currencyconversionservice;

import com.krzysiek.s.microservices.currencyconversionservice.bean.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//if I don't configured eureka yet
//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//if I dot'n configured zuul yet
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface ICurrencyExchangeServiceProxy {

//    @GetMapping("/currency-exchange/from/{from}/to/{to}")
//    if zuul is configured I have to add name of the service first (currency-exchange-service)
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
                                                 @PathVariable("to") String to);

}
