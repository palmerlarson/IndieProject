DELETE FROM user;
DELETE FROM goals;
DELETE FROM tool;
ALTER TABLE `user` AUTO_INCREMENT = 0;
INSERT INTO `user` VALUES (1,'Kathy','Sierra', 'kathy', 100000),(2,'Herbert','Schilt', 'herbert', 65000),(3,'Joseph','Ottinger', 'test', 33000);


