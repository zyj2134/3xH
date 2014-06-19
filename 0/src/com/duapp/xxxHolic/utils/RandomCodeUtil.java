package com.duapp.xxxHolic.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class RandomCodeUtil {
	//验证码宽度
	private static int width = 60;
	//验证码高度
	private static int height = 20;
	//验证码字符数
	private static int codeNum = 4;
	//验证码
	private static String randomCode = "";
	//干扰字符
	private static String drawString = "◻";
	//初始字符
	private static StringBuffer code = new StringBuffer();
	//初始字符长度
	private static int codeLength = 0;
	//背景色
	private static Color bgColor = new Color(215, 215, 215);
	//验证码字符颜色
	private static Color codeColor = new Color(0, 0, 0);
	//验证码字符字体
	private static Font codeFont = new Font(Font.SANS_SERIF, Font.BOLD, 16);
	static {
		//初始化字符
		for (char c = '0';  c <= 'z'; c++) {
			if (c == '9' + 1) {
				c = 'A';
			} else if (c == 'Z' + 1) {
				c = 'a';
			}
			code.insert(codeLength, c);
			codeLength++;
		}
	}
	
	public static BufferedImage getImage() {
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();
		Random r = new Random();
		g.setColor(bgColor);
		g.fillRect(0, 0, width, height);
		g.setFont(codeFont);
		g.setColor(codeColor);
		randomCode = "";
		for (int i = 0; i < codeNum; i++) {
			String word = String.valueOf(code.charAt(r.nextInt(codeLength)));
			randomCode += word;
			g.drawString(word, (width / codeNum - codeFont.getSize() / 10) * i + r.nextInt(width / codeNum - codeFont.getSize() / 2), height - codeFont.getSize() + codeFont.getSize() / 2 + r.nextInt(codeFont.getSize() - codeFont.getSize() / 2));
		}
		for (int i = 0; i < codeNum; i++) {
			g.setColor(new Color(r.nextInt(0xff), r.nextInt(0xff), r.nextInt(0xff)));
			// 干扰字符
			g.drawString(drawString, r.nextInt(width), r.nextInt(height));
			// 干扰线
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
		}
		// 干扰点
		g.setColor(codeColor);
		for (int j = 0; j < codeLength; j++) {
			int x = r.nextInt(width);
			int y = r.nextInt(height);
			g.drawLine(x, y, x, y);
		}
		return image;
	}

	public static String getRandomCode() {
		return randomCode;
	}

	public static void setWidth(int width) {
		RandomCodeUtil.width = width;
	}

	public static int getWidth() {
		return width;
	}

	public static void setHeight(int height) {
		RandomCodeUtil.height = height;
	}

	public static int getHeight() {
		return height;
	}

	public static int getCodeNum() {
		return codeNum;
	}

	public static void setCodeNum(int codeNum) {
		RandomCodeUtil.codeNum = codeNum;
	}

	public static String getDrawString() {
		return drawString;
	}

	public static void setDrawString(String drawString) {
		RandomCodeUtil.drawString = drawString;
	}

	public static int getCodeLength() {
		return codeLength;
	}

	public static Color getBgColor() {
		return bgColor;
	}

	public static void setBgColor(Color bgColor) {
		RandomCodeUtil.bgColor = bgColor;
	}

	public static Color getCodeColor() {
		return codeColor;
	}

	public static void setCodeColor(Color codeColor) {
		RandomCodeUtil.codeColor = codeColor;
	}

	public static Font getCodeFont() {
		return codeFont;
	}

	public static void setCodeFont(Font codeFont) {
		RandomCodeUtil.codeFont = codeFont;
	}
}
