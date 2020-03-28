CREATE TABLE IF NOT EXISTS `user` (

`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` varchar(100) NOT NULL,
`username` varchar(100) NOT NULL UNIQUE,
`password` varchar(100) NOT NULL,
`role` varchar(100) NOT NULL,
`active` bit NOT NULL,
`date_created` DATETIME,
`last_updated` DATETIME

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;