package miniTesty.p8;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaAsyncTask {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    private boolean result;

    public void runTask() {
        executorService.submit(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            System.out.println("Wydrukowanie po 0.5s");
            result = true;
        });
    }

    public boolean getResult() {
        return result;
    }
}
