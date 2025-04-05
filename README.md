# SCSE Student Project
_A project repository for student submissions and collaboration._


## 📁 Project Structure
- `src/` – Source code files
- `README.md` – Project overview and instructions
- `.gitignore` – Git ignored files config

## 🚀 Tech Stack

- Java (Spring Boot)
- SQL

## 🤝Contribution Guidelines

- Dr. Satish Kumar.
- Dr. Duncan Mullier.

## 📌 Notes

- Used Week 10 Student Repo to save initial development effoets.

# User Story: Student Course Enrollment & Graduation Eligibility

## Title: Enroll in Courses and Check Graduation Eligibility


### As a registered student,
- I want to enroll in courses and check my graduation eligibility,
- So that I can manage my academic progress and ensure I meet graduation requirements.

### Acceptance Criteria:
Course Enrollment:
- If it’s my first enrollment, the system should automatically create a student account in the Student Portal.

- Upon successful enrollment in a course, the system sends a request to the Finance microservice, generating an invoice for the student.

I can view a list of all my enrolled courses in a dedicated "My Enrollments" section of the portal.

### Graduation Eligibility Check:
- The system checks for any outstanding invoices via the Finance microservice.

- If there are no unpaid invoices, I am marked as eligible for graduation.

- If there are unpaid invoices, I will receive a notification listing the outstanding invoices.

### Integration Requirements:
- Student Creation triggers account creation in both Finance and Library microservices.

- Late book returns (managed by the Library microservice) generate fines, which are then invoiced through the Finance microservice.

Priority: High
Estimate: 5 Story Points

### Notes:
This user story ensures seamless integration between the Student Portal, Finance, and Library microservices.

Error handling must be in place for failed API calls (e.g., if the Finance or Library service is down).
