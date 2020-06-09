import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("DH");
		UI panelUi = new UI();
		frame.add(panelUi);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(BorderLayout.CENTER, panelUi);
		// 设置窗口最小尺寸
		frame.setMinimumSize(new Dimension(900, 560));
		// 调整此窗口的大小，以适合其子组件的首选大小和布局
		frame.pack();
		// 设置窗口相对于指定组件的位置
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		// 设置窗口尺寸是否固定不变
		frame.setResizable(false);

	}
}
