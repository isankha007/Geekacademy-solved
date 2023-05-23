package com.example.geektrust.model;

import com.example.geektrust.appconstants.Coupons;
import com.example.geektrust.appconstants.DiscountConst;
import com.example.geektrust.appconstants.Fees;
import com.example.geektrust.appconstants.Programme;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Course {
    private final Map<Programme,Integer> programmeMap=new LinkedHashMap<>();

    private final Map<Coupons,Double> couponsMap=new HashMap<>();

    private double proDiscount=0;

    private double couponsDiscount=0;

    private boolean proMember=false;

    private double proMembershipFee=0;

    private double subtotal=0;

    private double totalAmount=0;



    public Map<Programme,Integer> addProgramme(List<String> token){
        Programme programme= Programme.valueOf(token.get(0));
        Integer quantity= Integer.valueOf(token.get(1));
        programmeMap.put(programme,programmeMap.getOrDefault(programme,0)+quantity);
        return programmeMap;


    }
    public Map<Coupons,Double> applyCoupons(List<String> token){
        Coupons coupon= Coupons.valueOf(token.get(0).trim());
        double discount=0;
        if(coupon.equals(Coupons.DEAL_G20)){
            discount=Fees.DEAL_G20;
        }else if(coupon.equals(Coupons.DEAL_G5)){
            discount=Fees.DEAL_G5;
        }
        couponsMap.put(coupon,discount);
        return couponsMap;
    }

    public void addProMembership(){
        this.proMember = true;

    }

    public String calculateBill(){
        subtotal=0;
        totalAmount=0;

        if(proMember){
            proMembershipFee=Fees.PRO_MEMBERSHIP_FEE;
            //subtotal+=proMembershipFee;
        }
        calculateSubtotalAmount();

        // System.out.println("+++++++++++"+subtotal);
        totalAmount = subtotal;
        Coupons tempCoupon = Coupons.NONE;
        int totalProgrammsPurchased= programmeMap.values().stream().reduce(0, Integer::sum);

        if(totalProgrammsPurchased>=4){
            //B4G1 applied
            Programme lowesPriceProgramme = getLowesPriceProgramme();
            double feeForProgramme = Fees.getFeeForProgramme(lowesPriceProgramme);
            couponsDiscount = feeForProgramme;
            if(proMember){
                //we need not revert the discount too
                double revertProDiscount = feeForProgramme *
                        (DiscountConst.getDiscontForProgramme(lowesPriceProgramme));
                couponsDiscount-=revertProDiscount;
            }
            tempCoupon = Coupons.B4G1;

        }else{
            if(couponsMap.containsKey(Coupons.DEAL_G20) && subtotal>=DiscountConst.DEAL_G20_PURCHASE_CRITERIA){
                couponsDiscount=subtotal*Fees.DEAL_G20;
                tempCoupon=Coupons.DEAL_G20;
            }else if(couponsMap.containsKey(Coupons.DEAL_G5) && totalProgrammsPurchased>=DiscountConst.DEAL_G5_QUANTITY_CRITERIA){
                tempCoupon=Coupons.DEAL_G5;
                couponsDiscount=subtotal*Fees.DEAL_G5;
            }
        }
        double enrolMentFee=0;
        if(subtotal< DiscountConst.ENROLLMENT_FEE_CRITERIA){
            totalAmount +=Fees.ENROLLMENT_FEE;
            enrolMentFee=Fees.ENROLLMENT_FEE;
        }
        totalAmount -=couponsDiscount;


        return "SUB_TOTAL " + String.format("%.2f", subtotal) + "\n" +
                "COUPON_DISCOUNT " + tempCoupon.getType() + " " + String.format("%.2f", couponsDiscount) + "\n" +
                "TOTAL_PRO_DISCOUNT " + String.format("%.2f", proDiscount) + "\n" +
                "PRO_MEMBERSHIP_FEE " + String.format("%.2f", proMembershipFee) + "\n" +
                "ENROLLMENT_FEE " + String.format("%.2f", enrolMentFee) + "\n" +
                "TOTAL " + String.format("%.2f", totalAmount) + "\n";
    }

    private void calculateSubtotalAmount(){
       // AtomicInteger totalProgrammsPurchased= new AtomicInteger();
       // final double[] subtotal = {0,0};
        programmeMap.forEach((programme, quantity) ->
        {
            //calculate subtotal
            double actualPurchaseAmount=Fees.getFeeForProgramme(programme)*quantity;
           // System.out.println("==="+programme+" "+quantity+" "+Fees.getFeeForProgramme(programme));
            if(proMember){
                //for Pro Member
                double discountTemp=actualPurchaseAmount*DiscountConst.getDiscontForProgramme(programme);
                double discountedAmount=actualPurchaseAmount-discountTemp;
                proDiscount+=discountTemp;
                actualPurchaseAmount=discountedAmount;
            }
            subtotal +=actualPurchaseAmount;

        });
        subtotal+=proMember?Fees.PRO_MEMBERSHIP_FEE:0.0;

    }



    private Programme getLowesPriceProgramme(){
        if(programmeMap.containsKey(Programme.DIPLOMA)){
            return Programme.DIPLOMA;
        } else if(programmeMap.containsKey(Programme.CERTIFICATION)){
            return Programme.CERTIFICATION;
        }
        return Programme.DEGREE;
    }

}
