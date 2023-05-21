package SanGuo;


import java.awt.Image;
import java.util.*;

//小怪和Boss
public class Enemy extends People {
	int foodMove;//用于人物移动时，人物与食物之间的距离也会变化
	//构造方法
	public Enemy() {}
	//用于敌人
	public Enemy(int x,int y,int width,int height,float hp,float atk,int walkSpeed,Image stand_LImg,
			Image stand_RImg,List<Image> run_LListImg,List<Image> run_RListImg,int runImgNum,
			List<Image> quickGo_LListImg,List<Image> quickGo_RListImg,int quickGoImgNum,
			List<Image> cut_LListImg,List<Image> cut_RListImg,int cutImgNum,
			List<Image> skill_LListImg,List<Image> skill_RListImg,int skillImgNum) {
		super(x,y,width,height,hp,atk,walkSpeed,stand_LImg,stand_RImg,run_LListImg,run_RListImg,runImgNum,
				quickGo_LListImg,quickGo_RListImg,quickGoImgNum,
				cut_LListImg,cut_RListImg,cutImgNum,skill_LListImg,skill_RListImg,skillImgNum);	
	}
	
	
	//敌人的行为
	public void action() {
		//判断敌人是否死亡
		if (this.getHp() <= 0) {
			GameFame.killEnemyCount ++;
			//有概率生成食物，并将出现的食物添加到gameObjListImg中
			int n = (int)(Math.random()*10);
			switch (n) {
				case 0,1,2,3://有十分之四的概率不会掉落食物
					break;
				case 4,5:
					GameUtils.gameObjListImg.add(new GameObj(GameUtils.food1Img,this.getX()+25,this.getY()+40,48,32,100));
					break;
				case 6,7:
					GameUtils.gameObjListImg.add(new GameObj(GameUtils.food2Img,this.getX()+25,this.getY()+40,48,32,200));
					break;
				case 8:
					GameUtils.gameObjListImg.add(new GameObj(GameUtils.food3Img,this.getX()+25,this.getY()+40,64,32,300));
					break;
				case 9://这里酒增加的是攻击力
					GameUtils.gameObjListImg.add(new GameObj(GameUtils.drinkImg,this.getX()+25,this.getY()+40,48,48,10));
					break;
			}
			//用于魏延的被动
			if (GameFame.role == GameFame.role4) {
				if (100 + GameFame.role.getHp() > GameUtils.hp4) {
					this.hp = GameUtils.hp4;
				}else {
					GameFame.role.hp += 100;
				}
			}
			//将死亡的敌人添加到removeEnemyListImg中
			GameUtils.removeEnemyListImg.add(this);
			GameFame.nowEnemyCount-=5;//用于赵云的被动
		}
		goAndCut();//移动和攻击
	}
	
	//移动和攻击
	public void goAndCut() {
		//被攻击减血
		isWound();
		//相遇了
		if (isRec() ) {
			//拳击
			if (cutCoolDown) {
				attack();
				new cutCD().start();
			}
			//技能
			if (skillCoolDown) {
				int n = (int)(Math.random()*100);
				if (n < 10 && this.getHp() > 800) skill();//血量大于800时，大约有十分之一的概率，发动技能
				if (n < 30 && this.getHp() <= 500) skill();//血量小于500时，发动技能的概率为十分之三
				new skillCD().start();
			}
		}else {
			//移动
			//通过敌人与主角x坐标差值的正负，来让敌人一直靠近主角，并在相遇的同时攻击主角
			if (this.getX()-GameFame.role.getX() < 0) {
				rightMove();
			}else {
				leftMove();
			}
			//敌人有百分之五的概率发动冲锋
			int n = (int)(Math.random()*100);
			if (quickGoCoolDown && n<5) {
				 quickGo();
				new quickGoCD().start();
			}
		}		
	}
	
	//敌人被攻击到了
	public void isWound() {
		if (isRec()) {//如果相遇
			//判断主角是否攻击了，而且是哪一种攻击方式
			//拳击击中了敌人
			if (GameFame.role.getStatus().indexOf("cut") != -1) this.hp -= GameFame.role.getAtk()/2;
			//飞踢击中了敌人
			if (GameFame.role.getStatus().indexOf("flyKick") != -1) this.hp -= GameFame.role.getAtk()/1.5;
			//连击击中了敌人
			if (GameFame.role.getStatus().indexOf("longAttack") != -1) this.hp -= GameFame.role.getAtk()/1.5;
			//技能击中了敌人
			if (GameFame.role.getStatus().indexOf("skill") != -1) this.hp -= GameFame.role.getAtk();
			//冲撞击中了敌人
			if (GameFame.role.getStatus().indexOf("quickGo") != -1) this.hp -= GameFame.role.getAtk()/1.5;
		}
	}
	//判断敌人与主角是否相遇
	public boolean isRec() {
		if(this.getRec().intersects(GameFame.role.getRec())) {
			return true;//相遇了
		}else {
			return false;//未相遇
		}
	}
	
}
