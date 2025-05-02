import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine(); 
    String boom = br.readLine(); 

    int boomLen = boom.length();
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      stack.push(str.charAt(i));

      if (stack.size() >= boomLen) {
        boolean isBoom = true;
        for (int j = 0; j < boomLen; j++) {
          if (stack.get(stack.size() - boomLen + j) != boom.charAt(j)) {
            isBoom = false;
            break;
          }
        }

        if (isBoom) {
          for (int j = 0; j < boomLen; j++) {
            stack.pop();
          }
        }
      }
    }

    if (stack.isEmpty()) {
      System.out.println("FRULA");
    } else {
      String result = stack.stream().map(String::valueOf).collect(Collectors.joining());
      System.out.println(result);
    }
  }
}
