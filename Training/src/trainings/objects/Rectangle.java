package trainings.objects;

public class Rectangle {
	
	public int x1,y1,x2,y2;
	
	public Rectangle (int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	public Rectangle (int w, int h) {
		this.x1 = this.y1 = 0;
		this.x2 = w;
		this.y2 = h;
	}

	public void move (int dx, int dy) {
		this.x1+=dx;
		this.x2+=dx;
		this.y1+=dy;
		this.y2+=dy;
	}
	
	public String toString () {
		return "["+this.x1+","+this.y1+","+this.x2+","+this.y2+"]";
	}
}
