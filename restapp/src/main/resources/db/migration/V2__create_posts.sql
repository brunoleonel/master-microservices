CREATE TABLE posts (
	id int(11) not null auto_increment,
	description varchar(100) not null,
	user_id int not null,
	primary key (id) 
) 
ENGINE=InnoDB;