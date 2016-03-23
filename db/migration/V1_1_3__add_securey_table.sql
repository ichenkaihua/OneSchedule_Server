CREATE TABLE `authentication` (
  ac_id                          INT(11) AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  ac_user_id                      INT,
  ac_create_time                 DATETIME NOT NULL,
  ac_md5_value                    VARCHAR(400),
  ac_update_time                  DATETIME NOT NULL ,
  ac_expire_time                  DATETIME NOT NULL
);

