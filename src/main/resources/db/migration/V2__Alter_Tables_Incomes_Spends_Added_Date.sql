alter table if exists incomes
 drop column if exists timestamp;

alter table if exists incomes
    add column if not exists date date;

alter table if exists spends
    drop column if exists timestamp;
alter table if exists spends
    add column if not exists date date;
