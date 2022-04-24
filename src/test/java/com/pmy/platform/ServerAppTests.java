package com.pmy.platform;

import com.pmy.platform.controller.CadreController;
import com.pmy.platform.controller.ClazzController;
import com.pmy.platform.controller.ClazzNoticeController;
import com.pmy.platform.controller.CommonController;
import com.pmy.platform.controller.ConfigController;
import com.pmy.platform.controller.CourseController;
import com.pmy.platform.controller.DiscussSchoolNoticeController;
import com.pmy.platform.controller.ParentController;
import com.pmy.platform.controller.SchoolNoticeController;
import com.pmy.platform.controller.ScoreController;
import com.pmy.platform.controller.ScoreRankController;
import com.pmy.platform.controller.StoreupController;
import com.pmy.platform.controller.StudentController;
import com.pmy.platform.controller.TeacherController;
import com.pmy.platform.controller.UserController;
import com.pmy.platform.entity.CadreEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class ServerAppTests {

  @Autowired
  private CadreController cadreController;
  @Autowired
  private ClazzController clazzController;
  @Autowired
  private ClazzNoticeController clazzNoticeController;
  @Autowired
  private CommonController commonController;
  @Autowired
  private ConfigController configController;
  @Autowired
  private CourseController courseController;
  @Autowired
  private DiscussSchoolNoticeController discussSchoolNoticeController;
  @Autowired
  private ParentController parentController;
  @Autowired
  private SchoolNoticeController schoolNoticeController;
  @Autowired
  private ScoreController scoreController;
  @Autowired
  private ScoreRankController scoreRankController;
  @Autowired
  private StoreupController storeupController;
  @Autowired
  private StudentController studentController;
  @Autowired
  private TeacherController teacherController;
  @Autowired
  private UserController userController;

  @Test
  void contextLoads() {

  }

}
