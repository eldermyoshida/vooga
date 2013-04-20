package vooga.fighter.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

import util.Pixmap;

public class PaletteSwap {
	// palette swapping is a common practice in fighting games
	// palette swapping can be used to create new character models by recycling
	// old ones
	// palette swapping can also be used to help players distinguish each other
	// when they both
	// select the same character
	private Pixmap ObjectImage;

	public PaletteSwap() {

	}

	public void applyGreyscale(Image colorImage, int width, int height) {
		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_BYTE_GRAY);
		//Graphics g = image.getGraphics();
		//g.drawImage(colorImage, 0, 0, null);
		//g.dispose();
		RescaleOp op = new RescaleOp(.9f, 0, null);
	    bufferedImage = op.filter(bufferedImage, null);
	}
	
	public void applyDarken(Image colorImage, int width, int height) throws Exception {
	    BufferedImage bufferedImage = new BufferedImage(width, height,
	        BufferedImage.TYPE_BYTE_INDEXED);

	    RescaleOp op = new RescaleOp(.9f, 0, null);
	    bufferedImage = op.filter(bufferedImage, null);
	}
}