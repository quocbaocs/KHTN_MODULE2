package baiTap.bai2;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class RealImage implements Image {
	private String fileName;

	public RealImage(String fileName) {
		this.fileName = fileName;
		loadFromDisk(fileName);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public ImageIcon display() {
		ImageIcon img = new ImageIcon(fileName);
		return img;
	}

	public void loadFromDisk(String fileName) {
		JOptionPane.showMessageDialog(null, "Load image..." + fileName);
		;
	}

}
