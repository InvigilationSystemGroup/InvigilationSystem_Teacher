# InvigilationSystem_Teacher
### 在线考试防作弊系统教师端  
## 1.数据库设计    
 - student表：学生基本信息表  
 student_id：学生学号,主键  
 student_password：学生密码  
 student_name：学生姓名  
 student_faculty:学生学院  
 student_major：学生专业  
    
 - teacher表：教师基本信息表  
 teacher_id：教师工号,主键  
 teacher_password：教师密码  
 teacher_name：教师姓名  
 teacher_faculty：教师学院  
 teacher_major：教师专业  

 - admin表：管理员基本信息表  
 admin_id：管理员账号,主键  
 admin_name：管理员名称  
 admin_password：管理员密码
    
 - exam表：考试信息表  
 exam_id：考试序号,自增,主键  
 exam_name：考试科目  
 exam_starttime：考试开始时间  
 exam_endtime：考试结束时间   
 exam_room：考场名称  
 exam_capacity：考场容量  
 exam_ipwhite：ip白名单,教师端传 学生端取  
 exam_ipblack：ip黑名单,教师端传 学生端取  

 - student_exam表：学生考试表   
 student_exam_exam_id：考生参加的考试的考试序号,联合主键1  
 student_exam_student_id：考生学号,联合主键2  
 student_exam_seat：考生考试座位号  
 student_exam_cheat_brief：考生作弊简述及登录状态（默认为null）,学生端传 教师端取  
 student_exam_cheat_detail：考生作弊详情（默认为null）,学生端传操作日志 教师端取  
 student_exam_unlock：解锁密码,教师端传 学生端取  
 
 - teacher_exam表：教师监考表  
 teacher_exam_exam_id：教师监考的考试的考试序号,联合主键1  
 teacher_exam_teacher_id：教工号,联合主键2  
 
 - cheat表：作弊信息记录表  
 cheat_id：作弊信息记录序号,自增,主键  
 cheat_student_id：作弊考生学号  
 cheat_brief：作弊简述  
 cheat_detail：作弊详情  
 cheat_exam_id：作弊考试序号
 
 - warning表：警告信息记录表  
 
 ##2.教师端后端接口
 ####（包含基本操作，待补充）
 ###2.1学生、教师、考试的增删改查：
 
 + ####对教师的增删改查  
 
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/teacher/login?username=10000001&password=123456  
 教师登录
 
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/teacher/logout  
 教师退出
 
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/teacher/findByCondition?name=&faculty=&major=&id=  
 条件查询教师
 
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/teacher/update?id=10000002&password=111111&name&faculty=国际教育学院&major  
 根据教工号更新教师个人信息（id不能为空）
 
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/teacher/add?id=10000009&password=1111111&name=李师&faculty=国际教育学院&major=计算机科学与技术  
 添加教师个人信息（各项均不为空）
 
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/teacher/deleteOne?id=10000009  
 删除教师
 
 _http://localhost:8080/InvigilationSystem_Teacher_war_exploded/teacher/findAllTeachersWithExam  
 查询所有有监考任务的监考教师及其监考任务_
 
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/teacher/findTeachersByExamId?exam_id=1  
 查询所选考试的监考教师
 
 _http://localhost:8080/InvigilationSystem_Teacher_war_exploded/teacher/addForExam?teacher_id=10000001&exam_id=2  
 为某考试添加监考教师_
 
 _http://localhost:8080/InvigilationSystem_Teacher_war_exploded/teacher/deleteOneForExam?teacher_id=10000001&exam_id=2  
 为某考试删除监考教师_
 
 
 + ####对学生的增删改查
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/student/login?username=1812030001&password=123456  
 学生登录
 
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/student/logout  
 学生退出
 
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/student/findByCondition?name=&faculty=&major=&id=  
 条件查询学生
 
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/student/update?id=1812030001&password=111111&name&faculty=国际教育学院&major  
 根据学号更新学生个人信息（id不能为空）
 
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/student/add?id=1812030010&password=123456&name=张六&faculty=国际教育学院&major=计算机科学与技术  
 添加学生个人信息（各项均不为空）
 
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/student/deleteOne?id=1812030010  
 删除学生
 
 _http://localhost:8080/InvigilationSystem_Teacher_war_exploded/student/findAllStudentsWithExam  
 查询所有有考试的学生及其参加的考试_
 
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/student/findStudentsByExamId?exam_id=1  
 查询所选考试的考生
 
 _http://localhost:8080/InvigilationSystem_Teacher_war_exploded/student/addForExam?student_id=1812030001&exam_id=8  
 为某考试添加考生
 
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/student/deleteOneForExam?student_id=1812030001&exam_id=8  
 为某考试删除考生_
 
 + ####对考试的增删改查
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/exam/findExamsByStudentId?student_id=1812030001  
 查询某考生参加的考试
 
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/exam/findExamsByTeacherId?teacher_id=10000001  
 查询某教师监考的考试
 
 为某学生/教师添加/删除考试；查询所有有监考教师/考生的考试及其监考教师/考生。
 方法同上述*斜体*方法
 
 + ####对管理员
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/admin/login?username=1001&password=admin  
 登录
 
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/admin/logout  
 管理员退出
 
 http://localhost:8080/InvigilationSystem_Teacher_war_exploded/admin/update?id=1001&password=111111&name  
 根据id更新个人信息（id不能为空）

 
