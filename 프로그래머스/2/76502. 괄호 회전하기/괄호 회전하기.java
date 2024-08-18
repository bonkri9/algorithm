import java.util.Stack;

public class Solution {
    static public int solution(String s) {
        int sLen = s.length();
        int cnt = 0;

        // 여는 괄호를 넣고, 재사용할 stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < sLen; i++) {
            boolean isValid = true;
            stack.clear();  // 스택 초기화

            for (int j = 0; j < sLen; j++) {
                char c = s.charAt((i + j) % sLen);  // 동적 회전
                
                // 여는 괄호 삽입
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {  // else 내부는 닫는 괄호일 때의 처리 
                    
                    // stack이 비어있다면, 여는 괄호가 하나도 없고
                    // 닫는 괄호가 나온 상태이므로 올바르지 않음 
                    if (stack.isEmpty()) {
                        isValid = false;
                        break; 
                    }
                    
                    // (). {}. [] 일 경우는 알아서 pop이 되고, 
                    // 아닐 경우에만 조건문 처리
                    // 아닐 경우에, 올바르지 않은 문자열이므로 break
                    char top = stack.pop();
                    if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                        isValid = false;
                        break;
                    }
                }
            }
            
            // 올바른 괄호 문자열이고, 남는 여는 괄호가 없으면 
            if (isValid && stack.isEmpty()) {
                cnt++;
            }
        }

        return cnt;
    }
}
