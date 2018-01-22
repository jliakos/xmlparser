package parser;

import org.apache.commons.lang3.StringUtils;

public class StringXMLParser {

	public static final String DELIMITER = "//";


	private String getValue(String source,
	                        String whatTofind) {
		whatTofind = whatTofind + ">";
		if (StringUtils.isEmpty(source)) {
			return null;
		}
		int index = StringUtils.indexOf(source, whatTofind);
		if (index == -1) {
			return null;
		}
		index = index + whatTofind.length();
		StringBuilder sb = new StringBuilder();
		char v;
		do {
			v = source.charAt(index);
			if (v != '<') {
				sb.append(v);
			}

			index++;
		} while (v != '<');
		return sb.toString().trim();

	}


	public String parse(String source, String value) {
		if (StringUtils.isEmpty(source)) {
			return null;
		}

		try {

			final String[] split = StringUtils.split(value, DELIMITER);
			int index;
			String temp = source;
			String splitValue = "";
			for (String s : split) {
				index = StringUtils.indexOf(temp, s);
				if (index == -1) {
					return null;
				}
				temp = StringUtils.substring(temp, index);

				splitValue = s;
			}

			final String clean = clean(splitValue);
			return getValue(temp, clean);


		} catch (Exception e) {
			e.printStackTrace();
		}


		return null;

	}

	private String clean(String value) {

		return value.replaceAll("</", "").replaceAll(">/", "").replaceAll(">", "")
				.replaceAll("<", "");
	}


}
