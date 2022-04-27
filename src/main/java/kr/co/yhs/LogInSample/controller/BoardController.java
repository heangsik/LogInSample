package kr.co.yhs.LogInSample.controller;

import kr.co.yhs.LogInSample.domain.Board;
import kr.co.yhs.LogInSample.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    public void registerForm(Board board, Model model) throws Exception{

    }
}
