package com.example.geektrust;

import com.example.geektrust.model.Course;
import com.example.geektrust.service.CommandService;
import com.example.geektrust.utility.CommandParams;
import com.example.geektrust.utility.FileReaderUtility;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CommandServiceTest {

    @Test
    void processCommandTest(){
        FileReaderUtility fileReaderObj=new FileReaderUtility("sample_input/input5.txt");
        List<CommandParams> commandParams = fileReaderObj.getCommandParams();
        CommandService commandService=new CommandService(new Course());
        commandService.processCommand(commandParams);
    }
}
