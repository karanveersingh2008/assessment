package com.assessment.assessment.service;

import com.assessment.assessment.entity.Capacity;
import com.assessment.assessment.entity.RequestPOJO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

@Service
public class CapacityImpl implements Callable<Integer> {

    private static List<Capacity> capacityList = new ArrayList<>();
    int flag = 0;

    RequestPOJO request;

    CapacityImpl(){}
    public CapacityImpl(RequestPOJO request) {
        this.request = request;
    }
    static {

        try {
            capacityList.add(
                    new Capacity("Store001","Prod1", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-19"), 0.0));
            capacityList.add(
                    new Capacity("Store001", "Prod1",new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-20"), 2.0));
            capacityList.add(
                    new Capacity("Store001","Prod1" ,new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-21"), 2.0));
                    } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Integer call() throws Exception {
        String storeNumber = this.request.getStoreNo();
        Date reqDate = new SimpleDateFormat("yyyy-MM-dd").parse(this.request.getReqDate());


        capacityList.forEach(capacity ->{
            int result = capacity.getDate().compareTo(reqDate);
            if (result == 0 && capacity.getNoOfOrdersAccepted() > 0) {
                flag = 1;
                //  break;
            }
            if (result == 0 && capacity.getNoOfOrdersAccepted() == 0) {
                flag = 0;
                //    break;
            }
        });


        return flag;
    }
}

