
    drop table event if exists;
    
    drop table event_type if exists;
    
    drop table users if exists;
    
    create table event (
       Id bigint generated by default as identity,
        event_time timestamp,
        notes varchar(255),
        selecttype_id bigint,
        user_id bigint,
        primary key (Id)
    );
    
    create table event_type (
       selectType varchar(31) not null,
        id bigint generated by default as identity,
        change_type integer,
        amount decimal(19,2),
        wakeup timestamp,
        primary key (id)
    );
    
    create table users (
       Id bigint generated by default as identity,
        email varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (Id)
    );
    
    alter table event 
       add constraint FKj41m232kul24o0saf16fmx5ad 
       foreign key (selecttype_id) 
       references event_type;

    alter table event 
       add constraint FK31rxexkqqbeymnpw4d3bf9vsy 
       foreign key (user_id) 
       references users;