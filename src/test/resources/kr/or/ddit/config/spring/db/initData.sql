
/*운영환경에서 돌아갈수 없는 테이블을 만들어놓았다. 에러방지용*/
select * 
from no_exists_in_prd;



/*DELETE users;*/
TRUNCATE TABLE users;


Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('brown','브라운','brownPass',to_date('2019/01/28','RRRR/MM/DD'),'브라우니','대전특별시 중구','대흥동 454-12','12345','E:\profile\b71ceb10-b109-461f-aef3-28c90d205a55.jpg','ryan.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('cony','코니','conyPass',to_date('2019/01/28','RRRR/MM/DD'),'토끼',null,null,null,'E:\profile\cony.png','cony.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('sally','샐리','sallyPass',to_date('2019/01/28','RRRR/MM/DD'),'병아리',null,null,null,'E:\profile\sally.png','sally.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('james','제임스','jamesPass',to_date('2019/01/28','RRRR/MM/DD'),'사람',null,null,null,'E:\profile\james.png','james.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('moon','문','moonPass',null,'달',null,null,null,'E:\profile\moon.png','moon.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('leonard','레너드','leonardPass',to_date('2020/10/15','RRRR/MM/DD'),'개구리',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('edward','에드워드','edwardPass',to_date('2020/10/15','RRRR/MM/DD'),'애벌레',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('jessica','제시카','jessicaPass',to_date('2020/10/15','RRRR/MM/DD'),'고양이',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('boss','보스','bossPass',to_date('2020/10/15','RRRR/MM/DD'),'사람',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('choco','초코','chocoPass',to_date('2020/10/15','RRRR/MM/DD'),'곰2',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('pangyo','팡요','pangyoPass',to_date('2020/10/15','RRRR/MM/DD'),'판다',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('muzi','무지','muziPass',to_date('2020/10/15','RRRR/MM/DD'),'토끼',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('con','콘','conPass',to_date('2020/10/15','RRRR/MM/DD'),'악어',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('apeach','어피치2','apeachPass',to_date('2020/10/15','RRRR/MM/DD'),'복숭아',null,null,null,'E:\profile\20e90ccd-d1e5-4ccc-9706-0fcece1f6872.jpg','DovYlrQU0AAFoEL.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('ryan','라이언 ','ryanPass',to_date('2020/10/15','RRRR/MM/DD'),'사자',null,null,null,'E:\profile\954cfc88-c77e-4fe2-a947-48e75444c4bb.gif','ryan3.gif');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('nyr3','예리니222','1234',to_date('2020/10/22','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\432af6e3-a71f-4ea9-a12a-28c9b7f45e57.jpg','DovYlrQU0AAFoEL.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('nyr','예리니','1234',to_date('2020/11/05','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\DovYlrQU0AAFoEL.jpg','DovYlrQU0AAFoEL.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('nyr11111','예리니','1234',to_date('2020/11/05','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\DovYlrQU0AAFoEL.jpg','DovYlrQU0AAFoEL.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('nyr22222','예리니','1234',to_date('2020/11/05','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\ryanE.jpg','ryanE.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('nyr33333','예리니232','1234',to_date('2020/11/05','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\ryanE.jpg','ryanE.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('nyr44444','예리니','1234',to_date('2020/11/05','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\ryanE.jpg','ryanE.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('nyr11','예리니','1234',to_date('2020/10/22','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\f1153353-728f-4dff-a531-3c8442b18bb8.jpg','unnamed.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('nyr12323123','예리니','1234',to_date('2020/11/05','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\e3bdb9cb-e81a-43dd-8ca9-adb4a6833af3','ryanE.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('nyr23','예리니','1234',to_date('2020/10/22','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\fb1327e4-d39c-49d2-b839-5bf11e10a7f1.jpg','ryanE.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('nyr22222223123123','예리니','1234',to_date('2020/11/05','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\72e30503-6598-42df-96bf-1f606b872875.jpg','ryanE.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('nyr123','예리니','1234',to_date('2020/10/22','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','e:\profile\nyr.png','nyr.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('nyr2312','예리','1234',to_date('2020/10/22','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\6145aa67-8015-4ee0-bb6b-bfcc06353dcc.png','2018-03-16_10;50;49.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('nyr12312312','예리니','1234',to_date('2020/11/05','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\ce880af3-ac39-432d-88a8-287f36eaee0c.jpg','ryanE.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('123123124','예리니adfa1234','1234',to_date('2020/11/05','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\77d64cc4-9a0e-41d8-8474-a4ee3b8eebbc.jpg','green.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('aaaaaaaa','예리닝','1234',to_date('2020/11/09','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\5adae7c0-abde-4861-be7b-eeca0439b963.jpg','green.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('aaaaa','예리닝','1234',to_date('2020/11/09','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\8593c7d3-f576-4931-9026-5304a0fa671b.jpg','green.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('bbbbb','예리닝','1234',to_date('2020/11/09','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\6d2c8a3a-f11c-42e7-8495-6f9d6f771d14.jpg','red.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('ccc','예리닝','1234',to_date('2020/11/09','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\0cb317b7-db57-4438-868c-b62df395a287.jpg','DovYlrQU0AAFoEL.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('xxxx','예리닝','1234',to_date('2020/11/09','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\96f5e651-d9f2-4594-8813-f6f0faf536a8.jpg','red.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('xxx','예리닝','1234',to_date('2020/11/09','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\8a491a9b-ba55-4e15-916a-6f62c37e1d7e.jpg','green.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('xxxxx','예리닝','1234',to_date('2020/11/09','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\2a83cefa-129f-4830-a175-382a80a284fc.gif','ryan.gif');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('qqqqq','예리닝','1234',to_date('2020/11/09','RRRR/MM/DD'),'rinee','대전 중구 중앙로 76','영민빌딩 404호','34940','E:\profile\ded9a5dc-5b1e-4118-a1f9-0a42c349c3b2.jpg','unnamed.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('ddit','대덕인재','dditpass',to_date('2020/11/11','RRRR/MM/DD'),'개발원',null,null,null,null,null);