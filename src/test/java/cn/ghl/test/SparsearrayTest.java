package cn.ghl.test;

import cn.ghl.run.TestApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

@SpringBootTest(classes = TestApp.class)
public class SparsearrayTest {
    @Test
    public void sparsearrayTest() {
        int[][] chess = new int[11][11];
        chess[1][3] = 1;
        chess[2][4] = 2;
//        for (int i=0;i<chess.length;i++){
//            for (int j=0;j<chess[0].length;j++){
//                System.out.print(chess[i][j]+"\t");
//            }
//            System.out.println();
//        }
//        for (int[] row: chess) {
//            for (int col : row) {
//                System.out.printf("%d\t",col);
//            }
//            System.out.println();
//        }

        //将二维数组保存到磁盘
        try (//流的顺序
             //这样写读不到数据
                PrintWriter pw=new PrintWriter("D:\\MyApp\\temp\\a.txt");
                BufferedReader br = new BufferedReader(new FileReader("D:\\MyApp\\temp\\a.txt"));
        ) {
            for (int[] row :
                    chess) {
                for (int col :
                        row) {
                    pw.print(col+"\t");
                }
                pw.println();
            }
            int[][] chess2 = new int[11][11];
            String line;
            int rows = 0;
            while ((line = br.readLine()) != null) {
                String[] strings = line.split("\t");
                for (int i = 0; i < strings.length; i++) {
                    chess2[rows][i] = Integer.parseInt(strings[i]);
                }
                rows++;
            }

            for (int[] row : chess2) {
                for (int col : row) {
                    System.out.print(col + "\t");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


//        IOUtils.copy();
    }
}
