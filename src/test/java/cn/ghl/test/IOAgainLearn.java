package cn.ghl.test;

import cn.ghl.run.TestApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest(classes = TestApp.class)
public class IOAgainLearn {
    @Test
    public void ioFirstTest() {
        InputStream is = null;
        try {
            is = new FileInputStream("D:\\MyApp\\temp\\b.txt");
            int s1 = is.read();
            int s2 = is.read();
            int s3 = is.read();
            int s4 = is.read();
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);
            System.out.println(s4);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void ioImproveTest() {
        /**
         * 成员变量可不赋初值，若不赋初值则JAVA会按为其添加默认值；
         * 方法里定义的局部变量，在参与运算之前必须赋初值.
         *
         *
         * 局部变量可以先声明不初始化，但是必须在进行操作（类似打印，运算这样的操作）前赋值
         * 否则报错
         */
        try (InputStream is = new FileInputStream("D:\\MyApp\\temp\\b.txt")) {
            int temp;
//            System.out.println(temp); Variable 'temp' might not have been initialized
            StringBuffer sb = new StringBuffer();
            while ((temp = is.read()) != -1) {
                System.out.println(temp);
                sb.append((char) temp);
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ioFileInputAndOutputTest() {
        try (
                InputStream is = new FileInputStream("D:\\MyApp\\temp\\b.txt");
                OutputStream os = new FileOutputStream("D:/MyApp/temp/c.txt");) {
            int temp;
            while ((temp = is.read()) != -1) {
                os.write(temp);
            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ioFileInputBuffertTest() {
        try (
                InputStream is = new FileInputStream("D:\\MyApp\\temp\\b.txt");
                OutputStream os = new FileOutputStream("D:/MyApp/temp/c.txt");) {
            int temp;
            byte[] buff = new byte[1024];
            while ((temp = is.read(buff)) != -1) {
                os.write(buff, 0, temp);
            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ioFileInputBuffert2Test() {
        try (
                InputStream is = new FileInputStream("D:\\MyApp\\temp\\b.txt");
                OutputStream os = new FileOutputStream("D:/MyApp/temp/c.txt");) {
            byte[] buff = new byte[is.available()];
            is.read(buff);
            os.write(buff);
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ioBufferStreamTest() {
        try (
                InputStream is = new FileInputStream("D:\\MyApp\\temp\\b.txt");
                OutputStream os = new FileOutputStream("D:/MyApp/temp/c.txt");
                BufferedInputStream bis = new BufferedInputStream(is);
                BufferedOutputStream bos = new BufferedOutputStream(os);) {
            int temp = 0;
            while ((temp = bis.read()) != -1) {
                bos.write(temp);
            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileReaderTest() {
        try (FileReader reader = new FileReader("D:\\MyApp\\temp\\b.txt")) {
            int temp;
            while ((temp = reader.read()) != -1) {
                System.out.println((char) temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileWriterTest() {
        try (FileWriter writer = new FileWriter("D:\\MyApp\\temp\\b.txt");
             FileWriter writer2 = new FileWriter("D:\\MyApp\\temp\\b.txt", true)) {
            writer.write("你好ghl\r\n");
            writer.write("你是真的牛");
            writer.flush();

            writer2.write("666666666666666666666666666666666666666666");
            writer2.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileWriterAndReaderTest() {
        try (
                FileReader reader = new FileReader("D:\\MyApp\\temp\\b.txt");
                FileWriter writer = new FileWriter("D:\\MyApp\\temp\\bb.txt")) {
            int temp = 0;
            char[] buff = new char[1024];
            while ((temp = reader.read(buff)) != -1) {
                writer.write(buff, 0, temp);
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileWriterAndReaderBufferTest() {
        try (
                FileReader reader = new FileReader("D:\\MyApp\\temp\\b.txt");
                FileWriter writer = new FileWriter("D:\\MyApp\\temp\\bb.txt");
                BufferedReader br = new BufferedReader(reader);
                BufferedWriter bw = new BufferedWriter(writer)) {
            String temp;
            while ((temp = br.readLine()) != null) {
                System.out.println(temp);
                bw.write(temp);
                bw.newLine();
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void convertStream() {
        try (InputStream input = System.in;) {
            int temp;
            while ((temp = input.read()) != -1) {
                System.out.print((char) temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void printWriterTest() {
        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(new FileInputStream("D:\\MyApp\\temp\\b.txt")));
                PrintWriter pw = new PrintWriter("D:\\MyApp\\temp\\c.txt")
        ) {
            String temp;
            int i = 1;
            while ((temp = bufferedReader.readLine()) != null) {
                pw.println(i + "." + temp);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ByteArrayInputTest() {
        byte[] bytes = "abcdefg".getBytes();
        try (
                ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ) {
            int temp;
            while ((temp = bis.read()) != -1) {
                System.out.println((char) temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ByteArrayOutputTest() {
        try (
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ) {
            bos.write('a');
            bos.write('b');
            bos.write('c');
            byte[] byteArray = bos.toByteArray();
            for (int item :
                    byteArray) {
                System.out.println((char) item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void DataInputTest() {
        try (//注意逻辑
             DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
                     new FileOutputStream("D:\\MyApp\\temp\\d.txt")
             ));
             DataInputStream dis = new DataInputStream(new BufferedInputStream(
                     new FileInputStream("D:\\MyApp\\temp\\d.txt")
             ))
        ) {
            dos.writeInt(0);
            dos.writeChar('a');
            dos.writeUTF("utf");
            dos.flush();
            System.out.println(dis.readInt());
            System.out.println(dis.readChar());
            System.out.println(dis.readUTF());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ObjectInputTest() {//要分开
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(
                        new FileOutputStream("D:\\MyApp\\temp\\e.txt")));
                ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(
                        new FileInputStream("D:\\MyApp\\temp\\e.txt")));
        ) {
            oos.writeInt(11);
            oos.writeChar('b');
            oos.writeUTF("utf8");
            oos.flush();
            System.out.println(ois.readInt());
            System.out.println(ois.readChar());
            System.out.println(ois.readUTF());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ObjectInputObjTest() {
        try (
                ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(
                        new FileInputStream("D:\\MyApp\\temp\\e.txt")));
        ) {
            Dog dog = (Dog) ois.readObject();
            System.out.println(dog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ObjectOutputObjTest() {
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(
                        new FileOutputStream("D:\\MyApp\\temp\\e.txt")));
        ) {
            oos.writeObject(new Dog("shaguo", "红色"));
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        try(InputStream input=System.in;){
//            int temp;
//            while ((temp=input.read())!=-1){
//                System.out.print((char) temp);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        try (InputStream input = System.in;
             BufferedReader br = new BufferedReader(new InputStreamReader(input));
             OutputStream output = System.out;
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(output))) {
            while (true) {
                bw.write("请输入：");
                bw.flush();
                String line = br.readLine();
                if ("exit".equals(line)) {
                    break;
                }
                bw.write("你输入的是：" + line);
                bw.newLine();
                bw.flush();
//                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Dog implements Serializable {
    private final String name;
    private final String color;

    public Dog(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}