drop table if exists event CASCADE

drop table if exists event_type CASCADE

drop table if exists users CASCADE

drop sequence if exists hibernate_sequence

	create table event (
       id bigint not null,
        event_time timestamp,
        notes varchar(255),
        selecttype_id bigint,
        user_id bigint,
        primary key (id)
    )
    
	create table event_type (
       select_type varchar(31) not null,
        id bigint not null,
        change_type integer,
        amount numeric(19,2),
        wakeup timestamp,
        primary key (id)
    )
    
    create table users (
       id bigint not null,
        email varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    )
    
    alter table event 
       add constraint FKj41m232kul24o0saf16fmx5ad 
       foreign key (selecttype_id) 
       references event_type

    alter table event 
       add constraint FK31rxexkqqbeymnpw4d3bf9vsy 
       foreign key (user_id) 
       references users