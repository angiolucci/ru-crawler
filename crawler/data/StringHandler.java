package crawler.data;

public class StringHandler {
	public static String convertHtmlPattern(String str){
		char[] input = str.toCharArray();
		StringBuilder sb = null;
		StringBuilder output = new StringBuilder();
		int tokenPos = 0;
		
		while (tokenPos < input.length){
			sb = new StringBuilder();
			if (input[tokenPos] == '&'){
				tokenPos++;
				sb = new StringBuilder();
				while (tokenPos < input.length && input[tokenPos] != ';'){
					sb.append(input[tokenPos]);
					tokenPos++;
				}

				// TODO: Melhorar, reescrever com switch/case
				if (sb.toString().equals("Aacute"))
					output.append("Á");
				if (sb.toString().equals("aacute"))
					output.append("á");
				if (sb.toString().equals("Acirc"))
					output.append("Â");
				if (sb.toString().equals("acirc"))
					output.append("â");
				if (sb.toString().equals("Agrave"))
					output.append("À");
				if (sb.toString().equals("agrave"))
					output.append("à");
				if (sb.toString().equals("Aring"))
					output.append("Å");
				if (sb.toString().equals("aring"))
					output.append("å");
				if (sb.toString().equals("Atilde"))
					output.append("Ã");
				if (sb.toString().equals("atilde"))
					output.append("ã");
				if (sb.toString().equals("Auml"))
					output.append("Ä");
				if (sb.toString().equals("auml"))
					output.append("ä");
				if (sb.toString().equals("AElig"))
					output.append("Æ");
				if (sb.toString().equals("aelig"))
					output.append("æ");
				if (sb.toString().equals("Eacute"))
					output.append("É");
				if (sb.toString().equals("eacute"))
					output.append("é");
				if (sb.toString().equals("Ecirc"))
					output.append("ê");
				if (sb.toString().equals("ecirc"))
					output.append("ê");
				if (sb.toString().equals("Egrave"))
					output.append("È");
				if (sb.toString().equals("egrave"))
					output.append("è");
				if (sb.toString().equals("Euml"))
					output.append("Ë");
				if (sb.toString().equals("euml"))
					output.append("ë");
				if (sb.toString().equals("Etilde"))
					output.append("Ẽ");
				if (sb.toString().equals("etilde"))
					output.append("ẽ");
				if (sb.toString().equals("ETH"))
					output.append("Ð");
				if (sb.toString().equals("eth"))
					output.append("ð");
				if (sb.toString().equals("Iacute"))
					output.append("Í");
				if (sb.toString().equals("iacute"))
					output.append("í");
				if (sb.toString().equals("Icirc"))
					output.append("Î");
				if (sb.toString().equals("icirc"))
					output.append("î");
				if (sb.toString().equals("Igrave"))
					output.append("Ì");
				if (sb.toString().equals("igrave"))
					output.append("ì");
				if (sb.toString().equals("Iuml"))
					output.append("Ï");
				if (sb.toString().equals("iuml"))
					output.append("ï");
				if (sb.toString().equals("Itilde"))
					output.append("Ĩ");
				if (sb.toString().equals("itilde"))
					output.append("ĩ");
				if (sb.toString().equals("Oacute"))
					output.append("Ó");
				if (sb.toString().equals("oacute"))
					output.append("ó");
				if (sb.toString().equals("Ocirc"))
					output.append("Ô");
				if (sb.toString().equals("ocirc"))
					output.append("ô");
				if (sb.toString().equals("Ograve"))
					output.append("Ò");
				if (sb.toString().equals("ograve"))
					output.append("ò");
				if (sb.toString().equals("Oslash"))
					output.append("Ø");
				if (sb.toString().equals("oslash"))
					output.append("ø");
				if (sb.toString().equals("Otilde"))
					output.append("Õ");
				if (sb.toString().equals("otilde"))
					output.append("õ");
				if (sb.toString().equals("Ouml"))
					output.append("Ö");
				if (sb.toString().equals("ouml"))
					output.append("ö");
				if (sb.toString().equals("Uacute"))
					output.append("Ú");
				if (sb.toString().equals("uacute"))
					output.append("ú");
				if (sb.toString().equals("Ucirc"))
					output.append("û");
				if (sb.toString().equals("ucirc"))
					output.append("û");
				if (sb.toString().equals("Ugrave"))
					output.append("Ù");
				if (sb.toString().equals("ugrave"))
					output.append("ù");
				if (sb.toString().equals("Uuml"))
					output.append("Ü");
				if (sb.toString().equals("uuml"))
					output.append("ü");
				if (sb.toString().equals("Utilde"))
					output.append("Ũ");
				if (sb.toString().equals("utilde"))
					output.append("ũ");				
				if (sb.toString().equals("Ccedil"))
					output.append("Ç");
				if (sb.toString().equals("ccedil"))
					output.append("ç");
				if (sb.toString().equals("Ntilde"))
					output.append("Ñ");
				if (sb.toString().equals("ntilde"))
					output.append("Ñ");
				if (sb.toString().equals("lt"))
					output.append("<");
				if (sb.toString().equals("gt"))
					output.append(">");
				if (sb.toString().equals("amp"))
					output.append("&");
				if (sb.toString().equals("quot"))
					output.append("\"");
				if (sb.toString().equals("reg"))
					output.append("®");
				if (sb.toString().equals("copy"))
					output.append("©");
				if (sb.toString().equals("Yacute"))
					output.append("Ý");
				if (sb.toString().equals("yacute"))
					output.append("í");
				if (sb.toString().equals("THORN"))
					output.append("Þ");
				if (sb.toString().equals("thorn"))
					output.append("þ");
				if (sb.toString().equals("szlig"))
					output.append("ß");
			} else{
				output.append(input[tokenPos]);
			}
			
			tokenPos++;
		}
		return output.toString();		
	}

}
