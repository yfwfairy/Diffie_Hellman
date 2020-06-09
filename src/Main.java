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
		// ���ô�����С�ߴ�
		frame.setMinimumSize(new Dimension(900, 560));
		// �����˴��ڵĴ�С�����ʺ������������ѡ��С�Ͳ���
		frame.pack();
		// ���ô��������ָ�������λ��
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		// ���ô��ڳߴ��Ƿ�̶�����
		frame.setResizable(false);

	}
}
