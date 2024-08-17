import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        int size = players.length;
        Map<String,Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < size ; i++){
            map.put(players[i],i);
        }
        
        for(String call : callings){
            int back = map.get(call);
            int front = map.get(players[back-1]);
            
            String tmp = players[front];
            players[front] = players[back];
            players[back] = tmp;
            
            map.put(players[front],front);
            map.put(players[back],back);
        }
        
        String[] answer = players;
        return answer;
    }
}