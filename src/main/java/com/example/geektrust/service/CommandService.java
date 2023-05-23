package com.example.geektrust.service;

import com.example.geektrust.appconstants.CommandTypes;
import com.example.geektrust.model.Course;
import com.example.geektrust.utility.CommandParams;

import java.util.List;

public class CommandService {

    private final Course course;

    public CommandService(Course course) {
        this.course = course;
    }

    public void processCommand(List<CommandParams> params) {
        String outPutString="";
        for(CommandParams input:params){
            //LOGGER.info("Command->{}",input);
            //  System.out.println("+++++++"+input);
            if(input.getCommand().equals(CommandTypes.ADD_PROGRAMME.getType())){
               course.addProgramme(input.getTokens());
            }
            else if (input.getCommand().equals(CommandTypes.APPLY_COUPON.getType())) {
                course.applyCoupons(input.getTokens());
            }
            else if (input.getCommand().equals(CommandTypes.ADD_PRO_MEMBERSHIP.getType())) {
                course.addProMembership();
            }
            else if (input.getCommand().equals(CommandTypes.PRINT_BILL.getType())) {
                String output=course.calculateBill();
                System.out.println(output);
            }

        }
    }
}
