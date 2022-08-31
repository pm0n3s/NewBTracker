insert into users(id, username, password, email, phone) 
values (10001, 'pat', 'pat', 'pat@g.com', '555-5556');

insert into EVENT_TYPE(ID, SELECT_TYPE, CHANGE_TYPE, AMOUNT, WAKEUP) 
values (30001, 'change', 0, null, null);

insert into event(ID, NOTES, EVENT_TIME, SELECTTYPE_ID, USER_ID)
values (20001, 'damp not full', NOW(), 30001, 10001);

insert into EVENT_TYPE(ID, SELECT_TYPE, CHANGE_TYPE, AMOUNT, WAKEUP) 
values (30002, 'feed', null, 18.5, null);

insert into event(ID, NOTES, EVENT_TIME, SELECTTYPE_ID, USER_ID)
values (20002, 'finished without fussing', NOW(), 30002, 10001);

insert into EVENT_TYPE(ID, SELECT_TYPE, CHANGE_TYPE, AMOUNT, WAKEUP)
values (30003, 'sleep', null, null, NOW());

insert into event(ID, NOTES, EVENT_TIME, SELECTTYPE_ID, USER_ID)
values (20003, 'slept without waking up', NOW(), 30003, 10001);


