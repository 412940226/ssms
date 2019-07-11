package com.peng.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class ZXingQrCodeUtils {
	/**
	 * 生成普通二维码
	 * @param contents
	 * @param width
	 * @param height
	 * @param imagePath
	 * @throws Exception
	 */
	public static void encodeQrCode(String contents,int width,
			int height,String imagePath) {
		Map<EncodeHintType, Object> hints=new HashMap<EncodeHintType, Object>();
		//指定纠错等级
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		//指定编码格式
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		//设定无边框
		hints.put(EncodeHintType.MARGIN, 0);
		try {
			BitMatrix bitMatrix = new MultiFormatWriter()
					.encode(contents, BarcodeFormat.QR_CODE, width, height, hints);
			MatrixToImageWriter.writeToStream(bitMatrix, "png", 
					new FileOutputStream(imagePath));
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 对二维码进行解析
	 * @param imagePath
	 * @return
	 */
	public static String decodeQrCode(String imagePath){
		String strResult="";
		BufferedImage bufferedImage=null;
		Result result=null;
		try {
			if (StringUtils.isEmpty(imagePath)) {
				throw new IllegalArgumentException("获取不到图片路径");
			}
			bufferedImage = ImageIO.read(new File(imagePath));
			if (bufferedImage==null) {
				throw new IllegalArgumentException("获取不到图片路径");
			}
			LuminanceSource luminanceSource=new BufferedImageLuminanceSource(bufferedImage);
			BinaryBitmap binaryBitmap=new BinaryBitmap(new HybridBinarizer(luminanceSource));
			Map<DecodeHintType, Object> hints=new HashMap<DecodeHintType, Object>();
			//指定编码格式
			hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
			result=new MultiFormatReader().decode(binaryBitmap, hints);
			strResult= result.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strResult;
	}
	
	public static void main(String[] args) throws Exception {
		ZXingQrCodeUtils.encodeQrCode("我爱你", 300, 300, "d:/qrcode.png");
		System.out.println(ZXingQrCodeUtils.decodeQrCode("d:/qrcode.png"));
	}
}

