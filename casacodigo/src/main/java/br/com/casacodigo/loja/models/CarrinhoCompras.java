package br.com.casacodigo.loja.models;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CarrinhoCompras {

	private Map<CarrinhoItem,Integer> itens= new LinkedHashMap<CarrinhoItem,Integer>();
	
	
	public void add(CarrinhoItem carrinhoItem) {
		itens.put(carrinhoItem,getQntidade(carrinhoItem)+1);		
	}
	
	private int getQntidade(CarrinhoItem item) {
		if(!itens.containsKey(item)) {
			itens.put(item, 0);
		}	
		return itens.get(item);
	}
	
	public int getQuantidade() {
		return itens.values().stream().reduce(0, (proximo,acumulador) -> proximo + acumulador);
	}
}
