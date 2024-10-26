package cobolFileCreation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class bankAcctFileCreation {
	public static void main(String[] args) {
		String inputFilePath = "C:\\Users\\DELL\\OneDrive\\Desktop\\inputfile.txt";
		String outputFilePath = "C:\\Users\\DELL\\OneDrive\\Desktop\\outputfile.txt";
		String errorFilePath = "C:\\Users\\DELL\\OneDrive\\Desktop\\errorfile.txt";
		
		
		try {
			processFile(inputFilePath, outputFilePath, errorFilePath);
			System.out.println("Data coversion is complete");
			System.out.println("error report generated");
		} catch (IOException e) {
			System.out.println("An error occured:" + e.getMessage());
		}
	}
	private static void processFile(String inputFilePath, String outputFilePath, String errorFilePath) throws IOException {
		
		HashSet<String> seenRecords = new HashSet<>();
		
		HashSet<String> duplicateRecords = new HashSet<>();
		
		StringBuilder sb = new StringBuilder();
		StringBuilder errorsb = new StringBuilder();
		
		int totalRecords = 0;
		int rejectedRecords = 0; 
		int totalrecordWritten = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))){
			
			String line;
			
			while ((line = reader.readLine()) != null){
				if(line.startsWith("Routine")) {
					continue;
				}
				totalRecords++;
				
				String routingNumber = line.substring(0,9).trim();
				String accountNumber = line.substring(10).trim();
				if(routingNumber.length()>9)
				{
					errorsb.append(String.format("invalid Routing Number: %s, Accounting Number: %s%", routingNumber, accountNumber ));
					rejectedRecords++;
					continue;
				}
			if(accountNumber.length() > 17) {
				errorsb.append(String.format("Routing Number : %s, Invalid Accounting Number: %s%", routingNumber, accountNumber ));
				rejectedRecords++;
				continue;
			}
			String recordKey = routingNumber + "," + accountNumber;
			
			if(seenRecords.contains(recordKey)) {
				if(!duplicateRecords.contains(recordKey)) {
					errorsb.append(String.format("Duplicate Record: Routing Number: %s, Account Number: %s%", routingNumber, accountNumber));
					rejectedRecords++;
				}
			}
			else {
				seenRecords.add(recordKey);
				
				String formattedline = String.format("780,9,CH,EQ,C'%s',AND,789,17,CH,EQ,C'%s',OR,", routingNumber, accountNumber);
				sb.append(formattedline).append(System.lineSeparator());
				
				totalrecordWritten++;
			}
			}
		}
		try (BufferedWriter writer = new BufferedWriter (new FileWriter(outputFilePath))){
			writer.write(sb.toString());
		}
		
		errorsb.append(System.lineSeparator());
		errorsb.append(String.format("Total Records processed: %d%n", totalRecords));
		errorsb.append(String.format("Total Records rejected due to invalid Account/Routing number/Duplicate records: %d%n", rejectedRecords));
		errorsb.append(String.format("Total records written in output file: %d%n", totalrecordWritten));
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(errorFilePath))){
			writer.write(errorsb.toString());
		}
	}
}
