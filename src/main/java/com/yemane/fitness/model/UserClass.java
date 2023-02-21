package com.yemane.fitness.model;

public class UserClass {

	private String email;
	 
	    private Long classId;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Long getClassId() {
			return classId;
		}

		public void setClassId(Long classId) {
			this.classId = classId;
		}

		public UserClass(String email, Long classId) {
			super();
			this.email = email;
			this.classId = classId;
		}
		
	    
	    

	}
	

