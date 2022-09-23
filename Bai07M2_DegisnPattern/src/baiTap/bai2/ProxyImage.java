package baiTap.bai2;

import javax.swing.ImageIcon;

public class ProxyImage implements Image {
	
	private RealImage realImage;
	private String fileName;

	public ProxyImage(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public ImageIcon display() {
		if (realImage == null) {
			realImage = new RealImage(fileName);
		}
		return realImage.display();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
