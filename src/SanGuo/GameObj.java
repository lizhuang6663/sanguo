package SanGuo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class GameObj {
	Image img;//图片
	int x,y;//坐标
	int width,height;//图片的边长
	int recover;//恢复的血量值
	
	//构造方法
	public GameObj() {}
	public GameObj(Image img, int x,int y,int width,int height,int recover) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.recover = recover;
	}
	
	//绘制自身的图片
	public void paintSelf(Graphics gImage) {
		gImage.drawImage(img, x,y,null);
	}
	//返回自身矩形，可以进行碰撞检测
	public Rectangle getRec() {
		return new Rectangle(x,y,width,height);
	}
	
	//一些set get函数
	public void setImg(Image img) {
		this.img = img;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setRecover(int recover) {
		this.recover = recover;
	}
	public Image getImg() {
		return img;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getRecover() {
		return recover;
	}
}
