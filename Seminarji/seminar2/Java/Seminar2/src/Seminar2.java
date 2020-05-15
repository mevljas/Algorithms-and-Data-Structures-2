import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seminar2 {
    public static void main(String args[])
    {
        String file_name = args[0];

        try (Scanner in = new Scanner(new File(file_name))){
            int numberTestCases = Integer.parseInt(in.nextLine().stripTrailing());
            final int X = 1;
            final int Y = 0;

            for (int i = 1; i <= numberTestCases; i++) {
                List<Integer> list = new ArrayList<>();
                System.out.printf("Case %d:\n", i);
                int M = Integer.parseInt(in.nextLine().stripTrailing());
                StringBuilder piratesM = new StringBuilder();
                for (int j = 0; j < M; j++) {
                    int T = Integer.parseInt(in.nextLine().stripTrailing());
                    String piratesT = in.nextLine().stripTrailing().repeat(T);
                    piratesM.append(piratesT);
                }

                String[] integerStrings = piratesM.toString().split("");
                // Splits each spaced integer into a String array.
                for (int z = 0; z < integerStrings.length; z++){
                    list.add(Integer.parseInt(integerStrings[z]));
                }


                int Q = Integer.parseInt(in.nextLine().stripTrailing());
                int outputNum = 1;
                for (int j = 0; j < Q; j++) {
                    char c;
                    int a,b;
                    String tempArray[] = in.nextLine().stripTrailing().split(" ");
                    c = tempArray[0].charAt(0);
                    a = Integer.parseInt(tempArray[1]);
                    b = Integer.parseInt(tempArray[2]);


                    switch (c){
                        case 'F':
                            for (int k = a; k <= b ; k++) {
                                list.set(k, X);
                            }
                            break;
                        case 'E':
                            for (int k = a; k <= b ; k++) {
                                list.set(k, Y);
                            }
                            break;
                        case 'I':
                            for (int k = a; k <= b; k++) {
                                list.set(k, list.get(k) ^ 1);
                            }
                            break;
                        case 'S':
                            int sum = 0;
                            for (int k = a; k <= b ; k++) {
                                sum += list.get(k);
                            }
                            System.out.printf("Q%d: %d\n" , outputNum++, sum);
                            break;
                    }

                }


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
