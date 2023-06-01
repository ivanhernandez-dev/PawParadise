create schema pawparadise;
use pawparadise;

create table category (
id_category int unsigned auto_increment not null,
id_parent int unsigned null,
img_category varchar(250) null,
primary key (id_category),
foreign key (id_parent) references category (id_category)
);

create table product (
id_product int unsigned auto_increment not null, 
price decimal(8,2) not null,
stock int not null,
id_category int unsigned not null,
img_product varchar(250) null,
primary key (id_product),
foreign key (id_category) references category (id_category)
);

create table product_feature (
index_product_feature int not null,
description_feature varchar(800) not null,
language_type char(2) not null,
id_product int unsigned not null,
primary key (id_product, index_product_feature, language_type),
foreign key (id_product) references product (id_product)
);
