package com.example.geektrust;

import com.example.geektrust.appconstants.Coupons;
import com.example.geektrust.appconstants.Fees;
import com.example.geektrust.appconstants.Programme;
import com.example.geektrust.model.Course;
import com.example.geektrust.utility.CommandParams;
import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CourseTest {
    Course course;

    @BeforeEach
    void setCourse(){
        course=new Course();
    }

    @Test
    void addPrommaggeTest(){
        List<String> token= Arrays.asList("DEGREE","2");
        Map<Programme, Integer> programmeIntegerMap = course.addProgramme(token);
        Assert.assertNotNull(programmeIntegerMap.get(Programme.DEGREE));
        token= Arrays.asList("DIPLOMA","1");
        course.addProgramme(token);
        System.out.println(programmeIntegerMap);

    }

    @Test
    void applyCoupon(){

        List<String> token= Arrays.asList("DEAL_G20");
        Map<Coupons, Double> couponsDoubleMap = course.applyCoupons(token);
        Assert.assertEquals(Fees.DEAL_G20, couponsDoubleMap.get(Coupons.DEAL_G20));
       // Assert.assertEquals(0,couponsList.indexOf(Coupons.DEAL_G20));

    }


    @Test
    void addProMembershipTest(){
        course.addProMembership();
    }
    @Test
    void calculateBillTest(){
        List<String> token= Arrays.asList("DEGREE","2");
        Map<Programme, Integer> programmeIntegerMap = course.addProgramme(token);
        Assert.assertNotNull(programmeIntegerMap.get(Programme.DEGREE));
        token= Arrays.asList("DIPLOMA","1");
        course.addProgramme(token);

       // course.addProMembership();
        token= Arrays.asList("DEAL_G5");
       // course.applyCoupons(token);

        String bill = course.calculateBill();
        String[] lines = bill.split("\n");
        String[] subtotals = lines[0].split(" ");
        System.out.println(subtotals[1]);
        Assert.assertEquals("SUB_TOTAL",subtotals[0]);
        Assert.assertEquals("12500.00",subtotals[1]);


    }

/*    @Test
    void calculateSubtotalAmountTest(){
        List<String> token=Arrays.asList("CERTIFICATION","1");
        course.addProgramme(token);
        token=Arrays.asList("DEGREE","1");
        course.addProgramme(token);

        token=Arrays.asList("DIPLOMA","2");
        course.addProgramme(token);
        course.calculateSubtotalAmount();
    }*/



}
