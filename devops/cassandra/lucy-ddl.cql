-- key space
create keyspace if not exists lucy
            with replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};
use lucy;

create table if not exists account (
    "uid" bigint primary key,
    "token"   text,
);

create table if not exists shorten_url (
    hash ascii primary key,
    url   text,
    password text,
);
