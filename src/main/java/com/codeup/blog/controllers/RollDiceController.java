package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RollDiceController {

    static Integer dice;

    @GetMapping("/roll-dice")
    @ResponseBody
    public String showDice() {
        return "What is your guess?<br/><ul>" +
                "<li><a href='/roll-dice/1'>1</a></li>" +
                "<li><a href='/roll-dice/2'>2</a></li>" +
                "<li><a href='/roll-dice/3'>3</a></li>" +
                "<li><a href='/roll-dice/4'>4</a></li>" +
                "<li><a href='/roll-dice/5'>5</a></li>" +
                "<li><a href='/roll-dice/6'>6</a></li>" +
                "</ul>";
    }

    @GetMapping("/roll-dice/{n}")
    @ResponseBody
    public String checkGuess(@PathVariable Integer n) {
        Integer diceRoll = new Random().nextInt(6) + 1;
        String response = "<h2>The number rolled was " + diceRoll.toString() + "</h2>";
        if (n == diceRoll)
            response += "<h2>You got it!</h2>";
        else
            response += "<h2>Sorry, you missed.</h2>";
        response += "<a href='/roll-dice'>Try again</a>";
        return response;
    }

}
