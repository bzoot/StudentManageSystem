package studentManageSystemTest;

import ui.Login;
import ui.SystemFrame;

/** 
 * @author  Mualim
 * @date ����ʱ�䣺2017-3-20 ����12:31:57 
 * @version 1.0 
 * @parameter  
 * @return  
 */
public class Test {

	public static void main(String[] args) {
		SystemFrame systemFrame = new SystemFrame();
		systemFrame.add(new Login(systemFrame));
		systemFrame.revalidate();
		systemFrame.repaint();
	}
	
}
