CREATE TABLE user(
  u_id                          INT(11) AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  u_name                        VARCHAR(255),
  u_password                    VARCHAR(255),
  u_phone                       VARCHAR(255),
  u_email                       VARCHAR(255),
  u_avatar_id                   INT(11),
  u_last_time                   DATETIME,
  u_create_time                 DATETIME,
  u_state                       INT(11) DEFAULT '0',
  u_salt                       VARCHAR(10)
);
CREATE TABLE image_resource(
  ir_id                          INT(11) AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  ir_path                        VARCHAR(255),
  ir_upload_time                 DATETIME NOT NULL,
  ir_user_id                     INT(11)
);

