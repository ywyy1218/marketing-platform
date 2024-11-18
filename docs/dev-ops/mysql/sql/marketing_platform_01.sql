-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- 主机： mysql:3306
-- 生成日期： 2024-10-14 00:31:20
-- 服务器版本： 8.0.32
-- PHP 版本： 8.2.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `marketing_platform_01`
--

-- --------------------------------------------------------

--
-- 表的结构 `raffle_activity_account`
--

CREATE TABLE `raffle_activity_account` (
  `id` bigint UNSIGNED NOT NULL COMMENT '自增ID',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `activity_id` bigint NOT NULL COMMENT '活动ID',
  `total_count` int NOT NULL COMMENT '总次数',
  `total_count_surplus` int NOT NULL COMMENT '总次数-剩余',
  `day_count` int NOT NULL COMMENT '日次数',
  `day_count_surplus` int NOT NULL COMMENT '日次数-剩余',
  `month_count` int NOT NULL COMMENT '月次数',
  `month_count_surplus` int NOT NULL COMMENT '月次数-剩余',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='抽奖活动账户表';

-- --------------------------------------------------------

--
-- 表的结构 `raffle_activity_account_flow`
--

CREATE TABLE `raffle_activity_account_flow` (
  `id` int UNSIGNED NOT NULL COMMENT '自增ID',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `activity_id` bigint NOT NULL COMMENT '活动ID',
  `total_count` int NOT NULL COMMENT '总次数',
  `day_count` int NOT NULL COMMENT '日次数',
  `month_count` int NOT NULL COMMENT '月次数',
  `flow_id` varchar(32) NOT NULL COMMENT '流水ID - 生成的唯一ID',
  `flow_channel` varchar(12) NOT NULL DEFAULT 'activity' COMMENT '流水渠道（activity-活动领取、sale-购买、redeem-兑换、free-免费赠送）',
  `biz_id` varchar(12) NOT NULL COMMENT '业务ID（外部透传，活动ID、订单ID）',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='抽奖活动账户流水表';

-- --------------------------------------------------------

--
-- 表的结构 `raffle_activity_order`
--

CREATE TABLE `raffle_activity_order` (
  `id` bigint UNSIGNED NOT NULL COMMENT '自增ID',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `activity_id` bigint NOT NULL COMMENT '活动ID',
  `activity_name` varchar(64) NOT NULL COMMENT '活动名称',
  `strategy_id` bigint NOT NULL COMMENT '抽奖策略ID',
  `order_id` varchar(12) NOT NULL COMMENT '订单ID',
  `order_time` datetime NOT NULL COMMENT '下单时间',
  `state` varchar(8) NOT NULL COMMENT '订单状态（not_used、used、expire）',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='抽奖活动单';

--
-- 转储表的索引
--

--
-- 表的索引 `raffle_activity_account`
--
ALTER TABLE `raffle_activity_account`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uq_user_id_activity_id` (`user_id`,`activity_id`);

--
-- 表的索引 `raffle_activity_account_flow`
--
ALTER TABLE `raffle_activity_account_flow`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uq_flow_id` (`flow_id`),
  ADD UNIQUE KEY `uq_biz_id` (`biz_id`),
  ADD KEY `idx_user_id_activity_id` (`user_id`,`activity_id`);

--
-- 表的索引 `raffle_activity_order`
--
ALTER TABLE `raffle_activity_order`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uq_order_id` (`order_id`),
  ADD KEY `idx_user_id_activity_id` (`user_id`,`activity_id`,`state`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `raffle_activity_account`
--
ALTER TABLE `raffle_activity_account`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID';

--
-- 使用表AUTO_INCREMENT `raffle_activity_account_flow`
--
ALTER TABLE `raffle_activity_account_flow`
  MODIFY `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID';

--
-- 使用表AUTO_INCREMENT `raffle_activity_order`
--
ALTER TABLE `raffle_activity_order`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID';
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
