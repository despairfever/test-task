package com.veritas.testtask.web;

import com.veritas.testtask.beans.Text;
import org.kefirsf.bb.BBProcessorFactory;
import org.kefirsf.bb.TextProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    private TextProcessor processor = BBProcessorFactory.getInstance().create();

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("text", new Text());
        return "task1";
    }

    @PostMapping("/")
    public String processForm(@ModelAttribute Text text) {
        text.setValue(processor.process(text.getValue()));
        return "task1results";
    }

}
