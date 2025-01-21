import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Deque<String> deq = new LinkedList<>();

		int N = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < N; i++) {
			String cmd = sc.nextLine();

			switch (cmd) {
			case "pop_front":
				if (deq.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deq.removeFirst());
				}
				break;
			case "pop_back":
				if (deq.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deq.removeLast());
				}
				break;
			case "size":
				System.out.println(deq.size());
				break;
			case "empty":
				if (deq.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case "front":
				if (deq.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deq.peekFirst());
				}
				break;
			case "back":
				if (deq.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deq.peekLast());
				}
				break;
			default:
				String[] cmds = cmd.split(" ");
				if (cmds[0].equals("push_front")) {
					deq.addFirst(cmds[1]);
				} else if (cmds[0].equals("push_back")) {
					deq.addLast(cmds[1]);
				}
				break;

			}

		}

	}
}
