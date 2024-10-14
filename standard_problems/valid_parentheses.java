import java.util.*;
class  Solution{
    public boolean combo(char a, char b){
        return ((a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']'));
    }
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char cur = str.charAt(i);
            if(cur == '(' || cur == '{' || cur == '['){
                s.push(cur);
            }
            else{
                if(!s.isEmpty()){
                    char top = s.peek();
                    if(combo(top, cur)){
                        s.pop();
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        return s.isEmpty();
    }
}