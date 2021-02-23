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
 student_exam_id：考生考试序号,自增,主键  
 student_exam_exam_id：考生参加的考试的考试序号  
 student_exam_student_id：考生学号  
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
 
