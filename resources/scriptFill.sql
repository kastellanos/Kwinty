INSERT INTO `Credentials` VALUES('admin','admin');
INSERT INTO `User` VALUES('admin','cedula','admin','Admin Ad',145456);
INSERT INTO `Credentials` VALUES('jmelavo','melavo');
INSERT INTO `User` VALUES('jmelavo','cedula','admin','Jhonny Melavo',345456);
INSERT INTO `Credentials` VALUES('epolindo','polindo');
INSERT INTO `User` VALUES('epolindo','cedula','client','Elsa Polindo',123456);
INSERT INTO `Credentials` VALUES('ltigante','gante');
INSERT INTO `User` VALUES('ltigante','cedula','client','Lali Tigante',123456);
INSERT INTO `Credentials` VALUES('atilla','tilla');
INSERT INTO `User` VALUES('atilla','cedula','client','Aitor Tilla',987543);
INSERT INTO `Credentials` VALUES('faarangurent','gurent');
INSERT INTO `User` VALUES('faarangurent','cedula','client','Franco Aranguren',478378);
INSERT INTO `Credentials` VALUES('goldexperience','gold');
INSERT INTO `User` VALUES('goldexperience','cedula','client','Giorno Giovanna',357357);
INSERT INTO `Credentials` VALUES('theworld','idio');
INSERT INTO `User` VALUES('theworld','cedula','client','Dio Brando',3579257);
INSERT INTO `Credentials` VALUES('jojo','star');
INSERT INTO `User` VALUES('jojo','cedula','client','Jhonny Joestar',7326846);
INSERT INTO `Credentials` VALUES('stoneocean','string');
INSERT INTO `User` VALUES('stoneocean','cedula','client','Jolyne Cuho',937592);
INSERT INTO `User` VALUES('client','cedula','client','client',937521);
INSERT INTO `Credentials` VALUES('client','client');

INSERT INTO kwinty.Product (`type`, fee_type, interest_type, max_number_fees, interest_rate, description)  VALUES( 'Uno','Inicial','Compuesto',18,0.10,NULL);
INSERT INTO kwinty.Product (`type`, fee_type, interest_type, max_number_fees, interest_rate, description)  VALUES( 'Dos','Inicial','Compuesto',12,0.12,NULL);
INSERT INTO kwinty.Product (`type`, fee_type, interest_type, max_number_fees, interest_rate, description)  VALUES( 'Tres','Inicial','Compuesto',24,0.22,NULL);
INSERT INTO kwinty.Product (`type`, fee_type, interest_type, max_number_fees, interest_rate, description)  VALUES( 'Cuatro','Fijo','Simple',18,0.30,NULL);
INSERT INTO kwinty.Product (`type`, fee_type, interest_type, max_number_fees, interest_rate, description)  VALUES( 'Cinco','Fijo','Simple',12,0.25,NULL);



INSERT INTO kwinty.Acquiredproduct (Product_id, username_id, number_fees, amount, fee_amount, amount_paid, reference, acquisition_date, fee_increment_rate) VALUES(2, 'theworld',3,6,75000000,123456,'Carlangas','2002-08-12',0.2);
INSERT INTO kwinty.Acquiredproduct (Product_id, username_id, number_fees, amount, fee_amount, amount_paid, reference, acquisition_date, fee_increment_rate) VALUES(3, 'goldexperience',2,8,45500000,123456,'Carlangas','2002-08-12',0.2);
INSERT INTO kwinty.Acquiredproduct (Product_id, username_id, number_fees, amount, fee_amount, amount_paid, reference, acquisition_date, fee_increment_rate) VALUES(4, 'goldexperience',3,4,80000000,123456,'Carlangas','2002-08-12',0.2);
INSERT INTO kwinty.Acquiredproduct (Product_id, username_id, number_fees, amount, fee_amount, amount_paid, reference, acquisition_date, fee_increment_rate) VALUES(5, 'jmelavo',1,5,20000000,123456,'Carlos','2002-08-12',0.2);
INSERT INTO kwinty.Acquiredproduct (Product_id, username_id, number_fees, amount, fee_amount, amount_paid, reference, acquisition_date, fee_increment_rate) VALUES(2, 'stoneocean',5,4,30000000,123456,'Carlos','2002-08-12',0.2);
INSERT INTO kwinty.Acquiredproduct (Product_id, username_id, number_fees, amount, fee_amount, amount_paid, reference, acquisition_date, fee_increment_rate) VALUES(4, 'jmelavo',3,4,80000000,123456,'Carlangas','2002-08-12',0.2);
INSERT INTO kwinty.Acquiredproduct (Product_id, username_id, number_fees, amount, fee_amount, amount_paid, reference, acquisition_date, fee_increment_rate) VALUES(3, 'jojo',4,6,100000000,123456,'Carlos','2002-08-12',0.2);
INSERT INTO kwinty.Acquiredproduct (Product_id, username_id, number_fees, amount, fee_amount, amount_paid, reference, acquisition_date, fee_increment_rate) VALUES(5, 'jojo',5,8,80000000,123456,'Carlos','2002-08-12',0.2);
INSERT INTO kwinty.Acquiredproduct (Product_id, username_id, number_fees, amount, fee_amount, amount_paid, reference, acquisition_date, fee_increment_rate) VALUES(1, 'goldexperience',2,6,35000000,123456,'Carlangas','2002-08-12',0.2);

INSERT INTO `Admin` VALUES('admin','Your moms house');
INSERT INTO `Admin` VALUES('jmelavo','Your moms house');
INSERT INTO `Client` VALUES('epolindo',1234576,'epolindo@aa.com', 'calle3',500000);
INSERT INTO `Client` VALUES('ltigante',31223456,'ltigante@aa.com', 'calle2', 100000);
INSERT INTO `Client` VALUES('atilla',9872543, 'atilla@aa.com', 'calle45', 500000);
INSERT INTO `Client` VALUES('faarangurent',4783782, 'faarangurent@aa.com', 'calle23', 10000000);
INSERT INTO `Client` VALUES('goldexperience', 234357357, 'gold@aa.com', 'calle 33', 10000500);
INSERT INTO `Client` VALUES('theworld',3579257, 'dio@aa.com', 'carrera 12', 5420000);
INSERT INTO `Client` VALUES('jojo',7326846, 'jojo@aa.com', 'calle 54', 2345200);
INSERT INTO `Client` VALUES('stoneocean',313937592, 'free@aa.com', 'calle evergreen', 3500000);
INSERT INTO `Client` VALUES('client',313937592, 'free@aa.com', 'calle evergreen', 3500000);

INSERT INTO `Payment` values('2016-09-12', 10000, 3,'admin');
INSERT INTO `Payment` values('2016-09-13', 20000, 3,'admin');
INSERT INTO `Payment` values('2016-09-14', 30000, 3,'admin');
INSERT INTO `Payment` values('2016-09-15', 40000, 3,'admin');






