package map;

import java.util.Random;

import cell.Cell;
import gui.GUI;

public class Map {

	//��ͼ�Ĺ��
	 public  int xMax=5;

	 public  int yMax=5;
	
	//ϸ����
	public Cell[][] cell;
	
	public Map() {
		initial();
	}

	public static void main(String[] args) {
		Map map=new Map();
		map.initial();
		GUI gui=new GUI();
		gui.show();
		
      }
    
	
	public void initial() {
		Random random=new Random();
		cell=new Cell[xMax][yMax];
    	
    	for(int i=0;i<xMax;i++) {
    		for(int j=0;j<yMax;j++) {
    			cell[i][j]=new Cell(i,j);
    			cell[i][j].setLife((int)random.nextInt(2));
    			//cell[i][j].setStatus(1);
    		}
    	}
    }

	public int getLiving(Cell cell){
		int x=cell.getX(),y=cell.getY();
		int count=0;
		
		//һ�����
		if(x>=1&&x<xMax-1&&y>=1&&y<yMax-1) {
			for(int i=x-1;i<=x+1;i++)
				for(int j=y-1;j<y+1;j++)
					if(this.cell[i][j].getDeath()==false)
						count++;
			if(cell.getDeath()==true)
				return count;
			else
				return count-1;
		}
		
		//˳ʱ�����۱߽����
		//�����Ͻ�
		else if(x==0&&y==0) {
			for(int i=0;i<=1;i++)
				for(int j=0;j<=1;j++)
					if(this.cell[i][j].getDeath()==false)
						count++;
			if(cell.getDeath()==true)
				return count;
			else
				return count-1;
		}
			
		//��������һ��
		else if(x==0&&y>=1&&y<yMax-1){
			for(int i=0;i<=1;i++)
				for(int j=y-1;j<=y+1;j++)
					if(this.cell[i][j].getDeath()==false)
						count++;
			if(cell.getDeath()==true)
				return count;
			else
				return count-1;
		}
		
		//�����Ͻ�
		else if(x==0&&y==yMax-1) {
			for(int i=x;i<=x+1;i++)
				for(int j=y-1;j<=y;j++)
					if(this.cell[i][j].getDeath()==false)
						count++;
			if(cell.getDeath()==true)
				return count;
			else
				return count-1;
		}
		
		//�����ұ�
		else if(y==yMax-1&&x>=1&&x<xMax-1){
			for(int i=x-1;i<=x+1;i++)
				for(int j=yMax-1;y<=yMax;y++)
					if(this.cell[i][j].getDeath()==false)
						count++;
			if(cell.getDeath()==true)
				return count;
			else
				return count-1;
		}
		
		//�����½�
		else if(x==xMax-1&&y==yMax-1) {
			for(int i=xMax-2;i<xMax;i++)
				for(int j=yMax-2;j<yMax;j++)
					if(this.cell[i][j].getDeath()==false)
						count++;
			if(cell.getDeath()==true)
				return count;
			else
				return count-1;
		}
		
		//���±�
		else if(x==xMax-1&&y>=1&&y<xMax-1){
			for(int i=xMax-2;i<xMax;i++)
				for(int j=y-1;j<=y+1;j++)
					if(this.cell[i][j].getDeath()==false)
						count++;
			if(cell.getDeath()==true)
				return count;
			else
				return count-1;
		}
		
		//�����½�
		else if(x==xMax-1&&y==0) {
			for(int i=xMax-2;i<xMax;i++)
				for(int j=0;j<=1;j++)
					if(this.cell[i][j].getDeath()==false)
						count++;
			if(cell.getDeath()==true)
				return count;
			else
				return count-1;
		}
		
		//�������һ��
		else if(y==0&&x>=1&&x<xMax-1){
			for(int i=x-1;i<=x+1;i++)
				for(int j=0;j<=1;j++)
					if(this.cell[i][j].getDeath()==false)
						count++;
			if(cell.getDeath()==true)
				return count;
			else
				return count-1;
		}
		return count-1;
	}
}