package com.assessment.assessment.service;

import com.assessment.assessment.entity.Product;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static List<Product> productList = new ArrayList<>();


    static {
        try {
            productList
                    .add(new Product("Prod1", "Shirt", "EACH", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-21")));
            productList.add(
                    new Product("Prod2", "Trousers", "EACH", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-19")));
            productList
                    .add(new Product("Prod3", "Tie", "EACH", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-22")));
            productList
                    .add(new Product("Prod3", "Tie", "EACH", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-24")));

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Product> getSortedProduct(List<Product> Pro) {

        List<Product> sortedList = Pro.stream()
                .sorted(productComparator.reversed())
                .collect(Collectors.toList());

        return sortedList;
    }

    Comparator<Product> productComparator = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            if(p1.getProductId() == p2.getProductId()) {
                return p1.getLaunchDate().compareTo(p2.getLaunchDate());
            }
            else if (!p1.getProductId().equalsIgnoreCase(p2.getProductId()))
            {
                //System.out.println("here me"+o1.getProductId().compareTo(o2.getProductId()));
                return p1.getProductId().compareTo(p2.getProductId());
            }
            else
                return -1;
        }
    };


}
