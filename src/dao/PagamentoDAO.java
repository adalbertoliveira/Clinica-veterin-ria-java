package dao;

import modelo.Pagamento;

public class PagamentoDAO implements Fidelidade {
	private int valor = 50;
	private int desconto = 10;
	private int porcentagem = 5;	
	public PagamentoDAO() {
	
	}

	public int vista( ) {
		return valor -(valor*porcentagem)/100;
	
	}
	public int parcelado( ) {
		
		return valor / 2;
	}

	

	@Override
	public int desconto() {
		return valor - (valor * desconto)/100;
		// TODO Auto-generated method stub
		
	}

}
