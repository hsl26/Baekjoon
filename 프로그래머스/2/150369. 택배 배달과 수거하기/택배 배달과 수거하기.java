class Solution {
  public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
    long answer = 0;

    int dIdx = n - 1;
    int pIdx = n - 1;

    while (!(dIdx < 0 && pIdx < 0)) {

      while (dIdx >= 0 && deliveries[dIdx] == 0) {
        dIdx--;
      }

      while (pIdx >= 0 && pickups[pIdx] == 0) {
        pIdx--;
      }

      int l = Math.max(dIdx, pIdx);
      answer += 2 * (l + 1);

      int c = cap;
      while (c > 0 && dIdx >= 0) {
        if (deliveries[dIdx] >= c) {
          deliveries[dIdx] -= c;
          c = 0;
          if (deliveries[dIdx] == c)
            dIdx--;
          break;
        }

        c -= deliveries[dIdx];
        deliveries[dIdx] = 0;

        dIdx--;
      }

      c = cap;
      while (c > 0 && pIdx >= 0) {
        if (pickups[pIdx] >= c) {
          pickups[pIdx] -= c;
          c = 0;
          if (pickups[pIdx] == c)
            pIdx--;
          break;
        }

        c -= pickups[pIdx];
        pickups[pIdx] = 0;

        pIdx--;
      }

    }

    return answer;
  }

}
