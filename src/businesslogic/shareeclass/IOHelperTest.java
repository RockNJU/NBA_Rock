package businesslogic.shareeclass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class IOHelperTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testReadFile() {
		IOHelper io=new IOHelper();
		io.readFile("mavo.obj");
	 
	}

	@Test
	public void testWriteFile() {
	/*	IOHelper io=new IOHelper();
		MatchController m=new MatchController();
		ArrayList<MatchVO> list=new ArrayList<>();
		list=m.getAllMatchVO();
		//io.writeFile("matchvo.obj", list);*/
		
		fail("Not yet implemented");
	}

}
