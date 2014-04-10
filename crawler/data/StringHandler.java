package crawler.data;

public class StringHandler {
	public static String convertHtmlPattern(String str) {
		char[] input = str.toCharArray();
		StringBuilder sb = null;
		StringBuilder output = new StringBuilder();
		int tokenPos = 0;

		while (tokenPos < input.length) {
			sb = new StringBuilder();
			if (input[tokenPos] == '&') {
				tokenPos++;
				sb = new StringBuilder();
				while (tokenPos < input.length && input[tokenPos] != ';') {
					sb.append(input[tokenPos]);
					tokenPos++;
				}

				if (sb.toString().equals("Aacute"))
					output.append("Á");
				else if (sb.toString().equals("aacute"))
					output.append("á");
				else if (sb.toString().equals("Acirc"))
					output.append("Â");
				else if (sb.toString().equals("acirc"))
					output.append("â");
				else if (sb.toString().equals("Agrave"))
					output.append("À");
				else if (sb.toString().equals("agrave"))
					output.append("à");
				else if (sb.toString().equals("Aring"))
					output.append("Å");
				else if (sb.toString().equals("aring"))
					output.append("å");
				else if (sb.toString().equals("Atilde"))
					output.append("Ã");
				else if (sb.toString().equals("atilde"))
					output.append("ã");
				else if (sb.toString().equals("Auml"))
					output.append("Ä");
				else if (sb.toString().equals("auml"))
					output.append("ä");
				else if (sb.toString().equals("AElig"))
					output.append("Æ");
				else if (sb.toString().equals("aelig"))
					output.append("æ");
				else if (sb.toString().equals("Eacute"))
					output.append("É");
				else if (sb.toString().equals("eacute"))
					output.append("é");
				else if (sb.toString().equals("Ecirc"))
					output.append("ê");
				else if (sb.toString().equals("ecirc"))
					output.append("ê");
				else if (sb.toString().equals("Egrave"))
					output.append("È");
				else if (sb.toString().equals("egrave"))
					output.append("è");
				else if (sb.toString().equals("Euml"))
					output.append("Ë");
				else if (sb.toString().equals("euml"))
					output.append("ë");
				else if (sb.toString().equals("Etilde"))
					output.append("Ẽ");
				else if (sb.toString().equals("etilde"))
					output.append("ẽ");
				else if (sb.toString().equals("ETH"))
					output.append("Ð");
				else if (sb.toString().equals("eth"))
					output.append("ð");
				else if (sb.toString().equals("Iacute"))
					output.append("Í");
				else if (sb.toString().equals("iacute"))
					output.append("í");
				else if (sb.toString().equals("Icirc"))
					output.append("Î");
				else if (sb.toString().equals("icirc"))
					output.append("î");
				else if (sb.toString().equals("Igrave"))
					output.append("Ì");
				else if (sb.toString().equals("igrave"))
					output.append("ì");
				else if (sb.toString().equals("Iuml"))
					output.append("Ï");
				else if (sb.toString().equals("iuml"))
					output.append("ï");
				else if (sb.toString().equals("Itilde"))
					output.append("Ĩ");
				else if (sb.toString().equals("itilde"))
					output.append("ĩ");
				else if (sb.toString().equals("Oacute"))
					output.append("Ó");
				else if (sb.toString().equals("oacute"))
					output.append("ó");
				else if (sb.toString().equals("Ocirc"))
					output.append("Ô");
				else if (sb.toString().equals("ocirc"))
					output.append("ô");
				else if (sb.toString().equals("Ograve"))
					output.append("Ò");
				else if (sb.toString().equals("ograve"))
					output.append("ò");
				else if (sb.toString().equals("Oslash"))
					output.append("Ø");
				else if (sb.toString().equals("oslash"))
					output.append("ø");
				else if (sb.toString().equals("Otilde"))
					output.append("Õ");
				else if (sb.toString().equals("otilde"))
					output.append("õ");
				else if (sb.toString().equals("Ouml"))
					output.append("Ö");
				else if (sb.toString().equals("ouml"))
					output.append("ö");
				else if (sb.toString().equals("Uacute"))
					output.append("Ú");
				else if (sb.toString().equals("uacute"))
					output.append("ú");
				else if (sb.toString().equals("Ucirc"))
					output.append("û");
				else if (sb.toString().equals("ucirc"))
					output.append("û");
				else if (sb.toString().equals("Ugrave"))
					output.append("Ù");
				else if (sb.toString().equals("ugrave"))
					output.append("ù");
				else if (sb.toString().equals("Uuml"))
					output.append("Ü");
				else if (sb.toString().equals("uuml"))
					output.append("ü");
				else if (sb.toString().equals("Utilde"))
					output.append("Ũ");
				else if (sb.toString().equals("utilde"))
					output.append("ũ");
				else if (sb.toString().equals("Ccedil"))
					output.append("Ç");
				else if (sb.toString().equals("ccedil"))
					output.append("ç");
				else if (sb.toString().equals("Ntilde"))
					output.append("Ñ");
				else if (sb.toString().equals("ntilde"))
					output.append("Ñ");
				else if (sb.toString().equals("lt"))
					output.append("<");
				else if (sb.toString().equals("gt"))
					output.append(">");
				else if (sb.toString().equals("amp"))
					output.append("&");
				else if (sb.toString().equals("quot"))
					output.append("\"");
				else if (sb.toString().equals("reg"))
					output.append("®");
				else if (sb.toString().equals("copy"))
					output.append("©");
				else if (sb.toString().equals("Yacute"))
					output.append("Ý");
				else if (sb.toString().equals("yacute"))
					output.append("í");
				else if (sb.toString().equals("THORN"))
					output.append("Þ");
				else if (sb.toString().equals("thorn"))
					output.append("þ");
				else if (sb.toString().equals("szlig"))
					output.append("ß");
				else {
					output.append("&" + sb.toString() + ";"); // Non-converted
																// symbol
				}

			} else {
				output.append(input[tokenPos]);
			}

			tokenPos++;
		}
		return output.toString();
	}

}
