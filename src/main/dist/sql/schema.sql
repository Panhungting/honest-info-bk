DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) NOT NULL,
  `price` int(11) DEFAULT 0,
  `summary` varchar(256) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- employee
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
`employee_id` INT AUTO_INCREMENT NOT NULL,
`employee_name` VARCHAR(32)  NOT NULL,
`gender` TINYINT ,
`address` VARCHAR(256) ,
`tel` VARCHAR(128) ,
`mail` VARCHAR(128) ,
`login_id` VARCHAR(128) ,
`password` VARCHAR(128)  NOT NULL,
`authority` TINYINT DEFAULT 1,
`delete_flag` TINYINT DEFAULT 0,
`created_at` DATETIME  NOT NULL,
PRIMARY KEY (`employee_id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

-- employee_skill
DROP TABLE IF EXISTS  `employee_skill`;
CREATE TABLE `employee_skill` (
`employee_id` INT  NOT NULL,
`skill_id` INT  NOT NULL,
`level` TINYINT DEFAULT 0,
`created_at` DATETIME  NOT NULL,
PRIMARY KEY (`employee_id` , `skill_id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

-- skill
DROP TABLE IF EXISTS  `skill`;
CREATE TABLE `skill` (
`skill_id` INT AUTO_INCREMENT NOT NULL,
`skill` VARCHAR(32)  NOT NULL,
`category` TINYINT DEFAULT 0,
`created_at` DATETIME  NOT NULL,
PRIMARY KEY (`skill_id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

-- bulletin
DROP TABLE IF EXISTS  `bulletin`;
CREATE TABLE `bulletin` (
`bulletin_id` INT AUTO_INCREMENT NOT NULL,
`category` VARCHAR(128) ,
`title` VARCHAR(128)  NOT NULL,
`content` TEXT ,
`publish_date` DATETIME ,
`expiry` DATETIME ,
`publish_flag` TINYINT DEFAULT 0,
`created_at` DATETIME  NOT NULL,
PRIMARY KEY (`bulletin_id`),
UNIQUE `idx_title`(title)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;