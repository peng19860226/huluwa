drop table ez_accountbook;
CREATE TABLE ez_accountbook (
  id varchar(36) NOT NULL  COMMENT '主键',
  PRIMARY KEY (id),
  amount decimal(15,2) DEFAULT NULL COMMENT '金额',
  projectid varchar(50) DEFAULT NULL  COMMENT '项目',
  invoicetype varchar(50) DEFAULT NULL  COMMENT '发票类型',
  startdate varchar(20) DEFAULT NULL  COMMENT '开始日期',
  enddate varchar(20) DEFAULT NULL  COMMENT '结束日期',
  departurecity varchar(100) DEFAULT NULL  COMMENT '出发地',
  destinationcity varchar(100) DEFAULT NULL  COMMENT '目的地',
  note varchar(200) DEFAULT NULL  COMMENT '备注',
  hotelname varchar(100) DEFAULT NULL  COMMENT '酒店名称',
  cateringcorp varchar(50) DEFAULT NULL  COMMENT '餐饮公司',
  personnum integer(5) DEFAULT NULL  COMMENT '就餐人数',
  ostctype integer(1) DEFAULT NULL  COMMENT '费用类型',
  paymentsproject varchar(50) DEFAULT NULL  COMMENT '收支项目',
  communicationtype decimal(1) DEFAULT NULL  COMMENT '通讯类型',
  ts datetime DEFAULT CURRENT_TIMESTAMP COMMENT '版本控制',
   dr integer(1) DEFAULT 0 COMMENT '删除标记',
   modifier varchar(50) DEFAULT NULL  COMMENT '修改人',
   creator varchar(50) DEFAULT NULL  COMMENT '创建人',
   creationtime datetime DEFAULT NULL  COMMENT '创建时间',
   modifiedtime datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间'
)  ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='日记账表' ;
select * from ez_accountbook