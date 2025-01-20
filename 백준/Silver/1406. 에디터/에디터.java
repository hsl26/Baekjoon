import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		String[] strArr = str.split("");

		Stack<String> left = new Stack<>();
		Stack<String> right = new Stack<>();
		for (String s : strArr) {
			left.push(s);
		}

		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			String cmd = br.readLine();
			String text = "";

			if (cmd.length() > 1) {
				text = cmd.substring(2);
				cmd = cmd.substring(0, 1);
			}

			if (!left.isEmpty() && cmd.equals("L")) {
				right.push(left.pop());
			} else if (!right.isEmpty() && cmd.equals("D")) {
				left.push(right.pop());
			} else if (!left.isEmpty() && cmd.equals("B")) {
				left.pop();
			} else if (cmd.equals("P")){
				left.push(text);
			}
		}

		while (!left.empty()) {
			right.push(left.pop());
		}

		while (!right.empty()) {
			bw.write(right.pop());
		}
        
		bw.flush();
		bw.close(); 

	}
}