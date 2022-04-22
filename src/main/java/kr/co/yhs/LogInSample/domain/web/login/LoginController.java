package kr.co.yhs.LogInSample.domain.web.login;

import kr.co.yhs.LogInSample.domain.login.LoginService;
import kr.co.yhs.LogInSample.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@AllArgsConstructor
@RequestMapping
@Controller
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String LoginForm(@ModelAttribute LoginForm loginForm) {
        log.info("get login");
        return "login/loginForm";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute @Valid LoginForm loginForm, BindingResult bindingResult, @RequestParam(defaultValue = "/") String redirctUrl) {
        if(bindingResult.hasErrors()){
            return "login/loginForm";
        }
        Member member = loginService.login(loginForm.getLoginId(), loginForm.getPassword());

        if (null == member) {
            bindingResult.reject("loginFail", "id 또는 password가 맞지 않습니다.");
            return "login/loginForm";
        }

        return "redirect:" + redirctUrl;
    }
}
