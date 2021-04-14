import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaCallback{

    static void process(List<Integer> dataList, CallbackInterface callback){
        /* 문제 */
        int result = 0;
        for (Integer integer : dataList) {
            result += integer;
        }
        callback.printResult(result);
    }

    public static void main(String[] args) {
        
        List<Integer> dataList = Stream.of(3,5,7,1,9,4).collect(Collectors.toList());

        System.out.println(dataList);
        System.out.println("요청 시작");

        CallbackInterface callback = new CallbackInterface(){
            @Override
            public void printResult(int result) {
                // TODO Auto-generated method stub
                System.out.println(result);
            }

        };

        process(dataList, callback);

        System.out.println("요청 종료");
    }

    interface CallbackInterface{
        void printResult(int result);
    }
}


// 자바의 callback : 피호출자가 호출자를 호출하는 것.

/*
 자바스크립트 같은 경우는 아예 매개변수에 함수 포인터를 넣어서 호출할 수 있다고 하지만 자바에는 그런 기능이 없습니다. 따라서 직접 작성해줘야 합니다.
 "현재 실행되고 있는 인스턴스 안에 존재하는 함수의 전달 및 실행"
 https://codevang.tistory.com/187
*/