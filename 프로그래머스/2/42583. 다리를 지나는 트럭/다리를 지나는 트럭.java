import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> truckQueue = new LinkedList<>();
        for(int truck : truck_weights){
            truckQueue.offer(truck);
        }
        
        Queue<Integer> bridgeQueue = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++){
            bridgeQueue.offer(0);
        }
        
        int answer = 0;
        int currentWeight = 0;
        
        while(!truckQueue.isEmpty() || currentWeight > 0){
            currentWeight -= bridgeQueue.poll();
            answer++;
            
            if(!truckQueue.isEmpty() && currentWeight + truckQueue.peek() <= weight){
                int truck = truckQueue.poll();
                bridgeQueue.offer(truck);
                currentWeight += truck;
            } else{
                bridgeQueue.offer(0);
            }
        }
        
        return answer;
    }
}