/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : commoditysys

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 21/05/2021 12:43:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `COMMENT_ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `COMMENT_USER_ID` int(0) NOT NULL COMMENT '评论用户',
  `COMMENT_COMMODITY_ID` int(0) NOT NULL COMMENT '评论商品',
  `COMMENT_CONTENT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `COMMENT_CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  `COMMENT_LEVEL` int(0) NULL DEFAULT 0 COMMENT '评论等级',
  `IS_VALID` int(0) NULL DEFAULT 1 COMMENT '是否是有效数据',
  PRIMARY KEY (`COMMENT_ID`, `COMMENT_USER_ID`, `COMMENT_COMMODITY_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES (1, 10, 10, '', '2021-04-19 16:42:24', NULL, NULL);
INSERT INTO `t_comment` VALUES (2, 10, 10, '你好', '2021-04-19 16:46:44', NULL, NULL);
INSERT INTO `t_comment` VALUES (3, 10, 10, '我要发言', '2021-04-19 16:47:35', NULL, NULL);
INSERT INTO `t_comment` VALUES (4, 10, 10, '获取', '2021-04-19 17:14:05', NULL, NULL);
INSERT INTO `t_comment` VALUES (5, 10, 10, '你好', '2021-04-19 17:14:18', NULL, NULL);
INSERT INTO `t_comment` VALUES (6, 10, 11, '你好', '2021-04-23 19:15:39', NULL, NULL);
INSERT INTO `t_comment` VALUES (7, 10, 46, 'hhahaa', '2021-04-28 14:02:21', NULL, NULL);
INSERT INTO `t_comment` VALUES (8, 10, 63, '好的', '2021-05-02 09:42:40', NULL, NULL);
INSERT INTO `t_comment` VALUES (9, 1, 63, '挺不错的', '2021-05-02 09:42:54', NULL, NULL);
INSERT INTO `t_comment` VALUES (10, 10, 65, '这商品不太好', '2021-05-06 08:09:34', NULL, NULL);

-- ----------------------------
-- Table structure for t_commodity
-- ----------------------------
DROP TABLE IF EXISTS `t_commodity`;
CREATE TABLE `t_commodity`  (
  `COMMODITY_ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品主键',
  `COMMODITY_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名',
  `COMMODITY_STATUS` int(0) NULL DEFAULT 0 COMMENT '商品状态',
  `COMMODITY_NUM` int(0) NULL DEFAULT 0 COMMENT '商品数量',
  `COMMODITY_PRICE` decimal(10, 0) NULL DEFAULT 1 COMMENT '商品每日价格',
  `COMMODITY_USER_ID` int(0) NULL DEFAULT NULL COMMENT '商品发布用户id',
  `COMMODITY_IMG_SRC` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片地址',
  `COMMODITY_TAG` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品类型标签',
  `COMMODITY_QUALITY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品质量',
  `COMMODITY_DETAILS` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品介绍',
  `COMMODITY_CREATE_DATE` date NULL DEFAULT NULL COMMENT '创建日期',
  `IS_VALID` int(0) NULL DEFAULT 1 COMMENT '是否是有效数据',
  PRIMARY KEY (`COMMODITY_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 75 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_commodity
-- ----------------------------
INSERT INTO `t_commodity` VALUES (1, '商品01', 100, 10, 1, 1, NULL, '服装装扮,标签02,镖旗,标签03', NULL, NULL, NULL, 1);
INSERT INTO `t_commodity` VALUES (2, '商品01', 100, 10, 1, 1, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_commodity` VALUES (3, '商品', 100, 10, 1, 1, NULL, '服装装扮,,,', '', NULL, NULL, 1);
INSERT INTO `t_commodity` VALUES (4, '商品', 100, 10, 1, 1, NULL, NULL, '', NULL, NULL, 1);
INSERT INTO `t_commodity` VALUES (5, '商品', 100, 10, 1, NULL, NULL, NULL, '', NULL, NULL, 1);
INSERT INTO `t_commodity` VALUES (6, '商品', 100, 10, 1, 1, NULL, '服装装扮,adad,adadd,sadasd', '', NULL, NULL, 1);
INSERT INTO `t_commodity` VALUES (7, '商品', 100, 10, 1, 1, NULL, NULL, '', NULL, NULL, 1);
INSERT INTO `t_commodity` VALUES (8, '商品', 100, 10, 1, 1, NULL, NULL, '', NULL, NULL, 1);
INSERT INTO `t_commodity` VALUES (9, '商品001', 100, 34, 1, 1, NULL, NULL, '非常好', NULL, '2021-02-18', 1);
INSERT INTO `t_commodity` VALUES (10, '洗衣机', 100, 0, 1, 1, NULL, '生活便利,haha', '差', NULL, '2021-02-18', 1);
INSERT INTO `t_commodity` VALUES (11, '洗衣机2', 100, 2, 1, 1, NULL, '生活便利,haha', '差', NULL, '2021-02-18', 1);
INSERT INTO `t_commodity` VALUES (12, '洗衣机3', 100, 9, 1, 1, NULL, '生活便利,haha', '差', NULL, '2021-02-18', 1);
INSERT INTO `t_commodity` VALUES (13, '洗衣机4', 100, 12, 1, 1, NULL, '生活便利,haha', '差', NULL, '2021-02-18', 1);
INSERT INTO `t_commodity` VALUES (14, '洗衣机5', 100, 12, 1, 1, NULL, '生活便利,haha', '差', NULL, '2021-02-18', 1);
INSERT INTO `t_commodity` VALUES (15, '机器01', 100, 2, 1, 1, NULL, '服装装扮,上衣', '好', NULL, '2021-04-05', 1);
INSERT INTO `t_commodity` VALUES (16, '机器04', 100, 18, 1, 1, NULL, '服装装扮,裤子', '好', NULL, '2021-04-05', 1);
INSERT INTO `t_commodity` VALUES (17, '休闲', 100, 2, 1, 1, NULL, '休闲娱乐,超级休闲', '好', NULL, '2021-04-05', 1);
INSERT INTO `t_commodity` VALUES (18, '休闲02', 100, 2, 1, 1, NULL, '休闲娱乐,快乐玩具', '差', NULL, '2021-04-05', 1);
INSERT INTO `t_commodity` VALUES (19, '休闲03', 100, 22, 1, 1, NULL, '休闲娱乐,休闲82', '好差', NULL, '2021-04-05', 1);
INSERT INTO `t_commodity` VALUES (20, '休闲04', 100, 20, 1, 1, NULL, '休闲娱乐,休闲快乐', '不太好', NULL, '2021-04-05', 1);
INSERT INTO `t_commodity` VALUES (21, '休闲05', 100, 3, 1, 1, NULL, '休闲娱乐,休闲内容', '差', NULL, '2021-04-05', 1);
INSERT INTO `t_commodity` VALUES (22, '电子设备', 100, 2, 1, 1, NULL, '电子设备,游戏机', '好', NULL, '2021-04-05', 1);
INSERT INTO `t_commodity` VALUES (23, '电子02', 100, 0, 1, 1, NULL, '电子设备,电子设备', 'hao', NULL, '2021-04-05', 1);
INSERT INTO `t_commodity` VALUES (24, '电子03', 100, 4, 1, 1, NULL, '电子设备,电子通信,服务器', '差', NULL, '2021-04-05', 1);
INSERT INTO `t_commodity` VALUES (25, '电子04', 100, 4, 1, 1, NULL, '电子设备,游戏光驱', '好', NULL, '2021-04-05', 1);
INSERT INTO `t_commodity` VALUES (26, '电子激光', 100, 2, 1, 1, NULL, '电子设备,哈哈哈', 'wwww', NULL, '2021-04-05', 1);
INSERT INTO `t_commodity` VALUES (27, 'zuieyuyi的商品', 1, 6, 1, 10, NULL, NULL, '好', NULL, '2021-04-18', 1);
INSERT INTO `t_commodity` VALUES (28, '裤子001', 1, 111, 1, 10, NULL, NULL, '很差', NULL, '2021-04-18', 1);
INSERT INTO `t_commodity` VALUES (29, '衣服', 1, 33, 3, 10, NULL, NULL, '好', NULL, '2021-04-19', 1);
INSERT INTO `t_commodity` VALUES (30, '萨尔达传说', 1, 4, 1, 10, NULL, NULL, '好', NULL, '2021-04-19', 1);
INSERT INTO `t_commodity` VALUES (31, '卡带', 1, 3, 1, 10, NULL, NULL, '好', NULL, '2021-04-19', 1);
INSERT INTO `t_commodity` VALUES (32, '积木', 1, 4, 1, 10, NULL, NULL, '差', NULL, '2021-04-19', 1);
INSERT INTO `t_commodity` VALUES (33, '游戏王', 100, 1, 5, 10, NULL, '休闲娱乐,卡牌', '好', NULL, '2021-04-20', 1);
INSERT INTO `t_commodity` VALUES (34, '', 1, 0, 1, 10, NULL, NULL, '', NULL, '2021-04-25', 0);
INSERT INTO `t_commodity` VALUES (35, '短袖', 100, 20, 12, 10, '', '服装装扮', '差', NULL, '2021-04-28', 0);
INSERT INTO `t_commodity` VALUES (36, '短袖2', 1, 50, 8, 10, '', NULL, '差', NULL, '2021-04-28', 0);
INSERT INTO `t_commodity` VALUES (37, '短袖2', 1, 50, 13, 10, '', NULL, '差', NULL, '2021-04-28', 0);
INSERT INTO `t_commodity` VALUES (38, '短袖3', 1, 23, 1, 10, '', NULL, '差', NULL, '2021-04-28', 0);
INSERT INTO `t_commodity` VALUES (39, '短袖', 100, 20, 3, 10, '', '服装装扮', '差', NULL, '2021-04-28', 0);
INSERT INTO `t_commodity` VALUES (40, '短袖45', 100, 12, 2, 10, '/uploadFile/10/短袖4510/e787d95c-8334-45b9-a573-4ca9383dc60edongman5.jpg', '服装装扮', '差', NULL, '2021-04-28', 0);
INSERT INTO `t_commodity` VALUES (41, '三国杀', 100, 5, 2, 10, '/uploadFile/10/1619616595156/8420f5b4-d1c6-4cb2-bb19-e338aa9a6debdongman5.jpg', '休闲娱乐', '差', NULL, '2021-04-28', 0);
INSERT INTO `t_commodity` VALUES (42, '三国杀2', 100, 24, 54, 10, '/uploadFile/10/1619617066482/720d6dfa-c7ee-4cbf-97a1-77ad2c4402b6dongman5.jpg', '休闲娱乐', '差', NULL, '2021-04-28', 0);
INSERT INTO `t_commodity` VALUES (43, '三国杀', 100, 45, 43, 10, '/uploadFile/10/1619617387731/61e02d11-36e3-4d2c-88b9-af944e46a9f0dongman5.jpg', '休闲娱乐', '差', NULL, '2021-04-28', 1);
INSERT INTO `t_commodity` VALUES (44, '短袖', 100, 65, 2, 10, '/uploadFile/10/1619617725546/3eb66f4d-4b9b-4d05-8fbc-539b0ae96f72dongman5.jpg', NULL, '差', NULL, '2021-04-28', 1);
INSERT INTO `t_commodity` VALUES (45, 'cos衣服', 1, 45, 234, 10, '/uploadFile/10/1619618307281/d4f8a0f9-0c44-4ecd-ad28-476f42ecf56cdongman5.jpg', '休闲娱乐', '差', NULL, '2021-04-28', 1);
INSERT INTO `t_commodity` VALUES (46, '汽车', 100, 342, 2222, 10, '/uploadFile/10/1619618490015/74890bc2-60ed-4354-bd10-b712060bb8e4dongman5.jpg', '电子设备', '差', NULL, '2021-04-28', 1);
INSERT INTO `t_commodity` VALUES (47, '三国杀2', 100, 23, 4, 10, '/uploadFile/10/1619691723537/8e9c8a6d-4cbf-44c3-94f4-8eb8d92119f5dongman5.jpg', NULL, '差', NULL, '2021-04-29', 1);
INSERT INTO `t_commodity` VALUES (48, '短袖', 100, 4, 5, 10, '/uploadFile/10/1619692825597/03eba6a1-4a1b-4491-a9d2-5dc8b61c1035dongman5.jpg', NULL, '差', NULL, '2021-04-29', 1);
INSERT INTO `t_commodity` VALUES (49, '短袖', 100, 234, 44, 10, '/uploadFile/10/1619697820757/6477fc7f-1786-4aa7-85a0-8c6eb144de81dongman5.jpg', NULL, '差', NULL, '2021-04-29', 1);
INSERT INTO `t_commodity` VALUES (50, '公主链接周边', 1, 23, 456, 10, '/uploadFile/10/1619698169796/051321f1-6e53-4803-8079-15673d9e03bedongman5.jpg', NULL, '差', NULL, '2021-04-29', 1);
INSERT INTO `t_commodity` VALUES (51, '黄瓜', 100, 24, 23, 10, '/uploadFile/10/1619700308618/d8baff18-182d-4b97-980f-ce2b78d85459dongman5.jpg', NULL, '差', NULL, '2021-04-29', 1);
INSERT INTO `t_commodity` VALUES (52, 'psp', 1, 3, 23, 10, '/uploadFile/10/1619700568941/a68a36f2-e1e7-45d9-a72f-6df43a1bd280dongman5.jpg', NULL, '差', NULL, '2021-04-29', 1);
INSERT INTO `t_commodity` VALUES (53, '跑步机', 1, 23, 33333, 10, '/uploadFile/10/1619700885867/d8945065-d3aa-4188-a8f4-e6a1c465d782dongman5.jpg', NULL, '差', NULL, '2021-04-29', 1);
INSERT INTO `t_commodity` VALUES (54, 'ai酱玩偶', 1, 6, 75, 10, '/uploadFile/10/1619702848784/5d069d19-f78c-4f9b-826b-0f2e31168cfbdongman5.jpg', NULL, '差', NULL, '2021-04-29', 1);
INSERT INTO `t_commodity` VALUES (55, '星星玩具', 1, 234, 555, 10, '/uploadFile/10/1619703114819/e6f231e4-e8fb-479a-a0e0-aabd09c8911ddongman5.jpg', NULL, 'qwe qw', NULL, '2021-04-29', 1);
INSERT INTO `t_commodity` VALUES (56, '哎i', 1, 34, 555, 10, '/uploadFile/10/1619703261683/5b422e26-f74c-4eb8-a24e-0c1cdf2da8b6dongman5.jpg', NULL, '差', NULL, '2021-04-29', 1);
INSERT INTO `t_commodity` VALUES (57, '爱奇艺vip', 1, 23, 4, 10, '/uploadFile/10/1619703594778/5acbc74f-66f8-4db4-b090-efdf945c8a65dongman5.jpg', NULL, '差', NULL, '2021-04-29', 1);
INSERT INTO `t_commodity` VALUES (58, '密密', 1, 23, 44, 10, 'E:\\tomcat\\apache-tomcat-9.0.40\\apache-tomcat-9.0.40\\webapps\\CommoditySharePlatformWeb_war\\uploadFile\\10\\1619704098301\\145e71b9-48a3-462d-8968-988ee41787c3dongman5.jpg', NULL, '5', NULL, '2021-04-29', 1);
INSERT INTO `t_commodity` VALUES (59, '火车玩具', 1, 4, 55, 10, '/uploadFile/10/1619704652971/bc0b84c8-0011-445d-8646-5bd16ab790deQQ图片20210103141459.jpg', NULL, '差', NULL, '2021-04-29', 1);
INSERT INTO `t_commodity` VALUES (60, '任天堂大乱斗', 1, 34, 555, 10, '/uploadFile/10/1619705028235/55ecbdbb-f020-42c0-aa75-c3f70f81e017QQ图片20210103141459.jpg', NULL, '差', NULL, '2021-04-29', 1);
INSERT INTO `t_commodity` VALUES (61, 'gameboy', 1, 323, 333, 10, '/uploadFile/10/1619705251967/f6271d5a-0356-43a6-ba7f-95aafa28ec30QQ图片20210103141459.jpg', NULL, '差', NULL, '2021-04-29', 1);
INSERT INTO `t_commodity` VALUES (62, '爱玩具', 1, 54, 55, 10, '/uploadFile/10/1619832915801/f4d29b27-feaf-4011-865c-7a7f1d05b2a4QQ图片20210103141459.jpg', NULL, '差', NULL, '2021-05-01', 1);
INSERT INTO `t_commodity` VALUES (63, '三国杀风火包', 100, 6, 44, 10, '/uploadFile/10/1619948316604/1b5df1ef-3efb-43f0-9589-cd6504f876e8dongman5.jpg', '休闲娱乐', '差', NULL, '2021-05-02', 1);
INSERT INTO `t_commodity` VALUES (64, '我爱运动', 100, 44, 23, 10, '/uploadFile/10/1620031066395/f39179ec-1231-41bf-8d9e-07dffc28dae1QQ图片20210103141459.jpg', NULL, '差', NULL, '2021-05-03', 1);
INSERT INTO `t_commodity` VALUES (65, '我的商品', 100, 23, 4, 10, '/uploadFile/10/1620287085620/9ac15164-33a8-4b14-81dc-5a90eec5fa04u=1026016199,1338164578&fm=26&gp=0.jpg', '服装装扮', '差', NULL, '2021-05-06', 1);
INSERT INTO `t_commodity` VALUES (66, '商品01', 100, 10, 1, 1, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `t_commodity` VALUES (67, '商品01', 100, 10, 1, 1, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `t_commodity` VALUES (68, '短袖', 100, 444, 55, 10, '/uploadFile/10/1620546873066/c334e6b6-aae1-48c8-8480-11cf4245f15adongman5.jpg', NULL, '差', NULL, '2021-05-09', 0);
INSERT INTO `t_commodity` VALUES (69, '短袖', 100, 333, 44, 10, '/uploadFile/10/1620549195613/1aac19c4-2f53-4c58-8745-27dde6ce264ddongman5.jpg', NULL, '差', NULL, '2021-05-09', 0);
INSERT INTO `t_commodity` VALUES (70, '短袖', 100, 33, 4, 10, '/uploadFile/10/1620549495299/2163e7a0-bc7b-4070-8064-69ac55453c0cdongman5.jpg', NULL, '差', NULL, '2021-05-09', 1);
INSERT INTO `t_commodity` VALUES (71, '商品01', 100, 10, 1, 1, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `t_commodity` VALUES (72, '商品01', 100, 10, 1, 1, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `t_commodity` VALUES (73, '商品01', 100, 10, 1, 1, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `t_commodity` VALUES (74, '短袖33', 100, 333, 4, 10, '/uploadFile/10/1620825353044/03c26081-c4c9-4bff-be8a-2cea526f1663u=1026016199,1338164578&fm=26&gp=0.jpg', NULL, '差', NULL, '2021-05-12', 1);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `ORDER_ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `ORDER_PUB_USER_ID` int(0) NOT NULL COMMENT '卖家用户ID',
  `ORDER_USER_ID` int(0) NOT NULL COMMENT '买家用户ID',
  `ORDER_COMMODITY_ID` int(0) NOT NULL COMMENT '商品ID',
  `ORDER_COMMODITY_NUM` int(0) NOT NULL COMMENT '租借数量',
  `ORDER_COMMODITY_TOTAL` decimal(10, 0) NOT NULL COMMENT '商品总价',
  `ORDER_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单名',
  `ORDER_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单编号',
  `ORDER_STATUS` int(0) NULL DEFAULT 1 COMMENT '订单状态',
  `ORDER_CREATE_DATE` date NULL DEFAULT NULL COMMENT '订单创建日期',
  `ORDER_ADDR` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单发送地址',
  `ORDER_ARRIVE_ADDR` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单送达地址',
  `ORDER_BEGIN_RENT_TIME` date NULL DEFAULT NULL COMMENT '租借开始时间',
  `ORDER_END_RENT_TIME` date NULL DEFAULT NULL COMMENT '租借到达时间',
  `ORDER_BACK_TIME` date NULL DEFAULT NULL COMMENT '返还日期',
  `ORDER_RETURN_TIME` date NULL DEFAULT NULL COMMENT '退货时间',
  `IS_VALID` int(0) NULL DEFAULT 1 COMMENT '是否是有效数据',
  PRIMARY KEY (`ORDER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (1, 1, 1, 1, 0, 0, '订单1', '1', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `t_order` VALUES (2, 1, 1, 3, 0, 0, '订单01', 'Mon Feb 22 19:08:15 CST 2021132', 1, '2021-02-22', '111', NULL, '2021-02-22', '2021-02-18', '2021-03-14', NULL, 1);
INSERT INTO `t_order` VALUES (3, 1, 1, 1, 0, 0, '', 'Mon Feb 22 19:10:30 CST 2021770', 1, '2021-02-22', '111', NULL, '2021-02-16', '2021-02-26', '2021-03-07', NULL, 1);
INSERT INTO `t_order` VALUES (4, 1, 1, 1, 0, 0, '', '1613992655840', 1, '2021-02-22', '111', NULL, '2021-02-22', '2021-02-25', '2021-03-06', NULL, 1);
INSERT INTO `t_order` VALUES (5, 1, 1, 3, 0, 0, '订单01', '1613992839271', 1, '2021-02-22', '111', NULL, '2021-02-12', '2021-02-13', '2021-03-11', NULL, 1);
INSERT INTO `t_order` VALUES (6, 1, 1, 5, 0, 0, '', '1614077507828', 4, '2021-02-23', '111', '2222', '2021-02-11', '2021-02-19', '2021-03-14', NULL, 1);
INSERT INTO `t_order` VALUES (7, 1, 1, 3, 0, 0, '订单03', '1614077943727', 5, '2021-02-23', '111', '2222', '2021-02-17', '2021-02-25', '2021-03-14', NULL, 1);
INSERT INTO `t_order` VALUES (8, 1, 1, 4, 0, 0, '订单04', '1614078287365', 2, '2021-02-23', '111', '2222222', '2021-02-18', '2021-03-04', '2021-03-13', NULL, 0);
INSERT INTO `t_order` VALUES (9, 1, 10, 4, 0, 0, 'zuieyuyi的订单', '1614078287365', 10, '2021-02-23', '111', '2222222', '2021-02-18', '2021-03-04', '2021-03-13', '2021-04-02', 0);
INSERT INTO `t_order` VALUES (10, 10, 11, 4, 0, 0, 'zuieyuyi的订单', '1614078287365', 2, '2021-02-23', '111', '2222222', '2021-02-18', '2021-03-04', '2021-03-13', NULL, 0);
INSERT INTO `t_order` VALUES (11, 1, 10, 10, 4, 4, NULL, '1619210936423', 7, '2021-04-24', '福建福州', '福建福州', '2021-04-25', '2021-04-26', '2021-04-27', NULL, 1);
INSERT INTO `t_order` VALUES (12, 1, 10, 10, 4, 4, NULL, '1619211339136', 7, '2021-04-24', '福建福州', '福建福州', '2021-04-25', '2021-04-26', '2021-04-27', NULL, 1);
INSERT INTO `t_order` VALUES (13, 1, 10, 10, 4, 8, NULL, '1619211606210', 7, '2021-04-24', '福建福州', '福建福州', '2021-04-25', '2021-04-27', '2021-04-28', NULL, 1);
INSERT INTO `t_order` VALUES (14, 1, 10, 16, 4, 8, NULL, '1619211833222', 9, '2021-04-24', '福建福州', '福建福州', '2021-04-25', '2021-04-27', '2021-04-28', NULL, 1);
INSERT INTO `t_order` VALUES (15, 1, 10, 16, 2, 10, NULL, '1619212175830', 5, '2021-04-24', '福建福州', '福建福州', '2021-04-25', '2021-04-30', '2021-05-01', NULL, 1);
INSERT INTO `t_order` VALUES (16, 1, 10, 11, 10, 10, NULL, '1619212889238', 9, '2021-04-24', '福建福州', '福建福州', '2021-04-25', '2021-04-26', '2021-04-27', NULL, 1);
INSERT INTO `t_order` VALUES (17, 10, 10, 33, 2, 20, NULL, '1619252227626', 5, '2021-04-24', '福建福州', '福建福州', '2021-04-25', '2021-04-27', '2021-04-28', NULL, 0);
INSERT INTO `t_order` VALUES (18, 1, 10, 23, 2, 2, NULL, '1619252694860', 9, '2021-04-24', '福建福州', '福建福州', '2021-04-25', '2021-04-26', '2021-04-27', NULL, 1);
INSERT INTO `t_order` VALUES (19, 1, 10, 12, 3, 12, NULL, '1619252784410', 9, '2021-04-24', '福建福州', '福建福州', '2021-04-25', '2021-04-29', '2021-04-30', NULL, 1);
INSERT INTO `t_order` VALUES (20, 1, 10, 19, 3, 3, NULL, '1619255996629', 5, '2021-04-24', '福建福州', '福建福州', '2021-04-25', '2021-04-26', '2021-04-27', NULL, 1);
INSERT INTO `t_order` VALUES (21, 10, 1, 63, 2, 176, NULL, '1619948607443', 10, '2021-05-02', '福建福州', '福建福州', '2021-04-30', '2021-05-05', '2021-05-06', '2021-05-02', 1);
INSERT INTO `t_order` VALUES (22, 10, 10, 63, 1, 88, NULL, '1619952610045', 9, '2021-05-02', '福建福州', '福建福州', '2021-05-03', '2021-05-05', '2021-05-06', NULL, 1);
INSERT INTO `t_order` VALUES (23, 10, 10, 63, 1, 132, NULL, '1619952733843', 9, '2021-05-02', '福建福州', '福建福州', '2021-05-03', '2021-05-06', '2021-05-07', NULL, 1);
INSERT INTO `t_order` VALUES (24, 10, 1, 17, 1, 33, '订单00001', '1620035060509', 4, '2021-05-03', '111', '2222', '2021-05-01', '2021-05-04', '2021-05-05', NULL, 1);
INSERT INTO `t_order` VALUES (25, 10, 1, 17, 1, 33, '订单00001', '1620035883765', 7, '2021-05-03', '111', '2222', '2021-05-01', '2021-05-04', '2021-05-05', NULL, 0);
INSERT INTO `t_order` VALUES (26, 10, 1, 18, 3, 4, '订单00002', '1620039150560', 5, '2021-05-03', '111', '2222222', '2021-05-01', '2021-05-06', '2021-05-07', '2021-05-08', 1);

-- ----------------------------
-- Table structure for t_sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_admin`;
CREATE TABLE `t_sys_admin`  (
  `ADMIN_ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '管理员主键',
  `ADMIN_PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  `ADMIN_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员姓名',
  PRIMARY KEY (`ADMIN_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_admin
-- ----------------------------
INSERT INTO `t_sys_admin` VALUES (5, 'd17c7669bd9d477c0f8c9592e45d9167', 'admin');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `USER_ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `USER_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `USER_PW` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `USER_BUY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户购买订单',
  `USER_ADDR` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户地址',
  `USER_COLLECT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户收藏商品',
  `USER_EMAIL` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `USER_DETAILS` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '用户详情介绍',
  `USER_STATUS` int(0) NULL DEFAULT 0 COMMENT '用户状态',
  `USER_CREATE_DATE` date NULL DEFAULT NULL COMMENT '用户创建时间',
  `USER_IS_ADMIN` int(0) NULL DEFAULT 0 COMMENT '是否是超级用户',
  `USER_MONEY` decimal(65, 10) NOT NULL DEFAULT 0.0000000000 COMMENT '金钱剩余总额',
  `IS_VALID` int(0) NULL DEFAULT 1 COMMENT '是否是有效数据',
  PRIMARY KEY (`USER_ID`, `USER_NAME`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'zuieyuyi2', '8dda5810413f0590d2bb24025f5c5fa4', NULL, '福建福州', NULL, 'zuieyuyi@qq.com', NULL, 0, '2021-04-16', 0, 1366.4000000000, 1);
INSERT INTO `t_user` VALUES (10, 'zuieyuyi', '8dda5810413f0590d2bb24025f5c5fa4', NULL, '福建福州', NULL, 'zuieyuyi@qq.com', NULL, 0, '2021-04-16', 0, 2853.6000000000, 1);
INSERT INTO `t_user` VALUES (13, 'magic', 'e13e0b2de781f588c06769e82ae2c6d0', NULL, NULL, NULL, 'magic@qq.com', NULL, 0, '2021-04-24', 0, 0.0000000000, 1);
INSERT INTO `t_user` VALUES (14, 'magic1', 'e13e0b2de781f588c06769e82ae2c6d0', NULL, NULL, NULL, 'magic2@qq.com', NULL, 0, '2021-04-24', 0, 0.0000000000, 1);
INSERT INTO `t_user` VALUES (15, 'abc', 'e13e0b2de781f588c06769e82ae2c6d0', NULL, NULL, NULL, 'abc@qq.com', NULL, 0, '2021-04-24', 0, 0.0000000000, 1);
INSERT INTO `t_user` VALUES (16, 'abc1', 'e13e0b2de781f588c06769e82ae2c6d0', NULL, NULL, NULL, 'aaa@qq.com', NULL, 0, '2021-04-24', 0, 0.0000000000, 1);

SET FOREIGN_KEY_CHECKS = 1;
