package cn.ghl.test;

import cn.ghl.run.TestApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest(classes = TestApp.class)
public class SparsearrayTest {
    @Test
    public void sparsearrayTest(){
        int[][] chess=new int[11][11];
        chess[1][3]=1;
        chess[2][4]=2;
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
        FileWriter writer=null;
        FileReader reader=null;
        try {
            writer= new FileWriter("D:\\MyApp\\temp\\a.txt");
            for (int[] row: chess) {
                for (int col : row) {
                    writer.write(col+"\t");
                }
                writer.write("\r\n");
            }
            reader=new FileReader("D:\\MyApp\\temp\\a.txt");
            BufferedReader buff = new BufferedReader(reader);
            String temp;
            while ((temp=buff.readLine())!=null){
                System.out.println(temp+"---------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


//        IOUtils.copy();
    }
}
