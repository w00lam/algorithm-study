import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTimeMap = new HashMap<>();
        Map<String, Integer> totalTimeMap = new HashMap<>();
        
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        for(String record : records){
            String[] parts = record.split(" ");
            String timeString = parts[0];
            String carNum = parts[1];
            String type = parts[2];
            
            String[] timeParts = timeString.split(":");
            int time = Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]);
            
            if(type.equals("IN")){
                inTimeMap.put(carNum, time);
            } else {
                int inTime = inTimeMap.get(carNum);
                int parkedTime = time - inTime;
                
                totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + parkedTime);
                inTimeMap.remove(carNum);
            }
        }
        
        int endOfDay = 23 * 60 + 59;
        
        for (Map.Entry<String, Integer> entry : inTimeMap.entrySet()) {
            String carNum = entry.getKey();
            int inTime = entry.getValue();
            
            int parkedTime = endOfDay - inTime;
            totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + parkedTime);
        }
        
        List<String> carNums = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(carNums);
        
        int[] answer = new int[carNums.size()];
        for(int i = 0; i < carNums.size(); i++){
            String carNum = carNums.get(i);
            int totalTime = totalTimeMap.get(carNum);
            
            if(totalTime <= basicTime){
                answer[i] = basicFee;
            } else {
                answer[i] = basicFee + (int) Math.ceil((double) (totalTime - basicTime) / unitTime) * unitFee;
            }
        }
        
        return answer;
    }
}