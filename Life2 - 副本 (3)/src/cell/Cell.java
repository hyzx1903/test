package cell;

public class Cell {

	//细胞属性
	boolean ifDead;
	//周围的细胞数
	int cellsSurround;
	//位置
	int x,y;
	int a =1;
	int b=2;
	public Cell(int x,int y) {
		this.x=x;
		this.y=y;
	}

	public void setLife(int ranNum) {//赋值 初始状态 根据生成的细胞数目
		if(ranNum==0)
			this.ifDead=false;//死亡
		else
			this.ifDead=true;//存活
	}

//	public static void main(String[] args) {

//	}
	public void changeLife(boolean n) {
			this.ifDead=n;
	}
	
	public void setSurround(int surround) {
		this.cellsSurround=surround;
	}
	
	public int getX() {//x坐标
		return x;
	}	
	
	public int getY() {//y坐标
		return y;
	}	

	public boolean getDeath() {
		return ifDead;
	}
	
	public void setSituation(int n) {//根据存活细胞数目，更改细胞存活状态
		if(n==3) {
			this.ifDead=true;//活
		}
		else if(n<=1||n>3){
			this.ifDead=false;//死亡
		}

	}
	public int geta() {//x坐标
		return a;
	}
	public int getb() {//x坐标
		return b;
	}
}