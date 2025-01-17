import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Set<String> wordSet = new TreeSet<>((s1, s2) -> {
			return s1.length() == s2.length() ? s1.compareTo(s2) : Integer.compare(s1.length(), s2.length());
		});
		
		for (int i=0; i<N; i++) {
			wordSet.add(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		for (String word : wordSet) {
			sb.append(word).append("\n");
		}
		System.out.print(sb.toString());
	}

}
