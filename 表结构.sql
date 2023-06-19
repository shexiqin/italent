-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: italent
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `gen_table`
--

DROP TABLE IF EXISTS `gen_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gen_table` (
  `table_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) DEFAULT '' COMMENT '表描述',
  `sub_table_name` varchar(64) DEFAULT NULL COMMENT '关联子表的表名',
  `sub_table_fk_name` varchar(64) DEFAULT NULL COMMENT '子表关联的外键名',
  `class_name` varchar(100) DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作 sub主子表操作）',
  `package_name` varchar(100) DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) DEFAULT NULL COMMENT '生成功能作者',
  `gen_type` char(1) DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
  `gen_path` varchar(200) DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='代码生成业务表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gen_table`
--

LOCK TABLES `gen_table` WRITE;
/*!40000 ALTER TABLE `gen_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `gen_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gen_table_column`
--

DROP TABLE IF EXISTS `gen_table_column`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gen_table_column` (
  `column_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) DEFAULT '' COMMENT '字典类型',
  `sort` int DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='代码生成业务表字段';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gen_table_column`
--

LOCK TABLES `gen_table_column` WRITE;
/*!40000 ALTER TABLE `gen_table_column` DISABLE KEYS */;
/*!40000 ALTER TABLE `gen_table_column` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_blob_triggers`
--

DROP TABLE IF EXISTS `qrtz_blob_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_blob_triggers` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `blob_data` blob COMMENT '存放持久化Trigger对象',
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `QRTZ_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='Blob类型的触发器表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_blob_triggers`
--

LOCK TABLES `qrtz_blob_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_blob_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_blob_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_calendars`
--

DROP TABLE IF EXISTS `qrtz_calendars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_calendars` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `calendar_name` varchar(200) NOT NULL COMMENT '日历名称',
  `calendar` blob NOT NULL COMMENT '存放持久化calendar对象',
  PRIMARY KEY (`sched_name`,`calendar_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='日历信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_calendars`
--

LOCK TABLES `qrtz_calendars` WRITE;
/*!40000 ALTER TABLE `qrtz_calendars` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_calendars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_cron_triggers`
--

DROP TABLE IF EXISTS `qrtz_cron_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_cron_triggers` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `cron_expression` varchar(200) NOT NULL COMMENT 'cron表达式',
  `time_zone_id` varchar(80) DEFAULT NULL COMMENT '时区',
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `QRTZ_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='Cron类型的触发器表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_cron_triggers`
--

LOCK TABLES `qrtz_cron_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_cron_triggers` DISABLE KEYS */;
INSERT INTO `qrtz_cron_triggers` (`sched_name`, `trigger_name`, `trigger_group`, `cron_expression`, `time_zone_id`) VALUES ('RuoyiScheduler','TASK_CLASS_NAME1','DEFAULT','0/10 * * * * ?','Asia/Shanghai'),('RuoyiScheduler','TASK_CLASS_NAME2','DEFAULT','0/15 * * * * ?','Asia/Shanghai'),('RuoyiScheduler','TASK_CLASS_NAME3','DEFAULT','0/20 * * * * ?','Asia/Shanghai');
/*!40000 ALTER TABLE `qrtz_cron_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_fired_triggers`
--

DROP TABLE IF EXISTS `qrtz_fired_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_fired_triggers` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `entry_id` varchar(95) NOT NULL COMMENT '调度器实例id',
  `trigger_name` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `instance_name` varchar(200) NOT NULL COMMENT '调度器实例名',
  `fired_time` bigint NOT NULL COMMENT '触发的时间',
  `sched_time` bigint NOT NULL COMMENT '定时器制定的时间',
  `priority` int NOT NULL COMMENT '优先级',
  `state` varchar(16) NOT NULL COMMENT '状态',
  `job_name` varchar(200) DEFAULT NULL COMMENT '任务名称',
  `job_group` varchar(200) DEFAULT NULL COMMENT '任务组名',
  `is_nonconcurrent` varchar(1) DEFAULT NULL COMMENT '是否并发',
  `requests_recovery` varchar(1) DEFAULT NULL COMMENT '是否接受恢复执行',
  PRIMARY KEY (`sched_name`,`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='已触发的触发器表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_fired_triggers`
--

LOCK TABLES `qrtz_fired_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_fired_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_fired_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_job_details`
--

DROP TABLE IF EXISTS `qrtz_job_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_job_details` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `job_name` varchar(200) NOT NULL COMMENT '任务名称',
  `job_group` varchar(200) NOT NULL COMMENT '任务组名',
  `description` varchar(250) DEFAULT NULL COMMENT '相关介绍',
  `job_class_name` varchar(250) NOT NULL COMMENT '执行任务类名称',
  `is_durable` varchar(1) NOT NULL COMMENT '是否持久化',
  `is_nonconcurrent` varchar(1) NOT NULL COMMENT '是否并发',
  `is_update_data` varchar(1) NOT NULL COMMENT '是否更新数据',
  `requests_recovery` varchar(1) NOT NULL COMMENT '是否接受恢复执行',
  `job_data` blob COMMENT '存放持久化job对象',
  PRIMARY KEY (`sched_name`,`job_name`,`job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='任务详细信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_job_details`
--

LOCK TABLES `qrtz_job_details` WRITE;
/*!40000 ALTER TABLE `qrtz_job_details` DISABLE KEYS */;
INSERT INTO `qrtz_job_details` (`sched_name`, `job_name`, `job_group`, `description`, `job_class_name`, `is_durable`, `is_nonconcurrent`, `is_update_data`, `requests_recovery`, `job_data`) VALUES ('RuoyiScheduler','TASK_CLASS_NAME1','DEFAULT',NULL,'com.ruoyi.quartz.util.QuartzDisallowConcurrentExecution','0','1','0','0',_binary '��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0TASK_PROPERTIESsr\0com.ruoyi.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0\nconcurrentt\0Ljava/lang/String;L\0cronExpressionq\0~\0	L\0invokeTargetq\0~\0	L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0\'com.ruoyi.common.core.domain.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0�|��xpt\0\0pppt\01t\00/10 * * * * ?t\0ryTask.ryNoParamst\0DEFAULTsr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0系统默认（无参）t\03t\01x\0'),('RuoyiScheduler','TASK_CLASS_NAME2','DEFAULT',NULL,'com.ruoyi.quartz.util.QuartzDisallowConcurrentExecution','0','1','0','0',_binary '��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0TASK_PROPERTIESsr\0com.ruoyi.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0\nconcurrentt\0Ljava/lang/String;L\0cronExpressionq\0~\0	L\0invokeTargetq\0~\0	L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0\'com.ruoyi.common.core.domain.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0�|��xpt\0\0pppt\01t\00/15 * * * * ?t\0ryTask.ryParams(\'ry\')t\0DEFAULTsr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0系统默认（有参）t\03t\01x\0'),('RuoyiScheduler','TASK_CLASS_NAME3','DEFAULT',NULL,'com.ruoyi.quartz.util.QuartzDisallowConcurrentExecution','0','1','0','0',_binary '��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0TASK_PROPERTIESsr\0com.ruoyi.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0\nconcurrentt\0Ljava/lang/String;L\0cronExpressionq\0~\0	L\0invokeTargetq\0~\0	L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0\'com.ruoyi.common.core.domain.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0�|��xpt\0\0pppt\01t\00/20 * * * * ?t\08ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)t\0DEFAULTsr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0系统默认（多参）t\03t\01x\0');
/*!40000 ALTER TABLE `qrtz_job_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_locks`
--

DROP TABLE IF EXISTS `qrtz_locks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_locks` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `lock_name` varchar(40) NOT NULL COMMENT '悲观锁名称',
  PRIMARY KEY (`sched_name`,`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='存储的悲观锁信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_locks`
--

LOCK TABLES `qrtz_locks` WRITE;
/*!40000 ALTER TABLE `qrtz_locks` DISABLE KEYS */;
INSERT INTO `qrtz_locks` (`sched_name`, `lock_name`) VALUES ('RuoyiScheduler','STATE_ACCESS'),('RuoyiScheduler','TRIGGER_ACCESS');
/*!40000 ALTER TABLE `qrtz_locks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_paused_trigger_grps`
--

DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `trigger_group` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  PRIMARY KEY (`sched_name`,`trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='暂停的触发器表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_paused_trigger_grps`
--

LOCK TABLES `qrtz_paused_trigger_grps` WRITE;
/*!40000 ALTER TABLE `qrtz_paused_trigger_grps` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_paused_trigger_grps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_scheduler_state`
--

DROP TABLE IF EXISTS `qrtz_scheduler_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_scheduler_state` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `instance_name` varchar(200) NOT NULL COMMENT '实例名称',
  `last_checkin_time` bigint NOT NULL COMMENT '上次检查时间',
  `checkin_interval` bigint NOT NULL COMMENT '检查间隔时间',
  PRIMARY KEY (`sched_name`,`instance_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='调度器状态表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_scheduler_state`
--

LOCK TABLES `qrtz_scheduler_state` WRITE;
/*!40000 ALTER TABLE `qrtz_scheduler_state` DISABLE KEYS */;
INSERT INTO `qrtz_scheduler_state` (`sched_name`, `instance_name`, `last_checkin_time`, `checkin_interval`) VALUES ('RuoyiScheduler','DESKTOP-6URAA5V1649749380303',1649749451665,15000);
/*!40000 ALTER TABLE `qrtz_scheduler_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_simple_triggers`
--

DROP TABLE IF EXISTS `qrtz_simple_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_simple_triggers` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `repeat_count` bigint NOT NULL COMMENT '重复的次数统计',
  `repeat_interval` bigint NOT NULL COMMENT '重复的间隔时间',
  `times_triggered` bigint NOT NULL COMMENT '已经触发的次数',
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `QRTZ_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='简单触发器的信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_simple_triggers`
--

LOCK TABLES `qrtz_simple_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_simple_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_simple_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_simprop_triggers`
--

DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_simprop_triggers` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `str_prop_1` varchar(512) DEFAULT NULL COMMENT 'String类型的trigger的第一个参数',
  `str_prop_2` varchar(512) DEFAULT NULL COMMENT 'String类型的trigger的第二个参数',
  `str_prop_3` varchar(512) DEFAULT NULL COMMENT 'String类型的trigger的第三个参数',
  `int_prop_1` int DEFAULT NULL COMMENT 'int类型的trigger的第一个参数',
  `int_prop_2` int DEFAULT NULL COMMENT 'int类型的trigger的第二个参数',
  `long_prop_1` bigint DEFAULT NULL COMMENT 'long类型的trigger的第一个参数',
  `long_prop_2` bigint DEFAULT NULL COMMENT 'long类型的trigger的第二个参数',
  `dec_prop_1` decimal(13,4) DEFAULT NULL COMMENT 'decimal类型的trigger的第一个参数',
  `dec_prop_2` decimal(13,4) DEFAULT NULL COMMENT 'decimal类型的trigger的第二个参数',
  `bool_prop_1` varchar(1) DEFAULT NULL COMMENT 'Boolean类型的trigger的第一个参数',
  `bool_prop_2` varchar(1) DEFAULT NULL COMMENT 'Boolean类型的trigger的第二个参数',
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `QRTZ_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='同步机制的行锁表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_simprop_triggers`
--

LOCK TABLES `qrtz_simprop_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_simprop_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_simprop_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_triggers`
--

DROP TABLE IF EXISTS `qrtz_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_triggers` (
  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) NOT NULL COMMENT '触发器的名字',
  `trigger_group` varchar(200) NOT NULL COMMENT '触发器所属组的名字',
  `job_name` varchar(200) NOT NULL COMMENT 'qrtz_job_details表job_name的外键',
  `job_group` varchar(200) NOT NULL COMMENT 'qrtz_job_details表job_group的外键',
  `description` varchar(250) DEFAULT NULL COMMENT '相关介绍',
  `next_fire_time` bigint DEFAULT NULL COMMENT '上一次触发时间（毫秒）',
  `prev_fire_time` bigint DEFAULT NULL COMMENT '下一次触发时间（默认为-1表示不触发）',
  `priority` int DEFAULT NULL COMMENT '优先级',
  `trigger_state` varchar(16) NOT NULL COMMENT '触发器状态',
  `trigger_type` varchar(8) NOT NULL COMMENT '触发器的类型',
  `start_time` bigint NOT NULL COMMENT '开始时间',
  `end_time` bigint DEFAULT NULL COMMENT '结束时间',
  `calendar_name` varchar(200) DEFAULT NULL COMMENT '日程表名称',
  `misfire_instr` smallint DEFAULT NULL COMMENT '补偿执行的策略',
  `job_data` blob COMMENT '存放持久化job对象',
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  KEY `sched_name` (`sched_name`,`job_name`,`job_group`),
  CONSTRAINT `QRTZ_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `qrtz_job_details` (`sched_name`, `job_name`, `job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='触发器详细信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_triggers`
--

LOCK TABLES `qrtz_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_triggers` DISABLE KEYS */;
INSERT INTO `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`, `job_name`, `job_group`, `description`, `next_fire_time`, `prev_fire_time`, `priority`, `trigger_state`, `trigger_type`, `start_time`, `end_time`, `calendar_name`, `misfire_instr`, `job_data`) VALUES ('RuoyiScheduler','TASK_CLASS_NAME1','DEFAULT','TASK_CLASS_NAME1','DEFAULT',NULL,1649749380000,-1,5,'PAUSED','CRON',1649749380000,0,NULL,2,''),('RuoyiScheduler','TASK_CLASS_NAME2','DEFAULT','TASK_CLASS_NAME2','DEFAULT',NULL,1649749395000,-1,5,'PAUSED','CRON',1649749382000,0,NULL,2,''),('RuoyiScheduler','TASK_CLASS_NAME3','DEFAULT','TASK_CLASS_NAME3','DEFAULT',NULL,1649749400000,-1,5,'PAUSED','CRON',1649749383000,0,NULL,2,'');
/*!40000 ALTER TABLE `qrtz_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_config`
--

DROP TABLE IF EXISTS `sys_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_config` (
  `config_id` int NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb3 COMMENT='参数配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_config`
--

LOCK TABLES `sys_config` WRITE;
/*!40000 ALTER TABLE `sys_config` DISABLE KEYS */;
INSERT INTO `sys_config` (`config_id`, `config_name`, `config_key`, `config_value`, `config_type`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1,'主框架页-默认皮肤样式名称','sys.index.skinName','skin-blue','Y','admin','2022-04-03 16:13:36','',NULL,'蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow'),(2,'用户管理-账号初始密码','sys.user.initPassword','123456','Y','admin','2022-04-03 16:13:36','',NULL,'初始化密码 123456'),(3,'主框架页-侧边栏主题','sys.index.sideTheme','theme-dark','Y','admin','2022-04-03 16:13:36','',NULL,'深黑主题theme-dark，浅色主题theme-light，深蓝主题theme-blue'),(4,'账号自助-是否开启用户注册功能','sys.account.registerUser','false','Y','admin','2022-04-03 16:13:36','',NULL,'是否开启注册用户功能（true开启，false关闭）'),(5,'用户管理-密码字符范围','sys.account.chrtype','0','Y','admin','2022-04-03 16:13:36','',NULL,'默认任意字符范围，0任意（密码可以输入任意字符），1数字（密码只能为0-9数字），2英文字母（密码只能为a-z和A-Z字母），3字母和数字（密码必须包含字母，数字）,4字母数字和特殊字符（目前支持的特殊字符包括：~!@#$%^&*()-=_+）'),(6,'用户管理-初始密码修改策略','sys.account.initPasswordModify','0','Y','admin','2022-04-03 16:13:36','',NULL,'0：初始密码修改策略关闭，没有任何提示，1：提醒用户，如果未修改初始密码，则在登录时就会提醒修改密码对话框'),(7,'用户管理-账号密码更新周期','sys.account.passwordValidateDays','0','Y','admin','2022-04-03 16:13:36','',NULL,'密码更新周期（填写数字，数据初始化值为0不限制，若修改必须为大于0小于365的正整数），如果超过这个周期登录系统时，则在登录时就会提醒修改密码对话框'),(8,'主框架页-菜单导航显示风格','sys.index.menuStyle','topnav','Y','admin','2022-04-03 16:13:36','admin','2022-06-09 15:05:01','菜单导航显示风格（default为左侧导航菜单，topnav为顶部导航菜单）'),(9,'主框架页-是否开启页脚','sys.index.footer','true','Y','admin','2022-04-03 16:13:36','',NULL,'是否开启底部页脚显示（true显示，false隐藏）'),(10,'主框架页-是否开启页签','sys.index.tagsView','true','Y','admin','2022-04-03 16:13:36','',NULL,'是否开启菜单多页签显示（true显示，false隐藏）'),(100,'应聘登记二维码路径前缀','resume_gather','http://localhost:8087/italent/resume/addReg','Y','admin','2023-03-23 11:41:33','admin','2023-06-05 09:54:02',''),(101,'外网路径前缀','out.url.prefix','http://localhost:8087','Y','admin','2023-03-24 14:31:02','admin','2023-06-05 09:53:56','');
/*!40000 ALTER TABLE `sys_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dept` (
  `dept_id` bigint NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8mb3 COMMENT='部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
INSERT INTO `sys_dept` (`dept_id`, `parent_id`, `ancestors`, `dept_name`, `order_num`, `leader`, `phone`, `email`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (100,0,'0','八六三软件',0,'若依','15888888888','ry@qq.com','0','0','admin','2022-04-03 16:13:36','',NULL),(101,100,'0,100','03-测评中心',3,'','','','0','0','admin','2022-04-03 16:13:36','admin','2022-06-02 15:14:26'),(102,100,'0,100','02-营销中心',2,'','','','0','0','admin','2022-04-03 16:13:36','admin','2022-06-02 15:13:17'),(103,101,'0,100,101','测评部',1,'','','','0','0','admin','2022-04-03 16:13:36','admin','2022-06-02 15:14:44'),(104,101,'0,100,101','业务一部',2,'','','','0','0','admin','2022-04-03 16:13:36','admin','2022-06-02 15:15:11'),(105,101,'0,100,101','业务二部',3,'','','','0','0','admin','2022-04-03 16:13:36','admin','2022-06-02 15:15:21'),(106,101,'0,100,101','实验室',4,'','','','0','0','admin','2022-04-03 16:13:36','admin','2022-06-02 15:15:31'),(107,101,'0,100,101','运维部门',5,'若依','15888888888','ry@qq.com','0','2','admin','2022-04-03 16:13:36','',NULL),(108,102,'0,100,102','软件服务一部',1,'','','','0','0','admin','2022-04-03 16:13:36','admin','2022-06-02 15:13:48'),(109,102,'0,100,102','软件服务二部',2,'','','','0','0','admin','2022-04-03 16:13:36','admin','2022-06-02 15:14:02'),(200,100,'0,100','01-总经办',1,'','','','0','0','admin','2022-06-02 15:12:15','admin','2022-06-02 15:13:24'),(201,100,'0,100','04-开发中心',4,NULL,NULL,NULL,'0','0','admin','2022-06-02 15:16:17','',NULL),(202,201,'0,100,201','开发一部',1,NULL,NULL,NULL,'0','0','admin','2022-06-02 15:16:29','',NULL),(203,201,'0,100,201','开发二部',2,NULL,NULL,NULL,'0','0','admin','2022-06-02 15:16:36','',NULL);
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_data`
--

DROP TABLE IF EXISTS `sys_dict_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict_data` (
  `dict_code` bigint NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8mb3 COMMENT='字典数据表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_data`
--

LOCK TABLES `sys_dict_data` WRITE;
/*!40000 ALTER TABLE `sys_dict_data` DISABLE KEYS */;
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1,1,'男','0','sys_user_sex','','','Y','0','admin','2022-04-03 16:13:36','',NULL,'性别男'),(2,2,'女','1','sys_user_sex','','','N','0','admin','2022-04-03 16:13:36','',NULL,'性别女'),(3,3,'未知','2','sys_user_sex','','','N','0','admin','2022-04-03 16:13:36','',NULL,'性别未知'),(4,1,'显示','0','sys_show_hide','','primary','Y','0','admin','2022-04-03 16:13:36','',NULL,'显示菜单'),(5,2,'隐藏','1','sys_show_hide','','danger','N','0','admin','2022-04-03 16:13:36','',NULL,'隐藏菜单'),(6,1,'正常','0','sys_normal_disable','','primary','Y','0','admin','2022-04-03 16:13:36','',NULL,'正常状态'),(7,2,'停用','1','sys_normal_disable','','danger','N','0','admin','2022-04-03 16:13:36','',NULL,'停用状态'),(8,1,'正常','0','sys_job_status','','primary','Y','0','admin','2022-04-03 16:13:36','',NULL,'正常状态'),(9,2,'暂停','1','sys_job_status','','danger','N','0','admin','2022-04-03 16:13:36','',NULL,'停用状态'),(10,1,'默认','DEFAULT','sys_job_group','','','Y','0','admin','2022-04-03 16:13:36','',NULL,'默认分组'),(11,2,'系统','SYSTEM','sys_job_group','','','N','0','admin','2022-04-03 16:13:36','',NULL,'系统分组'),(12,1,'是','Y','sys_yes_no','','primary','Y','0','admin','2022-04-03 16:13:36','',NULL,'系统默认是'),(13,2,'否','N','sys_yes_no','','danger','N','0','admin','2022-04-03 16:13:36','',NULL,'系统默认否'),(14,1,'通知','1','sys_notice_type','','warning','Y','0','admin','2022-04-03 16:13:36','',NULL,'通知'),(15,2,'公告','2','sys_notice_type','','success','N','0','admin','2022-04-03 16:13:36','',NULL,'公告'),(16,1,'正常','0','sys_notice_status','','primary','Y','0','admin','2022-04-03 16:13:36','',NULL,'正常状态'),(17,2,'关闭','1','sys_notice_status','','danger','N','0','admin','2022-04-03 16:13:36','',NULL,'关闭状态'),(18,99,'其他','0','sys_oper_type','','info','N','0','admin','2022-04-03 16:13:36','',NULL,'其他操作'),(19,1,'新增','1','sys_oper_type','','info','N','0','admin','2022-04-03 16:13:36','',NULL,'新增操作'),(20,2,'修改','2','sys_oper_type','','info','N','0','admin','2022-04-03 16:13:36','',NULL,'修改操作'),(21,3,'删除','3','sys_oper_type','','danger','N','0','admin','2022-04-03 16:13:36','',NULL,'删除操作'),(22,4,'授权','4','sys_oper_type','','primary','N','0','admin','2022-04-03 16:13:36','',NULL,'授权操作'),(23,5,'导出','5','sys_oper_type','','warning','N','0','admin','2022-04-03 16:13:36','',NULL,'导出操作'),(24,6,'导入','6','sys_oper_type','','warning','N','0','admin','2022-04-03 16:13:36','',NULL,'导入操作'),(25,7,'强退','7','sys_oper_type','','danger','N','0','admin','2022-04-03 16:13:36','',NULL,'强退操作'),(26,8,'生成代码','8','sys_oper_type','','warning','N','0','admin','2022-04-03 16:13:36','',NULL,'生成操作'),(27,9,'清空数据','9','sys_oper_type','','danger','N','0','admin','2022-04-03 16:13:36','',NULL,'清空操作'),(28,1,'成功','0','sys_common_status','','primary','N','0','admin','2022-04-03 16:13:36','',NULL,'正常状态'),(29,2,'失败','1','sys_common_status','','danger','N','0','admin','2022-04-03 16:13:36','',NULL,'停用状态'),(30,1,'未沟通','0','resume_status','','','N','0','zss',NULL,'admin','2022-06-02 17:51:10','未沟通'),(31,2,'未约到','1','resume_status',NULL,NULL,'N','0','zss',NULL,'',NULL,'未约到'),(32,3,'已邀约','2','resume_status','','primary','N','0','zss',NULL,'admin','2022-07-05 13:48:22','已邀约'),(33,0,'已归档','3','resume_status','','','Y','0','zss',NULL,'admin','2022-07-05 13:44:00','已归档'),(34,5,'不合适','4','resume_status',NULL,NULL,'N','0','zss',NULL,'',NULL,'不合适'),(35,6,'黑名单','5','resume_status','','','N','0','zss',NULL,'admin','2022-07-25 13:22:48','黑名单'),(37,7,'已在职','6','resume_status','','','N','0','zss',NULL,'admin','2022-06-02 17:50:21','已经入职其他公司。'),(38,8,'待入职','7','resume_status','','','N','0','zss',NULL,'admin','2022-06-02 17:50:46','其他公司面试通过，待入职。'),(100,1,'BOSS直聘','BOSS直聘','resume_from','','','N','0','admin','2022-06-01 14:25:11','admin','2022-06-02 23:57:31',''),(101,2,'猎聘网','猎聘网','resume_from','','','N','0','admin','2022-06-01 14:25:30','admin','2022-07-29 10:23:34',''),(102,3,'智联招聘','智联招聘','resume_from','','','N','0','admin','2022-06-01 14:25:43','admin','2022-06-02 23:57:40',''),(103,4,'58同城','58同城','resume_from','','','N','0','admin','2022-06-01 14:25:56','admin','2022-06-02 23:57:44',''),(104,99,'其他','其他','resume_from','','','N','0','admin','2022-06-01 14:26:17','admin','2023-03-28 16:19:06',''),(105,1,'未安排','1','resume_progress','','danger','Y','0','admin','2022-06-02 15:21:23','admin','2022-06-02 15:23:46',''),(106,2,'面试中','2','resume_progress','','warning','Y','0','admin','2022-06-02 15:21:32','admin','2022-06-02 15:23:50',''),(107,4,'面试完毕','3','resume_progress','','info','Y','0','admin','2022-06-02 15:22:01','admin','2022-09-22 13:53:10',''),(108,5,'准备入职','4','resume_progress','','success','Y','0','admin','2022-06-02 15:22:10','admin','2022-09-22 13:53:17',''),(109,6,'入职成功','5','resume_progress','','primary','Y','0','admin','2022-06-02 15:22:30','admin','2022-09-22 13:53:23',''),(110,5,'前程无忧','前程无忧','resume_from','','','N','0','admin','2022-06-04 14:40:17','admin','2022-07-29 10:24:20',''),(111,1,'0 - 3 年','1','job_year',NULL,NULL,'Y','0','admin','2022-07-15 11:20:14','',NULL,NULL),(112,2,'3 - 5 年','2','job_year',NULL,NULL,'Y','0','admin','2022-07-15 11:20:25','',NULL,NULL),(113,3,'5 - 10 年','3','job_year',NULL,NULL,'Y','0','admin','2022-07-15 11:20:45','',NULL,NULL),(114,4,'10 年以上','4','job_year','','','Y','0','admin','2022-07-15 11:21:07','admin','2022-07-15 11:51:18',''),(115,5,'自定义','5','job_year',NULL,NULL,'Y','0','admin','2022-07-15 11:22:32','',NULL,NULL),(116,1,'学信网','学信网','educational_background_type','','','N','0','admin','2022-07-25 14:07:09','admin','2022-07-28 11:46:34',''),(117,2,'民教网','民教网','educational_background_type','','','N','0','admin','2022-07-25 14:07:39','admin','2022-07-28 11:46:38',''),(118,1,'统招','统招','enroll_type',NULL,NULL,'Y','0','admin','2022-07-28 11:46:58','',NULL,NULL),(119,2,'成教','成教','enroll_type',NULL,NULL,'Y','0','admin','2022-07-28 11:47:10','',NULL,NULL),(120,3,'自考','自考','enroll_type',NULL,NULL,'Y','0','admin','2022-07-28 11:47:17','',NULL,NULL),(121,4,'函授','函授','enroll_type',NULL,NULL,'Y','0','admin','2022-07-28 11:47:26','',NULL,NULL),(122,5,'在职','在职','enroll_type',NULL,NULL,'Y','0','admin','2022-07-28 11:47:33','',NULL,NULL),(123,6,'内部推荐','内部推荐','resume_from','','','N','0','admin','2022-07-29 10:24:02','admin','2023-03-28 16:19:49',''),(136,7,'外部推荐','外部推荐','resume_from','','','Y','0','admin','2022-07-29 15:04:50','admin','2023-03-23 15:56:02','1'),(137,7,'已推荐客户','6','resume_progress','','primary','Y','0','admin','2022-09-15 11:03:24','admin','2022-09-22 13:53:27',''),(139,3,'跟进中','7','resume_progress','','primary','Y','0','admin','2022-09-22 12:05:20','admin','2022-09-22 13:53:38',''),(140,8,'离职人员','离职人员','resume_from','','','Y','0','admin','2023-02-17 14:06:04','admin','2023-03-23 15:56:05','1'),(141,1,'模板','2','template_status','','','N','1','admin','2023-03-24 14:20:41','admin','2023-06-02 09:58:26',''),(142,2,'非模板','1','template_status','','','N','0','admin','2023-03-24 14:20:49','admin','2023-03-24 14:22:13',''),(143,1,'未发布','1','publish_status',NULL,NULL,'Y','0','admin','2023-03-24 14:25:26','',NULL,NULL),(144,2,'已发布','2','publish_status','','primary','Y','0','admin','2023-03-24 14:25:38','admin','2023-03-24 14:25:44',''),(145,1,'匿名','匿名','naire_anonymous_status',NULL,NULL,'Y','0','admin','2023-03-24 17:20:59','',NULL,NULL),(146,2,'实名','实名','naire_anonymous_status',NULL,NULL,'Y','0','admin','2023-03-24 17:21:07','',NULL,NULL),(147,1,'大数据','大数据','trade_classify',NULL,NULL,'Y','0','admin','2023-03-25 19:04:22','',NULL,NULL),(148,2,'政务','政务','trade_classify','','','Y','0','admin','2023-03-25 19:04:22','admin','2023-03-25 19:07:51',''),(149,3,'工业','工业','trade_classify',NULL,NULL,'Y','0','admin','2023-03-25 19:04:22','',NULL,NULL),(150,4,'制造业','制造业','trade_classify',NULL,NULL,'Y','0','admin','2023-03-25 19:04:22','',NULL,NULL),(151,5,'教育','教育','trade_classify',NULL,NULL,'Y','0','admin','2023-03-25 19:04:22','',NULL,NULL),(152,6,'电力','电力','trade_classify',NULL,NULL,'Y','0','admin','2023-03-25 19:04:22','',NULL,NULL),(153,7,'医疗','医疗','trade_classify',NULL,NULL,'Y','0','admin','2023-03-25 19:04:22','',NULL,NULL),(154,8,'环保','环保','trade_classify',NULL,NULL,'Y','0','admin','2023-03-25 19:04:22','',NULL,NULL),(155,9,'公安','公安','trade_classify',NULL,NULL,'Y','0','admin','2023-03-25 19:04:22','',NULL,NULL),(156,10,'互联网电商','互联网电商','trade_classify',NULL,NULL,'Y','0','admin','2023-03-25 19:04:22','',NULL,NULL),(157,11,'快消品','快消品','trade_classify',NULL,NULL,'Y','0','admin','2023-03-25 19:04:22','',NULL,NULL),(158,12,'连锁商超','连锁商超','trade_classify',NULL,NULL,'Y','0','admin','2023-03-25 19:04:22','',NULL,NULL),(159,13,'产业园','产业园','trade_classify',NULL,NULL,'Y','0','admin','2023-03-25 19:04:22','',NULL,NULL),(160,14,'房地产','房地产','trade_classify',NULL,NULL,'Y','0','admin','2023-03-25 19:04:22','',NULL,NULL),(161,15,'其他','其他','trade_classify',NULL,NULL,'Y','0','admin','2023-03-25 19:04:22','',NULL,NULL),(162,1,'专科','专科','edu_level',NULL,NULL,'Y','0','admin','2023-03-28 11:44:20','',NULL,NULL),(163,2,'本科','本科','edu_level',NULL,NULL,'Y','0','admin','2023-03-28 11:44:28','',NULL,NULL),(164,3,'硕士','硕士','edu_level',NULL,NULL,'Y','0','admin','2023-03-28 11:44:40','',NULL,NULL),(165,4,'博士','博士','edu_level',NULL,NULL,'Y','0','admin','2023-03-28 11:44:48','',NULL,NULL),(166,5,'其他','其他','edu_level',NULL,NULL,'Y','0','admin','2023-03-28 11:44:58','',NULL,NULL),(167,1,'统招','统招','admission_type',NULL,NULL,'Y','0','admin','2023-03-28 17:03:44','',NULL,NULL),(168,2,'自考','自考','admission_type',NULL,NULL,'Y','0','admin','2023-03-28 17:04:00','',NULL,NULL),(169,3,'成教','成教','admission_type',NULL,NULL,'Y','0','admin','2023-03-28 17:04:11','',NULL,NULL),(170,4,'函授','函授','admission_type',NULL,NULL,'Y','0','admin','2023-03-28 17:04:22','',NULL,NULL),(171,5,'在职','在职','admission_type',NULL,NULL,'Y','0','admin','2023-03-28 17:04:31','',NULL,NULL);
/*!40000 ALTER TABLE `sys_dict_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_type`
--

DROP TABLE IF EXISTS `sys_dict_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict_type` (
  `dict_id` bigint NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8mb3 COMMENT='字典类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_type`
--

LOCK TABLES `sys_dict_type` WRITE;
/*!40000 ALTER TABLE `sys_dict_type` DISABLE KEYS */;
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1,'用户性别','sys_user_sex','0','admin','2022-04-03 16:13:36','',NULL,'用户性别列表'),(2,'菜单状态','sys_show_hide','0','admin','2022-04-03 16:13:36','',NULL,'菜单状态列表'),(3,'系统开关','sys_normal_disable','0','admin','2022-04-03 16:13:36','',NULL,'系统开关列表'),(4,'任务状态','sys_job_status','0','admin','2022-04-03 16:13:36','',NULL,'任务状态列表'),(5,'任务分组','sys_job_group','0','admin','2022-04-03 16:13:36','',NULL,'任务分组列表'),(6,'系统是否','sys_yes_no','0','admin','2022-04-03 16:13:36','',NULL,'系统是否列表'),(7,'通知类型','sys_notice_type','0','admin','2022-04-03 16:13:36','',NULL,'通知类型列表'),(8,'通知状态','sys_notice_status','0','admin','2022-04-03 16:13:36','',NULL,'通知状态列表'),(9,'操作类型','sys_oper_type','0','admin','2022-04-03 16:13:36','',NULL,'操作类型列表'),(10,'系统状态','sys_common_status','0','admin','2022-04-03 16:13:36','',NULL,'登录状态列表'),(11,'简历状态','resume_status','0','zss','2022-04-18 21:23:49','admin','2022-06-02 15:08:38','标签状态'),(100,'简历来源','resume_from','0','admin','2022-06-01 14:24:32','admin','2022-06-02 15:08:49','简历来源'),(102,'面试进度','resume_progress','0','admin','2022-06-02 15:21:09','',NULL,'面试进度'),(103,'职位级别','resume_level','0','admin','2022-06-02 15:26:37','admin','2022-06-02 16:20:12','职位级别'),(104,'工作年限','job_year','0','admin','2022-07-15 11:19:46','',NULL,NULL),(105,'学历类型','educational_background_type','0','admin','2022-07-25 14:06:53','admin','2023-03-28 17:03:31',''),(106,'录取方式','enroll_type','0','admin','2022-07-28 11:46:25','',NULL,NULL),(107,'模板标识','template_status','0','admin','2023-03-24 14:20:17','',NULL,'适用于问卷模块'),(108,'发布状态','publish_status','0','admin','2023-03-24 14:25:06','',NULL,NULL),(109,'问卷匿名状态','naire_anonymous_status','0','admin','2023-03-24 17:19:53','',NULL,NULL),(110,'行业种类','trade_classify','0','admin','2023-03-25 18:56:03','',NULL,NULL),(111,'学历分类','edu_level','0','admin','2023-03-28 11:44:07','',NULL,NULL),(112,'录取方式','admission_type','0','admin','2023-03-28 17:03:20','',NULL,NULL);
/*!40000 ALTER TABLE `sys_dict_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_job`
--

DROP TABLE IF EXISTS `sys_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_job` (
  `job_id` bigint NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb3 COMMENT='定时任务调度表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_job`
--

LOCK TABLES `sys_job` WRITE;
/*!40000 ALTER TABLE `sys_job` DISABLE KEYS */;
INSERT INTO `sys_job` (`job_id`, `job_name`, `job_group`, `invoke_target`, `cron_expression`, `misfire_policy`, `concurrent`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1,'系统默认（无参）','DEFAULT','ryTask.ryNoParams','0/10 * * * * ?','3','1','1','admin','2022-04-03 16:13:36','',NULL,''),(2,'系统默认（有参）','DEFAULT','ryTask.ryParams(\'ry\')','0/15 * * * * ?','3','1','1','admin','2022-04-03 16:13:36','',NULL,''),(3,'系统默认（多参）','DEFAULT','ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)','0/20 * * * * ?','3','1','1','admin','2022-04-03 16:13:36','',NULL,'');
/*!40000 ALTER TABLE `sys_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_job_log`
--

DROP TABLE IF EXISTS `sys_job_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_job_log` (
  `job_log_id` bigint NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
  `status` char(1) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) DEFAULT '' COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='定时任务调度日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_job_log`
--

LOCK TABLES `sys_job_log` WRITE;
/*!40000 ALTER TABLE `sys_job_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_job_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_logininfor`
--

DROP TABLE IF EXISTS `sys_logininfor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_logininfor` (
  `info_id` bigint NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `ipaddr` varchar(128) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='系统访问记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_logininfor`
--

LOCK TABLES `sys_logininfor` WRITE;
/*!40000 ALTER TABLE `sys_logininfor` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_logininfor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_menu` (
  `menu_id` bigint NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) DEFAULT '#' COMMENT '请求地址',
  `target` varchar(20) DEFAULT '' COMMENT '打开方式（menuItem页签 menuBlank新窗口）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `is_refresh` char(1) DEFAULT '1' COMMENT '是否刷新（0刷新 1不刷新）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2088 DEFAULT CHARSET=utf8mb3 COMMENT='菜单权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1,'系统管理',0,997,'#','menuItem','M','0','1','','fa fa-gear','admin','2022-06-02 14:54:29','admin','2022-06-02 15:02:31','系统管理目录'),(2,'系统监控',0,998,'#','menuItem','M','1','1','','fa fa-video-camera','admin','2022-06-02 14:54:29','admin','2022-06-02 15:02:43','系统监控目录'),(3,'系统工具',0,999,'#','menuItem','M','1','1','','fa fa-bars','admin','2022-06-02 14:54:29','admin','2023-05-24 12:29:32','系统工具目录'),(100,'用户管理',1,1,'/system/user','','C','0','1','system:user:view','fa fa-user-o','admin','2022-06-02 14:54:29','',NULL,'用户管理菜单'),(101,'角色管理',1,2,'/system/role','','C','0','1','system:role:view','fa fa-user-secret','admin','2022-06-02 14:54:29','',NULL,'角色管理菜单'),(102,'菜单管理',1,3,'/system/menu','','C','0','1','system:menu:view','fa fa-th-list','admin','2022-06-02 14:54:29','',NULL,'菜单管理菜单'),(103,'部门管理',1,4,'/system/dept','','C','0','1','system:dept:view','fa fa-outdent','admin','2022-06-02 14:54:29','',NULL,'部门管理菜单'),(104,'岗位管理',1,5,'/system/post','','C','0','1','system:post:view','fa fa-address-card-o','admin','2022-06-02 14:54:29','',NULL,'岗位管理菜单'),(105,'字典管理',1,6,'/system/dict','','C','0','1','system:dict:view','fa fa-bookmark-o','admin','2022-06-02 14:54:29','',NULL,'字典管理菜单'),(106,'参数设置',1,7,'/system/config','','C','0','1','system:config:view','fa fa-sun-o','admin','2022-06-02 14:54:30','',NULL,'参数设置菜单'),(107,'通知公告',1,8,'/system/notice','','C','0','1','system:notice:view','fa fa-bullhorn','admin','2022-06-02 14:54:30','',NULL,'通知公告菜单'),(108,'日志管理',1,9,'#','','M','0','1','','fa fa-pencil-square-o','admin','2022-06-02 14:54:30','',NULL,'日志管理菜单'),(109,'在线用户',2,1,'/monitor/online','','C','0','1','monitor:online:view','fa fa-user-circle','admin','2022-06-02 14:54:30','',NULL,'在线用户菜单'),(110,'定时任务',2,2,'/monitor/job','','C','0','1','monitor:job:view','fa fa-tasks','admin','2022-06-02 14:54:30','',NULL,'定时任务菜单'),(111,'数据监控',2,3,'/monitor/data','','C','0','1','monitor:data:view','fa fa-bug','admin','2022-06-02 14:54:30','',NULL,'数据监控菜单'),(112,'服务监控',2,4,'/monitor/server','','C','0','1','monitor:server:view','fa fa-server','admin','2022-06-02 14:54:30','',NULL,'服务监控菜单'),(113,'缓存监控',2,5,'/monitor/cache','','C','0','1','monitor:cache:view','fa fa-cube','admin','2022-06-02 14:54:30','',NULL,'缓存监控菜单'),(114,'表单构建',3,1,'/tool/build','','C','0','1','tool:build:view','fa fa-wpforms','admin','2022-06-02 14:54:30','',NULL,'表单构建菜单'),(115,'代码生成',3,2,'/tool/gen','','C','0','1','tool:gen:view','fa fa-code','admin','2022-06-02 14:54:30','',NULL,'代码生成菜单'),(116,'系统接口',3,3,'/tool/swagger','','C','0','1','tool:swagger:view','fa fa-gg','admin','2022-06-02 14:54:30','',NULL,'系统接口菜单'),(500,'操作日志',108,1,'/monitor/operlog','','C','0','1','monitor:operlog:view','fa fa-address-book','admin','2022-06-02 14:54:30','',NULL,'操作日志菜单'),(501,'登录日志',108,2,'/monitor/logininfor','','C','0','1','monitor:logininfor:view','fa fa-file-image-o','admin','2022-06-02 14:54:30','',NULL,'登录日志菜单'),(1000,'用户查询',100,1,'#','','F','0','1','system:user:list','#','admin','2022-06-02 14:54:30','',NULL,''),(1001,'用户新增',100,2,'#','','F','0','1','system:user:add','#','admin','2022-06-02 14:54:30','',NULL,''),(1002,'用户修改',100,3,'#','','F','0','1','system:user:edit','#','admin','2022-06-02 14:54:30','',NULL,''),(1003,'用户删除',100,4,'#','','F','0','1','system:user:remove','#','admin','2022-06-02 14:54:30','',NULL,''),(1004,'用户导出',100,5,'#','','F','0','1','system:user:export','#','admin','2022-06-02 14:54:30','',NULL,''),(1005,'用户导入',100,6,'#','','F','0','1','system:user:import','#','admin','2022-06-02 14:54:30','',NULL,''),(1006,'重置密码',100,7,'#','','F','0','1','system:user:resetPwd','#','admin','2022-06-02 14:54:30','',NULL,''),(1007,'角色查询',101,1,'#','','F','0','1','system:role:list','#','admin','2022-06-02 14:54:30','',NULL,''),(1008,'角色新增',101,2,'#','','F','0','1','system:role:add','#','admin','2022-06-02 14:54:30','',NULL,''),(1009,'角色修改',101,3,'#','','F','0','1','system:role:edit','#','admin','2022-06-02 14:54:30','',NULL,''),(1010,'角色删除',101,4,'#','','F','0','1','system:role:remove','#','admin','2022-06-02 14:54:30','',NULL,''),(1011,'角色导出',101,5,'#','','F','0','1','system:role:export','#','admin','2022-06-02 14:54:30','',NULL,''),(1012,'菜单查询',102,1,'#','','F','0','1','system:menu:list','#','admin','2022-06-02 14:54:30','',NULL,''),(1013,'菜单新增',102,2,'#','','F','0','1','system:menu:add','#','admin','2022-06-02 14:54:30','',NULL,''),(1014,'菜单修改',102,3,'#','','F','0','1','system:menu:edit','#','admin','2022-06-02 14:54:30','',NULL,''),(1015,'菜单删除',102,4,'#','','F','0','1','system:menu:remove','#','admin','2022-06-02 14:54:30','',NULL,''),(1016,'部门查询',103,1,'#','','F','0','1','system:dept:list','#','admin','2022-06-02 14:54:30','',NULL,''),(1017,'部门新增',103,2,'#','','F','0','1','system:dept:add','#','admin','2022-06-02 14:54:30','',NULL,''),(1018,'部门修改',103,3,'#','','F','0','1','system:dept:edit','#','admin','2022-06-02 14:54:30','',NULL,''),(1019,'部门删除',103,4,'#','','F','0','1','system:dept:remove','#','admin','2022-06-02 14:54:30','',NULL,''),(1020,'岗位查询',104,1,'#','','F','0','1','system:post:list','#','admin','2022-06-02 14:54:30','',NULL,''),(1021,'岗位新增',104,2,'#','','F','0','1','system:post:add','#','admin','2022-06-02 14:54:30','',NULL,''),(1022,'岗位修改',104,3,'#','','F','0','1','system:post:edit','#','admin','2022-06-02 14:54:30','',NULL,''),(1023,'岗位删除',104,4,'#','','F','0','1','system:post:remove','#','admin','2022-06-02 14:54:30','',NULL,''),(1024,'岗位导出',104,5,'#','','F','0','1','system:post:export','#','admin','2022-06-02 14:54:30','',NULL,''),(1025,'字典查询',105,1,'#','','F','0','1','system:dict:list','#','admin','2022-06-02 14:54:30','',NULL,''),(1026,'字典新增',105,2,'#','','F','0','1','system:dict:add','#','admin','2022-06-02 14:54:30','',NULL,''),(1027,'字典修改',105,3,'#','','F','0','1','system:dict:edit','#','admin','2022-06-02 14:54:30','',NULL,''),(1028,'字典删除',105,4,'#','','F','0','1','system:dict:remove','#','admin','2022-06-02 14:54:30','',NULL,''),(1029,'字典导出',105,5,'#','','F','0','1','system:dict:export','#','admin','2022-06-02 14:54:31','',NULL,''),(1030,'参数查询',106,1,'#','','F','0','1','system:config:list','#','admin','2022-06-02 14:54:31','',NULL,''),(1031,'参数新增',106,2,'#','','F','0','1','system:config:add','#','admin','2022-06-02 14:54:31','',NULL,''),(1032,'参数修改',106,3,'#','','F','0','1','system:config:edit','#','admin','2022-06-02 14:54:31','',NULL,''),(1033,'参数删除',106,4,'#','','F','0','1','system:config:remove','#','admin','2022-06-02 14:54:31','',NULL,''),(1034,'参数导出',106,5,'#','','F','0','1','system:config:export','#','admin','2022-06-02 14:54:31','',NULL,''),(1035,'公告查询',107,1,'#','','F','0','1','system:notice:list','#','admin','2022-06-02 14:54:31','',NULL,''),(1036,'公告新增',107,2,'#','','F','0','1','system:notice:add','#','admin','2022-06-02 14:54:31','',NULL,''),(1037,'公告修改',107,3,'#','','F','0','1','system:notice:edit','#','admin','2022-06-02 14:54:31','',NULL,''),(1038,'公告删除',107,4,'#','','F','0','1','system:notice:remove','#','admin','2022-06-02 14:54:31','',NULL,''),(1039,'操作查询',500,1,'#','','F','0','1','monitor:operlog:list','#','admin','2022-06-02 14:54:31','',NULL,''),(1040,'操作删除',500,2,'#','','F','0','1','monitor:operlog:remove','#','admin','2022-06-02 14:54:31','',NULL,''),(1041,'详细信息',500,3,'#','','F','0','1','monitor:operlog:detail','#','admin','2022-06-02 14:54:31','',NULL,''),(1042,'日志导出',500,4,'#','','F','0','1','monitor:operlog:export','#','admin','2022-06-02 14:54:31','',NULL,''),(1043,'登录查询',501,1,'#','','F','0','1','monitor:logininfor:list','#','admin','2022-06-02 14:54:31','',NULL,''),(1044,'登录删除',501,2,'#','','F','0','1','monitor:logininfor:remove','#','admin','2022-06-02 14:54:31','',NULL,''),(1045,'日志导出',501,3,'#','','F','0','1','monitor:logininfor:export','#','admin','2022-06-02 14:54:31','',NULL,''),(1046,'账户解锁',501,4,'#','','F','0','1','monitor:logininfor:unlock','#','admin','2022-06-02 14:54:31','',NULL,''),(1047,'在线查询',109,1,'#','','F','0','1','monitor:online:list','#','admin','2022-06-02 14:54:31','',NULL,''),(1048,'批量强退',109,2,'#','','F','0','1','monitor:online:batchForceLogout','#','admin','2022-06-02 14:54:31','',NULL,''),(1049,'单条强退',109,3,'#','','F','0','1','monitor:online:forceLogout','#','admin','2022-06-02 14:54:31','',NULL,''),(1050,'任务查询',110,1,'#','','F','0','1','monitor:job:list','#','admin','2022-06-02 14:54:31','',NULL,''),(1051,'任务新增',110,2,'#','','F','0','1','monitor:job:add','#','admin','2022-06-02 14:54:31','',NULL,''),(1052,'任务修改',110,3,'#','','F','0','1','monitor:job:edit','#','admin','2022-06-02 14:54:31','',NULL,''),(1053,'任务删除',110,4,'#','','F','0','1','monitor:job:remove','#','admin','2022-06-02 14:54:31','',NULL,''),(1054,'状态修改',110,5,'#','','F','0','1','monitor:job:changeStatus','#','admin','2022-06-02 14:54:31','',NULL,''),(1055,'任务详细',110,6,'#','','F','0','1','monitor:job:detail','#','admin','2022-06-02 14:54:31','',NULL,''),(1056,'任务导出',110,7,'#','','F','0','1','monitor:job:export','#','admin','2022-06-02 14:54:31','',NULL,''),(1057,'生成查询',115,1,'#','','F','0','1','tool:gen:list','#','admin','2022-06-02 14:54:31','',NULL,''),(1058,'生成修改',115,2,'#','','F','0','1','tool:gen:edit','#','admin','2022-06-02 14:54:31','',NULL,''),(1059,'生成删除',115,3,'#','','F','0','1','tool:gen:remove','#','admin','2022-06-02 14:54:31','',NULL,''),(1060,'预览代码',115,4,'#','','F','0','1','tool:gen:preview','#','admin','2022-06-02 14:54:31','',NULL,''),(1061,'生成代码',115,5,'#','','F','0','1','tool:gen:code','#','admin','2022-06-02 14:54:31','',NULL,''),(2000,'驾驶舱',0,1,'/italent/index','menuItem','C','0','1','italent:index:view','fa fa-institution','admin','2022-06-02 14:57:15','admin','2022-06-06 18:23:42',''),(2001,'人才库',0,3,'/italent/resume','menuItem','C','0','1','#','fa fa-group','admin','2022-06-02 15:28:23','admin','2022-06-06 18:26:17',''),(2003,'人才库管理查询',2012,2,'#','menuItem','F','0','1','italent:resume:list','#','admin','2022-06-02 15:29:28','admin','2022-06-06 18:25:26',''),(2004,'人才库管理新增',2012,3,'#','menuItem','F','0','1','italent:resume:add','#','admin','2022-06-02 15:29:28','admin','2022-06-06 18:25:35',''),(2005,'人才库管理修改',2012,4,'#','menuItem','F','0','1','italent:resume:edit','#','admin','2022-06-02 15:29:28','admin','2022-06-06 18:25:44',''),(2006,'人才库管理删除',2012,5,'#','menuItem','F','0','1','italent:resume:remove','#','admin','2022-06-02 15:29:28','admin','2022-06-06 18:25:54',''),(2007,'人才库管理简历导出',2012,6,'#','menuItem','F','0','1','italent:resume:export','#','admin','2022-06-02 15:29:28','admin','2023-02-15 11:20:24',''),(2008,'统计',0,8,'/italent/Count','menuItem','C','1','1','#','fa fa-bar-chart-o','admin','2022-06-04 15:01:52','admin','2022-07-05 14:23:26',''),(2009,'人才库管理下载简历',2012,7,'#','menuItem','F','0','1','italent:resume:download','#','admin','2022-06-04 15:02:28','admin','2022-06-06 18:26:12',''),(2010,'人才库功能',0,996,'#','menuItem','F','0','1','#','#','admin','2022-06-06 18:24:44','admin','2022-06-06 18:28:55',''),(2011,'人才库管理展示',2012,1,'#','menuItem','F','0','1','italent:resume:view','#','admin','2022-06-06 18:25:15','',NULL,''),(2012,'人才库模块',2010,1,'#','menuItem','F','0','1','#','#','admin','2022-06-06 18:26:50','',NULL,''),(2013,'回收池',0,7,'/italent/resume/recycle','menuItem','C','0','1','','fa fa-snowflake-o','admin','2022-07-04 11:45:45','admin','2022-07-05 14:23:34',''),(2014,'待安排',0,4,'/italent/resume/unfix','menuItem','C','0','1','','fa fa-bell','admin','2022-07-04 12:39:28','admin','2022-07-05 14:23:11',''),(2015,'已安排',0,5,'/italent/resume/fix','menuItem','C','0','1','','fa fa-comments','admin','2022-07-05 14:22:59','admin','2022-07-05 14:24:37',''),(2016,'精英坊',0,6,'/italent/resume/hero','menuItem','C','0','1',NULL,'fa fa-handshake-o','admin','2022-07-05 14:24:14','',NULL,''),(2017,'人才库管理数据导入',2012,8,'#','menuItem','F','0','1','italent:resume:import','#','admin','2023-02-15 11:20:11','',NULL,''),(2018,'问卷评估',2087,9,'#','menuItem','M','0','1','','fa fa-qrcode','admin','2022-05-10 13:52:20','admin','2023-03-24 16:00:58',''),(2019,'我的问卷',2018,1,'/questionnaire/naire/1','menuItem','C','0','1','questionnaire:naire:view','#','admin','2022-05-10 14:47:36','admin','2022-05-10 15:46:07','问卷菜单'),(2020,'问卷查询',2019,1,'#','','F','0','1','questionnaire:naire:list','#','admin','2022-05-10 14:47:36','',NULL,''),(2021,'问卷新增',2019,2,'#','','F','0','1','questionnaire:naire:add','#','admin','2022-05-10 14:47:36','',NULL,''),(2022,'问卷修改',2019,3,'#','','F','0','1','questionnaire:naire:edit','#','admin','2022-05-10 14:47:36','',NULL,''),(2023,'问卷删除',2019,4,'#','','F','0','1','questionnaire:naire:remove','#','admin','2022-05-10 14:47:36','',NULL,''),(2024,'问卷导出',2019,5,'#','','F','0','1','questionnaire:naire:export','#','admin','2022-05-10 14:47:37','',NULL,''),(2025,'问卷详情',2018,4,'/questionnaire/result','menuItem','F','0','1','questionnaire:details:view','#','admin','2022-05-10 14:48:03','admin','2022-05-13 11:55:27','问卷详情菜单'),(2026,'问卷详情查询',2025,1,'#','','F','0','1','questionnaire:details:list','#','admin','2022-05-10 14:48:03','',NULL,''),(2027,'问卷详情新增',2025,2,'#','','F','0','1','questionnaire:details:add','#','admin','2022-05-10 14:48:03','',NULL,''),(2028,'问卷详情修改',2025,3,'#','','F','0','1','questionnaire:details:edit','#','admin','2022-05-10 14:48:03','',NULL,''),(2029,'问卷详情删除',2025,4,'#','','F','0','1','questionnaire:details:remove','#','admin','2022-05-10 14:48:03','',NULL,''),(2030,'问卷详情导出',2025,5,'#','','F','0','1','questionnaire:details:export','#','admin','2022-05-10 14:48:03','',NULL,''),(2031,'问卷模板',2018,3,'/questionnaire/naire/2','menuItem','C','1','1','','#','admin','2022-05-10 15:35:33','admin','2023-06-02 09:58:52',''),(2032,'问卷记录',2018,2,'/questionnaire/recode','menuItem','C','0','1','questionnaire:recode:view','#','admin','2022-05-11 21:23:18','admin','2022-05-12 11:49:04','问卷记录菜单'),(2033,'问卷记录查询',2032,1,'#','','F','0','1','questionnaire:recode:list','#','admin','2022-05-11 21:23:19','',NULL,''),(2034,'问卷记录新增',2032,2,'#','','F','0','1','questionnaire:recode:add','#','admin','2022-05-11 21:23:19','',NULL,''),(2035,'问卷记录修改',2032,3,'#','','F','0','1','questionnaire:recode:edit','#','admin','2022-05-11 21:23:19','',NULL,''),(2036,'问卷记录删除',2032,4,'#','','F','0','1','questionnaire:recode:remove','#','admin','2022-05-11 21:23:19','',NULL,''),(2037,'问卷记录导出',2032,5,'#','','F','0','1','questionnaire:recode:export','#','admin','2022-05-11 21:23:19','',NULL,''),(2038,'问卷结果',2018,5,'','menuItem','F','0','1','questionnaire:result:view','#','admin','2022-05-11 23:04:19','admin','2022-05-12 11:48:47','问卷结果菜单'),(2039,'问卷结果查询',2038,1,'#','','F','0','1','questionnaire:result:list','#','admin','2022-05-11 23:04:19','',NULL,''),(2040,'问卷结果新增',2038,2,'#','','F','0','1','questionnaire:result:add','#','admin','2022-05-11 23:04:19','',NULL,''),(2041,'问卷结果修改',2038,3,'#','','F','0','1','questionnaire:result:edit','#','admin','2022-05-11 23:04:19','',NULL,''),(2042,'问卷结果删除',2038,4,'#','','F','0','1','questionnaire:result:remove','#','admin','2022-05-11 23:04:19','',NULL,''),(2043,'企岗设置',1,10,'#','menuItem','M','0','1','','fa fa-flag','admin','2023-03-25 17:36:11','admin','2023-05-24 12:23:42',''),(2044,'职位管理',2043,2,'/italent/post','menuItem','C','0','1','italent:post:view','fa fa-cutlery','admin','2023-03-25 17:37:34','admin','2023-03-25 19:29:14','职位管理菜单'),(2045,'职位管理查询',2044,1,'#','','F','0','1','italent:post:list','#','admin','2023-03-25 17:37:35','',NULL,''),(2046,'职位管理新增',2044,2,'#','','F','0','1','italent:post:add','#','admin','2023-03-25 17:37:35','',NULL,''),(2047,'职位管理修改',2044,3,'#','','F','0','1','italent:post:edit','#','admin','2023-03-25 17:37:35','',NULL,''),(2048,'职位管理删除',2044,4,'#','','F','0','1','italent:post:remove','#','admin','2023-03-25 17:37:35','',NULL,''),(2049,'职位管理导出',2044,5,'#','','F','0','1','italent:post:export','#','admin','2023-03-25 17:37:35','',NULL,''),(2050,'企业档案',2043,1,'/italent/enterprise','menuItem','C','0','1','italent:enterprise:view','fa fa-paper-plane','admin','2023-03-25 18:57:24','admin','2023-03-25 19:29:41','企业档案菜单'),(2051,'企业档案查询',2050,1,'#','','F','0','1','italent:enterprise:list','#','admin','2023-03-25 18:57:24','',NULL,''),(2052,'企业档案新增',2050,2,'#','','F','0','1','italent:enterprise:add','#','admin','2023-03-25 18:57:24','',NULL,''),(2053,'企业档案修改',2050,3,'#','','F','0','1','italent:enterprise:edit','#','admin','2023-03-25 18:57:24','',NULL,''),(2054,'企业档案删除',2050,4,'#','','F','0','1','italent:enterprise:remove','#','admin','2023-03-25 18:57:24','',NULL,''),(2055,'企业档案导出',2050,5,'#','','F','0','1','italent:enterprise:export','#','admin','2023-03-25 18:57:25','',NULL,''),(2057,'家庭背景',0,11,'/italent/family','menuItem','C','1','1','italent:family:view','#','admin','2023-03-26 17:23:54','admin','2023-03-26 17:26:22','家庭背景菜单'),(2058,'家庭背景查询',2057,1,'#','','F','0','1','italent:family:list','#','admin','2023-03-26 17:23:54','',NULL,''),(2059,'家庭背景新增',2057,2,'#','','F','0','1','italent:family:add','#','admin','2023-03-26 17:23:54','',NULL,''),(2060,'家庭背景修改',2057,3,'#','','F','0','1','italent:family:edit','#','admin','2023-03-26 17:23:55','',NULL,''),(2061,'家庭背景删除',2057,4,'#','','F','0','1','italent:family:remove','#','admin','2023-03-26 17:23:55','',NULL,''),(2062,'家庭背景导出',2057,5,'#','','F','0','1','italent:family:export','#','admin','2023-03-26 17:23:55','',NULL,''),(2063,'教育状况',0,12,'/italent/edu','menuItem','C','1','1','italent:edu:view','#','admin','2023-03-28 12:09:58','admin','2023-03-28 12:18:58','教育状况菜单'),(2064,'教育状况查询',2063,1,'#','','F','0','1','italent:edu:list','#','admin','2023-03-28 12:09:59','',NULL,''),(2065,'教育状况新增',2063,2,'#','','F','0','1','italent:edu:add','#','admin','2023-03-28 12:09:59','',NULL,''),(2066,'教育状况修改',2063,3,'#','','F','0','1','italent:edu:edit','#','admin','2023-03-28 12:09:59','',NULL,''),(2067,'教育状况删除',2063,4,'#','','F','0','1','italent:edu:remove','#','admin','2023-03-28 12:09:59','',NULL,''),(2068,'教育状况导出',2063,5,'#','','F','0','1','italent:edu:export','#','admin','2023-03-28 12:09:59','',NULL,''),(2069,'培训经历',0,13,'/italent/drill','menuItem','C','1','1','italent:drill:view','#','admin','2023-03-28 12:10:06','admin','2023-03-28 12:19:05','培训经历菜单'),(2070,'培训经历查询',2069,1,'#','','F','0','1','italent:drill:list','#','admin','2023-03-28 12:10:06','',NULL,''),(2071,'培训经历新增',2069,2,'#','','F','0','1','italent:drill:add','#','admin','2023-03-28 12:10:07','',NULL,''),(2072,'培训经历修改',2069,3,'#','','F','0','1','italent:drill:edit','#','admin','2023-03-28 12:10:07','',NULL,''),(2073,'培训经历删除',2069,4,'#','','F','0','1','italent:drill:remove','#','admin','2023-03-28 12:10:07','',NULL,''),(2074,'培训经历导出',2069,5,'#','','F','0','1','italent:drill:export','#','admin','2023-03-28 12:10:07','',NULL,''),(2075,'工作背景',0,14,'/italent/work','menuItem','C','1','1','italent:work:view','#','admin','2023-03-28 12:10:14','admin','2023-03-28 12:19:11','工作背景菜单'),(2076,'工作背景查询',2075,1,'#','','F','0','1','italent:work:list','#','admin','2023-03-28 12:10:14','',NULL,''),(2077,'工作背景新增',2075,2,'#','','F','0','1','italent:work:add','#','admin','2023-03-28 12:10:14','',NULL,''),(2078,'工作背景修改',2075,3,'#','','F','0','1','italent:work:edit','#','admin','2023-03-28 12:10:14','',NULL,''),(2079,'工作背景删除',2075,4,'#','','F','0','1','italent:work:remove','#','admin','2023-03-28 12:10:14','',NULL,''),(2080,'工作背景导出',2075,5,'#','','F','0','1','italent:work:export','#','admin','2023-03-28 12:10:14','',NULL,''),(2081,'应聘啦',2087,2,'/italent/register','menuItem','C','0','1','italent:register:view','fa fa-registered','admin','2023-03-28 16:37:05','admin','2023-03-28 16:40:06','应聘登记菜单'),(2082,'应聘登记查询',2081,1,'#','','F','0','1','italent:register:list','#','admin','2023-03-28 16:37:06','',NULL,''),(2083,'应聘登记新增',2081,2,'#','','F','0','1','italent:register:add','#','admin','2023-03-28 16:37:06','',NULL,''),(2084,'应聘登记修改',2081,3,'#','','F','0','1','italent:register:edit','#','admin','2023-03-28 16:37:06','',NULL,''),(2085,'应聘登记删除',2081,4,'#','','F','0','1','italent:register:remove','#','admin','2023-03-28 16:37:07','',NULL,''),(2086,'应聘登记导出',2081,5,'#','','F','0','1','italent:register:export','#','admin','2023-03-28 16:37:07','',NULL,''),(2087,'应聘登记',0,2,'#','menuItem','M','0','1',NULL,'fa fa-address-card','admin','2023-06-02 09:47:38','',NULL,'');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_notice`
--

DROP TABLE IF EXISTS `sys_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_notice` (
  `notice_id` int NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(1) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` varchar(2000) DEFAULT NULL COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COMMENT='通知公告表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_notice`
--

LOCK TABLES `sys_notice` WRITE;
/*!40000 ALTER TABLE `sys_notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_oper_log`
--

DROP TABLE IF EXISTS `sys_oper_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_oper_log` (
  `oper_id` bigint NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operator_type` int DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
  `status` int DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='操作日志记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_oper_log`
--

LOCK TABLES `sys_oper_log` WRITE;
/*!40000 ALTER TABLE `sys_oper_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_oper_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_post`
--

DROP TABLE IF EXISTS `sys_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_post` (
  `post_id` bigint NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `post_sort` int NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COMMENT='岗位信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_post`
--

LOCK TABLES `sys_post` WRITE;
/*!40000 ALTER TABLE `sys_post` DISABLE KEYS */;
INSERT INTO `sys_post` (`post_id`, `post_code`, `post_name`, `post_sort`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1,'ceo','董事长',1,'0','admin','2022-04-03 16:13:36','',NULL,''),(2,'se','项目经理',2,'0','admin','2022-04-03 16:13:36','admin','2022-04-14 20:33:30','无'),(3,'hr','人力资源',3,'0','admin','2022-04-03 16:13:36','',NULL,''),(4,'user','普通员工',4,'0','admin','2022-04-03 16:13:36','',NULL,'');
/*!40000 ALTER TABLE `sys_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb3 COMMENT='角色信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`role_id`, `role_name`, `role_key`, `role_sort`, `data_scope`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1,'超级管理员','admin',1,'1','0','0','admin','2022-04-03 16:13:36','',NULL,'超级管理员'),(2,'普通角色','common',2,'2','0','0','admin','2022-04-03 16:13:36','admin','2022-04-18 15:43:24','普通角色'),(100,'面试官','viewer',3,'1','0','0','admin','2022-04-18 15:46:16','admin','2022-06-06 15:10:59','面试管'),(101,'HR','hr',5,'1','0','0','admin','2022-04-19 17:10:26','admin','2023-03-28 16:39:52',''),(102,'人资部门经理','hr_leader',4,'1','0','0','admin','2022-06-06 16:59:38','admin','2023-06-02 16:15:09',''),(103,'HR_公共','hr_public',6,'1','0','0','admin','2022-06-06 18:01:29','admin','2023-06-02 16:23:10','');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_dept`
--

DROP TABLE IF EXISTS `sys_role_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_dept` (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `dept_id` bigint NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='角色和部门关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_dept`
--

LOCK TABLES `sys_role_dept` WRITE;
/*!40000 ALTER TABLE `sys_role_dept` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='角色和菜单关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (101,2000),(101,2001),(101,2003),(101,2004),(101,2005),(101,2006),(101,2009),(101,2010),(101,2011),(101,2012),(101,2013),(101,2014),(101,2015),(101,2016),(101,2017),(102,1),(102,100),(102,103),(102,105),(102,1000),(102,1001),(102,1002),(102,1006),(102,1016),(102,1017),(102,1018),(102,1019),(102,1025),(102,1026),(102,1027),(102,2000),(102,2001),(102,2003),(102,2004),(102,2005),(102,2006),(102,2007),(102,2009),(102,2010),(102,2011),(102,2012),(102,2013),(102,2014),(102,2015),(102,2016),(102,2018),(102,2019),(102,2020),(102,2021),(102,2022),(102,2023),(102,2024),(102,2025),(102,2026),(102,2027),(102,2028),(102,2029),(102,2030),(102,2031),(102,2032),(102,2033),(102,2034),(102,2035),(102,2036),(102,2037),(102,2038),(102,2039),(102,2040),(102,2041),(102,2042),(102,2043),(102,2044),(102,2045),(102,2046),(102,2047),(102,2048),(102,2049),(102,2050),(102,2051),(102,2052),(102,2053),(102,2054),(102,2055),(102,2057),(102,2058),(102,2059),(102,2060),(102,2061),(102,2062),(102,2063),(102,2064),(102,2065),(102,2066),(102,2067),(102,2068),(102,2069),(102,2070),(102,2071),(102,2072),(102,2073),(102,2074),(102,2075),(102,2076),(102,2077),(102,2078),(102,2079),(102,2080),(102,2081),(102,2082),(102,2083),(102,2084),(102,2085),(102,2086),(102,2087),(103,2000),(103,2001),(103,2003),(103,2004),(103,2005),(103,2006),(103,2009),(103,2010),(103,2011),(103,2012),(103,2013),(103,2014),(103,2015),(103,2016),(103,2017),(103,2018),(103,2019),(103,2020),(103,2021),(103,2022),(103,2023),(103,2024),(103,2025),(103,2026),(103,2027),(103,2028),(103,2029),(103,2030),(103,2031),(103,2032),(103,2033),(103,2034),(103,2035),(103,2036),(103,2037),(103,2038),(103,2039),(103,2040),(103,2041),(103,2042),(103,2057),(103,2058),(103,2059),(103,2060),(103,2061),(103,2062),(103,2063),(103,2064),(103,2065),(103,2066),(103,2067),(103,2068),(103,2069),(103,2070),(103,2071),(103,2072),(103,2073),(103,2074),(103,2075),(103,2076),(103,2077),(103,2078),(103,2079),(103,2080),(103,2081),(103,2082),(103,2083),(103,2084),(103,2085),(103,2086),(103,2087);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
  `login_name` varchar(30) NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) DEFAULT '' COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户 01注册用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `salt` varchar(20) DEFAULT '' COMMENT '盐加密',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `pwd_update_date` datetime DEFAULT NULL COMMENT '密码最后更新时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8mb3 COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`user_id`, `dept_id`, `login_name`, `user_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `salt`, `status`, `del_flag`, `login_ip`, `login_date`, `pwd_update_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1,103,'admin','管理员','00','ry@163.com','15888888888','1','','031bdcc060a97ebb4d610be016fc3584','049d17','0','0','127.0.0.1','2023-06-05 09:51:53','2023-06-05 09:51:39','admin','2022-04-03 16:13:36','','2023-06-05 09:51:53','管理员');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_online`
--

DROP TABLE IF EXISTS `sys_user_online`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_online` (
  `sessionId` varchar(50) NOT NULL DEFAULT '' COMMENT '用户会话id',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `ipaddr` varchar(128) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` varchar(10) DEFAULT '' COMMENT '在线状态on_line在线off_line离线',
  `start_timestamp` datetime DEFAULT NULL COMMENT 'session创建时间',
  `last_access_time` datetime DEFAULT NULL COMMENT 'session最后访问时间',
  `expire_time` int DEFAULT '0' COMMENT '超时时间，单位为分钟',
  PRIMARY KEY (`sessionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='在线用户记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_online`
--

LOCK TABLES `sys_user_online` WRITE;
/*!40000 ALTER TABLE `sys_user_online` DISABLE KEYS */;
INSERT INTO `sys_user_online` (`sessionId`, `login_name`, `dept_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `start_timestamp`, `last_access_time`, `expire_time`) VALUES ('6411785a-d218-4bec-9758-887885c7f338','admin','测评部','127.0.0.1','内网IP','Chrome 11','Windows 10','on_line','2023-06-05 09:51:53','2023-06-05 09:59:13',1800000);
/*!40000 ALTER TABLE `sys_user_online` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_post`
--

DROP TABLE IF EXISTS `sys_user_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_post` (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `post_id` bigint NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='用户与岗位关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_post`
--

LOCK TABLES `sys_user_post` WRITE;
/*!40000 ALTER TABLE `sys_user_post` DISABLE KEYS */;
INSERT INTO `sys_user_post` (`user_id`, `post_id`) VALUES (1,1);
/*!40000 ALTER TABLE `sys_user_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_role` (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='用户和角色关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (1,1);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbitalent_drill_history`
--

DROP TABLE IF EXISTS `tbitalent_drill_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbitalent_drill_history` (
  `f_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_resume_id` varchar(10) NOT NULL COMMENT '应聘登记标识',
  `f_start_time` varchar(200) DEFAULT NULL COMMENT '开始时间',
  `f_end_time` varchar(200) DEFAULT NULL COMMENT '毕业时间',
  `f_company` varchar(200) DEFAULT NULL COMMENT '机构',
  `f_content` varchar(200) DEFAULT NULL COMMENT '培训内容',
  `f_certificate` varchar(200) DEFAULT NULL COMMENT '证书',
  `f_remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='培训经历';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbitalent_drill_history`
--

LOCK TABLES `tbitalent_drill_history` WRITE;
/*!40000 ALTER TABLE `tbitalent_drill_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbitalent_drill_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbitalent_edu_history`
--

DROP TABLE IF EXISTS `tbitalent_edu_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbitalent_edu_history` (
  `f_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_resume_id` varchar(10) NOT NULL COMMENT '应聘登记标识',
  `f_start_time` varchar(200) DEFAULT NULL COMMENT '开始时间',
  `f_end_time` varchar(200) DEFAULT NULL COMMENT '毕业时间',
  `f_school` varchar(200) DEFAULT NULL COMMENT '院校',
  `f_major` varchar(200) DEFAULT NULL COMMENT '专业',
  `f_edu_degree` varchar(200) DEFAULT NULL COMMENT '学历',
  `f_edu_background` varchar(200) DEFAULT NULL COMMENT '类型',
  `f_type` varchar(200) DEFAULT NULL COMMENT '入学方式',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='教育状况';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbitalent_edu_history`
--

LOCK TABLES `tbitalent_edu_history` WRITE;
/*!40000 ALTER TABLE `tbitalent_edu_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbitalent_edu_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbitalent_enterprise`
--

DROP TABLE IF EXISTS `tbitalent_enterprise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbitalent_enterprise` (
  `f_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `f_name` varchar(200) DEFAULT NULL COMMENT '公司名称',
  `f_industry` varchar(200) DEFAULT NULL COMMENT '行业',
  `f_describe` varchar(4000) DEFAULT NULL COMMENT '公司描述',
  `f_size` varchar(200) DEFAULT NULL COMMENT '公司规模',
  `f_address` varchar(200) DEFAULT NULL COMMENT '详细位置',
  `f_provinces` varchar(20) DEFAULT NULL COMMENT '省份',
  `f_city` varchar(20) DEFAULT NULL COMMENT '城市',
  `f_logo` varchar(200) DEFAULT NULL COMMENT 'Logo',
  `f_lng` decimal(10,0) DEFAULT NULL COMMENT '经度',
  `f_lat` decimal(10,0) DEFAULT NULL COMMENT '纬度',
  `f_hr_email` varchar(200) DEFAULT NULL COMMENT 'HR邮箱',
  `f_remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `f_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `f_create_by` varchar(200) DEFAULT NULL COMMENT '创建者',
  `f_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `f_update_by` varchar(200) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='企业档案';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbitalent_enterprise`
--

LOCK TABLES `tbitalent_enterprise` WRITE;
/*!40000 ALTER TABLE `tbitalent_enterprise` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbitalent_enterprise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbitalent_family_info`
--

DROP TABLE IF EXISTS `tbitalent_family_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbitalent_family_info` (
  `f_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_resume_id` varchar(10) NOT NULL COMMENT '应聘登记标识',
  `f_name` varchar(200) DEFAULT NULL COMMENT '姓名',
  `f_relation` varchar(200) DEFAULT NULL COMMENT '关系',
  `f_age` varchar(200) DEFAULT NULL COMMENT '年龄',
  `f_company` varchar(200) DEFAULT NULL COMMENT '工作单位',
  `f_post` varchar(200) DEFAULT NULL COMMENT '职位',
  `f_tel` varchar(200) DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='家庭背景';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbitalent_family_info`
--

LOCK TABLES `tbitalent_family_info` WRITE;
/*!40000 ALTER TABLE `tbitalent_family_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbitalent_family_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbitalent_post`
--

DROP TABLE IF EXISTS `tbitalent_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbitalent_post` (
  `f_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `f_jobname` varchar(255) DEFAULT NULL COMMENT '职位名称',
  `f_postname` varchar(255) DEFAULT NULL COMMENT '岗位名称',
  `f_del` varchar(255) DEFAULT NULL COMMENT '岗位下架',
  `f_remark` varchar(4000) DEFAULT NULL COMMENT '备注',
  `f_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `f_createby` varchar(255) DEFAULT NULL COMMENT '创建人',
  `f_updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `f_updateby` varchar(255) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3 COMMENT='职位管理表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbitalent_post`
--

LOCK TABLES `tbitalent_post` WRITE;
/*!40000 ALTER TABLE `tbitalent_post` DISABLE KEYS */;
INSERT INTO `tbitalent_post` (`f_id`, `f_jobname`, `f_postname`, `f_del`, `f_remark`, `f_createtime`, `f_createby`, `f_updatetime`, `f_updateby`) VALUES (2,'JAVA开发工程师','技术岗','2','','2023-03-25 17:49:35','管理员','2023-03-25 18:50:57','管理员'),(3,'WEB开发工程师','技术岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(4,'Andriod开发工程师','技术岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(5,'IOS开发工程师','技术岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(6,'PHP开发工程师','技术岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(7,'RPA开发工程师','技术岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(8,'BI开发','技术岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(9,'产品经理','技术岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(10,'售前工程师','技术岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(11,'实施工程师','技术岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(12,'需求分析师','技术岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(13,'架构师','技术岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(14,'软件销售客户经理','营销岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(15,'院校合作经理','营销岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(16,'咨询经理','营销岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(17,'其他','营销岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(18,'院校合作部经理/总监','营销管理岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(19,'咨询部经理/总监','营销管理岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(20,'软件销售部经理/总监','营销管理岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(21,'其他','营销管理岗','2','','2023-03-25 17:49:35','管理员','2023-03-25 18:47:57','管理员'),(22,'事业部部长','经营管理岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(23,'分子公司总经理','经营管理岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL),(24,'其他','经营管理岗','2',NULL,'2023-03-25 17:49:35','管理员',NULL,NULL);
/*!40000 ALTER TABLE `tbitalent_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbitalent_register`
--

DROP TABLE IF EXISTS `tbitalent_register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbitalent_register` (
  `f_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `f_jobname` varchar(50) DEFAULT NULL COMMENT '应聘职位',
  `f_hope_salary` varchar(200) DEFAULT NULL COMMENT '期望薪资',
  `f_entry_date` datetime DEFAULT NULL COMMENT '入职日期',
  `f_idcard` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `f_name` varchar(225) DEFAULT NULL COMMENT '姓名',
  `f_sex` char(1) DEFAULT NULL COMMENT '性别',
  `f_birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `f_tel` varchar(11) DEFAULT NULL COMMENT '电话',
  `f_nation` varchar(200) DEFAULT NULL COMMENT '民族',
  `f_marry` varchar(200) DEFAULT NULL COMMENT '婚姻状况',
  `f_hobby` varchar(200) DEFAULT NULL COMMENT '爱好',
  `f_mail` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `f_political_status` varchar(200) DEFAULT NULL COMMENT '政治面貌',
  `f_residence_address` varchar(200) DEFAULT NULL COMMENT '户籍地址',
  `f_now_address` varchar(200) DEFAULT NULL COMMENT '现住址',
  `f_source` varchar(50) DEFAULT NULL COMMENT '简历来源',
  `f_hr` varchar(10) DEFAULT NULL COMMENT 'hr专员',
  `f_remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  `f_createby` varchar(200) DEFAULT NULL COMMENT '创建者',
  `f_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `f_updateby` varchar(200) DEFAULT NULL COMMENT '更新者',
  `f_updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='应聘登记表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbitalent_register`
--

LOCK TABLES `tbitalent_register` WRITE;
/*!40000 ALTER TABLE `tbitalent_register` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbitalent_register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbitalent_resume`
--

DROP TABLE IF EXISTS `tbitalent_resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbitalent_resume` (
  `f_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `f_name` varchar(225) DEFAULT NULL COMMENT '姓名',
  `f_sex` char(1) DEFAULT NULL COMMENT '性别',
  `f_idcard` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `f_birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `f_age` int DEFAULT NULL COMMENT '年龄',
  `f_tel` varchar(11) DEFAULT NULL COMMENT '电话',
  `f_hope_salary` varchar(200) DEFAULT NULL COMMENT '期望薪资',
  `f_entry_date` datetime DEFAULT NULL COMMENT '入职日期',
  `f_nation` varchar(200) DEFAULT NULL COMMENT '民族',
  `f_marry` varchar(200) DEFAULT NULL COMMENT '婚姻状况',
  `f_hobby` varchar(200) DEFAULT NULL COMMENT '爱好',
  `f_mail` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `f_political_status` varchar(200) DEFAULT NULL COMMENT '政治面貌',
  `f_residence_address` varchar(200) DEFAULT NULL COMMENT '户籍地址',
  `f_now_address` varchar(200) DEFAULT NULL COMMENT '现住址',
  `f_jobname` varchar(50) DEFAULT NULL COMMENT '应聘职位',
  `f_jobyear` varchar(50) DEFAULT NULL COMMENT '工作年限',
  `f_exp` varchar(255) DEFAULT NULL COMMENT '工作经验',
  `f_region` varchar(50) DEFAULT NULL COMMENT '期望工作地点',
  `f_company` varchar(50) DEFAULT NULL COMMENT '之前工作的公司',
  `f_jobexp` varchar(2000) DEFAULT NULL COMMENT '工作经历',
  `f_prjexp` varchar(4000) DEFAULT NULL COMMENT '项目经历',
  `f_tech` varchar(2000) DEFAULT NULL COMMENT '技术栈',
  `f_eduexp` longtext COMMENT '教育经历',
  `f_educational_background` varchar(200) DEFAULT NULL COMMENT '学历类型',
  `f_enroll_type` varchar(200) DEFAULT NULL COMMENT '录取方式',
  `f_flag` varchar(10) DEFAULT NULL COMMENT '标签',
  `f_txt` longtext COMMENT '简历内容',
  `f_location` varchar(255) DEFAULT NULL COMMENT '简历文件路径',
  `f_appraise` longtext COMMENT '面试评价',
  `f_salary` decimal(10,2) DEFAULT NULL COMMENT '基本工资',
  `f_orthersalary` decimal(10,2) DEFAULT NULL COMMENT '其他工资',
  `f_performance` decimal(10,2) DEFAULT NULL COMMENT '绩效',
  `f_monthsalary` decimal(10,2) DEFAULT NULL COMMENT '月度工资',
  `f_degree` varchar(10) DEFAULT NULL COMMENT '职位级别',
  `f_hr` varchar(10) DEFAULT NULL COMMENT 'hr专员',
  `f_dep` varchar(50) DEFAULT NULL COMMENT '入职部门',
  `f_source` varchar(50) DEFAULT NULL COMMENT '简历来源',
  `f_start` varchar(10) DEFAULT '3' COMMENT '简历状态',
  `f_progress` varchar(255) DEFAULT '1' COMMENT '进度',
  `f_register` varchar(10) DEFAULT NULL COMMENT '应聘登记标识',
  `f_remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  `f_createby` varchar(200) DEFAULT NULL COMMENT '创建者',
  `f_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `f_updateby` varchar(200) DEFAULT NULL COMMENT '更新者',
  `f_updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='简历表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbitalent_resume`
--

LOCK TABLES `tbitalent_resume` WRITE;
/*!40000 ALTER TABLE `tbitalent_resume` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbitalent_resume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbitalent_work_history`
--

DROP TABLE IF EXISTS `tbitalent_work_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbitalent_work_history` (
  `f_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_resume_id` varchar(10) NOT NULL COMMENT '应聘登记标识',
  `f_start_time` varchar(200) DEFAULT NULL COMMENT '开始时间',
  `f_end_time` varchar(200) DEFAULT NULL COMMENT '毕业时间',
  `f_company` varchar(200) DEFAULT NULL COMMENT '工作单位',
  `f_post` varchar(200) DEFAULT NULL COMMENT '职位',
  `f_salary` varchar(200) DEFAULT NULL COMMENT '薪资',
  `f_leave` varchar(200) DEFAULT NULL COMMENT '离职原因',
  `f_tel` varchar(200) DEFAULT NULL COMMENT '单位电话',
  `f_witness` varchar(200) DEFAULT NULL COMMENT '证明人',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='工作背景';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbitalent_work_history`
--

LOCK TABLES `tbitalent_work_history` WRITE;
/*!40000 ALTER TABLE `tbitalent_work_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbitalent_work_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbque_naire`
--

DROP TABLE IF EXISTS `tbque_naire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbque_naire` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(255) DEFAULT NULL COMMENT '问卷标题',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `do_count` int DEFAULT NULL COMMENT '回答次数',
  `link` varchar(255) DEFAULT NULL COMMENT '链接',
  `anonymous` varchar(10) DEFAULT NULL COMMENT '匿名状态',
  `status` varchar(10) DEFAULT NULL COMMENT '发布状态',
  `template` varchar(10) DEFAULT NULL COMMENT '模板标识',
  `del_flg` varchar(10) DEFAULT NULL COMMENT '删除标识',
  `create_user` varchar(255) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='问卷表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbque_naire`
--

LOCK TABLES `tbque_naire` WRITE;
/*!40000 ALTER TABLE `tbque_naire` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbque_naire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbque_naire_details`
--

DROP TABLE IF EXISTS `tbque_naire_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbque_naire_details` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `que_naire` varchar(255) DEFAULT NULL COMMENT '问卷标识',
  `que_type` varchar(10) DEFAULT NULL COMMENT '题型',
  `content` longtext COMMENT '内容',
  `required` varchar(10) DEFAULT NULL COMMENT '必填',
  `create_user` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='问卷详情表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbque_naire_details`
--

LOCK TABLES `tbque_naire_details` WRITE;
/*!40000 ALTER TABLE `tbque_naire_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbque_naire_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbque_naire_recode`
--

DROP TABLE IF EXISTS `tbque_naire_recode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbque_naire_recode` (
  `id` varchar(255) NOT NULL COMMENT 'ID',
  `que_naire` varchar(255) DEFAULT NULL COMMENT '问卷标识',
  `create_user` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='问卷记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbque_naire_recode`
--

LOCK TABLES `tbque_naire_recode` WRITE;
/*!40000 ALTER TABLE `tbque_naire_recode` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbque_naire_recode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbque_naire_result`
--

DROP TABLE IF EXISTS `tbque_naire_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbque_naire_result` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `que_naire` varchar(255) DEFAULT NULL COMMENT '记录标识',
  `que_content` longtext COMMENT '题目内容',
  `answer` varchar(255) DEFAULT NULL COMMENT '回答内容',
  `create_user` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='问卷结果表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbque_naire_result`
--

LOCK TABLES `tbque_naire_result` WRITE;
/*!40000 ALTER TABLE `tbque_naire_result` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbque_naire_result` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-05 10:02:25
