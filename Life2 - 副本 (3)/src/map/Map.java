package map;

import java.util.Random;

import cell.Cell;
import gui.GUI;

public class Map {
	//地图的规格
	public int xMax=100;//地图纵向最大方格数
	public int yMax=100;//地图横向最大方格数
	public int side=5;//边长
	//细胞丛
	public Cell[][] cell=new Cell[xMax][yMax];
	public Cell[][] cell1=new Cell[xMax][yMax];
	
	public Map() {
		initial();
	}

	public static void main(String[] args) {
		Map map=new Map();
		map.initial();
		GUI gui=new GUI();
		//cell1=new Cell[xMax][yMax];
		//map.cell1=map.cell;
		gui.start();
    }
    
	public void initial() {
		Random random=new Random();
		//cell=new Cell[xMax][yMax];
    	
    	for(int i=0;i<xMax;i++) {
    		for(int j=0;j<yMax;j++) {
    			cell[i][j]=new Cell(i,j);
    			cell[i][j].setLife((int)random.nextInt(2));
    		}
    	}
    }

	public int getLiving(Cell cell,boolean lastcondition[][]){
		int x=cell.getX(),y=cell.getY();
		int count=0;
		
		//一般情况
		if(x>=1&&x<xMax-1&&y>=1&&y<yMax-1) {
			for(int i=x-1;i<=x+1;i++)
				for(int j=y-1;j<=y+1;j++)
					if(lastcondition[i][j]==true)
						{count++;}
			if(this.cell[x][y].getDeath()==false)
				{return count;}
			else
				{return count-1;}
		}
		
		//顺时针讨论边界情况
		//在左上角
		else if(x==0&&y==0) {
			for(int i=0;i<=1;i++)
				for(int j=0;j<=1;j++)
					if(lastcondition[i][j]==true)
						{count++;}
			//if(cell.getDeath()==false)
			if(this.cell[x][y].getDeath()==false)
				{return count;}
			else
				{return  count-1;}
		}
			
		//在最上面一列
		else if(x==0&&y>=1&&y<yMax-1){
			for(int i=0;i<=1;i++)
				for(int j=y-1;j<=y+1;j++)
					if(lastcondition[i][j]==true)
					{	count++;}
			if(this.cell[x][y].getDeath()==false)
				{return count;}
			else
				{return count-1;}
		}
		
		//在右上角
		else if(x==0&&y==yMax-1) {
			for(int i=0;i<=1;i++)
				for(int j=yMax-2;j<=yMax-1;j++)
					if(lastcondition[i][j]==true)
						{count++;}
			if(this.cell[x][y].getDeath()==false)
				{return count;}
			else
				{return count-1;}
		}
		
		//在最右边
		else if(y==yMax-1&&x>=1&&x<xMax-1){
			for(int i=x-1;i<=x+1;i++)
				for(int j=yMax-2;j<=yMax-1;j++)
					if(lastcondition[i][j]==true)
						{count++;}
			if(this.cell[x][y].getDeath()==false)
			{	return count;}
			else
				{return count-1;}
		}
		
		//在右下角
		else if(x==xMax-1&&y==yMax-1) {
			for(int i=xMax-2;i<xMax;i++)
				for(int j=yMax-2;j<yMax;j++)
					if(lastcondition[i][j]==true)
					{	count++;}
			if(this.cell[x][y].getDeath()==false)
				{return count;}
			else
				{return count-1;}
		}
		
		//最下边
		else if(x==xMax-1&&y>=1&&y<xMax-1){
			for(int i=xMax-2;i<xMax;i++)
				for(int j=y-1;j<=y+1;j++)
					if(lastcondition[i][j]==true)
						{count++;}
			if(this.cell[x][y].getDeath()==false)
				{return count;}
			else
				{return count-1;}
		}
		
		//在左下角
		else if(x==xMax-1&&y==0) {
			for(int i=xMax-2;i<xMax;i++)
				for(int j=0;j<=1;j++)
					if(lastcondition[i][j]==true)
					{	count++;}
			if(this.cell[x][y].getDeath()==false)
				{return count;}
			else
				{return count-1;}
		}
		
		//在最左边一列
		//else if(y==0&&x>=1&&x<xMax-1){
		else {	
			for(int i=x-1;i<=x+1;i++)
				for(int j=0;j<=1;j++)
					if(lastcondition[i][j]==true)
						{count++;}
			if(this.cell[x][y].getDeath()==false)
				{return count;}
			else
				{return count-1;}
		}
		
	}
	
	//不使用initial()的构造函数
	public Map(int xMax,int yMax,int side){
		this.xMax=xMax;
		this.yMax=yMax;
		this.side=side;
	}
	
	public void setCells(){
    	for(int i=0;i<xMax;i++) {
    		for(int j=0;j<yMax;j++) {
    			cell[i][j]=new Cell(i,j);
    			cell[i][j].setLife(0);
    		}
    	}
	} 
}