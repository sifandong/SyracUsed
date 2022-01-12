```sql
CREATE DATABASE syracused;
use syracused;

DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `items`;
DROP TABLE IF EXISTS `wishlists`;


CREATE TABLE users (
    id INT unsigned NOT NULL AUTO_INCREMENT,
    nickname VARCHAR(20),
    lat DOUBLE(11,7),
    lng DOUBLE(11,7),
    PRIMARY KEY (id)

);

CREATE TABLE selling_items (
    id INT unsigned NOT NULL AUTO_INCREMENT,
    seller_id INT unsigned,
    price DECIMAL(6,2),
    is_dollar BIT,
    description VARCHAR(255),
    is_deliverable BIT,
    PRIMARY KEY (id),
    FOREIGN KEY (seller_id) REFERENCES users(id)
);

CREATE TABLE requested_items (
    id INT unsigned NOT NULL AUTO_INCREMENT,
    requester_id INT unsigned,
    description VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (requester_id) REFERENCES users(id)
);taro-
```
```sql
# test
INSERT INTO users(id,nickname,lat,lng)
VALUES(1,'aspen_resident','43.02050517049937', '-76.1369542450678');
INSERT INTO users(id,nickname,lat,lng)
VALUES(2,'theory_resident','43.047199649658026', '-76.13686968739395');

INSERT INTO selling_items(id,seller_id,price,is_dollar,description,is_deliverable)
VALUES(1,1,150,0x01,'95新switch',0x00);

INSERT INTO selling_items(id,seller_id,price,is_dollar,description,is_deliverable)
VALUES(2,1,30,0x00,'95新自拍杆',0x01);

INSERT INTO selling_items(id,seller_id,price,is_dollar,description,is_deliverable)
VALUES(3,2,600,0x01,'thinkpadx1carbon',0x00);

INSERT INTO selling_items(id,seller_id,price,is_dollar,description,is_deliverable)
VALUES(4,2,50,0x00,'厨具',0x01);

INSERT INTO requested_items(id,requester_id,description)
VALUES(1,1,'想买个oculus quest2');

INSERT INTO requested_items(id,requester_id,description)
VALUES(2,2,'有人出相机吗');

```