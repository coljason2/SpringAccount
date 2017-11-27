--company
insert into  APP_COMPANY   (CRE_DATE, OID, UP_DATE, version, COM_NAME, COMPANY_ID) values  (now() , UUID(), now(), 1, '杏輝', uuid());
insert into  APP_COMPANY   (CRE_DATE, OID, UP_DATE, version, COM_NAME, COMPANY_ID) values  (now() , UUID(), now(), 1, '久裕', uuid());
insert into  APP_COMPANY   (CRE_DATE, OID, UP_DATE, version, COM_NAME, COMPANY_ID) values  (now() , UUID(), now(), 1, '裕利', uuid());
insert into  APP_COMPANY   (CRE_DATE, OID, UP_DATE, version, COM_NAME, COMPANY_ID) values  (now() , UUID(), now(), 1, '生達', uuid());
insert into  APP_COMPANY   (CRE_DATE, OID, UP_DATE, version, COM_NAME, COMPANY_ID) values  (now() , UUID(), now(), 1, '中化', uuid());
insert into  APP_COMPANY   (CRE_DATE, OID, UP_DATE, version, COM_NAME, COMPANY_ID) values  (now() , UUID(), now(), 1, '信東', uuid());
insert into  APP_COMPANY   (CRE_DATE, OID, UP_DATE, version, COM_NAME, COMPANY_ID) values  (now() , UUID(), now(), 1, '十全', uuid());
insert into  APP_COMPANY   (CRE_DATE, OID, UP_DATE, version, COM_NAME, COMPANY_ID) values  (now() , UUID(), now(), 1, '東竹', uuid());
--insert into  APP_COMPANY   (CRE_DATE, OID, UP_DATE, version, COM_NAME, COMPANY_ID) values  (now() , UUID(), now(), 1, '台一', uuid());
insert into  APP_COMPANY   (CRE_DATE, OID, UP_DATE, version, COM_NAME, COMPANY_ID) values  (now() , UUID(), now(), 1, '大昌', uuid());
insert into  APP_COMPANY   (CRE_DATE, OID, UP_DATE, version, COM_NAME, COMPANY_ID) values  (now() , UUID(), now(), 1, '晟德', uuid());
insert into  APP_COMPANY   (CRE_DATE, OID, UP_DATE, version, COM_NAME, COMPANY_ID) values  (now() , UUID(), now(), 1, '健亞', uuid());
insert into  APP_COMPANY   (CRE_DATE, OID, UP_DATE, version, COM_NAME, COMPANY_ID) values  (now() , UUID(), now(), 1, '泰宗', uuid());

--hospital
insert into APP_HOSPITAL  (HOSPITAL_ID ,CRE_DATE,OID,UP_DATE,VERSION,HOS_NAME ) values (uuid(),now(),uuid(),now(),1,'仁愛醫院');
insert into APP_HOSPITAL  (HOSPITAL_ID ,CRE_DATE ,OID,UP_DATE,VERSION,HOS_NAME ) values (uuid(),now(),uuid(),now(),1,'普門醫院');
insert into APP_HOSPITAL  (HOSPITAL_ID ,CRE_DATE ,OID,UP_DATE,VERSION,HOS_NAME ) values (uuid(),now(),uuid(),now(),1,'普門診所');
insert into APP_HOSPITAL  (HOSPITAL_ID ,CRE_DATE ,OID,UP_DATE,VERSION,HOS_NAME ) values (uuid(),now(),uuid(),now(),1,'普門健康');

--medicine
set @comid = (SELECT COMPANY_ID FROM APP_COMPANY where COM_NAME = '杏輝');
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'保利肝', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'安嗽', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'樂多糖', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'杏緩妥50M', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'杏化樂', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'美必胃135M', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'依莫瀉', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'壓血泰', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'蘆瀉黃', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'金貝比', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'寧康口內膠', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'杏聯親水軟膏', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'美康乳膏', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'喜美凝膠20MG', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'燙膚舒', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'美康耳用滴', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'諾蘭仙', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'旺滴', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'威寧疼', null , @comid );

set @comid = (SELECT COMPANY_ID FROM APP_COMPANY where COM_NAME = '裕利');
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'益脂可長效', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'易安穩', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'得安穩80MG', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'心樂寧', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'雅施達加強', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'痘膚潤50MG', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'痘膚潤15M', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'高糖優適錠50MG', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'利飛亞', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'雅施達錠', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'喜克脂', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'愛爾康柔膠15MG', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'舒栓寧75MG', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'舒脈康', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'雅脈', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'美百樂', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'得安穩160MG', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'必康80MG', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'去痰寧600MG', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'妥寧', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'托必拉美', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'賽樂治200MG', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'醣祿錠50MG', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'冠達悅', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'代蜜克龍', null , @comid );

set @comid = (SELECT COMPANY_ID FROM APP_COMPANY where COM_NAME = '中化');
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'恆脈循膜衣錠', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'飛敏耐膜衣錠60MG', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'心耐糖衣錠', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'柔糖錠', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'諾脂替', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'力停疼', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'黴癒錠250MG', null , @comid );

set @comid = (SELECT COMPANY_ID FROM APP_COMPANY where COM_NAME = '大昌');
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'利飛亞', null , @comid );

set @comid = (SELECT COMPANY_ID FROM APP_COMPANY where COM_NAME = '健亞');
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'易利淨', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'降脂妥', null , @comid );

set @comid = (SELECT COMPANY_ID FROM APP_COMPANY where COM_NAME = '泰宗');
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'克醣錠', null , @comid );

set @comid = (SELECT COMPANY_ID FROM APP_COMPANY where COM_NAME = '東竹');
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'可致律錠100MG', null , @comid );

set @comid = (SELECT COMPANY_ID FROM APP_COMPANY where COM_NAME = '晟德');
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'癲別液', null , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'賽力多內服液', null , @comid );

set @comid = (SELECT COMPANY_ID FROM APP_COMPANY where COM_NAME = '信東');
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'利控糖', 'AB58071100' , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'賜康保肝', 'AC479011G0' , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'雷司動錠2MG', 'AC47690100' , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'莫煩膜衣錠100MG', 'AC41547100' , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'帝帕克', 'AB46524100' , @comid );
insert into APP_MEDICINE (MEDICINE_ID,CRE_DATE,OID,UP_DATE,VERSION,NAME,NUMBER_ID,COMPANY_ID) values (uuid(),now(),uuid(),now(),1,'服脈錠2MG', 'AC43317100' , @comid );