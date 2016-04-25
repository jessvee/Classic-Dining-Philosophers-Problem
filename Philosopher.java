import java.util.Random;

public class Philosopher implements Runnable{
	//philosopher attributes:
	private int philNo;
	private boolean isHungry = true;
	private int numBites = 0;
	
	//Chopsticks local to philosopher:
	private Chopstick RightChopstick = new Chopstick(philNo);
	private Chopstick LeftChopstick = new Chopstick(philNo++);
	
	//random number for sleep interval duration
	private Random GenRando = new Random();
	
	public Philosopher(int number){
		this.philNo = number;
	}
	public void eat() throws InterruptedException{
		System.out.printf("Philosopher %d is eating bite number %d...%n", philNo, ++numBites);
		this.isHungry = false;
		
		Thread.sleep(GenRando.nextInt(5000));
	}
	public void think () throws InterruptedException{
		System.out.printf("Philosopher %d is thinking...%n", philNo);
		
		Thread.sleep(GenRando.nextInt(5000));
		
	}
	public synchronized boolean hasGrabbedBothChopsticks(){
		if(!LeftChopstick.getIsHeld() && !RightChopstick.getIsHeld()){
			LeftChopstick.setIsHeld(true);
			RightChopstick.setIsHeld(true);
			return true;
		}
		else return false;
	}
	@Override
	public void run() {
		try {
			think();
			if(hasGrabbedBothChopsticks() && isHungry)
				System.out.printf("Philosopher %d has the chopsticks...%n", philNo);
				eat();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}

}
