package cn.ghl.othertest.halo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@SpringBootTest
public class ScheduledTest {

    @Test
    public void scheduledTest(){
//        Options
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(10);
    }
}
class Myscheduled implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
