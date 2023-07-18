package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

/**
 * 완전 실무 스프링MVC 방식
 * 1. Model 파라미터
 *    : save() , members() 를 보면 Model을 파라미터로 받는 것을 확인할 수 있다. 스프링 MVC도 이런 편의 기능을 제공한다.
 * 2. @RequestMapping -> @GetMapping, @PostMapping
 *    : @RequestMapping 은 URL만 매칭하는 것이 아니라, HTTP Method도 함께 구분할 수 있다.
 *      예를 들어서 URL이 /new-form 이고, HTTP Method가 GET인 경우를 모두 만족하는 매핑을 하려면 다음과 같이 처리하면 된다.
 * 3. @RequestParam 사용
 *    : 스프링은 HTTP 요청 파라미터를 @RequestParam 으로 받을 수 있다.
 *      즉, @RequestParam("username") 은 request.getParameter("username") 와 거의 같은 코드라 생각하면 된다.
 */
@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    // 1단계 : @RequestMapping("/new-form")
    // 2단계 : @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    // 3딘계
    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

    // @RequestMapping("/save")
    // @RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping("/save")
    public String save(@RequestParam("username") String username,
                             @RequestParam("age") int age,
                             Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member);
        model.addAttribute("member", member);
        return "save-result";
    }

    //@RequestMapping
    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }
}
