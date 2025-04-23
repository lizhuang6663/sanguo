# 三国格斗小游戏

## 项目概述

这是一个基于三国题材的格斗类小游戏，使用Java开发。这是我使用Java开发的一个游戏作品。该游戏包含了基本的角色、敌人和战斗机制，旨在模拟以三国为背景的格斗场景。

## 功能特点

- **角色与敌人**：游戏包含玩家角色和敌人，分别通过`People.java`和`Enemy.java`实现。
- **战斗机制**：实现了简单的格斗逻辑，玩家可以与敌人进行战斗，并可以使用技能（技能拥有冷却时间）
- 各种动作，如防御、跳跃、拳击、飞踢、连击、冲锋以及技能
- **丰富的玩法**：玩家通过消灭敌人有概率掉落物品，如酒（加攻击）、包子、鸡肉、猪肉（加血）
- 玩家可以从4个角色中选择主角，每个角色的描述和技能各不相同，目前共拥有三个Boss，以及5种小兵
- **游戏框架**：通过`GameFame.java`和`GameObj.java`搭建了游戏的基本框架。
- **工具类**：使用`GameUtils.java`提供游戏所需的工具函数。
- **角色分类**：通过`Role.java`定义了不同的角色类型。

## 文件结构

- **src/SanGUO/**：包含游戏的主要Java源代码。
  - `Enemy.java`：定义敌人类。
  - `GameFame.java`：游戏框架主类。
  - `GameObj.java`：游戏对象类。
  - `GameUtils.java`：游戏工具类。
  - `People.java`：玩家角色类。
  - `Role.java`：角色类型定义。
  - `module-info.java`：模块信息文件。
- **imgs/**：存储游戏中使用的图片资源。
- **bin/**：编译后的字节码文件目录。
- **.DS_Store**：macOS系统生成的隐藏文件。

## 使用技术

- **Java**：使用Java编写游戏逻辑，包括面向对象编程（类、对象、继承等）。
- **文件管理**：通过文件夹结构管理资源文件（如图片）。

## 如何运行

1. 确保你的电脑已安装Java开发环境（JDK）。
2. 将此仓库克隆到本地。
3. 进入`src/SanGUO/`目录，编译并运行`GameFame.java`：

   ```bash
   javac GameFame.java
   java GameFame
   ```
4. 按照游戏提示进行操作。

## 演示视频

我已经在B站上传了这个游戏的演示视频，欢迎观看和反馈！\
📺 三国格斗小游戏演示

## 未来改进

- 添加更多的角色和技能，丰富游戏内容。
- 引入图形界面（例如使用JavaFX或Swing），提升游戏的可视化效果。
- 优化战斗逻辑，增加难度等级和关卡设计。

## 总结

这是我的一个Java学习项目，通过开发这个三国格斗小游戏，我对Java编程和游戏开发有了初步的了解。未来我会继续学习，改进这个游戏！

## 许可声明

此项目仅用于学习目的，不用于商业用途。



<img width="1000" alt="image" src="https://github.com/user-attachments/assets/3953bd8e-58d8-4b22-9cd8-b74e738e8194" />

<img width="1000" alt="image" src="https://github.com/user-attachments/assets/a89ac3a9-7635-4e62-b05f-aef34aa5ede9" />

<img width="1000" alt="image" src="https://github.com/user-attachments/assets/8d267e84-5733-4b60-b5d3-6f04a6c8bfc4" />

<img width="1000" alt="image" src="https://github.com/user-attachments/assets/8d176f5a-5d8b-4c20-aa3f-ed9d5a9d0e32" />

<img width="1000" alt="image" src="https://github.com/user-attachments/assets/28fba642-ecdc-4138-a0f7-ccbb23dd04ef" />

<img width="1000" alt="image" src="https://github.com/user-attachments/assets/432fbb0b-323d-4fb4-9f1f-cc10c6618301" />
