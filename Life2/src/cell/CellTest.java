package cell;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CellTest {

	private static Cell cell=new Cell(0,0);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetLife() {
		cell.setLife(0);
		assertEquals(false,cell.getDeath());
		cell.setLife(1);
		assertEquals(true,cell.getDeath());
	}

	@Test
	public void testSetSituation() {
		boolean lastTime;
		//ʹϸ�������
		cell.setSituation(3);
		assertEquals(true,cell.getDeath());
		//ϸ��״�����ֲ���
		lastTime=cell.getDeath();
		cell.setSituation(2);
		assertEquals(lastTime,cell.getDeath());
		//ʹϸ������
		cell.setSituation(4);
		assertEquals(false,cell.getDeath());
		cell.setSituation(1);
		assertEquals(false,cell.getDeath());
		cell.setSituation(0);
		assertEquals(false,cell.getDeath());
		//ϸ��״�����ֲ���
		lastTime=cell.getDeath();
		cell.setSituation(2);
		assertEquals(lastTime,cell.getDeath());
	}

}
