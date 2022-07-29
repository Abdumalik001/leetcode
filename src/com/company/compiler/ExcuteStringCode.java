package com.company.compiler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class ExcuteStringCode {


    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        try {
            System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.8.0_66");
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Abdumalik\\StudioProjects\\leetcode\\src\\C"));
            PrintWriter writer = new PrintWriter("Test.java");
            writer.write("public class Test{\n");
            writer.write("public static void excute(){\n");
            String reader = "";
            System.out.println("start");
            while ((reader = (br.readLine())) != null) {
                writer.write(reader + "\n");
            }
            writer.write("}\n}");

            br.close();
            writer.close();

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            System.out.println(compiler);
            int b = compiler.run(null, null, null, "d:\\Test.java");
            Test testme = new Test();
            testme.excute();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}