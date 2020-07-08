package gui;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

import map.Map;

public class GUI extends Thread{ 
	JFrame jframe;
	JPanel jpanel;
	Map map;
	Graphics g;
	
	public GUI() {
		jframe=new JFrame();
		jpanel=new JPanel();
		map=new Map();
	}
	
	//չʾ��Ϸ����
	public void show(){
		//չʾ��Ϸ����
		int side=map.side;
		int length;
		int width;
		length=map.xMax*side;
		width=map.yMax*side;
		
		//����Ϸ���滭����
		jframe.setSize(length+100,width+100);
    	jpanel.setBounds(0,0,length,width);
    	jframe.setTitle("������Ϸ");
    	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jframe.setLocationRelativeTo(null);
    	jframe.add(jpanel);
    	jframe.setVisible(true);
    	g=jpanel.getGraphics();
    	
    	//��ʼ��ͼ
    	jframe.update(g);
    	for(int i=0;i<map.xMax;i++) {
    		for(int j=0;j<map.yMax;j++) {
    			g.drawRect(i*side, j*side, side, side);
    		}
    	}
    	for(int i=0;i<map.xMax;i++) {
    		for(int j=0;j<map.yMax;j++) {
    			if(map.cell[i][j].getDeath()==true) {
    				g.fillRect(j*side, i*side, side, side);
    			}
    			
    		}
    	}
	}
	
	public void run() {
		show();
		while (true) {
			try {
				sleep(1000);
				refresh();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}

	public void refresh() {
		int xMax = map.xMax;
		int yMax = map.yMax;		
		int side = map.side;
		boolean[][] lastcondition=new boolean [map.xMax][map.yMax];
			
	    //��¼��һ��ͼ�ڵ�ϸ��������
	    for(int i=0;i<xMax;i++) {
	    	 for(int j=0;j<yMax;j++) {
	    	    //map.cell1[i][j]=new Cell(i,j);
	    	    lastcondition[i][j]=map.cell[i][j].getDeath();
	    	    	//map.cell1[i][j].changeLife(map.cell[i][j].getDeath());
	    	 }
	    }
	    //�����¸�����Ĵ��״��
	    for(int i=0;i<xMax;i++) {
	    	for(int j=0;j<yMax;j++) {
	    	    map.cell[i][j].setSituation(map.getLiving(
	    	    	map.cell[i][j],lastcondition));
	    	}
	    }
	    jpanel.update(g);
	    //������
	    for(int i=0;i<xMax;i++) {
	    	for(int j=0;j<yMax;j++) {
	    	    g.drawRect(i*side, j*side, side, side);
	    	}
	    }
	    //��䷽�飬���ϸ��Ϊ��
		for(int i=0;i<map.xMax;i++) {
			for(int j=0;j<map.yMax;j++) {
				if(map.cell[i][j].getDeath()==true) {
    				g.fillRect(j*side, i*side, side, side);
    			}
			}
		}
	}
	
}