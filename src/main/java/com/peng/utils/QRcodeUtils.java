package com.peng.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 
* @ClassName: QRcodeUtils 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author pengcq 412940226@qq.com 
* @date 2017年6月30日 下午4:51:31 
*
 */
public class QRcodeUtils {

	public static String format = "png";

	private static final int BLACK = 0xff000000;

	private static final int WHITE = 0xFFFFFFFF;
	// 嵌入的图片宽度
	private static final int IMAGE_WIDTH = 30;
	private static final int IMAGE_HEIGHT = 30;
	private static final int IMAGE_HALF_WIDTH = IMAGE_WIDTH / 2;
	private static final int FRAME_WIDTH = 2;
	// 二维码写码器
	private static MultiFormatWriter mutiWriter = new MultiFormatWriter();
	
	/***
	 * 创建单纯的二维码，没有中间的图标
	 * 
	 * @param content
	 * @param width
	 * @param height
	 * @param destFile
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void createQRcodeImage(String content, int width, int height,
			File destFile) throws Exception {
		Hashtable hints = new Hashtable();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.MARGIN, 0);
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
				BarcodeFormat.QR_CODE, width, height, hints);
		MatrixToImageWriter.writeToFile(bitMatrix, format, destFile);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void createQRcodeImage(String content, int width, int height, 
			OutputStream os) throws WriterException, IOException{
		Hashtable hints = new Hashtable();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.MARGIN, 0);
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
				BarcodeFormat.QR_CODE, width, height, hints);
		MatrixToImageWriter.writeToStream(bitMatrix, format, os);;
	}
	
	/***
	 * 创建包含中间图标的二维码
	 * @param content
	 * @param width
	 * @param height
	 * @param srcImage 图标
	 * @param destImage
	 */
	public static void createQRcodeImage(String content, int width, int height,
			File srcImage, File destImage) {
		//文件存在则不生成，不存在则生成
		if (!destImage.exists()) {
			try {
				ImageIO.write(genBarcode(content, width, height, srcImage),
						"png", destImage);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriterException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private static BufferedImage genBarcode(String content, int width,
			int height, File srcImage) throws WriterException,
			IOException {
		// 读取源图像
		BufferedImage scaleImage = scale(srcImage, IMAGE_WIDTH,
				IMAGE_HEIGHT, true);
		int[][] srcPixels = new int[IMAGE_WIDTH][IMAGE_HEIGHT];
		for (int i = 0; i < scaleImage.getWidth(); i++) {
			for (int j = 0; j < scaleImage.getHeight(); j++) {
				srcPixels[i][j] = scaleImage.getRGB(i, j);
			}
		}

		Map<EncodeHintType, Object> hint = new HashMap<EncodeHintType, Object>();
		hint.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hint.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		// 生成二维码
		BitMatrix matrix = mutiWriter.encode(content, BarcodeFormat.QR_CODE,
				width, height, hint);

		// 二维矩阵转为一维像素数组
		int halfW = matrix.getWidth() / 2;
		int halfH = matrix.getHeight() / 2;
		int[] pixels = new int[width * height];

		for (int y = 0; y < matrix.getHeight(); y++) {
			for (int x = 0; x < matrix.getWidth(); x++) {
				// 读取图片
				if (x > halfW - IMAGE_HALF_WIDTH
						&& x < halfW + IMAGE_HALF_WIDTH
						&& y > halfH - IMAGE_HALF_WIDTH
						&& y < halfH + IMAGE_HALF_WIDTH) {
					pixels[y * width + x] = srcPixels[x - halfW
							+ IMAGE_HALF_WIDTH][y - halfH + IMAGE_HALF_WIDTH];
				} 
				// 在图片四周形成边框
				else if ((x > halfW - IMAGE_HALF_WIDTH - FRAME_WIDTH
						&& x < halfW - IMAGE_HALF_WIDTH + FRAME_WIDTH
						&& y > halfH - IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH
						+ IMAGE_HALF_WIDTH + FRAME_WIDTH)
						|| (x > halfW + IMAGE_HALF_WIDTH - FRAME_WIDTH
								&& x < halfW + IMAGE_HALF_WIDTH + FRAME_WIDTH
								&& y > halfH - IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH
								+ IMAGE_HALF_WIDTH + FRAME_WIDTH)
						|| (x > halfW - IMAGE_HALF_WIDTH - FRAME_WIDTH
								&& x < halfW + IMAGE_HALF_WIDTH + FRAME_WIDTH
								&& y > halfH - IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH
								- IMAGE_HALF_WIDTH + FRAME_WIDTH)
						|| (x > halfW - IMAGE_HALF_WIDTH - FRAME_WIDTH
								&& x < halfW + IMAGE_HALF_WIDTH + FRAME_WIDTH
								&& y > halfH + IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH
								+ IMAGE_HALF_WIDTH + FRAME_WIDTH)) {
					pixels[y * width + x] = 0xfffffff;
				} else {
					// 此处可以修改二维码的颜色，可以分别制定二维码和背景的颜色；
					pixels[y * width + x] = matrix.get(x, y) ? 0xff000000
							: 0xfffffff;
				}
			}
		}

		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		image.getRaster().setDataElements(0, 0, width, height, pixels);

		return image;
	}

	/**
	 * 把传入的原始图像按高度和宽度进行缩放，生成符合要求的图标
	 * 
	 * @param srcImageFile
	 *            源文件
	 * @param height
	 *            目标高度
	 * @param width
	 *            目标宽度
	 * @param hasFiller
	 *            比例不对时是否需要补白：true为补白; false为不补白;
	 * @throws IOException
	 */
	private static BufferedImage scale(File srcImageFile, int height,
			int width, boolean hasFiller) throws IOException {
		double ratio = 0.0; // 缩放比例
		
		BufferedImage srcImage = ImageIO.read(srcImageFile);
		Image destImage = srcImage.getScaledInstance(width, height,
				BufferedImage.SCALE_SMOOTH);
		// 计算比例
		if ((srcImage.getHeight() > height) || (srcImage.getWidth() > width)) {
			if (srcImage.getHeight() > srcImage.getWidth()) {
				ratio = (new Integer(height)).doubleValue()
						/ srcImage.getHeight();
			} else {
				ratio = (new Integer(width)).doubleValue()
						/ srcImage.getWidth();
			}
			AffineTransformOp op = new AffineTransformOp(
					AffineTransform.getScaleInstance(ratio, ratio), null);
			destImage = op.filter(srcImage, null);
		}
		if (hasFiller) {// 补白
			BufferedImage image = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D graphic = image.createGraphics();
			graphic.setColor(Color.white);
			graphic.fillRect(0, 0, width, height);
			if (width == destImage.getWidth(null))
				graphic.drawImage(destImage, 0,
						(height - destImage.getHeight(null)) / 2,
						destImage.getWidth(null), destImage.getHeight(null),
						Color.white, null);
			else
				graphic.drawImage(destImage,
						(width - destImage.getWidth(null)) / 2, 0,
						destImage.getWidth(null), destImage.getHeight(null),
						Color.white, null);
			graphic.dispose();
			destImage = image;
		}
		return (BufferedImage) destImage;
	}
	public static void main(String[] args) throws Exception {
		QRcodeUtils.createQRcodeImage("http://meeting.jomoo.cn/login.html", 300, 300, new File("c:/qrcode2.png"));
	}
}
