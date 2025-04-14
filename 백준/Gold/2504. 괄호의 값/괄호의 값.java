import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  static String arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    arr = br.readLine();
    Stack<Object> s = new Stack<>();

    for (int i = 0; i < arr.length(); i++) {

      char c = arr.charAt(i);

      if (c == '(' || c == '[') {
        s.push(c);
      } else {
        int tmp = 0;

        while (!s.isEmpty() && s.peek() instanceof Integer) {
          tmp += (int) s.pop();
        }

        if (s.isEmpty()) {
          System.out.println(0);
          return;
        }

        char top = (char) s.pop();

        if (c == ')' && top == '(') {
          s.push(tmp == 0 ? 2 : 2 * tmp);
        } else if (c == ']' && top == '[') {
          s.push(tmp == 0 ? 3 : 3 * tmp);
        } else {
          System.out.println(0);
          return;
        }
      }
    }

    int res = 0;
    for (Object o : s) {
      if (o instanceof Character) {
        System.out.println(0);
        return;
      }
      res += (int) o;
    }

    System.out.println(res);
  }
}