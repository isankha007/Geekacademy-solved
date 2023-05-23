package com.example.geektrust;

import com.example.geektrust.appconstants.Fees;
import com.example.geektrust.appconstants.Programme;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class FeesTest {
    @Test
    void getFeeForProgramme(){
        double feeForProgramme = Fees.getFeeForProgramme(Programme.CERTIFICATION);
        Assert.assertEquals(3000.0,feeForProgramme);
    }
}
