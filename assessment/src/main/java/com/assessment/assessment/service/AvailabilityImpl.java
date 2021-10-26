package com.assessment.assessment.service;

import com.assessment.assessment.entity.Availability;
import com.assessment.assessment.entity.RequestPOJO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

public class AvailabilityImpl implements Callable<Integer> {

    private static List<Availability> availabilityList = new ArrayList<>();

    int flag = 0;

    RequestPOJO request;

    AvailabilityImpl(){}
    public AvailabilityImpl(RequestPOJO request) {
        this.request = request;
    }

    static {

        try {
            availabilityList.add(
                    new Availability("Store001", "Prod1", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-19"), 1.0));
            availabilityList.add(
                    new Availability("Store001", "Prod1", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-20"), 3.0));
            availabilityList.add(
                    new Availability("Store001", "Prod1", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-21"), 0.0));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @Override
    public Integer call() throws Exception   {
        // TODO Auto-generated method stub
        String storeNumber = this.request.getStoreNo();
        Date reqDate = new SimpleDateFormat("yyyy-MM-dd").parse(this.request.getReqDate());

        availabilityList.forEach(availability ->{
            int result = availability.getDate().compareTo(reqDate);
            if (result == 0 && availability.getAvailQty() > 0) {
                flag = 1;
                //  break;
            }
            if (result == 0 && availability.getAvailQty() == 0) {
                flag = 0;
                //    break;
            }
        });
        return flag;
    }
}
