# These statements create the tables with required restraints in the las palmas medical center database
create table Physician
	(physicianID	integer,
    name			varchar(40),
    position		varchar(40)
		check (position in ('Intern', 'Surgeon', 'Senior', 'Chief of Medicine', 'Resident', 'Psychiatrist')),
    ssn				integer,
    primary key(physicianID)
    );
create table Department
	(deptID			integer,
    name			varchar(40) 
		check (name in ('General Medicine', 'Surgery', 'Psychiatry')),
    headID			integer,
    primary key(deptID),
    foreign key(headID) references Physician(physicianID)
        on delete set null
    );
create table AffiliatedWith
	(physicianID	integer,
    departmentID	integer,
    primary key(physicianID, departmentID),
    foreign key(physicianID) references Physician(physicianID)
        on delete cascade,
    foreign key(departmentID) references Department(deptID)
        on delete cascade
    );
create table `Procedure`
	(procID			integer,
    name			varchar(40),
    cost			real,
    primary key(procID)
    );
create table Patient
	(patientID		integer,
    ssn				integer,
    name			varchar(40),
    address			varchar(100),
    dob				date,
    phone			varchar(16),
    insuranceNumber	integer,
    primaryPhysID	integer,
    primary key(patientID),
    foreign key(primaryPhysID) references Physician(physicianID)
        on delete set null
    );
create table Nurse
	(nurseID		integer,
    name			varchar(40),
    position		varchar(40)
		check (position in ('Head Nurse', 'Nurse')),
    ssn				integer,
    primary key(nurseID)
    );
create table Medication
	(medID			integer,
    name			varchar(40),
    primary key(medID)
    );
create table Prescribes
	(physicianID	integer,
    patientID		integer,
    medicationID	integer,
    prescribedDate	date,
    dose			varchar(40),
    primary key(prescribedDate, patientID, medicationID, prescribedDate),
    foreign key(physicianID) references Physician(physicianID)
        on delete cascade,
    foreign key(patientID) references Patient(patientID)
		on delete cascade,
    foreign key(medicationID) references Medication(medID)
        on delete cascade
    );
create table Room
	(roomID			integer,
    roomType		varchar(40)
		check (roomType in ('Single', 'Double')),
    primary key(roomID)
    );
create table Stay
	(stayID			integer,
    patientID		integer,
    roomID			integer,
    startDate		date,
    endDate			date,
    primary key(stayID),
    foreign key(patientID) references Patient(patientID)
        on delete cascade,
    foreign key(roomID) references Room(roomID)
        on delete cascade
    );
create table Undergoes
	(patientID		integer,
    procedureID		integer,
    stayID			integer,
    procDate		date,
    physicianID		integer,
    nurseID			integer,
	primary key(patientID, procedureID, stayID, procDate),
    foreign key(patientID) references Patient(patientID)
        on delete cascade,
    foreign key(procedureID) references `Procedure`(procID)
        on delete cascade,
    foreign key(stayID) references Stay(stayID)
        on delete set null,
    foreign key(physicianID) references Physician(physicianID)
        on delete set null,
    foreign key(nurseID) references Nurse(nurseID)
        on delete set null
    );
create table OnCall
	(nurseID		integer,
    startDate		date,
    endDate			date,
    primary key(nurseID, startDate, endDate),
    foreign key(nurseID) references Nurse(nurseID)
        on delete cascade
    );
create table Appointment
	(appID			integer,
    patientID		integer,
    nurseID			integer,
    physicianID		integer,
    startDateTime	datetime,
    endDateTime		datetime,
    primary key(appID),
    foreign key(patientID) references Patient(patientID)
        on delete cascade,
    foreign key(nurseID) references Nurse(nurseID)
        on delete set null,
    foreign key(physicianID) references Physician(physicianID)
        on delete set null
    );
    
    
    