import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<Integer, int[]> cars = new TreeMap<>();
        
        for(int i=0;i<records.length;i++) {
            String[] arr = records[i].split(" ");
            
            int carNum = Integer.parseInt(arr[1]);
            
            cars.putIfAbsent(Integer.parseInt(arr[1]), new int[] {0, 0, 0});
            
            String[] time = arr[0].split(":");
            if(arr[2].equals("IN")) {
                
                cars.get(carNum)[0] = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
                cars.get(carNum)[1]  = 24*60;
                
            } else {
                
                cars.get(carNum)[1] = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
                cars.get(carNum)[2] += cars.get(carNum)[1] - cars.get(carNum)[0];
                
            }
        }
        
        int[] answer = new int[cars.size()];
        int idx = 0;
        
        for(Integer num : cars.keySet()) {
            
            if(cars.get(num)[1] == 24 * 60) {
                cars.get(num)[2] += 24 * 60 - 1 - cars.get(num)[0];
            }
            
            int t = cars.get(num)[2] - fees[0];
            int price = fees[1];
            
            if (t > 0) {
                price += Math.ceil((double)t / (double)fees[2] ) * fees[3];
            }
            
            answer[idx++] = price;
        }
        
        return answer;
    }
}