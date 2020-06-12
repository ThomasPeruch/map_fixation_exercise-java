package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map <String,Integer> candidate = new LinkedHashMap<>();
		
		System.out.println("Enter file full path : ");
		String path = sc.next();

		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line!=null) {
				String[] fields = line.split(",");
				String name  = fields[0];
				int votes = Integer.parseInt(fields[1]);
				
				if(candidate.containsKey(name)) {
					int votesSoFar = candidate.get(name);
					candidate.put(name, votes + votesSoFar);
				}
				else {
					candidate.put(name,votes);
				}
				line = br.readLine();
			}
			
			for(String x : candidate.keySet()){
				System.out.println(x + ": " + candidate.get(x));
				
			}
		}catch(IOException e) {
			System.out.println("error : " + e.getMessage());
		}	
	}
}
