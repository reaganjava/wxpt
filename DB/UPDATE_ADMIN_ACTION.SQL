USE WXPT;
CREATE TABLE `common_admin_action` (
  `AAID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ADMINID` int(11) NOT NULL,
  `CONTENT` varchar(50) NOT NULL,
  `DATE` datetime NOT NULL,
  `USERNAME` varchar(20) NOT NULL,
  `TYPE` int(11) NOT NULL,
  PRIMARY KEY (`AAID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;