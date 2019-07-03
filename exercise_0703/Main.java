package exercise.exercise_0703;

/*
数字之和
 */
/*
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            System.out.println(helper(n)+" "+helper(n*n));
        }
    }
    public static int helper(int n) {
        int sum = 0;
        while(n!=0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}*/

/*
计票统计
 */
/*
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            List<String> listKey = new ArrayList<>();
            List<Integer> listValue = new ArrayList<>();
            int n = in.nextInt();
            for(int i=0; i<n; i++){
                listKey.add(in.next());
                listValue.add(0);
            }
            int n2 = in.nextInt();
            int count = 0;
            for(int i=0; i<n2; i++){
                String vName = in.next();
                int index = listKey.indexOf(vName);
                if(index != -1){
                    listValue.set(index,listValue.get(index)+1);
                }else{
                    count++;
                }
            }
            for(int i=0; i<listValue.size(); i++){
                System.out.println(listKey.get(i)+" : "+listValue.get(i));
            }
            System.out.println("Invalid : "+count);
        }
    }
}*/

/*
找x
 */
/*
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                list.add(in.nextInt());
            }
            System.out.println(list.indexOf(in.nextInt()));
        }
    }
}
*/

/*
整数与IP地址间的转换
 */
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            if(str.contains(".")){
                System.out.println(ipToInteger(str));
            }else{
                System.out.println(integerToIp(str));
            }
        }
    }
    public static String ipToInteger(String str) {
        String[] strs = str.split("\\.");
        String s = "";
        //将十进制数转为二进制数并拼接
        for(int i=0; i<strs.length; i++){
            String tmp = new BigInteger(strs[i],10).toString(2);;
            for(int j=tmp.length();j<8;j++){
                tmp = "0"+tmp;
            }
            s +=  tmp;
        }
        return new BigInteger(s,2).toString(10);
    }
    public static String integerToIp(String str) {
        String s = Long.toBinaryString(Long.parseLong(str));
        String result = "";
        int i=s.length();
        for(; i-8>=0; i-=8){
            result = new BigInteger(s.substring(i-8,i),2).toString(10) + result;
            if(i-8 > 0){
                result = "." + result;
            }
        }
        if(i!=0){
            result = new BigInteger(s.substring(0,i),2).toString(10) + result;
        }
        return result;
    }
}