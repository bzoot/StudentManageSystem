package studentManageSystemTest;

import ui.Login;
import ui.SystemFrame;

/** 
 * @author  Mualim
 * @date 创建时间：2017-3-20 下午12:31:57 
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
