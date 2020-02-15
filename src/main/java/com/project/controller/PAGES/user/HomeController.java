package com.project.controller.PAGES.user;

import com.project.constants.UrlConstants;
import com.project.controller.AbtractController;
import com.project.entity.User;
import com.project.entity.UserExam;
import com.project.service.ExamService;
import com.project.service.UserExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value= UrlConstants.URI_HOME)
public class HomeController extends AbtractController {

    @Autowired
    private ExamService examService;

    @Autowired
    private UserExamService userExamService;


    @GetMapping(value="")
    public String  home(Model model, Principal principal){

        User currentUser = this.realUser(principal);
        List<UserExam>  uexams  = userExamService.findAllByUserAndExamIsNotNullAndDeleteAtIsNull(currentUser);
        model.addAttribute("userExams",uexams);

        return "";
    }


}
