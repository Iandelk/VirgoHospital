create database Virgo_Database
go

use Virgo_Database

create table Blood_Type
(
IDBloodType int primary key identity,
Type nvarchar(6) not null
)
insert into Blood_Type(Type) values('none')
insert into Blood_Type(Type) values('A+')
insert into Blood_Type(Type) values('A-')
insert into Blood_Type(Type) values('B+')
insert into Blood_Type(Type) values('B-')
insert into Blood_Type(Type) values('AB+')
insert into Blood_Type(Type) values('AB-')
insert into Blood_Type(Type) values('0')

go



create table PaymentType
(
IDPaymentType int primary key identity,
Type nvarchar(50) not null
)

go

create table Bill
(
IDBill int primary key identity,
PaymentType int foreign key references PaymentType(IDPaymentType),
Total int not null,
Time datetime not null
)

go

create table Item
(
IDItem int primary key identity,
ItemName nvarchar(100) not null,
Price int not null,
BillID int foreign key references Bill(IDBill)
)

go

create table Specialization
(
IDSpecialization int primary key identity,
Type nvarchar(50) not null
)

go

create table Doctor
(
IDDoctor int primary key identity,
Name nvarchar(50) not null,
Surname nvarchar(50) not null,
SpecializationID int foreign key references Specialization(IDSpecialization),
DateAdded date
)
go


create table Patient
(
IDPatient int primary key identity,
OPID nvarchar(25),
Name nvarchar(50) not null,
MiddleName nvarchar(50),
Surname nvarchar(50) not null,
SexID int not null,
DateOfBirth date,
BriefStatementOfComplaint nvarchar(500),
PresentAddressStreet nvarchar(50),
PresentAddressDoorNo int default 0,
PresentAddressArea nvarchar(50),
PresentAddressCity nvarchar(50),
PresentAddressState nvarchar(50),
PresentAddressPincode nvarchar(50),
PermanentAddressStreet nvarchar(50),
PermanentAddressDoorNo int default 0,
PermanentAddressArea nvarchar(50),
PermanentAddressCity nvarchar(50),
PermanentAddressState nvarchar(50),
PermanentAddressPincode nvarchar(50),
MaritalStatus nvarchar(25),
NumberOfDependents int default 0,
Height int default 0,
Weight int default 0,
BloodType int foreign key references Blood_Type(IDBloodType) default 1,
Occupation nvarchar(50),
GrossAnnualIncome int,
Vegetarian bit default 0,
Smoker bit default 0,
AverageNumberOfCigarettesPerDay int,
ConsumeAlcoholicBeverage bit,
AverageNumberOfDrinksPerDay int,
Stimulants nvarchar(50),
ConsumptionOfCoffee_TeaPerDay int,
ConsumptionOfSoftDrinksPerDay int,
EatHome_OutsidePredominantly bit default 0,
HaveRegularMeals bit default 0,
StatementOfComplaint nvarchar (500),
HistoryOfPreviousTreatment nvarchar (200),
Physician_HospitalTreated nvarchar (100),
Diabetic bit default 0,
Hypertensive bit default 0,
CardiacCondition nvarchar (50),
RespiratoryCondition nvarchar(50),
DigestiveCondition nvarchar(50),
OrthopedicCondition nvarchar(50),
MuscularCondition nvarchar(50),
NeurologicalCondition nvarchar(50),
KnownAlergies nvarchar(50),
KnownAdverseReactionToSpecificDrugs nvarchar(100),
MajorSurgeriesHistory nvarchar (200),
DateAdded date,
DoctorId int foreign key references Doctor(IDDoctor),
)


create table NextOfKin
(
IDNextOfKin int primary key identity,
Name nvarchar(50) not null,
MiddleName nvarchar(50),
Surname nvarchar(50) not null,
RelationshipToOutpatient nvarchar(50),
AddressStreet nvarchar(50),
AddressDoorNo int default 0,
AddressArea nvarchar(50),
AddressCity nvarchar(50),
AddressState nvarchar(50),
AddressPincode nvarchar(50),
PatientID int foreign key references Patient(IDPatient)
)

create table Contact
(
IDContact int primary key identity,
Number nvarchar(25) not null,
PatientID int foreign key references Patient(IDPatient)
)

create table Contact_NextOfKin
(
IDContact int primary key identity,
Number nvarchar(25) not null,
NextOfKinID int foreign key references NextOfKin(IDNextOfKin)
)

create table Appointment
(
IDAppointment int primary key identity,
PatientID int foreign key references Patient(IDPatient) not null,
DoctorID int foreign key references Doctor(IDDoctor) not null,
AppointmentTime DateTime not null,
Diagnosis nvarchar(300),
Prescription nvarchar(100),
LabTests nvarchar(200),
Reference int foreign key references Doctor(IDDoctor),
FollowUp DateTime,
BillID int foreign key references Bill(IDBill),
Closed bit
)

