package modelo;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Limitenome extends PlainDocument {
	private int quantidadeMax;

	public Limitenome(int maxLen) {
		super();
		if (maxLen <= 0)
			throw new IllegalArgumentException("Especifique a quantidade");
		quantidadeMax = maxLen;
	}

	@Override
	public void insertString(int offset, String str, AttributeSet attr)
			throws BadLocationException {
		if (str == null || getLength() == quantidadeMax)
			return;
		int totalquantia = (getLength() + str.length());
		if (totalquantia <= quantidadeMax) {
			super.insertString(offset, str.replaceAll("[^a-z |^A-Z]", ""), attr);
			return;
		}
		String nova = str.substring(0, getLength() - quantidadeMax);
		super.insertString(offset, nova, attr);
	}


}
