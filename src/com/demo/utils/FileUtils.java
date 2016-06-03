package com.demo.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TimeZone;

public class FileUtils {
	private static String FILE_TIMESTAMP_FORMAT = "-yyyyMMdd_HHmmss_SSS";
    private static String FILENAME_EXT = ".xml";
	private static String primaryNamePrefix = "prefix";
	private static String deltaFileNamePrefix = "prefix";

	public static long getRuleFileTimestamp(String fileName) {
		long timestamp = -1;
        if (fileName == null) {
            return timestamp;
        }
        if (!fileName.toLowerCase().endsWith(FILENAME_EXT .toLowerCase())) {
            return timestamp;
        }
        if (!fileName.startsWith(primaryNamePrefix) && !fileName.startsWith(deltaFileNamePrefix)) {
            return timestamp;
        }
        int ind = fileName.length() - FILENAME_EXT.length() - FILE_TIMESTAMP_FORMAT .length();
        if (ind < 0) {
            return timestamp;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(FILE_TIMESTAMP_FORMAT);
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            sdf.setLenient(false);

            timestamp = sdf.parse(fileName.substring(ind)).getTime();
        } catch (ParseException e) {
            
        }
        
        return timestamp;
    }
	
    
	/**
	 * The method will append a object to file. Using BufferWriter
	 * 
	 * @param number
	 * @param file
	 * @return The method returns true if append success else false
	 * @throws IOException
	 */
	public static boolean appendToFile(Number number, File file) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		writer.append(String.valueOf(number));
		writer.newLine();
		writer.close();
		
		return true;
	}
	
	/**
	 * This method read the no empty line before the end of file. Using
	 * bufferdReader
	 * 
	 * @return
	 */
	public static String getLineBeforeEndOfFile(File file) throws IOException{
		String lastLine = null, currentLine = null;
		
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(
				new FileInputStream(file)));
		
		while ((currentLine = buffReader.readLine()) != null) {
			if (StringUtils.isNotBlank(currentLine)) {
				lastLine = currentLine;
			}
		}
		buffReader.close();
		
		return lastLine;
	}
	
	/**
	 * This method write a string to file
	 * 
	 * @param destinationFileName
	 * @param str
	 * @throws IOException 
	 */
	public static void writeToFile(String destinationFileName, String str) throws IOException{
		File destinationFile = new File(destinationFileName);

		if (!destinationFile.exists()) {
			destinationFile.createNewFile();
		} else {
			destinationFile.delete();
			destinationFile.createNewFile();
		}

		PrintWriter pw = new PrintWriter(new FileWriter(destinationFileName));
		pw.println(str);
		pw.close();
	}
	
	/**
	 * The method get line set from a file
	 * @param file
	 */
	public static Set<String> getLineSet(File file) throws FileNotFoundException{
		Set<String> lineSet = new HashSet<String>(); 
		
		Scanner scanner = new Scanner(file);
		
		String lineText;
		while (scanner.hasNextLine())
		{
			lineText = scanner.nextLine();
			if (lineText != null && !lineText.trim().isEmpty()) {
				lineSet.add(lineText.trim());
			}
		}
		scanner.close();
		
		return lineSet;
	}
}
