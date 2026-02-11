class Student:
    def __init__(self, name, grade, age):
        self.name = name
        self.grade = grade
        self.age = age

    def display(self):
        print("Student Name :", self.name)
        print("Grade   :", self.grade)
        print("Age :", self.age)


class School(Student):
    def __init__(self, name, grade, age, school_name):
        super().__init__(name, grade, age)
        self.school_name = school_name

    def SchoolStudentDisplay(self):
        print("===School Student Details===")
        print("School Name  :", self.school_name)
        print("Student Name :", self.name)
        print("Grade        :", self.grade)
        print("Age          :", self.age)

if __name__ == "__main__":
    s1 = Student("Pavan", "10th", 15)
    print("Using Student class display():")
    s1.display()
    print()

    st2 = School("Pavan", "9th", 14, "ZPHS High School")
    print("Using School class SchoolStudentDisplay():")
    st2. SchoolStudentDisplay()
