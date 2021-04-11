package jp.co.honest.controller.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.honest.domain.Employee;
import jp.co.honest.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    // ログイン画面
    @GetMapping({ "/", "/index" })
    public String index(@ModelAttribute LoginForm loginForm, Model model) {
        return "login/index";
    }

    // ログインチェックが実行される
    @PostMapping({ "/check" })
    public String check(@ModelAttribute LoginForm loginForm, RedirectAttributes redirectAttributes, Model model) {

        // ユーザー存在確認
        Optional<Employee> otpEmployee = loginService.getLoginUser(loginForm.getLoginId(), loginForm.getPassword());

        if (otpEmployee.isPresent()) {
            
            Employee employee = otpEmployee.get();
            redirectAttributes.addFlashAttribute("employee", employee);
        } else {

            // TODO 詳しいエラーメッセージを表示ユーザがない或いはPW間違い
            model.addAttribute("msg", "ログインできません");
            return "login/index";
        }

        // TODO employeeを次の画面に渡したい場合、どうしますか？
        return "redirect:/top/index";
    }

        
    // GETリクエストがきたら、このメソッドが実行される
    @ResponseBody
    @GetMapping({"/empty/check/loginId"}) // メソッドのURL
    public int indexCheLoginId(
        @RequestParam("loginId") String loginIdTest,
        @RequestParam String password) {
        
        // DBからユーザー存在確認
        int count = loginService.getEmployeeIsExist(loginIdTest);

        // コンソールで確認
        System.out.println("getLoginId:"+loginIdTest);
        System.out.println("getPassword:"+password);

        // コンソールでフロントエンドから値を渡す
        return count;
    }

    // 参照のため、PSOT作成した
    // POSTリクエストがきたら、このメソッドが実行される
    @ResponseBody
    @PostMapping({"/empty/check/password"}) // メソッドのURL
    public int indexCheck2(@RequestBody LoginForm loginForm) {

        // DBからユーザー存在確認
        int count = loginService.getEmployeeIsExist(loginForm.getLoginId());
        
        // コンソールで確認
        System.out.println("getLoginId:"+loginForm.getLoginId());
        System.out.println("getPassword:"+loginForm.getPassword());

        // コンソールでフロントエンドから値を渡す
        return count;
    }
}