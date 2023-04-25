package com.crio.jukebox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import com.crio.jukebox.appConfig.ApplicationConfig;
import com.crio.jukebox.commands.CommandInvoker;


public class App {
    // To run the application  ./gradlew run --args="INPUT_FILE=jukebox-input.txt"
	public static void main(String[] args) throws IOException {

        // String s =  "INPUT_FILE=jukebox-input.txt";
		List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));


        String expectedSequence = "INPUT_FILE";
        String actualSequence = commandLineArgs.stream()
                .map(a -> a.split("=")[0])
                .collect(Collectors.joining("$"));
                
        if(expectedSequence.equals(actualSequence)){
            run(commandLineArgs);
        }
       
	}

    public static void run(List<String> commandLineArgs) throws IOException {
   
        ApplicationConfig applicationConfig = new ApplicationConfig();
        CommandInvoker songsInvoker = applicationConfig.getSongsInvoker();
        BufferedReader reader;
        String inputFile = commandLineArgs.get(0).split("=")[1];
        commandLineArgs.remove(0);
            
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            while (line != null) {
                List<String> songs = Arrays.asList(line.split(" "));

                songsInvoker.executeCommand(songs.get(0),songs);
                
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
       
    }
}
