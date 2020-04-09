/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizut.tpsi.springlab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorController {
    @RequestMapping("/wynikdodawania")
    public String add(Model model, int x, int y) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        model.addAttribute("wynik", x + y);

        return "wynikdodawania";
    }
    
    @RequestMapping("/wynikzad2")
    public String calc(Model model, int x, int y, String operacja) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        model.addAttribute("operacja", operacja);
        model.addAttribute("wynik", calculateEquation(x, y, operacja));
        
        return "wynik";
    }
    
        
    @RequestMapping("/wynikzad3")
    public String calc(Model model, CalculatorForm calculator) {
        int x = calculator.getX();
        int y = calculator.getY();
        String operacja = calculator.getOperacja();
        
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        model.addAttribute("operacja", operacja);
        model.addAttribute("wynik", calculateEquation(x, y, operacja));
        
        return "wynik";
    }
    
    private int calculateEquation(int x, int y, String operacja) {
        switch (operacja) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            default:    
                return 0;
        }
    }
}