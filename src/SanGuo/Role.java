package SanGuo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.List;


public class Role extends People{
	//构造方法
	public Role() {}
	public Role(int x,int y,int width,int height,float hp,float atk,int walkSpeed,Image stand_LImg,Image stand_RImg,
			Image defend_LImg,Image defend_RImg,List<Image> run_LListImg,List<Image> run_RListImg,int runImgNum,
			List<Image> slip_LListImg,List<Image> slip_RLIstImg,int slipImgNum,
			List<Image> jump_LListImg,List<Image> jump_RListImg,int jumpImgNum,
			List<Image> cut_LListImg,List<Image> cut_RListImg,int cutImgNum,
			List<Image> flyKick_LListImg,List<Image> flyKick_RListImg,int flyKickImgNUm,
			List<Image> longAttack_LListImg,List<Image> longAttack_RListImg,int longAttackImgNum,
			List<Image> skill_LListImg,List<Image> skill_RListImg,int skillImgNum) {
		super(x,y,width,height,hp,atk,walkSpeed,stand_LImg,stand_RImg,defend_LImg,defend_RImg,run_LListImg,run_RListImg,
				runImgNum,slip_LListImg,slip_RLIstImg,slipImgNum,jump_LListImg,jump_RListImg,jumpImgNum,cut_LListImg,
				cut_RListImg,cutImgNum,flyKick_LListImg,flyKick_RListImg,flyKickImgNUm,longAttack_LListImg,
				longAttack_RListImg,longAttackImgNum,skill_LListImg,skill_RListImg,skillImgNum);
	}
	//主角被攻击
	public void isWound() {
		GameFame.isCutAgoHp = this.getHp();//被攻击前的血量，用于张飞的被动 
		//被小怪攻击
		for (int i = 0;i<GameUtils.enemyListImg.size();i++) {
			//如果遇到了小怪
			if (this.getRec().intersects(GameUtils.enemyListImg.get(i).getRec())) {
				//主角死亡
				if (hp <= 0) GameFame.gameState = 4;
				//被拳击攻击到
				if (GameUtils.enemyListImg.get(i).getStatus().indexOf("cut") != -1 ) {
					if (this.status.indexOf("defend") != -1) {//如果此时在防御，只受到敌人三分之一的攻击力
						this.hp -= GameUtils.enemyListImg.get(i).getAtk()/3;
					}else {
						this.hp -= GameUtils.enemyListImg.get(i).getAtk();
					}
				}
				//被技能攻击到
				if (GameUtils.enemyListImg.get(i).getStatus().indexOf("skill") != -1) {
					if (this.status.indexOf("defend") != -1) {
						this.hp -= (GameUtils.enemyListImg.get(i).getAtk()*2)/3;
					}else {
						this.hp -= GameUtils.enemyListImg.get(i).getAtk()*2;
					}
				}
				//被冲锋攻击到
				if (GameUtils.enemyListImg.get(i).getStatus().indexOf("quickGo") != -1) {
					if (this.status.indexOf("defend") != -1) {
						this.hp -= (GameUtils.enemyListImg.get(i).getAtk()*2)/3;
					}else {
						this.hp -= GameUtils.enemyListImg.get(i).getAtk()*1.5;
					}
				}
			}
		}
		//被Boss攻击
		for (int i = 0;i<GameUtils.bossListImg.size();i++) {
			//如果遇到了Boss
			if (this.getRec().intersects(GameUtils.bossListImg.get(i).getRec())) {
				//主角死亡
				if (hp <= 0) GameFame.gameState = 4;
				//被拳击攻击到
				if (GameUtils.bossListImg.get(i).getStatus().indexOf("cut") != -1 ) {
					if (this.status.indexOf("defend") != -1) {//如果此时在防御，只受到敌人三分之一的攻击力
						this.hp -= GameUtils.bossListImg.get(i).getAtk()/3;
					}else {
						this.hp -= GameUtils.bossListImg.get(i).getAtk();
					}
				}
				//被技能攻击到
				if (GameUtils.bossListImg.get(i).getStatus().indexOf("skill") != -1) {
					if (this.status.indexOf("defend") != -1) {
						this.hp -= (GameUtils.bossListImg.get(i).getAtk()*2)/3;
					}else {
						this.hp -= GameUtils.bossListImg.get(i).getAtk()*2;
					}
				}
				if (GameUtils.bossListImg.get(i).getStatus().indexOf("quickGo") != -1) {
					if (this.status.indexOf("defend") != -1) {
						this.hp -= (GameUtils.bossListImg.get(i).getAtk()*2)/3;
					}else {
						this.hp -= GameUtils.bossListImg.get(i).getAtk()*1.5;
					}
				}
			}
		}
		//用于张飞的被动，随着生命的降低，攻击力不断增加，相当于每损失100 血量，增加1点攻击
		if (GameFame.role == GameFame.role2) {
			float n = (GameFame.isCutAgoHp - this.getHp())/100;
			this.atk += n;
		}
	}
	
	
	//主角吃食物
	public void eatFood() {
		//遍历食物列表
		for (int i = 0;i<GameUtils.gameObjListImg.size();i++) {
			if (GameUtils.gameObjListImg.get(i).getRec().intersects(this.getRec())) {
				//当食物是酒时能增加攻击力
				if (GameUtils.gameObjListImg.get(i).getImg() == GameUtils.drinkImg) {
					this.atk +=GameUtils.gameObjListImg.get(i).getRecover();
				}else {//恢复血量
					if (this.getHp() < GameUtils.hp1) {
						//防止血量超出上限
						if (GameFame.role == GameFame.role1) {//主角1
							if (this.getHp()+GameUtils.gameObjListImg.get(i).getRecover() > GameUtils.hp1) {
								this.hp = GameUtils.hp1;
							}else {
								this.hp += GameUtils.gameObjListImg.get(i).getRecover();
							}
						}
						if (GameFame.role == GameFame.role2) {//主角2
							if (this.getHp()+GameUtils.gameObjListImg.get(i).getRecover() > GameUtils.hp2) {
								this.hp = GameUtils.hp2;
							}else {
								this.hp += GameUtils.gameObjListImg.get(i).getRecover();
							}
						}
						if (GameFame.role == GameFame.role3) {//主角3
							if (this.getHp()+GameUtils.gameObjListImg.get(i).getRecover() > GameUtils.hp3) {
								this.hp = GameUtils.hp3;
							}else {
								this.hp += GameUtils.gameObjListImg.get(i).getRecover();
							}
						}
						if (GameFame.role == GameFame.role4) {//主角4
							if (this.getHp()+GameUtils.gameObjListImg.get(i).getRecover() > GameUtils.hp4) {
								this.hp = GameUtils.hp4;
							}else {
								this.hp += GameUtils.gameObjListImg.get(i).getRecover();
							}
						}
					}
				}
				//将已经吃过的食物添加到removeObjListImg中
				GameUtils.removeObjListImg.add(GameUtils.gameObjListImg.get(i));
			}
			//人物向右走时，为了实现食物与人物的距离在减小
			if (this.getStatus().contains("run--right") && GameFame.bgWalk != -4120) {
				int foodX = GameUtils.gameObjListImg.get(i).getX();
				GameUtils.gameObjListImg.get(i).setX(foodX-this.getXSpeed());
			}
		}
	}
	
	//键盘的按下，来控制移动
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()){
			case KeyEvent.VK_A://向左走
				leftMove();
				break;
			case KeyEvent.VK_D://向右走
				rightMove();
				break;
			case KeyEvent.VK_S://防御
				defend();
				break;
			case KeyEvent.VK_O://冲锋，0.5秒冷却
				if (quickGoCoolDown) {
					quickGo();
					new quickGoCD().start();
				}
				break;
			case KeyEvent.VK_W://跳跃1秒冷却
				if (jumpCoolDown) {
					jump();
					new jumpCD().start();//判断跳跃冷却状态
				}
				break;
			case KeyEvent.VK_J://拳击，无冷却
					attack();
				break;
			case KeyEvent.VK_K://飞踢，0.5秒冷却
				if (flyKickCoolDown) {
					flyKick();
					new flyKickCD().start();
				}
				break;
			case KeyEvent.VK_L://连击，0.5无冷却
				if (longAttackCoolDown){
					longAttack();
					new longAttackCD().start();	
				}
				break;
			case KeyEvent.VK_I://技能，3秒冷却
				if (skillCoolDown) {
					skill();
					new skillCD().start();
				}
				break;
		}
	}
	//键盘的松开，来控制暂停
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()){
			case KeyEvent.VK_A:
				leftStop();
				break;
			case KeyEvent.VK_D:
				rightStop();
				break;
			case KeyEvent.VK_S:
			case KeyEvent.VK_I:
			case KeyEvent.VK_O:
			case KeyEvent.VK_J:
			case KeyEvent.VK_K:
			case KeyEvent.VK_L:
				actionStop();//停止各种攻击，跳跃，技能等行为
				break;	
		}
	}

}
