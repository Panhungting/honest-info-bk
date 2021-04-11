package jp.co.honest.controller.top;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.honest.domain.Bulletin;
import jp.co.honest.domain.Employee;
import jp.co.honest.service.TopService;

@Controller 
@RequestMapping("/top")
public class TopController {

    @Autowired
    private TopService topService;

    // top入り口
    @GetMapping({ "/", "/index" })
    public String bulletinListView(@ModelAttribute("employee") Employee employee, Model model) {

        // DBから一覧検索
        List<Bulletin> bulletinList = topService.getBulletinList();

        // テンプレートに渡す値を設定
        model.addAttribute("bulletinList", bulletinList);
        model.addAttribute("count", bulletinList.size());

        // TODO session update
        if (employee != null) {

            model.addAttribute("employeeName", employee.getEmployeeName());
            model.addAttribute("loginId", employee.getLoginId());
        }

        return "top/index";
    }

        // top戻る入り口
        @GetMapping({ "/", "/back","/back/{loginId}/{employeeName}" })
        public String bulletinListView(@PathVariable String loginId,@PathVariable String employeeName, Model model) {
    
            // DBから一覧検索
            List<Bulletin> bulletinList = topService.getBulletinList();
    
            // テンプレートに渡す値を設定
            model.addAttribute("bulletinList", bulletinList);
            model.addAttribute("count", bulletinList.size());
    
            // 値を設定
            if (loginId != null || employeeName != null) {

                model.addAttribute("employeeName", employeeName);
                model.addAttribute("loginId", loginId);
            }
        
            return "top/index";
        }
}