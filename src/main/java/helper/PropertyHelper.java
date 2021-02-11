package helper;

import java.util.*;  
import java.io.*;  
public class PropertyHelper { 
	

public static String helperProperty(String paramter1) throws Exception{  
    FileReader reader=new FileReader("src//main//resources//test.properties");  
    Properties p=new Properties();  
    p.load(reader);       
    return p.getProperty(paramter1);
}  
}  