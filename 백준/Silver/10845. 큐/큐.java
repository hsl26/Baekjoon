import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		int last = -1;
		
		for (int i=0; i<T; i++) {
			String cmd = br.readLine();
			String[] cmds = cmd.split(" ");
			
			if (cmds[0].equals("pop")) {
				if (q.isEmpty()) 
					bw.write(-1+"\n");
				else
					bw.write(q.remove()+"\n");
			} else if (cmds[0].equals("size")) {
				bw.write(q.size()+"\n");
			} else if (cmds[0].equals("empty")) {
				if (q.isEmpty()) 
					bw.write(1+"\n");
				else
					bw.write(0+"\n");
			} else if (cmds[0].equals("front")) {
				if (q.isEmpty())
					bw.write(-1+"\n");
				else
					bw.write(q.peek()+"\n");
			} else if (cmds[0].equals("back")) {
				if (q.isEmpty())
					bw.write(-1+"\n");
				else
					bw.write(last+"\n");
			} else if (cmds[0].equals("push")) {
				q.add(Integer.parseInt(cmds[1]));
				last = Integer.parseInt(cmds[1]);
			}
		}

		bw.flush();
		bw.close();

	}
}
