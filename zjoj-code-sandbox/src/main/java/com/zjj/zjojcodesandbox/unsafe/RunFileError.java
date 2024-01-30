package com.zjj.zjojcodesandbox.unsafe;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Classname RunFileError
 * @Description Run Trojan virus
 * @Author zjj
 * @Date 1/30/24 12:43 PM
 */
public class RunFileError {

    public static void main(String[] args) throws IOException, InterruptedException {
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + File.separator + "src/main/resources/trojan.bat";
        Process process = Runtime.getRuntime().exec(filePath);
        process.waitFor();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        //read by line
        String compileOutputLine;
        while ((compileOutputLine = bufferedReader.readLine()) != null) {
            System.out.println(compileOutputLine);
        }

        System.out.println("Run Trojan...");
    }
}
