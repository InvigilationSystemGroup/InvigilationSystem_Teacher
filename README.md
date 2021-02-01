# InvigilationSystem_Teacher
### 在线考试防作弊系统教师端  
## 1.数据库设计    
 - student表：学生基本信息表  
 student_id：学生学号，主键  
 student_name：学生姓名  
 student_major：学生专业  
    
 - teacher表：教师基本信息表  
 teacher_id：教师工号，主键  
 teacher_name：教师姓名  
 teacher_major：教师专业
    
 - exam表：考试信息表  
 exam_id：考试id,自增,主键  
 exam_name：考试科目  
 exam_starttime：考试开始时间  
 exam_endtime：考试结束时间   
 exam_room：考场名称

 - student_exam表：学生考试表（多对多）  
 student_exam_id：考生考试id,自增,主键  
 student_exam_exam_id：考生参加的考试序号  
 student_exam_student_id：考生学号  
 student_exam_cheat_brief：考生作弊简述（默认为null）  
 student_exam_cheat_detail：考生作弊详情（默认为null）
 
 - cheat表：作弊信息记录表  
 cheat_id：作弊信息记录id，自增,主键  
 cheat_student_id：作弊考生学号  
 cheat_brief：作弊简述  
 cheat_detail：作弊详情  
 cheat_room_id：作弊考试id
