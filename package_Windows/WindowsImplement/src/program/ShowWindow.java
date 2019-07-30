package program;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import command.WindowsCommand;

public class ShowWindow extends JFrame {

	JFrame Recruit = new JFrame();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JButton jb1 = new JButton("実行");
	JTextField tf = new JTextField(10);
	JLabel label1 = new JLabel("DBサーバーのIPを入力してください。その後、10~20秒後にブラウザを開いてください。");
	JLabel label2 = new JLabel();

	private static final long serialVersionUID = 1L;

	public ShowWindow() {
		panel1.add(label1);

		jb1.addActionListener(new Listner());
		panel2.add(tf);
		panel2.add(jb1);
		panel3.add(label2);

		Recruit.getContentPane().add(BorderLayout.NORTH, panel1);
		Recruit.getContentPane().add(BorderLayout.CENTER, panel2);
		Recruit.getContentPane().add(BorderLayout.SOUTH, panel3);

		Recruit.setTitle("管理プログラム");
		Recruit.setSize(550, 110);
		Recruit.setResizable(false);
		Recruit.setLocationRelativeTo(null);
		Recruit.setVisible(true);
		Recruit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		if (label2.getText().equals("서버를 실행중입니다.")) {
//			
//		}
	}

	class Listner implements ActionListener {

		private WindowsCommand windowsCommand;

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			String ipAddr = tf.getText();
			String[] ipAddrBox = {ipAddr};

			if (actionEvent.getSource() == jb1) {

				Pattern pattern = Pattern.compile(
						"^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
				Matcher matcher = pattern.matcher(ipAddrBox[0]);

				if (matcher.find() || ipAddrBox[0].equals("localhost")) {
//					label2.setText("서버를 실행중입니다. 10초 정도 후에 브라우저에서 관리 프로그램을 실행해 주세요.");
					try {
						windowsCommand.main(ipAddrBox);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					label2.setText("IPの正しい形式を入力してください。");
				}
			}
		}
	}

}
