CREATE TABLE IF NOT EXISTS `subscription` (

`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` varchar(100) NOT NULL,
`active` bit NOT NULL,
`qt_users` int,
`date_created` DATETIME,
`last_updated` DATETIME


)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `user` (

`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` varchar(100) NOT NULL,
`username` varchar(100) NOT NULL UNIQUE,
`password` varchar(100) NOT NULL,
`role` varchar(100) NOT NULL,
`active` bit NOT NULL,
`date_created` DATETIME,
`last_updated` DATETIME,
`subscription_id` int,

CONSTRAINT FK_SubscriptionUser FOREIGN KEY (subscription_id)
    REFERENCES subscription(id)

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;