SET MODE MYSQL;

create table if not exists category (
id_category int unsigned auto_increment not null,
id_parent int unsigned null,
img_category varchar(250) null,
primary key (id_category),
foreign key (id_parent) references category (id_category)
);

create table if not exists product (
id_product int unsigned auto_increment not null,
price decimal(8,2) not null,
stock int not null,
id_category int unsigned not null,
img_product varchar(250) null,
primary key (id_product),
foreign key (id_category) references category (id_category)
);

create table if not exists customer (
id_customer int unsigned auto_increment not null,
name_customer varchar(20) not null,
surname_1 varchar(20) not null,
surname_2 varchar(20) null,
email varchar(256) not null,
password_customer varchar(50) not null,
street varchar(250) not null,
num int not null,
door_num int,
pc int not null,
primary key (id_customer)
);

create table if not exists purchase (
id_purchase int unsigned auto_increment not null,
date_purchase datetime not null default now(),
status_purchase int not null,
id_customer int unsigned not null,
primary key (id_purchase),
foreign key (id_customer) references customer (id_customer)
);

create table if not exists purchase_line (
quantity int not null,
id_product int unsigned not null,
id_purchase int unsigned not null,
primary key (id_product, id_purchase),
foreign key (id_product) references product (id_product),
foreign key (id_purchase) references purchase (id_purchase)
);