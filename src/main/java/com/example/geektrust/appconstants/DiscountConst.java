package com.example.geektrust.appconstants;

public class DiscountConst {
    public final static double DEAL_G20_PURCHASE_CRITERIA=10000;
    public final static int DEAL_G5_QUANTITY_CRITERIA=2;

    public final static double ENROLLMENT_FEE_CRITERIA=6666;

    public static double getDiscontForProgramme(Programme programme){
        double discount=0;
        if(programme.equals(Programme.DEGREE)){
            return Fees.PRO_MEMBERSHIP_DEGREE_DISCOUNT;
        } else if (programme.equals(Programme.CERTIFICATION)) {
            return Fees.PRO_MEMBERSHIP_CERTIFICATIOn_DISCOUNT;
        } else {
            return Fees.PRO_MEMBERSHIP_DIPLOMA_DISCOUNT;
        }
    }

}
