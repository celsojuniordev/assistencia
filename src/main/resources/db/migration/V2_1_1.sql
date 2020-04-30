CREATE TABLE IF NOT EXISTS `phone` (

`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`number` varchar(100) NOT NULL,
`type` varchar(100) NOT NULL,
`date_created` DATETIME,
`last_updated` DATETIME,
`date_deleted` DATETIME,
`user_id` int,

CONSTRAINT FK_UserPhone FOREIGN KEY (user_id)
    REFERENCES user(id)

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;