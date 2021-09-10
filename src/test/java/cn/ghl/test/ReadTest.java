package cn.ghl.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class ReadTest {

    @Test
    public void dateTest() {
        Date start = new Date();
        Date end = new Date();
        end.setYear(78);
        System.out.println("start = " + start);
        System.out.println("end = " + end);
        System.out.println(new Date(0));

        System.out.println("start.compareTo(end) = " + start.compareTo(end));
        System.out.println("start.getTime() = " + start.getTime());
    }

    @Test
    public void periodTest() {
        Date start = new Date();
        Date end = new Date();
        Period period = new Period(start, end);
        end.setYear(78);
        System.out.println("period.getEnd() = " + period.getEnd());
    }

    @Test
    public void arrayTest() {
//        int[] arr=new int[]{1,3,6};
        String str = "A";
        String a = "a";
        System.out.println("str.equalsIgnoreCase(a) = " + str.equalsIgnoreCase(a));
    }

}

final class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + "after" + end);
        }
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}