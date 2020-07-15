import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Seminar2 {
    public static void main(String args[]) {
        String file_name = args[0];
        PrintWriter out;
        int numberTestCases;
        int M;
        int T;
        String[] piratesT;
        int n;
        boolean[] pirates;
        int idx;
        int Q;
        int outputNum;
        char c;
        int a, b;
        int sum;

        try (Scanner in = new Scanner(new File(file_name))) {
            out = new PrintWriter(file_name.replace("IN", "OUT"));

            numberTestCases = in.nextInt();

            for (int i = 1; i <= numberTestCases; i++) {
                out.printf("Case %s:\n", i);
                M = in.nextInt();
                piratesT = new String[M];
                n = 0;

                for (int j = 0; j < M; j++) {
                    T = in.nextInt();
                    piratesT[j] = in.next().repeat(T);
                    n += piratesT[j].length();
                }

                pirates = new boolean[n];
                idx = 0;

                for (String element : piratesT) {
                    for (int j = 0; j < element.length(); j++) {
                        pirates[idx++] = element.charAt(j) == '1';
                    }
                }

                Q = in.nextInt();
                outputNum = 1;

                for (int j = 0; j < Q; j++) {
                    c = in.next().charAt(0);
                    a = in.nextInt();
                    b = in.nextInt();

                    switch (c) {
                        case 'F':
                            for (int k = a; k <= b; k++) {
                                pirates[k] = true;
                            }
                            break;

                        case 'E':
                            for (int k = a; k <= b; k++) {
                                pirates[k] = false;
                            }
                            break;

                        case 'I':
                            for (int k = a; k <= b; k++) {
                                pirates[k] = !pirates[k];
                            }
                            break;

                        case 'S':
                            sum = 0;
                            for (int k = a; k <= b; k++) {
                                sum += pirates[k] ? 1 : 0;
                            }
                            out.printf("Q%d: %s\n", outputNum++, sum);
                    }
                }
            }

            in.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
