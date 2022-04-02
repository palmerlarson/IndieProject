DELETE FROM user;
DELETE FROM budgeter;
DELETE FROM goals;
DELETE FROM WDevel_Tool;
ALTER TABLE `user` AUTO_INCREMENT = 0;
INSERT INTO `user` VALUES (1,'Kathy','Sierra', 'kathy@gmail.com', 100000),(2,'Herbert','Schilt', 'herbert@gmail.com', 65000),(3,'Joseph','Ottinger', 'test@gmail.com', 33000);


