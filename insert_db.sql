# These statements input sample records into the las palmas medical center database
SET SQL_SAFE_UPDATES = 0;

insert into physician values(89745, 'Hank Williams', 'Surgeon', 551298988);
insert into physician values(43295, 'Johnny Cash', 'Intern', 237906663);
insert into physician values(90909, 'Merle Haggard', 'Senior', 987241343);
insert into physician values(67455, 'George Jones', 'Chief of Medicine', 349929213);
insert into physician values(66754, 'Charlie Daniels', 'Psychiatrist', 888754643);
insert into department values(10, 'General Medicine', 67455);
insert into department values(20, 'Surgery', 89745);
insert into department values(30, 'Psychiatry', 66754);
insert into affiliatedwith values(89745,20);
insert into affiliatedwith values(43295,10);
insert into affiliatedwith values(90909,10);
insert into affiliatedwith values(67455,10);
insert into affiliatedwith values(66754,30);
insert into `procedure` values(100, 'Hernia Repair', 5000.00);
insert into `procedure` values(200, 'Carpal Tunnel Release', 3000.00);
insert into `procedure` values(300, 'Open Heart Surgery', 50000.00);
insert into `procedure` values(400, 'Hysterectomy', 10000.00);
insert into patient values(1000, 100101000, 'Marshall Mathers', '555 Slim Shady Ln', '1975-05-15', 575-982-2345, 501, 89745);
insert into patient values(1005, 200202000, 'Dr. Dre', '420 Chronic Rd', '1966-12-12', 575-223-5656, 506, 90909);
insert into patient values(1010, 300303000, 'Ice Cube', '7555 Friday Ave', '1972-02-28', 719-678-4356, 511, 67455);
insert into patient values(1015, 400404000, 'Eazy E', '12 Hood Blvd', '1973-11-06', 575-983-4792, 516, 66754);
insert into nurse values(9000, 'Lana', 'Head Nurse', 505761234);
insert into nurse values(9005, 'Adele', 'Nurse', 760091122);
insert into nurse values(9010, 'Florence', 'Nurse', 253787111);
insert into nurse values(9015, 'Lorde', 'Nurse', 111909090);
insert into medication values(500, 'Snickers');
insert into medication values(550, 'M&Ms');
insert into medication values(505, 'Twix');
insert into medication values(510, 'Skittles');
insert into medication values(525, 'Kit Kat');
insert into prescribes values(89745, 1000, 550, '2019-01-01', 'Once a day');
insert into prescribes values(90909, 1005, 505, '2019-02-05', 'Twice a day');
insert into prescribes values(67455, 1010, 510, '2019-03-06', 'Once a day');
insert into prescribes values(89745, 1015, 525, '2019-04-07', 'Twice a day');
insert into room values(770, 'Single');
insert into room values(780, 'Double');
insert into room values(790, 'Double');
insert into room values(791, 'Single');
insert into stay values(101010, 1000, 770, '2020-02-28', '2020-03-03');
insert into stay values(202020, 1005, 780, '2020-05-28', '2020-06-01');
insert into stay values(303030, 1010, 790, '2020-12-25', '2020-12-28');
insert into stay values(404040, 1015, 791, '2021-04-15', '2021-04-16');
insert into undergoes values(1000, 100, 101010, '2020-02-28', 89745, 9000);
insert into undergoes values(1005, 200, 202020, '2020-05-28', 90909, 9005);
insert into undergoes values(1010, 300, 303030, '2020-12-25', 67455, 9010);
insert into undergoes values(1015, 400, 404040, '2021-04-15', 66754, 9015);
insert into oncall values(9000, '2022-01-01', '2022-01-31');
insert into oncall values(9005, '2022-02-01', '2022-02-28');
insert into oncall values(9010, '2022-03-01', '2022-03-31');
insert into oncall values(9015, '2022-04-01', '2022-04-30');
insert into appointment values(1, 1000, 9000, 89745, '2021-12-05 14:00', '2021-12-05 15:00');
insert into appointment values(2, 1005, 9005, 89745, '2020-12-05 09:00', '2020-12-05 10:00');
insert into appointment values(3, 1010, 9010, 89745, '2020-08-08 08:00', '2021-08-08 09:00');
insert into appointment values(4, 1015, 9015, 89745, '2021-07-15 12:00', '2021-07-15 13:00');







