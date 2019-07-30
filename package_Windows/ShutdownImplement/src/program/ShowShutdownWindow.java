package program;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import command.ShutdownCommand;

public class ShowShutdownWindow extends JFrame {

	JFrame Recruit = new JFrame();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JButton jb1 = new JButton("管理プログラム終了");
	JTextField tf = new JTextField(10);
	JLabel label1 = new JLabel("サーバーの終了のためには下記のボタンを押してください。");
	JLabel label2 = new JLabel();

	private static final long serialVersionUID = 1L;

	public ShowShutdownWindow() {
		panel1.add(label1);

		jb1.addActionListener(new Listner());
		panel2.add(jb1);
		panel3.add(label2);

		Recruit.getContentPane().add(BorderLayout.NORTH, panel1);
		Recruit.getContentPane().add(BorderLayout.CENTER, panel2);
		Recruit.getContentPane().add(BorderLayout.SOUTH, panel3);

		Recruit.setTitle("管理プログラム終了");
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

		private ShutdownCommand shutdownCommand;

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			String dir = ShutdownCommand.setDir(System.getProperty("user.dir"));
			System.out.println(dir);

			String[] command = {"cmd", "/c" , dir + "shutdownCommand.bat" };

			try {
				shutdownCommand.main(command);
				label2.setText("サーバー終了しました。");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}