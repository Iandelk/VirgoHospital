USE [Virgo_Database]
GO
SET IDENTITY_INSERT [dbo].[PaymentType] ON 

INSERT [dbo].[PaymentType] ([IDPaymentType], [Type]) VALUES (1, N'Cash')
INSERT [dbo].[PaymentType] ([IDPaymentType], [Type]) VALUES (2, N'Credit Card')
SET IDENTITY_INSERT [dbo].[PaymentType] OFF
SET IDENTITY_INSERT [dbo].[Bill] ON 

INSERT [dbo].[Bill] ([IDBill], [PaymentType], [Total], [Time]) VALUES (1, NULL, 44, CAST(N'2019-06-06T15:21:20.357' AS DateTime))
INSERT [dbo].[Bill] ([IDBill], [PaymentType], [Total], [Time]) VALUES (2, NULL, 42, CAST(N'2019-06-06T15:25:03.957' AS DateTime))
SET IDENTITY_INSERT [dbo].[Bill] OFF
SET IDENTITY_INSERT [dbo].[Item] ON 

INSERT [dbo].[Item] ([IDItem], [ItemName], [Price], [BillID]) VALUES (1, N'Appointment Cost', 12, 1)
INSERT [dbo].[Item] ([IDItem], [ItemName], [Price], [BillID]) VALUES (2, N'Perscription Cost', 21, 1)
INSERT [dbo].[Item] ([IDItem], [ItemName], [Price], [BillID]) VALUES (3, N'Laboratory Test Cos', 11, 1)
INSERT [dbo].[Item] ([IDItem], [ItemName], [Price], [BillID]) VALUES (4, N'Appointment Cost', 11, 2)
INSERT [dbo].[Item] ([IDItem], [ItemName], [Price], [BillID]) VALUES (5, N'Perscription Cost', 21, 2)
INSERT [dbo].[Item] ([IDItem], [ItemName], [Price], [BillID]) VALUES (6, N'Laboratory Test Cos', 10, 2)
SET IDENTITY_INSERT [dbo].[Item] OFF
SET IDENTITY_INSERT [dbo].[Specialization] ON 

INSERT [dbo].[Specialization] ([IDSpecialization], [Type]) VALUES (1, N'General')
INSERT [dbo].[Specialization] ([IDSpecialization], [Type]) VALUES (2, N'Nurse')
INSERT [dbo].[Specialization] ([IDSpecialization], [Type]) VALUES (3, N'Allergist')
INSERT [dbo].[Specialization] ([IDSpecialization], [Type]) VALUES (4, N'Immunologist')
INSERT [dbo].[Specialization] ([IDSpecialization], [Type]) VALUES (5, N'Anesthesiologist')
INSERT [dbo].[Specialization] ([IDSpecialization], [Type]) VALUES (6, N'Surgeon')
INSERT [dbo].[Specialization] ([IDSpecialization], [Type]) VALUES (7, N'Cardiologist')
INSERT [dbo].[Specialization] ([IDSpecialization], [Type]) VALUES (8, N'Dermatologist')
INSERT [dbo].[Specialization] ([IDSpecialization], [Type]) VALUES (9, N'Neurologist')
INSERT [dbo].[Specialization] ([IDSpecialization], [Type]) VALUES (10, N'Gynecologist')
INSERT [dbo].[Specialization] ([IDSpecialization], [Type]) VALUES (11, N'Ophthalmologist')
INSERT [dbo].[Specialization] ([IDSpecialization], [Type]) VALUES (12, N'Rheumatologist')
INSERT [dbo].[Specialization] ([IDSpecialization], [Type]) VALUES (13, N'Urologist')
INSERT [dbo].[Specialization] ([IDSpecialization], [Type]) VALUES (14, N'Podiatrist')
INSERT [dbo].[Specialization] ([IDSpecialization], [Type]) VALUES (15, N'Pediatrician')
INSERT [dbo].[Specialization] ([IDSpecialization], [Type]) VALUES (16, N'Pathologist')
INSERT [dbo].[Specialization] ([IDSpecialization], [Type]) VALUES (17, N'Otolaryngologist')
SET IDENTITY_INSERT [dbo].[Specialization] OFF
SET IDENTITY_INSERT [dbo].[Doctor] ON 

INSERT [dbo].[Doctor] ([IDDoctor], [Name], [Surname], [SpecializationID], [DateAdded]) VALUES (1, N'Vladimir', N'Hrustoff', 1, NULL)
INSERT [dbo].[Doctor] ([IDDoctor], [Name], [Surname], [SpecializationID], [DateAdded]) VALUES (2, N'Mike', N'Morhaime', 1, NULL)
INSERT [dbo].[Doctor] ([IDDoctor], [Name], [Surname], [SpecializationID], [DateAdded]) VALUES (3, N'Joanne', N'Lakire', 3, NULL)
INSERT [dbo].[Doctor] ([IDDoctor], [Name], [Surname], [SpecializationID], [DateAdded]) VALUES (4, N'James', N'Hetfield', 17, NULL)
INSERT [dbo].[Doctor] ([IDDoctor], [Name], [Surname], [SpecializationID], [DateAdded]) VALUES (5, N'Miley', N'Cyrus', 16, NULL)
INSERT [dbo].[Doctor] ([IDDoctor], [Name], [Surname], [SpecializationID], [DateAdded]) VALUES (6, N'David', N'Draiman', 10, NULL)
INSERT [dbo].[Doctor] ([IDDoctor], [Name], [Surname], [SpecializationID], [DateAdded]) VALUES (7, N'Axl', N'Rose', 11, NULL)
INSERT [dbo].[Doctor] ([IDDoctor], [Name], [Surname], [SpecializationID], [DateAdded]) VALUES (8, N'Goran', N'Karan', 14, NULL)
INSERT [dbo].[Doctor] ([IDDoctor], [Name], [Surname], [SpecializationID], [DateAdded]) VALUES (9, N'Mike', N'Shinoda', 5, NULL)
INSERT [dbo].[Doctor] ([IDDoctor], [Name], [Surname], [SpecializationID], [DateAdded]) VALUES (10, N'Celine', N'Dion', 2, NULL)
INSERT [dbo].[Doctor] ([IDDoctor], [Name], [Surname], [SpecializationID], [DateAdded]) VALUES (11, N'Angelina', N'Jolie', 6, NULL)
INSERT [dbo].[Doctor] ([IDDoctor], [Name], [Surname], [SpecializationID], [DateAdded]) VALUES (12, N'Jessica', N'Alba', 4, NULL)
INSERT [dbo].[Doctor] ([IDDoctor], [Name], [Surname], [SpecializationID], [DateAdded]) VALUES (13, N'Blake', N'Lively', 15, NULL)
SET IDENTITY_INSERT [dbo].[Doctor] OFF
SET IDENTITY_INSERT [dbo].[Patient] ON 

INSERT [dbo].[Patient] ([IDPatient], [OPID], [Name], [MiddleName], [Surname], [SexID], [DateOfBirth], [BriefStatementOfComplaint], [PresentAddressStreet], [PresentAddressDoorNo], [PresentAddressArea], [PresentAddressCity], [PresentAddressState], [PresentAddressPincode], [PermanentAddressStreet], [PermanentAddressDoorNo], [PermanentAddressArea], [PermanentAddressCity], [PermanentAddressState], [PermanentAddressPincode], [MaritalStatus], [NumberOfDependents], [Height], [Weight], [BloodType], [Occupation], [GrossAnnualIncome], [Vegetarian], [Smoker], [AverageNumberOfCigarettesPerDay], [ConsumeAlcoholicBeverage], [AverageNumberOfDrinksPerDay], [Stimulants], [ConsumptionOfCoffee_TeaPerDay], [ConsumptionOfSoftDrinksPerDay], [EatHome_OutsidePredominantly], [HaveRegularMeals], [StatementOfComplaint], [HistoryOfPreviousTreatment], [Physician_HospitalTreated], [Diabetic], [Hypertensive], [CardiacCondition], [RespiratoryCondition], [DigestiveCondition], [OrthopedicCondition], [MuscularCondition], [NeurologicalCondition], [KnownAlergies], [KnownAdverseReactionToSpecificDrugs], [MajorSurgeriesHistory], [DateAdded], [DoctorId]) VALUES (4, N'123456789', N'Jane', N'Josie', N'Maxel', 2, CAST(N'1982-06-06' AS Date), NULL, N'4638  Gladwell Street', 4, N'Gladwell', N'Dallas', N'Texas', N'75202', N'379  Keyser Ridge Road', 22, N'Greens', N'Greensboro', N'North Carolina', N'27401', N'Married', 2, 172, 75, 4, N'Music Therapist', 100000, 1, 0, 0, 1, 1, N'none', 2, 3, 0, 1, N'Knee Pain', N'none', N'House MD', 1, 0, N'Good', N'Fine', N'Solid', N'Not bad', N'Weak', N'Crazy', N'none', N'no', N'spine surgery', CAST(N'2019-06-05' AS Date), 2)
INSERT [dbo].[Patient] ([IDPatient], [OPID], [Name], [MiddleName], [Surname], [SexID], [DateOfBirth], [BriefStatementOfComplaint], [PresentAddressStreet], [PresentAddressDoorNo], [PresentAddressArea], [PresentAddressCity], [PresentAddressState], [PresentAddressPincode], [PermanentAddressStreet], [PermanentAddressDoorNo], [PermanentAddressArea], [PermanentAddressCity], [PermanentAddressState], [PermanentAddressPincode], [MaritalStatus], [NumberOfDependents], [Height], [Weight], [BloodType], [Occupation], [GrossAnnualIncome], [Vegetarian], [Smoker], [AverageNumberOfCigarettesPerDay], [ConsumeAlcoholicBeverage], [AverageNumberOfDrinksPerDay], [Stimulants], [ConsumptionOfCoffee_TeaPerDay], [ConsumptionOfSoftDrinksPerDay], [EatHome_OutsidePredominantly], [HaveRegularMeals], [StatementOfComplaint], [HistoryOfPreviousTreatment], [Physician_HospitalTreated], [Diabetic], [Hypertensive], [CardiacCondition], [RespiratoryCondition], [DigestiveCondition], [OrthopedicCondition], [MuscularCondition], [NeurologicalCondition], [KnownAlergies], [KnownAdverseReactionToSpecificDrugs], [MajorSurgeriesHistory], [DateAdded], [DoctorId]) VALUES (5, N'1322316548', N'Jay', N'John', N'Fresno', 1, CAST(N'1968-09-19' AS Date), NULL, N'12 Meadowcrest Lane', 12, N'Downtown', N'Lexington', N'Kentucky', N'40507', N'1047 Jacobs Street', 11, N'Uptown', N'Gibsonia', N'Pennsylvania', N'15044', N'Not Married', 1, 177, 89, 7, N'Teacher', 50000, 0, 0, 0, 0, 0, N'none', 3, 0, 1, 1, N'Hip pain', N'none', N'House MD', 0, 0, N'good', N'good', N'good', N'good', N'good', N'good', N'none', N'none', N'none', CAST(N'2019-06-05' AS Date), 2)
INSERT [dbo].[Patient] ([IDPatient], [OPID], [Name], [MiddleName], [Surname], [SexID], [DateOfBirth], [BriefStatementOfComplaint], [PresentAddressStreet], [PresentAddressDoorNo], [PresentAddressArea], [PresentAddressCity], [PresentAddressState], [PresentAddressPincode], [PermanentAddressStreet], [PermanentAddressDoorNo], [PermanentAddressArea], [PermanentAddressCity], [PermanentAddressState], [PermanentAddressPincode], [MaritalStatus], [NumberOfDependents], [Height], [Weight], [BloodType], [Occupation], [GrossAnnualIncome], [Vegetarian], [Smoker], [AverageNumberOfCigarettesPerDay], [ConsumeAlcoholicBeverage], [AverageNumberOfDrinksPerDay], [Stimulants], [ConsumptionOfCoffee_TeaPerDay], [ConsumptionOfSoftDrinksPerDay], [EatHome_OutsidePredominantly], [HaveRegularMeals], [StatementOfComplaint], [HistoryOfPreviousTreatment], [Physician_HospitalTreated], [Diabetic], [Hypertensive], [CardiacCondition], [RespiratoryCondition], [DigestiveCondition], [OrthopedicCondition], [MuscularCondition], [NeurologicalCondition], [KnownAlergies], [KnownAdverseReactionToSpecificDrugs], [MajorSurgeriesHistory], [DateAdded], [DoctorId]) VALUES (6, N'123654789857', N'Alexander', N'James', N'Chrysler', 1, CAST(N'1987-07-14' AS Date), NULL, N'1242 Ventura Drive', 29, N'Cruz', N'Santa Cruz', N'California', N'95062', N'556 Valley Street', 11, N'Downtown', N'Pennsauken', N'New Jersey', N'08110', N'Not Married', 0, 198, 101, 3, N'Sherrif', 60000, 0, 1, 20, 0, 0, N'none', 5, 0, 0, 1, N'Fever', N'none', N'House MD', 0, 0, N'Good', N'Good', N'Good', N'Good', N'Good', N'Good', N'none', N'Penicillin', N'Knee Surgery', CAST(N'2019-06-05' AS Date), 2)
SET IDENTITY_INSERT [dbo].[Patient] OFF
SET IDENTITY_INSERT [dbo].[Appointment] ON 

INSERT [dbo].[Appointment] ([IDAppointment], [PatientID], [DoctorID], [AppointmentTime], [Diagnosis], [Prescription], [LabTests], [Reference], [FollowUp], [BillID], [Closed]) VALUES (1, 4, 2, CAST(N'2019-06-30T18:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Appointment] ([IDAppointment], [PatientID], [DoctorID], [AppointmentTime], [Diagnosis], [Prescription], [LabTests], [Reference], [FollowUp], [BillID], [Closed]) VALUES (2, 6, 1, CAST(N'2019-09-13T14:00:00.000' AS DateTime), N'Pneumonia', N'penicilin', N'blood', 3, CAST(N'2019-06-14T15:20:00.000' AS DateTime), 1, 1)
INSERT [dbo].[Appointment] ([IDAppointment], [PatientID], [DoctorID], [AppointmentTime], [Diagnosis], [Prescription], [LabTests], [Reference], [FollowUp], [BillID], [Closed]) VALUES (3, 5, 2, CAST(N'2019-06-20T23:43:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Appointment] ([IDAppointment], [PatientID], [DoctorID], [AppointmentTime], [Diagnosis], [Prescription], [LabTests], [Reference], [FollowUp], [BillID], [Closed]) VALUES (7, 6, 2, CAST(N'2019-06-30T18:30:00.000' AS DateTime), N'Flu', N'Sumamed', N'stool sample', NULL, NULL, 2, 1)
INSERT [dbo].[Appointment] ([IDAppointment], [PatientID], [DoctorID], [AppointmentTime], [Diagnosis], [Prescription], [LabTests], [Reference], [FollowUp], [BillID], [Closed]) VALUES (8, 6, 2, CAST(N'2019-06-30T17:30:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Appointment] ([IDAppointment], [PatientID], [DoctorID], [AppointmentTime], [Diagnosis], [Prescription], [LabTests], [Reference], [FollowUp], [BillID], [Closed]) VALUES (9, 6, 3, CAST(N'2019-06-14T15:20:00.000' AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL, 0)
SET IDENTITY_INSERT [dbo].[Appointment] OFF
SET IDENTITY_INSERT [dbo].[NextOfKin] ON 

INSERT [dbo].[NextOfKin] ([IDNextOfKin], [Name], [MiddleName], [Surname], [RelationshipToOutpatient], [AddressStreet], [AddressDoorNo], [AddressArea], [AddressCity], [AddressState], [AddressPincode], [PatientID]) VALUES (3, N'Dennis', N'Dane', N'Maxel', N'Husband', N'2566  Winifred Way', 12, N'South Marion', N'Marion', N'Indiana', N'46953', 4)
INSERT [dbo].[NextOfKin] ([IDNextOfKin], [Name], [MiddleName], [Surname], [RelationshipToOutpatient], [AddressStreet], [AddressDoorNo], [AddressArea], [AddressCity], [AddressState], [AddressPincode], [PatientID]) VALUES (4, N'Marianne', N'Leia', N'Fresno', N'Daughter', N'1047 Jacobs Street', 11, N'Uptown', N'Gibsonia', N'Pennsylvania', N'15044', 5)
INSERT [dbo].[NextOfKin] ([IDNextOfKin], [Name], [MiddleName], [Surname], [RelationshipToOutpatient], [AddressStreet], [AddressDoorNo], [AddressArea], [AddressCity], [AddressState], [AddressPincode], [PatientID]) VALUES (5, N'Mary', N'Jocelyn', N'Camacho', N'Friend', N'520 Heavner Avenue', 142, N'Uptown State', N'Atlanta', N'Georgia', N'30329', 6)
SET IDENTITY_INSERT [dbo].[NextOfKin] OFF
SET IDENTITY_INSERT [dbo].[Contact] ON 

INSERT [dbo].[Contact] ([IDContact], [Number], [PatientID]) VALUES (13, N'56745674567', 4)
INSERT [dbo].[Contact] ([IDContact], [Number], [PatientID]) VALUES (14, N'mail mail ', 4)
INSERT [dbo].[Contact] ([IDContact], [Number], [PatientID]) VALUES (15, N'jjFresno@mail.com', 5)
INSERT [dbo].[Contact] ([IDContact], [Number], [PatientID]) VALUES (16, N'339988547', 5)
INSERT [dbo].[Contact] ([IDContact], [Number], [PatientID]) VALUES (17, N'Chrysler@gmail.com', 6)
INSERT [dbo].[Contact] ([IDContact], [Number], [PatientID]) VALUES (18, N'0021254875869', 6)
SET IDENTITY_INSERT [dbo].[Contact] OFF
SET IDENTITY_INSERT [dbo].[Contact_NextOfKin] ON 

INSERT [dbo].[Contact_NextOfKin] ([IDContact], [Number], [NextOfKinID]) VALUES (6, N'jHusband@mail.com', 3)
INSERT [dbo].[Contact_NextOfKin] ([IDContact], [Number], [NextOfKinID]) VALUES (7, N'4523452345345', 3)
INSERT [dbo].[Contact_NextOfKin] ([IDContact], [Number], [NextOfKinID]) VALUES (8, N'546474567456', 3)
INSERT [dbo].[Contact_NextOfKin] ([IDContact], [Number], [NextOfKinID]) VALUES (9, N'54674567547', 3)
INSERT [dbo].[Contact_NextOfKin] ([IDContact], [Number], [NextOfKinID]) VALUES (10, N'CamJ@gmail.com', 5)
INSERT [dbo].[Contact_NextOfKin] ([IDContact], [Number], [NextOfKinID]) VALUES (11, N'02121549876', 5)
SET IDENTITY_INSERT [dbo].[Contact_NextOfKin] OFF
