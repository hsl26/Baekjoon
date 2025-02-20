import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int Rows;
  private static int Cols;
  private static int attackRange;

  private static int[] archerPositions = new int[3];
  private static int[][] field;
  private static int max = 0;

  private static int canAttack(int[][] attackStatus, int distance, int currentRow, int archerCol) {
    for (int targetCol = archerCol - distance; targetCol <= archerCol + distance; targetCol++) {
      int targetRow = currentRow - (distance - Math.abs(targetCol - archerCol));

      if (targetRow < 0 || targetRow >= currentRow || targetCol < 0 || targetCol >= Cols)
        continue;
      if (field[targetRow][targetCol] == 0)
        continue;
      if (attackStatus[targetRow][targetCol] == 0) {
        attackStatus[targetRow][targetCol] = currentRow;
        return 1;
      } else if (attackStatus[targetRow][targetCol] == currentRow) {
        return 0;
      }
    }
    return -1;
  }

  private static int simulateGame() {
    int Enemies = 0;
    int[][] attackStatus = new int[Rows][Cols];

    for (int currentRow = Rows; currentRow > 0; currentRow--) {
      for (int archerCol : archerPositions) {
        for (int distance = 1; distance <= attackRange; distance++) {
          int attackResult = canAttack(attackStatus, distance, currentRow, archerCol);
          if (attackResult < 0)
            continue;
          Enemies += attackResult;
          break;
        }
      }
    }
    return Enemies;
  }

  private static void newArcherPositions(int count, int start) {
    if (count == 3) {
      max = Math.max(max, simulateGame());
      return;
    }
    for (int i = start; i < Cols; i++) {
      archerPositions[count] = i;
      newArcherPositions(count + 1, i + 1);
    }
  }

  public static void main(String[] args) throws Exception {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(reader.readLine());
    Rows = Integer.parseInt(st.nextToken());
    Cols = Integer.parseInt(st.nextToken());
    attackRange = Integer.parseInt(st.nextToken());

    field = new int[Rows][Cols];
    for (int i = 0; i < Rows; i++) {
      st = new StringTokenizer(reader.readLine());
      for (int j = 0; j < Cols; j++) {
        field[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    newArcherPositions(0, 0);
    System.out.println(max);
  }
}