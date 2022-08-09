package Matrix;

import java.util.ArrayList;
import java.util.List;

public class ParallelThreadsCreator {

    public static void multiply(int[][] matrix1, int[][] matrix2, int[][] result) {
        List threads = new ArrayList<>();
        int rows1 = matrix1.length;
        for (int i = 0; i < rows1; i++) {
            RowMultiplyWorker task = new RowMultiplyWorker(result, matrix1, matrix2, i);
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
            if (threads.size() % 10 == 0) {
                waitForThreads(threads);
            }
        }
    }

    private static void waitForThreads(List<Thread> threads) {

        for (int i=0;i<threads.size();i++)
            try {
            threads.get(i).join();
        }catch (InterruptedException e){
                e.printStackTrace();
            }
        threads.clear();
    }


}

