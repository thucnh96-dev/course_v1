package com.project.controller.API;

import com.project.validator.UserValidator;
import com.project.constants.UrlConstants;
import com.project.controller.AbtractController;
import com.project.entity.Role;
import com.project.entity.User;
import com.project.entity.enums.Roles;
import com.project.form.UserFormRegister;
import com.project.response.APIResponse;
import com.project.security.SecurityService;
import com.project.service.RoleService;
import com.project.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = UrlConstants.URI_API)
@Api(value = "APIUserController", description = "API User Controller")
public class APIUserController extends AbtractController {

    @Autowired
    private UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleService roleService;


    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @PostMapping(value = UrlConstants.URI_USER)
    @ApiOperation(value = "Create User Question", response = Object.class)
    ResponseEntity<APIResponse> createUser(@RequestBody UserFormRegister userFormRegister){

        userValidator.validate(userFormRegister);
        User user = new User();
        user.setUserName(userFormRegister.getUserName());
        user.setPassWord(bCryptPasswordEncoder.encode(userFormRegister.getPassWord()));
        user.setPhone(userFormRegister.getPhone());
        Role role = roleService.findByName(Roles.USER.toString());
        user.addRole(role);
        userService.save(user);
        securityService.autologin(user.getUserName(), userFormRegister.getPassWord());
        Map data = new HashMap();
        data.put("userName",user.getUserName());
        data.put("password",userFormRegister.getPassWord());
        data.put("phone",user.getPhone());
        return responseUtil.successResponse(data);

    }
}
