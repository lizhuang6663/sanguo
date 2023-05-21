package SanGuo;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;


public class GameUtils {
	//背景
	public static Image bg1Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/Round6.png");
	public static Image bg2Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/Round1.png");
	public static Image bg3Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/Round2.png");
	public static Image title1Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/show/title1.png");
	public static Image title2Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/show/title2.png");
	public static Image title3Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/show/title3.png");
	public static Image title4Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/show/title4.png");
	public static Image title5Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/show/title5.png");
	public static Image title6Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/show/title6.png");
	public static Image title7Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/show/title7.png");
	public static Image title8Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/show/title8.png");
	public static Image title9Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/show/title9.png");
	public static Image waitImg = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/show/wait.png");
	public static Image begin1Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/show/begin1.png");
	public static Image begin2Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/show/begin2.png");
	public static Image helpImg = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/show/help.png");
	public static Image returnImg = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/show/return.png");
	public static Image failImg = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/show/fail.png");
	public static Image introduceEnemyImg = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/show/introduceEnemy.png");
	public static Image bloodImg = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/show/blood.png");
	public static Image atkImg = Toolkit.getDefaultToolkit().getImage("imgs/res改正/5.场景/show/atk.png");
	//道具
	public static Image food1Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/6.道具/food1.png");
	public static Image food2Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/6.道具/food2.png");
	public static Image food3Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/6.道具/food3.png");
	public static Image drinkImg = Toolkit.getDefaultToolkit().getImage("imgs/res改正/6.道具/drink.png");
	//人物头像
	public static Image header1Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/关羽头像.png");
	public static Image header2Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/张飞头像.png");
	public static Image header3Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/赵云头像.png");
	public static Image header4Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/魏延头像.png");
	//人物死亡
	public static Image did1Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/关羽死亡.png");
	public static Image did2Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/张飞死亡.png");
	public static Image did3Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/赵云死亡.png");
	public static Image did4Img = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/魏延死亡.png");
	
	//关羽
	public static float hp1 = 4000;//关羽的血量
	public static float atk1 = 100;//关羽的攻击
	public static int walkSpeed1 = 5;//关羽的速度
	public static Image stand_LImg1 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.L关羽/0.png");//向左站立
	public static Image stand_RImg1 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.R关羽/0.png");//向右站立
	public static Image defend_LImg1 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.L关羽/95.png");//防御
	public static Image defend_RImg1 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.R关羽/95.png");//防御
	public static List<Image> run_LListImg1 = new ArrayList<>();//向左跑
	public static List<Image> run_RListImg1 = new ArrayList<>();//向右跑
	public static List<Image> jump_LListImg1 = new ArrayList<>();//向左跳跃
	public static List<Image> jump_RListImg1 = new ArrayList<>();//向右跳跃
	public static List<Image> cut_LListImg1 = new ArrayList<>();//向左攻击
	public static List<Image> cut_RListImg1 = new ArrayList<>();//向右攻击
	public static List<Image> flyKick_LListImg1 = new ArrayList<>();//飞踢向左攻击
	public static List<Image> flyKick_RListImg1 = new ArrayList<>();//飞踢向右攻击
	public static List<Image> longAttack_LListImg1 = new ArrayList<>();//连击，向左
	public static List<Image> longAttack_RListImg1 = new ArrayList<>();//连击，向右
	public static List<Image> skill_LListImg1 = new ArrayList<>();//技能左
	public static List<Image> skill_RListImg1 = new ArrayList<>();//技能右
	public static List<Image> quickGo_LListImg1 = new ArrayList<>();//冲锋左
	public static List<Image> quickGo_RListImg1 = new ArrayList<>();//冲锋右
	//张飞
	public static float hp2 = 3400;//张飞的血量
	public static float atk2 = 80;//张飞的攻击
	public static int walkSpeed2 = 5;//张飞的速度
	public static Image stand_LImg2 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.L张飞/0.png");//向左站立
	public static Image stand_RImg2 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.R张飞/0.png");//向右站立
	public static Image defend_LImg2 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.L张飞/115.png");//防御
	public static Image defend_RImg2 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.R张飞/115.png");//防御
	public static List<Image> run_LListImg2 = new ArrayList<>();//向左跑
	public static List<Image> run_RListImg2 = new ArrayList<>();//向右跑
	public static List<Image> jump_LListImg2 = new ArrayList<>();//向左跳跃
	public static List<Image> jump_RListImg2 = new ArrayList<>();//向右跳跃
	public static List<Image> cut_LListImg2 = new ArrayList<>();//向左攻击
	public static List<Image> cut_RListImg2 = new ArrayList<>();//向右攻击
	public static List<Image> flyKick_LListImg2 = new ArrayList<>();//飞踢向左攻击
	public static List<Image> flyKick_RListImg2 = new ArrayList<>();//飞踢向右攻击
	public static List<Image> longAttack_LListImg2 = new ArrayList<>();//连击，向左
	public static List<Image> longAttack_RListImg2 = new ArrayList<>();//连击，向右
	public static List<Image> skill_LListImg2 = new ArrayList<>();//技能左
	public static List<Image> skill_RListImg2 = new ArrayList<>();//技能右
	public static List<Image> quickGo_LListImg2 = new ArrayList<>();//冲锋左
	public static List<Image> quickGo_RListImg2 = new ArrayList<>();//冲锋右
	//赵云
	public static float hp3 = 2800;//赵云的血量
	public static float atk3 = 120;//赵云的攻击
	public static int walkSpeed3 = 6;//赵云的速度
	public static Image stand_LImg3 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.L赵云/0.png");//向左站立
	public static Image stand_RImg3 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.R赵云/0.png");//向右站立
	public static Image defend_LImg3 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.L赵云/48.png");//防御
	public static Image defend_RImg3 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.R赵云/48.png");//防御
	public static List<Image> run_LListImg3 = new ArrayList<>();//向左跑
	public static List<Image> run_RListImg3 = new ArrayList<>();//向右跑
	public static List<Image> jump_LListImg3 = new ArrayList<>();//向左跳跃
	public static List<Image> jump_RListImg3 = new ArrayList<>();//向右跳跃
	public static List<Image> cut_LListImg3 = new ArrayList<>();//向左攻击
	public static List<Image> cut_RListImg3 = new ArrayList<>();//向右攻击
	public static List<Image> flyKick_LListImg3 = new ArrayList<>();//飞踢向左攻击
	public static List<Image> flyKick_RListImg3 = new ArrayList<>();//飞踢向右攻击
	public static List<Image> longAttack_LListImg3 = new ArrayList<>();//连击，向左
	public static List<Image> longAttack_RListImg3 = new ArrayList<>();//连击，向右
	public static List<Image> skill_LListImg3 = new ArrayList<>();//技能左
	public static List<Image> skill_RListImg3 = new ArrayList<>();//技能右
	public static List<Image> quickGo_LListImg3 = new ArrayList<>();//冲锋左
	public static List<Image> quickGo_RListImg3 = new ArrayList<>();//冲锋右
	//魏延
	public static float hp4 = 5000;//魏延的血量
	public static float atk4 = 50;//魏延的攻击
	public static int walkSpeed4 = 3;//魏延的速度
	public static Image stand_LImg4 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.L魏延/0.png");//向左站立
	public static Image stand_RImg4 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.R魏延/0.png");//向右站立
	public static Image defend_LImg4 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.L魏延/103.png");//防御
	public static Image defend_RImg4 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.R魏延/103.png");//防御
	public static List<Image> run_LListImg4 = new ArrayList<>();//向左跑
	public static List<Image> run_RListImg4 = new ArrayList<>();//向右跑
	public static List<Image> jump_LListImg4 = new ArrayList<>();//向左跳跃
	public static List<Image> jump_RListImg4 = new ArrayList<>();//向右跳跃
	public static List<Image> cut_LListImg4 = new ArrayList<>();//向左攻击
	public static List<Image> cut_RListImg4 = new ArrayList<>();//向右攻击
	public static List<Image> flyKick_LListImg4 = new ArrayList<>();//飞踢向左攻击
	public static List<Image> flyKick_RListImg4 = new ArrayList<>();//飞踢向右攻击
	public static List<Image> longAttack_LListImg4 = new ArrayList<>();//连击，向左
	public static List<Image> longAttack_RListImg4 = new ArrayList<>();//连击，向右
	public static List<Image> skill_LListImg4 = new ArrayList<>();//技能左
	public static List<Image> skill_RListImg4 = new ArrayList<>();//技能右
	public static List<Image> quickGo_LListImg4 = new ArrayList<>();//冲锋左
	public static List<Image> quickGo_RListImg4 = new ArrayList<>();//冲锋右
	
	//存放小怪
	public static List<Enemy> enemyListImg = new ArrayList<>();
	//存放Boss元素
	public static List<Enemy> bossListImg = new ArrayList<>();
	//需要删除敌人元素
	public static List<Enemy> removeEnemyListImg = new ArrayList<>();
	//存放道具
	public static List<GameObj> gameObjListImg = new ArrayList<>();
	//需要删除道具元素
	public static List<GameObj> removeObjListImg = new ArrayList<>();
	
	//因为图片刷新的很快，所以要将敌人的攻击力设置的小一点，最好是三的倍数，因为主角的防御状态会降低敌方三分之二的攻击
	//小怪1
	public static float hpEnemy1 = 1000;//第一种敌人的血量
	public static float atkEnemy1 = 2;//第一种敌人的攻击
	public static int walkSpeedEnemy1 = 3;//第一种敌人的速度
	public static Image stand_LEnemyImg1 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.L蛮兵/0.png");//向左站立
	public static Image stand_REnemyImg1 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.R蛮兵/0.png");//向右站立
	public static List<Image> run_LEnemyListImg1 = new ArrayList<>();//移动
	public static List<Image> run_REnemyListImg1 = new ArrayList<>();
	public static List<Image> cut_LEnemyListImg1 = new ArrayList<>();//攻击
	public static List<Image> cut_REnemyListImg1 = new ArrayList<>();
	public static List<Image> skill_LEnemyListImg1 = new ArrayList<>();//技能
	public static List<Image> skill_REnemyListImg1 = new ArrayList<>();
	public static List<Image> quickGo_LEnemyListImg1 = new ArrayList<>();//冲锋
	public static List<Image> quickGo_REnemyListImg1 = new ArrayList<>();
	//小怪2，由于小怪在同一个列表中，当绘制血条时，会出现问题，只能将小怪的血量设为相同的了
	public static float hpEnemy2 = 1000;//第2种敌人的血量
	public static float atkEnemy2 = 3;//第2种敌人的攻击
	public static int walkSpeedEnemy2 = 3;//第2种敌人的速度
	public static Image stand_LEnemyImg2 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.L枪兵/0.png");//向左站立
	public static Image stand_REnemyImg2 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.R枪兵/0.png");//向右站立
	public static List<Image> run_LEnemyListImg2 = new ArrayList<>();//向左跑
	public static List<Image> run_REnemyListImg2 = new ArrayList<>();//向右跑
	public static List<Image> cut_LEnemyListImg2 = new ArrayList<>();//向左攻击
	public static List<Image> cut_REnemyListImg2 = new ArrayList<>();//向右攻击
	public static List<Image> skill_LEnemyListImg2 = new ArrayList<>();//向左技能
	public static List<Image> skill_REnemyListImg2 = new ArrayList<>();//向右技能
	public static List<Image> quickGo_LEnemyListImg2 = new ArrayList<>();//冲锋
	public static List<Image> quickGo_REnemyListImg2 = new ArrayList<>();
	//小怪3
	public static float hpEnemy3 = 1000;//第3种敌人的血量
	public static float atkEnemy3 = 5;//第3种敌人的攻击
	public static int walkSpeedEnemy3 = 5;//第3种敌人的速度
	public static Image stand_LEnemyImg3 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.L重刀兵/0.png");//向左站立
	public static Image stand_REnemyImg3 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.R重刀兵/0.png");//向右站立
	public static List<Image> run_LEnemyListImg3 = new ArrayList<>();//向左跑
	public static List<Image> run_REnemyListImg3 = new ArrayList<>();//向右跑
	public static List<Image> cut_LEnemyListImg3 = new ArrayList<>();//向左攻击
	public static List<Image> cut_REnemyListImg3 = new ArrayList<>();//向右攻击
	public static List<Image> skill_LEnemyListImg3 = new ArrayList<>();//向左技能
	public static List<Image> skill_REnemyListImg3 = new ArrayList<>();//向右技能
	public static List<Image> quickGo_LEnemyListImg3 = new ArrayList<>();//冲锋
	public static List<Image> quickGo_REnemyListImg3 = new ArrayList<>();
	//小怪4
	public static float hpEnemy4 = 1000;//第4种敌人的血量
	public static float atkEnemy4 = 7;//第4种敌人的攻击
	public static int walkSpeedEnemy4 = 6;//第4种敌人的速度
	public static Image stand_LEnemyImg4 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/4.L刺客/0.png");//向左站立
	public static Image stand_REnemyImg4 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/4.R刺客/0.png");//向右站立
	public static List<Image> run_LEnemyListImg4 = new ArrayList<>();//向左跑
	public static List<Image> run_REnemyListImg4 = new ArrayList<>();//向右跑
	public static List<Image> cut_LEnemyListImg4 = new ArrayList<>();//向左攻击
	public static List<Image> cut_REnemyListImg4 = new ArrayList<>();//向右攻击
	public static List<Image> skill_LEnemyListImg4 = new ArrayList<>();//向左技能
	public static List<Image> skill_REnemyListImg4 = new ArrayList<>();//向右技能
	public static List<Image> quickGo_LEnemyListImg4 = new ArrayList<>();//冲锋
	public static List<Image> quickGo_REnemyListImg4 = new ArrayList<>();
	//小怪5
	public static float hpEnemy5 = 1000;//第5种敌人的血量
	public static float atkEnemy5 = 8;//第5种敌人的攻击
	public static int walkSpeedEnemy5 = 3;//第3种敌人的速度
	public static Image stand_LEnemyImg5 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/5.L重锤兵/0.png");//向左站立
	public static Image stand_REnemyImg5 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/5.R重锤兵/0.png");//向右站立
	public static List<Image> run_LEnemyListImg5 = new ArrayList<>();//向左跑
	public static List<Image> run_REnemyListImg5 = new ArrayList<>();//向右跑
	public static List<Image> cut_LEnemyListImg5 = new ArrayList<>();//向左攻击
	public static List<Image> cut_REnemyListImg5 = new ArrayList<>();//向右攻击
	public static List<Image> skill_LEnemyListImg5 = new ArrayList<>();//向左技能
	public static List<Image> skill_REnemyListImg5 = new ArrayList<>();//向右技能
	public static List<Image> quickGo_LEnemyListImg5 = new ArrayList<>();//冲锋
	public static List<Image> quickGo_REnemyListImg5 = new ArrayList<>();

	//Boss1
	public static float hpBoss1 = 4000;//第一种Boss的血量
	public static float atkBoss1 = 6;//第一种Boss的攻击力
	public static int walkSpeedBoss1 = 6;//第一种Boss的速度
	public static Image stand_LBossImg1 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.LBoss/0.png");//向左站立
	public static Image stand_RBossImg1 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.RBoss/0.png");//向右站立
	public static List<Image> run_LBossListImg1 = new ArrayList<>();//向左跑
	public static List<Image> run_RBossListImg1 = new ArrayList<>();//向右跑
	public static List<Image> cut_LBossListImg1 = new ArrayList<>();//向左攻击
	public static List<Image> cut_RBossListImg1 = new ArrayList<>();//向右攻击
	public static List<Image> skill_LBossListImg1 = new ArrayList<>();//技能左
	public static List<Image> skill_RBossListImg1 = new ArrayList<>();//技能右
	public static List<Image> quickGo_LBossListImg1 = new ArrayList<>();//冲锋
	public static List<Image> quickGo_RBossListImg1 = new ArrayList<>();
	//Boss2
	public static float hpBoss2 = 4000;//第2种Boss的血量
	public static float atkBoss2 = 9;//第2种Boss的攻击力
	public static int walkSpeedBoss2 = 6;//第2种Boss的速度
	public static Image stand_LBossImg2 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.LBoss/0.png");//向左站立
	public static Image stand_RBossImg2 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.RBoss/0.png");//向右站立
	public static List<Image> run_LBossListImg2 = new ArrayList<>();//向左跑
	public static List<Image> run_RBossListImg2 = new ArrayList<>();//向右跑
	public static List<Image> cut_LBossListImg2 = new ArrayList<>();//向左攻击
	public static List<Image> cut_RBossListImg2 = new ArrayList<>();//向右攻击
	public static List<Image> skill_LBossListImg2 = new ArrayList<>();//技能左
	public static List<Image> skill_RBossListImg2 = new ArrayList<>();//技能右
	public static List<Image> quickGo_LBossListImg2 = new ArrayList<>();//冲锋
	public static List<Image> quickGo_RBossListImg2 = new ArrayList<>();
	//Boss3
	public static float hpBoss3 = 4000;//第3种Boss的血量
	public static float atkBoss3 = 12;//第3种Boss的攻击力
	public static int walkSpeedBoss3 = 8;//第3种Boss的速度
	public static Image stand_LBossImg3 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.LBoss/0.png");//向左站立
	public static Image stand_RBossImg3 = Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.RBoss/0.png");//向右站立
	public static List<Image> run_LBossListImg3 = new ArrayList<>();//向左跑
	public static List<Image> run_RBossListImg3 = new ArrayList<>();//向右跑
	public static List<Image> cut_LBossListImg3 = new ArrayList<>();//向左攻击
	public static List<Image> cut_RBossListImg3 = new ArrayList<>();//向右攻击
	public static List<Image> skill_LBossListImg3 = new ArrayList<>();//技能左
	public static List<Image> skill_RBossListImg3 = new ArrayList<>();//技能右
	public static List<Image> quickGo_LBossListImg3 = new ArrayList<>();//冲锋
	public static List<Image> quickGo_RBossListImg3 = new ArrayList<>();


	//初始化图片集合
	public static void init() {
		//关羽，移动
		for (int i = 1;i<=8 ;i++) run_LListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.L关羽/"+i+".png"));
		for (int i = 1;i<=8 ;i++) run_RListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.R关羽/"+i+".png"));
		//跳跃 (4张跳跃图片刷新的太快了，点击一下跳跃键，跳跃图片循环了4次，所以想了个歪招)
		for (int i = 1;i<=3;i++) jump_LListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.L关羽/49.png"));
		for (int i = 1;i<=5;i++) jump_LListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.L关羽/50.png"));
		for (int i = 1;i<=8;i++) jump_LListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.L关羽/51.png"));
		for (int i = 1;i<=5;i++) jump_LListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.L关羽/52.png"));
		for (int i = 1;i<=3;i++) jump_RListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.R关羽/49.png"));
		for (int i = 1;i<=5;i++) jump_RListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.R关羽/50.png"));
		for (int i = 1;i<=8;i++) jump_RListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.R关羽/51.png"));
		for (int i = 1;i<=5;i++) jump_RListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.R关羽/52.png"));
		//攻击
		for (int i = 9;i<= 11 ;i++) cut_LListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.L关羽/"+i+".png"));
		for (int i = 9;i<= 11 ;i++) cut_RListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.R关羽/"+i+".png"));
		//飞踢
		for (int i = 54;i<= 58;i++) flyKick_LListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.L关羽/"+i+".png"));
		for (int i = 54;i<= 58;i++) flyKick_RListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.R关羽/"+i+".png"));
		//连击
		for (int i = 12;i<= 20;i++) longAttack_LListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.L关羽/"+i+".png"));
		for (int i = 12;i<= 20;i++) longAttack_RListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.R关羽/"+i+".png"));
		//技能
		for (int i = 132;i<= 138;i++) skill_LListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.L关羽/"+i+".png"));
		for (int i = 163;i<= 166;i++) skill_LListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.L关羽/"+i+".png"));
		for (int i = 132;i<= 138;i++) skill_RListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.R关羽/"+i+".png"));
		for (int i = 163;i<= 166;i++) skill_RListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.R关羽/"+i+".png"));
		//冲锋
		for (int i = 40;i<=42;i++) quickGo_LListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.L关羽/"+i+".png"));
		for (int i = 40;i<=42;i++) quickGo_RListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/1.R关羽/"+i+".png"));
		
		//张飞，移动
		for (int i = 1;i<=8;i++) run_LListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.L张飞/"+i+".png"));
		for (int i = 1;i<=8;i++) run_RListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.R张飞/"+i+".png"));
		//跳跃
		for (int i = 1;i<=3;i++) jump_LListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.L张飞/63.png"));
		for (int i = 1;i<=5;i++) jump_LListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.L张飞/65.png"));
		for (int i = 1;i<=8;i++) jump_LListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.L张飞/66.png"));
		for (int i = 1;i<=5;i++) jump_LListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.L张飞/67.png"));
		for (int i = 1;i<=3;i++) jump_RListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.R张飞/63.png"));
		for (int i = 1;i<=5;i++) jump_RListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.R张飞/65.png"));
		for (int i = 1;i<=8;i++) jump_RListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.R张飞/66.png"));
		for (int i = 1;i<=5;i++) jump_RListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.R张飞/67.png"));
		//攻击
		for (int i = 9;i<=11;i++) cut_LListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.L张飞/"+i+".png"));
		for (int i = 9;i<=11;i++) cut_RListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.R张飞/"+i+".png"));
		//飞踢
		for (int i = 73;i<=78;i++) flyKick_LListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.L张飞/"+i+".png"));
		for (int i = 73;i<=78;i++) flyKick_RListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.R张飞/"+i+".png"));
		//连击
		for (int i = 12;i<=18;i++) longAttack_LListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.L张飞/"+i+".png"));
		for (int i = 12;i<=18;i++) longAttack_RListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.R张飞/"+i+".png"));
		//技能
		for (int i = 151;i<=153;i++) skill_LListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.L张飞/"+i+".png"));
		for (int i = 210;i<=217;i++) skill_LListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.L张飞/"+i+".png"));
		for (int i = 151;i<=153;i++) skill_RListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.R张飞/"+i+".png"));
		for (int i = 210;i<=217;i++) skill_RListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.R张飞/"+i+".png"));
		//冲锋
		for (int i = 60;i<=62;i++) quickGo_LListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.L张飞/"+i+".png"));
		for (int i = 60;i<=62;i++) quickGo_RListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/2.R张飞/"+i+".png"));
		
		//赵云，移动
		for (int i = 1;i<=8;i++) run_LListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.L赵云/"+i+".png"));
		for (int i = 1;i<=8;i++) run_RListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.R赵云/"+i+".png"));
		//跳跃
		for (int i = 1;i<=3;i++) jump_LListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.L赵云/9.png"));
		for (int i = 1;i<=5;i++) jump_LListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.L赵云/10.png"));
		for (int i = 1;i<=8;i++) jump_LListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.L赵云/11.png"));
		for (int i = 1;i<=5;i++) jump_LListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.L赵云/12.png"));
		for (int i = 1;i<=3;i++) jump_RListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.R赵云/9.png"));
		for (int i = 1;i<=5;i++) jump_RListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.R赵云/10.png"));
		for (int i = 1;i<=8;i++) jump_RListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.R赵云/11.png"));
		for (int i = 1;i<=5;i++) jump_RListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.R赵云/12.png"));
		//攻击
		for (int i = 16;i<=21;i++) cut_LListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.L赵云/"+i+".png"));
		for (int i = 16;i<=21;i++) cut_RListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.R赵云/"+i+".png"));
		//飞踢
		for (int i = 13;i<=15;i++) flyKick_LListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.L赵云/"+i+".png"));
		for (int i = 13;i<=15;i++) flyKick_RListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.R赵云/"+i+".png"));
		//连击
		for (int i = 22;i<=28;i++) longAttack_LListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.L赵云/"+i+".png"));
		for (int i = 22;i<=28;i++) longAttack_RListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.R赵云/"+i+".png"));
		//技能
		for (int i = 33;i<=39;i++) skill_LListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.L赵云/"+i+".png"));
		for (int i = 33;i<=39;i++) skill_RListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.R赵云/"+i+".png"));
		//冲锋
		for (int i = 42;i<=46;i++) quickGo_LListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.L赵云/"+i+".png"));
		for (int i = 42;i<=46;i++) quickGo_RListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/3.R赵云/"+i+".png"));
		
		//魏延，移动
		for (int i = 1;i<=8;i++) run_LListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.L魏延/"+i+".png"));
		for (int i = 1;i<=8;i++) run_RListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.R魏延/"+i+".png"));
		//跳跃
		for (int i = 1;i<=3;i++) jump_LListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.L魏延/52.png"));
		for (int i = 1;i<=5;i++) jump_LListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.L魏延/54.png"));
		for (int i = 1;i<=8;i++) jump_LListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.L魏延/55.png"));
		for (int i = 1;i<=5;i++) jump_LListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.L魏延/56.png"));
		for (int i = 1;i<=3;i++) jump_RListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.R魏延/52.png"));
		for (int i = 1;i<=5;i++) jump_RListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.R魏延/54.png"));
		for (int i = 1;i<=8;i++) jump_RListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.R魏延/55.png"));
		for (int i = 1;i<=5;i++) jump_RListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.R魏延/56.png"));
		//攻击
		for (int i = 12;i<=16;i++) cut_LListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.L魏延/"+i+".png"));
		for (int i = 12;i<=16;i++) cut_RListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.R魏延/"+i+".png"));
		//飞踢
		for (int i = 57;i<=62;i++) flyKick_LListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.L魏延/"+i+".png"));
		for (int i = 57;i<=62;i++) flyKick_RListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.R魏延/"+i+".png"));
		//连击
		for (int i = 17;i<=21;i++) longAttack_LListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.L魏延/"+i+".png"));
		for (int i = 37;i<=40;i++) longAttack_LListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.L魏延/"+i+".png"));
		for (int i = 17;i<=21;i++) longAttack_RListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.R魏延/"+i+".png"));
		for (int i = 37;i<=40;i++) longAttack_RListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.R魏延/"+i+".png"));
		//技能
		for (int i = 167;i<=172;i++) skill_LListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.L魏延/"+i+".png"));
		for (int i = 154;i<=157;i++) skill_LListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.L魏延/"+i+".png"));
		for (int i = 167;i<=172;i++) skill_RListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.R魏延/"+i+".png"));
		for (int i = 154;i<=157;i++) skill_RListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.R魏延/"+i+".png"));
		//冲锋
		for (int i = 41;i<=43;i++) quickGo_LListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.L魏延/"+i+".png"));
		for (int i = 41;i<=43;i++) quickGo_RListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/1.主角/4.R魏延/"+i+".png"));
		
		//小怪1
		for (int i = 1;i<=6;i++) run_LEnemyListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.L蛮兵/"+i+".png"));//移动
		for (int i = 1;i<=6;i++) run_REnemyListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.R蛮兵/"+i+".png"));
		for (int i = 8;i<=12;i++) cut_LEnemyListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.L蛮兵/"+i+".png"));//攻击
		for (int i = 8;i<=12;i++) cut_REnemyListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.R蛮兵/"+i+".png"));
		for (int i = 17;i<=20;i++) skill_LEnemyListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.L蛮兵/"+i+".png"));//技能
		for (int i = 17;i<=20;i++) skill_REnemyListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.R蛮兵/"+i+".png"));
		
		for (int i = 1;i<=2;i++) quickGo_LEnemyListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.L蛮兵/6.png"));
		for (int i = 1;i<=3;i++) quickGo_LEnemyListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.L蛮兵/7.png"));
		for (int i = 1;i<=2;i++) quickGo_LEnemyListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.L蛮兵/8.png"));
		for (int i = 1;i<=2;i++) quickGo_REnemyListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.R蛮兵/6.png"));
		for (int i = 1;i<=3;i++) quickGo_REnemyListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.R蛮兵/7.png"));
		for (int i = 1;i<=2;i++) quickGo_REnemyListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.R蛮兵/8.png"));
		/*
		for (int i = 6;i<=8;i++) quickGo_LEnemyListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.L蛮兵/"+i+".png"));
		for (int i = 6;i<=8;i++) quickGo_REnemyListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.R蛮兵/"+i+".png"));
		*/
		//小怪2
		for (int i = 1;i<=5;i++) run_LEnemyListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.L枪兵/"+i+".png"));//移动
		for (int i = 1;i<=5;i++) run_REnemyListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.R枪兵/"+i+".png"));
		for (int i = 17;i<=20;i++) cut_LEnemyListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.L枪兵/"+i+".png"));//攻击
		for (int i = 17;i<=20;i++) cut_REnemyListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.R枪兵/"+i+".png"));
		for (int i = 12;i<=15;i++) skill_LEnemyListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.L枪兵/"+i+".png"));//技能
		for (int i = 12;i<=15;i++) skill_REnemyListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.R枪兵/"+i+".png"));
		for (int i = 19;i<=21;i++) quickGo_LEnemyListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.L枪兵/"+i+".png"));//技能
		for (int i = 19;i<=21;i++) quickGo_REnemyListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.R枪兵/"+i+".png"));//技能
		//小怪3
		for (int i = 1;i<=2;i++) run_LEnemyListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.L重刀兵/"+i+".png"));//移动
		for (int i = 1;i<=2;i++) run_REnemyListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.R重刀兵/"+i+".png"));
		for (int i = 3;i<=5;i++) cut_LEnemyListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.L重刀兵/"+i+".png"));//攻击
		for (int i = 3;i<=5;i++) cut_REnemyListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.R重刀兵/"+i+".png"));
		for (int i = 6;i<=8;i++) skill_LEnemyListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.L重刀兵/"+i+".png"));//技能
		for (int i = 6;i<=8;i++) skill_REnemyListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.R重刀兵/"+i+".png"));
		for (int i = 19;i<=21;i++) quickGo_LEnemyListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.L重刀兵/"+i+".png"));//技能
		for (int i = 19;i<=21;i++) quickGo_REnemyListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.R重刀兵/"+i+".png"));//技能
		//小怪4
		for (int i = 1;i<=5;i++) run_LEnemyListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/4.L刺客/"+i+".png"));//移动
		for (int i = 1;i<=5;i++) run_REnemyListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/4.R刺客/"+i+".png"));
		for (int i = 6;i<=8;i++) cut_LEnemyListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/4.L刺客/"+i+".png"));//攻击
		for (int i = 6;i<=8;i++) cut_REnemyListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/4.R刺客/"+i+".png"));
		for (int i = 9;i<=12;i++) skill_LEnemyListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/4.L刺客/"+i+".png"));//技能
		for (int i = 9;i<=12;i++) skill_REnemyListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/4.R刺客/"+i+".png"));
		for (int i = 18;i<=20;i++) quickGo_LEnemyListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/4.L刺客/"+i+".png"));//技能
		for (int i = 18;i<=20;i++) quickGo_REnemyListImg4.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/4.R刺客/"+i+".png"));//技能
		//小怪5
		for (int i = 1;i<=4;i++) run_LEnemyListImg5.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/5.L重锤兵/"+i+".png"));//移动
		for (int i = 1;i<=4;i++) run_REnemyListImg5.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/5.R重锤兵/"+i+".png"));
		for (int i = 5;i<=7;i++) cut_LEnemyListImg5.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/5.L重锤兵/"+i+".png"));//攻击
		for (int i = 5;i<=7;i++) cut_REnemyListImg5.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/5.R重锤兵/"+i+".png"));
		for (int i = 8;i<=11;i++) skill_LEnemyListImg5.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/5.L重锤兵/"+i+".png"));//技能
		for (int i = 8;i<=11;i++) skill_REnemyListImg5.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/5.R重锤兵/"+i+".png"));
		for (int i = 20;i<=22;i++) quickGo_LEnemyListImg5.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/5.L重锤兵/"+i+".png"));//技能
		for (int i = 20;i<=22;i++) quickGo_REnemyListImg5.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/5.R重锤兵/"+i+".png"));//技能
		//Boss1
		for (int i = 1;i<=5;i++) run_LBossListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.LBoss/"+i+".png"));//移动
		for (int i = 1;i<=5;i++) run_RBossListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.RBoss/"+i+".png"));
		for (int i = 8;i<=12;i++) cut_LBossListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.LBoss/"+i+".png"));//攻击
		for (int i = 8;i<=12;i++) cut_RBossListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.RBoss/"+i+".png"));
		for (int i = 17;i<=21;i++) skill_LBossListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.LBoss/"+i+".png"));//技能
		for (int i = 17;i<=21;i++) skill_RBossListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.RBoss/"+i+".png"));
		for (int i = 23;i<=25;i++) quickGo_LBossListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.LBoss/"+i+".png"));//技能
		for (int i = 23;i<=25;i++) quickGo_RBossListImg1.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/1.RBoss/"+i+".png"));//技能
		//Boss2
		for (int i = 1;i<=4;i++) run_LBossListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.LBoss/"+i+".png"));//移动
		for (int i = 1;i<=4;i++) run_RBossListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.RBoss/"+i+".png"));
		for (int i = 5;i<=8;i++) cut_LBossListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.LBoss/"+i+".png"));//攻击
		for (int i = 5;i<=8;i++) cut_RBossListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.RBoss/"+i+".png"));
		for (int i = 9;i<=10;i++) skill_LBossListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.LBoss/"+i+".png"));//技能
		for (int i = 9;i<=10;i++) skill_RBossListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.RBoss/"+i+".png"));
		for (int i = 11;i<=13;i++) quickGo_LBossListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.LBoss/"+i+".png"));//技能
		for (int i = 11;i<=13;i++) quickGo_RBossListImg2.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/2.RBoss/"+i+".png"));//技能
		//Boss2		
		for (int i = 1;i<=4;i++) run_LBossListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.LBoss/"+i+".png"));//移动
		for (int i = 1;i<=4;i++) run_RBossListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.RBoss/"+i+".png"));
		for (int i = 5;i<=9;i++) cut_LBossListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.LBoss/"+i+".png"));//攻击
		for (int i = 5;i<=9;i++) cut_RBossListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.RBoss/"+i+".png"));
		for (int i = 10;i<=14;i++) skill_LBossListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.LBoss/"+i+".png"));//技能
		for (int i = 10;i<=14;i++) skill_RBossListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.RBoss/"+i+".png"));
		for (int i = 14;i<=16;i++) quickGo_LBossListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.LBoss/"+i+".png"));//技能
		for (int i = 14;i<=16;i++) quickGo_RBossListImg3.add(Toolkit.getDefaultToolkit().getImage("imgs/res改正/3.小怪/3.RBoss/"+i+".png"));//技能
	}
}
