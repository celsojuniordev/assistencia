CREATE TABLE IF NOT EXISTS `address` (

`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`street` varchar(255) NOT NULL,
`city` varchar(255),
`district` varchar(255),
`uf` varchar(10),
`zipcode` varchar(100),
`complement` varchar(255) NOT NULL,
`number` int NOT NULL,
`user_id` int,
`subscription_id` int,
`date_created` DATETIME,
`date_deleted` DATETIME,
`last_updated` DATETIME,

CONSTRAINT FK_SubscriptionAddress FOREIGN KEY (subscription_id)
    REFERENCES subscription(id),
CONSTRAINT FK_UserAddress FOREIGN KEY (user_id)
    REFERENCES user(id)

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;