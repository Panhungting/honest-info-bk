package jp.co.honest.controller.employee;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.honest.domain.Employee;
import jp.co.honest.service.EmployeeService;

@Controller // コントローラクラス
@RequestMapping("/employee") // コントローラクラス全体のURL
public class EmployeeController {

    // TODO
    @Autowired
    private EmployeeService employeeService;

    // GETリクエストがきたら、このメソッドが実行される
    // @GetMapping({"/", "/list","/list/{loginId}/{employeeName}"}) // メソッドのURL
    // public String index(@PathVariable String loginId,@PathVariable String employeeName,Model model) {
    @GetMapping({"/", "/list"}) // メソッドのURL
    public String index(Model model) {

        // DBから一覧検索
        List<Employee> employeeList = employeeService.getEmployeeList();

        // リポッジストリからフォームに変換
        List<EmployeeForm> employeeFormList = employeeList
            .stream().map(e -> EmployeeForm.builder()
                .employeeId(e.getEmployeeId())
                .employeeName(e.getEmployeeName())
                .gender(e.getGender()).build()
            ).collect(Collectors.toList());

        // DBからスキル検索
        // employeeFormList = employeeService.getEmployeeSkills(employeeFormList);


        // テンプレートに渡す値を設定
        model.addAttribute("employeeFormList", employeeFormList);
        // model.addAttribute("loginId", loginId);
        // model.addAttribute("employeeName", employeeName);

        // テンプレート名パス（拡張子なし）
        return "employee/list_up";
    }

    // TODO
    // // GETリクエストがきたら、このメソッドが実行される
    // @GetMapping("/add")
    // public String add(@ModelAttribute DemoForm form, Model model) {
    // // テンプレート名パス（拡張子なし）
    // return "demo/add";
    // }

    // TODO
    // // GETリクエストがきたら、このメソッドが実行される
    // @GetMapping("/update")
    // public String add(@ModelAttribute DemoForm form, Model model) {
    // // テンプレート名パス（拡張子なし）
    // return "demo/add";
    // }

    // TODO
    // // POSTリクエストがきたら、このメソッドが実行される
    // @PostMapping("/delete")
    // public String delete(@ModelAttribute DemoForm form, Model model) {
    // return "demo/list";
    // }

}