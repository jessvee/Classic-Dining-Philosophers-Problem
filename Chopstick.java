
public class Chopstick {
	private int ChopNo;
	private boolean isHeld;
	
	public Chopstick(int number){
		this.ChopNo = number;
		this.isHeld = false;
	}
	public boolean getIsHeld(){
		return isHeld;
	}
	public void setIsHeld(boolean status){
		this.isHeld = status;
	}
	public int getChopNo(){
		return this.ChopNo;
	}
}
