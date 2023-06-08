insert into customer values (1, 'Alma', 'López', null, 'alma@gmail.com', 'alma', 'calle alta', 1, 1, 46001);

insert into purchase (id_purchase, status_purchase, id_customer) values (1,'0', 1);

insert into category values (1, null, null);
insert into category values (5, 1, null);
insert into category values (6, 1, null);
insert into category values (7, 1, null);

insert into product values (1, 23.90, 10, 5, null);
insert into product values (2, 25.90, 20, 6, '/img/product/orange-waterproof-raincoat.png');
insert into product values (3, 16.90, 5, 7, '/img/product/pink-boots.png');

insert into purchase_line values (2, 1, 1);
insert into purchase_line values (1, 2, 1);
