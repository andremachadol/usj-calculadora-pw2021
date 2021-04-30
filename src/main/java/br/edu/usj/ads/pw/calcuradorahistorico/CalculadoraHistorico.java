package br.edu.usj.ads.pw.calcuradorahistorico;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class CalculadoraHistorico {
    
    List<String> historico = new ArrayList<>();
   
    @PostMapping(value="calcular")
     public ModelAndView postCalcular(@RequestParam String operando1,@RequestParam String operando2, @RequestParam String operador ) {
     //converter para double
     Double operando1Double= Double.valueOf(operando1);
     Double operando2Double= Double.valueOf(operando2);
     // operar
     //verificar qual operação é
     Double resultado = null;
     if ("+".equals(operador)){
         resultado = operando1Double + operando2Double;

     } 

     //formatar a opercao no historico
     String operacao = operando1 + " " + operador + " " + operando2 + " = " + resultado;

     //Salvar operação no histórico
     historico.add(operacao);


     // instanciar template
    
     ModelAndView modelAndView = new ModelAndView("index");
     // aplicar resultado da operação no template
     //aplicar o histórico no template
     modelAndView.addObject("resultado", resultado);
     modelAndView.addObject("historico", historico);
     // retornar
     
        return modelAndView ;
  }
        
    }
    

