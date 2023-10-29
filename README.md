# cvmaker
The aim of this application is to provide a plattform where a user can sign up adding personal
information and with that create a CV.

TODO:

-- Currently  working on skills 	
	- do unit tests missing
	- do create userdataSkill Controller.
		- userdataSkill Controller cannot work properly due to issues with UserdataSkill(Entity) logic -- See TODO

1. New table "summary" created in database
	- Create required classes BE
2. New table "work_experience" created in database
	- Create required classes BE
3. New table "studies" created in database
	- Create required classes BE
4. Create a package for CV object which will include all the info for a user

INFO

Skill and UserdataSkill are different concepts.
	1- Skill contains a String name, and a Long id. We can add new skills whenever we want.
	2- UserdataSkill contains a Long id, Long userdataId, and a List<Skill> with all the skills the user has