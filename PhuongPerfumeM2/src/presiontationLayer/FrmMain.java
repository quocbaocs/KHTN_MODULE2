
package presiontationLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class FrmMain extends JFrame {

	private static final long serialVersionUID = 1L;
	JDesktopPane desktopPane;
	private JButton btnLogout;
	private JLabel lblName;
	private JMenuItem mntmNewMenuItem;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMain frame = new FrmMain();
					frame.setSize(1500, 15000);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMain() {
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Perfume Shop");
		setBounds(100, 100, 577, 491);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		desktopPane = new JDesktopPane() {
			ImageIcon icon = new ImageIcon("src/images/background.png");
			Image image = icon.getImage();

			Image newimage = image.getScaledInstance(1000, 1000, Image.SCALE_SMOOTH);

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(newimage, 0, 0, this);
			}
		};

		JMenu mnNewMenu = new JMenu("Hệ thống");
		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("Giới thiệu");
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Thoát ra");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JMenuItem mntmngNhp = new JMenuItem("Đăng nhập");
		mntmngNhp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmDangNhap fdn = new FrmDangNhap();
				fdn.setVisible(true);
			}
		});
		mnNewMenu.add(mntmngNhp);
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenu mnSnPhm = new JMenu("Sản phẩm");
		menuBar.add(mnSnPhm);

		JMenuItem mntmThngHiu = new JMenuItem("Thương hiệu");
		mnSnPhm.add(mntmThngHiu);

		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Loại");
		mnSnPhm.add(mntmNewMenuItem_1_1);

		JMenu mnNewMenu_1 = new JMenu("Sản phẩm");
		mnSnPhm.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Thêm mới");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmThemSanPham ftsp = new FrmThemSanPham();
				desktopPane.add(ftsp);
				ftsp.setVisible(true);
			}

		});
		mnNewMenu_1.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Cập nhật");
		mnNewMenu_1.add(mntmNewMenuItem_4);

		JMenu mnnHng = new JMenu("Đơn hàng");
		menuBar.add(mnnHng);

		JMenuItem mntmQunLn = new JMenuItem("Quản lý đơn hàng");
		mntmQunLn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmQuanLyDonHang fqldh = new FrmQuanLyDonHang();
				desktopPane.add(fqldh);
				fqldh.setVisible(true);
			}
		});
		mnnHng.add(mntmQunLn);

		JMenuItem mntmNewMenuItem_1_1_1_1 = new JMenuItem("Thống kê đơn hàng");
		mnnHng.add(mntmNewMenuItem_1_1_1_1);

		JMenu mnQungCo = new JMenu("Quảng cáo");
		menuBar.add(mnQungCo);

		JMenuItem mntmThmQungCo = new JMenuItem("Thêm quảng cáo");
		mnQungCo.add(mntmThmQungCo);

		JMenuItem mntmNewMenuItem_1_1_1 = new JMenuItem("Cập nhật quảng cáo");
		mnQungCo.add(mntmNewMenuItem_1_1_1);
		getContentPane().add(desktopPane, BorderLayout.CENTER);

		new Thread() {
			@Override
			public void run() {

				if (FrmDangNhap.nd != null) {
					btnLogout = new JButton();

					btnLogout.setBounds(1400, 0, 60, 47);
					ImageIcon iconLogout = new ImageIcon("src/images/icon-logout.jpg");
					iconLogout.setImage(iconLogout.getImage().getScaledInstance(btnLogout.getWidth(),
							btnLogout.getHeight(), Image.SCALE_SMOOTH));
					btnLogout.setIcon(iconLogout);
					btnLogout.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							FrmDangNhap.nd = null;
							lblName.setVisible(false);
							btnLogout.setVisible(false);
							FrmDangNhap fdn = new FrmDangNhap();
							fdn.setVisible(true);
							dispose();
						}

					});
					desktopPane.add(btnLogout, SwingConstants.EAST);

					lblName = new JLabel("");

					lblName.setBounds(900, 0, 600, 47);
					lblName.setFont(new Font("Calibri", Font.BOLD, 20));
					lblName.setForeground(Color.RED);

					String name = FrmDangNhap.nd.getHoTen();
					lblName.setText("Chào mừng bạn " + name);
					desktopPane.add(lblName);
				}
			}
		}.start();

	}

	public ImageIcon getScaledIcon(ImageIcon imageIcon, JLabel jLabel) {
		Image image = imageIcon.getImage().getScaledInstance(jLabel.getWidth(), jLabel.getHeight(), Image.SCALE_SMOOTH);
		imageIcon.setImage(image);
		return imageIcon;
	}

}
