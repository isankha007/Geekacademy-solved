package com.example.geektrust;

import com.example.geektrust.appconstants.DiscountConst;
import com.example.geektrust.appconstants.Programme;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class DiscountConstTest {
    @Test
    void getDiscontForProgramme(){
        double discontForProgramme = DiscountConst.getDiscontForProgramme(Programme.CERTIFICATION);
        Assert.assertEquals(0.02,discontForProgramme);
    }
}
