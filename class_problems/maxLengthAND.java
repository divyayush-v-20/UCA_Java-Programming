// find the longest sequence with AND >= 1
// leetcode 2275
public class maxLengthAND{
    public int solve(int arr[]){
        int res = 0;
        for(int i = 0; i < 32; i++){
            int cur_cnt = 0;
            for(int j = 0; j < arr.length; j++){
                if((arr[j] & (1 << i)) != 0){
                    ++cur_cnt;
                }
            }
            res = Math.max(res, cur_cnt);
        }
        return res;
    }
    public static void main(String[] args){
        int a1[] = {16, 17, 71, 62, 12, 24, 14};
        int a2[] = {8, 8};

        maxLengthAND obj = new maxLengthAND();

        System.out.println(obj.solve(a1));
        System.out.println(obj.solve(a2));
    }
}
