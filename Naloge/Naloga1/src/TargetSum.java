import java.util.*;

public class TargetSum {
    public static int smallestSubListWithTargetSum(List<Integer> A, int S) {

        Deque<Integer> window = new ArrayDeque<>(A);
		int tempValue;
        int sum = 0;
        int NumOfItems = A.size();
        int minSublistLength = A.size() + 1;
        int currentIndex = 0;

        while (currentIndex < NumOfItems) {

            while (sum < S && currentIndex < NumOfItems) {

//				take care of negative numbers
                if (S > 0 && sum <= 0) {
                    sum = 0;
                    window.clear();
                }

                sum += tempValue = A.get(currentIndex++);
                window.addLast(tempValue);
            }

//			shorten the list
            while (sum >= S) {

                if (window.size() < minSublistLength) {
                    minSublistLength = window.size();
                }

                sum -= window.removeFirst();
            }
        }
        return (minSublistLength != A.size() + 1) ? minSublistLength : -1;


    }

    public static void main(String[] args) {
        List<Integer> testCase1 = List.of(1, 4, 45, 6, 10, 19);
        int S1 = 51;
        int minLen1 = smallestSubListWithTargetSum(testCase1, S1);
        System.out.println(minLen1);

        List<Integer> testCase2 = List.of(1, 10, 5, 2, 7);
        int S2 = 9;
        int minLen2 = smallestSubListWithTargetSum(testCase2, S2);
        System.out.println(minLen2);

        List<Integer> testCase3 = List.of(1, 11, 100, 1, 0, 200, 3, 2, 1, 250);
        int S3 = 280;
        int minLen3 = smallestSubListWithTargetSum(testCase3, S3);
        System.out.println(minLen3);

        TestData td1 = TestCases.case1();
        int minLen4 = smallestSubListWithTargetSum(td1.getNumbers(), td1.getS());
        System.out.println(minLen4);

        TestData td2 = TestCases.case2();
        int minLen5 = smallestSubListWithTargetSum(td2.getNumbers(), td2.getS());
        System.out.println(minLen5);

        TestData td3 = TestCases.case3();
        int minLen6 = smallestSubListWithTargetSum(td3.getNumbers(), td3.getS());
        System.out.println(minLen6);

        TestData td4 = TestCases.case4();
        int minLen7 = smallestSubListWithTargetSum(td4.getNumbers(), td4.getS());
        System.out.println(minLen7);

    }
}
