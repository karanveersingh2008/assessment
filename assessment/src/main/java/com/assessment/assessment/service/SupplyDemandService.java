package com.assessment.assessment.service;

import com.assessment.assessment.entity.Demand;
import com.assessment.assessment.entity.Product;
import com.assessment.assessment.entity.Supply;

import java.util.ArrayList;
import java.util.List;

public class SupplyDemandService {

    private static List<Supply> supplyList = new ArrayList<>();
    private static List<Demand> demandList = new ArrayList<>();


    static {
        supplyList.add(new Supply("Product1",10));
        supplyList.add(new Supply("Product2",5));
    }

    static {
        demandList.add(new Demand("Product1",2));
        demandList.add(new Demand("Product2",5));
    }


    public static int findAvailability(String productId) {
        int avail = 0;

        Supply supply = supplyList.stream().filter(sup -> productId.equals(sup.getProductId())).findAny()
                .orElse(null);
        Demand demand = demandList.stream().filter(dem -> productId.equals(dem.getProductId())).findAny()
                .orElse(null);

        if (supply != null && demand != null)
            avail = (int) (supply.getQuantity() - demand.getQuantity());
        return avail;



    }

}


