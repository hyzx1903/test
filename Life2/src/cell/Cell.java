package cell;

public class Cell {

	//ϸ������
	boolean ifDead;
	//��Χ��ϸ����
	int cellsSurround;
	//λ��
	int x,y;
	int a =1;
	int b=2;
	public Cell(int x,int y) {
		this.x=x;
		this.y=y;
	}

	public void setLife(int ranNum) {//��ֵ ��ʼ״̬ �������ɵ�ϸ����Ŀ
		if(ranNum==0)
			this.ifDead=false;//����
		else
			this.ifDead=true;//���
	}

//	public static void main(String[] args) {

//	}
	public void changeLife(boolean n) {
			this.ifDead=n;
	}
	
	public void setSurround(int surround) {
		this.cellsSurround=surround;
	}
	
	public int getX() {//x����
		return x;
	}	
	
	public int getY() {//y����
		return y;
	}	

	public boolean getDeath() {
		return ifDead;
	}
	
	public void setSituation(int n) {//���ݴ��ϸ����Ŀ������ϸ�����״̬
		if(n==3) {
			this.ifDead=true;//��
		}
		else if(n<=1||n>3){
			this.ifDead=false;//����
		}

	}
	public int geta() {//x����
		return a;
	}
	public int getb() {//x����
		return b;
	}
}