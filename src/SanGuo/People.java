package SanGuo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class People implements Runnable {
	private int x, y;//人物的坐标
	int width,height;//角色的宽，高
	float hp;//血量
	float atk;//攻击力
	//当前的状态
	public String status;
	//显示当前的状态所对应的图像
	public Image show = null;
	//创建一个线程对象，来实现人物的动作
	private Thread thread = null;
	private int walkSpeed;//需要传入的参数速度
	private int xSpeed;//移动速度
	private int ySpeed;//跳跃速度
	private int upTime = 0;//表示主角的上升的时间
	
	//定义索引，用于我们获得人物的移动图片；因为移动，跳，攻击等图片的数量不同，所以要定义不同的索引
	int indexRun;//索引，移动的图片
	int indexJump;//索引，跳的图片
	int indexAttack;//索引，拳击的图片
	int indexFlyKick; //索引，飞踢的图片
	int indexLongAttack;//索引，连击的图片
	int indexSkill;//索引，技能的图片
	int indexQuickGo;//索引，冲锋的图片
	
	//（应该传入具体的图片数量，如5，3等格式，不要用 ......size()的格式，不然人物会卡空白）
	int runImgNum;//移动的图片数
	int jumpImgNum;//跳跃的图片数
	int cutImgNum;//拳击的图片数
	int flyKickImgNum;//飞踢的图片数
	int longAttackImgNum;//连击的图片数
	int skillImgNum;//技能的图片数
	int quickGoImgNum;//冲撞的图片数
	
	boolean cutCoolDown = true;//攻击冷却
	boolean quickGoCoolDown = true;//冲锋冷却
	boolean jumpCoolDown = true;//跳跃冷却状态
	boolean flyKickCoolDown = true;//飞踢冷却状态
	boolean longAttackCoolDown = true;//连击冷却状态
	boolean skillCoolDown = true;//技能冷却状态
	
	//各种行为图片的列表
	Image stand_LImg;//向左站立
	Image stand_RImg;//向右站立
	Image defend_LImg;//防御
	Image defend_RImg;//防御
	List<Image> run_LListImg = new ArrayList<>();//向左跑
	List<Image> run_RListImg = new ArrayList<>();//向右跑
	List<Image> jump_LListImg = new ArrayList<>();//向左跳跃
	List<Image> jump_RListImg = new ArrayList<>();//向右跳跃
	List<Image> cut_LListImg = new ArrayList<>();//向左攻击
	List<Image> cut_RListImg = new ArrayList<>();//向右攻击
	List<Image> flyKick_LListImg = new ArrayList<>();//飞踢向左
	List<Image> flyKick_RListImg = new ArrayList<>();//飞踢向右
	List<Image> longAttack_LListImg = new ArrayList<>();//连击向左
	List<Image> longAttack_RListImg = new ArrayList<>();//连击向右
	List<Image> skill_LListImg = new ArrayList<>();//技能左
	List<Image> skill_RListImg = new ArrayList<>();//技能右
	List<Image> quickGo_LListImg = new ArrayList<>();//冲锋左
	List<Image> quickGo_RListImg = new ArrayList<>();//冲锋右

	
	//构造方法
	public People() {}
	//敌人用的构造方法（包含小怪，Boss）
	public People(int x,int y,int width,int height,float hp,float atk,int walkSpeed,Image stand_LImg,
			Image stand_RImg,List<Image> run_LListImg,List<Image> run_RListImg,int runImgNum,
			List<Image> cut_LListImg,List<Image> cut_RListImg,int cutImgNum,
			List<Image> skill_LListImg,List<Image> skill_RListImg,int skillImgNum) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.hp = hp;
		this.atk = atk;
		this.walkSpeed = walkSpeed;
		this.stand_LImg = stand_LImg;
		this.stand_RImg = stand_RImg;
		this.run_LListImg = run_LListImg;
		this.run_RListImg = run_RListImg;
		this.runImgNum = runImgNum;
		this.cut_LListImg = cut_LListImg;
		this.cut_RListImg = cut_RListImg;
		this.cutImgNum = cutImgNum;
		this.skill_LListImg = skill_LListImg;
		this.skill_RListImg = skill_RListImg;
		this.skillImgNum = skillImgNum;
		//默认的初始值
		this.status = "stand--right";
		this.show = stand_RImg;
		this.thread = new Thread(this);
		thread.start();
	}
	//敌人2
	public People(int x,int y,int width,int height,float hp,float atk,int walkSpeed,Image stand_LImg,
			Image stand_RImg,List<Image> run_LListImg,List<Image> run_RListImg,int runImgNum,
			List<Image> quickGo_LListImg,List<Image> quickGo_RListImg,int quickGoImgNum,
			List<Image> cut_LListImg,List<Image> cut_RListImg,int cutImgNum,
			List<Image> skill_LListImg,List<Image> skill_RListImg,int skillImgNum) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.hp = hp;
		this.atk = atk;
		this.walkSpeed = walkSpeed;
		this.stand_LImg = stand_LImg;
		this.stand_RImg = stand_RImg;
		this.run_LListImg = run_LListImg;
		this.run_RListImg = run_RListImg;
		this.runImgNum = runImgNum;
		this.quickGo_LListImg = quickGo_LListImg;
		this.quickGo_RListImg = quickGo_RListImg;
		this.quickGoImgNum = quickGoImgNum;
		this.cut_LListImg = cut_LListImg;
		this.cut_RListImg = cut_RListImg;
		this.cutImgNum = cutImgNum;
		this.skill_LListImg = skill_LListImg;
		this.skill_RListImg = skill_RListImg;
		this.skillImgNum = skillImgNum;
		//默认的初始值
		this.status = "stand--right";
		this.show = stand_RImg;
		this.thread = new Thread(this);
		thread.start();
	}

	//主角用的构造方法
	public People(int x,int y,int width,int height,float hp,float atk,int walkSpeed,Image stand_LImg,Image stand_RImg,
			Image defend_LImg,Image defend_RImg,List<Image> run_LListImg,List<Image> run_RListImg,int runImgNum,
			List<Image> quickGo_LListImg,List<Image> quickGo_RListImg,int quickGoImgNum,
			List<Image> jump_LListImg,List<Image> jump_RListImg,int jumpImgNum,
			List<Image> cut_LListImg,List<Image> cut_RListImg,int cutImgNum,
			List<Image> flyKick_LListImg,List<Image> flyKick_RListImg,int flyKickImgNum,
			List<Image> longAttack_LListImg,List<Image> longAttack_RListImg,int longAttackImgNum,
			List<Image> skill_LListImg,List<Image> skill_RListImg,int skillImgNum) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.hp = hp;
		this.atk = atk;
		this.walkSpeed = walkSpeed;
		this.stand_LImg = stand_LImg;
		this.stand_RImg = stand_RImg;
		this.defend_LImg = defend_LImg;
		this.defend_RImg = defend_RImg;
		this.quickGo_LListImg = quickGo_LListImg;
		this.quickGo_RListImg = quickGo_RListImg;
		this.quickGoImgNum= quickGoImgNum;
		this.run_LListImg = run_LListImg;
		this.run_RListImg = run_RListImg;
		this.runImgNum = runImgNum;
		this.jump_LListImg = jump_LListImg;
		this.jump_RListImg = jump_RListImg;
		this.jumpImgNum = jumpImgNum;
		this.cut_LListImg = cut_LListImg;
		this.cut_RListImg = cut_RListImg;
		this.cutImgNum = cutImgNum;
		this.flyKick_LListImg = flyKick_LListImg;
		this.flyKick_RListImg = flyKick_RListImg;
		this.flyKickImgNum = flyKickImgNum;
		this.longAttack_LListImg = longAttack_LListImg;
		this.longAttack_RListImg = longAttack_RListImg;
		this.longAttackImgNum = longAttackImgNum;
		this.skill_LListImg = skill_LListImg;
		this.skill_RListImg = skill_RListImg;
		this.skillImgNum = skillImgNum;
		//默认的初始值
		this.status = "stand--right";//默认的人物状态是向右站立
		this.show = stand_RImg;//默认向右站立(不写也可以)
		this.thread = new Thread(this);
		thread.start();//开启线程
	}
	
	//向左移动时 调用此函数
	public void leftMove() {
		xSpeed = -walkSpeed;//改变速度
		status = "run--left";
	}
	//向右移动时 调用此函数
	public void rightMove() {
		xSpeed = walkSpeed;
		status = "run--right";
	}
	//面向左停止
	public void leftStop() {
		xSpeed = 0;
		status = "stop--left";
	}
	//面向右停止
	public void rightStop() {
		xSpeed = 0;
		status = "stop--right";
	}
	//防御
	public void defend() {
		xSpeed = 0;//防御时不能移动
		if (status.indexOf("jump") == -1) {//跳跃的时候不能防御
			if (status.indexOf("left") != -1) {//如果面向左
				status = "defend--left";
			}else {
				status = "defend--right";
			}
		}
	}
	//冲锋
	public void quickGo() {
		if (status.indexOf("jump") == -1) {//不在跳跃状态
			if (status.indexOf("left") != -1) {//如果面向左
				status = "quickGo--left";
				this.xSpeed = -walkSpeed*2;
			}else {
				status = "quickGo--right";
				this.xSpeed = walkSpeed*2;
			}
		}
	}
	//跳跃
	public void jump() {
		if (status.indexOf("left") != -1) {//如果面向左
			status = "jump--left";
		}else {
			status = "jump--right";
		}
		ySpeed = -10;//向上跳y 减少
		upTime = 5;//相当于向上跳了50像素
	}
	//主角，小怪，Boss的普通攻击
	public void attack() {
		if (status.indexOf("left") != -1) {//如果面朝着左边
			status = "cut--left";
		}else {
			status = "cut--right";
		}
	}
	//主角飞踢
	public void flyKick() {
		if (status.indexOf("left") != -1) {//如果面朝着左边
			status = "flyKick--left";
		}else {
			status = "flyKick--right";
		}
	}
	//主角连击
	public void longAttack() {
		if (status.indexOf("jump") == -1) {//只有站立在地面上才能使用连击
			xSpeed = 0;//使用连击时不能移动
			if (status.indexOf("left") != -1) {//如果面朝着左边
				status = "longAttack--left";
			}else {
				status = "longAttack--right";
			}
		}
	}
	//主角，小怪，Boss的技能
	public void skill() {
		if (status.indexOf("left") != -1) {
			status = "skill--left";
		}else {
			status = "skill--right";
		}
	}
	//人物结束了攻击，跳跃，技能等行为
	public void actionStop() {
		if (status.indexOf("slip") != -1) this.y = 270;
		if (status.indexOf("quickGo") != -1) this.setXSpeed(0);
		if (status.indexOf("left") != -1) {//如果面朝着左边	
			status = "stop--left";
		}else {//如果面朝着右边
			status = "stop--right";
		}
	}
	
	//在死循环里判断
	@Override
	public void run() {
		while(true) {
			if(y == 270 && upTime == 0) {//此时在地面上
				//此时人物没有拳击，连击，技能，冲锋，防御
				if (status.indexOf("cut") == -1 && status.indexOf("longAttack") == -1 && 
						status.indexOf("skill") == -1 && status.indexOf("quickGo") == -1
						&& status.indexOf("defend") == -1) {
					if (status.indexOf("left") != -1 ) {//判断方向
						if(xSpeed != 0) {//判断是否在移动中
							status = "run--left";
						}else {
							status = "stop--left";
						}
					}else if (status.indexOf("right") != -1) { 
						if(xSpeed != 0) {//判断是否在移动中
							status = "run--right";
						}else {
							status = "stop--right";
						}
					}
				}
			}else {//处于上升或下降的状态
				if(upTime != 0) {
					upTime --;//让upTime 一直自减
				}else {//这时upTime=0，达到了最高点
					ySpeed = 10;//改变ySpeed 的正负，让人物下降
				}
				y += ySpeed;//实现y 轴坐标的上下改变
			}
			
			//判断是否在运动，如果在运动，改变位置坐标
			if (xSpeed != 0) {
				x += xSpeed;
				//判断是否运动到了屏幕的边界，并防止超出屏幕界限
				if (x < 0) x = 0;
				if (x >= 960) x = 960;
			}
			
			//判断当前是否是移动状态，改变跑步图片的索引,如果在移动，改变索引（不断改变索引，从而改变图片）
			if (status.contains("run")) indexRun = indexRun < runImgNum-1 ? indexRun+1 : 0;
			//改变跳的图片的索引
			if (status.contains("jump")) indexJump = indexJump < jumpImgNum-1 ? indexJump+1 : 0;
			//改变普通攻击的图片的索引
			if (status.contains("cut")) indexAttack = indexAttack < cutImgNum-1 ? indexAttack+1 : 0;
			//改变飞踢的图片的索引
			if (status.contains("flyKick")) indexFlyKick = indexFlyKick < flyKickImgNum-1 ? indexFlyKick+1 : 0;
			//改变连击的图片的索引
			if (status.contains("longAttack")) indexLongAttack = indexLongAttack < longAttackImgNum-1 ? indexLongAttack+1 : 0;
			//改变放技能的图片的索引
			if (status.contains("skill")) indexSkill = indexSkill < skillImgNum-1 ? indexSkill+1 : 0;
			//改变冲锋的图片的索引
			if (status.contains("quickGo")) indexQuickGo = indexQuickGo < quickGoImgNum-1 ? indexQuickGo+1 : 0;
			
			//改变停止的图片
			if (status.equals("stop--left")) show = stand_LImg;
			if (status.equals("stop--right")) show = stand_RImg;
			//改变防御的图片
			if (status.equals("defend--left")) show = defend_LImg;
			if (status.equals("defend--right")) show = defend_RImg;
			//改变移动的图片
			if (status.equals("run--left")) show = run_LListImg.get(indexRun);
			if (status.equals("run--right")) show = run_RListImg.get(indexRun);
			//改变跳跃的图片
			if (status.equals("jump--left")) show = jump_LListImg.get(indexJump);
			if (status.equals("jump--right")) show = jump_RListImg.get(indexJump);
			//改变攻击的图片
			if (status.equals("cut--left"))show = cut_LListImg.get(indexAttack);
			if (status.equals("cut--right")) show = cut_RListImg.get(indexAttack);
			//改变飞踢的图片
			if (status.equals("flyKick--left")) show = flyKick_LListImg.get(indexFlyKick);
			if (status.equals("flyKick--right")) show = flyKick_RListImg.get(indexFlyKick);
			//改变连击的图片
			if (status.equals("longAttack--left")) show = longAttack_LListImg.get(indexLongAttack);  
			if (status.equals("longAttack--right")) show = longAttack_RListImg.get(indexLongAttack);  
			//改变技能的图片
			if (status.equals("skill--left")) show = skill_LListImg.get(indexSkill);  
			if (status.equals("skill--right")) show = skill_RListImg.get(indexSkill);  
			//改变冲锋的图片
			if (status.equals("quickGo--left")) show = quickGo_LListImg.get(indexQuickGo);  
			if (status.equals("quickGo--right")) show = quickGo_RListImg.get(indexQuickGo);  
			
			//休眠100毫秒，最好与主包里的休眠时间一致
			try {
				Thread.sleep(100);
			} catch (Exception e) {}
		}
	}
	
	//攻击冷却
	class cutCD extends Thread{
		public void run() {
			cutCoolDown = false;
			try {
				Thread.sleep(500);//拳击冷却时间，每隔0.5秒
				cutCoolDown = true;
			} catch (Exception e) {}
			this.interrupt();//中断线程(如果不中断好像暂时也没有问题)
		}
	}
	//跳跃冷却
	class jumpCD extends Thread{
		public void run() {
			jumpCoolDown = false;
			try {
				Thread.sleep(1000);
				jumpCoolDown = true;
			} catch (Exception e) {}
			this.interrupt();
		}
	}
	//飞踢冷却
	class flyKickCD extends Thread{
		public void run() {
			flyKickCoolDown = false;
			try {
				Thread.sleep(500);
				flyKickCoolDown = true;
			} catch (Exception e) {}
			this.interrupt();
		}
	}
	//连击冷却
	class longAttackCD extends Thread{
		public void run() {
			longAttackCoolDown = false;
			try {
				Thread.sleep(500);
				longAttackCoolDown = true;
			} catch (Exception e) {}
			this.interrupt();
		}
	}
	//技能冷却
	class skillCD extends Thread{
		public void run() {
			skillCoolDown = false;
			try {
				Thread.sleep(3000);
				skillCoolDown = true;
			} catch (Exception e) {}
			this.interrupt();
		}
	}
	//冲锋冷却
	class quickGoCD extends Thread{
		public void run() {
			quickGoCoolDown = false;
			try {
				Thread.sleep(500);
				quickGoCoolDown = true;
			} catch (Exception e) {}
			this.interrupt();
		}
	}

	//碰撞
	public Rectangle getRec() {
		return new Rectangle(x,y,width,height);
	}
	//一些set函数
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setShow(Image show) {
		this.show = show;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setXSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}
	public void setYSpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	public void setUpTime(int upTime) {
		this.upTime = upTime;
	}
	//get函数
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
	public float getHp() {
		return hp;
	}
	public float getAtk() {
		return atk;
	}
	public String getStatus() {
		return status;
	}
	public Image getShow() {
		return show;
	}
	public int getXSpeed() {
		return xSpeed;
	}
	public int getYSpeed() {
		return ySpeed;
	}
	public int getUpTime() {
		return upTime;
	}
	//获得相关行为的图片索引
	public int getIndexRun() {
		return indexRun;
	}
	public int getIndexJump() {
		return indexJump;
	}
	public int getIndexAttack() {
		return indexAttack;
	}
	public int getIndexFlyKick() {
		return indexFlyKick;
	}
	public int getIndexLongAttack() {
		return indexLongAttack;
	}
	public int getIndexSkill() {
		return indexSkill;
	}
	//获得相关行为的图片数量
	public int getRunImgNum() {
		return runImgNum;
	}
	public int getJumpImgNum() {
		return jumpImgNum;
	}
	public int getCutImgNum() {
		return cutImgNum;
	}
	public int getFlyKickImgNum() {
		return flyKickImgNum;
	}
	public int getLongAttackImgNum() {
		return longAttackImgNum;
	}
	public int getSkillImgNum() {
		return skillImgNum;
	}
	//获得相关攻击图片列表
	public List<Image> getCut_LListImg(){
		return cut_LListImg;
	}
	public List<Image> getCut_RListImg(){
		return cut_RListImg;
	}
	public List<Image> getFlyKick_LListImg(){
		return flyKick_LListImg;
	}
	public List<Image> getFlyKick_RListImg(){
		return flyKick_RListImg;
	}
	public List<Image> getLongAttack_LListImg(){
		return longAttack_LListImg;
	}
	public List<Image> getLongAttack_RListImg(){
		return longAttack_RListImg;
	}
	public List<Image> getSkill_ListImg(){
		return skill_LListImg;
	}
	public List<Image> getSkill_RistImg(){
		return skill_RListImg;
	}
}
