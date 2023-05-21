package SanGuo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
//未解决问题：由于绘制血条长度不一致的问题，只能将小怪的血量设为相同的了


public class GameFame extends JFrame {
	private static final long serialVersionUID = 1L;
	int width = 1000, height = 416;
	//双缓存
	private Image offScreenImg = null;
	//head 为了随机选择gameState = 0 时的背景图片
	int head;
	//bgWald为了实现背景的移动
	public static int bgWalk = 0;
	//游戏状态 0未开始，1选择人物，2开始游戏，3暂停，4失败，5胜利，
	//6按键介绍，7关羽的被动介绍，8张飞，9赵云，10魏延，11，敌人的介绍，12开始游戏的进度条
	public static int gameState;
	
	//建立角色对象
	public static Role role = null;
	public static Role role1 = null;//关羽
	public static Role role2 = null;//张飞
	public static Role role3 = null;//赵云
	public static Role role4 = null;//魏延

	//小怪的最大数量（每一关小怪的最大数量是不同的）
	int soldierCount;
	//小怪出现的速度（每一关小怪的生成速度都是不同的）
	int appearEnemySpeed;
	
	//击杀小怪的数量，用于关羽的被动和魏延的被动2
	public static int killEnemyCount;
	//主角被攻击前的血量，用于张飞的被动
	public static float isCutAgoHp;
	//敌人在场上的数量，用于赵云的被动
	public static int nowEnemyCount;

	
	//Boss
	Enemy boss1 = null;
	Enemy boss2 = null;
	Enemy boss3 = null;
	//临时敌人对象，用来实现状态12
	Enemy temporaryEnemy;
	//关卡集合
	public static List<Image> allBgImg = new ArrayList<>();
	//用来表示目前到达了那一关
	int nowBgNum = 0;
	
	
	//主入口
	public static void main(String[] args) {
		new GameFame().launch();
	}
	//初始化
	public void launch() {
		this.setFocusable(true);
		setTitle("Lizhuang");
		setSize(width,height);
		setResizable(false);
		setLocationRelativeTo(null);//居中
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		//实现键盘监听，控制主角移动
		this.addKeyListener(new GameFame.KeyMonitor());	
		//往关卡列表中添加背景，共三个关卡
		allBgImg.add(GameUtils.bg1Img);
		allBgImg.add(GameUtils.bg2Img);
		allBgImg.add(GameUtils.bg3Img);
		//初始化关羽对象
		role1 = new Role(100,270,64,79,GameUtils.hp1,GameUtils.atk1,GameUtils.walkSpeed1,
				GameUtils.stand_LImg1,GameUtils.stand_RImg1,GameUtils.defend_LImg1,GameUtils.defend_RImg1,
				GameUtils.run_LListImg1,GameUtils.run_RListImg1,8,GameUtils.quickGo_LListImg1,GameUtils.quickGo_RListImg1,3,
				GameUtils.jump_LListImg1,GameUtils.jump_RListImg1,21,GameUtils.cut_LListImg1,GameUtils.cut_RListImg1,3,
				GameUtils.flyKick_LListImg1,GameUtils.flyKick_RListImg1,5,GameUtils.longAttack_LListImg1,GameUtils.longAttack_RListImg1,9,
				GameUtils.skill_LListImg1,GameUtils.skill_RListImg1,11);
		//初始化张飞对象
		role2 = new Role(100,270,72,77,GameUtils.hp2,GameUtils.atk2,GameUtils.walkSpeed2,
				GameUtils.stand_LImg2,GameUtils.stand_RImg2,GameUtils.defend_LImg2,GameUtils.defend_RImg2,
				GameUtils.run_LListImg2,GameUtils.run_RListImg2,8,GameUtils.quickGo_LListImg2,GameUtils.quickGo_RListImg2,3,
				GameUtils.jump_LListImg2,GameUtils.jump_RListImg2,21,GameUtils.cut_LListImg2,GameUtils.cut_RListImg2,3,
				GameUtils.flyKick_LListImg2,GameUtils.flyKick_RListImg2,6,GameUtils.longAttack_LListImg2,GameUtils.longAttack_RListImg2,7,
				GameUtils.skill_LListImg2,GameUtils.skill_RListImg2,11);
		//初始化赵云对象
		role3 = new Role(100,270,56,76,GameUtils.hp3,GameUtils.atk3,GameUtils.walkSpeed3,
				GameUtils.stand_LImg3,GameUtils.stand_RImg3,GameUtils.defend_LImg3,GameUtils.defend_RImg3,
				GameUtils.run_LListImg3,GameUtils.run_RListImg3,8,GameUtils.quickGo_LListImg3,GameUtils.quickGo_RListImg3,5,
				GameUtils.jump_LListImg3,GameUtils.jump_RListImg3,21,GameUtils.cut_LListImg3,GameUtils.cut_RListImg3,6,
				GameUtils.flyKick_LListImg3,GameUtils.flyKick_RListImg3,3,GameUtils.longAttack_LListImg3,GameUtils.longAttack_RListImg3,7,
				GameUtils.skill_LListImg3,GameUtils.skill_RListImg3,7);
		//初始化魏延对象
		role4 = new Role(100,270,62,76,GameUtils.hp4,GameUtils.atk4,GameUtils.walkSpeed4,
				GameUtils.stand_LImg4,GameUtils.stand_RImg4,GameUtils.defend_LImg4,GameUtils.defend_RImg4,
				GameUtils.run_LListImg4,GameUtils.run_RListImg4,8,GameUtils.quickGo_LListImg4,GameUtils.quickGo_RListImg4,3,
				GameUtils.jump_LListImg4,GameUtils.jump_RListImg4,21,GameUtils.cut_LListImg4,GameUtils.cut_RListImg4,5,
				GameUtils.flyKick_LListImg4,GameUtils.flyKick_RListImg4,6,GameUtils.longAttack_LListImg4,GameUtils.longAttack_RListImg4,9,
				GameUtils.skill_LListImg4,GameUtils.skill_RListImg4,10);
		
		//初始化临时敌人对象
		temporaryEnemy = new Enemy(0,270,68,79,GameUtils.hpEnemy2,GameUtils.atkEnemy2,10,
				GameUtils.stand_LEnemyImg2,GameUtils.stand_REnemyImg2,GameUtils.run_LEnemyListImg2,GameUtils.run_REnemyListImg2,5,
				GameUtils.quickGo_LEnemyListImg2,GameUtils.quickGo_REnemyListImg2,3,
				GameUtils.cut_LEnemyListImg2,GameUtils.cut_REnemyListImg2,4,
				GameUtils.skill_LEnemyListImg2,GameUtils.skill_REnemyListImg2,4);
		//初始化图片
		GameUtils.init();
		//初始化gameState = 0 时的背景图（随机选择图片）
		head = (int)(Math.random()*3+1);
		
		
		//鼠标点击监听，在游戏状态为1的时候，选择角色
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = new Point(e.getX(),e.getY());
				//鼠标点击来开始游戏或者看按键帮助
				if (gameState == 0) {
					if (p.x>330 && p.x<554 && p.y>300 && p.y<354) gameState = 1;
					if (p.x>880 && p.x<980 && p.y>50 && p.y<89) gameState = 6;
				}
				//鼠标点击来选择人物
				if (gameState == 1){
					if (p.x>150 && p.x<216 && p.y>50 && p.y<150) {
						gameState = 7;//改变游戏状态
						role = role1;//设置主角
					}else if (p.x>350 && p.x<416 && p.y>50 && p.y<150){
						gameState = 8;
						role = role2;
					}else if (p.x>550 && p.x<616 && p.y>50 && p.y<150){
						gameState = 9;
						role = role3;
					}else if (p.x>750 && p.x<816 && p.y>50 && p.y<150){
						gameState = 10;
						role = role4;
					}else if (p.x>20 && p.x<141 && p.y>40 && p.y<77) {
						gameState = 0;//返回按钮
					}			
				}
				if (gameState == 6) {
					if (p.x>20 && p.x<141 && p.y>40 && p.y<77) gameState = 0;//返回按钮
					if (p.x>920 && p.x<983 && p.y>320 && p.y<383) gameState = 11;//进入状态11:敌人的介绍
				}
				if (gameState == 7 || gameState == 8 || gameState == 9 || gameState == 10) {
					if (p.x>20 && p.x<141 && p.y>40 && p.y<77) gameState = 1;//返回按钮
					if (p.x>400 && p.x<522 && p.y>300 && p.y<338) gameState = 12;//开始按钮，进入状态12：开始游戏的进度条
				}
				if (gameState == 11) {
					if (p.x>20 && p.x<141 && p.y>40 && p.y<77) gameState = 6;//返回按钮
				}
			}
		});
		
		
		//重复绘制
		while(true) {
			if (gameState == 2) creatObj();//创建敌人
			repaint();
			try {
				Thread.sleep(100);
			} catch (Exception e) {}
		}
	}
	
	//重置（用于重新开始游戏）
	public void init() {
		bgWalk = 0;
		nowBgNum = 0;
		GameUtils.gameObjListImg.clear();//删除列表中的所有元素
		GameUtils.enemyListImg.clear();
		GameUtils.bossListImg.clear();
		soldierCount = 0;//小怪数量清零
		boss1 = null;
		boss2 = null;
		boss3 = null;
		if (role == role1) role.hp = GameUtils.hp1;//恢复主角的血量
		if (role == role2) role.hp = GameUtils.hp2;
		if (role == role3) role.hp = GameUtils.hp3;
		if (role == role4) role.hp = GameUtils.hp4;
	}
	
	//创建敌人
	public void creatObj() {
			int n = (int)(Math.random()*3);//一次性随机数
			int site = 0;//小怪出现的位置，小怪的随机出现位置只有在左边和右边
			if (n == 0) site = 0;
			if (n == 1 || n == 2) site = 900;//小怪大约有三分之二的概率从右边出现
			//小怪随机添加
			int n2 = (int)(Math.random()*10);
			//如果是第1关，只有蛮兵，枪兵，小怪的生成速度是每100帧
			if (nowBgNum == 0 && appearEnemySpeed >= 100 && soldierCount < 8) {
				appearEnemySpeed = 0;
				if (n2 <= 5) {//有一半的概率生成蛮兵
					//将小怪1添加到enemyListImg中
					GameUtils.enemyListImg.add(new Enemy(site,270,56,93,GameUtils.hpEnemy1,GameUtils.atkEnemy1,GameUtils.walkSpeedEnemy1,
							GameUtils.stand_LEnemyImg1,GameUtils.stand_REnemyImg1,GameUtils.run_LEnemyListImg1,GameUtils.run_REnemyListImg1,6,
							GameUtils.quickGo_LEnemyListImg1,GameUtils.quickGo_REnemyListImg1,6,
							GameUtils.cut_LEnemyListImg1,GameUtils.cut_REnemyListImg1,5,
							GameUtils.skill_LEnemyListImg1,GameUtils.skill_REnemyListImg1,4));
				}else {//将小怪2添加到enemyListImg中
					GameUtils.enemyListImg.add(new Enemy(site,270,68,79,GameUtils.hpEnemy2,GameUtils.atkEnemy2,GameUtils.walkSpeedEnemy2,
							GameUtils.stand_LEnemyImg2,GameUtils.stand_REnemyImg2,GameUtils.run_LEnemyListImg2,GameUtils.run_REnemyListImg2,5,
							GameUtils.quickGo_LEnemyListImg2,GameUtils.quickGo_REnemyListImg2,3,
							GameUtils.cut_LEnemyListImg2,GameUtils.cut_REnemyListImg2,4,
							GameUtils.skill_LEnemyListImg2,GameUtils.skill_REnemyListImg2,4));	
				}
				soldierCount++;
				nowEnemyCount+=5;
			}
			//如果是第2关，只有重刀兵，刺客
			if (nowBgNum == 1 && appearEnemySpeed >= 60 && soldierCount < 15) {
				appearEnemySpeed = 0;
				if (n2 <= 5) {
					GameUtils.enemyListImg.add(new Enemy(site,270,80,64,GameUtils.hpEnemy3,GameUtils.atkEnemy3,GameUtils.walkSpeedEnemy3,
							GameUtils.stand_LEnemyImg3,GameUtils.stand_REnemyImg3,GameUtils.run_LEnemyListImg3,GameUtils.run_REnemyListImg3,2,
							GameUtils.quickGo_LEnemyListImg3,GameUtils.quickGo_REnemyListImg3,3,
							GameUtils.cut_LEnemyListImg3,GameUtils.cut_REnemyListImg3,3,
							GameUtils.skill_LEnemyListImg3,GameUtils.skill_REnemyListImg3,3));	
				}else {
					GameUtils.enemyListImg.add(new Enemy(site,270,48,80,GameUtils.hpEnemy4,GameUtils.atkEnemy4,GameUtils.walkSpeedEnemy4,
							GameUtils.stand_LEnemyImg4,GameUtils.stand_REnemyImg4,GameUtils.run_LEnemyListImg4,GameUtils.run_REnemyListImg4,5,
							GameUtils.quickGo_LEnemyListImg4,GameUtils.quickGo_REnemyListImg4,3,
							GameUtils.cut_LEnemyListImg4,GameUtils.cut_REnemyListImg4,3,
							GameUtils.skill_LEnemyListImg4,GameUtils.skill_REnemyListImg4,4));		
				}
				soldierCount++;
				nowEnemyCount+=5;
			}
			//如果是第3关，5个兵种都有几率出现，但主要是重锤兵
			if (nowBgNum == 2 && appearEnemySpeed >= 80 && soldierCount < 20) {
				appearEnemySpeed = 0;
				switch (n2) {
					case 0:
						GameUtils.enemyListImg.add(new Enemy(site,270,56,93,GameUtils.hpEnemy1,GameUtils.atkEnemy1,GameUtils.walkSpeedEnemy1,
								GameUtils.stand_LEnemyImg1,GameUtils.stand_REnemyImg1,GameUtils.run_LEnemyListImg1,GameUtils.run_REnemyListImg1,6,
								GameUtils.quickGo_LEnemyListImg1,GameUtils.quickGo_REnemyListImg1,3,
								GameUtils.cut_LEnemyListImg1,GameUtils.cut_REnemyListImg1,5,
								GameUtils.skill_LEnemyListImg1,GameUtils.skill_REnemyListImg1,4));
						break;
					case 1,2:
						GameUtils.enemyListImg.add(new Enemy(site,270,68,79,GameUtils.hpEnemy2,GameUtils.atkEnemy2,GameUtils.walkSpeedEnemy2,
								GameUtils.stand_LEnemyImg2,GameUtils.stand_REnemyImg2,GameUtils.run_LEnemyListImg2,GameUtils.run_REnemyListImg2,5,
								GameUtils.quickGo_LEnemyListImg2,GameUtils.quickGo_REnemyListImg2,3,
								GameUtils.cut_LEnemyListImg2,GameUtils.cut_REnemyListImg2,4,
								GameUtils.skill_LEnemyListImg2,GameUtils.skill_REnemyListImg2,4));	
						break;
					case 3,4:
						GameUtils.enemyListImg.add(new Enemy(site,270,80,64,GameUtils.hpEnemy3,GameUtils.atkEnemy3,GameUtils.walkSpeedEnemy3,
								GameUtils.stand_LEnemyImg3,GameUtils.stand_REnemyImg3,GameUtils.run_LEnemyListImg3,GameUtils.run_REnemyListImg3,2,
								GameUtils.quickGo_LEnemyListImg3,GameUtils.quickGo_REnemyListImg3,3,
								GameUtils.cut_LEnemyListImg3,GameUtils.cut_REnemyListImg3,3,
								GameUtils.skill_LEnemyListImg3,GameUtils.skill_REnemyListImg3,3));	
						break;
					case 5,6:
						GameUtils.enemyListImg.add(new Enemy(site,270,48,80,GameUtils.hpEnemy4,GameUtils.atkEnemy4,GameUtils.walkSpeedEnemy4,
								GameUtils.stand_LEnemyImg4,GameUtils.stand_REnemyImg4,GameUtils.run_LEnemyListImg4,GameUtils.run_REnemyListImg4,5,
								GameUtils.quickGo_LEnemyListImg4,GameUtils.quickGo_REnemyListImg4,3,
								GameUtils.cut_LEnemyListImg4,GameUtils.cut_REnemyListImg4,3,
								GameUtils.skill_LEnemyListImg4,GameUtils.skill_REnemyListImg4,4));		
						break;
					case 7,8,9:
						GameUtils.enemyListImg.add(new Enemy(site,270,80,80,GameUtils.hpEnemy5,GameUtils.atkEnemy5,GameUtils.walkSpeedEnemy5,
								GameUtils.stand_LEnemyImg5,GameUtils.stand_REnemyImg5,GameUtils.run_LEnemyListImg5,GameUtils.run_REnemyListImg5,4,
								GameUtils.quickGo_LEnemyListImg5,GameUtils.quickGo_REnemyListImg5,3,
								GameUtils.cut_LEnemyListImg5,GameUtils.cut_REnemyListImg5,3,
								GameUtils.skill_LEnemyListImg5,GameUtils.skill_REnemyListImg5,4));	
						break;
				}
				soldierCount++;
				nowEnemyCount+=5;
			}
			
		//如果没有Boss，而且背景移动到头了，添加Boss1
		if (boss1 == null && bgWalk <= -3500 && nowBgNum == 0) {
			boss1 = new Enemy(900,200,96,112,GameUtils.hpBoss1,GameUtils.atkBoss1,GameUtils.walkSpeedBoss1,
					GameUtils.stand_LBossImg1,GameUtils.stand_RBossImg1,GameUtils.run_LBossListImg1,GameUtils.run_RBossListImg1,5,
					GameUtils.quickGo_LBossListImg1,GameUtils.quickGo_RBossListImg1,3,
					GameUtils.cut_LBossListImg1,GameUtils.cut_RBossListImg1,5,
					GameUtils.skill_LBossListImg1,GameUtils.skill_RBossListImg1,5);
			GameUtils.bossListImg.add(boss1);//将Boss添加到bossListImg中
			nowEnemyCount+=5;
		}
		//在第2关创建Boss2
		if (boss2 == null && bgWalk <= -3500 && nowBgNum == 1) {
			boss2 = new Enemy(900,200,160,96,GameUtils.hpBoss2,GameUtils.atkBoss2,GameUtils.walkSpeedBoss2,
					GameUtils.stand_LBossImg2,GameUtils.stand_RBossImg2,GameUtils.run_LBossListImg2,GameUtils.run_RBossListImg2,4,
					GameUtils.quickGo_LBossListImg2,GameUtils.quickGo_RBossListImg2,3,
					GameUtils.cut_LBossListImg2,GameUtils.cut_RBossListImg2,4,
					GameUtils.skill_LBossListImg2,GameUtils.skill_RBossListImg2,2);
			GameUtils.bossListImg.add(boss2);
			nowEnemyCount+=5;
		}
		//在第3关创建Boss3
		if (boss3 == null && bgWalk <= -3500 && nowBgNum == 2) {
			boss3 = new Enemy(900,200,112,128,GameUtils.hpBoss3,GameUtils.atkBoss3,GameUtils.walkSpeedBoss3,
					GameUtils.stand_LBossImg3,GameUtils.stand_RBossImg3,GameUtils.run_LBossListImg3,GameUtils.run_RBossListImg3,4,
					GameUtils.quickGo_LBossListImg3,GameUtils.quickGo_RBossListImg3,3,
					GameUtils.cut_LBossListImg3,GameUtils.cut_RBossListImg3,5,
					GameUtils.skill_LBossListImg3,GameUtils.skill_RBossListImg3,5);
			GameUtils.bossListImg.add(boss3);
			nowEnemyCount+=5;
		}
	}
	
	
	//绘制图片
	@Override
	public void paint(Graphics g) {
		if (offScreenImg == null) offScreenImg = createImage(width,height);
		Graphics gImage = offScreenImg.getGraphics();
		gImage.fillRect(0, 0, width, height);
		//0未开始
		if (gameState == 0) {
			//随机设置背景
			if (head == 1) gImage.drawImage(GameUtils.title1Img,0,0,null);
			if (head == 2) gImage.drawImage(GameUtils.title2Img,0,0,null);
			if (head == 3) gImage.drawImage(GameUtils.title3Img,0,0,null);
			gImage.drawImage(GameUtils.begin1Img,330,300,null);//开始游戏
			gImage.drawImage(GameUtils.helpImg,880,50,null);//游戏帮助
		}
		//1选择人物
		if (gameState == 1) {
			gImage.drawImage(GameUtils.title4Img,0,0,null);
			gImage.drawImage(GameUtils.returnImg,20,40,null);//返回的按钮
			gImage.drawImage(GameUtils.header1Img,150,50,null);
			gImage.drawImage(GameUtils.header2Img,350,50,null);
			gImage.drawImage(GameUtils.header3Img,550,50,null);
			gImage.drawImage(GameUtils.header4Img,750,50,null);
		}
		//2开始游戏
		if (gameState == 2) {
			//Music.startPlay();
			//实现背景的移动
			if (role.getStatus().indexOf("right") != -1) {
				//bgWalk是为了实现背景的移动，人物向右走的时候，背景也跟着动；人物向左走的时候，背景不会动
				bgWalk += -(role.getXSpeed()*2.5);
				if (bgWalk < -4120) bgWalk = -4120;// //防止bgWalk超出范围
			}
			//绘制背景
			gImage.drawImage(allBgImg.get(nowBgNum),bgWalk,0,null);
			//绘制人物
			gImage.drawImage(role.getShow(), role.getX(),role.getY(),null);
			gImage.drawImage(GameUtils.bloodImg,15,35,null);//绘制血条，血条长200
			gImage.setColor(Color.red);
			if (role == role1) {
				gImage.fillRect(30,47,(int)role.getHp()/(int)(GameUtils.hp1/200),8);
				//关羽被动，随着击杀敌人的数量增加，攻击力不断增加
				role.atk += killEnemyCount*2;
				killEnemyCount = 0;//清零，防止重复加
			}
			if (role == role2) {
				gImage.fillRect(30,47,(int)role.getHp()/(int)(GameUtils.hp2/200),8);
				//张飞的被动在Role中
			}
			if (role == role3) {
				gImage.fillRect(30,47,(int)role.getHp()/(int)(GameUtils.hp3/200),8);
				//赵云被动，在场的敌人数量越多，攻击力越高
				role.atk = GameUtils.atk3 + nowEnemyCount;			
			}
			if (role == role4) {
				gImage.fillRect(30,47,(int)role.getHp()/(int)(GameUtils.hp4/200),8);
				//魏延被动，击杀敌人后，恢复所杀敌人血量的百分之五的血量，被动在Enemy
			}
			gImage.drawImage(GameUtils.atkImg,25,70,null);//绘制主角的攻击力
			gImage.setColor(Color.yellow);
			gImage.fillRect(25,71,(int)role.getAtk(),7);
			role.isWound();//是否受伤
			role.eatFood();//吃食物
			
			//遍历小怪列表
			for (int i = 0;i<GameUtils.enemyListImg.size();i++) {
				//绘制敌人
				gImage.drawImage(GameUtils.enemyListImg.get(i).getShow(),GameUtils.enemyListImg.get(i).getX(),GameUtils.enemyListImg.get(i).getY(),null);
				GameUtils.enemyListImg.get(i).action();//让敌人开始一系列动作
				//绘制血条的白色背景
				gImage.setColor(Color.white);
				gImage.fillRect(GameUtils.enemyListImg.get(i).getX()-10,GameUtils.enemyListImg.get(i).getY()-10,100,5);//填充的矩形长度是100
				//绘制血条
				gImage.setColor(Color.red);
				gImage.fillRect(GameUtils.enemyListImg.get(i).getX()-10,GameUtils.enemyListImg.get(i).getY()-10,
						(int)GameUtils.enemyListImg.get(i).getHp()/(int)(GameUtils.hpEnemy1/100),5);
			}
			//遍历Boss列表
			for (int i = 0;i<GameUtils.bossListImg.size();i++) {
				gImage.drawImage(GameUtils.bossListImg.get(i).getShow(),GameUtils.bossListImg.get(i).getX(),GameUtils.bossListImg.get(i).getY(),null);
				GameUtils.bossListImg.get(i).action();//让Boss开始一系列动作
				//绘制血条的白色背景
				gImage.setColor(Color.white);
				gImage.fillRect(GameUtils.bossListImg.get(i).getX()-10,GameUtils.bossListImg.get(i).getY()-10,100,5);//填充的矩形长度是100
				//绘制血条
				gImage.setColor(Color.red);
				gImage.fillRect(GameUtils.bossListImg.get(i).getX()-10,GameUtils.bossListImg.get(i).getY()-10,
						(int)GameUtils.bossListImg.get(i).getHp()/(int)(GameUtils.hpBoss1/100),5);
			}
			//绘制食物(主角吃食物的代码在Role中)
			for (int i = 0;i<GameUtils.gameObjListImg.size();i++) {
				gImage.drawImage(GameUtils.gameObjListImg.get(i).getImg(),GameUtils.gameObjListImg.get(i).getX(),GameUtils.gameObjListImg.get(i).getY(),null);
			}
			//删除已经吃过的食物
			GameUtils.gameObjListImg.removeAll(GameUtils.removeObjListImg);
			//删除已经死亡的敌人
			GameUtils.enemyListImg.removeAll(GameUtils.removeEnemyListImg);//在gameListImg中删除死掉的小怪
			GameUtils.bossListImg.removeAll(GameUtils.removeEnemyListImg);//在bossListImg中删除死掉的Boss
			//判断游戏胜利的条件
			if (GameUtils.enemyListImg.size() == 0 && GameUtils.bossListImg.size() == 0 && bgWalk <= -4100 && role.getX() >= 950) {
				if (nowBgNum == 2) gameState = 5;//全部关卡都已经通过，胜利了
				nowBgNum ++;
				bgWalk = 0;//将背景的移动清零
				soldierCount = 0;//将小怪的数量清零
				role.setX(50);//改正主角的位置
				role.setY(270);
			}
		}
		//3暂停
		if (gameState == 3) {
			gImage.drawImage(GameUtils.title5Img,0,0,null);
			gImage.setColor(Color.red);
			gImage.setFont(new Font("仿宋",Font.BOLD+ Font.ITALIC,40));
			gImage.drawString("大人，战事紧急，还请速速回去", 200,350);
		}
		//4失败
		if (gameState == 4) {
			//绘制角色死后的图片
			gImage.drawImage(GameUtils.failImg, 380,100,null);
			if (role == role1) gImage.drawImage(GameUtils.did1Img,430,200,null);
			if (role == role2) gImage.drawImage(GameUtils.did2Img,430,200,null);
			if (role == role3) gImage.drawImage(GameUtils.did3Img,430,200,null);
			if (role == role4) gImage.drawImage(GameUtils.did4Img,430,200,null);
		}
		//5胜利
		if (gameState == 5) {
			gImage.drawImage(GameUtils.title9Img,0,0,null);
			gImage.setColor(Color.red);
			gImage.setFont(new Font("仿宋",Font.BOLD+ Font.ITALIC,40));
			gImage.drawString("胜利", 450,100);
		}
		//6按键介绍
		if (gameState == 6) {
			gImage.setColor(Color.red);
			gImage.setFont(new Font("仿宋",Font.BOLD+ Font.ITALIC,30));
			gImage.drawString("按键介绍", 380,80);
			gImage.setFont(new Font("仿宋",Font.BOLD+ Font.ITALIC,20));
			gImage.drawString("A：向左移动", 100,120);
			gImage.drawString("D：向右移动", 100,140);
			gImage.drawString("S：防御，减少敌人三分之二的攻击，但不能移动", 100,160);
			gImage.drawString("W：跳跃，冷却1秒", 100,180);
			gImage.drawString("J：拳击，可以在移动，跳跃时使用，无冷却", 100,200);
			gImage.drawString("K：飞踢，必须在点击跳跃的时候，点击K键方可使用，冷却0.5秒", 100,220);
			gImage.drawString("L：连击，又名王八拳，移动和跳跃会打断连击，冷却0.5秒", 100,240);
			gImage.drawString("I：技能，一直按压I键，来释放完整的技能，冷却3秒", 100,260);
			gImage.drawString("O：冲锋，向前突进一段距离，并对敌人造成伤害，冷却0.5秒", 100,280);
			gImage.drawString("游戏开始时，点击空格暂停游戏",100,320);
			gImage.drawString("死亡或胜利后，点击空格重新开始游戏",100,340);

			gImage.drawImage(GameUtils.returnImg,20,40,null);//返回的按钮
			gImage.drawImage(GameUtils.introduceEnemyImg,920,320,null);//下一个介绍的按钮
		}
		//7，8，9，10，四个主角的被动介绍
		if (gameState == 7 || gameState == 8 || gameState == 9 || gameState == 10){
			gImage.drawImage(GameUtils.title7Img,0,0,null);
			gImage.setColor(Color.red);
			gImage.setFont(new Font("仿宋",Font.BOLD+ Font.ITALIC,20));
			gImage.drawImage(GameUtils.begin2Img,400,300,null);//开始的按钮
			gImage.drawImage(GameUtils.returnImg,20,40,null);//返回的按钮
			//7关羽的被动介绍
			if (gameState == 7) {
				gImage.drawImage(GameUtils.header1Img,440,50,null);
				gImage.drawString("关羽",450,180);
				gImage.drawString("血量：4000，攻击：100，速度：5",310,240);
				gImage.drawString("被动：过五关斩六将：随着击杀敌人的数量增加，攻击力不断增加，每击杀一个敌人，增加2点攻击力", 60,280);
			}
			//8张飞的被动介绍
			if (gameState == 8) {
				gImage.drawImage(GameUtils.header2Img,440,50,null);
				gImage.drawString("张飞",450,180);
				gImage.drawString("血量：3400，攻击：80，速度：5",310,240);
				gImage.drawString("被动：愈战愈勇： 随着生命的降低，攻击力不断增加，每损失100生命值，增加1点的攻击力", 100,280);
			}
			//9赵云的被动介绍
			if (gameState == 9) {
				gImage.drawImage(GameUtils.header3Img,440,50,null);
				gImage.drawString("赵云",450,180);
				gImage.drawString("血量：2800，攻击：120，速度：6",310,240);
				gImage.drawString("被动：单枪匹马：在场的敌人数量越多，攻击力越高，场上每多1个敌人，攻击力增加5", 100,280);
				gImage.drawString("冷静的头脑：喝酒不会增加赵云的攻击力",290,300);
			}
			//10魏延的被动介绍
			if (gameState == 10) {
				gImage.drawImage(GameUtils.header4Img,440,50,null);
				gImage.drawString("魏延",450,180);
				gImage.drawString("血量：5000，攻击：50，速度：3",310,240);
				gImage.drawString("被动：以战养战：击杀敌人后，恢复所杀敌人血量的百分之十的血量", 160,280);
			}
		}
		//11敌人的介绍
		if (gameState == 11) {
			gImage.drawImage(GameUtils.title6Img,0,0,null);
			gImage.drawImage(GameUtils.returnImg,20,40,null);//返回的按钮
			gImage.setColor(Color.red);
			gImage.setFont(new Font("仿宋",Font.ITALIC,10));
			gImage.drawImage(GameUtils.stand_REnemyImg1,40,100,null);//小怪1
			gImage.drawString("蛮兵，血量：1000，攻击：2",10,220);
			gImage.drawImage(GameUtils.stand_REnemyImg2,190,100,null);//小怪2
			gImage.drawString("枪兵，血量：1000，攻击：3",160,220);
			gImage.drawImage(GameUtils.stand_REnemyImg3,360,120,null);//小怪3
			gImage.drawString("重刀兵，血量：1000，攻击：5",320,220);
			gImage.drawImage(GameUtils.stand_REnemyImg4,520,110,null);//小怪4
			gImage.drawString("刺客，血量：1000，攻击：6",480,220);
			gImage.drawImage(GameUtils.stand_REnemyImg5,670,110,null);//小怪5
			gImage.drawString("重锤兵，血量：1000，攻击：8",630,220);
			gImage.drawImage(GameUtils.stand_RBossImg1,30,260,null);//Boss1
			gImage.drawString("Boss1，血量：4000，攻击：6",10,390);
			gImage.drawImage(GameUtils.stand_RBossImg2,150,260,null);//Boss2
			gImage.drawString("Boss2，血量：4000，攻击：9",170,390);
			gImage.drawImage(GameUtils.stand_RBossImg3,330,250,null);//Boss3
			gImage.drawString("Boss3，血量：4000，攻击：12",320,390);
			//食物的介绍
			gImage.drawImage(GameUtils.food1Img,510,340,null);//Boss3
			gImage.drawString("包子：恢复100血量",480,390);
			gImage.drawImage(GameUtils.food2Img,600,340,null);//Boss3
			gImage.drawString("鸡肉：恢复200血量",580,390);
			gImage.drawImage(GameUtils.food3Img,690,340,null);//Boss3
			gImage.drawString("猪肉：恢复300血量",680,390);
			gImage.drawImage(GameUtils.drinkImg,790,330,null);//Boss3
			gImage.drawString("酒：增加10攻击力",780,390);
		}
		//12开始游戏的进度条
		if (gameState == 12) {
			gImage.drawImage(GameUtils.title8Img,0,0,null);
			gImage.drawImage(GameUtils.waitImg,0,350,null);
			//绘制临时的小怪走路
			gImage.drawImage(temporaryEnemy.getShow(),temporaryEnemy.getX(),temporaryEnemy.getY(),null);
			temporaryEnemy.rightMove();
			if (temporaryEnemy.getX() >= 920) gameState = 2;
			gImage.setColor(Color.red);
			gImage.setFont(new Font("仿宋",Font.ITALIC,20));
			int n = (int)(Math.random()*6);
			switch (n) {
				case 0:
					gImage.drawString("据说曹公极好人妻......",760,400);
					break;
				case 1:
					gImage.drawString("追杀曹贼中......",760,400);
					break;
				case 2:
					gImage.drawString("正在赶往战场......",760,400);
					break;
				case 3:
					gImage.drawString("曹贼!!!哪里逃......",760,400);
					break;
				case 4:
					gImage.drawString("匡扶汉室......",760,400);
					break;
				case 5:
					gImage.drawString("敌人正在赶来的路上......",760,400);
					break;
			}
		}
		
		appearEnemySpeed++;
		//绘制双缓存图片
		g.drawImage(offScreenImg,0,0,null);
	}
	
	//键盘控制
	class KeyMonitor extends KeyAdapter{
		//按下键盘
		@Override
		public void keyPressed(KeyEvent e) {	
			//按压空格键
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				//暂停功能
				if (gameState == 2) {
					gameState = 3;
				}else if (gameState == 3) {
					gameState = 2;
				}
				//重新开始功能
				if (gameState == 4 || gameState == 5) {
					gameState = 1;
					init();//初始化一切
					creatObj();//重新创建敌人
				}
			}
			if(gameState == 2) role.keyPressed(e);//进入了游戏，开始通过键盘按压来控制人物移动
		}
		//松开键盘
		@Override
		public void keyReleased(KeyEvent e) {
			if (gameState == 2) role.keyReleased(e);
		}
	}
}
