package br.com.casacodigo.loja.controllers;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casacodigo.loja.models.CarrinhoCompras;
import br.com.casacodigo.loja.models.DadosPagamento;
import br.com.casacodigo.loja.models.TipoPreco;

@RequestMapping("/pagamento")
@Controller
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class PagamentoController {

    @Autowired
    CarrinhoCompras carrinho;
    @Autowired
    RestTemplate restTemplate;
    
    @RequestMapping(value="/finalizar", method=RequestMethod.POST)
    public Callable<ModelAndView> finalizar(RedirectAttributes model){
        return () -> {
            try {
                String uri = "http://book-payment.herokuapp.com/payment";
                String response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()), String.class);
                model.addFlashAttribute("message", response);
                System.out.println(response);
                return new ModelAndView("redirect:/produtos");
            } catch (HttpClientErrorException e) {
                e.printStackTrace();
                model.addFlashAttribute("message", "Valor maior que o permitido");
                return new ModelAndView("redirect:/produtos");
            }
        };
    }
    
    @RequestMapping("/remover")
    public ModelAndView remover(Integer produtoId, TipoPreco tipoPreco){
        carrinho.remover(produtoId, tipoPreco);
        return new ModelAndView("redirect:/carrinho");
    }
    
}