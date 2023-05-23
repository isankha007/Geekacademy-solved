package com.example.geektrust.appconstants;

public class Fees {
    public final static double CERTIFICATION_FEE=3000;
    public final static double DEGREE_FEE=5000;

    public final static double DIPLOMA_FEE=2500;

    public final static double ENROLLMENT_FEE=500;
    public final static double PRO_MEMBERSHIP_FEE=200;

    public final static double PRO_MEMBERSHIP_DIPLOMA_DISCOUNT=0.01;

    public final static double PRO_MEMBERSHIP_CERTIFICATIOn_DISCOUNT=0.02;

    public final static double PRO_MEMBERSHIP_DEGREE_DISCOUNT=0.03;

    public final static double DEAL_G20=0.2;

    public final static double DEAL_G5 =0.05;


    public static double getFeeForProgramme(Programme programme){
        double fee=0;
        if(programme.equals(Programme.DEGREE)){
            fee =Fees.DEGREE_FEE;
        } else if (programme.equals(Programme.CERTIFICATION)) {
            fee= Fees.CERTIFICATION_FEE;
        } else {
            fee= Fees.DIPLOMA_FEE;
        }
        return fee;
    }





}
