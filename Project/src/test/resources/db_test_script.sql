/*
SQLyog Community v12.09 (64 bit)
MySQL - 5.6.26-log : Database - db_test
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `db_test.legends` */

CREATE DATABASE IF NOT EXISTS db_test;


GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' IDENTIFIED BY '' WITH GRANT OPTION;
FLUSH PRIVILEGES;



SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `db_test.legends`;

CREATE TABLE `db_test.legends` (
  `legend_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `legend_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`legend_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `db_test.legends` */

/*Table structure for table `legends` */

DROP TABLE IF EXISTS `legends`;

CREATE TABLE `legends` (
  `legend_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `legend_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`legend_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `legends` */

insert  into `legends`(`legend_id`,`legend_name`) values (1,'bad-sinalization');
insert  into `legends`(`legend_id`,`legend_name`) values (2,'bicyle-route');
insert  into `legends`(`legend_id`,`legend_name`) values (3,'accident-risk');
insert  into `legends`(`legend_id`,`legend_name`) values (4,'heavy-traffic');
insert  into `legends`(`legend_id`,`legend_name`) values (5,'rout-damaged');
insert  into `legends`(`legend_id`,`legend_name`) values (6,'foo1');
insert  into `legends`(`legend_id`,`legend_name`) values (7,'foo3');

/*Table structure for table `ocorrencia` */

DROP TABLE IF EXISTS `ocorrencia`;

CREATE TABLE `ocorrencia` (
  `idOcorrencia` bigint(20) NOT NULL AUTO_INCREMENT,
  `dataOcorrencia` datetime NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `lat` varchar(255) NOT NULL,
  `lng` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idOcorrencia`),
  KEY `FK1A94EBD7C12542F8` (`user_id`),
  CONSTRAINT `FK1A94EBD7C12542F8` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `ocorrencia` */

insert  into `ocorrencia`(`idOcorrencia`,`dataOcorrencia`,`endereco`,`lat`,`lng`,`title`,`user_id`) values (1,'2015-07-03 00:00:00','Rua Pereira Simões, 463 - Bairro Novo, Olinda - PE, 53030-060, Brasil','-8.001283019294856','-34.84382629394531','CPA',1);

/*Table structure for table `passwordresettoken` */

DROP TABLE IF EXISTS `passwordresettoken`;

CREATE TABLE `passwordresettoken` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `expiryDate` datetime DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC1ADB305C12542F8` (`user_id`),
  CONSTRAINT `FKC1ADB305C12542F8` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `passwordresettoken` */

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_description` (`role_description`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `roles` */

insert  into `roles`(`role_id`,`role_description`) values (1,'ROLE_ADMIN');
insert  into `roles`(`role_id`,`role_description`) values (2,'ROLE_USER');

/*Table structure for table `user_roles` */

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FK734299491BFA7F18` (`role_id`),
  KEY `FK73429949C12542F8` (`user_id`),
  CONSTRAINT `FK734299491BFA7F18` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
  CONSTRAINT `FK73429949C12542F8` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_roles` */

insert  into `user_roles`(`user_id`,`role_id`) values (1,1);
insert  into `user_roles`(`user_id`,`role_id`) values (2,2);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_password` varchar(255) DEFAULT NULL,
  `user_username` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_username` (`user_username`),
  UNIQUE KEY `user_email` (`user_email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`user_id`,`user_password`,`user_username`,`user_email`,`enabled`) values (1,'21232f297a57a5a743894a0e4a801fc3','admin','admin',1);
insert  into `users`(`user_id`,`user_password`,`user_username`,`user_email`,`enabled`) values (2,'ee11cbb19052e40b07aac0ca060c23ee','user','user',1);

/*Table structure for table `verificationtoken` */

DROP TABLE IF EXISTS `verificationtoken`;

CREATE TABLE `verificationtoken` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `expiry_date` datetime DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `verified` tinyint(1) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8E5ACC7EC12542F8` (`user_id`),
  CONSTRAINT `FK8E5ACC7EC12542F8` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `verificationtoken` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
