package com.assessment.assessment.controller;

import com.assessment.assessment.entity.Product;
import com.assessment.assessment.entity.RequestPOJO;
import com.assessment.assessment.entity.ResponsePOJO;
import com.assessment.assessment.entity.SupplyDemandRequestResponse;
import com.assessment.assessment.service.AvailabilityImpl;
import com.assessment.assessment.service.CapacityImpl;
import com.assessment.assessment.service.ProductService;
import com.assessment.assessment.service.SupplyDemandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RestController
public class Controller {

@Autowired
ProductService proserv;

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @PostMapping("/sortProducts")
    public Map<String, List<Product>> getSortedProduct(@RequestBody Map<String,List<Product>> productmap){
        logger.info("sortProducts post method endpoint triggred");
        Map response = new HashMap<String, List<Product>>();
        response.put("productList", proserv.getSortedProduct(productmap.get("productList")));
        return response;
    }


    @PostMapping("/getProdAvailability")
    public ResponseEntity<ResponsePOJO> getProdAvailability(@RequestBody RequestPOJO request ) throws InterruptedException, ExecutionException {
        ResponseEntity<ResponsePOJO> responseEntity=null;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> availabilityFuture = executorService.submit(new AvailabilityImpl(request));
        Future<Integer> capacityFuture = executorService.submit(new CapacityImpl(request));
        ResponsePOJO response= new ResponsePOJO();
        response.setStoreNo(request.getStoreNo());
        response.setProductId(request.getProductId());
        response.setReqQty(request.getReqQty());
        response.setReqDate(request.getReqDate());
        if(availabilityFuture.get()==1 && capacityFuture.get()==0) {
            response.setStatus("No Capacity");
            responseEntity= new ResponseEntity<ResponsePOJO>(response, HttpStatus.OK);
        }
        if(availabilityFuture.get()==1 && capacityFuture.get()==1) {
            response.setStatus("Available");
            responseEntity= new ResponseEntity<ResponsePOJO>(response, HttpStatus.OK);
        }
        if(availabilityFuture.get()==0 && capacityFuture.get()==1) {
            responseEntity= new ResponseEntity<ResponsePOJO>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;

    }

    @PostMapping("/getAvailability")
    public ResponseEntity<SupplyDemandRequestResponse> findStoreAvailability(@RequestBody SupplyDemandRequestResponse request) {

        int availableQuantity =  SupplyDemandService.findAvailability(request.getProductid());
        if (availableQuantity > 0) {
            request.setAvailableQuantity((double) availableQuantity);
            return new ResponseEntity<SupplyDemandRequestResponse>(request, HttpStatus.OK);
        } else {
            return new ResponseEntity<SupplyDemandRequestResponse>(HttpStatus.NO_CONTENT);
        }
    }

}
