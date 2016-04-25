import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;

public class ThinkingDinnerDriver {

	public static void main(String[] args) {
		Philosopher phil1 = new Philosopher(1);
		Philosopher phil2 = new Philosopher(2);
		Philosopher phil3 = new Philosopher(3);
		Philosopher phil4 = new Philosopher(4);
		Philosopher phil5 = new Philosopher(5);
		
		ExecutorService ex = Executors.newCachedThreadPool();
		
		ex.execute(phil1);
		ex.execute(phil2);
		ex.execute(phil3);
		ex.execute(phil4);
		ex.execute(phil5);
		
		ex.shutdown();
		
		try{
			boolean finished = ex.awaitTermination(1, TimeUnit.MINUTES);
			if (finished)
				System.out.println("Dinner is done.");
			else
				System.out.println("Too much thinking and not enough eating: Processes Timed Out.");
		}
		catch(InterruptedException ie){
			System.out.println("Program was interrupted.");
		}
		
	}

}
