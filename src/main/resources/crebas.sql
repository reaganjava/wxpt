SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `wxpt` DEFAULT CHARACTER SET utf8 ;
USE `wxpt` ;

-- -----------------------------------------------------
-- Table `wxpt`.`sys_category`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`sys_category` (
  `CATEID` INT(11) NOT NULL AUTO_INCREMENT ,
  `PARENT_ID` INT(11) NOT NULL ,
  `NAME` VARCHAR(30) NOT NULL ,
  `TYPE` INT(11) NOT NULL ,
  `SORT` INT(11) NOT NULL ,
  `DESCRPTION` VARCHAR(200) NOT NULL ,
  PRIMARY KEY (`CATEID`) ,
  INDEX `CATEGORY_INDEX` (`CATEID` ASC, `PARENT_ID` ASC) ,
  INDEX `CATEGORY_PARENT_idx` (`PARENT_ID` ASC) ,
  CONSTRAINT `CATEGORY_PARENT`
    FOREIGN KEY (`PARENT_ID` )
    REFERENCES `wxpt`.`sys_category` (`CATEID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`business_company`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`business_company` (
  `COID` INT(11) NOT NULL AUTO_INCREMENT ,
  `CATEGORY_ID` INT(11) NOT NULL ,
  `NAME` VARCHAR(50) NOT NULL ,
  `DISTRICT` VARCHAR(10) NOT NULL ,
  `LEVEL` INT(11) NOT NULL ,
  `SETTLE_TYPE` INT(11) NOT NULL ,
  `SERVICE_TYPE` INT(11) NOT NULL ,
  `SCALE` INT(11) NOT NULL ,
  `SALES_NAME` VARCHAR(8) NOT NULL ,
  `CREATE_DATE` DATETIME NOT NULL ,
  PRIMARY KEY (`COID`) ,
  INDEX `COMANY_INDEX` (`COID` ASC, `CATEGORY_ID` ASC) ,
  INDEX `COMPANY_CATEGORY_idx` (`CATEGORY_ID` ASC) ,
  CONSTRAINT `COMPANY_CATEGORY`
    FOREIGN KEY (`CATEGORY_ID` )
    REFERENCES `wxpt`.`sys_category` (`CATEID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`business_advertisement`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`business_advertisement` (
  `ADID` INT(11) NOT NULL AUTO_INCREMENT ,
  `COMPANY_ID` INT(11) NOT NULL ,
  `SHOP_ID` INT(11) NULL DEFAULT NULL ,
  `GOODS_ID` INT(11) NULL DEFAULT NULL ,
  `TITLE` VARCHAR(30) NOT NULL ,
  `CONTENT` VARCHAR(200) NOT NULL ,
  `DATE` DATETIME NOT NULL ,
  `URL` VARCHAR(100) NOT NULL ,
  `SORT` INT(11) NOT NULL ,
  `STATUS` INT(11) NOT NULL ,
  PRIMARY KEY (`ADID`) ,
  INDEX `ADVERTISENT_INDEX` (`ADID` ASC, `COMPANY_ID` ASC) ,
  INDEX `ADVERTISEMENT_COMPANY_idx` (`COMPANY_ID` ASC) ,
  CONSTRAINT `ADVERTISEMENT_COMPANY`
    FOREIGN KEY (`COMPANY_ID` )
    REFERENCES `wxpt`.`business_company` (`COID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`business_company_action`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`business_company_action` (
  `CAID` INT(11) NOT NULL AUTO_INCREMENT ,
  `COMPNAY_ID` INT(11) NULL DEFAULT NULL ,
  `SHOP_ID` INT(11) NULL DEFAULT NULL ,
  `GOODS_ID` INT(11) NULL DEFAULT NULL ,
  `CONTENT` VARCHAR(100) NOT NULL ,
  `DATE` DATETIME NOT NULL ,
  `NAME` VARCHAR(20) NOT NULL ,
  `TYPE` INT(11) NOT NULL ,
  PRIMARY KEY (`CAID`) ,
  INDEX `ACTION_IDNEX` (`CAID` ASC, `COMPNAY_ID` ASC) )
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`common_members`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`common_members` (
  `UID` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `OPENID` VARCHAR(64) NOT NULL ,
  `NICKNAME` VARCHAR(30) NOT NULL ,
  `SEX` INT(11) NOT NULL ,
  `CITY` VARCHAR(20) NOT NULL ,
  `COUNTRY` VARCHAR(20) NOT NULL ,
  `PROVINCE` VARCHAR(20) NOT NULL ,
  `LANGUAGE` VARCHAR(8) NOT NULL ,
  `SUBSCRIBE_TIME` VARCHAR(64) NOT NULL ,
  `STATUS` INT(11) NOT NULL ,
  PRIMARY KEY (`UID`) ,
  INDEX `MEMBER_INDEX` (`UID` ASC, `OPENID` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`business_transaction`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`business_transaction` (
  `TRAID` INT(11) NOT NULL AUTO_INCREMENT ,
  `TRAN_NUMBER` INT(11) NOT NULL ,
  `ORDE_NUMBER` VARCHAR(11) NOT NULL ,
  `PAY_NUMBER` VARCHAR(15) NOT NULL ,
  `START_DATE` DATETIME NOT NULL ,
  `END_DATE` DATETIME NOT NULL ,
  `GOODS_AMOUNT` DECIMAL(10,2) NOT NULL ,
  `DISCOUNT_AMOUNT` DECIMAL(10,2) NOT NULL ,
  `PAY_AMOUNT` DECIMAL(10,2) NOT NULL ,
  `TRANSPORT_AMOUNT` DECIMAL(10,2) NOT NULL ,
  `STATUS` INT(11) NOT NULL ,
  `PAY_MODE` INT(11) NOT NULL ,
  `PAYCHANNEL` VARCHAR(20) NOT NULL ,
  `PAY_DATE` DATETIME NOT NULL ,
  PRIMARY KEY (`TRAID`) ,
  INDEX `TRANSCATION` (`TRAID` ASC, `TRAN_NUMBER` ASC, `ORDE_NUMBER` ASC, `PAY_NUMBER` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`business_order`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`business_order` (
  `ORDID` INT(11) NOT NULL AUTO_INCREMENT ,
  `ORD_NUMBER` VARCHAR(11) NOT NULL ,
  `TRAN_ID` INT(11) NOT NULL ,
  `UID` BIGINT(20) NOT NULL ,
  `DATE` DATETIME NOT NULL ,
  `STATUS` INT(11) NOT NULL ,
  `GOODS_QUANTITY` INT(11) NOT NULL ,
  `ORDER_DATE` DATETIME NOT NULL ,
  `DIS_DATE` DATETIME NOT NULL ,
  `AMOUNT` DECIMAL(10,2) NOT NULL ,
  `PAY_MODE` INT(11) NOT NULL ,
  PRIMARY KEY (`ORDID`) ,
  INDEX `MEMBER_ORDER_idx` (`UID` ASC) ,
  INDEX `ORDER_INDEX` (`ORDID` ASC, `ORD_NUMBER` ASC, `UID` ASC) ,
  INDEX `TRAN_ORDER_idx` (`TRAN_ID` ASC) ,
  CONSTRAINT `MEMBER_ORDER`
    FOREIGN KEY (`UID` )
    REFERENCES `wxpt`.`common_members` (`UID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `TRAN_ORDER`
    FOREIGN KEY (`TRAN_ID` )
    REFERENCES `wxpt`.`business_transaction` (`TRAID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`business_distribution`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`business_distribution` (
  `ORDID` INT(11) NOT NULL ,
  `UID` BIGINT(20) NOT NULL ,
  `CUS_NAME` VARCHAR(8) NOT NULL ,
  `ZIP` VARCHAR(10) NOT NULL ,
  `TEL` VARCHAR(15) NOT NULL ,
  `MOBILE` VARCHAR(15) NOT NULL ,
  `ADDRESS` VARCHAR(100) NOT NULL ,
  `DELIVER_MODE` INT(11) NOT NULL ,
  `DELIVER_DATE` DATETIME NOT NULL ,
  `IS_PAY` INT(11) NOT NULL ,
  PRIMARY KEY (`ORDID`) ,
  INDEX `ORDER_ADDRE_INDEX` (`ORDID` ASC, `UID` ASC) ,
  INDEX `MEMBER_DISTRBUTION_idx` (`UID` ASC) ,
  CONSTRAINT `MEMBER_DISTRBUTION`
    FOREIGN KEY (`UID` )
    REFERENCES `wxpt`.`common_members` (`UID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ORDER_DISTRBUTION`
    FOREIGN KEY (`ORDID` )
    REFERENCES `wxpt`.`business_order` (`ORDID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`sys_region_category`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`sys_region_category` (
  `RCID` INT(11) NOT NULL AUTO_INCREMENT ,
  `PARENT_ID` INT(11) NOT NULL ,
  `NAME` VARCHAR(20) NOT NULL ,
  `TYPE` INT(11) NOT NULL ,
  `SORT` INT(11) NOT NULL ,
  `LNG` INT(11) NOT NULL ,
  `LAT` INT(11) NOT NULL ,
  PRIMARY KEY (`RCID`) ,
  INDEX `REGION_INDEX` (`RCID` ASC, `PARENT_ID` ASC) ,
  INDEX `REGION_CATEGORY_PARENT_idx` (`PARENT_ID` ASC) ,
  CONSTRAINT `REGION_CATEGORY_PARENT`
    FOREIGN KEY (`PARENT_ID` )
    REFERENCES `wxpt`.`sys_region_category` (`RCID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`business_shop`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`business_shop` (
  `SHID` INT(11) NOT NULL AUTO_INCREMENT ,
  `COMPANY_ID` INT(11) NOT NULL ,
  `CATEGORY_ID` INT(11) NOT NULL ,
  `REGION_ID` INT(11) NOT NULL ,
  `NAME` VARCHAR(30) NOT NULL ,
  `ADDRESS` VARCHAR(50) NOT NULL ,
  `TEL` VARCHAR(15) NOT NULL ,
  `MOBILE` VARCHAR(15) NOT NULL ,
  `CONTACT` VARCHAR(8) NOT NULL ,
  `PROVINCE` VARCHAR(20) NOT NULL ,
  `CITY` VARCHAR(20) NOT NULL ,
  `DISTRICT` VARCHAR(20) NOT NULL ,
  `PUSH_TYPE` INT(11) NOT NULL ,
  `DESCRIPTION` VARCHAR(200) NOT NULL ,
  PRIMARY KEY (`SHID`) ,
  INDEX `SHOP_INDEX` (`SHID` ASC, `COMPANY_ID` ASC, `CATEGORY_ID` ASC, `REGION_ID` ASC) ,
  INDEX `COMPANY_SHOP_idx` (`COMPANY_ID` ASC) ,
  INDEX `CATEGORY_SHOP_idx` (`CATEGORY_ID` ASC) ,
  INDEX `REGION_SHOP_idx` (`REGION_ID` ASC) ,
  CONSTRAINT `CATEGORY_SHOP`
    FOREIGN KEY (`CATEGORY_ID` )
    REFERENCES `wxpt`.`sys_category` (`CATEID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `COMPANY_SHOP`
    FOREIGN KEY (`COMPANY_ID` )
    REFERENCES `wxpt`.`business_company` (`COID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `REGION_SHOP`
    FOREIGN KEY (`REGION_ID` )
    REFERENCES `wxpt`.`sys_region_category` (`RCID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`business_goods`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`business_goods` (
  `GOID` INT(11) NOT NULL AUTO_INCREMENT ,
  `CATEGORY_ID` INT(11) NOT NULL ,
  `COMPANY_ID` INT(11) NOT NULL ,
  `SHOP_ID` INT(11) NOT NULL ,
  `REGION_ID` INT(11) NOT NULL ,
  `SHID` INT(11) NOT NULL ,
  `NAME` VARCHAR(100) NOT NULL ,
  `PRICE` DECIMAL(10,2) NOT NULL ,
  `DESCRIPTION` VARCHAR(200) NOT NULL ,
  `QUANTITY` INT(11) NOT NULL ,
  `PAY_QUANTITY` INT(11) NOT NULL ,
  `EVALUATE` INT(11) NOT NULL ,
  `PAY_TYPE` INT(11) NOT NULL ,
  `STATUS` INT(11) NOT NULL ,
  PRIMARY KEY (`GOID`) ,
  INDEX `GOODS_INDEX` (`GOID` ASC, `CATEGORY_ID` ASC, `COMPANY_ID` ASC, `SHOP_ID` ASC, `REGION_ID` ASC) ,
  INDEX `GOODS_COMPANY_idx` (`COMPANY_ID` ASC) ,
  INDEX `GOODS_CATEGORY_idx` (`CATEGORY_ID` ASC) ,
  INDEX `GOOGDS_SHOP_idx` (`SHOP_ID` ASC) ,
  INDEX `GOOODS_REGION_idx` (`REGION_ID` ASC) ,
  CONSTRAINT `GOODS_CATEGORY`
    FOREIGN KEY (`CATEGORY_ID` )
    REFERENCES `wxpt`.`sys_category` (`CATEID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `GOODS_COMPANY`
    FOREIGN KEY (`COMPANY_ID` )
    REFERENCES `wxpt`.`business_company` (`COID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `GOOGDS_SHOP`
    FOREIGN KEY (`SHOP_ID` )
    REFERENCES `wxpt`.`business_shop` (`SHID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `GOOODS_REGION`
    FOREIGN KEY (`REGION_ID` )
    REFERENCES `wxpt`.`sys_region_category` (`RCID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`business_order_detail`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`business_order_detail` (
  `ORDID` INT(11) NOT NULL ,
  `COMPANY_ID` INT(11) NOT NULL ,
  `SHOP_ID` INT(11) NOT NULL ,
  `GOODS_ID` INT(11) NOT NULL ,
  `GOODS_PRICE` DECIMAL(10,2) NOT NULL ,
  `DIS_PRICE` DECIMAL(10,2) NOT NULL ,
  `DISCOUNT` INT(11) NOT NULL ,
  `GOODS_QUANTITY` INT(11) NOT NULL ,
  PRIMARY KEY (`ORDID`) ,
  INDEX `ORDER_DETAIL_INDEX` (`ORDID` ASC, `COMPANY_ID` ASC, `SHOP_ID` ASC, `GOODS_ID` ASC) ,
  INDEX `COMPANY_DETAIL_idx` (`COMPANY_ID` ASC) ,
  INDEX `SHOP_DETAIL_idx` (`SHOP_ID` ASC) ,
  INDEX `GOODS_DETAIL_idx` (`GOODS_ID` ASC) ,
  CONSTRAINT `COMPANY_DETAIL`
    FOREIGN KEY (`COMPANY_ID` )
    REFERENCES `wxpt`.`business_company` (`COID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `GOODS_DETAIL`
    FOREIGN KEY (`GOODS_ID` )
    REFERENCES `wxpt`.`business_goods` (`GOID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ORDER_DETAIL`
    FOREIGN KEY (`ORDID` )
    REFERENCES `wxpt`.`business_order` (`ORDID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `SHOP_DETAIL`
    FOREIGN KEY (`SHOP_ID` )
    REFERENCES `wxpt`.`business_shop` (`SHID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`business_push`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`business_push` (
  `PUID` INT(11) NOT NULL AUTO_INCREMENT ,
  `ATTACHMENT_ID` INT(11) NOT NULL ,
  `TYPE` INT(11) NOT NULL ,
  `DATE` DATETIME NOT NULL ,
  `CONTENT` VARCHAR(200) NOT NULL ,
  `MODE` INT(11) NOT NULL ,
  `STATUS` INT(11) NOT NULL ,
  `CREATENAME` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`PUID`) ,
  INDEX `PUSH_INDEX` (`PUID` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`business_shopcar`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`business_shopcar` (
  `SCID` INT(11) NOT NULL AUTO_INCREMENT ,
  `UID` BIGINT(20) NOT NULL ,
  `GOODS_ID` INT(11) NOT NULL ,
  `GOODS_NAME` VARCHAR(100) NOT NULL ,
  `QUANTITY` INT(11) NOT NULL ,
  `DATE` DATETIME NOT NULL ,
  `GOODS_PRICE` DECIMAL(10,2) NOT NULL ,
  `AMOUNT` DECIMAL(10,2) NOT NULL ,
  PRIMARY KEY (`SCID`) ,
  INDEX `SHOPCAR_INDEX` (`SCID` ASC, `UID` ASC, `GOODS_ID` ASC) ,
  INDEX `MEMBER_SHOPCAR_idx` (`UID` ASC) ,
  INDEX `GOODS_SHOPCAR_idx` (`GOODS_ID` ASC) ,
  CONSTRAINT `GOODS_SHOPCAR`
    FOREIGN KEY (`GOODS_ID` )
    REFERENCES `wxpt`.`business_goods` (`GOID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `MEMBER_SHOPCAR`
    FOREIGN KEY (`UID` )
    REFERENCES `wxpt`.`common_members` (`UID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`common_admin`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`common_admin` (
  `ADMID` INT(11) NOT NULL AUTO_INCREMENT ,
  `GROUP_ID` INT(11) NOT NULL ,
  `COMPANY_ID` INT(11) NOT NULL ,
  `USERNAME` VARCHAR(20) NOT NULL ,
  `PASSWORD` VARCHAR(32) NOT NULL ,
  `REALNAME` VARCHAR(10) NOT NULL ,
  `CREATEDATE` DATETIME NOT NULL ,
  `CREATENAME` VARCHAR(20) NOT NULL ,
  `STATUS` INT(11) NOT NULL ,
  PRIMARY KEY (`ADMID`) ,
  INDEX `ADMIN_INDEX` (`ADMID` ASC, `COMPANY_ID` ASC, `USERNAME` ASC) ,
  INDEX `COMPANY_ADMIN_idx` (`COMPANY_ID` ASC) ,
  CONSTRAINT `COMPANY_ADMIN`
    FOREIGN KEY (`COMPANY_ID` )
    REFERENCES `wxpt`.`business_company` (`COID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`common_counties`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`common_counties` (
  `UID` BIGINT(20) NOT NULL ,
  `TEL` VARCHAR(15) NOT NULL ,
  `MOBILE` VARCHAR(15) NOT NULL ,
  `ZIPCODE` VARCHAR(10) NOT NULL ,
  `ADDRESS` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`UID`) ,
  INDEX `COUNTIES_INDEX` (`UID` ASC) ,
  CONSTRAINT `MEMBER_COUNTIES`
    FOREIGN KEY (`UID` )
    REFERENCES `wxpt`.`common_members` (`UID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`common_fraction`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`common_fraction` (
  `UID` BIGINT(20) NOT NULL ,
  `QUANTITY` INT(11) NOT NULL ,
  `LAST_TIME` DATETIME NOT NULL ,
  `LAST_QUANTITY` INT(11) NOT NULL ,
  PRIMARY KEY (`UID`) ,
  INDEX `FRACTION_INDEX` (`UID` ASC) ,
  CONSTRAINT `MEMBER_FRACTION`
    FOREIGN KEY (`UID` )
    REFERENCES `wxpt`.`common_members` (`UID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`common_member_action`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`common_member_action` (
  `ACID` INT(11) NOT NULL AUTO_INCREMENT ,
  `UID` BIGINT(20) NOT NULL ,
  `CONTENT` VARCHAR(50) NOT NULL ,
  `DATE` DATETIME NOT NULL ,
  `NICKNAME` VARCHAR(30) NOT NULL ,
  `TYPE` INT(11) NOT NULL ,
  PRIMARY KEY (`ACID`) ,
  INDEX `ACTION_INDEX` (`ACID` ASC, `UID` ASC) )
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`sys_attachment`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`sys_attachment` (
  `ATID` INT(11) NOT NULL AUTO_INCREMENT ,
  `ADVERTISEMENT_ID` INT(11) NULL DEFAULT NULL ,
  `GOODS_ID` INT(11) NULL DEFAULT NULL ,
  `FILENAME` VARCHAR(32) NOT NULL ,
  `PATH` VARCHAR(100) NOT NULL ,
  `DATE` DATETIME NOT NULL ,
  `MIMETYPE` INT(11) NOT NULL ,
  `CREATENAME` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`ATID`) ,
  INDEX `ATID` (`ATID` ASC) )
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`sys_command`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`sys_command` (
  `COMID` INT(11) NOT NULL AUTO_INCREMENT ,
  `COMPANY_ID` INT(11) NOT NULL ,
  `KEYVALUE` VARCHAR(15) NOT NULL ,
  `EVENT_URL` VARCHAR(100) NOT NULL ,
  `EVENT_TYPE` INT(11) NOT NULL ,
  `CREATE_NAME` VARCHAR(20) NOT NULL ,
  `CREATE_DATE` DATETIME NOT NULL ,
  PRIMARY KEY (`COMID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`sys_config`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`sys_config` (
  `KEY` VARCHAR(20) NOT NULL ,
  `VALUE` VARCHAR(100) NOT NULL ,
  `DESCRIPTION` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`KEY`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`sys_menu_group`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`sys_menu_group` (
  `MGID` INT(11) NOT NULL AUTO_INCREMENT ,
  `COMPANY_ID` INT(11) NOT NULL ,
  `SHOP_ID` INT(11) NULL DEFAULT NULL ,
  `GOODS_ID` INT(11) NULL DEFAULT NULL ,
  `COMMAND_ID` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`MGID`) ,
  INDEX `MENU_GROUP_INDEX` (`MGID` ASC, `COMPANY_ID` ASC, `SHOP_ID` ASC, `GOODS_ID` ASC, `COMMAND_ID` ASC) ,
  INDEX `COMPANY_MG_idx` (`COMPANY_ID` ASC) ,
  INDEX `SHOP_MG_idx` (`SHOP_ID` ASC) ,
  INDEX `GOODS_MG_idx` (`GOODS_ID` ASC) ,
  INDEX `COMMAND_MG_idx` (`COMMAND_ID` ASC) ,
  CONSTRAINT `COMMAND_MG`
    FOREIGN KEY (`COMMAND_ID` )
    REFERENCES `wxpt`.`sys_command` (`COMID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `COMPANY_MG`
    FOREIGN KEY (`COMPANY_ID` )
    REFERENCES `wxpt`.`business_company` (`COID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `GOODS_MG`
    FOREIGN KEY (`GOODS_ID` )
    REFERENCES `wxpt`.`business_goods` (`GOID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `SHOP_MG`
    FOREIGN KEY (`SHOP_ID` )
    REFERENCES `wxpt`.`business_shop` (`SHID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wxpt`.`sys_menus`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `wxpt`.`sys_menus` (
  `MENUID` INT(11) NOT NULL AUTO_INCREMENT ,
  `MENU_GROUP_ID` INT(11) NOT NULL ,
  `NAME` VARCHAR(7) NOT NULL ,
  `TYPE` INT(11) NOT NULL ,
  `EVENT` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`MENUID`) ,
  INDEX `MENUS_INDEX` (`MENUID` ASC, `MENU_GROUP_ID` ASC) ,
  INDEX `MENU_GROUP_MENU_idx` (`MENU_GROUP_ID` ASC) ,
  CONSTRAINT `MENU_GROUP_MENU`
    FOREIGN KEY (`MENU_GROUP_ID` )
    REFERENCES `wxpt`.`sys_menu_group` (`MGID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `wxpt` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
