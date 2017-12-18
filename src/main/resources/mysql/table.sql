CREATE DATABASE curricula_variable_system;

CREATE TABLE `course` (
  `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT "主键",
  `c_no` VARCHAR (45) NOT NULL UNIQUE COMMENT "课程号",
  `c_name` VARCHAR (50) NOT NULL COMMENT "课程名",
  `c_credit` INT (10) NOT NULL COMMENT "学分",
  `c_perid`  INT (10) NOT NULL COMMENT "学时",
  `t_no`   INT (11) NOT NULL COMMENT "教师工号",
  `c_grade`  VARCHAR (30) NOT NULL COMMENT "年级",
  `c_address` VARCHAR (45) NOT NULL COMMENT "上课地点",
  `c_week_time` VARCHAR (50) NOT NULL COMMENT "上课时间",
  `c_number` INT (10) NOT NULL COMMENT "限定人数",
  `c_desc` VARCHAR (100) NOT NULL COMMENT "课程描述",
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT="课程信息";

CREATE TABLE `user`(
`id` INT (11) NOT NULL AUTO_INCREMENT COMMENT "主键",
`u_num` INT (11) NOT NULL UNIQUE COMMENT "工号/学号",
`u_passwd` VARCHAR (20) NOT NULL COMMENT "密码",
`u_type`INT (10) NOT NULL COMMENT "用户身份　1:管理员　2:教师　3:学生",
`u_name` VARCHAR (40) NOT NULL COMMENT "姓名",
`u_gender` VARCHAR (10) NOT NULL COMMENT "性别",
`u_grade` VARCHAR (30) NOT NULL COMMENT "年级",
`u_major` VARCHAR (40) NOT NULL COMMENT "专业-班级",
`u_key` VARCHAR (32) NOT NULL COMMENT "登陆key",
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT="用户信息";

CREATE TABLE `curricula_variable_info`(
`id` INT (11) NOT NULL AUTO_INCREMENT COMMENT "主键",
`c_c_no` INT (11) NOT NULL  COMMENT "课程号",
`c_s_no` INT (11) NOT NULL COMMENT "学号",
`c_t_no` INT (11) NOT NULL COMMENT "教工号",
`c_mark` INT (10) COMMENT "成绩",
`c_status` VARCHAR (20) COMMENT "审核状态",
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT="选课信息";