create table sneakers(
    id serial primary key,
    brand varchar(255),
    country text,
    manufacturerCountry text,
    yearOfManufacture date,
    amountOfModels integer,
    total integer
);

insert into sneakers(brand, country, manufacturerCountry, yearOfManufacture, amountOfModels, total)
                 values ('VANS', 'США', 'Китай', '25-Jan-2019', 24, 120)

insert into sneakers(brand, country, manufacturerCountry, yearOfManufacture, amountOfModels, total)
                 values ('Converse', 'США', 'Бангладеш', '01-Jun-2018', 12, 98)

insert into sneakers(brand, country, manufacturerCountry, yearOfManufacture, amountOfModels, total)
                 values ('Umbro ', 'Великобритания', 'Португалия', '13-Sep-2020', 15, 74)

insert into sneakers(brand, country, manufacturerCountry, yearOfManufacture, amountOfModels, total)
                 values ('Balenciaga', 'Франция', 'Камбоджа', '20-Feb-2020', 7, 51)

select  * from sneakers

update sneakers set yearofmanufacture = '2020-01-01'

select  * from sneakers

delete from sneakers

select  * from sneakers